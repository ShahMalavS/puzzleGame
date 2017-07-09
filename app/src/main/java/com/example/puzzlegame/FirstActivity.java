package com.example.puzzlegame;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class FirstActivity extends ActionBarActivity
{
	Button play, about,exit,sound,help,reset;
	ImageView title;
	String i="1",tb="on";
	final Context context = this;
	public static String filename = "MySharedString";
	SharedPreferences someData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity1);
		
		play = (Button) findViewById(R.id.play);
		exit = (Button) findViewById(R.id.exit);
		about = (Button) findViewById(R.id.about);
		title = (ImageView) findViewById(R.id.title);
		help = (Button) findViewById(R.id.help);
		sound = (Button) findViewById(R.id.sound);
		reset = (Button) findViewById(R.id.reset);
		
		someData = getSharedPreferences(filename, 0);
		if (someData.contains("sound"))
	    {
	         i = someData.getString("sound", "");
	         if(i.equals("1"))
	         {
	        	 tb = "on";
	        	 sound.setBackgroundResource(R.drawable.sound);
	         }
	         else
	         {
	        	 tb = "off";
	        	 sound.setBackgroundResource(R.drawable.soundm);
	         }
	    }
		
		play.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				Intent i = new Intent(FirstActivity.this,MazeSelect.class);
				startActivity(i);
			}
		});
		
		exit.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				finish();
				
			}
		});	
		
		sound.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
						SharedPreferences.Editor editor = someData.edit();
						String s = tb;
						if(s.equals("on"))
						{
							editor.putString("sound", "0");
							tb = "off";
							sound.setBackgroundResource(R.drawable.soundm);
							Toast.makeText(FirstActivity.this,"Sound is turned OFF", Toast.LENGTH_SHORT).show();
						}
						else
						{
							editor.putString("sound", "1");
							tb = "on";
							sound.setBackgroundResource(R.drawable.sound);
							Toast.makeText(FirstActivity.this,"Sound is turned ON", Toast.LENGTH_SHORT).show();
						}
						editor.commit();	
					}
		});
		
		about.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				final About ab = new About(context);
				ab.setContentView(R.layout.about);
				ab.setTitle("About Us");
				ab.show();
			}
		});
		
		reset.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				SharedPreferences.Editor editor = someData.edit();

				editor.putString("level", "1");	
				editor.putString("level44", "1");	
				editor.putString("level444", "1");
				
				editor.putString("sharedString_1", "000");	
				editor.putString("sharedString_2", "000");	
				editor.putString("sharedString_3", "000");	
				editor.putString("sharedString_4", "000");	//3*3 best score
				editor.putString("sharedString_5", "000");	
				editor.putString("sharedString_6", "000");	
				editor.putString("sharedString_7", "000");	
				editor.putString("sharedString_8", "000");
				editor.putString("worst_1", "000");	
				editor.putString("worst_2", "000");	
				editor.putString("worst_3", "000");	
				editor.putString("worst_4", "000");	//3*3 worst score
				editor.putString("worst_5", "000");	
				editor.putString("worst_6", "000");	
				editor.putString("worst_7", "000");	
				editor.putString("worst_8", "000");
				editor.putString("average_1", "000");	
				editor.putString("average_2", "000");	
				editor.putString("average_3", "000");	
				editor.putString("average_4", "000");	//3*3 average score
				editor.putString("average_5", "000");	
				editor.putString("average_6", "000");	
				editor.putString("average_7", "000");	
				editor.putString("average_8", "000");
				editor.putString("number_1", "000");	
				editor.putString("number_2", "000");	
				editor.putString("number_3", "000");	
				editor.putString("number_4", "000");	//3*3 number of games played
				editor.putString("number_5", "000");	
				editor.putString("number_6", "000");	
				editor.putString("number_7", "000");	
				editor.putString("number_8", "000");
				editor.putString("t_current_1", "000");	
				editor.putString("t_current_2", "000");	
				editor.putString("t_current_3", "000");	
				editor.putString("t_current_4", "000");	//3*3 best score
				editor.putString("t_current_5", "000");	
				editor.putString("t_current_6", "000");	
				editor.putString("t_current_7", "000");	
				editor.putString("t_current_8", "000");
				editor.putString("t_worst_1", "000");	
				editor.putString("t_worst_2", "000");	
				editor.putString("t_worst_3", "000");	
				editor.putString("t_worst_4", "000");	//3*3 t_worst score
				editor.putString("t_worst_5", "000");	
				editor.putString("t_worst_6", "000");	
				editor.putString("t_worst_7", "000");	
				editor.putString("t_worst_8", "000");
				editor.putString("t_average_1", "000");	
				editor.putString("t_average_2", "000");	
				editor.putString("t_average_3", "000");	
				editor.putString("t_average_4", "000");	//3*3 t_average score
				editor.putString("t_average_5", "000");	
				editor.putString("t_average_6", "000");	
				editor.putString("t_average_7", "000");	
				editor.putString("t_average_8", "000");
				
				editor.putString("sharedString44_1", "000");	
				editor.putString("sharedString44_2", "000");	
				editor.putString("sharedString44_3", "000");	
				editor.putString("sharedString44_4", "000");	//4*4
				editor.putString("sharedString44_5", "000");	
				editor.putString("sharedString44_6", "000");	
				editor.putString("sharedString44_7", "000");	
				editor.putString("sharedString44_8", "000");
				editor.putString("worst44_1", "000");	
				editor.putString("worst44_2", "000");	
				editor.putString("worst44_3", "000");	
				editor.putString("worst44_4", "000");	//4*4
				editor.putString("worst44_5", "000");	
				editor.putString("worst44_6", "000");	
				editor.putString("worst44_7", "000");	
				editor.putString("worst44_8", "000");
				editor.putString("average44_1", "000");	
				editor.putString("average44_2", "000");	
				editor.putString("average44_3", "000");	
				editor.putString("average44_4", "000");	//4*4
				editor.putString("average44_5", "000");	
				editor.putString("average44_6", "000");	
				editor.putString("average44_7", "000");	
				editor.putString("average44_8", "000");
				editor.putString("number44_1", "000");	
				editor.putString("number44_2", "000");	
				editor.putString("number44_3", "000");	
				editor.putString("number44_4", "000");	//4*4
				editor.putString("number44_5", "000");	
				editor.putString("number44_6", "000");	
				editor.putString("number44_7", "000");	
				editor.putString("number44_8", "000");
				
				editor.putString("sharedString444_1", "000");	
				editor.putString("sharedString444_2", "000");	
				editor.putString("sharedString444_3", "000");	
				editor.putString("sharedString444_4", "000");	//5*5
				editor.putString("sharedString444_5", "000");	
				editor.putString("sharedString444_6", "000");	
				editor.putString("sharedString444_7", "000");	
				editor.putString("sharedString444_8", "000");
				editor.putString("worst444_1", "000");	
				editor.putString("worst444_2", "000");	
				editor.putString("worst444_3", "000");	
				editor.putString("worst444_4", "000");	//5*5
				editor.putString("worst444_5", "000");	
				editor.putString("worst444_6", "000");	
				editor.putString("worst444_7", "000");	
				editor.putString("worst444_8", "000");
				editor.putString("average444_1", "000");	
				editor.putString("average444_2", "000");	
				editor.putString("average444_3", "000");	
				editor.putString("average444_4", "000");	//5*5
				editor.putString("average444_5", "000");	
				editor.putString("average444_6", "000");	
				editor.putString("average444_7", "000");	
				editor.putString("average444_8", "000");
				editor.putString("number444_1", "000");	
				editor.putString("number444_2", "000");	
				editor.putString("number444_3", "000");	
				editor.putString("number444_4", "000");	//5*5
				editor.putString("number444_5", "000");	
				editor.putString("number444_6", "000");	
				editor.putString("number444_7", "000");	
				editor.putString("number444_8", "000");
				
				editor.commit();
				Toast.makeText(FirstActivity.this,"Best Moves are Deleted", Toast.LENGTH_LONG).show();
			}	
		});	
		
		help.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				final Dialog ab = new Dialog(context);
				ab.setContentView(R.layout.help);
				ab.setTitle("Help");
				ab.show();
			}	
		});
		
	}
}
