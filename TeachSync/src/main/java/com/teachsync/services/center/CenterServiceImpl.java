package com.teachsync.services.center;

import com.teachsync.dtos.center.CenterReadDTO;
import com.teachsync.entities.BaseEntity;
import com.teachsync.entities.Center;
import com.teachsync.repositories.CenterRepository;
import com.teachsync.utils.enums.DtoOption;
import com.teachsync.utils.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CenterServiceImpl implements CenterService {
    @Autowired
    private CenterRepository centerRepository;


    /* =================================================== CREATE =================================================== */


    /* =================================================== READ ===================================================== */
    /* id */
    @Override
    public Center getById(Long id) throws Exception {
        return centerRepository
                .findByIdAndStatusNot(id, Status.DELETED)
                .orElse(null);
    }

    @Override
    public List<Center> getAllByIdIn(Collection<Long> idCollection) throws Exception {
        List<Center> centerList =
                centerRepository.findAllByIdInAndStatusNot(idCollection, Status.DELETED);

        if (centerList.isEmpty()) {
            return null; }

        return centerList;
    }
    @Override
    public Map<Long, String> mapCenterIdCenterNameByIdIn(Collection<Long> idCollection) throws Exception {
        List<Center> centerList = getAllByIdIn(idCollection);

        if (centerList.isEmpty()) {
            return null; }

        return centerList.stream()
                .collect(Collectors.toMap(BaseEntity::getId, Center::getCenterName));
    }


    /* =================================================== UPDATE =================================================== */


    /* =================================================== DELETE =================================================== */


    /* =================================================== WRAPPER ================================================== */
    @Override
    public CenterReadDTO wrapDTO(Center center, Collection<DtoOption> options) throws Exception {
        return null;
    }
    @Override
    public List<CenterReadDTO> wrapListDTO(Collection<Center> centerCollection, Collection<DtoOption> options) throws Exception {
        return null;
    }
    @Override
    public Page<CenterReadDTO> wrapPageDTO(Page<Center> centerPage, Collection<DtoOption> options) throws Exception {
        return null;
    }
}
