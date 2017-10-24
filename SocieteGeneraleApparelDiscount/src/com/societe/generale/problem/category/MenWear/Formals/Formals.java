package com.societe.generale.problem.category.MenWear.Formals;

import com.societe.generale.problem.category.MenWear.MenWear;
import com.societe.generale.problem.utils.AppConstants;
import com.societe.generale.problem.utils.DiscountCalculator;

/**
 * Formals subcategory that extends "MenWear" category.
 */
public abstract class Formals extends MenWear {

    private final String subCategory = AppConstants.FORMALS;
    private final int discount = AppConstants.FORMALS_DISC;

    public String  subCategory(){
        return this.subCategory;
    }

    @Override
    public int discount() {
        return DiscountCalculator.discountCalculator(this.discount, super.discount());
    }
}