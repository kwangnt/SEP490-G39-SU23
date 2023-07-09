package com.teachsync.services.clazz;

import com.teachsync.dtos.clazz.ClazzCreateDTO;
import com.teachsync.dtos.clazz.ClazzReadDTO;
import com.teachsync.dtos.clazz.ClazzUpdateDTO;
import com.teachsync.dtos.clazzSchedule.ClazzScheduleReadDTO;
import com.teachsync.dtos.courseSemester.CourseSemesterReadDTO;
import com.teachsync.entities.BaseEntity;
import com.teachsync.entities.Clazz;
import com.teachsync.entities.ClazzMember;
import com.teachsync.entities.CourseSemester;
import com.teachsync.repositories.ClazzRepository;
import com.teachsync.repositories.CourseSemesterRepository;
import com.teachsync.services.clazzMember.ClazzMemberService;
import com.teachsync.services.clazzSchedule.ClazzScheduleService;
import com.teachsync.services.courseSemester.CourseSemesterService;
import com.teachsync.utils.MiscUtil;
import com.teachsync.utils.enums.DtoOption;
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
import java.util.stream.Collectors;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzRepository clazzRepository;

    @Autowired
    private ClazzMemberService clazzMemberService;
    @Autowired
    private ClazzScheduleService clazzScheduleService;
    @Autowired
    private CourseSemesterService courseSemesterService;
    @Autowired
    private CourseSemesterRepository courseSemesterRepository;

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
            clazz.setClazzSize(15); /* TODO: replace with dynamic, not yet code on controller */

            /* TODO: replace courseId with courseSemesterId (hoc ky cua khoa hoc) */
            Optional<CourseSemester> schedule =
                    courseSemesterRepository
                            .findFirstByCourseIdAndStatusNot(createDTO.getCourseId(), Status.DELETED);

            CourseSemester courseSemester = schedule.orElse(null);

            clazz.setCourseSemesterId(courseSemester.getId());

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
        
        return wrapPageDTO(clazzPage, null);
    }

    /* id */
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

        return wrapDTO(clazz, null);
    }

    @Override
    public List<Clazz> getAllByIdIn(
            Collection<Long> idCollection) throws Exception {
        List<Clazz> clazzList =
                clazzRepository.findAllByIdInAndStatusNot(idCollection, Status.DELETED);

        if (clazzList.isEmpty()) {
            return null;
        }

        return clazzList;
    }
    @Override
    public Map<Long, String> mapClazzIdClazzNameByIdIn(Collection<Long> idCollection) throws Exception {
        List<Clazz> roomList = getAllByIdIn(idCollection);

        if (roomList.isEmpty()) {
            return null; }

        return roomList.stream()
                .collect(Collectors.toMap(BaseEntity::getId, Clazz::getClazzName));
    }

    /* courseSemesterId */
    @Override
    public List<Clazz> getAllByCourseSemesterIdIn(
            Collection<Long> scheduleIdCollection) throws Exception {
        List<Clazz> clazzList =
                clazzRepository.findAllByCourseSemesterIdInAndStatusNot(scheduleIdCollection, Status.DELETED);

        if (clazzList.isEmpty()) {
            return null;
        }

        return clazzList;
    }
    @Override
    public List<ClazzReadDTO> getAllDTOByCourseSemesterIdIn(
            Collection<Long> scheduleIdCollection, Collection<DtoOption> options) throws Exception {
        List<Clazz> clazzList = getAllByCourseSemesterIdIn(scheduleIdCollection);

        if (clazzList == null) {
            return null;
        }

        return wrapListDTO(clazzList, options);
    }
    @Override
    public Map<Long, List<ClazzReadDTO>> mapScheduleIdClazzDTOListByCourseSemesterIdIn(
            Collection<Long> scheduleIdCollection, Collection<DtoOption> options) throws Exception {
        List<ClazzReadDTO> clazzDTOList = getAllDTOByCourseSemesterIdIn(scheduleIdCollection, options);

        if (clazzDTOList == null) {
            return new HashMap<>(); }

        Map<Long, List<ClazzReadDTO>> scheduleIdClazzDTOListMap = new HashMap<>();
        long scheduleId;
        List<ClazzReadDTO> tmpList;
        for (ClazzReadDTO dto : clazzDTOList) {
            scheduleId = dto.getCourseSemesterId();

            tmpList = scheduleIdClazzDTOListMap.get(scheduleId);
            if (tmpList == null) {
                scheduleIdClazzDTOListMap.put(scheduleId, new ArrayList<>(Collections.singletonList(dto)));
            } else {
                tmpList.add(dto);
                scheduleIdClazzDTOListMap.put(scheduleId, tmpList);
            }
        }

        return scheduleIdClazzDTOListMap;
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

            /* TODO: replace courseId with courseSemesterId (hoc ky cua khoa hoc) */
            Optional<CourseSemester> schedule =
                    courseSemesterRepository
                            .findFirstByCourseIdAndStatusNot(updateDTO.getCourseId(), Status.DELETED);

            CourseSemester courseSemester = schedule.orElse(null);

            clazz.setCourseSemesterId(courseSemester.getId());

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
    public ClazzReadDTO wrapDTO(Clazz clazz, Collection<DtoOption> options) throws Exception {
        ClazzReadDTO dto = mapper.map(clazz, ClazzReadDTO.class);

        /* Add Dependency */
        if (options != null && !options.isEmpty()) {
            if (options.contains(DtoOption.COURSE_SCHEDULE)) {
                dto.setCourseSemester(
                        courseSemesterService.getDTOById(clazz.getCourseSemesterId(), options));
            }

            if (options.contains(DtoOption.CLAZZ_SCHEDULE)) {
                dto.setClazzSchedule(
                        clazzScheduleService.getDTOByClazzId(clazz.getId(), options));
            }

            if (options.contains(DtoOption.SESSION_LIST)) {
//            TODO: dto.setSessionList();
            }

            if (options.contains(DtoOption.MEMBER_LIST)) {
                dto.setMemberList(
                        clazzMemberService.getAllByClazzId(clazz.getId()));
            }

            if (options.contains(DtoOption.HOMEWORK_LIST)) {
//            TODO: dto.setHomeworkList();
            }

            if (options.contains(DtoOption.TEST_LIST)) {
//            TODO: dto.setTestList();
            }
        }

        return dto;
    }
    @Override
    public List<ClazzReadDTO> wrapListDTO(Collection<Clazz> clazzCollection, Collection<DtoOption> options) throws Exception {
        List<ClazzReadDTO> dtoList = new ArrayList<>();

        ClazzReadDTO dto;

        Map<Long, CourseSemesterReadDTO> scheduleIdCourseSemesterMap = new HashMap<>();
        Map<Long, ClazzScheduleReadDTO> clazzIdClazzScheduleMap = new HashMap<>();
//      TODO: Map<Long, List<SessionReadDTO>> clazzIdSessionListMap = new HashMap<>();
        Map<Long, List<ClazzMember>> clazzIdClazzMemberListMap = new HashMap<>();
//      TODO: Map<Long, List<HomeworkReadDTO>> clazzIdHomeworkListMap = new HashMap<>();
//      TODO: Map<Long, List<ClazzTestReadDTO>> clazzIdClazzTestListMap = new HashMap<>();

        if (options != null && !options.isEmpty()) {
            Set<Long> clazzIdSet = new HashSet<>();
            Set<Long> scheduleIdSet = new HashSet<>();

            for (Clazz clazz : clazzCollection) {
                clazzIdSet.add(clazz.getId());
                scheduleIdSet.add(clazz.getCourseSemesterId());
            }
            if (options.contains(DtoOption.COURSE_SCHEDULE)) {
                scheduleIdCourseSemesterMap =
                        courseSemesterService.mapIdDTOByIdIn(scheduleIdSet, options);
            }

            if (options.contains(DtoOption.CLAZZ_SCHEDULE)) {
                clazzIdClazzScheduleMap =
                        clazzScheduleService.mapClazzIdDTOByClazzIdIn(clazzIdSet, options);
            }

            if (options.contains(DtoOption.SESSION_LIST)) {
                //TODO:
            }

            if (options.contains(DtoOption.MEMBER_LIST)) {
                clazzIdClazzMemberListMap =
                        clazzMemberService.mapClazzIdClazzMemberListByClazzIdIn(clazzIdSet);
            }

            if (options.contains(DtoOption.HOMEWORK_LIST)) {
                //TODO:
            }

            if (options.contains(DtoOption.TEST_LIST)) {
                //TODO:
            }
        }

        for (Clazz clazz : clazzCollection) {
            dto = mapper.map(clazz, ClazzReadDTO.class);

            /* Add Dependency */
            dto.setCourseSemester(
                    scheduleIdCourseSemesterMap.get(clazz.getCourseSemesterId()));

            dto.setClazzSchedule(
                    clazzIdClazzScheduleMap.get(clazz.getId()));

//            TODO: dto.setSessionList();

            dto.setMemberList(
                    clazzIdClazzMemberListMap.get(clazz.getId()));

//            TODO: dto.setHomeworkList();

//            TODO: dto.setTestList();

            dtoList.add(dto);
        }

        return dtoList;
    }
    @Override
    public Page<ClazzReadDTO> wrapPageDTO(Page<Clazz> clazzPage, Collection<DtoOption> options) throws Exception {
        return new PageImpl<>(
                wrapListDTO(clazzPage.getContent(), options),
                clazzPage.getPageable(),
                clazzPage.getTotalPages());
    }
}
