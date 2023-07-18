package com.teachsync.services.locationUnit;

import com.teachsync.entities.LocationUnit;

import java.util.List;

public interface LocationUnitService {

    LocationUnit getById(Long id) throws Exception;

    List<LocationUnit> getAllByParentId(Long parentId) throws Exception;

}
