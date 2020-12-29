package com.google.codelabs.mdc.java.twoactivitiesalpha;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	public static final String EXTRA_MESSAGE = "com.google.codelabs.mdc.java.twoactivitiesalpha.extra.MESSAGE";

	public static final int TEXT_REQUEST = 1;
	private TextView mReplyHeadTextView;
	private TextView mReplyTextView;

	private EditText mMessageEdit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mMessageEdit = findViewById(R.id.editText_main);
		mReplyHeadTextView = findViewById(R.id.text_header_reply);
		mReplyTextView = findViewById(R.id.text_message_reply);
	}

	public void launchSecondActivity(View view) {

		Log.d(TAG, "launchSecondActivity: Button Clicked");

//		Navigate to the second activity with an explicit intent
		Intent intent = new Intent(this, SecondActivity.class);
		String message = mMessageEdit.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivityForResult(intent, TEXT_REQUEST);

		mReplyHeadTextView.setVisibility(View.VISIBLE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == TEXT_REQUEST) {
			if (resultCode == RESULT_OK) {
				String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
				mReplyTextView.setText(reply);
				mReplyTextView.setVisibility(View.VISIBLE);
			}
		}
	}
}