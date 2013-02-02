package com.example.pdfreader;

import net.sf.andpdf.pdfviewer.PdfViewerActivity;
import android.os.Bundle;

public class CommonPDFActivity extends PdfViewerActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public int getNextPageImageResource() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPdfPageNumberEditField() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPdfPageNumberResource() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPdfPasswordEditField() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPdfPasswordExitButton() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPdfPasswordLayoutResource() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPdfPasswordOkButton() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPreviousPageImageResource() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getZoomInImageResource() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getZoomOutImageResource() {
		// TODO Auto-generated method stub
		return 0;
	}

}
