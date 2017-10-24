package com.societe.generale.problem.utils;

/**
 * Utility class for calculating discount, final discount, and discounted price.
 */
public class DiscountCalculator {
    public static int discountCalculator(int discount, int parentDiscount){
        return discount > parentDiscount ? discount : parentDiscount;
    }

    public static int finalDiscCalculator(int discount, int parentDiscount, int brandDiscount){
        int disc = discount > parentDiscount ? discount : parentDiscount;
        return disc > brandDiscount ? disc : brandDiscount;
    }

    public static float discPriceCalculator(String actualPrice, int discount){
        return (float)(Integer.parseInt(actualPrice) * (100 - discount)) / 100;
    }
}
