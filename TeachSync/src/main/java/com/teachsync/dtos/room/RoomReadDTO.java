package com.teachsync.dtos.room;

import com.teachsync.dtos.BaseReadDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.teachsync.entities.Room}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomReadDTO extends BaseReadDTO {
    private Long centerId;
    private String roomType;
    private String roomDesc;
    private String roomName;
    private Integer roomSize;
}