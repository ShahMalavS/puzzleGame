package com.example.puzzlegame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CustomImg extends ActionBarActivity
{
	Button threeb,fourb,fiveb;
	ImageView img;
	final Context context = this;
	public static String filename = "MySharedString";
	SharedPreferences someData;
	String path;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.customimg);
		path = getIntent().getExtras().getString("Path");
		ImageView imageView = (ImageView) findViewById(R.id.im);
		imageView.setVisibility(View.VISIBLE);
		imageView.setImageBitmap(BitmapFactory.decodeFile(path));
		threeb = (Button) findViewById(R.id.threeb);
		fourb = (Button) findViewById(R.id.fourb);
		fiveb = (Button) findViewById(R.id.fiveb);
		
		threeb.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				Intent i = new Intent(CustomImg.this,CustomMaze3.class);
				i.putExtra("Path", path);
				startActivity(i);
			}
		});
		
		fourb.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				Intent i = new Intent(CustomImg.this,CustomMaze4.class);
				i.putExtra("Path", path);
				startActivity(i);
			}
		});
		
		fiveb.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				Intent i= new Intent(getApplicationContext(),CustomMaze.class);
				 // potentially add data to the intent
			//	 i.putExtra("Maze",  "5");
				 i.putExtra("Path", path);
				 startActivity(i);
			}
		});
	}
}