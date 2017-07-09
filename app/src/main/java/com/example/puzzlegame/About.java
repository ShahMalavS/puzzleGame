package com.example.puzzlegame;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

public class About extends Dialog
{
	Context context;
	public About(Context c) 
	{
		// TODO Auto-generated constructor stub
		super(c);
	}
	
	protected void onCreate(Bundle savedInstanceState, final Context context) 
	{
		super.onCreate(savedInstanceState);
	//	requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.about);
	}
}
