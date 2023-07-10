package com.teachsync.services.user;

import com.teachsync.dtos.user.UserCreateDTO;
import com.teachsync.dtos.user.UserReadDTO;
import com.teachsync.dtos.user.UserUpdateDTO;
import com.teachsync.entities.Role;
import com.teachsync.entities.User;
import com.teachsync.repositories.UserRepository;
import com.teachsync.services.role.RoleService;
import com.teachsync.utils.Constants;
import com.teachsync.utils.enums.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ModelMapper mapper;


    /* =================================================== CREATE =================================================== */
    @Override
    public User createUser(User user) throws Exception {
        /* Check duplicate */
        boolean isExists =
                userRepository.existsByUsernameAndStatusNot(user.getUsername(), Status.DELETED);
        if (isExists) {
            throw new IllegalArgumentException("Đã tồn tại tài khoản : " + user.getUsername());
        }
        boolean isExistsEmail =
                userRepository.existsByEmailAndStatusNot(user.getEmail(), Status.DELETED);
        if (isExistsEmail) {
            throw new IllegalArgumentException("email đã có người đăng ký ");
        }

        /* Check FK */
        Role role = roleService.getById(user.getRoleId());
        if (role == null) {
            throw new Exception("Không có role hợp lệ : " + user.getRoleId());
        }
//        user.setRole(role);

        user = userRepository.saveAndFlush(user);

        return user;
    }

    @Override
    public UserReadDTO signupDTO(UserCreateDTO dto) throws Exception {
        dto.setRoleId(Constants.ROLE_STUDENT);

        User user = mapper.map(dto, User.class);

        if (dto.getParentEmail() != null) {
//            TODO: Create parent account
//            User parent = createUser(new User());
//            user.setParent(parent);
        }
        //process password BCryptPasswordEncoder
        String password = user.getPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        user.setPassword(hashedPassword);

        user = createUser(user);

        return wrapDTO(user);
    }


    /* =================================================== READ ===================================================== */
    @Override
    public User login(String username) throws Exception {
        Optional<User> user = userRepository.findByUsernameAndStatusNot(username, Status.DELETED);

        return user.orElse(null);
    }

    @Override
    public UserReadDTO loginDTO(String username, String password) throws Exception {
        User user = login(username);

        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("Không tìm thấy tài khoản với username: " + username);
        }

        //check password
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean isMatch = passwordEncoder.matches(password, user.getPassword());
        if (!isMatch) {
            /* Wrong password */
            throw new BadCredentialsException("Sai username hoặc password");
        }

        return wrapDTO(user);
    }

    @Override
    public List<User> getListUserByType(Long type) {
        System.out.println("type = " + type);
        List<User> x = userRepository.findAllByRoleId(type);
        System.out.println(x);
        return x;
    }

    @Override
    public List<User> getListUserByUserName(String username) {
        return userRepository.findAllByUsernameContaining(username);
    }

    @Override
    public User getById(Long id) throws Exception {
        Optional<User> user = userRepository.findByIdAndStatusNot(id, Status.DELETED);

        return user.orElse(null);
    }

    @Override
    public UserReadDTO getDTOById(Long id) throws Exception {
        User user = getById(id);

        if (user == null) {
            return null;
        }

        return wrapDTO(user);
    }

    @Override
    public User updateUser(User user) throws Exception {
        User oldUser = getById(user.getId());

        if (oldUser == null) {
            throw new IllegalArgumentException("No User found with Id: " + user.getId());
        }

        //Check valid input (Vd: email, phone)

        //Check FK
        Role role = roleService.getById(user.getRoleId());
        if (role == null) {
            throw new IllegalArgumentException("No role found with roleId: " + user.getRoleId());
        }
//        user.setRole(role);

        user.setUsername(oldUser.getUsername());
        user.setPassword(oldUser.getPassword());

        return userRepository.saveAndFlush(user);
    }

    @Override
    public UserReadDTO updateDTOUser(UserUpdateDTO dto) throws Exception {
        User user = mapper.map(dto, User.class);

        user = updateUser(user);

        return wrapDTO(user);
    }

    @Override
    public UserReadDTO activateTeacherAccount(Long unactivatedTeacherAccId) throws Exception {
        Optional<User> teacherOptional = userRepository.findByIdAndStatus(unactivatedTeacherAccId, Status.DELETED); /* TODO: different status */

        if (teacherOptional.isEmpty()) {
            throw new IllegalArgumentException(
                    "No unactivated teacher account found with id: " + unactivatedTeacherAccId);
        }

        User teacher = teacherOptional.get();
        teacher.setStatus(Status.UPDATED); /* TODO: different status */

        teacher = updateUser(teacher);

        return wrapDTO(teacher);
    }

    /* =================================================== UPDATE =================================================== */



    /* =================================================== DELETE =================================================== */


    /* =================================================== WRAPPER ================================================== */
    @Override
    public UserReadDTO wrapDTO(User user) throws Exception {
        UserReadDTO dto = mapper.map(user, UserReadDTO.class);

        /* Add Dependency */
//        dto.setRequestMadeList();
//        if (user.getRoleId() == parentRoleId) {
//            dto.setChildList();
//        }

        return dto;
    }

    @Override
    public List<UserReadDTO> wrapListDTO(Collection<User> userCollection) throws Exception {
        return null;
    }

    @Override
    public Page<UserReadDTO> wrapPageDTO(Page<User> userPage) throws Exception {
        return null;
    }


    /* =================================================== Forgot Password ========================================== */
    @Override
    public User getByResetPasswordToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }

    @Override
    public void updatePassword(User user, String newPassword) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(newPassword);
//        user.setPassword(encodedPassword);
        user.setPassword(newPassword);

        user.setResetPasswordToken(null);
        userRepository.saveAndFlush(user);
    }

    @Override
    public void updateResetPasswordToken(String token, String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setResetPasswordToken(token);

            /* Check data */
            userRepository.saveAndFlush(user);
        }
    }
}