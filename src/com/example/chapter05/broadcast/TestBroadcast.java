package com.example.chapter05.broadcast;

import com.example.chapter05.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

public class TestBroadcast extends Activity {
	private IntentFilter intentFilter;

	private NetworkChangeReceiver networkChangeReceiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.b1_networkchange);

		intentFilter = new IntentFilter();
		// Ҫ����ʲô�㲥��д��Ӧ��action
		intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
		networkChangeReceiver = new NetworkChangeReceiver();
		registerReceiver(networkChangeReceiver, intentFilter);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(networkChangeReceiver);
	}

	/*
	 * ÿ������״̬�����仯��onReceive()����ִ��
	 */
	class NetworkChangeReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			ConnectivityManager connectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
			if (networkInfo != null && networkInfo.isAvailable()) {
				Toast.makeText(context, "����ɻ��", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(context, "���粻��ʹ��", Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	
}
