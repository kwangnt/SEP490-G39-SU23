package com.capstone.teachSync.services;

import com.capstone.teachSync.dtos.EXAMPLECreateDTO;
import com.capstone.teachSync.dtos.EXAMPLEReadDTO;
import com.capstone.teachSync.dtos.EXAMPLEUpdateDTO;
import com.capstone.teachSync.entities.EXAMPLE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EXAMPLEService {
    /* =================================================== CREATE =================================================== */
    EXAMPLE createEXAMPLE(EXAMPLE example) throws Exception;
    EXAMPLEReadDTO createEXAMPLEByDTO(EXAMPLECreateDTO exampleDTO) throws Exception;

    List<EXAMPLE> createBulkEXAMPLE(Collection<EXAMPLE> exampleCollection) throws Exception;
    List<EXAMPLEReadDTO> createBulkEXAMPLEByDTO(Collection<EXAMPLECreateDTO> exampleDTOCollection) throws Exception;



    /* ==================================================== READ ==================================================== */
    Page<EXAMPLE> getPageAll(Pageable paging) throws Exception;
    List<EXAMPLEReadDTO> getAllDTO(Pageable paging) throws Exception;

    /* Id */
    EXAMPLE getById(long exampleId) throws Exception;
    EXAMPLEReadDTO getDTOById(long exampleId) throws Exception;

    List<EXAMPLE> getAllByIdIn(Collection<Long> exampleIdCollection) throws Exception;
    List<EXAMPLEReadDTO> getAllDTOByIdIn(Collection<Long> exampleIdCollection) throws Exception;

    /* fkId */
    EXAMPLE getByFKId(long fkId) throws Exception;
    EXAMPLEReadDTO getDTOByFKId(long fkId) throws Exception;

    List<EXAMPLE> getAllByFKId(long fkId) throws Exception;
    List<EXAMPLEReadDTO> getAllDTOByFKId(long fkId) throws Exception;

    List<EXAMPLE> getAllByFKIdIn(Collection<Long> fkIdCollection) throws Exception;
    List<EXAMPLEReadDTO> getAllDTOByFKIdIn(Collection<Long> fkIdCollection) throws Exception;

    Map<Long, EXAMPLEReadDTO> mapFkIdEXAMPLEDTOByFKIdIn(Collection<Long> fkIdCollection) throws Exception;
    Map<Long, List<EXAMPLEReadDTO>> mapFkIdEXAMPLEDTOListByFKIdIn(Collection<Long> fkIdCollection) throws Exception;



    /* =================================================== UPDATE =================================================== */
    EXAMPLE updateEXAMPLE(EXAMPLE example) throws Exception;
    EXAMPLEReadDTO updateEXAMPLEByDTO(EXAMPLEUpdateDTO exampleDTO) throws Exception;

    List<EXAMPLE> updateBulkEXAMPLE(Collection<EXAMPLE> exampleCollection) throws Exception;
    List<EXAMPLEReadDTO> updateBulkEXAMPLEByDTO(Collection<EXAMPLEUpdateDTO> exampleDTOCollection) throws Exception;



    /* =================================================== DELETE =================================================== */
    boolean deleteEXAMPLE(long exampleId) throws Exception;
    boolean deleteAllEXAMPLEByIdIn(Collection<Long> exampleIdCollection) throws Exception;

    /* fkId */
    boolean deleteByFKId(long fkId) throws Exception;
    boolean deleteAllByFKId(long fkId) throws Exception;
    boolean deleteAllByFKIdIn(Collection<Long> fkIdCollection) throws Exception;



    /* ==================================================== UTIL ==================================================== */
    /** Wrapper class for all getDTO... in @Service. Unifying return */
    EXAMPLEReadDTO dtoWrapperSingle(EXAMPLE example) throws Exception;
    /** Wrapper class for all getAllDTO... in @Service. Unifying return. */
    List<EXAMPLEReadDTO> dtoWrapperBulk(Collection<EXAMPLE> exampleCollection) throws Exception;
}
