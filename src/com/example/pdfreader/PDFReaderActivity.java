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
			Intent begin = new Intent(this, BeginnerActivity.class);
			begin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(begin);
			break;
		case R.id.btnInter:
			Intent inter = new Intent(this, IntermediateActivity.class);
			inter.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(inter);
			break;
		case R.id.btnAdvance:
			Intent adv = new Intent(this, AdvancedActivity.class);
			adv.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(adv);
			break;
		}
	}
}