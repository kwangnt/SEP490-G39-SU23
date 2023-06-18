package com.teachsync.services.teacherRequest;

import com.teachsync.dtos.classroom.ClassroomDto;
import com.teachsync.dtos.request.TeacherRequestDto;
import com.teachsync.entities.TeacherRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TeacherRequestService {
    Page<TeacherRequestDto> getPageAll(Pageable paging) throws Exception;

    String addTeacherRequest(TeacherRequestDto teacherRequestDto);

    String editTeacherRequest(TeacherRequestDto teacherRequestDto);

    String deleteTeacherRequest(Long Id);

    TeacherRequestDto findById(Long Id) throws Exception;
}
