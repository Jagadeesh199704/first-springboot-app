package com.example.bankingapp.repository;

import com.example.bankingapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM user WHERE name=?1", nativeQuery = true)
    User findByName(String userName);

    @Query(value = "SELECT * FROM user WHERE name=?2 AND id=?1", nativeQuery = true)
        User findByIdAndName(int id, String name);



}
