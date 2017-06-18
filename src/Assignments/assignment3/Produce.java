//Code Written by Austin O'Boyle 10147479
//I solemnly swear that Austin O'Boyle wrote this code

package assignment3;

import java.math.BigDecimal;

public class Produce extends MarketItem{

    private double unitPrice;
    private double amount;
    
    /**
     * Constructor for a Produce Item
     * 
     * @see MarketItem#MarketItem(String, String)
     * 
     * @param name
     *      name of MarketItem being sold (String)
     * @param vendor
     *      name of vendor selling the item (String)
     * @param unitPrice
     *      unit price (per certain amount bought) of an item (double)
     * @param amount
     *      amount of the item bought (double)
     */
    public Produce(String name, String vendor, double unitPrice, double amount) {
        super(name, vendor);
        this.unitPrice = unitPrice;
        this.amount = amount;
        
        //Error Handling for invalid unitPrice or amount
        if (this.unitPrice < 0)
            this.unitPrice = 0;
        if (this.amount < 0)
            this.amount = 0;
    }
    
    /**
     * Accessor for unit price
     * @return
     *      double: unit price
     */
    public double getUnitPrice(){
        return this.unitPrice;
    }
    
    /**
     * Accessor for amount of item
     * @return
     *      double: amount of item
     */
    public double getAmount(){
        return this.amount;
    }
    
    /**
     * @see MarketItem#getPrice()
     */
    public double getPrice(){
        return this.unitPrice * this.amount;
    }
    
    /**
     * @see MarketItem#getTax()
     */
    public double getTax(){
        return 0.00;
    }
    
    
    /**
     * Overrides toString in MarketItem
     * @see MarketItem#toString
     * @return
     *      quantity of item, unit price of item, name of item, and name of vendor (String)
     */
    @Override
    public String toString(){
        String s = round(this.amount,2) + " @ $" + round(this.unitPrice,2) + " = $" + round(getPrice(), 2)
                + " " + this.getName() + " from " + this.getVendor();
        
        return s;
    }
    
    /**Checks equality of self and other produce item
     * 
     * @param that
     *      Other produce item
     * @return
     *      boolean: True if name, unitPrice, and vendor are the same
     *               False otherwise
     */
    public boolean equals(Produce that){
        return this.getName().equals(that.getName()) 
                && this.getVendor().equals(that.getVendor())
                && this.unitPrice == that.unitPrice;
    }
    
    /**
     * 
     * @param value
     *      double: value to round
     * @param places
     *      int: number of decimal places
     * @return
     *      String: rounded value
     */
    private String round(double value, int places) {
        return new BigDecimal(value).setScale(places, BigDecimal.ROUND_HALF_UP).toString();
    }
}
