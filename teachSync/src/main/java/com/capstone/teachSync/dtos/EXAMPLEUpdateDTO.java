package com.capstone.teachSync.dtos;

import com.capstone.teachSync.entities.EXAMPLE;
import com.capstone.teachSync.utils.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link EXAMPLE} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EXAMPLEUpdateDTO implements Serializable {
    private Long exampleId;
    private Long exampleFKId;
    private Long exampleLong;
    private Float exampleFloat;
    private Double exampleDouble;
    private String exampleString;
    private Status status;
}