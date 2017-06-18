//Code Written by Austin O'Boyle 10147479
//I solemnly swear that Austin O'Boyle wrote all of this code
//that wasn't given to us by Dr. Kunz

package assignment3;

import java.math.BigDecimal;


public class Checkout {
    private MarketItem[] items;   // list with food items
    
    /** constructor */
    public Checkout(MarketItem[] items) {
        this.items = items;
    }
    
    /** returns the total price for all items
     * excluding tax 
     */
    public double getTotalPrice() {
        double totalAmount = 0.0;
        for (MarketItem item:this.items){
            totalAmount += item.getPrice();
        }
        return totalAmount;    // replace with correct value
    }
    
    /** returns the total tax for all items
     */
    public double getTotalTax() {
        double totalTax = 0.0;
        for (MarketItem item:this.items){
            totalTax += item.getTax();
        }
        return totalTax;
    }
    
    /** returns the total purchase amount for all items
     * including tax
     */
    public double getTotalAmount() {
        return this.getTotalPrice() + this.getTotalTax();   // replace with correct value
    }
    
    /**
     * @return
     *      line separated list of items bought at Marketplace.  Each line
     *      includes total price, total tax, and total amount paid (String)
     */
    @Override
    public String toString() {
        String s = "Sum Price: $"+ round(this.getTotalPrice(),2) + "\n"
                +  "Sum Tax: $" + round(this.getTotalTax(),2)+ "\n"
                +  "Total: $" + round(this.getTotalAmount(),2);
        return s;
    }
    
    private String round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        return new BigDecimal(value).setScale(places, BigDecimal.ROUND_HALF_UP).toString();
    }
}
