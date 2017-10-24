package com.societe.generale.problem.category.WomenWear;

import com.societe.generale.problem.utils.AppConstants;
import com.societe.generale.problem.category.Category;

/**
 * Women wear category that implements "Category" interface.
 */
public abstract class WomenWear implements Category {

    private final String category = AppConstants.WOMEN_WEAR;
    private final int discount = AppConstants.WOMEN_WEAR_DISC;

    @Override
    public String category() {
        return this.category;
    }

    @Override
    public int discount() {
        return this.discount;
    }
}
