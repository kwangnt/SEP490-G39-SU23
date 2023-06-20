package com.teachsync.services.clazz;

import com.teachsync.dtos.clazz.ClazzReadDTO;
import com.teachsync.dtos.clazz.ClazzReadDTO;
import com.teachsync.dtos.course.CourseReadDTO;
import com.teachsync.dtos.priceLog.PriceLogReadDTO;
import com.teachsync.entities.Clazz;
import com.teachsync.entities.Clazz;
import com.teachsync.entities.CourseSchedule;
import com.teachsync.repositories.ClazzRepository;
import com.teachsync.repositories.CourseRepository;
import com.teachsync.repositories.CourseScheduleRepository;
import com.teachsync.utils.MiscUtil;
import com.teachsync.utils.enums.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzRepository clazzRepository;

    @Autowired
    private CourseScheduleRepository courseScheduleRepository;

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private MiscUtil miscUtil;

    /* =================================================== CREATE =================================================== */



    /* =================================================== READ ===================================================== */
    @Override
    public Page<Clazz> getPageAll(Pageable paging) throws Exception {
        if (paging == null) {
            paging = miscUtil.defaultPaging();
        }
        
        Page<Clazz> clazzPage =
                clazzRepository.findAllByStatusNot(Status.DELETED, paging);
        
        if (clazzPage.isEmpty()) {
            return null;
        }
        
        return clazzPage;
    }
    @Override
    public Page<ClazzReadDTO> getPageDTOAll(Pageable paging) throws Exception {
        Page<Clazz> clazzPage = getPageAll(paging);

        if (clazzPage == null) {
            return null;
        }
        
        return wrapPageDTO(clazzPage);
    }

    @Override
    public Clazz getById(Long id) throws Exception {
        Optional<Clazz> clazz = 
                clazzRepository.findByIdAndStatusNot(id, Status.DELETED);
        
        return clazz.orElse(null);
    }
    @Override
    public ClazzReadDTO getDTOById(Long id) throws Exception {
        Clazz clazz = getById(id);

        if (clazz == null) {
            return null;
        }

        return wrapDTO(clazz);
    }


    /* =================================================== UPDATE =================================================== */



    /* =================================================== DELETE =================================================== */



    /* =================================================== WRAPPER ================================================== */
    
    @Override
    public ClazzReadDTO wrapDTO(Clazz clazz) throws Exception {
        ClazzReadDTO dto = mapper.map(clazz, ClazzReadDTO.class);

        /* Add Dependency */
        /* TODO: replace with dto and call service */
        dto.setCourseSchedule(
                courseScheduleRepository
                        .findByIdAndStatusNot(clazz.getCourseScheduleId(), Status.DELETED)
                        .orElse(null));

//        dto.setSessionList();

        return dto;
    }

    @Override
    public List<ClazzReadDTO> wrapListDTO(Collection<Clazz> clazzCollection) throws Exception {
        List<ClazzReadDTO> dtoList = new ArrayList<>();
        ClazzReadDTO dto;

        /* TODO: replace with dto and call service */
        Set<Long> courseScheduleIdSet =
                clazzCollection.stream()
                        .map(Clazz::getCourseScheduleId)
                        .collect(Collectors.toSet());

        List<CourseSchedule> courseScheduleList =
                courseScheduleRepository.findAllByIdInAndStatusNot(courseScheduleIdSet, Status.DELETED);

        Map<Long, CourseSchedule> courseScheduleIdCourseScheduleMap = new HashMap<>();

        if (!courseScheduleList.isEmpty()) {
            courseScheduleIdCourseScheduleMap =
                    courseScheduleList.stream()
                            .collect(Collectors.toMap(CourseSchedule::getId, Function.identity()));
        }

        for (Clazz clazz : clazzCollection) {
            dto = mapper.map(clazz, ClazzReadDTO.class);

            /* Add Dependency */
            dto.setCourseSchedule(
                    courseScheduleIdCourseScheduleMap
                            .get(clazz.getCourseScheduleId()));

//            dto.setSessionList();

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public Page<ClazzReadDTO> wrapPageDTO(Page<Clazz> clazzPage) throws Exception {
        return new PageImpl<>(
                wrapListDTO(clazzPage.getContent()),
                clazzPage.getPageable(),
                clazzPage.getTotalPages());
    }
}
