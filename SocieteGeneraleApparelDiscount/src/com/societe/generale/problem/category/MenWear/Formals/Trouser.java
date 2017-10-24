package com.societe.generale.problem.category.MenWear.Formals;

import com.societe.generale.problem.Brand;
import com.societe.generale.problem.utils.DiscountCalculator;

/**
 * Trouser subcategory that extends "Formals" subcategory.
 */
public class Trouser extends Formals {

    private int discount;
    private String actualPrice;
    private Brand brand;
    private int finalDiscount;
    private float discountedPrice;

    public Trouser(Builder builder){
        this.discount = builder.discount;
        this.actualPrice = builder.actualPrice;
        this.brand = builder.brand;
    }

    @Override
    public Brand brand() {
        return null;
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
        return this.discountedPrice = DiscountCalculator.discPriceCalculator(this.actualPrice, finalDiscount);
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

        public Trouser build(){
            return new Trouser(this);
        }
    }
}