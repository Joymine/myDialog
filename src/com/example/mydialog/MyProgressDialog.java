package com.example.mydialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MyProgressDialog extends Activity {
	private Button b1,b2,b3;
	ProgressDialog dialog;
	int count=0;

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progressdialog);
		b1=(Button)findViewById(R.id.bh);
		b3=(Button)findViewById(R.id.bhandle);
		b2=(Button)findViewById(R.id.bc);
		b2.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog=new ProgressDialog(MyProgressDialog.this);
				//设置风格为圆形旋转的
				dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
				dialog.setTitle("Tltle");
				dialog.setMessage("旋转形进度条");
				dialog.setIndeterminate(false);
				dialog.setCancelable(true);
				dialog.setButton("确定",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.cancel();
					}
				});
				dialog.show();
				
			}
		});
	    b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				dialog=new ProgressDialog(MyProgressDialog.this);
				dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				dialog.setTitle("Tytle");
				dialog.setMessage("横向的进度条");
				dialog.setProgress(100);
				dialog.setIndeterminate(false);
				dialog.setCancelable(true);
				dialog.show();
				
				new Thread(){
					public void run(){
						try{
							while(count<=100){
								dialog.setProgress(count++);
								Thread.sleep(100);
							}
							dialog.cancel();
						}catch(InterruptedException e){
							e.printStackTrace();
						}
					}
				}.start();
				
				
				
				
				
				
				
			}
		});
	    b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dialog=ProgressDialog.show(MyProgressDialog.this, "Tips", "Loadind");
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						spandTimeMethod();
						handler.sendEmptyMessage(0);
						
					}
				} ).start();
			}
		});
	}
	
	 private void spandTimeMethod(){
		 try{
			 Thread.sleep(2000);
		 }catch (InterruptedException e){
			 e.printStackTrace();
		 }
	 }
	 Handler handler=new Handler(){
		 public void handleMessage(Message msg){
			 dialog.dismiss();
		 }
	 };

}
