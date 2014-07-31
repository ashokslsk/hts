package ashok.android.hts_interview_assesment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends Activity implements
		AdapterView.OnItemClickListener {

	SharedPreferences pref;
	GridView grid;
	String[] web = { "Google", "Twitter", "windows" };

	int[] imageId = { R.drawable.image1, R.drawable.image2, R.drawable.image3, };

	private Class[] activities = { Product1.class, Product2.class,
			Product3.class };

	Intent i, j, k;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		CustomGrid adapter = new CustomGrid(MainActivity.this, web, imageId);
		grid = (GridView) findViewById(R.id.grid);
		grid.setAdapter(adapter);

		grid.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.layout.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.Camera:

			Intent b = new Intent(MainActivity.this, Camera.class);
			startActivity(b);

			break;

		case R.id.Registered_data:
			Intent a = new Intent(MainActivity.this, Registered_data.class);
			startActivity(a);

			break;
		}
		return true;

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		String Tag = "abc";
		if (position == 0) {
			Intent i = new Intent(MainActivity.this, Product1.class);
			startActivity(i);

		} else if (position == 1) {
			Intent j = new Intent(MainActivity.this, Product2.class);
			startActivity(j);
		} else if (position == 2) {
			Intent k = new Intent(MainActivity.this, Product3.class);
			startActivity(k);
		}

	}

}
