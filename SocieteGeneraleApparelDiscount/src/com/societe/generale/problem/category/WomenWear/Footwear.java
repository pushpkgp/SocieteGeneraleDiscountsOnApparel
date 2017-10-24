package com.societe.generale.problem.category.WomenWear;

import com.societe.generale.problem.Brand;
import com.societe.generale.problem.utils.DiscountCalculator;

/**
 * Foot wear subcategory that extends "WomenWear" category.
 */
public class Footwear extends WomenWear {

    private String actualPrice;
    private Brand brand;
    private int discount;
    private int finalDiscount;
    private float discountedPrice;

    public Footwear(Builder builder){
        this.discount = builder.discount;
        this.actualPrice = builder.actualPrice;
        this.brand = builder.brand;
    }

    @Override
    public Brand brand() {
        return this.brand;
    }

    @Override
    public int discount() {
        return this.finalDiscount = DiscountCalculator.finalDiscCalculator(this.discount, super.discount(), brand.brandDiscount());
    }

    @Override
    public String actualPrice() {
        return this.actualPrice;
    }

    @Override
    public float discountedPrice() {
        int finalDiscount = DiscountCalculator.finalDiscCalculator(this.discount, super.discount(), brand.brandDiscount());
        return this.discountedPrice = DiscountCalculator.discPriceCalculator(actualPrice, finalDiscount);
    }

    public static class Builder {
        private int discount;
        private String actualPrice;
        private Brand brand;

        public Builder brand(Brand brand) {
            this.brand = brand;
            return this;
        }

        public Builder discount(int discount) {
            this.discount = discount;
            return this;
        }

        public Builder actualPrice(String actualPrice) {
            this.actualPrice = actualPrice;
            return this;
        }

        public Footwear build(){
            return new Footwear(this);
        }
    }
}
