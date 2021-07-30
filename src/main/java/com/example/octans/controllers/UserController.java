package com.example.octans.controllers;

import com.example.octans.models.UserModel;
import com.example.octans.services.UserService;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ArrayList<UserModel> allUsers(){
        return userService.allUsers();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @GetMapping( path = "/{id_user}" )
    public Optional<UserModel> getById(@PathVariable("id_user") Long id_user){
        return this.userService.getById(id_user);
    }

    @GetMapping( path = "/query" )
    public ArrayList<UserModel> getByName(@RequestParam("name") String name){
        return this.userService.getByName(name);
    }

    @DeleteMapping( path = "/{id_user}" )
    public String eliminarPorId(@PathVariable("id_user") Long id_user){
        boolean ok = this.userService.deleteUser(id_user);
        if (ok){
            return "Se eliminó el usuario correctamente ";
        }else{
            return "No se pudo eliminar el usuario";
        }
    }
    
}