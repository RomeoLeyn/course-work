package com.ternopil.services.serviceImpl;

import com.ternopil.DTO.UserAuthDTO;
import com.ternopil.DTO.UserDTO;
import com.ternopil.mappers.UserMapper;
import com.ternopil.models.AuthenticationResponse;
import com.ternopil.models.User;
import com.ternopil.models.enums.RoleType;
import com.ternopil.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(UserDTO request) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(request.getFirstName());
        userDTO.setLastName(request.getLastName());
        userDTO.setEmail(request.getEmail());
        userDTO.setPassword(passwordEncoder.encode(request.getPassword()));

        userDTO.setRoleType(userDTO.getRoleType());

        User user = UserMapper.INSTANCE.toModel(userDTO);
        user.setRoleType(RoleType.USER);
        userRepository.save(user);

        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse auth(User request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByFirstName(request.getFirstName()).orElseThrow();

        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token);
    }
}