package assignment3;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mkunz
 * Test program for Assignment 3 - CISC 124 Winter 2017
 */
public class Assignment3Test {


    public static void main(String[] args) {
       
       // test Produce class
       System.out.println("\nTesting Produce class \n");
       Produce p1 = new Produce("potatoes", "Mensen Farm", 2.5, 1.4);
       Produce p2 = new Produce("eggs", "Little Red Hen Farm", 1.25, 12);
       Produce p3 = new Produce("potatoes", "Mensen Farm", 2.5, 2.8);
       MarketItem p4 = p1;
//       
       System.out.println("Produce p1: " + p1);
       System.out.println("Tax for p1: " + p1.getTax());
       System.out.println("Produce p2: " + p2);
       System.out.println("Tax for p2: " + p2.getTax());
       System.out.println("Produce p3: " + p3);
       System.out.println("Tax for p3: " + p3.getTax());
//
       System.out.println("p1.equals(p2): " + p1.equals(p2));
       System.out.println("p1.equals(p3): " + p1.equals(p3));
       System.out.println("p1.equals(p4): " + p1.equals(p4));
       
       
       // test PreparedMeal class
       System.out.println("\nTesting PreparedMeal class \n");
       PreparedMeal meal1 = new PreparedMeal("sausage roll", "Little German Bakery", 3.0);
       PreparedMeal meal2 = new PreparedMeal("falafel", "Main Street Market", 2.50);
       PreparedMeal meal3 = new PreparedMeal("falafel", "Main Street Market", 5.0);
       
       System.out.println("Meal 1: " + meal1);
       System.out.println("Tax for meal1: " + meal1.getTax());
       System.out.println("Meal 2: " + meal2);
       System.out.println("Tax for meal2: " + meal2.getTax());
       System.out.println("Meal 3: " + meal3);
       System.out.println("Tax for meal3: " + meal3.getTax());
//
       System.out.println("meal1.equals(meal2): " + meal1.equals(meal2));
       System.out.println("meal1.equals(meal3): " + meal1.equals(meal3));
       System.out.println("meal1.equals(meal1): " + meal1.equals(meal1));
       System.out.println("meal2.equals(meal3): " + meal2.equals(meal3));
       
       // testing Checkout class
       System.out.println("\nTesting Checkout class \n");
       MarketItem[] items = new MarketItem[6];
       items[0] = (MarketItem)p1;
       items[1] = (MarketItem)p2;
       items[2] = (MarketItem)p3;
       items[3] = (MarketItem)meal1;
       items[4] = (MarketItem)meal2;
       items[5] = (MarketItem)meal3;
//       
       Checkout check = new Checkout(items);
       System.out.println("Receipt for your shopping: ");
       for (MarketItem i : items)
            System.out.println(i);
       
        System.out.println(check);  
       
    }
    
}
