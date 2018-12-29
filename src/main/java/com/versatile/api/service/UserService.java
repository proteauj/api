package com.versatile.api.service;

import com.versatile.api.entity.Employee;
import com.versatile.api.entity.UserRole;
import com.versatile.api.exception.UserAlreadyExistException;
import com.versatile.api.exception.UserNotFoundException;
import com.versatile.api.exception.UserRoleNotFoundException;
import com.versatile.api.mapper.UserMapper;
import com.versatile.api.mapper.UserRoleMapper;
import com.versatile.api.mapper.UserTypeMapper;
import com.versatile.api.repository.UserRoleRepository;
import com.versatile.api.repository.UserTypeRepository;
import com.versatile.api.ressource.UserRessource;
import com.versatile.api.repository.UserRepository;
import com.versatile.api.ressource.UserRoleRessource;
import com.versatile.api.ressource.UserTypeRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    @Autowired
    UserMapper mapper;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    UserTypeRepository userTypeRepository;

    @Autowired
    UserTypeMapper userTypeMapper;

    public List<UserRessource> getUsers() {
        return mapper.entitiesToModels(repository.findAll());
    }

    public UserRessource getByEmail(String email) {
        return mapper.entityToModel(repository.findByEmail(email));
    }

    public UserRessource getById(int id) throws UserNotFoundException {
        return mapper.entityToModel(repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id)));
    }

    public UserRessource save(UserRessource user) throws UserAlreadyExistException {
        Employee userWithSameEmail = repository.findByEmail(user.getEmail());
        if (userWithSameEmail != null) {
            throw new UserAlreadyExistException(userWithSameEmail.getEmail(), userWithSameEmail.getIdUser());
        }

        Employee userEntity = mapper.modelToEntity(user);

        return mapper.entityToModel(repository.save(userEntity));
    }

    public UserRessource updateUser(UserRessource user, int id) {
        Employee newUser = mapper.modelToEntity(user);

        return repository.findById(id)
                .map(oldUser -> {
                    oldUser.setEmail(newUser.getEmail());
                    oldUser.setName(newUser.getName());
                    oldUser.setType(newUser.getType());
                    oldUser.setImage(newUser.getImage());
                    oldUser.setRoles(newUser.getRoles());
                    return mapper.entityToModel(repository.save(oldUser));
                })
                .orElseGet(() -> {
                    newUser.setIdUser(id);
                    return mapper.entityToModel(repository.save(newUser));
                });
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public List<UserTypeRessource> getUserTypes() {
        return userTypeMapper.entitiesToModels(userTypeRepository.findAll());
    }

    public UserTypeRessource getUserTypeByDescription(String description) {
        return userTypeMapper.entityToModel(userTypeRepository.findByDescription(description));
    }

    public List<UserRoleRessource> getUserRoles() {
        return userRoleMapper.entitiesToModels(userRoleRepository.findAll());
    }

    public UserRoleRessource getUserRoleByDescription(String description) {
        return userRoleMapper.entityToModel(userRoleRepository.findByDescription(description));
    }

    public List<UserRessource> getUsersByRole(int idRole) {
        Optional<UserRole> role = userRoleRepository.findById(idRole);
        List<UserRessource> users = new ArrayList<>();

        if (role.isPresent()) {
            //users = mapper.entitiesToModels(repository.findByRole(role.get()));
        }

        return users;
    }

    public UserRoleRessource getRoleById(int id) throws UserRoleNotFoundException {
        return userRoleMapper.entityToModel(userRoleRepository.findById(id)
                .orElseThrow(() -> new UserRoleNotFoundException(id)));
    }
}
