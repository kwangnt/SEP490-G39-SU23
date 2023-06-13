package com.teachsync.services.classroom;

import com.teachsync.dtos.classroom.ClassroomDto;
import com.teachsync.entities.Classroom;
import com.teachsync.entities.Course;
import com.teachsync.repositories.ClassroomRepository;
import com.teachsync.utils.MiscUtil;
import com.teachsync.utils.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private MiscUtil miscUtil;

    @Autowired
    private ClassroomRepository classroomRepository;

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
}
