//Code Written by Austin O'Boyle 10147479
//I solemnly swear that Austin O'Boyle wrote this code

package assignment3;

import java.math.BigDecimal;

public class PreparedMeal extends MarketItem {
        private double price;
        
        /**
         * Constructor for PreparedMeal item.  Derived from MarketItem
         * 
         * @see MarketItem#MarketItem(String, String)
         * 
         * @param name
         *      name of PreparedMeal item (String)
         * @param vendor
         *      name of vendor selling item (String)
         * @param price
         *      price of item (double)
         */
        public PreparedMeal(String name, String vendor, double price){
            super(name, vendor);
            this.price = price;
            
            //Error handling, set invalid prices to zero
            if (this.price < 0)
                this.price = 0;
        }
        
        /**
         * @see assignment3.MarketItem#getPrice()
         */
        public double getPrice(){
            return round(this.price,2);
        }
        
        /**
         * @see assignment3.MarketItem#getTax()
         */
        public double getTax(){
            if (this.price <= 4.0){
                return round((this.price * 0.05),2);
            }
            return round(this.price * 0.13,2);
        }
        
        /**
         * @return
         *      price of item, name of item, and name of vendor (String)
         */
        @Override
        public String toString(){
            String s = "$" + roundGetString(this.price,2) + " " + this.getName() + " from " + this.getVendor();
            return s;
        }
        
        /**
         * Determines equality of two PreparedMeal items
         * @param that
         *     other PreparedMeal item
         * @return
         *      True if name and vendor are equal, False otherwise (boolean)
         */
        public boolean equals(PreparedMeal that){
            return this.getName().equals(that.getName()) && this.getVendor().equals(that.getVendor()); 
        }
        
        //Helper rounding methods outputting double and String respectively
        private double round(double value, int places){
            return new BigDecimal(value).setScale(places, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        
        private String roundGetString(double value, int places){
            return new BigDecimal(value).setScale(places, BigDecimal.ROUND_HALF_UP).toString();
        }
}

