package com.example.chapter05.standard;

import com.example.chapter05.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

public class TestStandardBroadcast extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.b2_standard);
		findViewById(R.id.b2_standard).setOnClickListener(this);
		findViewById(R.id.b2_order).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b2_standard:
			Intent intent1 = new Intent("test.standard.MY_BROADCAST");
			sendBroadcast(intent1);
			break;
		case R.id.b2_order:
			Intent intent2 = new Intent("test.standard.MY_BROADCAST");
			//有序广播只替换这一行代码
			sendOrderedBroadcast(intent2, null);
			break;
		default:
			break;
		}
	}

}
