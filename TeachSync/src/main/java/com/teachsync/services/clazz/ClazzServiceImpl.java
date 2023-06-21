package com.teachsync.services.clazz;

import com.teachsync.dtos.clazz.ClazzCreateDTO;
import com.teachsync.dtos.clazz.ClazzReadDTO;
import com.teachsync.dtos.clazz.ClazzUpdateDTO;
import com.teachsync.entities.Clazz;
import com.teachsync.entities.Course;
import com.teachsync.entities.CourseSchedule;
import com.teachsync.repositories.ClazzRepository;
import com.teachsync.repositories.CourseScheduleRepository;
import com.teachsync.utils.MiscUtil;
import com.teachsync.utils.enums.Status;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

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

    private Logger logger = LoggerFactory.getLogger(ClazzServiceImpl.class);



    /* =================================================== CREATE =================================================== */
    @Override
    @Transactional
    public String addClazz(ClazzCreateDTO createDTO) {
        try {
            Clazz clazz = mapper.map(createDTO, Clazz.class);
            clazz.setClazzSize(15); /* TODO: replace with dynamic */

            /* TODO: replace courseId with courseScheduleId (hoc ky cua khoa hoc) */
            Optional<CourseSchedule> schedule =
                    courseScheduleRepository
                            .findFirstByCourseIdAndStatusNotOrderByStartDateDesc(createDTO.getCourseId(), Status.DELETED);

            CourseSchedule courseSchedule = schedule.orElse(null);

            clazz.setCourseScheduleId(courseSchedule.getId());

            clazzRepository.saveAndFlush(clazz);

            return "success";
        } catch (Exception e) {
            logger.error("Error when addClazz  : " + e.getMessage());
            return "error";
        }
    }


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
    @Override
    @Transactional
    public String editClazz(ClazzUpdateDTO updateDTO) {
        try {
            Clazz clazz = clazzRepository.findById(updateDTO.getId()).orElse(null);

            if(ObjectUtils.isEmpty(clazz)){
                throw new Exception();
            }

            clazz = mapper.map(updateDTO, Clazz.class);
            clazz.setClazzSize(15); /* TODO: replace with dynamic */

            /* TODO: replace courseId with courseScheduleId (hoc ky cua khoa hoc) */
            Optional<CourseSchedule> schedule =
                    courseScheduleRepository
                            .findFirstByCourseIdAndStatusNotOrderByStartDateDesc(updateDTO.getCourseId(), Status.DELETED);

            CourseSchedule courseSchedule = schedule.orElse(null);

            clazz.setCourseScheduleId(courseSchedule.getId());

            clazzRepository.saveAndFlush(clazz);
            return "success";
        } catch (Exception e) {
            logger.error("Error when EditClazzRoom  : " + e.getMessage());
            return "error";
        }
    }


    /* =================================================== DELETE =================================================== */
    @Override
    public String deleteClazz(Long Id) {
        try{
            Clazz clazz = clazzRepository.findById(Id).orElseThrow(() -> new Exception("Không tìm thấy lớp học"));
            clazz.setStatus(Status.DELETED);
            clazzRepository.saveAndFlush(clazz);
            return "success";
        }catch (Exception e){
            logger.error("Error when deleteClazz  : " + e.getMessage());
            return "error";
        }
    }


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
