package com.example.octans.repositories;

import java.util.ArrayList;

import com.example.octans.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserRepository extends CrudRepository<UserModel,Long> {
    @Query( value = "SELECT u.* FROM users u WHERE u.name like %?1%", nativeQuery = true)
    public ArrayList<UserModel>  findByName(String name);
}