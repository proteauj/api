package com.versatile.api.service;

import com.versatile.api.mapper.UserMapper;
import com.versatile.api.model.UserModel;
import com.versatile.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    @Autowired
    UserMapper mapper;

    public UserModel getByEmail(String email) {
        return mapper.entityToModel(repository.findByEmail(email));
    }
}
