package com.example.chapter05.standard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyStandardBroadcast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "received in TestStandardBroadcast(标准广播)", Toast.LENGTH_SHORT).show();
		//广播截断，调用这个方法，终止传递
		abortBroadcast();
	}

}
