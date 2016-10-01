package com.example.chapter05.localhost;

import com.example.chapter05.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Toast;
/**
 * 本地广播的优势
 * 1.可以明确的知道正在运行的广播不会离开我们的程序，因此不需要担心机密数据泄漏的问题。
 * 2.其他程序无法将广播发送到我们的程序内部，因此不需要担心会有安全漏洞的隐患；
 * 3.发送本地广播比起发送系统全局广播将会更加高效
 * @author 魏文强
 *
 */
public class TextLocalHostBroadcast extends Activity implements OnClickListener {
	private IntentFilter intentFilter;
	
	private LocalReceiver localReceiver;
	private LocalBroadcastManager localBroadcastManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.b3_localhost);
		//获取实例
		localBroadcastManager = LocalBroadcastManager.getInstance(this);
		findViewById(R.id.b3_localhost).setOnClickListener(this);
		
		intentFilter = new IntentFilter();
		//本地广播无法通过静态注册的方式来接收，因为只有在程序启动的情况下使用
		intentFilter.addAction("com.test.broadcast.LOCAL_BROADCAST");
		localReceiver = new LocalReceiver();
		//注册本地广播监听器
		localBroadcastManager.registerReceiver(localReceiver, intentFilter);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		localBroadcastManager.unregisterReceiver(localReceiver);
	}

	class LocalReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			Toast.makeText(context, "received local broadcast(接收到本地广播)", Toast.LENGTH_SHORT).show();
		}
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b3_localhost:
			
			Intent intent = new Intent("com.test.broadcast.LOCAL_BROADCAST");
			//发送本地广播
			localBroadcastManager.sendBroadcast(intent);
			
			break;

		default:
			break;
		}
	}
}
