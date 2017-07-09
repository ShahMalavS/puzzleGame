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

public class MainActivity44 extends ActionBarActivity 
{

	ImageView p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p,ssss;
	ToggleButton tb;
	LinearLayout l1,l2,l3,l4;
	TextView tscore,t;
	Button ans,score,move,restart;
	ArrayList<Bitmap> imageChunks;
	ImageButton left,right;
	int blank = 16, x1, flag=0, sound,s=1,worse;
	String x,level,wors="000";
	int[] a = new int[20];
	final Context context = this;
	public static String filename = "MySharedString";
	SharedPreferences someData;
	//MediaPlayer mp;
	SoundPool sp;
	Chronometer chronometer;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main44);
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
		Log.d("1","1");
		
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
		p10 = (ImageView) findViewById(R.id.part10);
		p11 = (ImageView) findViewById(R.id.part11);
		p12 = (ImageView) findViewById(R.id.part12);
		p13 = (ImageView) findViewById(R.id.part13);
		p14 = (ImageView) findViewById(R.id.part14);
		p15 = (ImageView) findViewById(R.id.part15);
		p16 = (ImageView) findViewById(R.id.part16);
		ssss = (ImageView) findViewById(R.id.ssss);
		p = (ImageView) findViewById(R.id.image);
		restart = (Button) findViewById(R.id.restart);
		l1 = (LinearLayout) findViewById(R.id.l1);
		l2 = (LinearLayout) findViewById(R.id.l2);
		l3 = (LinearLayout) findViewById(R.id.l3);
		l4 = (LinearLayout) findViewById(R.id.l4);
		t = (TextView) findViewById(R.id.textView1);
		chronometer = (Chronometer) findViewById(R.id.chronometer1);
		Log.d("1","1");

		SharedPreferences.Editor editor = someData.edit();
		right.setBackgroundResource(R.drawable.ic_action_name1);
		left.setBackgroundResource(R.drawable.ic_action_name);		
		if (someData.contains("level44"))
	   	{
	     	    level = someData.getString("level44", "");
	   	}
		else
		{
			level = "1";
     	 	editor.putString("level44", "1");
			editor.commit();
		}
		
		if(level.equals("1"))
		{
			p.setBackgroundResource(R.drawable.level44_1);
			p.setImageDrawable(getResources().getDrawable(R.drawable.level44_1));
			left.setVisibility(View.GONE);
			right.setVisibility(View.VISIBLE);
			if (someData.contains("sharedString44_1"))
	 		{
	        		 tscore.setText(someData.getString("sharedString44_1", ""));
			}
			if (someData.contains("number44_1") && someData.contains("average44_1"))
	   		{
	    	}
			else
			{
				editor.putString("number44_1", "0");
				editor.putString("average44_1", "0");
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
			if (someData.contains("sharedString44_2"))
	 		{
	        		 tscore.setText(someData.getString("sharedString44_2", ""));
			}
			if (someData.contains("number44_2") && someData.contains("average44_2"))
	   		{
	    	}
			else
			{
				editor.putString("number44_2", "0");
				editor.putString("average44_2", "0");
			}
			t.setText("Maze 2 : Barbie");
		}
		else if(level.equals("3"))
		{
			p.setBackgroundResource(R.drawable.level3);
			p.setImageDrawable(getResources().getDrawable(R.drawable.level3));
			left.setVisibility(View.VISIBLE);
			right.setVisibility(View.VISIBLE);
			if (someData.contains("sharedString44_3"))
	 		{
	        		 tscore.setText(someData.getString("sharedString44_3", ""));
			}
			if (someData.contains("number44_3") && someData.contains("average44_3"))
	   		{
	    	}
			else
			{
				editor.putString("number44_3", "0");
				editor.putString("average44_3", "0");
			}
			t.setText("Maze 3 : Doraemon");
		}
		else if(level.equals("4"))
		{
			p.setBackgroundResource(R.drawable.level4);
			p.setImageDrawable(getResources().getDrawable(R.drawable.level4));
			left.setVisibility(View.VISIBLE);
			right.setVisibility(View.VISIBLE);
			if (someData.contains("sharedString44_4"))
	 		{
	        		 tscore.setText(someData.getString("sharedString44_4", ""));
			}
			if (someData.contains("number44_4") && someData.contains("average44_4"))
	   		{
	    	}
			else
			{
				editor.putString("number44_4", "0");
				editor.putString("average44_4", "0");
			}
			t.setText("Maze 4 : Fish");
		}
		else if(level.equals("5"))
		{
			p.setBackgroundResource(R.drawable.level5);
			p.setImageDrawable(getResources().getDrawable(R.drawable.level5));
			left.setVisibility(View.VISIBLE);
			right.setVisibility(View.VISIBLE);
			if (someData.contains("sharedString44_5"))
	 		{
	        		 tscore.setText(someData.getString("sharedString44_5", ""));
			}
			if (someData.contains("number44_5") && someData.contains("average44_5"))
	   		{
	    	}
			else
			{
				editor.putString("number44_5", "0");
				editor.putString("average44_5", "0");
			}
			t.setText("Maze 5 : Flower");
		}
		else if(level.equals("6"))
		{
			p.setBackgroundResource(R.drawable.level6);
			p.setImageDrawable(getResources().getDrawable(R.drawable.level6));
			left.setVisibility(View.VISIBLE);
			right.setVisibility(View.VISIBLE);
			if (someData.contains("sharedString44_6"))
	 		{
	        		 tscore.setText(someData.getString("sharedString44_6", ""));
			}
			if (someData.contains("number44_6") && someData.contains("average44_6"))
	   		{
	    	}
			else
			{
				editor.putString("number44_6", "0");
				editor.putString("average44_6", "0");
			}
			t.setText("Maze 6 : Koala Beer");
		}
		else if(level.equals("7"))
		{
			p.setBackgroundResource(R.drawable.level7);
			p.setImageDrawable(getResources().getDrawable(R.drawable.level7));
			left.setVisibility(View.VISIBLE);
			right.setVisibility(View.VISIBLE);
			if (someData.contains("sharedString44_7"))
	 		{
	        		 tscore.setText(someData.getString("sharedString44_7", ""));
			}
			if (someData.contains("number44_7") && someData.contains("average44_7"))
	   		{
	    	}
			else
			{
				editor.putString("number44_7", "0");
				editor.putString("average44_7", "0");
			}
			t.setText("Maze 7 : Penguin");
		}

		else if(level.equals("8"))
		{
			p.setBackgroundResource(R.drawable.level8);
			p.setImageDrawable(getResources().getDrawable(R.drawable.level8));
			left.setVisibility(View.VISIBLE);
			right.setVisibility(View.GONE);
			if (someData.contains("sharedString44_8"))
	 		{
	        		 tscore.setText(someData.getString("sharedString44_8", ""));
			}
			if (someData.contains("number44_8") && someData.contains("average44_8"))
	   		{
	    	}
			else
			{
				editor.putString("number44_8", "0");
				editor.putString("average44_8", "0");
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
				Log.d("9", "9");
				flag=1;
				x1=0;
				ans.setText(Integer.toString(x1));
				blank=16;
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
				String temp = someData.getString("level44", "");
				int x = Integer.parseInt(temp);
				x++;
				temp = Integer.toString(x);
				editor.putString("level44", temp);
				editor.commit();
				Log.d("6","6");
				Intent i = new Intent(MainActivity44.this,MainActivity44.class);
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
				Intent i = new Intent(MainActivity44.this,MainActivity44.class);	
				SharedPreferences.Editor editor = someData.edit();
				String temp = someData.getString("level44", "");
				int x = Integer.parseInt(temp);
				x--;
				temp = Integer.toString(x);
				editor.putString("level44", temp);
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
				blank=16;
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
				if(blank==5)
				{
					slide(p1,p5,1);
				}
				else if(blank==2)
				{
					
					slide(p1,p2,1);
				}
				else
				{
					Toast.makeText(MainActivity44.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
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
				else if(blank==6)
				{
					slide(p2,p6,2);
				}
				else
				{
					Toast.makeText(MainActivity44.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
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
				else if(blank==4)
				{
					slide(p3,p4,3);
				}
				else if(blank==7)
				{
					slide(p3,p7,3);
				}
				else
				{
					Toast.makeText(MainActivity44.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
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
				if(blank==3)
				{
					slide(p4,p3,4);
				}
				else if(blank==8)
				{
					slide(p4,p8,4);
				}
				else
				{
					Toast.makeText(MainActivity44.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
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
				if(blank==1)
				{
					slide(p5,p1,5);
				}
				else if(blank==9)
				{
					slide(p5,p9,5);
				}
				else if(blank==6)
				{
					slide(p5,p6,5);
				}
				else
				{
					Toast.makeText(MainActivity44.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
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
				if(blank==2)
				{
					slide(p6,p2,6);
				}
				else if(blank==5)
				{
					slide(p6,p5,6);
				}
				else if(blank==7)
				{
					slide(p6,p7,6);
				}
				else if(blank==10)
				{
					slide(p6,p10,6);
				}
				else
				{
					Toast.makeText(MainActivity44.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
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
				if(blank==3)
				{
					slide(p7,p3,7);
				}
				else if(blank==8)
				{
					slide(p7,p8,7);
				}
				else if(blank==6)
				{
					slide(p7,p6,7);
				}
				else if(blank==11)
				{
					slide(p7,p11,7);
				}
				else
				{
					Toast.makeText(MainActivity44.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
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
				else if(blank==4)
				{
					slide(p8,p4,8);
				}
				else if(blank==12)
				{
					slide(p8,p12,8);
				}
				else
				{
					Toast.makeText(MainActivity44.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
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
				if(blank==5)
				{
					slide(p9,p5,9);
				}
				else if(blank==10)
				{			
					slide(p9,p10,9);
				}
				else if(blank==13)
				{
					slide(p9,p13,9);
				}
				else
				{
					Toast.makeText(MainActivity44.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
				}
			}
		});	
        
        p10.setOnClickListener(new ImageView.OnClickListener() 
        {	
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
			//	mp.start();
				sp.play(sound, 1, 1, 0, 0, 1);
				if(blank==6)
				{
					slide(p10,p6,10);
				}
				else if(blank==9)
				{
					slide(p10,p9,10);
				}
				else if(blank==11)
				{
					slide(p10,p11,10);
				}
				else if(blank==14)
				{
					slide(p10,p14,10);
				}
				else
				{
					Toast.makeText(MainActivity44.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
				}
			}
		});	
        
        p11.setOnClickListener(new ImageView.OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
			//	mp.start();
				sp.play(sound, 1, 1, 0, 0, 1);
				if(blank==7)
				{
					slide(p11,p7,11);
				}
				else if(blank==10)
				{
					slide(p11,p10,11);
				}
				else if(blank==12)
				{
					slide(p11,p12,11);
				}
				else if(blank==15)
				{
					slide(p11,p15,11);
				}
				else
				{
					Toast.makeText(MainActivity44.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
				}
			}
        });
        
        p12.setOnClickListener(new ImageView.OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
			//	mp.start();
				sp.play(sound, 1, 1, 0, 0, 1);
				if(blank==8)
				{
					slide(p12,p8,12);
				}
				else if(blank==11)
				{
					slide(p12,p11,12);
				}
				else if(blank==16)
				{
					slide(p12,p16,12);
				}
				else
				{
					Toast.makeText(MainActivity44.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
				}
			}
        });
        
        p13.setOnClickListener(new ImageView.OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
			//	mp.start();
				sp.play(sound, 1, 1, 0, 0, 1);
				if(blank==9)
				{
					slide(p13,p9,13);
				}
				else if(blank==14)
				{
					slide(p13,p14,13);
				}
				else
				{
					Toast.makeText(MainActivity44.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
				}
			}
        });
        
        p14.setOnClickListener(new ImageView.OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
			//	mp.start();
				sp.play(sound, 1, 1, 0, 0, 1);
				if(blank==13)
				{
					slide(p14,p13,14);
				}
				else if(blank==10)
				{
					slide(p14,p10,14);
				}
				else if(blank==15)
				{
					slide(p14,p15,14);
				}
				else
				{
					Toast.makeText(MainActivity44.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
				}
			}
        });
        
        p15.setOnClickListener(new ImageView.OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
			//	mp.start();
				sp.play(sound, 1, 1, 0, 0, 1);
				if(blank==14)
				{
					slide(p15,p14,15);
				}
				else if(blank==11)
				{
					slide(p15,p11,15);
				}
				else if(blank==16)
				{
					slide(p15,p16,15);
				}
				else
				{
					Toast.makeText(MainActivity44.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
				}
			}
        });
        
        p16.setOnClickListener(new ImageView.OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
			//	mp.start();
				sp.play(sound, 1, 1, 0, 0, 1);
				if(blank==12)
				{
					slide(p16,p12,16);
				}
				else if(blank==15)
				{
					slide(p16,p15,16);
				}
				else
				{
					Toast.makeText(MainActivity44.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
				}
			}
        });
	}
	
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
										ssss.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(8)));
										if (((BitmapDrawable) p9.getDrawable()).getBitmap()==((BitmapDrawable)ssss.getDrawable()).getBitmap())
										{
											ssss.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(9)));
											if (((BitmapDrawable) p10.getDrawable()).getBitmap()==((BitmapDrawable)ssss.getDrawable()).getBitmap())
											{
												ssss.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(10)));
												if (((BitmapDrawable) p11.getDrawable()).getBitmap()==((BitmapDrawable)ssss.getDrawable()).getBitmap())
												{	
													ssss.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(11)));
													if (((BitmapDrawable) p12.getDrawable()).getBitmap()==((BitmapDrawable)ssss.getDrawable()).getBitmap())
													{
														ssss.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(12)));
														if (((BitmapDrawable) p13.getDrawable()).getBitmap()==((BitmapDrawable)ssss.getDrawable()).getBitmap())
														{
															ssss.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(13)));
															if (((BitmapDrawable) p14.getDrawable()).getBitmap()==((BitmapDrawable)ssss.getDrawable()).getBitmap())
															{
																ssss.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(14)));
																if (((BitmapDrawable) p15.getDrawable()).getBitmap()==((BitmapDrawable)ssss.getDrawable()).getBitmap())
																{
																	chronometer.stop();
																	CharSequence t = chronometer.getText();
																	String time = t.toString();
																	SharedPreferences.Editor editor = someData.edit();
																	int number, average=0,total;
																	x = ans.getText().toString();
																	x1 = Integer.parseInt(x);
																	Log.d("inside if","hurrah");
																	String xx = tscore.getText().toString();
																	int yy = Integer.parseInt(xx);
																	final GameComplete md = new GameComplete(this);
																	md.setContentView(R.layout.game_complete);
																	md.setTitle("Puzzle Solved");
																	ImageView s1 = (ImageView) md.findViewById(R.id.star1);
																	ImageView s2 = (ImageView) md.findViewById(R.id.star2);
																	ImageView s3 = (ImageView) md.findViewById(R.id.star3);
																	if(x1<=100)
																	{
																		s1.setBackgroundResource(R.drawable.star);
																		s3.setBackgroundResource(R.drawable.star);
																		s2.setBackgroundResource(R.drawable.star);
																	}
																	else if(x1<=120)
																	{
																		s2.setBackgroundResource(R.drawable.star);
																		s1.setBackgroundResource(R.drawable.star);
																	}
																	else if(x1<=150)
																	{
																		s1.setBackgroundResource(R.drawable.star);
																	}
																	TextView timecurrent = (TextView) md.findViewById(R.id.timecurrent);
																	timecurrent.setText(t);
																	if(x1<yy || yy==0)
																	{
																		if(level.equals("1"))
																		{
																			editor.putString("sharedString44_1", x);
																		}
																		else if(level.equals("2"))
																		{
																			editor.putString("sharedString44_2", x);
																		}
																		else if(level.equals("3"))
																		{
																			editor.putString("sharedString44_3", x);
																		}
																		else if(level.equals("4"))
																		{
																			editor.putString("sharedString44_4", x);
																		}
																		else if(level.equals("5"))
																		{
																			editor.putString("sharedString44_5", x);
																		}
																		else if(level.equals("6"))
																		{
																			editor.putString("sharedString44_6", x);
																		}
																		else if(level.equals("7"))
																		{
																			editor.putString("sharedString44_7", x);
																		}
																		else if(level.equals("8"))
																		{	
																			editor.putString("sharedString44_8", x);
																		}
																		editor.commit();
																		tscore.setText(x);
																		TextView tt = (TextView) md.findViewById(R.id.text);
																		tt.setVisibility(View.VISIBLE);
																		xx=Integer.toString(x1);
																	}
																	TextView ansmoves = (TextView) md.findViewById(R.id.ansmoves);
																	ansmoves.setText(x);
																	Log.e("10","10");
																	TextView best = (TextView) md.findViewById(R.id.best);
																	best.setText(xx);
																	TextView worst = (TextView) md.findViewById(R.id.worst);
																	Log.e("9","9");
																	
																	if(level.equals("1"))
																	{
																		number = Integer.parseInt(someData.getString("number44_1", ""));
																		Log.e("39","39");
																		average = Integer.parseInt(someData.getString("average44_1", ""));
																		total = number * average + x1;
																		number++;
																		Log.e("49","49");
																		average = total/number;
																		editor.putString("number44_1", Integer.toString(number));
																		if (someData.contains("worst44_1"))
																	   	{
																			wors = someData.getString("worst44_1", "");
																			worse = Integer.parseInt(wors);
																		}
																	}
																	else if(level.equals("2"))
																	{
																		number = Integer.parseInt(someData.getString("number44_2", ""));
																		Log.e("39","39");
																		average = Integer.parseInt(someData.getString("average44_2", ""));
																		total = number * average + x1;
																		number++;
																		Log.e("49","49");
																		average = total/number;
																		editor.putString("number44_2", Integer.toString(number));
																		if (someData.contains("worst44_2"))
																	   	{
																			wors = someData.getString("worst44_2", "");
																			worse = Integer.parseInt(wors);
																		}
																	}
																	else if(level.equals("3"))
																	{
																		number = Integer.parseInt(someData.getString("number44_3", ""));
																		Log.e("39","39");
																		average = Integer.parseInt(someData.getString("average44_3", ""));
																		total = number * average + x1;
																		number++;
																		Log.e("49","49");
																		average = total/number;
																		editor.putString("number44_3", Integer.toString(number));
																		if (someData.contains("worst44_3"))
																	   	{
																			wors = someData.getString("worst44_3", "");
																			worse = Integer.parseInt(wors);
																		}
																	}
																	else if(level.equals("4"))
																	{
																		number = Integer.parseInt(someData.getString("number44_4", ""));
																		Log.e("39","39");
																		average = Integer.parseInt(someData.getString("average44_4", ""));
																		total = number * average + x1;
																		number++;
																		Log.e("49","49");
																		average = total/number;
																		editor.putString("number44_4", Integer.toString(number));
																		if (someData.contains("worst44_4"))
																	   	{
																			wors = someData.getString("worst44_4", "");
																			worse = Integer.parseInt(wors);
																		}
																	}
																	else if(level.equals("5"))
																	{
																		number = Integer.parseInt(someData.getString("number44_5", ""));
																		Log.e("39","39");
																		average = Integer.parseInt(someData.getString("average44_5", ""));
																		total = number * average + x1;
																		number++;
																		Log.e("49","49");
																		average = total/number;
																		editor.putString("number44_5", Integer.toString(number));
																		if (someData.contains("worst44_5"))
																	   	{
																			wors = someData.getString("worst44_5", "");
																			worse = Integer.parseInt(wors);
																		}
																	}
																	else if(level.equals("6"))
																	{
																		number = Integer.parseInt(someData.getString("number44_6", ""));
																		Log.e("39","39");
																		average = Integer.parseInt(someData.getString("average44_6", ""));
																		total = number * average + x1;
																		number++;
																		Log.e("49","49");
																		average = total/number;
																		editor.putString("number44_6", Integer.toString(number));
																		if (someData.contains("worst44_6"))
																	   	{
																			wors = someData.getString("worst44_6", "");
																			worse = Integer.parseInt(wors);
																		}
																	}
																	else if(level.equals("7"))
																	{
																		number = Integer.parseInt(someData.getString("number44_7", ""));
																		Log.e("39","39");
																		average = Integer.parseInt(someData.getString("average44_7", ""));
																		total = number * average + x1;
																		number++;
																		Log.e("49","49");
																		average = total/number;
																		editor.putString("number44_7", Integer.toString(number));
																		if (someData.contains("worst44_7"))
																	   	{
																			wors = someData.getString("worst44_7", "");
																			worse = Integer.parseInt(wors);
																		}
																	}
																	else if(level.equals("8"))
																	{
																		number = Integer.parseInt(someData.getString("number44_8", ""));
																		Log.e("39","39");
																		average = Integer.parseInt(someData.getString("average44_8", ""));
																		total = number * average + x1;
																		number++;
																		Log.e("49","49");
																		average = total/number;
																		editor.putString("number44_8", Integer.toString(number));
																		if (someData.contains("worst44_8"))
																	   	{
																			wors = someData.getString("worst44_8", "");
																			worse = Integer.parseInt(wors);
																		}
																	}
																	
																	if(x1>worse || worse==000)
																	{
																		if(level.equals("1"))
																		{
																			editor.putString("worst44_1", x);
																			worse=x1;
																		}
																		else if(level.equals("2"))
																		{
																			editor.putString("worst44_2", x);
																			worse=x1;
																		}
																		else if(level.equals("3"))
																		{
																			editor.putString("worst44_3", x);
																			worse=x1;
																		}
																		else if(level.equals("4"))
																		{
																			editor.putString("worst44_4", x);
																			worse=x1;
																		}
																		else if(level.equals("5"))
																		{
																			editor.putString("worst44_5", x);
																			worse=x1;
																		}
																		else if(level.equals("6"))
																		{
																			editor.putString("worst44_6", x);
																			worse=x1;
																		}
																		else if(level.equals("7"))
																		{
																			editor.putString("worst44_7", x);
																			worse=x1;
																		}
																		else if(level.equals("8"))
																		{
																			editor.putString("worst44_8", x);
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
																			blank=16;
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
																			Intent i = new Intent(MainActivity44.this,FirstActivity.class);
																			startActivity(i);
																			md.dismiss();
																			finish();
																		}
																	});
																	Button next = (Button) md.findViewById(R.id.next);
																	TextView Average = (TextView) md.findViewById(R.id.average);
																	Average.setText(Integer.toString(average));
																	next.setOnClickListener(new Button.OnClickListener()
																	{
																		@Override
																		public void onClick(View v) 
																		{
																			// TODO Auto-generated method stub
																			SharedPreferences.Editor editor = someData.edit();
																			String temp = someData.getString("level44", "");
																			int x = Integer.parseInt(temp);
																			if(x<8)
																			{
																				x++;
																				temp = Integer.toString(x);
																				editor.putString("level44", temp);
																				editor.commit();
																				Intent i = new Intent(MainActivity44.this,MainActivity44.class);
																				startActivity(i);
																				md.dismiss();
																				finish();
																			}
																			else
																			{
																				temp = "1";
																				editor.putString("level44", temp);
																				editor.putString("level444", temp);
																				editor.commit();
																				Intent i = new Intent(MainActivity44.this,MainActivity444.class);
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
		l4.setVisibility(View.VISIBLE);
		ans.setVisibility(View.VISIBLE);
		restart.setVisibility(View.VISIBLE);
		chronometer.setVisibility(View.VISIBLE);
		Log.d("1","1");
		
		splitImage sp = new splitImage();
		imageChunks = sp.split(p,16);
		Log.d("7","7");
		
		Random r = new Random();
		int i = r.nextInt(9);
		
		/*int k=-1,omg=0,flagallocate=1;
		while(k<14)
		{
			Log.d("1","1");
			flagallocate=1;
			omg = r.nextInt(15);
			Log.d("omg",Integer.toString(omg));
			for(int j = 0; j <= k;j++)
			{
				Log.d("1","inside for");
				if((omg+1)==a[j])
				{
					Log.d("1","inside for if");
					flagallocate=0;
					break;
				}
			}
			if(flagallocate==1)
			{
				k++;
				a[k] = omg+1;
				Log.d("k",Integer.toString(k));
				Log.d("a[k]",Integer.toString(a[k]));
			}
		}
		Log.d("1","all done finally");
		image(a[0],a[1],a[2],a[3],a[4],a[5],a[6],a[7],a[8],a[9],a[10],a[11],a[12],a[13],a[14]);
		*/
		
		if(i==0)
		{
			image(10,3,9,14,2,1,11,13,15,6,4,5,8,12,7);
		}
		else if(i==1)
		{
			image(13,3,9,11,10,6,12,4,1,15,8,14,7,5,2);
		}
		else if(i==2)
		{
			image(9,5,4,2,1,14,11,10,15,3,6,13,12,7,8);
		}
		else if(i==3)
		{
			image(10,12,3,11,2,6,7,14,5,9,13,8,15,1,4);
		}
		else if(i==4)
		{
			image(1,15,7,6,13,11,4,8,9,5,10,3,14,12,2);
		}
		else if(i==5)
		{
			image(4,7,3,5,15,6,10,11,9,1,8,2,14,12,13);
		}
		else if(i==6)
		{
			image(12,14,3,9,2,8,7,5,10,4,6,13,11,1,15);
		}
		else if(i==7)
		{
			image(13,7,1,6,10,9,2,15,5,11,8,12,14,4,3);
		}
		else if(i==8)
		{
			image(15,11,3,5,1,13,2,12,14,10,4,8,9,6,7);
		}
		else
		{
			image(12,8,11,9,13,10,5,14,6,3,4,15,2,7,1);
		}
	}
	
	private void image(int i, int j, int k, int l,int m, int n, int o, int p, int q, int r, int s, int t, int u, int v, int w) 
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
		p9.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(q-1)));
		p10.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(r-1)));
		p11.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(s-1)));
		p12.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(t-1)));
		p13.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(u-1)));
		p14.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(v-1)));
		p15.setImageDrawable(new BitmapDrawable(getResources(),imageChunks.get(w-1)));
		p16.setImageDrawable(getResources().getDrawable(R.drawable.blank1));
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
    		l4.setVisibility(View.GONE);
    		ans.setVisibility(View.GONE);
    		restart.setVisibility(View.GONE);
    		chronometer.setVisibility(View.GONE);
    		flag=0;
      }   
    }
}
