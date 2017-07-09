package com.example.puzzlegame;

import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends ActionBarActivity 
{
	ImageView p1,p2,p3,p4,p5,p6,p7,p8,p9,p,ssss;
	LinearLayout l1,l2,l3;
	ToggleButton tb;
	Thread timer;
	TextView tscore,t;
	Button ans,score,move,restart;
	ImageButton left,right;
	ArrayList<Bitmap> imageChunks;
	int blank = 9, x1, flag=0, sound,s=1,y1,worse;
	int[] a = new int[20];
	String x,level,wors="000",y;
	final Context context = this;
	public static String filename = "MySharedString";
	SharedPreferences someData;
	//MediaPlayer mp;
	SoundPool sp;
	int  i = 0, j = 0;
	Chronometer chronometer;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		someData = getSharedPreferences(filename, 0);
	//	mp = MediaPlayer.create(this, R.raw.click);
		sp = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
		sound = sp.load(this, R.raw.click, 1);
		if (someData.contains("sound"))
	   	{
			s = Integer.parseInt((someData.getString("sound", "")));
			if(s==1)
			{
				sound = sp.load(this, R.raw.click, 1);
			}
			else
			{
				sound = sp.load(this, R.raw.novoice, 1);
			}
		}		
		ans = (Button) findViewById(R.id.ans);
		score = (Button) findViewById(R.id.score);
		tscore = (TextView) findViewById(R.id.tscore);
		right = (ImageButton) findViewById(R.id.right);
		left = (ImageButton) findViewById(R.id.left);
		p1 = (ImageView) findViewById(R.id.part1);
		p2 = (ImageView) findViewById(R.id.part2);
		p3 = (ImageView) findViewById(R.id.part3);
		p4 = (ImageView) findViewById(R.id.part4);
		p5 = (ImageView) findViewById(R.id.part5);
		p6 = (ImageView) findViewById(R.id.part6);
		p7 = (ImageView) findViewById(R.id.part7);
		p8 = (ImageView) findViewById(R.id.part8);
		p9 = (ImageView) findViewById(R.id.part9);
		p = (ImageView) findViewById(R.id.image);
		ssss = (ImageView) findViewById(R.id.ssss);
		restart = (Button) findViewById(R.id.restart);
		l1 = (LinearLayout) findViewById(R.id.l1);
		l2 = (LinearLayout) findViewById(R.id.l2);
		l3 = (LinearLayout) findViewById(R.id.l3);
		t = (TextView) findViewById(R.id.textView1);
		SharedPreferences.Editor editor = someData.edit();
		chronometer = (Chronometer) findViewById(R.id.chronometer1);

		right.setBackgroundResource(R.drawable.ic_action_name1);
		left.setBackgroundResource(R.drawable.ic_action_name);	
	
		if (someData.contains("level"))
	   	{
	     	    level = someData.getString("level", "");
		}
		else
		{
			level = "1";
     	    editor.putString("level", "1");
			editor.commit();
		}
		
		if(level.equals("1"))
		{
		//	p.setBackgroundResource(R.drawable.level1);
			p.setImageDrawable(getResources().getDrawable(R.drawable.level1));
			left.setVisibility(View.GONE);
			right.setVisibility(View.VISIBLE);
			if (someData.contains("sharedString_1"))
	   		{
	   	  	    tscore.setText(someData.getString("sharedString_1", ""));
	    	}
			if (someData.contains("number_1") && someData.contains("average_1"))
	   		{
	    	}
			else
			{
				editor.putString("number_1", "0");
				editor.putString("average_1", "0");
			}
			t.setText("Maze 1 : Numbers");
			Log.d("1","1");
		}
		else if(level.equals("2"))
		{
			Log.d("3","3");
			p.setBackgroundResource(R.drawable.level2);
			p.setImageDrawable(getResources().getDrawable(R.drawable.level2));
			left.setVisibility(View.VISIBLE);
			right.setVisibility(View.VISIBLE);
			if (someData.contains("sharedString_2"))
	   		{
	   	  	    tscore.setText(someData.getString("sharedString_2", ""));
	    	}
			if (someData.contains("number_2") && someData.contains("average_2"))
	   		{
	    	}
			else
			{
				editor.putString("number_2", "0");
				editor.putString("average_2", "0");
			}
			t.setText("Maze 2 : Barbie");
		}
		else if(level.equals("3"))
		{
			p.setBackgroundResource(R.drawable.level3);
			p.setImageDrawable(getResources().getDrawable(R.drawable.level3));
			left.setVisibility(View.VISIBLE);
			right.setVisibility(View.VISIBLE);
			if (someData.contains("sharedString_3"))
	   		{
	   	  	    tscore.setText(someData.getString("sharedString_3", ""));
	    	}
			if (someData.contains("number_3") && someData.contains("average_3"))
	   		{
	    	}
			else
			{
				editor.putString("number_3", "0");
				editor.putString("average_3", "0");
			}
			t.setText("Maze 3 : Doraemon");
		}
		else if(level.equals("4"))
		{
			p.setBackgroundResource(R.drawable.level4);
			p.setImageDrawable(getResources().getDrawable(R.drawable.level4));
			left.setVisibility(View.VISIBLE);
			right.setVisibility(View.VISIBLE);
			if (someData.contains("sharedString_4"))
	   		{
	   	  	    tscore.setText(someData.getString("sharedString_4", ""));
	    	}
			if (someData.contains("number_4") && someData.contains("average_4"))
	   		{
	    	}
			else
			{
				editor.putString("number_4", "0");
				editor.putString("average_4", "0");
			}
			t.setText("Maze 4 : Fish");
		}
		else if(level.equals("5"))
		{
			p.setBackgroundResource(R.drawable.level5);
			p.setImageDrawable(getResources().getDrawable(R.drawable.level5));
			left.setVisibility(View.VISIBLE);
			right.setVisibility(View.VISIBLE);
			if (someData.contains("sharedString_5"))
	   		{
	   	  	    tscore.setText(someData.getString("sharedString_5", ""));
	    	}
			if (someData.contains("number_5") && someData.contains("average_5"))
	   		{
	    	}
			else
			{
				editor.putString("number_5", "0");
				editor.putString("average_5", "0");
			}
			t.setText("Maze 5 : Flower");
		}
		else if(level.equals("6"))
		{
			p.setBackgroundResource(R.drawable.level6);
			p.setImageDrawable(getResources().getDrawable(R.drawable.level6));
			left.setVisibility(View.VISIBLE);
			right.setVisibility(View.VISIBLE);
			if (someData.contains("sharedString_6"))
	   		{
	   	  	    tscore.setText(someData.getString("sharedString_6", ""));
	    	}
			if (someData.contains("number_6") && someData.contains("average_6"))
	   		{
	    	}
			else
			{
				editor.putString("number_6", "0");
				editor.putString("average_6", "0");
			}
			t.setText("Maze 6 : Koala Beer");
		}
		else if(level.equals("7"))
		{
			p.setBackgroundResource(R.drawable.level7);
			p.setImageDrawable(getResources().getDrawable(R.drawable.level7));
			left.setVisibility(View.VISIBLE);
			right.setVisibility(View.VISIBLE);
			if (someData.contains("sharedString_7"))
	   		{
	   	  	    tscore.setText(someData.getString("sharedString_7", ""));
	    	}
			if (someData.contains("number_7") && someData.contains("average_7"))
	   		{
	    	}
			else
			{
				editor.putString("number_7", "0");
				editor.putString("average_7", "0");
			}
			t.setText("Maze 7 : Penguin");
		}

		else if(level.equals("8"))
		{
			p.setBackgroundResource(R.drawable.level8);
			p.setImageDrawable(getResources().getDrawable(R.drawable.level8));
			left.setVisibility(View.VISIBLE);
			right.setVisibility(View.GONE);
			if (someData.contains("sharedString_8"))
	   		{
	   	  	    tscore.setText(someData.getString("sharedString_8", ""));
	    	}
			if (someData.contains("number_8") && someData.contains("average_8"))
	   		{
	    	}
			else
			{
				editor.putString("number_8", "0");
				editor.putString("average_8", "0");
			}
			t.setText("Maze 8 : Tulips");
		}
		editor.commit();
		
		Log.d("1","1");
		
		p.setOnClickListener(new ImageView.OnClickListener()
		{

			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				allocateimage();
				Log.d("4","4");
				flag=1;
				x1=0;
				ans.setText(Integer.toString(x1));
				blank=9;
			}
		});
		
		right.setOnClickListener(new ImageButton.OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub	
				SharedPreferences.Editor editor = someData.edit();
				Log.d("5","5");
				String temp = someData.getString("level", "");
				int x = Integer.parseInt(temp);
				x++;
				temp = Integer.toString(x);
				editor.putString("level", temp);
				editor.commit();
				Log.d("6","6");
				Intent i = new Intent(MainActivity.this,MainActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		left.setOnClickListener(new ImageButton.OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,MainActivity.class);	
				SharedPreferences.Editor editor = someData.edit();
				String temp = someData.getString("level", "");
				int x = Integer.parseInt(temp);
				x--;
				temp = Integer.toString(x);
				editor.putString("level", temp);
				editor.commit();
				startActivity(i);
				finish();
			}
		});

		restart.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				allocateimage();
				x1=0;
				ans.setText(Integer.toString(x1));
				blank=9;
			}
		});
		
        p1.setOnClickListener(new ImageView.OnClickListener() 
        {
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				//mp.start();
				sp.play(sound, 1, 1, 0, 0, 1);
				if(blank==4)
				{
					slide(p1,p4,1);
				}
				else if(blank==2)
				{	
					slide(p1,p2,1);
				}
				else
				{
					Toast.makeText(MainActivity.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
				}			
			}
		});
        
        p2.setOnClickListener(new ImageView.OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				//mp.start();
				sp.play(sound, 1, 1, 0, 0, 1);
				if(blank==1)
				{
					slide(p2,p1,2);
				}
				else if(blank==3)
				{
					slide(p2,p3,2);
				}
				else if(blank==5)
				{
					slide(p2,p5,2);
				}
				else
				{
					Toast.makeText(MainActivity.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
        p3.setOnClickListener(new ImageView.OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				//mp.start();
				sp.play(sound, 1, 1, 0, 0, 1);
				if(blank==2)
				{
					slide(p3,p2,3);
				}
				else if(blank==6)
				{
					slide(p3,p6,3);
				}
				else
				{
					Toast.makeText(MainActivity.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
				}
			}
		});
        
        p4.setOnClickListener(new ImageView.OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				//mp.start();
				sp.play(sound, 1, 1, 0, 0, 1);
				if(blank==1)
				{
					slide(p4,p1,4);
				}
				else if(blank==7)
				{
					slide(p4,p7,4);
				}
				else if(blank==5)
				{
					slide(p4,p5,4);
				}
				else
				{
					Toast.makeText(MainActivity.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
				}
			}
		});
        
        p5.setOnClickListener(new ImageView.OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				//mp.start();
				sp.play(sound, 1, 1, 0, 0, 1);
				if(blank==2)
				{
					slide(p5,p2,5);
				}
				else if(blank==4)
				{
					slide(p5,p4,5);
				}
				else if(blank==6)
				{
					slide(p5,p6,5);
				}
				else if(blank==8)
				{
					slide(p5,p8,5);
				}
				else
				{
					Toast.makeText(MainActivity.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
				}
			}
		});
        
        p6.setOnClickListener(new ImageView.OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				//mp.start();
				sp.play(sound, 1, 1, 0, 0, 1);
				if(blank==9)
				{
					slide(p6,p9,6);
				}
				else if(blank==3)
				{
					slide(p6,p3,6);
				}
				else if(blank==5)
				{
					slide(p6,p5,6);
				}
				else
				{
					Toast.makeText(MainActivity.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
				}
			}
		});
        
        p7.setOnClickListener(new ImageView.OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				//mp.start();
				sp.play(sound, 1, 1, 0, 0, 1);
				if(blank==4)
				{
					slide(p7,p4,7);
				}
				else if(blank==8)
				{
					slide(p7,p8,7);
				}
				else
				{
					Toast.makeText(MainActivity.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
				}
			}
		});
        
        p8.setOnClickListener(new ImageView.OnClickListener() 
        {
			@Override		
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				//mp.start();
				sp.play(sound, 1, 1, 0, 0, 1);
				if(blank==7)
				{
					slide(p8,p7,8);
				}
				else if(blank==9)
				{
					slide(p8,p9,8);
				}
				else if(blank==5)
				{
					slide(p8,p5,8);
				}
				else
				{
					Toast.makeText(MainActivity.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
				}
			}
		});
        
        p9.setOnClickListener(new ImageView.OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
			//	mp.start();
				sp.play(sound, 1, 1, 0, 0, 1);
				if(blank==6)
				{
					slide(p9,p6,9);
				}
				else if(blank==8)
				{		
					slide(p9,p8,9);
				}
				else
				{
					Toast.makeText(MainActivity.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
				}
			}
		});		
	}
	
	/*protected void time() 
	{
		// TODO Auto-generated method stub
		TextView time = (TextView) findViewById(R.id.time);
		time.setText(Integer.toString(i2));
	}*/

	protected void slide(ImageView p92, ImageView p82, int i) 
	{
		// TODO Auto-generated method stub
		p82.setImageDrawable(p92.getDrawable());
		p92.setImageDrawable(getResources().getDrawable(R.drawable.blank1));
		blank=i;
		moves();
		gameover();
	}

	protected void moves()
	{
		// TODO Auto-generated method stub
		x = ans.getText().toString();
		x1 = Integer.parseInt(x);
		x1++;
		ans.setText(Integer.toString(x1));	
	}
	
	private void gameover() 
	{
		// TODO Auto-generated method stub				
		ssss.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(0)));
		if (((BitmapDrawable) p1.getDrawable()).getBitmap()==((BitmapDrawable)ssss.getDrawable()).getBitmap())
		{
			ssss.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(1)));
			if (((BitmapDrawable) p2.getDrawable()).getBitmap()==((BitmapDrawable)ssss.getDrawable()).getBitmap())
			{
				ssss.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(2)));
				if (((BitmapDrawable) p3.getDrawable()).getBitmap()==((BitmapDrawable)ssss.getDrawable()).getBitmap())
				{	
					ssss.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(3)));
					if (((BitmapDrawable) p4.getDrawable()).getBitmap()==((BitmapDrawable)ssss.getDrawable()).getBitmap())
					{
						ssss.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(4)));
						if (((BitmapDrawable) p5.getDrawable()).getBitmap()==((BitmapDrawable)ssss.getDrawable()).getBitmap())
						{
							ssss.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(5)));
							if (((BitmapDrawable) p6.getDrawable()).getBitmap()==((BitmapDrawable)ssss.getDrawable()).getBitmap())
							{
								ssss.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(6)));
								if (((BitmapDrawable) p7.getDrawable()).getBitmap()==((BitmapDrawable)ssss.getDrawable()).getBitmap())
								{
									ssss.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(7)));
									if (((BitmapDrawable) p8.getDrawable()).getBitmap()==((BitmapDrawable)ssss.getDrawable()).getBitmap())
									{
										chronometer.stop();
										CharSequence t = chronometer.getText();
										String time = t.toString();
									//	int iiii = Integer.parseInt(time);
										Log.e("time", time);
										SharedPreferences.Editor editor = someData.edit();
										int number, average=0,total;
										
										x = ans.getText().toString();
										String xx = tscore.getText().toString();
										int yy = Integer.parseInt(xx);
										final GameComplete md = new GameComplete(this);
										md.setContentView(R.layout.game_complete);
										md.setTitle("Puzzle Solved");
										TextView timecurrent = (TextView) md.findViewById(R.id.timecurrent);
										timecurrent.setText(t);
										ImageView s1 = (ImageView) md.findViewById(R.id.star1);
										ImageView s2 = (ImageView) md.findViewById(R.id.star2);
										ImageView s3 = (ImageView) md.findViewById(R.id.star3);
										if(x1<=30)
										{
											s1.setBackgroundResource(R.drawable.star);
											s3.setBackgroundResource(R.drawable.star);
											s2.setBackgroundResource(R.drawable.star);
										}
										else if(x1<=40)
										{
											s2.setBackgroundResource(R.drawable.star);
											s1.setBackgroundResource(R.drawable.star);
										}
										else if(x1<=50)
										{
											s1.setBackgroundResource(R.drawable.star);
										}
										TextView tt = (TextView) md.findViewById(R.id.text);
										Log.e("0","0");
										if(x1<yy || yy==000)
										{
											if(level.equals("1"))
											{
												editor.putString("sharedString_1", x);
											}
											else if(level.equals("2"))
											{
												editor.putString("sharedString_2", x);
											}
											else if(level.equals("3"))
											{
												editor.putString("sharedString_3", x);
											}
											else if(level.equals("4"))
											{
												editor.putString("sharedString_4", x);
											}
											else if(level.equals("5"))
											{
												editor.putString("sharedString_5", x);
											}
											else if(level.equals("6"))
											{
												editor.putString("sharedString_6", x);
											}
											else if(level.equals("7"))
											{
												editor.putString("sharedString_7", x);
											}
											else if(level.equals("8"))
											{
												editor.putString("sharedString_8", x);
											}
											editor.commit();
											tscore.setText(x);
											tt.setVisibility(View.VISIBLE);
											xx=Integer.toString(x1);
										}
										Log.e("1","1");
										TextView ansmoves = (TextView) md.findViewById(R.id.ansmoves);
										ansmoves.setText(x);
										TextView best = (TextView) md.findViewById(R.id.best);
										best.setText(xx);
										TextView worst = (TextView) md.findViewById(R.id.worst);
										
										if(level.equals("1"))
										{
											number = Integer.parseInt(someData.getString("number_1", ""));
											Log.e("39","39");
											average = Integer.parseInt(someData.getString("average_1", ""));
											total = number * average + x1;
											number++;
											Log.e("49","49");
											average = total/number;
											editor.putString("number_1", Integer.toString(number));
											Log.e("59","59");
											editor.putString("average_1", Integer.toString(average));
											editor.putString("t_current_1", time);
											
											if (someData.contains("worst_1"))
										   	{
												wors = someData.getString("worst_1", "");
												worse = Integer.parseInt(wors);
											}
										}
										else if(level.equals("2"))
										{
											number = Integer.parseInt(someData.getString("number_2", ""));
											average = Integer.parseInt(someData.getString("average_2", ""));
											total = number * average + x1;
											number++;
											average = total/number;
											editor.putString("number_2", Integer.toString(number));
											editor.putString("average_2", Integer.toString(average));
											if (someData.contains("worst_2"))
										   	{
												wors = someData.getString("worst_2", "");
												worse = Integer.parseInt(wors);
											}
										}
										else if(level.equals("3"))
										{
											number = Integer.parseInt(someData.getString("number_3", ""));
											average = Integer.parseInt(someData.getString("average_3", ""));
											total = number * average + x1;
											number++;
											average = total/number;
											editor.putString("number_3", Integer.toString(number));
											editor.putString("average_3", Integer.toString(average));
											if (someData.contains("worst_3"))
										   	{
												wors = someData.getString("worst_3", "");
												worse = Integer.parseInt(wors);
											}
										}
										else if(level.equals("4"))
										{
											number = Integer.parseInt(someData.getString("number_4", ""));
											average = Integer.parseInt(someData.getString("average_4", ""));
											total = number * average + x1;
											number++;
											average = total/number;
											editor.putString("number_4", Integer.toString(number));
											editor.putString("average_4", Integer.toString(average));
											if (someData.contains("worst_4"))
										   	{
												wors = someData.getString("worst_4", "");
												worse = Integer.parseInt(wors);
											}
										}
										else if(level.equals("5"))
										{
											number = Integer.parseInt(someData.getString("number_5", ""));
											average = Integer.parseInt(someData.getString("average_5", ""));
											total = number * average + x1;
											number++;
											average = total/number;
											editor.putString("number_5", Integer.toString(number));
											editor.putString("average_5", Integer.toString(average));
											if (someData.contains("worst_5"))
										   	{
												wors = someData.getString("worst_5", "");
												worse = Integer.parseInt(wors);
											}
										}
										else if(level.equals("6"))
										{
											number = Integer.parseInt(someData.getString("number_6", ""));
											average = Integer.parseInt(someData.getString("average_6", ""));
											total = number * average + x1;
											number++;
											average = total/number;
											editor.putString("number_6", Integer.toString(number));
											editor.putString("average_6", Integer.toString(average));
											if (someData.contains("worst_6"))
										   	{
												wors = someData.getString("worst_6", "");
												worse = Integer.parseInt(wors);
											}
										}
										else if(level.equals("7"))
										{
											number = Integer.parseInt(someData.getString("number_7", ""));
											average = Integer.parseInt(someData.getString("average_7", ""));
											total = number * average + x1;
											number++;
											average = total/number;
											editor.putString("number_7", Integer.toString(number));
											editor.putString("average_7", Integer.toString(average));
											if (someData.contains("worst_7"))
										   	{
												wors = someData.getString("worst_7", "");
												worse = Integer.parseInt(wors);
											}
										}
										else if(level.equals("8"))
										{
											number = Integer.parseInt(someData.getString("number_8", ""));
											average = Integer.parseInt(someData.getString("average_8", ""));
											total = number * average + x1;
											number++;
											average = total/number;
											editor.putString("number_8", Integer.toString(number));
											editor.putString("average_8", Integer.toString(average));
											if (someData.contains("worst_8"))
										   	{
												wors = someData.getString("worst_8", "");
												worse = Integer.parseInt(wors);
											}
										}
										Log.e("19","19");
										TextView Average = (TextView) md.findViewById(R.id.average);
										Average.setText(Integer.toString(average));
										Log.e("29","29");
										if(x1>worse || worse==000)
										{
											if(level.equals("1"))
											{
												editor.putString("worst_1", x);
												worse=x1;
											}
											else if(level.equals("2"))
											{
												editor.putString("worst_2", x);
												worse=x1;
											}
											else if(level.equals("3"))
											{
												editor.putString("worst_3", x);
												worse=x1;
											}
											else if(level.equals("4"))
											{
												editor.putString("worst_4", x);
												worse=x1;
											}
											else if(level.equals("5"))
											{
												editor.putString("worst_5", x);
												worse=x1;
											}
											else if(level.equals("6"))
											{
												editor.putString("worst_6", x);
												worse=x1;
											}
											else if(level.equals("7"))
											{
												editor.putString("worst_7", x);
												worse=x1;
											}
											else if(level.equals("8"))
											{
												editor.putString("worst_8", x);
												worse=x1;
											}
											editor.commit();
										}
										wors = Integer.toString(worse);
										worst.setText(wors);
										Button playagain = (Button) md.findViewById(R.id.play);
										playagain.setOnClickListener(new Button.OnClickListener()
										{
											@Override
											public void onClick(View v) 
											{
												// TODO Auto-generated method stub
												allocateimage();
												x1=0;
												ans.setText(Integer.toString(x1));
												blank=9;
												md.dismiss();
											}
										});
										Button menu = (Button) md.findViewById(R.id.menu);
										menu.setOnClickListener(new Button.OnClickListener()
										{
											@Override
											public void onClick(View v) 
											{
												// TODO Auto-generated method stub
												Intent i = new Intent(MainActivity.this,FirstActivity.class);
												startActivity(i);
												md.dismiss();
												finish();
											}
										});
										/*TextView timecurrent = (TextView) md.findViewById(R.id.timecurrent);
										timecurrent.setText(Integer.toString(i));*/
										Button next = (Button) md.findViewById(R.id.next);
										next.setOnClickListener(new Button.OnClickListener()
										{
											@Override
											public void onClick(View v) 
											{
												// TODO Auto-generated method stub
												SharedPreferences.Editor editor = someData.edit();
												String temp = someData.getString("level", "");
												int x = Integer.parseInt(temp);
												if(x<8)
												{
													x++;
													temp = Integer.toString(x);
													editor.putString("level", temp);
													editor.commit();
													Intent i = new Intent(MainActivity.this,MainActivity.class);
													startActivity(i);
													md.dismiss();
													finish();
												}
												else
												{
													temp="1";
													editor.putString("level", temp);
													editor.putString("level44", temp);
													editor.commit();
													Intent i = new Intent(MainActivity.this,MainActivity44.class);
													startActivity(i);
													md.dismiss();
													finish();	
												}
												
											}
										});
										md.show();
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private void allocateimage() 
	{
		// TODO Auto-generated method stub
		
		p.setVisibility(View.GONE);
		tscore.setVisibility(View.GONE);
		right.setVisibility(View.GONE);
		left.setVisibility(View.GONE);
		score.setVisibility(View.GONE);
		l1.setVisibility(View.VISIBLE);
		l2.setVisibility(View.VISIBLE);
		l3.setVisibility(View.VISIBLE);
		ans.setVisibility(View.VISIBLE);
		restart.setVisibility(View.VISIBLE);	
		chronometer.setVisibility(View.VISIBLE);
		splitImage sp = new splitImage();
		imageChunks = sp.split(p,9);
		
		Random r = new Random();
		int i = r.nextInt(9);
		
	/*	int k=-1,omg=0,flagallocate=1;
		while(k<7)
		{
			flagallocate=1;
			omg = r.nextInt(8);
			for(int j = 0; j <= k;j++)
			{
				if((omg+1)==a[j])
				{
					flagallocate=0;
					break;
				}
			}
			if(flagallocate==1)
			{
				k++;
				a[k] = omg+1;
			}
		}
		image(a[0],a[1],a[2],a[3],a[4],a[5],a[6],a[7]);
		*/
		
		if(i==0)
		{
			image(4,3,8,1,7,5,2,6);
		}
		else if(i==1)
		{
			image(2,4,8,5,7,3,1,6);
		}
		else if(i==2)
		{
			image(8,1,2,6,5,7,3,4);
		}
		else if(i==3)
		{
			image(5,1,4,7,8,2,3,6);
		}
		else if(i==4)
		{
			image(2,3,7,6,1,5,4,8);
		}
		else if(i==5)
		{
			image(1,8,4,3,6,2,7,5);
		}
		else if(i==6)
		{
			image(7,6,1,4,2,5,3,8);
		}
		else if(i==7)
		{
			image(4,3,8,7,5,2,6,1);
		}
		else if(i==8)
		{
			image(5,6,8,1,2,7,4,3);
		}
		else
		{
			image(5,6,8,4,1,7,2,3);
		}
	}
	
	private void image(int i, int j, int k, int l,int m, int n, int o, int p) 
	{
		// TODO Auto-generated method stub
		p1.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(i-1)));
		p2.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(j-1)));
		p3.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(k-1)));
		p4.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(l-1)));
		p5.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(m-1)));
		p6.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(n-1)));
		p7.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(o-1)));
		p8.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(p-1)));
		p9.setImageDrawable(getResources().getDrawable(R.drawable.blank1));
		chronometer.setBase(SystemClock.elapsedRealtime());
		chronometer.start();
	}
	
    @Override
    public void onBackPressed()
    {
      if(flag==0)
      {
    	  finish();
    	  sp.release();
      }
      else
      {
  		p.setVisibility(View.VISIBLE);
  		tscore.setVisibility(View.VISIBLE);
  		if(level.equals("1"))
  		{
  		}
  		else
  		{
  			left.setVisibility(View.VISIBLE);
  		}
  		if(level.equals("8"))
  		{
  		}
  		else
  		{
  			right.setVisibility(View.VISIBLE);
  		}
  		score.setVisibility(View.VISIBLE);
  		l3.setVisibility(View.GONE);
  		l2.setVisibility(View.GONE);
  		l1.setVisibility(View.GONE);
  		ans.setVisibility(View.GONE);
  		restart.setVisibility(View.GONE);
  		chronometer.setVisibility(View.GONE);
  		flag=0;
      }   
    }
}