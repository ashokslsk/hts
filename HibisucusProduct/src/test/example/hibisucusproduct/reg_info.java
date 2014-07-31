package test.example.hibisucusproduct;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class reg_info extends Activity{
	private TextView batteryInfo,tv_name,num1,num2;
	SharedPreferences pref;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reg_info);
		tv_name = (TextView) findViewById(R.id.Nameof_reg);
		num1 = (TextView) findViewById(R.id.Number1);
		num2 = (TextView) findViewById(R.id.Number2);
		
		pref = getSharedPreferences("Registration", 0);
		String name = pref.getString("Name", null);
		tv_name.setText(name);
		
		pref = getSharedPreferences("Registration", 0);
		String n1 = pref.getString("Num1", null);
		num1.setText(n1);
		
		pref = getSharedPreferences("Registration", 0);
		String n2 = pref.getString("Num2", null);
		num2.setText(n2);
	}

}
