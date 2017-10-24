package com.societe.generale.problem.category;

import com.societe.generale.problem.Brand;

/**
 * An interface for category.
 */
public interface Category {
    String category();
    int discount();
    Brand brand();
    String actualPrice();
    float discountedPrice();
}
