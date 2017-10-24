package com.societe.generale.problem;

/**
 * 1. This class represents all Brands.
 * 2. Each brand is conformed using it.
 */
public class Brand {
    private int brandDiscount;
    private String brandName;

    public Brand(Builder builder){
        this.brandDiscount = builder.brandDiscount;
        this.brandName = builder.brandName;
    }

    public String brand() {
        return this.brandName;
    }

    public int brandDiscount() {
        return this.brandDiscount;
    }

    public static class Builder {
        private int brandDiscount;
        private String brandName;

        public Builder brandName(String serialNumber){
            this.brandName = serialNumber;
            return this;
        }

        public Builder brandDiscount(int brandDiscount){
            this.brandDiscount = brandDiscount;
            return this;
        }

        public Brand build(){
            return new Brand(this);
        }
    }
}