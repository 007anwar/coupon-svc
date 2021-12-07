package com.example.couponsvc.controllers;

import com.example.couponsvc.entity.Coupon;
import com.example.couponsvc.repository.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CouponController {

    private final CouponRepo couponRepo;

    @Autowired
    public CouponController(CouponRepo couponRepo) {
        this.couponRepo = couponRepo;
    }

    @PostMapping(value = "/coupon")
    public Coupon createCoupon(@RequestBody Coupon coupon)
       {
       return couponRepo.save(coupon);
          }

          @GetMapping(value = "/coupon/{code}")
          public Coupon getCoupon(@PathVariable("code") String code)
          {
        return couponRepo.findByCode(code);
          }

}
