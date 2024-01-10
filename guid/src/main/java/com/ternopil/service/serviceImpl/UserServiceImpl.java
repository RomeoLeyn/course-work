package com.ternopil.service.serviceImpl;

import com.ternopil.DTO.UserDTO;
import com.ternopil.exeption.NotFoundException;
import com.ternopil.mappers.UserMapper;
import com.ternopil.models.User;
import com.ternopil.models.enums.RoleType;
import com.ternopil.repository.UserRepository;
import com.ternopil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@CacheConfig(cacheNames = "users")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.toModel(userDTO);
        userRepository.save(user);
    }

    @Override
    @Cacheable(key = "#id")
    public UserDTO findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(() -> new NotFoundException("Not found"));
        return UserMapper.INSTANCE.toDTO(user);
    }

    @Override
    @CacheEvict("users")
    public void remove(Long ID) {
        userRepository.deleteById(ID);
    }

    @Override
    @CachePut(cacheNames = "users",key = "#id")
    public void update(Long id, UserDTO userDTO) {
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.orElseThrow(() -> new NotFoundException("Not found user by id" + id));
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRoleType(userDTO.getRoleType());

        userRepository.save(user);
    }

    @Override
    @Cacheable(key = "#roleType")
    public List<UserDTO> getAllUsersWithRole(RoleType roleType, PageRequest pageRequest) {
        List<User> users = userRepository.getUserByRoleType(roleType, pageRequest).getContent();
        return users.stream().map(UserMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    @Cacheable(key = "#pageRequest")
    public List<UserDTO> getAll(PageRequest pageRequest) {
        List<User> users = userRepository.findAll(pageRequest).getContent();
        return users.stream().map(UserMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    @Cacheable(key = "#name")
    public List<UserDTO> getUserByName(String name, PageRequest pageRequest) {
        List<User> users = userRepository.getUserByFirstNameContainingIgnoreCase(name, pageRequest).getContent();
        return users.stream().map(UserMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }
}