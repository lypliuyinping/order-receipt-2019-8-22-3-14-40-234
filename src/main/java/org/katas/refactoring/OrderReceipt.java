package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;
    private double totSalesTx = 0d;
    private double tot = 0d;
    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        
        // print headers
        printHeaders(output);
        // prints lineItems
        printsLineItems(output);
        // prints the state tax
        output.append("Sales Tax").append('\t').append(totSalesTx);
        // print total amount
        output.append("Total Amount").append('\t').append(tot);
        return output.toString();
    }
    private void printHeaders(StringBuilder output) {
        output.append("======Printing Orders======\n");
        // print date, bill no, customer name
        // output.append("Date - " + order.getDate();
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
        //   output.append(order.getCustomerLoyaltyNumber());
    }
    private void printsLineItems(StringBuilder output) {
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.totalAmount());
            output.append('\n');

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;
            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            tot += lineItem.totalAmount() + salesTax;
        }
       }
    
    
}