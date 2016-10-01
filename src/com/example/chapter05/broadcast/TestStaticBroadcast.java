package com.example.chapter05.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TestStaticBroadcast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "Boot Complete(Æô¶¯Íê³É)", Toast.LENGTH_LONG).show();
	}

}
