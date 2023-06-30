package com.teachsync.services.clazzMember;

import com.teachsync.dtos.clazzMember.ClazzMemberReadDTO;
import com.teachsync.entities.ClazzMember;
import com.teachsync.utils.enums.DtoOption;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface ClazzMemberService {
    /* =================================================== CREATE =================================================== */
    

    /* =================================================== READ ===================================================== */
    /* clazzId */
    List<ClazzMember> getAllByClazzId(Long clazzId) throws Exception;
    List<ClazzMember> getAllStudentMemberByClazzId(Long clazzId) throws Exception;

    List<ClazzMember> getAllByClazzIdIn(Collection<Long> clazzIdCollection) throws Exception;
    List<ClazzMember> getAllStudentMemberByClazzIdIn(Collection<Long> clazzIdCollection) throws Exception;
    Map<Long, List<ClazzMember>> mapClazzIdClazzMemberListByClazzIdIn(
            Collection<Long> clazzIdCollection, DtoOption option) throws Exception;

    /* userId */
    List<ClazzMember> getAllByUserId(Long userId) throws Exception;

    List<ClazzMember> getAllByUserIdIn(Collection<Long> userIdCollection) throws Exception;


    /* =================================================== UPDATE =================================================== */

    
    /* =================================================== DELETE =================================================== */


    /* =================================================== WRAPPER ================================================== */
    ClazzMemberReadDTO wrapDTO(ClazzMember course) throws Exception;

    List<ClazzMemberReadDTO> wrapListDTO(Collection<ClazzMember> courseCollection) throws Exception;

    Page<ClazzMemberReadDTO> wrapPageDTO(Page<ClazzMember> coursePage) throws Exception;
}
