package com.example.pdfreader;

import net.sf.andpdf.pdfviewer.PdfViewerActivity;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class BeginnerActivity extends Activity {
	ListView chptList;
	String[] chapterList = { "Chapter-1", "Chapter-2" };
	ListAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);

		chptList = (ListView) findViewById(R.id.chpt_list);
		adapter = new ListAdapter();
		chptList.setAdapter(adapter);

		chptList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				// TODO Auto-generated method stub

				Uri path = Uri
						.parse("android.resource://com.example.pdfreader/raw/chap"
								+ (position + 1) + ".pdf");
				// File file = new File(path);
				try {
					Intent intent = new Intent(BeginnerActivity.this,
							CommonPDFActivity.class);
					intent.putExtra(PdfViewerActivity.EXTRA_PDFFILENAME,
					/*
					 * "file:///android_asset/chap" + (position + 1) + ".pdf"
					 */path.toString()
					/*
					 * "android.resource://com.example.pdfreader/" + R.raw.chap1
					 */);
					startActivity(intent);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	class ListAdapter extends BaseAdapter {
		LayoutInflater mInflater;

		public ListAdapter() {
			super();
			mInflater = (LayoutInflater) BeginnerActivity.this
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return chapterList.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub

			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.list_item, null);
			}
			((TextView) convertView.findViewById(R.id.chptName))
					.setText(chapterList[position]);
			return convertView;
		}
	}
}