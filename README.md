*************************************************************************************************************************************
*                                                Problem Statement - Discounts on Apparel                                           *
*************************************************************************************************************************************

1.	This shopping season you are having fun at the Mall. The Mall owner, himself, is quite stressed out having to manage the influx of 
customers.

2.	He is struggling to calculate the discounts that he has on his clothing line. You decide to help him out by building a system that
calculates the discounts on all the applicable items a customer has bought.
 
3.	There are several categories of products. In fact, categories have subcategories which themselves can have subcategories. Below 
is a diagram.

4.	Casuals is a subcategory of Trousers, which by itself is a subcategory of Men's wear. Some categories have discounts.
 
            Men's wear                 	Women's wear (50% off)
            |- Shirts                   |- Dresses
            |- Trousers                 |- Footwear
            |- Casuals (30% off)
            |- Jeans   (20% off)
 
5.	Each product belongs to a brand which by themselves is running discounts. Below is a table that list Brands Discounts:
            Wrangler		10%
            Arrow 		  20%
            Vero Moda		60%
            UCB		      None
            Adidas		  5%
            Provogue		20%

6.	This way, a product can have three types of discounts applicable:
    a.	Discount on the brand
    b.	Discount on the category
    c.	Discount on the ancestor category (e.g. Footwear doesn't have a discount, but it's parent category Women's wear has 50% off).

It is worth noting, that it is an ancestor: not just a direct parent, anyone in the lineage.

The discount that is applied is the greatest of the above three. For example, if the customer buys a Jeans of Wrangler Brand,
the discounts are:
1. Discount on brand: 10%
2. Discount on category (Jeans): 20%
3. Discount on parents (Trousers, Men's wear): None
So, the discount that is applied 20%.
 
7.	Inventory (the list of items that shop has):
=======================================================================
| Id	| Brand 		| Category            | Price		| Discounted Price	|
=======================================================================
| 1	  | Arrow		  | Shirts		          | 800		  | 640			          |
| 2	  | Vero Moda	| Dresses	            | 1400		| 560			          |
| 3	  | Provogue	| Footwear	          | 1800		| 900			          |
| 4 	| Wrangler	| Jeans		            | 2200		| 1760		          |
| 5	  | UCB		    | Shirts		          | 1500		| 1500		          |
=======================================================================
 
You will be given the above table (without discounted price) in CSV form as standard input. This is the shop inventory.

8.	You'll also get the customer options as comma separated Id's after a newline. In the example below, 1,2,3,4 are the 
customer choices.
 
Sample Input:
 
5
1, Arrow,Shirts,800
2, Vero Moda,Dresses,1400
3, Provogue,Footwear,1800
4, Wrangler,Jeans,2200
5, UCB,Shirts,1500
 
2
1,2,3,4
1,5
 
Expected output:
3860
2140

*************************************************************************************************************************************
*                                                Release Note - Discounts on Apparel                                                *
*************************************************************************************************************************************
1.	Programming Language:  Java language is used for the solution.

2.	Input: 
    a.	An input file, Input.csv, is placed in “res” directory of the project.
    b.	Location: "./res/Input.csv"
    c.	Input file is read in “main” method from the location and processed further.
    
3.	Design Assumptions and Explanation
    a.	The structure followed is little different from the one given in the problem shared.
    
    b.	I have followed the general category-subcategory structure followed across by major e-commerce players such as Flipkart, 
        Amazon etc.
    
    c.	There are two main categories namely MenWear and WomenWear.
    
    d.	MenWear has two main subcategories namely Casuals and Formals.
        i.	Casuals subcategory has Jean and T-Shirt in it.
        ii.	Formals subcategory has Trouser and Shirt in it.
    
    e.	WomenWear has two main subcategories namely FootWear and Dress.

4.	Categories
    a.	 Men Wear
        i.	Casuals
            1.	Jean
            2.	T-Shirt
            
        ii.	Formals
            1.	Trouser
            2.	Shirt

    b.	Women Wear
        i.	Foot Wear
        ii.	Dress

Note: The structure followed here is highly modular and hence scalable in such a way that any number of subcategories can be 
added to with much change.

5.	Instructions to Run Application
    1.  JAR
        Run the jar present in “./res” directory by using “java –jar <jar name> ” command and follow the instructions provided 
        for command line input option.
        
    2.  Code
        Import the code as an IntelliJ project and simply run the project from “ApparelDiscountMain.java” using either 
        “command line input” option or “file input” option. 
        
        •	If “command line input” option is used, follow the instructions provided for command line input option.
        
        •	If “file input” option is used, use the input file present in “./res” directory ["./res/Input.csv"]. Or use a file that 
        has the same pattern as that of the input file pattern.

    Command Line: Use below instructions for your reference while using command line input option.
    1.	Enter Number of Products. Expected input is one number. E.g. 2
    
    2.	Enter Products. Expected input is this format: “1,Arrow,Shirts,800”. Avoid any white spaces in between.
        E.g. use ” VeroModa” instead of “Vero Moda”.(2,VeroModa,Dresses,1400) 
    
    3.	Enter Number of Products for which discounted price to be calculated. Expected input is one number. E.g. 2
    
    4.	Enter Products serial number for which discounted price is to be calculated. E.g. 2 is serial number in 
        product "2,VeroModa,Dresses,1400".
        
  *************************************************************************************************************************************
