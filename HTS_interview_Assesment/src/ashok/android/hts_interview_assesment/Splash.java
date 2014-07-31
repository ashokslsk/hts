package ashok.android.hts_interview_assesment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;

public class Splash extends Activity {

	TextView tv1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		tv1 = (TextView) findViewById(R.id.Splash_count_down_timer);

		CountDownTimer cd = new CountDownTimer(5000, 1000) {

			@Override
			public void onTick(long millisUntilFinished) {

				tv1.setText("Please wait..." + "00:"
						+ (millisUntilFinished / 1000));

			}

			@Override
			public void onFinish() {

				SharedPreferences pref = PreferenceManager
						.getDefaultSharedPreferences(getBaseContext());
				pref = getSharedPreferences("Registration_signup", 0);
				String name = pref.getString("User_Name", null);

				pref = getSharedPreferences("Registration_signup", 0);
				String password = pref.getString("User_Pass", null);

				if (TextUtils.isEmpty(name)) {
					Intent intent_Login = new Intent(Splash.this,
							LoginActivity.class);
					startActivity(intent_Login);
				} else {
					Intent intent = new Intent(Splash.this, MainActivity.class);
					startActivity(intent);
				}

			}
		};
		cd.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
