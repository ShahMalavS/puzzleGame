package com.example.puzzlegame;

import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class CustomMaze3 extends ActionBarActivity 
{
	ImageView p1,p2,p3,p4,p5,p6,p7,p8,p9,p,ssss;
	LinearLayout l1,l2,l3;
	ToggleButton tb;
	TextView tscore;
	Button ans,score,move,restart;
	ImageButton left,right;
	ArrayList<Bitmap> imageChunks;
	int blank = 9, x1, flag=0, sound,s=1;
	int[] a = new int[20];
	private static int RESULT_LOAD_IMAGE = 1;
	String x,level,path;
	final Context context = this;
	public static String filename = "MySharedString";
	SharedPreferences someData;
	//MediaPlayer mp;
	SoundPool sp;

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
		
		path = getIntent().getExtras().getString("Path");
		p.setVisibility(View.VISIBLE);
		p.setImageBitmap(BitmapFactory.decodeFile(path));
	
		left.setVisibility(View.GONE);
		right.setVisibility(View.GONE);
		allocateimage();
		flag=1;
		x1=0;
		ans.setText(Integer.toString(x1));
		blank=9;

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
					Toast.makeText(CustomMaze3.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
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
					Toast.makeText(CustomMaze3.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
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
					Toast.makeText(CustomMaze3.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
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
					Toast.makeText(CustomMaze3.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
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
					Toast.makeText(CustomMaze3.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
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
					Toast.makeText(CustomMaze3.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
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
					Toast.makeText(CustomMaze3.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
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
					Toast.makeText(CustomMaze3.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
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
					Toast.makeText(CustomMaze3.this,"Cannot move that tile", Toast.LENGTH_SHORT).show();
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
										x = ans.getText().toString();
										Log.d("inside if","hurrah");
										final GameComplete md = new GameComplete(this);
										md.setContentView(R.layout.game_complete_custom);
										md.setTitle("Puzzle Solved");
										Button ansmoves = (Button) md.findViewById(R.id.ansmoves);
										ansmoves.setText("Moves : "+x1);
										Button playagain3 = (Button) md.findViewById(R.id.three);
										Button playagain4 = (Button) md.findViewById(R.id.four);
										Button playagain5 = (Button) md.findViewById(R.id.five);
										playagain3.setOnClickListener(new Button.OnClickListener()
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
										playagain4.setOnClickListener(new Button.OnClickListener()
										{
											@Override
											public void onClick(View v) 
											{
												// TODO Auto-generated method stub
												Intent i = new Intent(CustomMaze3.this,CustomMaze4.class);
												 i.putExtra("Path",  path);
												startActivity(i);
												md.dismiss();
											}
										});
										playagain5.setOnClickListener(new Button.OnClickListener()
										{
											@Override
											public void onClick(View v) 
											{
												// TODO Auto-generated method stub
												Intent i = new Intent(CustomMaze3.this,CustomMaze.class);
												i.putExtra("Path",  path);
												startActivity(i);
												md.dismiss();
											}
										});
										Button next = (Button) md.findViewById(R.id.next);
										next.setOnClickListener(new Button.OnClickListener()
										{
											@Override
											public void onClick(View v) 
											{
												// TODO Auto-generated method stub
												Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
												startActivityForResult(i, RESULT_LOAD_IMAGE);
											}
										});
										Button menu = (Button) md.findViewById(R.id.menu);
										menu.setOnClickListener(new Button.OnClickListener()
										{
											@Override
											public void onClick(View v) 
											{
												// TODO Auto-generated method stub
												Intent i = new Intent(CustomMaze3.this,FirstActivity.class);
												startActivity(i);
												md.dismiss();
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
		Log.d("1","1");
		
		splitImage sp = new splitImage();
		imageChunks = sp.split(p,9);
		Log.d("7","7");
		
		Random r = new Random();
	/*	int k=-1,omg=0,flagallocate=1;
		while(k<7)
		{
			Log.d("1","1");
			flagallocate=1;
			omg = r.nextInt(8);
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
		image(a[0],a[1],a[2],a[3],a[4],a[5],a[6],a[7]);*/
		int i = r.nextInt(9);
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
	}
	
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
    	super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data)
		{
			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };

			Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			String picturePath = cursor.getString(columnIndex);
			cursor.close();	
			
			Intent i= new Intent(getApplicationContext(),CustomImg.class);
			 // potentially add data to the intent
			 i.putExtra("Path",  picturePath);
			 startActivity(i);
			
			/*ImageView imageView = (ImageView) findViewById(R.id.img);
			imageView.setVisibility(View.VISIBLE);
			imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));*/
		}    
    }
	@Override
    public void onBackPressed()
    {
	 	finish();
    }
}