package lwtech.itad230.ii;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class TimeActivity extends AppCompatActivity {
  public final static String SAVE_TEDITTEXT = "lwtech.itad230.twoactivities.SAVE_TEDITTEXT";
  public final static String SAVE_TTEXTVIEW2 = "lwtech.itad230.twoactivities.SAVE_TTEXTVIEW";
  public final static String SAVE_TMESSAGE = "lwtech.itad230.twoactivities.TMESSAGE";
  EditText eText1, eText2 = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_time);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
          .setAction("Action", null).show();
      }
    });
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }


  /**
   * Called when the user clicks the Set Timer button
   */
  public void btnSetTimer(View v) {
    /* Send an implicit intent to the Android device app that can handle
    the ACTION_SET_TIMER action. Include extras on the intent that specify:
        a message
        the duration in seconds
        skip the user interface and just start the timer
    */
    // Create the text message with a string

    eText1 = (EditText) findViewById(R.id.edtDuration);
    String secondsToRun = eText1.getText().toString();

    eText2 = (EditText) findViewById(R.id.edtMessage);
   String message = eText2.getText().toString();

    Intent Tintent = new Intent(AlarmClock.ACTION_SET_TIMER)
      .putExtra(AlarmClock.EXTRA_MESSAGE, message)
      .putExtra(AlarmClock.EXTRA_LENGTH, secondsToRun)
      .putExtra(AlarmClock.EXTRA_SKIP_UI, false);

    // Verify that the intent will resolve to an activity

    if (Tintent.resolveActivity(getPackageManager()) != null) {
      startActivity(Tintent);

    }
  }
}