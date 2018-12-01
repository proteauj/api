package com.versatile.api.service;

import com.versatile.api.entity.Employee;
import com.versatile.api.entity.LogIn;
import com.versatile.api.exception.LogInNotFoundException;
import com.versatile.api.mapper.LogInMapper;
import com.versatile.api.mapper.UserMapper;
import com.versatile.api.repository.LogInRepository;
import com.versatile.api.ressource.LogInRessource;
import com.versatile.api.ressource.UserRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogInService {
    @Autowired
    LogInRepository repository;

    @Autowired
    LogInMapper mapper;

    @Autowired
    UserMapper mapperUser;

    public List<LogInRessource> getLogIns() {
        return mapper.entitiesToModels(repository.findAll());
    }

    public LogInRessource getLogInByUser(UserRessource user) {
        Employee userEntity = mapperUser.modelToEntity(user);
        return mapper.entityToModel(repository.findByUser(userEntity));
    }

    public LogInRessource getById(int id) throws LogInNotFoundException {
        return mapper.entityToModel(repository.findById(id)
                .orElseThrow(() -> new LogInNotFoundException(id)));
    }

    public LogInRessource save(LogInRessource logIn) {
        LogInRessource logInWithSameUser = getLogInByUser(logIn.getUser());
        if (logInWithSameUser != null) {
            return updateLogIn(logIn, logInWithSameUser.getId());
        }

        LogIn logInEntity = mapper.modelToEntity(logIn);
        return mapper.entityToModel(repository.save(logInEntity));
    }

    public LogInRessource updateLogIn(LogInRessource logIn, int id) {
        LogIn newLogIn = mapper.modelToEntity(logIn);

        return repository.findById(id)
                .map(oldLogIn -> {
                    oldLogIn.setPassword(newLogIn.getPassword());
                    oldLogIn.setNbFailedLogin(newLogIn.getNbFailedLogin());
                    oldLogIn.setUser(newLogIn.getUser());
                    return mapper.entityToModel(repository.save(oldLogIn));
                })
                .orElseGet(() -> {
                    return save(logIn);
                });
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
