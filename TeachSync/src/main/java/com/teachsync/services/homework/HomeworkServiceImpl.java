package com.teachsync.services.homework;

import com.teachsync.dtos.homework.HomeworkReadDTO;
import com.teachsync.dtos.request.RequestReadDTO;
import com.teachsync.entities.Clazz;
import com.teachsync.entities.Homework;
import com.teachsync.entities.Request;
import com.teachsync.entities.User;
import com.teachsync.repositories.ClazzRepository;
import com.teachsync.repositories.HomeworkRepository;
import com.teachsync.utils.MiscUtil;
import com.teachsync.utils.enums.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    @Autowired
    private MiscUtil miscUtil;

    @Autowired
    private HomeworkRepository homeworkRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    ClazzRepository clazzRepository;

    @Override
    public Page<HomeworkReadDTO> getPageAll(Pageable paging) throws Exception {
        if (paging == null) {
            paging = miscUtil.defaultPaging();
        }
        Page<Homework> homeworkPage = homeworkRepository.findAllByStatusNot(Status.DELETED, paging);

        List<HomeworkReadDTO> homeworkDtoList = new ArrayList<>();
        for (Homework homework : homeworkPage) {
            HomeworkReadDTO requestReadDTO = mapper.map(homework, HomeworkReadDTO.class);
            //get class
            Clazz clazz = clazzRepository.findById(requestReadDTO.getClazzId()).orElseThrow(() -> new Exception("không tìm lớp học"));
            requestReadDTO.setClazzName(clazz.getClazzName());

            homeworkDtoList.add(requestReadDTO);
        }

        Page<HomeworkReadDTO> homeworkReadDTOS = new PageImpl<>(homeworkDtoList, paging, homeworkPage.getTotalElements());

        if (homeworkReadDTOS.isEmpty()) {
            return new PageImpl<>(Collections.emptyList());
        }

        return homeworkReadDTOS;
    }
}
