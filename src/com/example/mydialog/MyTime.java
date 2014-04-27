package com.example.mydialog;

import java.util.Calendar;

import com.example.mydialog.R.id;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class MyTime extends Activity {
	 Button b_exit;
	 EditText b_time,b_date;

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.time);
		b_date=(EditText)findViewById(R.id.bdate);
		b_time=(EditText)findViewById(R.id.btime);
		b_exit=(Button)findViewById(R.id.bexit);
		//获得时间类实例
		Calendar calender=Calendar.getInstance();
		//获得系统时间
		calender.setTimeInMillis(System.currentTimeMillis());
		//
		final int year=calender.get(Calendar.YEAR);
		final int month=calender.get(calender.MONTH);
		final int day=calender.get(Calendar.DAY_OF_MONTH);
		final int hour=calender.get(Calendar.HOUR_OF_DAY);
		final int min=calender.get(calender.MINUTE);
		b_date.setText(year+"-"+formatTimeTwoNumber(month+1)+"-"+formatTimeTwoNumber(day));
		b_time.setText(formatTimeTwoNumber(hour)+"-"+formatTimeTwoNumber(min));
		b_date.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				b_date.setText("");
				new DatePickerDialog(MyTime.this,new DatePickerDialog.OnDateSetListener() {
					
					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						// TODO Auto-generated method stub
						b_date.setText(year+"-"+formatTimeTwoNumber(month+1)+"-"+formatTimeTwoNumber(day));
						
					}
				},year,month,day).show();
				
			}
		});
		//b
		b_time.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				b_time.setText("");
				new TimePickerDialog(MyTime.this, new TimePickerDialog.OnTimeSetListener() {
					
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						// TODO Auto-generated method stub
						b_time.setText(formatTimeTwoNumber(hour)+"-"+formatTimeTwoNumber(min));
					}
				},hour,min,true).show();
			}
		});
		 b_exit.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					AlertDialog.Builder dbuilder=new Builder(MyTime.this)
					.setTitle("tips")
					.setMessage("确定要退出时间设置么？")
					.setPositiveButton("YES",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub
							MyTime.this.finish();
						}
					})
					.setNegativeButton("NO", null);
					dbuilder.show();
				}
			});
		
	
	}
	
	public static String formatTimeTwoNumber(int x){
		String s=Integer.toString(x);
		if(s.length()==1){
			s="0"+s;
		}
		return s;
	}
	

}
