package com.example.arnoldfinalproject;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
	private Button buttonCon;
	private Button buttonConv;
	private Button buttonConvert;
	
	private EditText editMiles;
	private EditText editGallons;
	private EditText editInches;
	private EditText editKilo;
	private EditText editLit;
	private EditText editCent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buttonConvert =(Button)findViewById(R.id.buttonConvert);
        buttonCon =(Button)findViewById(R.id.buttonCon);
        buttonConv = (Button)findViewById(R.id.buttonConv);
        
        editMiles = (EditText)findViewById(R.id.editMiles);
        editGallons = (EditText)findViewById(R.id.editGallons);
        editInches = (EditText)findViewById(R.id.editInches);
        editKilo = (EditText)findViewById(R.id.editKilo);
        editLit = (EditText)findViewById(R.id.editLit);
        editCent = (EditText)findViewById(R.id.editCent);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void buttonCoclicked(View v){
    	Editable input = editMiles.getText();
    	String inputString = String.valueOf(input);
    	float miles= Float.valueOf(inputString);
    	float kilo = (float) (miles * 1.6 );
    	editKilo.setText(String.valueOf(kilo));
    }
    public void buttonConclicked(View v){
    	Editable input = editGallons.getText();
    	String inputString = String.valueOf(input);
    	float gallons= Float.valueOf(inputString);
    	float lit = (float) (gallons * 3.8 );
    	editLit.setText(String.valueOf(lit));
    } public void buttonConvclicked(View v){
    	Editable input = editInches.getText();
    	String inputString = String.valueOf(input);
    	float inches= Float.valueOf(inputString);
    	float cent = (float) (inches * 2.54 );
    	editCent.setText(String.valueOf(cent));
    }
   
}
