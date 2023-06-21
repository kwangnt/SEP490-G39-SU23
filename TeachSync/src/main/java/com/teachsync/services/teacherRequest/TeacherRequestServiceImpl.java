package com.teachsync.services.teacherRequest;

import com.teachsync.dtos.request.*;
import com.teachsync.entities.Request;
import com.teachsync.repositories.RequestRepository;
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
    RequestRepository requestRepository;

    @Override
    public Page<RequestReadDTO> getPageAll(Pageable paging) throws Exception {
        return null;
    }

    @Transactional
    @Override
    public String addRequest(RequestCreateDTO createDTO) {
        Request teacherRequest = new Request();
        teacherRequest.setRequesterId(createDTO.getRequesterId());
        teacherRequest.setRequestName("Request apply Teacher " + MiscUtil.generateRandomName());
        teacherRequest.setRequestType("APPLICATION");
        teacherRequest.setRequestDesc(createDTO.getRequestDesc());
        teacherRequest.setRequestContent(createDTO.getRequestContent());
        teacherRequest.setContentLink(createDTO.getContentLink());
        teacherRequest.setStatus(Status.CREATED);

        Request teacherDb = requestRepository.saveAndFlush(teacherRequest);

        if (ObjectUtils.isEmpty(teacherDb)) {
            return "error";
        }

        return "success";
    }

    @Override
    public String editRequest(RequestUpdateDTO updateDTO) {
        return null;
    }

    @Override
    public String deleteRequest(Long Id) {
        return null;
    }

    @Override
    public RequestReadDTO findById(Long Id) throws Exception {
        return null;
    }
}
