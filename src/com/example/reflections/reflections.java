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
    			new Quote("The Master was allergic to ideologies. \n\n'In a war of ideas' he said, 'it is people who are the casualties.' \n\n Later he elaborated: 'People kill for money or for power. But the most ruthless murderers are those who kill for their ideas.'",1), 
    			new Quote("'When you speak about Reality,' said the Master, 'you are attempting to put the Inexpressible into words, so your words are certain to be misunderstood. Thus people who read that expression of Reality called the Scriptures become stupid and cruel for they follow, not their common sense, but what they think their Scriptures say.' \n\n He had the perfect parable to show this: \n A village blacksmith found an apprentice willing to work hard at low pay. The smith immediately began his instructions to the lad: 'When I take the metal out of the fire, I'll lay it on the anvil; and when I nod my head you hit it with the hammer.' The apprentice did precisely what he thought he was told. Next day he was the village blacksmith",1),
    			new Quote("'What is the secret of your serenity? \n\nSaid the Master 'Wholehearted cooperation with the inevitable.'",1),
    			new Quote("''Name one practical, down-to-earth effect of spirituality,' said the skeptic who was ready for an argument. \n 'Here's one,' said the Master. 'When someone offends you, you can raise your spirits to heights where offenses cannot reach.''",1),
    			new Quote("The Master once referred to the Hindu notion that all creation is 'leela' — God's play — and the universe is his playground. The aim of spirituality, he claimed, is to make all life play.\n This seemed too frivolous for a puritanical visitor. 'Is their no room then for work?'\n 'Of course there is. But work becomes spiritual only when it is transformed into play.'",1),
    			new Quote("'What is my identity?'\n 'Nothing,' said the Master.\n 'You mean that I am an emptiness and a void?' said the incredulous disciple.\n 'Nothing that can be labeled.' said the Master. \n",1),
    			new Quote("The master enjoined not austerity, but moderation. If we truly enjoyed things, he claimed, we would be spontaneously moderate. Asked why he was so opposed to ascetical practices, he replied, 'Because they produce pleasure-haters who always become people-haters — rigid and cruel.'",1),
    			new Quote("",1),
    			new Quote("",1),
    			new Quote("",1),
    			new Quote("",1),
    			new Quote("",1),
    			new Quote("",1),
    			new Quote("",1),
    			new Quote("",1),
    			new Quote("",1),
    			new Quote("",1),
    			new Quote("",1),
    			new Quote("",1),
    			new Quote("",1),
    			new Quote("",1),
    			new Quote("",1),
    			new Quote("'Tell me,' said the atheist, 'Is there a God — really?' Said the master, 'If you want me to be perfectly honest with you, I will not answer.' \n\n Later the disciples demanded to know why he had not answered. 'Because the question is unanswerable,' said the Master. 'So you are an atheist?' 'Certainly not. \n\n The atheist makes the mistake of denying that of which nothing may be said... and the theist makes the mistake of affirming it.",1)  
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