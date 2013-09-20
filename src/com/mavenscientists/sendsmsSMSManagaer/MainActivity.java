package com.mavenscientists.sendsmsSMSManagaer;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button sendText;
	EditText phoneNumber;
	EditText message;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sendText = (Button) findViewById(R.id.button1);  
		phoneNumber = (EditText) findViewById(R.id.editText1);
		message = (EditText) findViewById(R.id.editText2);
		
		sendText.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) {
				
				Log.d("sendsms", "Send Text Button clicked");
				String number = phoneNumber.getText().toString();
				String text = message.getText().toString();
				
				try
				{
					SmsManager smsManager = SmsManager.getDefault();
					smsManager.sendTextMessage(number, null, text, null, null);
					Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_LONG).show();
				}
				catch (Exception e)
				{
					Toast.makeText(getApplicationContext(), "Message sending failed", Toast.LENGTH_LONG).show();
					e.printStackTrace();
				}				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
