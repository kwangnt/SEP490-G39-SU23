package com.teachsync.services.course;

import com.teachsync.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {

    Page<Course> getPageAll(Pageable paging) throws Exception;

    Course getById(Long id) throws Exception;

}
