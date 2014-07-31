package ashok.android.hts_interview_assesment;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class SignUpActivity extends Activity {
	 SharedPreferences pref;
	    Editor editor;
	    Button btn_register;
	    EditText name, pass, Email;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_sign_up);
		name = (EditText) findViewById(R.id.usernameField);
	    pass = (EditText) findViewById(R.id.passwordField);
	    Email = (EditText) findViewById(R.id.emailField);
	    btn_register = (Button) findViewById(R.id.signup_Button);
	   
	    // creating an shared Preference file for the information to be stored
	    // first argument is the name of file and second is the mode, 0 is private mode
	   
	    pref = getSharedPreferences("Registration_signup", 0);
	    // get editor to edit in file
	    editor = pref.edit();
	   
	    // the tap of button we will fetch the information from three edittext    
	    btn_register.setOnClickListener(new View.OnClickListener() {
	       
	        public void onClick(View v) {
	        
	        String user_name = name.getText().toString();
	        String user_Pass = pass.getText().toString();
	        String user_Email = Email.getText().toString();
	   	    
	       
	        if(name.getText().length()<=0){
	            Toast.makeText(SignUpActivity.this, "Enter name", Toast.LENGTH_SHORT).show();
	        }
	        else if(pass.getText().length()<=0){
	            Toast.makeText(SignUpActivity.this, "Enter password ", Toast.LENGTH_SHORT).show();
	        }
	        else if( Email.getText().length()<=0){
	            Toast.makeText(SignUpActivity.this, "Enter Email address please", Toast.LENGTH_SHORT).show();
	        }
	        else{
	       
	        // as now we have information in string. Lets stored them with the help of editor
	       
	        editor.putString("User_Name", user_name);
	        editor.putString("User_Pass", user_Pass);
	        editor.putString("Email",user_Email);
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
	            	   Intent ob = new Intent(SignUpActivity.this, MainActivity.class);
	       	           startActivity(ob);
	            	   SignUpActivity.this.finish();
	            	   System.exit(0);
	               }
	           })
	           .setNegativeButton("Re-fill", null)
	           .show();
	}


	
}	

