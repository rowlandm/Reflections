package com.example.reflections;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class reflections extends Activity {
	
	/* List of questions to ask */
	/*
	 * Good thing to do again
	 * Thing to improve
	 * Actions that stemmed from want of praise
	 * Something new learned
	 * Spiritual
	 * Imagine if I didn't worry about....
	 * Romance
	 * What really annoyed me for no good reason
	 * Rejection
	 * Rescuer, Victim and Persecutor
	 * Good things I did today
	 * Good things she did
	 * Was I harsh on myself?
	 * What did I say I would do?
	 * Organise for tomorrow
	 * What did I do to improve my health
	 * Update Resume
	 * Interesting website
	 * What surprised me today
	 * 
	 */
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /* Do something when text is entered */
        final EditText edittext = (EditText) findViewById(R.id.edittext);
        edittext.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                    (keyCode == KeyEvent.KEYCODE_ENTER)) {
                  // Perform action on key press
                  Toast.makeText(reflections.this, edittext.getText(), Toast.LENGTH_SHORT).show();
                  return true;
                }
                return false;
            }
        });
        
        /* DO something when the rating has been set */
        final RatingBar ratingbar = (RatingBar) findViewById(R.id.ratingbar);
        ratingbar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(reflections.this, "New Rating: " + rating, Toast.LENGTH_SHORT).show();
            }
        });
        
        /* button to go to the next view */
        final Button button = (Button) findViewById(R.id.next_button_id);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Toast.makeText(reflections.this, "You have clicked the next button - good on you", Toast.LENGTH_SHORT).show();
            }
        });
        
    }
}