package com.example.chapter05.close;

import com.example.chapter05.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TestLoginActivity extends BaseActivity implements OnClickListener {
	private EditText accountEdit;
	private EditText passwordEdit;
	private Button login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.b4_login);
		accountEdit = (EditText) findViewById(R.id.login_account);
		passwordEdit = (EditText) findViewById(R.id.login_password);
		login = (Button) findViewById(R.id.b4_login);
		login.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b4_login:
			String account = accountEdit.getText().toString();
			String password = passwordEdit.getText().toString();
			// 如果帐号是admin且密码是123456，就认为登录成功
			if (account.equals("admin") && password.equals("123456")) {
				Intent intent = new Intent(TestLoginActivity.this,
						TestForceOffline.class);
				startActivity(intent);
//				finish();
			} else {
				Toast.makeText(TestLoginActivity.this,
						"account or password is invalid(帐号或密码错误)", Toast.LENGTH_SHORT)
						.show();
			}

			break;

		default:
			break;
		}
	}

}
