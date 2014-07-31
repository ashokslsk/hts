package test.example.hibisucusproduct;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class custom_list extends ArrayAdapter<String> {
	
	private final Activity context;
	private final String[] web;
	private final Integer[] ImageId;
	
	public custom_list(Activity context, String[] web, Integer[] ImageId){
		super(context,R.layout.single_item,web);
		this.context = context;
		this.web = web;
		this.ImageId = ImageId;
		
	}
	
	@Override
	public View getView(int position, View view, ViewGroup parents){
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.single_item, null, true);
		TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
		txtTitle.setText(web[position]);
		imageView.setImageResource(ImageId[position]);
		return rowView;
		
	}
	
	

}
