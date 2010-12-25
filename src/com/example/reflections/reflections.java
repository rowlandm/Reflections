package com.example.reflections;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RatingBar.OnRatingBarChangeListener;


class Quote {
	
	String  quote = "";
	int active = 0;
	
	Quote(String q,int a) {
		
		quote = q;
		active = a;
		
	}
	
}



public class reflections extends Activity {
	
	/* List of quotes to ask */
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
	int currentQuote = -1;
	Quote[] quotes;
	
	private ReflectionsDbAdapter mDbHelper;
	public static final int INSERT_ID = Menu.FIRST;
	
	public void showNextQuote(){
		
		if (this.currentQuote + 1 == quotes.length)
  			return;
		
		this.currentQuote++;
  		
  		setContentView(R.layout.main);
    	
    	TextView labelText = (TextView) findViewById(R.id.label_edittext);
    	
    	labelText.setText(quotes[this.currentQuote].quote);	

    	this.setupTriggers();
    	
	}
	
	public void showPrevQuote(){
		
		if (this.currentQuote == 0) 
    		return;
		
		this.currentQuote = this.currentQuote - 1 ;
    	
    	
		
		setContentView(R.layout.main);
    	
    	TextView labelText = (TextView) findViewById(R.id.label_edittext);
    	
    	labelText.setText(quotes[this.currentQuote].quote);	
	
    	this.setupTriggers();
    	
	}	
	
	public void setupTriggers() {
		
        /* button to go to the previous view */
        final Button buttonPrev = (Button) findViewById(R.id.prev_button_id);
        buttonPrev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	// Toast.makeText(reflections.this, "You have clicked the previous button - good on you", Toast.LENGTH_SHORT).show();
            	reflections.this.showPrevQuote();
            }
        });        
        
        /* button to go to the next view */
        final Button button = (Button) findViewById(R.id.next_button_id);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	// Toast.makeText(reflections.this, "You have clicked the next button - good on you", Toast.LENGTH_SHORT).show();
            	reflections.this.showNextQuote();
            }
        });		
		
		
	}
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	mDbHelper = new ReflectionsDbAdapter(this);
        mDbHelper.open();
    	
    	// setup a basic array
    	
    	quotes = new Quote[] { 
    			new Quote("What did I do well today?",1), 
    			new Quote("What can I do better?",1),
    			new Quote("What actions came from want of praise?",1),
    			new Quote("Rejection?",1)
    	};
    	
    	
    	// do the first quote
    	this.showNextQuote();
        
        
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onCreateOptionsMenu(menu);
        menu.add(0, INSERT_ID, 0, R.string.menu_insert);
        return result;
    }
    

    
    
    
    
}