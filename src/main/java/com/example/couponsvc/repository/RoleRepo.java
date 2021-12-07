package com.example.couponsvc.repository;


import com.example.couponsvc.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role,Long> {
}
