package com.societe.generale.problem;

import com.societe.generale.problem.category.Category;
import com.societe.generale.problem.category.MenWear.Casuals.Jean;
import com.societe.generale.problem.category.MenWear.Formals.Shirt;
import com.societe.generale.problem.category.MenWear.Formals.Trouser;
import com.societe.generale.problem.category.WomenWear.Dress;
import com.societe.generale.problem.category.WomenWear.Footwear;
import com.societe.generale.problem.utils.AppConstants;

/**
 * 1. This class is responsible for building products.
 * 2. Builder pattern is used to build products.
 */
public class ProductBuilder {

    private String serialNumber;
    private Brand brand;
    private Category category;
    private String initialPrice;

    public ProductBuilder(Builder builder){
        this.serialNumber = builder.serialNumber;
        this.brand = builder.brand;
        this.category = builder.category;
        this.initialPrice = builder.actualPrice;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public Brand getBrand() {
        return this.brand;
    }

    public Category getCategory() {
        return this.category;
    }

    public String getInitialPrice() {
        return this.initialPrice;
    }

    public static class Builder {
        private String serialNumber;
        private Brand brand;
        private Category category;
        private String actualPrice;

        public Builder serialNumber(String serialNumber){
            this.serialNumber = serialNumber;
            return this;
        }

        public Builder brand(String brandName){
            switch (brandName){
                case AppConstants.ADIDAS:
                    this.brand = new Brand.Builder().brandName(AppConstants.ADIDAS)
                            .brandDiscount(AppConstants.ADIDAS_DISC).build();
                    break;
                case AppConstants.ARROW:
                    this.brand = new Brand.Builder().brandName(AppConstants.ARROW)
                            .brandDiscount(AppConstants.ARROW_DISC).build();
                    break;
                case AppConstants.PROVOGUE:
                    this.brand = new Brand.Builder().brandName(AppConstants.PROVOGUE)
                            .brandDiscount(AppConstants.PROVOGUE_DISC).build();
                    break;
                case AppConstants.UCB:
                    this.brand = new Brand.Builder().brandName(AppConstants.UCB)
                            .brandDiscount(AppConstants.UCB_DISC).build();
                    break;
                case AppConstants.VERO_MODA:
                case AppConstants.VERO_MODA1:
                    this.brand = new Brand.Builder().brandName(AppConstants.VERO_MODA)
                            .brandDiscount(AppConstants.VERO_MODA_DISC).build();
                    break;
                case AppConstants.WRANGLER:
                    this.brand = new Brand.Builder().brandName(AppConstants.WRANGLER)
                            .brandDiscount(AppConstants.WRANGLER_DISC).build();
                    break;
                default:
                    // Do Nothing.
            }
            return this;
        }

        public Builder actualPrice(String actualPrice){
            this.actualPrice = actualPrice;
            return this;
        }

        public Builder category(String category){
            switch (category){
                case AppConstants.DRESSES:
                    this.category = new Dress.Builder().discount(AppConstants.DRESSES_DISC)
                            .actualPrice(this.actualPrice).brand(this.brand).build();
                    break;
                case AppConstants.FOOTWEAR:
                    this.category = new Footwear.Builder().discount(AppConstants.FOOTWEAR_DISC)
                            .actualPrice(this.actualPrice).brand(this.brand).build();
                    break;
                case AppConstants.JEANS:
                    this.category = new Jean.Builder().discount(AppConstants.JEANS_DISC)
                            .actualPrice(this.actualPrice).brand(this.brand).build();
                    break;
                case AppConstants.SHIRTS:
                    this.category = new Shirt.Builder().discount(AppConstants.SHIRTS_DISC)
                            .actualPrice(this.actualPrice).brand(this.brand).build();
                    break;
                case AppConstants.TROUSERS:
                    this.category = new Trouser.Builder().discount(AppConstants.TROUSERS_DISC)
                            .actualPrice(this.actualPrice).brand(this.brand).build();
                default:
                    // Do Nothing.
            }
            return this;
        }

        public ProductBuilder build(){
            return new ProductBuilder(this);
        }
    }
}