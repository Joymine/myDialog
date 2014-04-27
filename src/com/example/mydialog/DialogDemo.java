package com.example.mydialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogDemo extends Activity {
	//使用上下文菜单
	private Button b1,b2,b3,b4,b5,b6,b7,b_exit;
	AlertDialog.Builder  dbuilder=null;

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog);
		    b1=(Button)findViewById(R.id.button1);
	        b2=(Button)findViewById(R.id.button2);
	        b3=(Button)findViewById(R.id.button3);
	        b4=(Button)findViewById(R.id.button4);
	        b5=(Button)findViewById(R.id.button5);
	        b6=(Button)findViewById(R.id.button6);
	        b7=(Button)findViewById(R.id.button7);
	        b_exit=(Button)findViewById(R.id.button8);
	        
	        b1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Toast.makeText(DialogDemo.this,"...", Toast.LENGTH_SHORT).show();
					dbuilder=new Builder(DialogDemo.this);
				    dbuilder.setTitle("提示");
				    dbuilder.setMessage("界面漂亮不~？");
				    dbuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							dialog.dismiss();
							
							
						}
					} );
				    dbuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							dialog.dismiss();
						}
					});
				    dbuilder.show();
				
				}	
					
			});
	        b2.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					dbuilder=new Builder(DialogDemo.this);
					dbuilder.setTitle("dialog2");
					dbuilder.setMessage("这个有三个按钮，并且替换图片");
					dbuilder.setIcon(R.drawable.ic_launcher);
					dbuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							Toast.makeText(DialogDemo.this,"YES",Toast.LENGTH_SHORT).show();
							dialog.dismiss();
							
						}
					});
					dbuilder.setNeutralButton("others", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub
							Toast.makeText(DialogDemo.this,"others",Toast.LENGTH_SHORT).show();
							arg0.dismiss();
						}
					});
					dbuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							Toast.makeText(DialogDemo.this,"NO",Toast.LENGTH_SHORT).show();
							dialog.dismiss();
						}
					});
					//
					dbuilder.show();
				}
			});
	       b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dbuilder=new Builder(DialogDemo.this);
				dbuilder.setTitle("dialog 3")
				.setIcon(R.drawable.ic_launcher)
				.setView(new EditText(DialogDemo.this))
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(DialogDemo.this, "OK", Toast.LENGTH_SHORT);
					}
				})
				.setNegativeButton("NO",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(DialogDemo.this, "No", Toast.LENGTH_SHORT);
					}
				}).show();
				
				
			
				//
			}
		});
	       b4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dbuilder=new AlertDialog.Builder(DialogDemo.this)
				.setTitle("Dialog 单选框")
				.setIcon(R.drawable.ic_launcher)
				.setSingleChoiceItems( new String[] { "Item1", "Item2" }, 0, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						arg0.dismiss();
					}
				})
				.setNegativeButton("NO", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(DialogDemo.this, "NO", Toast.LENGTH_SHORT);
					}
				})
				.setPositiveButton("OK", null);
				dbuilder.show();
				
			}
		});
	       b5.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dbuilder=new AlertDialog.Builder(DialogDemo.this)
				.setTitle("Dialog 复选框")
				.setIcon(R.drawable.ic_launcher)
				.setMultiChoiceItems(new String[]{"Item1","Item2"}, null, null)
				.setPositiveButton("ok", null)
				.setNegativeButton("NO", null);
				dbuilder.show();
			}
		});
	       b6.setOnClickListener(new  OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View arg0) {
	   			// TODO Auto-generated method stub
	   			dbuilder=new AlertDialog.Builder(DialogDemo.this)
	   			.setTitle("Dialog 复选框")
	   			.setIcon(R.drawable.ic_launcher)
	   			.setItems(new String[]{"Item1","Item2"}, null)
	   			.setPositiveButton("ok", null)
	   			.setNegativeButton("NO", null);
	   			dbuilder.show();
	   		}
	   	});
	       //自定义的dialog
	       b7.setOnClickListener(new  OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View arg0) {
	   			// TODO Auto-generated method stub
	   			LayoutInflater inflater=getLayoutInflater();
	   			View layout=inflater.inflate(R.layout.mydialog, (ViewGroup)findViewById(R.id.dialog));
	   			dbuilder=new AlertDialog.Builder(DialogDemo.this)
	   			.setTitle("Dialog自定义布局")
	   			.setView(layout)
	   			.setIcon(R.drawable.ic_launcher)
	   			.setMultiChoiceItems(new String[]{"Item1","Item2"}, null, null)
	   			.setPositiveButton("ok", null)
	   			.setNegativeButton("NO", null);
	   			dbuilder.show();
	   		}
	   	});
	       b_exit.setOnClickListener(new OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			// TODO Auto-generated method stub
	   			dbuilder=new Builder(DialogDemo.this)
	   			.setTitle("tips")
	   			.setMessage("确定要退出程序么？")
	   			.setPositiveButton("YES",new DialogInterface.OnClickListener() {
	   				
	   				@Override
	   				public void onClick(DialogInterface arg0, int arg1) {
	   					// TODO Auto-generated method stub
	   					DialogDemo.this.finish();
	   				}
	   			})
	   			.setNegativeButton("NO", null);
	   			dbuilder.show();
	   		}
	   	});
	}
	

}
