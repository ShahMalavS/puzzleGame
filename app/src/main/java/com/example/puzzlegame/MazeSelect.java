package com.example.puzzlegame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class MazeSelect extends ActionBarActivity 
{
	Button three,four,five,select;
	private static int RESULT_LOAD_IMAGE = 1;
	final Context context = this;
	public static String filename = "MySharedString";
	SharedPreferences someData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maze);
		
		three = (Button) findViewById(R.id.three);
		four = (Button) findViewById(R.id.four);
		five = (Button) findViewById(R.id.five);
		select = (Button) findViewById(R.id.custom);
		
		three.setText("       3 * 3       ");
		four.setText("       4 * 4       ");
		five.setText("       5 * 5       ");
		
		three.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				
				Intent i = new Intent(MazeSelect.this,MainActivity.class);
				startActivity(i);
			}
		});
		
		four.setOnClickListener(new Button.OnClickListener()
		{

			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				Intent i = new Intent(MazeSelect.this,MainActivity44.class);
				startActivity(i);
			}			
		});
		
		five.setOnClickListener(new Button.OnClickListener()
		{

			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				Intent i = new Intent(MazeSelect.this,MainActivity444.class);
				startActivity(i);
			}			
		});
		
		select.setOnClickListener(new Button.OnClickListener()
		{

			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(i, RESULT_LOAD_IMAGE);
			}			
		});

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
		
		}    
    }
}
