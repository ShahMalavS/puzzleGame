package com.example.puzzlegame;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

public class splitImage
{
	public splitImage()
	{
		
	}
	
	ArrayList<Bitmap> split(ImageView image, int chunkNumbers) 
	{	
		
		//For the number of rows and columns of the grid to be displayed
		int rows,cols;
		
		//For height and width of the small image chunks 
		int chunkHeight,chunkWidth;
		
		//To store all the small image chunks in bitmap format in this list 
		ArrayList<Bitmap> chunkedImages = new ArrayList<Bitmap>(chunkNumbers);
		
		//Getting the scaled bitmap of the source image
		BitmapDrawable drawable = (BitmapDrawable) image.getDrawable();
		Bitmap bitmap = drawable.getBitmap();
		Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true);
		
		rows = cols = (int) Math.sqrt(chunkNumbers);
		chunkHeight = bitmap.getHeight()/rows;
		chunkWidth = bitmap.getWidth()/cols;
		
		//xCoord and yCoord are the pixel positions of the image chunks
		int yCoord = 0;
		for(int x=0; x<rows; x++)
		{
			int xCoord = 0;
			for(int y=0; y<cols; y++)
			{
				chunkedImages.add(Bitmap.createBitmap(scaledBitmap, xCoord, yCoord, chunkWidth, chunkHeight));
				xCoord += chunkWidth;
			}
			yCoord += chunkHeight;
		}
		
		return chunkedImages;
		//Start a new activity to show these chunks into a grid 
//		Intent intent = new Intent(ImageActivity.this, ChunkedImageActivity.class);
	//	intent.putParcelableArrayListExtra("image chunks", chunkedImages);
		//startActivity(intent);
	}
}
