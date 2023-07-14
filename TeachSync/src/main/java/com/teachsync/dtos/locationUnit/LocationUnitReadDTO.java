package com.teachsync.dtos.locationUnit;

import com.teachsync.dtos.BaseReadDTO;
import com.teachsync.utils.enums.LocationUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link com.teachsync.entities.LocationUnit}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationUnitReadDTO extends BaseReadDTO {
    private LocationUnitReadDTO parent;
    private Long parentId;
    private Integer level;
    private String unitName;
    private String unitAlias;
    private LocationUnitType unitType;
}