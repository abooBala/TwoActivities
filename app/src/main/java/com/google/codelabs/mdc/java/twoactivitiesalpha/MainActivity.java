package com.google.codelabs.mdc.java.twoactivitiesalpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	public static final String EXTRA_MESSAGE = "com.google.codelabs.mdc.java.twoactivitiesalpha.extra.MESSAGE";

	private EditText mMessageEdit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mMessageEdit = findViewById(R.id.editText_main);
	}

	public void launchSecondActivity(View view) {

		Log.d(TAG, "launchSecondActivity: Button Clicked");

//		Navigate to the second activity with an explicit intent
		Intent intent = new Intent(this, SecondActivity.class);
		String message = mMessageEdit.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}
}