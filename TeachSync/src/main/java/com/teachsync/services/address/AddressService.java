package com.teachsync.services.address;

import com.teachsync.dtos.address.AddressReadDTO;
import com.teachsync.entities.Address;
import com.teachsync.utils.enums.DtoOption;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

public interface AddressService {
    /* =================================================== CREATE =================================================== */


    /* =================================================== READ ===================================================== */


    /* =================================================== UPDATE =================================================== */


    /* =================================================== DELETE =================================================== */


    /* =================================================== WRAPPER ================================================== */
    AddressReadDTO wrapDTO(Address address, Collection<DtoOption> options) throws Exception;
    List<AddressReadDTO> wrapListDTO(Collection<Address> addressCollection, Collection<DtoOption> options) throws Exception;
    Page<AddressReadDTO> wrapPageDTO(Page<Address> addressPage, Collection<DtoOption> options) throws Exception;
}
