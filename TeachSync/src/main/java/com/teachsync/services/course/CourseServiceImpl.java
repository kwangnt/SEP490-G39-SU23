package com.teachsync.services.course;

import com.teachsync.entities.Course;
import com.teachsync.repositories.CourseRepository;
import com.teachsync.utils.MiscUtil;
import com.teachsync.utils.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private MiscUtil miscUtil;


    @Override
    public Page<Course> getPageAll(Pageable paging) throws Exception {
        if (paging == null) {
            paging = miscUtil.defaultPaging(); }

        Page<Course> coursePage =
                courseRepository.findAllByStatusNot(Status.DELETED, paging);

        if (coursePage.isEmpty()) {
            return null; }

        return coursePage;
    }

    @Override
    public Course getById(Long id) throws Exception {
        Optional<Course> course =
                courseRepository.findByIdAndStatusNot(id, Status.DELETED);

        return course.orElse(null);
    }
}
