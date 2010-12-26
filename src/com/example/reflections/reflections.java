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
import java.util.Random;

class Quote {
	
	String  quote = "";
	int active = 0;
	
	Quote(String q,int a) {
		
		quote = q;
		active = a;
		
	}
	
}



public class reflections extends Activity {
	
	int currentQuote = -1;
	Quote[] quotes;
	
	public static final int INSERT_ID = Menu.FIRST;
	
	
	public void showRandomQuote(){
		
		final Random myRandom = new Random();
		
		this.currentQuote = myRandom.nextInt(quotes.length);
		
		setContentView(R.layout.main);
    	
    	TextView labelText = (TextView) findViewById(R.id.label_edittext);
    	
    	labelText.setText(quotes[this.currentQuote].quote);	

    	this.setupTriggers();
    	
	}
	
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
		
        /* button to go to the next random view */
        final Button buttonRandom = (Button) findViewById(R.id.random_button_id);
        buttonRandom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	// Toast.makeText(reflections.this, "You have clicked the next button - good on you", Toast.LENGTH_SHORT).show();
            	reflections.this.showRandomQuote();
            }
        });		
		
		
	}
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	// setup a basic array
    	
    	quotes = new Quote[] { 
    			new Quote("The Master was allergic to ideologies. \n\n'In a war of ideas' he said, 'it is people who are the casualties.' \n\n Later he elaborated: 'People kill for money or for power. But the most ruthless murderers are those who kill for their ideas.'",1), 
    			new Quote("'When you speak about Reality,' said the Master, 'you are attempting to put the Inexpressible into words, so your words are certain to be misunderstood. Thus people who read that expression of Reality called the Scriptures become stupid and cruel for they follow, not their common sense, but what they think their Scriptures say.' \n\n He had the perfect parable to show this: \n A village blacksmith found an apprentice willing to work hard at low pay. The smith immediately began his instructions to the lad: 'When I take the metal out of the fire, I'll lay it on the anvil; and when I nod my head you hit it with the hammer.' The apprentice did precisely what he thought he was told. Next day he was the village blacksmith",1),
    			new Quote("'What is the secret of your serenity? \n\nSaid the Master 'Wholehearted cooperation with the inevitable.'",1),
    			new Quote("''Name one practical, down-to-earth effect of spirituality,' said the skeptic who was ready for an argument. \n 'Here's one,' said the Master. 'When someone offends you, you can raise your spirits to heights where offenses cannot reach.''",1),
    			new Quote("The Master once referred to the Hindu notion that all creation is 'leela' — God's play — and the universe is his playground. The aim of spirituality, he claimed, is to make all life play.\n This seemed too frivolous for a puritanical visitor. 'Is their no room then for work?'\n 'Of course there is. But work becomes spiritual only when it is transformed into play.'",1),
    			new Quote("'What is my identity?'\n 'Nothing,' said the Master.\n 'You mean that I am an emptiness and a void?' said the incredulous disciple.\n 'Nothing that can be labeled.' said the Master. \n",1),
    			new Quote("The master enjoined not austerity, but moderation. If we truly enjoyed things, he claimed, we would be spontaneously moderate. Asked why he was so opposed to ascetical practices, he replied, 'Because they produce pleasure-haters who always become people-haters — rigid and cruel.'",1),
    			new Quote("A religious belief… is not a statement about Reality, but a hint, a clue about something that is a mystery, beyond the grasp of human thought. In short, a religious belief is only a finger pointing to the moon. Some religious people never get beyond the study of the finger. Others are engaged in sucking it. Others yet use the finger to gouge their eyes out. These are the bigots whom religion has made blind. Rare indeed is the religionist who is sufficiently detached from the finger to see what it is indicating — these are those who, having gone beyond belief, are taken for blasphemers.",1),
    			new Quote("'What can I do to see Reality as it is?'\n The master smiled and said, 'I have good news and bad news for you, my friend.'\n 'What's the bad news?'\n 'There's nothing you can do to see — it is a gift.'\n 'And what's the good news?'\n 'There's nothing you can do to see — it is a gift.'",1),
    			new Quote("'I seek the meaning of existence.' said the stranger. \n 'You are of course, assuming.' said the Master, 'that existence has a meaning.'\n 'Doesn't it?'\n 'When you experience existence as it is — not as you think it is — you will discover that your question has no meaning.'",1),
    			new Quote("'Isn't there such a thing as social liberation?' \n 'Of course there is,' said the Master.\n 'How would you describe it?'\n 'Liberation from the need to belong to the herd.'",1),
    			new Quote("One always treads with a joyful step when one has dropped the burden called the ego.",1),
    			new Quote("Happiness is our natural state. Happiness is the natural state of little children, to whom the kingdom belongs until they have been polluted and contaminated by the stupidity of society and culture. To acquire happiness you don't have to do anything, because happiness cannot be acquired. Does anybody know why? Because we have it already. How can you acquire what you already have? Then why don't you experience it? Because you've got to drop something. You've got to drop illusions. You don't have to add anything in order to be happy; you've got to drop something. Life is easy, life is delightful. It's only hard on your illusions, your ambitions, your greed, your cravings. Do you know where these things come from? From having identified with all kinds of labels!",1),
    			new Quote("Suffering is a sign that you're out of touch with the truth. Suffering is given to you that you might open your eyes to the truth, that you might understand that there's falsehood somewhere, just as physical pain is given to you so you will understand that there is disease or illness somewhere. Suffering points out that there is falsehood somewhere. Suffering occurs when you clash with reality. When your illusions clash with reality when your falsehoods clash with the truth, then you have suffering. Otherwise there is no suffering.",1),
    			new Quote("Step by step, let whatever happens happen. Real change will come when it is brought about, not by your ego, but by reality. Awareness releases reality to change you.",1),
    			new Quote("As soon as you look at the world through an ideology you are finished. No reality fits an ideology. Life is beyond that. That is why people are always searching for a meaning to life. But life has no meaning; it cannot have meaning because meaning is a formula; meaning is something that makes sense to the mind. Every time you make sense out of reality, you bump into something that destroys the sense you made. Meaning is only found when you go beyond meaning. Life only makes sense when you perceive it as mystery and it makes no sense to the conceptualizing mind.",1),
    			new Quote("This is what Wisdom means: To be changed without the slightest effort on your part, to be transformed, believe it or not, merely by waking to the reality that is not words, that lies beyond the reach of words. If you are fortunate enough to be Awakened thus, you will know why the finest language is the one that is not spoken, the finest action is the one that is not done and the finest change is the one that is not willed.",1),
    			new Quote("To a disciple who was forever complaining about others the Master said, 'If it is peace you want, seek to change yourself, not other people. It is easier to protect your feet with slippers than to carpet the whole of the earth.'",1),
    			new Quote("To a visitor who asked to become his disciple the Master said, 'You may live with me, but don't become my follower.'\n 'Whom, then, shall I follow?' \n 'No one. The day you follow someone you cease to follow Truth.'",1),
    			new Quote("'You are only a disciple because your eyes are closed. The day you open them you will see there is nothing you can learn from me or anyone.'\n 'What then is a Master for?' \n 'To make you see the uselessness of having one.'",1),
    			new Quote("When you are guilty, it is not your sins you hate but yourself.",1),
    			new Quote("When you come to see you are not as wise today as you thought you were yesterday, you are wiser today.",1),
    			new Quote("What would you do if you knew you were going to die tomorrow? \n What would you do if you knew you were going to die next week? What would you do if you were going to die next year? What would you do if you didn't know you were going to die? Because that is the situation you are currently in.",1),
    			new Quote("Just remember it is whatever you want it to be. Life, parenting, school, work, relationships. You can either choose to consider it good or bad. It's whatever you want it to be.",1),
    			new Quote("Expectations that are not met turns into annoyance, frustration and anger. Change the expectations and you change the outcome.",1),
    			new Quote("How can you want more than to be content? If you are not content with being content you will never be content!",1),
    			new Quote("Recognising you are going to die isn't being pessimistic, it is being realistic. Most people try to avoid this - but eventually they have to face it all at once with the death of a loved one or their own mortality.",1),
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