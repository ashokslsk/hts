package test.example.hibisucusproduct;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
	SharedPreferences pref;
	
	ListView list;
	  String[] web = {
	    "Google Plus",
	      "Twitter",
	      "Windows",
	      
	  } ;
	  
	  final static int cameraData = 0;

	  Integer[] imageId = {
		      R.drawable.image1,
		      R.drawable.image2,
		      R.drawable.image3,
		  
		  };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        custom_list adapter = new custom_list(MainActivity.this, web, imageId);
        
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);	
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
               // Toast.makeText(MainActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
           
            	if(position==0){
            		Intent detailIntent = new Intent(MainActivity.this,
                            Productdetail1.class);
                    //detailIntent.putExtra("biller", 0);
                    startActivity(detailIntent);
            	}else if(position==1){
            		
            		Intent detailIntent1 = new Intent(MainActivity.this,
                            ProductActivity2.class);
                    //detailIntent.putExtra("biller", 0);
                    startActivity(detailIntent1);
            		
            	}else if(position==2){
            		
            		Intent detailIntent2 = new Intent(MainActivity.this,
                            ProductActivity3.class);
                    //detailIntent.putExtra("biller", 0);
                    startActivity(detailIntent2);
            		
            	}
            }
        });
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	 MenuInflater menuInflater = getMenuInflater();
         menuInflater.inflate(R.menu.main, menu);
         return true;   	
    }
    
    
    public boolean onOptionsItemSelected(MenuItem item)
    {
         
        switch (item.getItemId())
        {
        case R.id.Camera:
        	Intent i = new Intent(MainActivity.this, Camera.class);
			startActivity(i);
            return true;
        case R.id.reg_data:
        	Intent i1 = new Intent(MainActivity.this, reg_info.class);
			startActivity(i1);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}