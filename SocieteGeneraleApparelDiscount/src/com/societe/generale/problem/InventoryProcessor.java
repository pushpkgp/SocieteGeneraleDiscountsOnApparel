package com.societe.generale.problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Functions:
 * 1. Class responsible for processing the inventory file and building the products.
 * 2. Class responsible for displaying the final output.
 *
 * Assumptions:
 * 1. File reader is based on the given input file present in "res" directory.
 * 2. We need to adjust if the input file pattern is different from the given one.
 */

public class InventoryProcessor {

    public void cmdLineInventoryProcessor(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of Products. Expected input is only one number. E.g. 2");
        int numberOfProds = sc.nextInt();

        List<String []> productList = new ArrayList();
        System.out.println("Enter Products. Expected input is this format: 1,Arrow,Shirts,800. Avoid any white spaces in between. E.g. use VeroModa instead of Vero Moda.");
        for(int i = 0; i < numberOfProds; i++){
            String prod = sc.next();
            productList.add(prod.split(","));
        }

        Map<String, ProductBuilder> productMap = productProcessor(productList);

        System.out.println("Enter Number of Products for which discounted price to be calculated. Expected input is only one number. E.g. 2");
        int no = sc.nextInt();

        for(int i = 0; i < no; i++){
            System.out.println("Enter Products serial number for which discounted price is to be calculated. E.g. 2 is serial number in this product (2,VeroModa,Dresses,1400)");
            String prod = sc.next();
            float discountedPrice = 0;
            String[] discPriceForProds = prod.split(",");
            for(int j = 0; j < discPriceForProds.length; j++){
                discountedPrice = discountedPrice +  productMap.get(discPriceForProds[j]).getCategory().discountedPrice();
            }
            System.out.println("Discounted price for " + prod + " products is " + discountedPrice);
        }

        sc.close();
    }

    public void inventoryProcessor(String file){
        List<String []> productList = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int inventorySize = Integer.parseInt(br.readLine());
            String currentLine;
            for(int i = 0; i < inventorySize; i++){
                currentLine = br.readLine();
                String [] product = currentLine.split(",");
                productList.add(product);
            }

            Map<String, ProductBuilder> productMap = productProcessor(productList);

            currentLine = br.readLine();
            currentLine = br.readLine();

            while ((currentLine = br.readLine()) != null) {
                float discountedPrice = 0;
                String[] discPriceForProds = currentLine.split(",");
                for(int i = 0; i < discPriceForProds.length; i++){
                    discountedPrice = discountedPrice +  productMap.get(discPriceForProds[i]).getCategory().discountedPrice();
                }
                System.out.println("Discounted price for " + currentLine + " products is " + discountedPrice);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, ProductBuilder>  productProcessor(List<String []> productList){
        Map<String, ProductBuilder> productMap = new HashMap();
        for(String [] product : productList){
            ProductBuilder finalProduct = new ProductBuilder.Builder()
                    .serialNumber(product[0])
                    .brand(product[1])
                    .actualPrice(product[3])
                    .category(product[2])
                    .build();

            productMap.put(finalProduct.getSerialNumber(), finalProduct);
        }
        return productMap;
    }
}