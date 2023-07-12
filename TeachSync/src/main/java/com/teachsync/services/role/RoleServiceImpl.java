package com.teachsync.services.role;

import com.teachsync.dtos.role.RoleReadDTO;
import com.teachsync.entities.Role;
import com.teachsync.repositories.RoleRepository;
import com.teachsync.utils.enums.DtoOption;
import com.teachsync.utils.enums.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper mapper;



    /* =================================================== CREATE =================================================== */



    /* =================================================== READ ===================================================== */
    @Override
    public Role getById(Long id) throws Exception {
        return roleRepository
                .findByIdAndStatusNot(id, Status.DELETED)
                .orElse(null);
    }
    @Override
    public RoleReadDTO getDTOById(Long id, Collection<DtoOption> options) throws Exception {
        Role role = getById(id);

        if (role == null) {
            return null;
        }

        return wrapDTO(role, options);
    }



    /* =================================================== UPDATE =================================================== */



    /* =================================================== DELETE =================================================== */



    /* =================================================== WRAPPER ================================================== */
    @Override
    public RoleReadDTO wrapDTO(Role role, Collection<DtoOption> options) throws Exception {
        RoleReadDTO dto = mapper.map(role, RoleReadDTO.class);

        /*if (options != null && !options.isEmpty()) {
            if (options.contains(DtoOption.FK)) {
                EXAMPLE
            }
        }*/

        return dto;
    }
    @Override
    public List<RoleReadDTO> wrapListDTO(Collection<Role> roleCollection, Collection<DtoOption> options) throws Exception {
        return null;
    }
    @Override
    public Page<RoleReadDTO> wrapPageDTO(Page<Role> rolePage, Collection<DtoOption> options) throws Exception {
        return null;
    }

}
