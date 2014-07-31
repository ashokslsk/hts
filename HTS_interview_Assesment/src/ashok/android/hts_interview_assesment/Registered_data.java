package ashok.android.hts_interview_assesment;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Registered_data extends Activity {

	TextView reg_data_name;
	SharedPreferences pref;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_registered_data);
		reg_data_name = (TextView)findViewById(R.id.reg_data_buyer);
		
		pref = getSharedPreferences("Registration", 0);
		String name = pref.getString("Name", "could not load any data save it first");
		String email = pref.getString("Email", "could not load any data save it first");
		String phone = pref.getString("Phone", "could not load any data save it first");

		
		
		reg_data_name.setText(name+"\n "+email+"\n "+" "+phone);
		
		
		
		
		
	}
}