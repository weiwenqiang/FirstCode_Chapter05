package com.example.chapter05.standard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyStandardBroadcast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "received in TestStandardBroadcast(��׼�㲥)", Toast.LENGTH_SHORT).show();
		//�㲥�ضϣ����������������ֹ����
		abortBroadcast();
	}

}
