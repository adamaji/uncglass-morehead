package com.uncglass.moreheadcaptioning;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.google.android.glass.app.Card;

public class Magic extends Activity {
	
	private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		Queue<Display> q = new LinkedQueue<Display>();
		final Card card = new Card(this);
		
		Thread textThread = new Thread(new TextRenderer(card, q));
		textThread.start();
		
		final Context mContext = this;
		Runnable updateUI = new Runnable(){
			public void run(){
				((Activity) mContext).setContentView(card.toView());
				mHandler.postDelayed(this, 100);
			}
		};
		
		mHandler.postDelayed(updateUI, 100);
	}
}
