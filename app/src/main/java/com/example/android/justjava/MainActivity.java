package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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
        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_cream_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        EditText text = findViewById(R.id.input_name);
        String name = text.getText().toString();
       int price=calculatePrice();
       displayMessage(createOrderSummary(price,hasWhippedCream,hasChocolate,name));
    }

    /**
     * Creates the summary of the order
     * @param hasWhippedCream is whether or not the user wants whipped cream topping
     * @param hasChocolate is whether or not the user wants chocolate topping
     * @param price of the order
     * @return text message
     */
    private String createOrderSummary(int price,boolean hasWhippedCream,boolean hasChocolate,String name){
        return "Name: "+name+"\nHas Whipped Cream? "+hasWhippedCream+"\nHas Chocolate? "+hasChocolate+"\nQuantity: "+numberOfCoffees+"\nTotal: $"+price+"\nThank You!";
    }
    /**
     * Calculates the price of the order.
     */
    private int calculatePrice(){
        return numberOfCoffees*5;
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