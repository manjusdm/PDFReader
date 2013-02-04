package com.example.pdfreader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import net.sf.andpdf.pdfviewer.PdfViewerActivity;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
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
	String[] beginPDFNames = { "chap1.pdf", "chap2.pdf" };
	String[] categories = { "beginner", "intermediate", "advanced" };
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
				// copyFilesToSdCard();
				copyAssets();

				String path = Environment.getExternalStorageDirectory()
						+ "/chap1.pdf";
				try {
					Intent intent = new Intent(BeginnerActivity.this,
							CommonPDFActivity.class);
					intent.putExtra(PdfViewerActivity.EXTRA_PDFFILENAME,
							Environment.getExternalStorageDirectory()
									+ "/PDFReader/" + categories[0] + "/"
									+ beginPDFNames[position]);
					startActivity(intent);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void copyAssets() {
		AssetManager assetManager = getAssets();
		String[] files = null;
		for (int i = 0; i < categories.length; i++) {
			try {
				files = assetManager.list(categories[i]);
				System.out.println("files SIZE : " + files.length);
			} catch (IOException e) {
				Log.e("tag", "Failed to get asset file list.", e);
			}
			for (String filename : files) {
				InputStream in = null;
				OutputStream out = null;
				try {
					in = assetManager.open(categories[i] + "/" + filename);
					File direct = new File(
							Environment.getExternalStorageDirectory()
									+ "/PDFReader/" + categories[i]);
					System.out.println("direct : " + direct.toString());
					if (!direct.exists()) {
						if (direct.mkdirs()) // directory is created;
							System.out.println("TRUE");
						else
							System.out.println("FALSE");
					}
					System.out.println("filename : " + filename);
					File file = new File(direct, filename);
					file.createNewFile();
					out = new FileOutputStream(file);
					copyFile(in, out);
					in.close();
					in = null;
					out.flush();
					out.close();
					out = null;
				} catch (IOException e) {
					Log.e("tag", "Failed to copy asset file: " + filename, e);
				}
			}
		}
	}

	private void copyFile(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[1024];
		int read;
		while ((read = in.read(buffer)) != -1) {
			out.write(buffer, 0, read);
		}
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