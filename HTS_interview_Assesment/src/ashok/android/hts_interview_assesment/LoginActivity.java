package ashok.android.hts_interview_assesment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

	EditText username, userpass;
	public TextView user_name, user_password;
	SharedPreferences pref;

	Button Guest_login;

	TextView signup;

	Intent intent_main;
	boolean state;
	String done;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		username = (EditText) findViewById(R.id.user_name);
		userpass = (EditText) findViewById(R.id.user_password);
		signup = (TextView) findViewById(R.id.Sign_up_link);

		Guest_login = (Button) findViewById(R.id.Guest_login);

		Guest_login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				intent_main = new Intent(LoginActivity.this, MainActivity.class);
				startActivity(intent_main);
			}

		});

		signup.setPaintFlags(signup.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

		signup.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent_signup = new Intent(LoginActivity.this,
						SignUpActivity.class);
				startActivity(intent_signup);
			}
		});

		Button Login = (Button) findViewById(R.id.Login_button);
		Login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				String username1 = username.getText().toString();
				String userpassword1 = userpass.getText().toString();

				pref = getSharedPreferences("Registration_signup", 0);
				String name = pref.getString("User_Name", null);

				pref = getSharedPreferences("Registration_signup", 0);
				String password = pref.getString("User_Pass", null);

				if (username1.equals(name) && userpassword1.equals(password)) {

					Intent intent_main = new Intent(LoginActivity.this,
							MainActivity.class);
					startActivity(intent_main);

				} else {
					warning();
				}

			}

			private void warning() {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Invalid login",
						Toast.LENGTH_SHORT).show();

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
