package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int numberOfCoffees = 2;

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        Log.v("MainActivity","Hass Whipped Cream: "+hasWhippedCream);
       int price=calculatePrice(hasWhippedCream);
       displayMessage(createOrderSummary(price,hasWhippedCream));
    }

    /**
     * Creates the summary of the order
     * @param price of the order
     * @return text message
     */
    private String createOrderSummary(int price,boolean hasWhippedCream){
        if (price==0)
            return "Nothing Order";
        else
            return "Name: Rahul krishna\n"+"Has Whipped Cream? "+hasWhippedCream+"\nQuantity: "+numberOfCoffees+"\nTotal: $"+price+"\nThank You!";
    }
    /**
     * Calculates the price of the order.
     */
    private int calculatePrice(boolean hasWhippedCream) {
        int price;
        if(hasWhippedCream)
            price= numberOfCoffees*7;
        else
            price= numberOfCoffees*5;
        return price;
    }

    public void increment(View view) {
        numberOfCoffees++;
        displayQuantity(numberOfCoffees);
    }

    public void decrement(View view) {
        if (numberOfCoffees > 0) {
            numberOfCoffees--;
            displayQuantity(numberOfCoffees);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numbers) {
        TextView quantityTextView =  findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+numbers);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}