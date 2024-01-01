package com.ternopil.service.serviceImpl;

import com.ternopil.DTO.UserDTO;
import com.ternopil.mappers.UserMapper;
import com.ternopil.models.User;
import com.ternopil.models.enums.RoleType;
import com.ternopil.repository.UserRepository;
import com.ternopil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(UserDTO user) {
        userRepository.save(UserMapper.INSTANCE.toModel(user));
    }


    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void remove(Long ID) {
        userRepository.deleteById(ID);
    }

    @Override
    public List<User> getAllUsersWithRole(RoleType roleType) {
        return userRepository.getUserByRoleType(roleType);
    }
}