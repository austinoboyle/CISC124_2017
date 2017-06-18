//Austin O'Boyle 10147479
//Code written by Austin O'Boyle

package assignment5;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.EventObject;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


/**
 *
 * @author Austin O'Boyle, CISC 124 Winter 2017.
 * Market Checkout GUI Main Panel - Assignment 5
 */
public class MainPanel extends JPanel {
    
    //Text Area for the receipt
    private JTextArea receiptArea;
    
    //Fields for user input of the item information
    private JTextField nameField = new JTextField(50);
    private JTextField vendorField = new JTextField(50);
    private JTextField priceField = new JTextField(50);
    private JTextField amountField = new JTextField(50);
    
    //Panels for summary/checkout information
    private JPanel totalPricePanel = new JPanel();
    private JPanel totalTaxPanel = new JPanel();
    private JPanel totalAmountPanel = new JPanel();

    Font bigLabelFont = new Font("Serif", Font.BOLD, 20);
    
    private JLabel totalPriceLabel = new JLabel();
    private JLabel totalTaxLabel = new JLabel();
    private JLabel totalAmountLabel = new JLabel();
    
    private Checkout checkout = new Checkout();
    
    JTextField fieldArray1[] = {nameField, vendorField, priceField,amountField};
        
    //Variables for the entered information
    private String itemName;
    private String vendor;
    private double price;
    private double amount;
    
    //Variables for receipt summary
    private double totalPrice = 0;
    private double totalTax = 0;
    private double totalAmount = 0;
    
