package com.blakestiller.groupdine;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View view){
        // Hide Numpad onClick - when the button is pressed
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        // get all the user input from the EditText fields
        EditText total   = (EditText)findViewById(R.id.editText2);
        EditText people   = (EditText)findViewById(R.id.editText);
        EditText tip   = (EditText)findViewById(R.id.editText3);
        EditText each   = (EditText)findViewById(R.id.editText4);
                // Convert all user input to Float
                float totalVar = Float.parseFloat(total.getText().toString());
                float peopleVar = Float.parseFloat(people.getText().toString());
                float tipVar = Float.parseFloat(tip.getText().toString());
                // Calculate total * tip + total / people
                float calc = (totalVar * (tipVar/100) + totalVar) / peopleVar;
                // Round it up to 2 decimal points
                String EachPay = String.format("%.2f", calc);

                // Show what everyone pays in the EditText field
                each.setText("$"+EachPay);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
