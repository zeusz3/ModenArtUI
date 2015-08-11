package course.labs.modernartui;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	private DialogFragment dialog;

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
        	dialog = MoreInfoDialog.newInstance();
        	dialog.show(getSupportFragmentManager(), "ALERT");
        }
        return super.onOptionsItemSelected(item);
    }

	
	public static class MoreInfoDialog extends DialogFragment {
		
		public static MoreInfoDialog newInstance() {
			return new MoreInfoDialog();
		}
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the Builder class for convenient dialog construction
	        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	        builder.setMessage(R.string.dialogMsg)
	               .setPositiveButton(R.string.visitMoMA, new DialogInterface.OnClickListener() {
	                   public void onClick(DialogInterface dialog, int id) {
	                       Log.i("DIALOG", "dialog fire pressed");
	                       Intent intent = new Intent(Intent.ACTION_VIEW);
	                       intent.setData(Uri.parse("http://www.moma.org"));
	                       startActivity(intent);
	                   }
	               })
	               .setNegativeButton(R.string.notNow, new DialogInterface.OnClickListener() {
	                   public void onClick(DialogInterface dialog, int id) {
	                	   Log.i("DIALOG", "dialog cancel pressed");
	                   }
	               });
	        // Create the AlertDialog object and return it
	        return builder.create();
		}
	
	}
}