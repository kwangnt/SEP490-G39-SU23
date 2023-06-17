package com.teachsync.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "material")
public class Material extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId", referencedColumnName = "id")
    private Course course;
    @Positive
    @Column(name = "courseId", insertable = false, updatable = false)
    private Long courseId;

    @Lob
    @URL
    @NotBlank
    @Column(name = "materialLink", nullable = false)
    private String materialLink;
}
