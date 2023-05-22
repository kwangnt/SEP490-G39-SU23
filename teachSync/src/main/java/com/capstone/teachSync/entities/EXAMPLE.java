package com.capstone.teachSync.entities;

import com.capstone.teachSync.utils.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class EXAMPLE {
    @Id
    private Long exampleId;
    private Long exampleFKId;
    private Long exampleLong;
    private Float exampleFloat;
    private Double exampleDouble;
    private String exampleString;
    private Status status;
}
