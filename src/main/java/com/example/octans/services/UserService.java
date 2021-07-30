package com.example.octans.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.octans.models.UserModel;
import com.example.octans.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> allUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser( UserModel user ){
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id_user){
        return userRepository.findById(id_user);
    }

    public ArrayList<UserModel> getByName(String name){
        if(name != null){
            return userRepository.findByName(name);
        }
        return this.allUsers();
    }

    public boolean deleteUser(Long id_user){
        try {
            userRepository.deleteById(id_user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
 

}