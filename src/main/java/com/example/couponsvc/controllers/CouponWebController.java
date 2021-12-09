package com.example.couponsvc.controllers;


import com.example.couponsvc.entity.Coupon;
import com.example.couponsvc.repository.CouponRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/web")
public class CouponWebController {

    private final CouponRepo couponRepo;

    public CouponWebController(CouponRepo couponRepo) {
        this.couponRepo = couponRepo;
    }
//
//    @GetMapping("/")
//    public String index()
//    {
//           return "index";
//    }

    @GetMapping("/showcreatecoupon")
    public String showCreateCoupon()
    {
        return "createcoupon";
    }

    @PostMapping(value = "/save")
    public String saveCoupon( Coupon coupon)
    {
        couponRepo.save(coupon);
        return "couponresponse";
    }

    @GetMapping("/showcoupon")
    public String showGetCoupon()
    {
return "allcoupons";
    }

    @PostMapping("/getcoupon")
    public ModelAndView getCoupon(String code)
    {
        ModelAndView allcoupons = new ModelAndView("allcouponsresponse");
        allcoupons.addObject(couponRepo.findByCode(code));
        return allcoupons;
    }

}
