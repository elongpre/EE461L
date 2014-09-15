package edu.utexas.longpre.trialapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
	private int state = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		RadioGroup group1 = (RadioGroup)findViewById(R.id.orientation);
		group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
		  @Override
		  public void onCheckedChanged(RadioGroup group, int checkedId) {
		    switch (checkedId) {
		      case R.id.horizontal:
		        group.setOrientation(LinearLayout.HORIZONTAL);
		        break;
		      case R.id.vertical:
		        group.setOrientation(LinearLayout.VERTICAL);
		        break;
		    }
		  }
		}); 
		
	}
	
	public void onClick(View view) {
		EditText text = (EditText)findViewById(0x7f060000);
		String message = text.getText().toString();
		Toast.makeText(this, message, Toast.LENGTH_LONG).show();
	}
	
	public void switchImage(View view){
		ImageView image = (ImageView)findViewById(R.id.icon);
		if(state == 0){
			image.setImageResource(R.drawable.steam);
			this.state = 1;
		}else {
			image.setImageResource(R.drawable.dragon);
			this.state = 0;
		}
	}
}
