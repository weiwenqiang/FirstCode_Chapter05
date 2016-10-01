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
 * ���ع㲥������
 * 1.������ȷ��֪���������еĹ㲥�����뿪���ǵĳ�����˲���Ҫ���Ļ�������й©�����⡣
 * 2.���������޷����㲥���͵����ǵĳ����ڲ�����˲���Ҫ���Ļ��а�ȫ©����������
 * 3.���ͱ��ع㲥������ϵͳȫ�ֹ㲥������Ӹ�Ч
 * @author κ��ǿ
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
		//��ȡʵ��
		localBroadcastManager = LocalBroadcastManager.getInstance(this);
		findViewById(R.id.b3_localhost).setOnClickListener(this);
		
		intentFilter = new IntentFilter();
		//���ع㲥�޷�ͨ����̬ע��ķ�ʽ�����գ���Ϊֻ���ڳ��������������ʹ��
		intentFilter.addAction("com.test.broadcast.LOCAL_BROADCAST");
		localReceiver = new LocalReceiver();
		//ע�᱾�ع㲥������
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
			Toast.makeText(context, "received local broadcast(���յ����ع㲥)", Toast.LENGTH_SHORT).show();
		}
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b3_localhost:
			
			Intent intent = new Intent("com.test.broadcast.LOCAL_BROADCAST");
			//���ͱ��ع㲥
			localBroadcastManager.sendBroadcast(intent);
			
			break;

		default:
			break;
		}
	}
}
