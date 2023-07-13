package com.teachsync.services.role;

import com.teachsync.dtos.role.RoleReadDTO;
import com.teachsync.entities.Role;
import com.teachsync.utils.enums.DtoOption;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

public interface RoleService {
    /* =================================================== CREATE =================================================== */
    
    
    
    /* =================================================== READ ===================================================== */
    Role getById(Long id) throws Exception;
    RoleReadDTO getDTOById(Long id, Collection<DtoOption> options) throws Exception;



    /* =================================================== UPDATE =================================================== */
    
    
    
    /* =================================================== DELETE =================================================== */
    
    
    
    /* =================================================== WRAPPER ================================================== */
    RoleReadDTO wrapDTO(Role role, Collection<DtoOption> options) throws Exception;
    List<RoleReadDTO> wrapListDTO(Collection<Role> roleCollection, Collection<DtoOption> options) throws Exception;
    Page<RoleReadDTO> wrapPageDTO(Page<Role> rolePage, Collection<DtoOption> options) throws Exception;
}
