package com.societe.generale.problem;

import com.societe.generale.problem.utils.AppConstants;

/**
 * This class is the application entry point.
 */
public class ApparelDiscountMain {
    public static void main(String []arr){
        // File input processor.
        new InventoryProcessor().inventoryProcessor(AppConstants.APPAREL_INVENTORY);

        // Commandline input processor.
//        new InventoryProcessor().cmdLineInventoryProcessor();
    }
}