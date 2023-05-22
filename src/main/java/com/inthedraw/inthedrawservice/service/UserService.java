package com.inthedraw.inthedrawservice.service;

import com.inthedraw.inthedrawservice.entity.user.UserEntity;
import com.inthedraw.inthedrawservice.entity.wallet.WalletEntity;
import com.inthedraw.inthedrawservice.mapper.UserMapper;
import com.inthedraw.inthedrawservice.model.user.*;
import com.inthedraw.inthedrawservice.repository.user.UserRepository;
import com.inthedraw.inthedrawservice.repository.wallet.WalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.inthedraw.inthedrawservice.utils.DomainConstants.USER_ROLE_CUSTOMER;
import static com.inthedraw.inthedrawservice.utils.DomainConstants.USER_STATUS_ACTIVE;

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserRepository repository;

    @Autowired
    private WalletRepository walletRepository;

    public LoginResponse updateUser(Integer id, UpdateUserRequest request) {
        LoginResponse response = new LoginResponse();
        Optional<UserEntity> userToUpdate = repository.findById(Long.parseLong(id.toString()));
        if (userToUpdate.isPresent()) {
            if (null != request.getName()) {
                userToUpdate.get().setName(request.getName());
            }
            if (null != request.getSurname()) {
                userToUpdate.get().setSurname(request.getSurname());
            }
            if (null != request.getSize()) {
                userToUpdate.get().setSize(request.getSize());
            }
            if (null != request.getPhoto()) {
                userToUpdate.get().setPhoto(request.getPhoto());
            }
            if (null != request.getAddress()) {
                userToUpdate.get().setAddress(request.getAddress());
            }
            if (null != request.getCity()) {
                userToUpdate.get().setCity(request.getCity());
            }
            if (null != request.getCountry()) {
                userToUpdate.get().setCountry(request.getCountry());
            }
            if (null != request.getPostalCode()) {
                userToUpdate.get().setPostalCode(request.getPostalCode());
            }
            if (null != request.getDescription()) {
                userToUpdate.get().setDescription(request.getDescription());
            }

            repository.save(userToUpdate.get());
            Optional<UserEntity> userUpdated = repository.findById(Long.parseLong(id.toString()));
            userUpdated.ifPresent(userEntity -> response.setUserLogged(mapper.toDTO(userEntity)));
        }
        return response;
    }

    public void createMockUsers() {
        for (int i = 0; i < 300; i++) {
            CreateUserRequest newRequest = new CreateUserRequest();
            newRequest.setEmail(UUID.randomUUID().toString());
            newRequest.setName(UUID.randomUUID().toString());
            newRequest.setSurname(UUID.randomUUID().toString());
            newRequest.setPassword(UUID.randomUUID().toString());

            register(newRequest);
        }
    }

    public LoginResponse register(CreateUserRequest request) {
        LoginResponse response = new LoginResponse();

        try {
            // check if mail exists
            UserEntity alreadyEx = repository.findByEmail(request.getEmail());
            if (alreadyEx != null) {
                response.setError(true);
                response.setErrorMessage("Email already present in our system.");
            }

            UserEntity newUser = new UserEntity();
            newUser.setName(request.getName());
            newUser.setSurname(request.getSurname());
            newUser.setEmail(request.getEmail());
            newUser.setPassword(request.getPassword());
            newUser.setEntries(0);
            newUser.setSize(4);
            newUser.setEntriesWon(0);
            newUser.setRole(USER_ROLE_CUSTOMER);
            newUser.setStatus(USER_STATUS_ACTIVE);
            newUser = repository.save(newUser);
            logger.info("> user " + newUser.getId() + " created");

            WalletEntity newWallet = new WalletEntity();
            newWallet.setUserId(newUser.getId());
            newWallet.setBalance(0);
            walletRepository.save(newWallet);

            response.setUserLogged(mapper.toDTO(newUser));
        } catch (Exception e) {
            response.setError(true);
            response.setErrorMessage("Something fails during registration, please check the fields");
        }
        return response;
    }

    public LoginResponse login(LoginRequest request) {
        LoginResponse loginResponse = new LoginResponse();
        UserEntity entity = repository.findByEmailAndPassword(request.getEmail(), request.getPassword());
        if (null != entity) {
            logger.info("> user " + entity.getEmail() + " logged");
            loginResponse.setUserLogged(mapper.toDTO(entity));
        } else {
            loginResponse.setError(true);
            loginResponse.setErrorMessage("Wrong email or password.");
        }
        return loginResponse;
    }

    public UserDTO retrieveUser(Integer id) {
        logger.info("> retrieve user " + id.toString());
        UserDTO response = null;
        Optional<UserEntity> entity = repository.findById(Long.parseLong(id.toString()));
        if (entity.isPresent()) {
            response = mapper.toDTO(entity.get());
        }

        return response;
    }
}
