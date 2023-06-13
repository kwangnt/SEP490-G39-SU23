package com.teachsync.services.classroom;

import com.teachsync.dtos.classroom.ClassroomDto;
import com.teachsync.entities.Classroom;
import com.teachsync.entities.Course;
import com.teachsync.repositories.ClassroomRepository;
import com.teachsync.utils.MiscUtil;
import com.teachsync.utils.enums.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private MiscUtil miscUtil;

    @Autowired
    private ClassroomRepository classroomRepository;

    private Logger logger = LoggerFactory.getLogger(ClassroomServiceImpl.class);

    @Override
    public Page<ClassroomDto> getPageAll(Pageable paging) {

        if (paging == null) {
            paging = miscUtil.defaultPaging();
        }
        Page<Classroom> classroomPage = classroomRepository.findAllByStatusNot(Status.DELETED, paging);
        List<ClassroomDto> classroomDtoList = classroomPage.getContent().stream()
                .map(ClassroomDto::toClassroomDto)
                .collect(Collectors.toList());
        Page<ClassroomDto> classroomDtoPage = new PageImpl<>(classroomDtoList, paging, classroomPage.getTotalElements());
        ;

        if (classroomDtoPage.isEmpty()) {
            return null;
        }

        return classroomDtoPage;
    }

    @Override
    @Transactional
    public String addClassroom(ClassroomDto classroomDto) {
        try {
            Classroom classroom = new Classroom();
            classroom.setClassName(classroomDto.getClassName());
            classroom.setClassDesc(classroomDto.getClassDesc());
            classroom.setStatus(Status.CREATED);
            Course course = new Course();
            course.setId(classroomDto.getCourseId());
            classroom.setCourse(course);
            classroomRepository.save(classroom);
            return "success";
        } catch (Exception e) {
            logger.error("Error when addClassroom  : " + e.getMessage());
            return "error";
        }
    }

    @Override
    @Transactional
    public String editClassroom(ClassroomDto classroomDto) {
        try {
            Classroom classroom = classroomRepository.findById(classroomDto.getId()).orElse(null);
            if(ObjectUtils.isEmpty(classroom)){
                throw new Exception();
            }
            classroom.setClassName(classroomDto.getClassName());
            classroom.setClassDesc(classroomDto.getClassDesc());
            classroom.setStatus(Status.UPDATED);
            Course course = new Course();
            course.setId(classroomDto.getCourseId());
            classroom.setCourse(course);
            classroomRepository.save(classroom);
            return "success";
        } catch (Exception e) {
            logger.error("Error when EditClassRoom  : " + e.getMessage());
            return "error";
        }
    }

    @Override
    public String deleteClassroom(Long Id) {
        try{
            Classroom classroom = classroomRepository.findById(Id).orElseThrow(() -> new Exception("Không tìm thấy lớp học"));
            classroom.setStatus(Status.DELETED);
            classroomRepository.save(classroom);
            return "success";
        }catch (Exception e){
            logger.error("Error when deleteClassroom  : " + e.getMessage());
            return "error";
        }
    }

    @Override
    public ClassroomDto findById(Long Id) {
        return ClassroomDto.toClassroomDto(classroomRepository.findById(Id).orElse(new Classroom()));
    }
}
