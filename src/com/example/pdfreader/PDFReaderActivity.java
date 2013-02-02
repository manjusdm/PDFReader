package com.example.pdfreader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PDFReaderActivity extends Activity implements OnClickListener {
	Button btnBegin, btnInter, btnAdvance;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		btnBegin = (Button) findViewById(R.id.btnBegin);
		btnBegin.setOnClickListener(this);
		btnInter = (Button) findViewById(R.id.btnInter);
		btnInter.setOnClickListener(this);
		btnAdvance = (Button) findViewById(R.id.btnAdvance);
		btnAdvance.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnBegin:
			System.out.println("HI");
			Intent intent = new Intent(this, BeginnerActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case R.id.btnInter:
			break;
		case R.id.btnAdvance:
			break;
		}
	}
}