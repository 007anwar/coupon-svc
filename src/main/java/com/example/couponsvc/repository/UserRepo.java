package com.example.couponsvc.repository;


import com.example.couponsvc.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {
    User findByEmail(String email);
}
