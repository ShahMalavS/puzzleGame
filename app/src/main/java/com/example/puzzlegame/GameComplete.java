package com.example.puzzlegame;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

public class GameComplete extends Dialog
{
	Context context;
	public GameComplete(Context c) 
	{
		// TODO Auto-generated constructor stub
		super(c);
	}
	

	Button play;	
	
	protected void onCreate(Bundle savedInstanceState, final Context context) 
	{
		super.onCreate(savedInstanceState);
	//	requestWindowFeature(Window.FEATURE_NO_TITLE);
		

	}
}
