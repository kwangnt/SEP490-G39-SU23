package com.teachsync.services.address;

import com.teachsync.dtos.address.AddressReadDTO;
import com.teachsync.entities.Address;
import com.teachsync.repositories.AddressRepository;
import com.teachsync.utils.enums.DtoOption;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper mapper;


    /* =================================================== CREATE =================================================== */


    /* =================================================== READ ===================================================== */


    /* =================================================== UPDATE =================================================== */


    /* =================================================== DELETE =================================================== */


    /* =================================================== WRAPPER ================================================== */
    @Override
    public AddressReadDTO wrapDTO(Address address, Collection<DtoOption> options) throws Exception {
        AddressReadDTO dto = mapper.map(address, AddressReadDTO.class);

        /* Add dependency */
        /* TODO:
        if (options != null && !options.isEmpty()) {
            if (options.contains(DtoOption.FK)) {
                FkReadDTO fkDTO = fkService.getDTOById(address.getFkId());
                dto.setFk(fkDTO);
            }

            if (options.contains(DtoOption.FK_LIST)) {
                List<FkReadDTO> fkDTOList = fkService.getAllDTOById(address.getFkId());
                dto.setFkList(fkDTOList);
            }
        }
        */

        return dto;
    }

    @Override
    public List<AddressReadDTO> wrapListDTO(Collection<Address> addressCollection, Collection<DtoOption> options) throws Exception {
        List<AddressReadDTO> dtoList = new ArrayList<>();
        AddressReadDTO dto;

        /* TODO:
        Map<Long, FkReadDTO> fkIdFkDTOMap = new HashMap<>();
        Map<Long, List<FkReadDTO>> fkIdFkDTOListMap = new HashMap<>();

        if (options != null && !options.isEmpty()) {
            Set<Long> fkIdSet = new HashSet<>();

            for (Address address : addressCollection) {
                fkIdSet.add(address.getFkId());
            }

            if (options.contains(DtoOption.FK)) {
                fkIdFkDTOMap = fkService.mapIdDTOByIdIn(fkIdSet);
            }

            if (options.contains(DtoOption.FK_LIST)) {
                fkIdFkDTOListMap = fkService.mapIdListDTOByIdIn(fkIdSet);
            }
        }
        */

        for (Address address : addressCollection) {
            dto = mapper.map(address, AddressReadDTO.class);

            /* Add dependency */
            /*
            dto.setFk(fkIdFkDTOMap.get(address.getFkId()));

            dto.setFkList(fkIdFkDTOListMap.get(address.getFkId()));
            */

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public Page<AddressReadDTO> wrapPageDTO(Page<Address> addressPage, Collection<DtoOption> options) throws Exception {
        return new PageImpl<>(
                wrapListDTO(addressPage.getContent(), options),
                addressPage.getPageable(),
                addressPage.getTotalPages());
    }
}
