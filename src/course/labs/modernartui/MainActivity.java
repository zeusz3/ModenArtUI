package course.labs.modernartui;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        final TextView textView1 = (TextView) findViewById(R.id.element1);
        final TextView textView2 = (TextView) findViewById(R.id.element2);
        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
        	@Override
        	public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
        		textView1.setBackgroundColor(android.graphics.Color.rgb(255-progresValue, 0, 0+progresValue));
        		textView2.setBackgroundColor(android.graphics.Color.rgb(0+progresValue, 0, 255-progresValue));
        	}
        	
        	@Override
        	public void onStartTrackingTouch(SeekBar seekBar) {
        		
        	}
        	      
        	@Override
        	public void onStopTrackingTouch(SeekBar seekBar) {
        		
        	}
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        	Intent intent = new Intent(Intent.ACTION_VIEW);
        	intent.setData(Uri.parse("http://www.moma.org"));
         	startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