    // constructor
    // creates GUI components and actions event listener
    public MainPanel() {
        super(new GridLayout(1, 2));    // basic layout grid: 1 row, 2 columns
       
        JPanel leftPanel = new JPanel(new BorderLayout());
        this.add(leftPanel);
        JPanel rightPanel = new JPanel(new BorderLayout());
        this.add(rightPanel);
        
        
        //User interaction panel (left side)
        JPanel controlPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        controlPanel.setBorder(new LineBorder(Color.GREEN, 1));
        leftPanel.add(controlPanel);
        
        nameField.setFont(new Font("Serif", Font.BOLD, 16));
        vendorField.setFont(new Font("Serif", Font.BOLD, 16));
        priceField.setFont(new Font("Serif", Font.BOLD, 16));
        amountField.setFont(new Font("Serif", Font.BOLD, 16));
        
        String fieldList[] = {"Name", "Vendor", "Price", "Amount"};
        
        for (int i = 0; i < 4; i++){
            String fieldName = fieldList[i];
            JPanel fieldPanel = new JPanel(new GridLayout(1,2));
            JLabel l = new JLabel(fieldName + ":");
            
            l.setFont(new Font("Serif", Font.BOLD, 20));
            fieldPanel.add(l);
            switch (i){
            case 0:
                fieldPanel.add(nameField, 0,1);
                break;
            case 1:
                fieldPanel.add(vendorField, 0,1);
                break;
            case 2:
                fieldPanel.add(priceField, 0,1);
                break;
            case 3:
                fieldPanel.add(amountField, 0,1);
                break;
            }
            controlPanel.add(fieldPanel);
        }
        
        
        //Set up right panel
        
        rightPanel.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 1), "Receipt"));
        // create a text area to display items on the receipt
        receiptArea = new JTextArea(50,200);
        receiptArea.setFont(new Font("SansSerif", Font.BOLD, 12));
        receiptArea.setEditable(false);
        rightPanel.add(receiptArea);
        
        JPanel summaryPanel = new JPanel(new GridLayout(3,1,0,10));
       
        totalPriceLabel.setFont(bigLabelFont);
        totalPricePanel.add(totalPriceLabel);

        totalTaxLabel.setFont(bigLabelFont);
        totalTaxPanel.add(totalTaxLabel);

        totalAmountLabel.setFont(bigLabelFont);
        totalAmountPanel.add(totalAmountLabel);
      
        summaryPanel.add(totalPricePanel);
        summaryPanel.add(totalTaxPanel);
        summaryPanel.add(totalAmountPanel);
        
        rightPanel.add(summaryPanel, BorderLayout.SOUTH); 
        updateSummary();
        
        //Create buttons to use for each type of market item
        Font btnFont = new Font("Serif", Font.ITALIC, 18);
        JPanel btnPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        JButton produceButton = new JButton("Produce");
        produceButton.setFont(btnFont);
        btnPanel.add(produceButton);
        
        JButton preparedMealButton = new JButton("Prepared Meal");
        preparedMealButton.setFont(btnFont);
        btnPanel.add(preparedMealButton);
        leftPanel.add(btnPanel, BorderLayout.SOUTH);

        // add action listener to the buttons
        produceButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                if (!isEmpty()){
                    itemName = nameField.getText();
                    vendor = vendorField.getText();
                    
                    //Check for invalid input
                    try{
                        price = Double.parseDouble(priceField.getText());
                        amount = Double.parseDouble(amountField.getText());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(new JFrame(),
                                "Must enter valid number in the amount and price fields.");
                        return;
                    }
                    Produce produceItem = new Produce(itemName, vendor, price,amount); 
                    addItem(produceItem);
                    
                    totalPrice += produceItem.getPrice();
                    totalTax += produceItem.getTax();
                    totalAmount = totalPrice + totalTax;
                    
                    updateSummary();
                    clearFields();
                }
                else{
                    //Empty text field(s), return error msg
                    JOptionPane.showMessageDialog(new JFrame(),
                            "Must not leave any fields blank."); 
                }
           }
        });
        
        preparedMealButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                if (!isEmpty()){
                    itemName = nameField.getText();
                    vendor = vendorField.getText();
                    
                    //Check for invalid input
                    try{
                        price = Double.parseDouble(priceField.getText());
                        amount = Double.parseDouble(amountField.getText());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(new JFrame(),
                                "Must enter valid number in the amount and price fields.");
                        return;
                    }
                    
                    int quantity = (int)Math.round(amount);
                    
                    PreparedMeal produceItem = new PreparedMeal(itemName, vendor, price,quantity); 
                    addItem(produceItem);
                    
                    totalPrice += produceItem.getPrice();
                    totalTax += produceItem.getTax();
                    totalAmount = totalPrice + totalTax;
                    
                    updateSummary();
                    clearFields();
                }
                else{
                    JOptionPane.showMessageDialog(new JFrame(),
                            "Must not leave any fields blank."); 
                }
           }
        });        
    }
    
    /**Checks if any of the user supplied fields were left empty
     * 
     * @return true if any fields are empty, false otherwise
     */
    boolean isEmpty() {
        String s1 = nameField.getText();
        String s2 = vendorField.getText();
        String s3 = priceField.getText();
        String s4 = amountField.getText();
        
        if (s1.equals("")
         || s2.equals("")
         || s3.equals("")
         || s4.equals("")){
            return true;
        }
        else{
            return false;
        }
    }
    
    //Updates the totalled values in the checkout cart
    void updateSummary(){
        totalPriceLabel.setText("Total Price: " + Money.format(Money.roundMoney(totalPrice)));
        totalTaxLabel.setText("Total Tax: " + Money.format(Money.roundMoney(totalTax)));        
        totalAmountLabel.setText("Total Amount: " + Money.format(Money.roundMoney(totalAmount)));
    }
    
    //clear all fields
    void clearFields(){
        JTextField fieldArray[] = {nameField, vendorField, priceField,amountField};
        for (JTextField field:fieldArray){
            field.setText("");
        }
    }
    
    // Add item to the checkout list, and the receipt
    void addItem(MarketItem item) {
        checkout.addItem(item);
        String s = item.toString();
        s = s + "\n";
        // append new information at end of text area
        receiptArea.append(s);
    }
    

}
