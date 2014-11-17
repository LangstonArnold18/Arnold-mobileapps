package com.example.arnold_finalexam_fall14;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//Langston Arnold
// All work here is honestly obtained and is my own
public class MainActivity extends Activity {
	private Button ButtonD;
	private Button ButtonY;
	private Button ButtonP;
	private EditText editDollar;
	private EditText editYen;
	private EditText editPound;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ButtonD = (Button)findViewById(R.id.buttonD);
		ButtonY = (Button)findViewById(R.id.buttonY);
		ButtonP = (Button)findViewById(R.id.buttonP);
		editDollar = (EditText)findViewById(R.id.editDollar);
		editYen = (EditText)findViewById(R.id.editYen);
		editPound = (EditText)findViewById(R.id.editPound);
		
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
	public void buttonDclicked(View v){
		Editable input = editDollar.getText();
		String inputString = String.valueOf(input);
		float dollar = Float.valueOf(inputString);
		float yen = (float)(dollar * 97.35);
		float pound = (float)(dollar * .62);
		editYen.setText(String.valueOf(yen));
		editPound.setText(String.valueOf(pound));
	}
	public void buttonYclicked(View v){
		Editable input = editYen.getText();
		String inputString = String.valueOf(input);
		float yen = Float.valueOf(inputString);
		float dollar = (float)(yen / 97.35);
		float pound = (float)(yen * .0055);
		editDollar.setText(String.valueOf(dollar));
		editPound.setText(String.valueOf(pound));
	}
	public void buttonPclicked(View v){
		Editable input = editPound.getText();
		String inputString = String.valueOf(input);
		float pound = Float.valueOf(inputString);
		float dollar = (float)(pound * 1.56);
		float yen = (float)(pound * 181.93);
		editDollar.setText(String.valueOf(dollar));
		editYen.setText(String.valueOf(yen));
	}
	
}
