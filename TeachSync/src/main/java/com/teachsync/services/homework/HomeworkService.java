package com.teachsync.services.homework;

import com.teachsync.dtos.homework.HomeworkReadDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HomeworkService {

    Page<HomeworkReadDTO> getPageAll(Pageable paging) throws Exception;

}
