package com.teachsync.dtos.material;

import com.teachsync.dtos.BaseReadDTO;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialReadDTO extends BaseReadDTO {
    private Long courseId;

    private String materialName;

    private String materialLink;

    private byte[] materialContent;

    private String materialImg;
}
