package com.teachsync.services.address;

import com.teachsync.dtos.address.AddressCreateDTO;
import com.teachsync.dtos.address.AddressReadDTO;
import com.teachsync.dtos.address.AddressUpdateDTO;
import com.teachsync.entities.Address;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface AddressService {

    Address createAddress(Address address) throws Exception;

    AddressReadDTO createAddressByDTO(AddressCreateDTO addressCreateDTO) throws Exception;


    Address updateAddress(Address address) throws Exception;

    AddressReadDTO updateAddressByDTO(AddressUpdateDTO addressUpdateDTO) throws Exception;

    Address getById(Long id) throws Exception;

    AddressReadDTO getDTOById(Long id) throws Exception;

    List<Address> getAllByIdIn(Collection<Long> idCollection) throws Exception;

    List<AddressReadDTO> getAllDTOByIdIn(Collection<Long> idCollection) throws Exception;

    Map<Long, Address> mapIdAddressByIdIn(Collection<Long> idCollection) throws Exception;

}
