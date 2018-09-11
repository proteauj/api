package com.versatile.api.service;

import com.versatile.api.entity.User;
import com.versatile.api.exception.UserAlreadyExistException;
import com.versatile.api.exception.UserNotFoundException;
import com.versatile.api.mapper.UserMapper;
import com.versatile.api.model.UserModel;
import com.versatile.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    @Autowired
    UserMapper mapper;

    public List<UserModel> getUsers() {
        return mapper.entitiesToModels(repository.findAll());
    }

    public UserModel getByEmail(String email) {
        return mapper.entityToModel(repository.findByEmail(email));
    }

    public UserModel getById(int id) throws UserNotFoundException {
        return mapper.entityToModel(repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id)));
    }

    public UserModel save(UserModel user) throws UserAlreadyExistException {
        User userWithSameEmail = repository.findByEmail(user.getEmail());
        if (userWithSameEmail != null) {
            throw new UserAlreadyExistException(userWithSameEmail.getEmail(), userWithSameEmail.getId());
        }

        User userEntity = mapper.modelToEntity(user);
        return mapper.entityToModel(repository.save(userEntity));
    }

    public UserModel updateUser(UserModel user, int id) {
        User newUser = mapper.modelToEntity(user);

        return repository.findById(id)
                .map(oldUser -> {
                    oldUser.setEmail(newUser.getEmail());
                    oldUser.setName(newUser.getName());
                    oldUser.setIdRole(newUser.getIdRole());
                    oldUser.setIdUserType(newUser.getIdUserType());
                    return mapper.entityToModel(repository.save(oldUser));
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return mapper.entityToModel(repository.save(newUser));
                });
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
