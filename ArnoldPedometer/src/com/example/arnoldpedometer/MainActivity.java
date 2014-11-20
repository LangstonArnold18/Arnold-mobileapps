package com.example.arnoldpedometer;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	//Display Fields for Accelerometer
	private TextView textViewX;
	private TextView textViewY;
	private TextView textViewZ;
	// Display Field for Sensitivity
	private TextView textSensitive;
	//Display for Steps
	private TextView textViewSteps;
	// Reset Button
	private Button buttonReset;
	// Sensor Manager
	private SensorManager sensorManager;
	private float acceleration;
	// Values to Calculate Number of Steps
	private float previousY;
	private float currentY;
	private int numSteps;
	// SeekBar Fields
	private SeekBar seekBar;
	private int threshold;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textViewX = (TextView)findViewById(R.id.textViewX);
		textViewY = (TextView)findViewById(R.id.textViewY);
		textViewZ = (TextView)findViewById(R.id.textViewZ);
		textViewSteps = (TextView)findViewById(R.id.textSteps);
		textSensitive = (TextView)findViewById(R.id.textSensitive);
		buttonReset = (Button)findViewById(R.id.buttonReset);
		seekBar = (SeekBar)findViewById(R.id.seekBar);
		seekBar.setProgress(10);
		seekBar.setOnSeekBarChangeListener(seekBarListener);
		threshold = 10;
		textSensitive.setText(String.valueOf(threshold));
		
		//Initialize Values
		previousY = 0;
		currentY = 0;
		numSteps = 0;
		//initialize acceleration values
		acceleration = 0.00f;
		//enable the listener
		enableAccelerometerListening();
		
		
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
	private void enableAccelerometerListening(){
		// Initialize the Sensor Manager
		sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 
				SensorManager.SENSOR_DELAY_NORMAL);
	}
	//Event handler for accelerometer events
	private SensorEventListener sensorEventListener =
			new SensorEventListener()
	{

	public void onSensorChanged(SensorEvent event)
	{
		//Gather the values from accelerometer
		float x = event.values[0];
		float y = event.values[1];
		float z = event.values[2];
		//Fetch the current Y
		currentY = y;
		//Measure if a step is taken
		if(Math.abs(currentY - previousY)>threshold){
			numSteps++;
			textViewSteps.setText(String.valueOf(numSteps));
		}
		//Display the Values
		textViewX.setText(String.valueOf(x));
		textViewY.setText(String.valueOf(y));
		textViewZ.setText(String.valueOf(z));
		//Store the previous Y
		previousY = y;
	}// onSensorChanged
	public void onAccuracyChanged(Sensor sensor, int accuracy){
	}
};
	// Called by the resetButton to set the steps count to 0 abd reset the Display
	public void buttonResetclicked(View v){
		numSteps = 0;
		textViewSteps.setText(String.valueOf(numSteps));
}
	private OnSeekBarChangeListener seekBarListener =
			new OnSeekBarChangeListener()
	{
		public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
			//Change the threshold
			threshold = seekBar.getProgress();
			//Write to the TextView
			textSensitive.setText(String.valueOf(threshold));
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			
		}
	};
}
