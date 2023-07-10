package com.teachsync.dtos.material;

import com.teachsync.dtos.BaseReadDTO;
import com.teachsync.utils.enums.MaterialType;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialReadDTO extends BaseReadDTO {

    private String materialName;

    private String materialLink;

    private byte[] materialContent;

    private String materialImg;

    private MaterialType materialType;

    private Boolean isFree;
}
