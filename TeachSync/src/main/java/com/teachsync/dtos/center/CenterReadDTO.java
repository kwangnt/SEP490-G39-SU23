package com.teachsync.dtos.center;

import com.teachsync.dtos.BaseReadDTO;
import com.teachsync.dtos.room.RoomReadDTO;
import com.teachsync.entities.Center;
import com.teachsync.entities.CenterStaff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.teachsync.entities.Center}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CenterReadDTO extends BaseReadDTO {
    private Long addressId;

    private String centerName;

    private String centerType;

    private String centerDesc;

    private Integer centerSize;

    private List<RoomReadDTO> roomList;
//    private List<CenterStaffReadDTO> staffList;
}