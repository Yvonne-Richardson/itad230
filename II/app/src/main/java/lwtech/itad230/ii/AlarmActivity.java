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

public class AlarmActivity extends AppCompatActivity {
  public final static String SAVE_AEDITTEXT = "lwtech.itad230.twoactivities.SAVE_AEDITTEXT";
  public final static String SAVE_ATEXTVIEW = "lwtech.itad230.twoactivities.SAVE_ATEXTVIEW";
  public final static String SAVE_AMESSAGE = "lwtech.itad230.twoactivities.AMESSAGE";
  EditText eText1, eText2, eText3 = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_alarm);
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
  public void btnSetAlarm(View v)  {
    /* Send an implicit intent to the Android device app that can handle
    the ACTION_SET_ALARM action. Include extras on the intent that specify:
        the hour and minutes of the alarm, and the message
    */
    // Create the text message with a string

    eText1 = (EditText) findViewById(R.id.edtHours);
    String hour = eText1.getText().toString();

    eText2 = (EditText) findViewById(R.id.edtMinutes);
    String minutes = eText2.getText().toString();

    eText3 = (EditText) findViewById(R.id.edtMessage);
    String message = eText3.getText().toString();

    Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
    intent.putExtra(AlarmClock.EXTRA_MESSAGE, message);
    intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
    intent.putExtra(AlarmClock.EXTRA_MINUTES, minutes);
    intent.putExtra(AlarmClock.EXTRA_SKIP_UI, false);

// Verify that the intent will resolve to an activity

    if (intent.resolveActivity(getPackageManager()) != null) {
      startActivity(intent);
    }

  }

}
