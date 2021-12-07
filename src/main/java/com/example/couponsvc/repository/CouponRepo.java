package com.example.couponsvc.repository;


import com.example.couponsvc.entity.Coupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepo extends CrudRepository<Coupon,Integer> {
    Coupon findByCode(String code);
}
