package com.teachsync.services.locationUnit;

import com.teachsync.entities.LocationUnit;
import com.teachsync.repositories.LocationUnitRepository;
import com.teachsync.utils.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationUnitServiceImpl implements LocationUnitService {
    @Autowired
    private LocationUnitRepository locationUnitRepository;
    @Override
    public LocationUnit getById(Long id) throws Exception {
        return locationUnitRepository.findByIdAndStatusNot(id, Status.DELETED).orElse(null);
    }

    @Override
    public List<LocationUnit> getAllByParentId(Long parentId) throws Exception {
        List<LocationUnit> listLocationUnit = locationUnitRepository.findAllByParentIdAndStatusNot(parentId,Status.DELETED);
        if(listLocationUnit.isEmpty()){
            return null;
        }
        return listLocationUnit;
    }

}
