package com.teachsync.services.classroom;

import com.teachsync.dtos.classroom.ClassroomDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ClassroomService {
    Page<ClassroomDto> getPageAll(Pageable paging) throws Exception;

    String addClassroom(ClassroomDto classroom);

    String editClassroom(ClassroomDto classroom);

    String deleteClassroom(Long Id);

    ClassroomDto findById(Long Id) throws Exception;
}
