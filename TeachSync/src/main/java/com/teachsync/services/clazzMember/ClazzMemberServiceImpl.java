package com.teachsync.services.clazzMember;

import com.teachsync.dtos.clazzMember.ClazzMemberReadDTO;
import com.teachsync.entities.ClazzMember;
import com.teachsync.repositories.ClazzMemberRepository;
import com.teachsync.utils.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClazzMemberServiceImpl implements ClazzMemberService {
    @Autowired
    private ClazzMemberRepository clazzMemberRepository;


    /* =================================================== CREATE =================================================== */


    /* =================================================== READ ===================================================== */
    /* clazzId */
    @Override
    public List<ClazzMember> getAllByClazzId(Long clazzId) throws Exception {
        List<ClazzMember> clazzMemberList =
                clazzMemberRepository.findAllByClazzIdAndStatusNot(clazzId, Status.DELETED);

        if (clazzMemberList.isEmpty()) {
            return null; }

        return clazzMemberList;
    }

    @Override
    public List<ClazzMember> getAllByClazzIdIn(Collection<Long> clazzIdCollection) throws Exception {
        List<ClazzMember> clazzMemberList =
                clazzMemberRepository.findAllByClazzIdInAndStatusNot(clazzIdCollection, Status.DELETED);

        if (clazzMemberList.isEmpty()) {
            return null; }

        return clazzMemberList;
    }
    /* TODO: replace with dto */
    @Override
    public Map<Long, List<ClazzMember>> mapClazzIdClazzMemberListByClazzIdIn(Collection<Long> clazzIdCollection) throws Exception {
        List<ClazzMember> clazzMemberList = getAllByClazzIdIn(clazzIdCollection);

        if (clazzMemberList == null) {
            return new HashMap<>(); }

        Map<Long, List<ClazzMember>> clazzIdMemberListMap = new HashMap<>();
        long clazzId;
        List<ClazzMember> tmpList;
        for (ClazzMember member : clazzMemberList) {
            clazzId = member.getClazzId();

            tmpList = clazzIdMemberListMap.get(clazzId);
            if (tmpList == null) {
                clazzIdMemberListMap.put(clazzId, new ArrayList<>(List.of(member)));
            } else {
                tmpList.add(member);
                clazzIdMemberListMap.put(clazzId, tmpList);
            }
        }

        return clazzIdMemberListMap;
    }

    /* userId */
    @Override
    public List<ClazzMember> getAllByUserId(Long userId) throws Exception {
        return null;
    }

    @Override
    public List<ClazzMember> getAllByUserIdIn(Collection<Long> userIdCollection) throws Exception {
        return null;
    }


    /* =================================================== UPDATE =================================================== */


    /* =================================================== DELETE =================================================== */


    /* =================================================== WRAPPER ================================================== */
    @Override
    public ClazzMemberReadDTO wrapDTO(ClazzMember course) throws Exception {
        return null;
    }

    @Override
    public List<ClazzMemberReadDTO> wrapListDTO(Collection<ClazzMember> courseCollection) throws Exception {
        return null;
    }

    @Override
    public Page<ClazzMemberReadDTO> wrapPageDTO(Page<ClazzMember> coursePage) throws Exception {
        return null;
    }
}
