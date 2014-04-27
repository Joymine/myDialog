package com.example.mydialog;

import android.app.Activity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends Activity {
	//options menue
	private Button b_dialog,b_progress,b_time,b_exit,b_menu;
	AlertDialog.Builder  dbuilder=null;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        //初始化控件
        b_dialog=(Button)findViewById(R.id.button1);
        b_progress=(Button)findViewById(R.id.button2);
        b_time=(Button)findViewById(R.id.button3);
        b_exit=(Button)findViewById(R.id.button4);
        b_menu=(Button)findViewById(R.id.button5);
        
        //给组件天添加响应
        b_dialog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,DialogDemo.class);
				startActivity(intent);
				                
			}
		});
  
        b_progress.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			  // TODO Auto-generated method stub
			Intent intent=new Intent(MainActivity.this,MyProgressDialog.class);
			startActivity(intent);
			                
	
		}
	});
        b_time.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(MainActivity.this,MyTime.class);
			startActivity(intent);
		}
	});
        b_exit.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			dbuilder=new Builder(MainActivity.this)
			.setTitle("tips")
			.setMessage("确定要退出程序么？")
			.setPositiveButton("YES",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					MainActivity.this.finish();
				}
			})
			.setNegativeButton("NO", null);
			dbuilder.show();
		}
	});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
    	 super.onCreateOptionsMenu(menu);  
         int groupId = 100;  
         int itemId=1;
         int orderId = 1;  
         menu.add(groupId, itemId, orderId, "item1");  
         menu.add(groupId, itemId+1, orderId+1, "item2");  
         menu.add(groupId+1, itemId+2, orderId+2, "new 3");
         menu.add(groupId+1, itemId+3, orderId+3, "new 4").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this,"YES",Toast.LENGTH_SHORT).show();
				return false;
			}
		});
        
       
         return true;  
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id==1){
        	Toast.makeText(MainActivity.this,item.toString(),Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
      
  

}
