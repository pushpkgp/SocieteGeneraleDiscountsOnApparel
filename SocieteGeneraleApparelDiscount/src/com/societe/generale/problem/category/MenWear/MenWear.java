package com.societe.generale.problem.category.MenWear;

import com.societe.generale.problem.utils.AppConstants;
import com.societe.generale.problem.category.Category;

/**
 * MenWear category that implements "Category" interface.
 */
public abstract class MenWear implements Category {

    private final String category = AppConstants.MEN_WEAR;
    private final int discount = AppConstants.MEN_WEAR_DISC;

    @Override
    public String category() {
        return this.category;
    }

    @Override
    public int discount() {
        return this.discount;
    }
}
