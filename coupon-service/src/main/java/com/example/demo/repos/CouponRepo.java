package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Coupon;

@Repository
public interface CouponRepo extends JpaRepository<Coupon, Long> {

    public Coupon findByCode(String code);

}