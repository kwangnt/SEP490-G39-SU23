package com.capstone.teachSync.services;

import com.capstone.teachSync.repositories.EXAMPLERepository;
import com.capstone.teachSync.dtos.EXAMPLECreateDTO;
import com.capstone.teachSync.dtos.EXAMPLEReadDTO;
import com.capstone.teachSync.dtos.EXAMPLEUpdateDTO;
import com.capstone.teachSync.entities.EXAMPLE;
import com.capstone.teachSync.utils.enums.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.management.OperationsException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EXAMPLEServiceImpl implements EXAMPLEService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private EXAMPLERepository exampleRepository;



    /* =================================================== CREATE =================================================== */
    @Override
    public EXAMPLE createEXAMPLE(EXAMPLE example) throws Exception {
        /* Validate input */

        /* Check duplicate */

        /* Check FK */

        /* Create EXAMPLE */

        /* Create EXAMPLE's dependant */

        return null;
    }
    @Override
    public EXAMPLEReadDTO createEXAMPLEByDTO(EXAMPLECreateDTO exampleDTO) throws Exception {
        EXAMPLE example = mapper.map(exampleDTO, EXAMPLE.class);

        example = createEXAMPLE(example);

        return dtoWrapperSingle(example);
    }

    @Override
    public List<EXAMPLE> createBulkEXAMPLE(Collection<EXAMPLE> exampleCollection) throws Exception {
        return null;
    }
    @Override
    public List<EXAMPLEReadDTO> createBulkEXAMPLEByDTO(Collection<EXAMPLECreateDTO> exampleDTOCollection) throws Exception {
        return null;
    }



    /* ==================================================== READ ==================================================== */
    @Override
    public Page<EXAMPLE> getPageAll(Pageable paging) throws Exception {
        Page<EXAMPLE> examplePage = exampleRepository.findAllByStatusNot(Status.DELETED, paging);

        if (examplePage.isEmpty()) {
            return null; }

        return examplePage;
    }
    @Override
    public List<EXAMPLEReadDTO> getAllDTO(Pageable paging) throws Exception {
        Page<EXAMPLE> examplePage = getPageAll(paging);

        if (examplePage == null) {
            return null; }

        return dtoWrapperBulk(examplePage.getContent());
    }

    /* Id */
    @Override
    public EXAMPLE getById(long exampleId) throws Exception {
        return exampleRepository
                .findByExampleIdAndStatusNot(exampleId, Status.DELETED)
                .orElse(null);
    }
    @Override
    public EXAMPLEReadDTO getDTOById(long exampleId) throws Exception {
        EXAMPLE example = getById(exampleId);

        if (example == null) {
            return null; }

        return dtoWrapperSingle(example);
    }

    @Override
    public List<EXAMPLE> getAllByIdIn(Collection<Long> exampleIdCollection) throws Exception {
        List<EXAMPLE> exampleList =
                exampleRepository.findAllByExampleIdInAndStatusNot(exampleIdCollection, Status.DELETED);

        if (exampleList.isEmpty()) {
            return null; }

        return exampleList;
    }
    @Override
    public List<EXAMPLEReadDTO> getAllDTOByIdIn(Collection<Long> exampleIdCollection) throws Exception {
        List<EXAMPLE> exampleList = getAllByIdIn(exampleIdCollection);

        if (exampleList == null) {
            return null; }

        return dtoWrapperBulk(exampleList);
    }

    /* fkId */
    @Override
    public EXAMPLE getByFKId(long fkId) throws Exception {
        return exampleRepository
                .findByExampleFKIdAndStatusNot(fkId, Status.DELETED)
                .orElse(null);
    }
    @Override
    public EXAMPLEReadDTO getDTOByFKId(long fkId) throws Exception {
        EXAMPLE example = getByFKId(fkId);

        if (example == null) {
            return null; }

        return dtoWrapperSingle(example);
    }

    @Override
    public List<EXAMPLE> getAllByFKId(long fkId) throws Exception {
        List<EXAMPLE> exampleList =
                exampleRepository.findAllByExampleFKIdAndStatusNot(fkId, Status.DELETED);

        if (exampleList.isEmpty()) {
            return null; }

        return exampleList;
    }
    @Override
    public List<EXAMPLEReadDTO> getAllDTOByFKId(long fkId) throws Exception {
        List<EXAMPLE> exampleList = getAllByFKId(fkId);

        if (exampleList == null) {
            return null; }

        return dtoWrapperBulk(exampleList);
    }

    @Override
    public List<EXAMPLE> getAllByFKIdIn(Collection<Long> fkIdCollection) throws Exception {
        List<EXAMPLE> exampleList =
                exampleRepository.findAllByExampleFKIdInAndStatusNot(fkIdCollection, Status.DELETED);

        if (exampleList.isEmpty()) {
            return null; }

        return exampleList;
    }
    @Override
    public List<EXAMPLEReadDTO> getAllDTOByFKIdIn(Collection<Long> fkIdCollection) throws Exception {
        List<EXAMPLE> exampleList = getAllByFKIdIn(fkIdCollection);

        if (exampleList == null) {
            return null; }

        return dtoWrapperBulk(exampleList);
    }

    @Override
    public Map<Long, EXAMPLEReadDTO> mapFkIdEXAMPLEDTOByFKIdIn(Collection<Long> fkIdCollection) throws Exception {
        List<EXAMPLEReadDTO> exampleDTOList = getAllDTOByFKIdIn(fkIdCollection);

        if (exampleDTOList == null) {
            return new HashMap<>(); }

        Map<Long, EXAMPLEReadDTO> fkIdEXAMPLEDTOMap = new HashMap<>();
        EXAMPLEReadDTO tmpDTO;
        for (EXAMPLEReadDTO exampleDTO : exampleDTOList) {
            long fkId = exampleDTO.getExampleFKId();
            tmpDTO = fkIdEXAMPLEDTOMap.get(fkId);

            if (tmpDTO == null) {
                fkIdEXAMPLEDTOMap.put(fkId, exampleDTO);
            } else {
                throw new OperationsException(
                        "Wrong operation used. FK have 0.* relationship. Use mapFkIdEXAMPLEDTOListByFKIdIn() instead.");
            }
        }

        return fkIdEXAMPLEDTOMap;
    }
    @Override
    public Map<Long, List<EXAMPLEReadDTO>> mapFkIdEXAMPLEDTOListByFKIdIn(Collection<Long> fkIdCollection) throws Exception {
        List<EXAMPLEReadDTO> exampleDTOList = getAllDTOByFKIdIn(fkIdCollection);

        if (exampleDTOList == null) {
            return new HashMap<>(); }

        Map<Long, List<EXAMPLEReadDTO>> fkIdEXAMPLEDTOListMap = new HashMap<>();
        List<EXAMPLEReadDTO> tmpDTOList;
        for (EXAMPLEReadDTO exampleDTO : exampleDTOList) {
            long fkId = exampleDTO.getExampleFKId();
            tmpDTOList = fkIdEXAMPLEDTOListMap.get(fkId);

            if (tmpDTOList == null) {
                fkIdEXAMPLEDTOListMap.put(fkId, new ArrayList<>(Collections.singletonList(exampleDTO)));
            } else {
                tmpDTOList.add(exampleDTO);
                fkIdEXAMPLEDTOListMap.put(fkId, exampleDTOList);
            }
        }

        return fkIdEXAMPLEDTOListMap;
    }



    /* =================================================== UPDATE =================================================== */
    @Override
    public EXAMPLE updateEXAMPLE(EXAMPLE example) throws Exception {
        long exampleId = example.getExampleId();

        /* Exists by Id */

        /* Validate input */

        /* Check duplicate */

        /* Check FK */

        /* Update EXAMPLE */

        /* Create EXAMPLE's dependant */

        /* Update EXAMPLE's dependant */

        return null;
    }
    @Override
    public EXAMPLEReadDTO updateEXAMPLEByDTO(EXAMPLEUpdateDTO exampleDTO) throws Exception {
        EXAMPLE example = mapper.map(exampleDTO, EXAMPLE.class);

        example = updateEXAMPLE(example);

        return dtoWrapperSingle(example);
    }

    @Override
    public List<EXAMPLE> updateBulkEXAMPLE(Collection<EXAMPLE> exampleCollection) throws Exception {
        return null;
    }
    @Override
    public List<EXAMPLEReadDTO> updateBulkEXAMPLEByDTO(Collection<EXAMPLEUpdateDTO> exampleDTOCollection) throws Exception {
        return null;
    }



    /* =================================================== DELETE =================================================== */
    @Override
    public boolean deleteEXAMPLE(long exampleId) throws Exception {
        /* Exists by Id */

        /* Delete Item */

        /* Cascade delete dependant */

        return true;
    }
    @Override
    public boolean deleteAllEXAMPLEByIdIn(Collection<Long> exampleIdCollection) throws Exception {
        /* Exists by Ids */

        return deleteAll();
    }

    /* fkId */
    @Override
    public boolean deleteByFKId(long fkId) throws Exception {
        /* Exists by fkId */

        /* Delete Item */

        /* Cascade delete dependant */

        return true;
    }
    @Override
    public boolean deleteAllByFKId(long fkId) throws Exception {
        /* Exists by fkId */

        return deleteAll();
    }

    @Override
    public boolean deleteAllByFKIdIn(Collection<Long> fkIdCollection) throws Exception {
        /* Exists by fkIds */

        return deleteAll();
    }

    /** Unify deleteAllBy... to save on code */
    private boolean deleteAll() throws Exception {
        /* Delete all Item */

        /* Cascade delete dependant */

        return true;
    }


    /* ==================================================== UTIL ==================================================== */
    @Override
    public EXAMPLEReadDTO dtoWrapperSingle(EXAMPLE example) throws Exception {
        /* Map to DTO */
        EXAMPLEReadDTO dto = mapper.map(example, EXAMPLEReadDTO.class);

        /* Mapping FK */

        return dto;
    }
    @Override
    public List<EXAMPLEReadDTO> dtoWrapperBulk(Collection<EXAMPLE> exampleCollection) throws Exception {
        List<EXAMPLEReadDTO> dtoList = new ArrayList<>();

        EXAMPLEReadDTO dto;
        for (EXAMPLE example : exampleCollection) {
            /* Map to DTO */
            dto = mapper.map(example, EXAMPLEReadDTO.class);

            /* Mapping FK */

            dtoList.add(dto);
        }

        return dtoList;
    }
}
