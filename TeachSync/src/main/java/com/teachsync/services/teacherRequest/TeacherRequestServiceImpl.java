package com.teachsync.services.teacherRequest;

import com.teachsync.dtos.request.TeacherRequestDto;
import com.teachsync.entities.TeacherRequest;
import com.teachsync.entities.User;
import com.teachsync.repositories.TeacherRequestRepository;
import com.teachsync.utils.MiscUtil;
import com.teachsync.utils.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
public class TeacherRequestServiceImpl implements TeacherRequestService {

    @Autowired
    TeacherRequestRepository teacherRequestRepository;

    @Override
    public Page<TeacherRequestDto> getPageAll(Pageable paging) throws Exception {
        return null;
    }

    @Transactional
    @Override
    public String addTeacherRequest(TeacherRequestDto teacherRequestDto) {
        TeacherRequest teacherRequest = new TeacherRequest();
        teacherRequest.setUser(teacherRequestDto.getUser());
        teacherRequest.setRequestName("Request apply Teacher " + MiscUtil.generateRandomName());
        teacherRequest.setRequestType("APPLICATION");
        teacherRequest.setRequestDesc(teacherRequestDto.getRequestDesc());
        teacherRequest.setRequestContent(teacherRequestDto.getRequestContent());
        teacherRequest.setStatus(Status.CREATED);
        TeacherRequest teacherDb = teacherRequestRepository.save(teacherRequest);
        if (ObjectUtils.isEmpty(teacherDb)) {
            return "error";
        }

        return "success";
    }

    @Override
    public String editTeacherRequest(TeacherRequestDto teacherRequestDto) {
        return null;
    }

    @Override
    public String deleteTeacherRequest(Long Id) {
        return null;
    }

    @Override
    public TeacherRequestDto findById(Long Id) throws Exception {
        return null;
    }
}
