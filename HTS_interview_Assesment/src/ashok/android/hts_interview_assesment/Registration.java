package ashok.android.hts_interview_assesment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.provider.ContactsContract.Profile;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Registration extends Activity {
	 SharedPreferences pref;
	    Editor editor;
	    Button btn_register;
	    EditText name, phone, email;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_registration);
		name = (EditText) findViewById(R.id.editText1);
	    phone = (EditText) findViewById(R.id.editText2);
	    email = (EditText) findViewById(R.id.editText3);
	    btn_register = (Button) findViewById(R.id.reg_button);
	   
	    // creating an shared Preference file for the information to be stored
	    // first argument is the name of file and second is the mode, 0 is private mode
	   
	    pref = getSharedPreferences("Registration", 0);
	    // get editor to edit in file
	    editor = pref.edit();
	   
	    // the tap of button we will fetch the information from three edittext    
	    btn_register.setOnClickListener(new View.OnClickListener() {
	       
	        public void onClick(View v) {
	        
	        String buyer_name = name.getText().toString();
	        String buyer_phone = phone.getText().toString();
	        String buyer_emai = email.getText().toString();
	   	    
	       
	        if(name.getText().length()<=0){
	            Toast.makeText(Registration.this, "Enter name", Toast.LENGTH_SHORT).show();
	        }
	        else if( phone.getText().length()<=0){
	            Toast.makeText(Registration.this, "Please Enter your 10 digit phone number", Toast.LENGTH_SHORT).show();
	        }
	        else if( email.getText().length()<=0){
	            Toast.makeText(Registration.this, "Please Enter your email address", Toast.LENGTH_SHORT).show();
	        }
	        else{
	       
	        // as now we have information in string. Lets stored them with the help of editor
	       
	        editor.putString("Name", buyer_name);
	        editor.putString("Phone",buyer_phone);
	        editor.putString("Email",buyer_emai);
	        editor.commit();   // commit the values
	        // after saving the value open next activity
	        onBackPressed();
	        
	        
	       
	        }   
	        }
	    });
}
	@Override
	public void onBackPressed() {
	    new AlertDialog.Builder(this)
	           .setMessage("Thanks for your Information..")
	           .setCancelable(false)
	           .setPositiveButton("Facility", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	            	   Intent ob = new Intent(Registration.this, MainActivity.class);
	       	           startActivity(ob);
	       	            
	            	   Registration.this.finish();
	            	   System.exit(0);
	               }
	           })
	           .setNegativeButton("Re-fill", null)
	           .show();
	}

	
}	
