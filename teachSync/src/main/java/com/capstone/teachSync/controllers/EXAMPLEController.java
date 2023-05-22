package com.capstone.teachSync.controllers;

import com.capstone.teachSync.services.EXAMPLEService;
import com.capstone.teachSync.dtos.EXAMPLECreateDTO;
import com.capstone.teachSync.dtos.EXAMPLEReadDTO;
import com.capstone.teachSync.dtos.EXAMPLEUpdateDTO;
import com.capstone.teachSync.utils.MiscUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/example")
public class EXAMPLEController{
    @Autowired
    private EXAMPLEService exampleService;
    @Autowired
    private MiscUtil miscUtil;

    /* ================================================= VERSION 1 ================================================== */

    /* =================================================== CREATE =================================================== */
    @PostMapping(path = "/v1/create")
    public ResponseEntity<Object> createEXAMPLE(
            @RequestBody EXAMPLECreateDTO createDTO) {
        try {
            EXAMPLEReadDTO readDTO = exampleService.createEXAMPLEByDTO(createDTO);

            return ResponseEntity.ok().body(readDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }



    /* ==================================================== READ ==================================================== */
    @GetMapping(path = "/v1/getAll")
    public ResponseEntity<Object> getAllEXAMPLE(
            @RequestParam int pageNo,
            @RequestParam int pageSize,
            @RequestParam(required = false, defaultValue = "exampleId") String sortBy,
            @RequestParam boolean isAsc) {
        try {
            Pageable pageable = miscUtil.makePaging(pageNo, pageSize, sortBy, isAsc);

            List<EXAMPLEReadDTO> readDTOList = exampleService.getAllDTO(pageable);

            return ResponseEntity.ok().body(readDTOList);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping(path = "/v1/get/id")
    public ResponseEntity<Object> getEXAMPLEById(
            @RequestParam int exampleId) {
        try {
            EXAMPLEReadDTO readDTO = exampleService.getDTOById(exampleId);

            return ResponseEntity.ok().body(readDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping(path = "/v1/getAll/id")
    public ResponseEntity<Object> getAllEXAMPLEByIdIn(
            @RequestParam(name = "exampleIds", required = true) Collection<Long> exampleIdCollection) {
        try {
            List<EXAMPLEReadDTO> readDTOList = exampleService.getAllDTOByIdIn(exampleIdCollection);

            return ResponseEntity.ok().body(readDTOList);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }



    /* =================================================== UPDATE =================================================== */
    @PutMapping(path = "/v1/update")
    public ResponseEntity<Object> updateEXAMPLE(
            @RequestParam EXAMPLEUpdateDTO updateDTO) {
        try {
            EXAMPLEReadDTO readDTO = exampleService.updateEXAMPLEByDTO(updateDTO);

            return ResponseEntity.ok().body(readDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }



    /* =================================================== DELETE =================================================== */
    @DeleteMapping(path = "/v1/delete")
    public ResponseEntity<Object> deleteEXAMPLE(
            @RequestBody int exampleId) {
        try {
            boolean isDeleted = exampleService.deleteEXAMPLE(exampleId);

            if (isDeleted) {
                return ResponseEntity.ok().body("Successfully delete EXAMPLE with Id: " + exampleId);
            } else {
                return ResponseEntity.internalServerError().body("Error delete EXAMPLE with Id: " + exampleId);
            }
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    /* ================================================= VERSION 1 ================================================== */

}
