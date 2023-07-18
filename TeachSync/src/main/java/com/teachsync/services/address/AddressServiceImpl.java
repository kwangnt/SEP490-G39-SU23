package com.teachsync.services.address;

import com.teachsync.dtos.address.AddressCreateDTO;
import com.teachsync.dtos.address.AddressReadDTO;
import com.teachsync.dtos.address.AddressUpdateDTO;
import com.teachsync.entities.Address;
import com.teachsync.entities.BaseEntity;
import com.teachsync.entities.LocationUnit;
import com.teachsync.repositories.AddressRepository;
import com.teachsync.repositories.LocationUnitRepository;
import com.teachsync.utils.enums.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private LocationUnitRepository locationUnitRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Address createAddress(Address address) throws Exception {
        //TODO: Kiểm tra khóa ngoại, chính tả,..
        return addressRepository.saveAndFlush(address);
    }

    @Override
    public AddressReadDTO createAddressByDTO(AddressCreateDTO addressCreateDTO) throws Exception {
        Address address = modelMapper.map(addressCreateDTO, Address.class);
        ArrayList<LocationUnit> unitList = new ArrayList<>();
        LocationUnit locationUnit = locationUnitRepository.findByIdAndStatusNot(address.getUnitId(), Status.DELETED).orElse(null);
        while (locationUnit.getParentId() != null){
            unitList.add(locationUnit);
            locationUnit = locationUnitRepository.findByIdAndStatusNot(locationUnit.getParentId(), Status.DELETED).orElse(null);
        }
        StringBuilder addressString = new StringBuilder(address.getAddressNo() + " " + address.getStreet());

        for (LocationUnit unit: unitList
             ) {
            addressString.append(", ").append(unit.getUnitAlias());
        }

        address.setAddressString(addressString.toString());
        address = createAddress(address);
        return modelMapper.map(address, AddressReadDTO.class);
    }

    @Override
    public Address updateAddress(Address address) throws Exception {
        return null;
    }

    @Override
    public AddressReadDTO updateAddressByDTO(AddressUpdateDTO addressUpdateDTO) throws Exception {
        return null;
    }

    @Override
    public Address getById(Long id) throws Exception {
        return addressRepository.findByIdAndStatusNot(id, Status.DELETED).orElse(null);
    }

    @Override
    public AddressReadDTO getDTOById(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Address> getAllByIdIn(Collection<Long> idCollection) throws Exception {
        List<Address> addressesList = addressRepository.findAllByIdInAndStatusNot(idCollection,Status.DELETED);
        if(addressesList.isEmpty()){
            return null;
        }
        return addressesList;
    }

    @Override
    public List<AddressReadDTO> getAllDTOByIdIn(Collection<Long> idCollection) throws Exception {
        return null;
    }

    @Override
    public Map<Long, Address> mapIdAddressByIdIn(Collection<Long> idCollection) throws Exception {
        List<Address> addressList = getAllByIdIn(idCollection);
        if(addressList == null){
            return new HashMap<>();
        }
        return addressList.stream().collect(Collectors.toMap(BaseEntity::getId, Function.identity()));
    }
}
