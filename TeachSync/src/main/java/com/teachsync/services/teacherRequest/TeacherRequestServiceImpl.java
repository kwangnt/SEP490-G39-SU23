package com.teachsync.services.teacherRequest;

import com.teachsync.dtos.classroom.ClassroomDto;
import com.teachsync.dtos.request.TeacherRequestDto;
import com.teachsync.entities.Classroom;
import com.teachsync.entities.Role;
import com.teachsync.entities.TeacherRequest;
import com.teachsync.entities.User;
import com.teachsync.repositories.TeacherRequestRepository;
import com.teachsync.repositories.UserRepository;
import com.teachsync.utils.Constants;
import com.teachsync.utils.MiscUtil;
import com.teachsync.utils.enums.Status;
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
public class TeacherRequestServiceImpl implements TeacherRequestService {

    @Autowired
    TeacherRequestRepository teacherRequestRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private MiscUtil miscUtil;

    @Override
    public Page<TeacherRequestDto> getPageAll(Pageable paging) throws Exception {
        if (paging == null) {
            paging = miscUtil.defaultPaging();
        }
        Page<TeacherRequest> teacherRequests = teacherRequestRepository.findAllByStatusNot(Status.DELETED, paging);
        List<TeacherRequestDto> teacherRequestDtoList = teacherRequests.getContent().stream()
                .map(TeacherRequestDto::toTeacherRequestDto)
                .collect(Collectors.toList());

        Page<TeacherRequestDto> classroomDtoPage = new PageImpl<>(teacherRequestDtoList, paging, teacherRequests.getTotalElements());

        if (classroomDtoPage.isEmpty()) {
            return null;
        }

        return classroomDtoPage;
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
        return TeacherRequestDto.toTeacherRequestDto(teacherRequestRepository.findById(Id).orElseThrow(() -> new Exception("không tìm thấy")));
    }

    @Transactional
    @Override
    public void changeStatus(Long Id, String operation) throws Exception {
        TeacherRequest teacherRequest = teacherRequestRepository.findById(Id).orElseThrow(() -> new Exception("không tìm thấy yêu cầu"));
        if (operation.equals("approve")) {
            User user = userRepository.findById(teacherRequest.getUser().getId()).orElseThrow(() -> new Exception("không tìm thấy tài khoản"));
            Role role = new Role();
            role.setId(Constants.ROLE_TEACHER);
            user.setRole(role);
             userRepository.save(user);
             //delete
            teacherRequest.setStatus(Status.DELETED);
            TeacherRequest teacher = teacherRequestRepository.save(teacherRequest);
            if(ObjectUtils.isEmpty(teacher)){
                throw new Exception("Lỗi khi xóa yêu cầu");
            }
        } else {
            teacherRequest.setStatus(Status.DELETED);
            TeacherRequest teacher = teacherRequestRepository.save(teacherRequest);
            if(ObjectUtils.isEmpty(teacher)){
                throw new Exception("Lỗi khi hủy yêu cầu");
            }
        }
    }
}
