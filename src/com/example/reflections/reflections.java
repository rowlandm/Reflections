package com.example.reflections;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



class FontSize {
	
	int small = 14;
	int medium = 16;
	int large = 18;
	int current = 14;
	
	
	public void setSmall() {
		this.current = this.small;
	}
	
	public void setMedium() {
		this.current = this.medium;
	}
	
	public void setLarge() {
		this.current = this.large;
	}
	
	public void setCurrent(int value){
		
		this.current = value;
		
	}
	
	public int getOrder(){
		
		int currentOrder = 0;
		switch(this.current){
			
		case 14:
			currentOrder = 0;
			break;
		case 16:
			currentOrder = 1;
			break;
		case 18: 
			currentOrder = 2;
			break;
			
		
		}
		return currentOrder;
	}
	
	public int getCurrent() {
		return this.current;
	}
}

class Quote {
	
	String  quote = "";
	int active = 0;
	
	Quote(String q,int a) {
		
		quote = q;
		active = a;
		
	}
	
}

class savedState {
	
	int quote = -1;
	boolean inAboutUsMenu = false;
	int fontSize = 14;
	
}

public class reflections extends Activity {
	
	int currentQuote = -1;
	boolean inAboutUsMenu = false;
	
	FontSize fontSize = new FontSize();	
	Quote[] quotes;
	
	public static final int INSERT_ID = Menu.FIRST;
	static final int DIALOG_CHOOSE_FONT = 0;
	
	
	
	
	public void showRandomQuote(){
		
		this.inAboutUsMenu = false;
		
		final Random myRandom = new Random();
		
		this.currentQuote = myRandom.nextInt(quotes.length);
		
		DisplayMetrics dm = new DisplayMetrics(); 
    	getWindowManager().getDefaultDisplay().getMetrics(dm); 
    	int screenHeight = dm.heightPixels;
    	int screenWidth = dm.widthPixels;
    	
    	if (screenHeight > screenWidth){
    		setContentView(R.layout.main_portrait);
    	} else {
    		setContentView(R.layout.main);
    	}
    	
    	// hide next button if this is the end
    	if (this.currentQuote + 1 == quotes.length){
	    	final Button button = (Button) findViewById(R.id.next_button_id);
	        button.setVisibility(View.VISIBLE);		
	        button.setTextColor(Color.parseColor("#BBBBBB"));
	        
	        final Button buttonNextBottom = (Button) findViewById(R.id.next_button_id_bottom);
	        buttonNextBottom.setVisibility(View.VISIBLE);
	        buttonNextBottom.setTextColor(Color.parseColor("#BBBBBB"));
    	}
    	
    	// hide prev button if this is the start
    	if (this.currentQuote == 0){
	    	final Button button = (Button) findViewById(R.id.prev_button_id);
	        button.setVisibility(View.VISIBLE);		
	        button.setTextColor(Color.parseColor("#BBBBBB"));
	        
	        final Button buttonPrevBottom = (Button) findViewById(R.id.prev_button_id_bottom);
	        buttonPrevBottom.setVisibility(View.VISIBLE);
	        buttonPrevBottom.setTextColor(Color.parseColor("#BBBBBB"));
    	}
    	
    	TextView labelText = (TextView) findViewById(R.id.label_edittext);
    	
    	labelText.setText(quotes[this.currentQuote].quote);	
    	labelText.setTextSize(this.fontSize.getCurrent());
    	
    	this.setupTriggers("All");
    	
	}
	
	public void showNextQuote(){
		
		this.inAboutUsMenu = false;
		
		if (this.currentQuote + 1 == quotes.length)
  			return;
		
		this.currentQuote++;
  		
		DisplayMetrics dm = new DisplayMetrics(); 
    	getWindowManager().getDefaultDisplay().getMetrics(dm); 
    	int screenHeight = dm.heightPixels;
    	int screenWidth = dm.widthPixels;
    	
    	if (screenHeight > screenWidth){
    		setContentView(R.layout.main_portrait);
    	} else {
    		setContentView(R.layout.main);
    	}
    	
    	// hide next button if this is the end
    	if (this.currentQuote + 1 == quotes.length){
	    	final Button button = (Button) findViewById(R.id.next_button_id);
	        button.setVisibility(View.VISIBLE);		
	        button.setTextColor(Color.parseColor("#BBBBBB"));
	        
	        final Button buttonNextBottom = (Button) findViewById(R.id.next_button_id_bottom);
	        buttonNextBottom.setVisibility(View.VISIBLE);
	        buttonNextBottom.setTextColor(Color.parseColor("#BBBBBB"));
    	}
    	
    	// hide prev button if this is the start
    	if (this.currentQuote == 0){
	    	final Button button = (Button) findViewById(R.id.prev_button_id);
	        button.setVisibility(View.VISIBLE);
	        button.setTextColor(Color.parseColor("#BBBBBB"));
	        
	        final Button buttonPrevBottom = (Button) findViewById(R.id.prev_button_id_bottom);
	        buttonPrevBottom.setVisibility(View.VISIBLE);
	        buttonPrevBottom.setTextColor(Color.parseColor("#BBBBBB"));
    	}
    	
    	TextView labelText = (TextView) findViewById(R.id.label_edittext);
    	
    	labelText.setText(quotes[this.currentQuote].quote);	
    	
    	labelText.setTextSize(this.fontSize.getCurrent());
    	
    	this.setupTriggers("All");
    	
	}
	
	public void showPrevQuote(){
		
		this.inAboutUsMenu = false;
		
		if (this.currentQuote == 0) 
    		return;
		
		this.currentQuote = this.currentQuote - 1 ;
    	
    	
		DisplayMetrics dm = new DisplayMetrics(); 
    	getWindowManager().getDefaultDisplay().getMetrics(dm); 
    	int screenHeight = dm.heightPixels;
    	int screenWidth = dm.widthPixels;
    	
    	if (screenHeight > screenWidth){
    		setContentView(R.layout.main_portrait);
    	} else {
    		setContentView(R.layout.main);
    	}
    	
    	// hide next button if this is the end
    	if (this.currentQuote + 1 == quotes.length){
	    	final Button button = (Button) findViewById(R.id.next_button_id);
	        button.setVisibility(View.VISIBLE);		
	        button.setTextColor(Color.parseColor("#BBBBBB"));
	        
	        final Button buttonNextBottom = (Button) findViewById(R.id.next_button_id_bottom);
	        buttonNextBottom.setVisibility(View.VISIBLE);
	        buttonNextBottom.setTextColor(Color.parseColor("#BBBBBB"));
    	}
    	
    	// hide prev button if this is the start
    	if (this.currentQuote == 0){
	    	final Button button = (Button) findViewById(R.id.prev_button_id);
	        button.setVisibility(View.VISIBLE);		
	        button.setTextColor(Color.parseColor("#BBBBBB"));
	        
	        final Button buttonPrevBottom = (Button) findViewById(R.id.prev_button_id_bottom);
	        buttonPrevBottom.setVisibility(View.VISIBLE);
	        buttonPrevBottom.setTextColor(Color.parseColor("#BBBBBB"));
    	}
    	
    	TextView labelText = (TextView) findViewById(R.id.label_edittext);
    	
    	labelText.setText(quotes[this.currentQuote].quote);	
    	labelText.setTextSize(this.fontSize.getCurrent());
    	this.setupTriggers("All");
    	
	}	
	
	public void showCurrentQuote(){
		
		this.inAboutUsMenu = false;
		
		DisplayMetrics dm = new DisplayMetrics(); 
    	getWindowManager().getDefaultDisplay().getMetrics(dm); 
    	int screenHeight = (int) dm.heightPixels;
    	int screenWidth = (int) dm.widthPixels;
    	
    	if (screenHeight > screenWidth){
    		setContentView(R.layout.main_portrait);
    	} else {
    		setContentView(R.layout.main);
    	}

    	// hide next button if this is the end
    	if (this.currentQuote + 1 == quotes.length){
	    	final Button button = (Button) findViewById(R.id.next_button_id);
	        button.setVisibility(View.VISIBLE);		
	        button.setTextColor(Color.parseColor("#BBBBBB"));
	        
	        final Button buttonNextBottom = (Button) findViewById(R.id.next_button_id_bottom);
	        buttonNextBottom.setVisibility(View.VISIBLE);
	        buttonNextBottom.setTextColor(Color.parseColor("#BBBBBB"));
    	}
    	
    	// hide prev button if this is the start
    	if (this.currentQuote == 0){
	    	final Button button = (Button) findViewById(R.id.prev_button_id);
	        button.setVisibility(View.VISIBLE);		
	        button.setTextColor(Color.parseColor("#BBBBBB"));
	        
	        final Button buttonPrevBottom = (Button) findViewById(R.id.prev_button_id_bottom);
	        buttonPrevBottom.setVisibility(View.VISIBLE);
	        button.setTextColor(Color.parseColor("#BBBBBB"));
    	}
    	
    	TextView labelText = (TextView) findViewById(R.id.label_edittext);
    	
    	labelText.setText(quotes[this.currentQuote].quote);	
    	labelText.setTextSize(this.fontSize.getCurrent());
    	
    	this.setupTriggers("All");
    	
	}
	
	public void showAboutUs(){
		
		this.inAboutUsMenu = true;
		setContentView(R.layout.about_us);
		
		TextView aboutUsText = (TextView) findViewById(R.id.about_us_text);
		
		aboutUsText.setTextSize(this.fontSize.getCurrent());
    	
    	this.setupTriggers("Random");
		
    	
	}	

    
    @Override
    protected Dialog onCreateDialog(int id) {
        AlertDialog alert;
        
        switch(id) {
        case DIALOG_CHOOSE_FONT:
            // do the work to define the pause Dialog
        	final CharSequence[] items = {"Small", "Medium", "Large"};

    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder.setTitle("Pick a font size");
    		builder.setSingleChoiceItems(items,reflections.this.fontSize.getOrder(), new DialogInterface.OnClickListener() {
    		    public void onClick(DialogInterface dialog, int item) {
    		    	
    		    	//Toast.makeText(getApplicationContext(), item , Toast.LENGTH_SHORT).show();
    		    	
    		    	
    		    	switch(item){
    		    	case 0:
    		    		//Toast.makeText(getApplicationContext(), "0" , Toast.LENGTH_SHORT).show();
    		    		reflections.this.fontSize.setSmall();
    		    		break;
    		    	case 1:
    		    		//Toast.makeText(getApplicationContext(), "1" , Toast.LENGTH_SHORT).show();
    		    		reflections.this.fontSize.setMedium();
    		    		break;
    		    	
    		    	case 2:
    		    		//Toast.makeText(getApplicationContext(), "2" , Toast.LENGTH_SHORT).show();
    		    		reflections.this.fontSize.setLarge();
    		    		break;
    		    	
    		    		
    		    	}
    		    	
    		    	reflections.this.showCurrentQuote();
    		        dialog.cancel();
    		    }
    		});
    		alert = builder.create();
    		
    		
            break;
        default:
            alert = null;
        }
        
        
        
        return alert;
    }	
	
	
	public void setupTriggers(String ButtonsToTrigger) {
		
        /* button to go to the previous view */
		// if(strVowels.compareTo("AEIOU") == 0)
		if (ButtonsToTrigger.compareTo("Previous") ==0  || ButtonsToTrigger.compareTo("All") == 0 ) {
	        final Button buttonPrev = (Button) findViewById(R.id.prev_button_id);
	        buttonPrev.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                // Perform action on click
	            	// Toast.makeText(reflections.this, "You have clicked the previous button - good on you", Toast.LENGTH_SHORT).show();
	            	reflections.this.showPrevQuote();
	            }
	        });        
	        
	        
	        final Button buttonPrevBottom = (Button) findViewById(R.id.prev_button_id_bottom);
	        buttonPrevBottom.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                // Perform action on click
	            	// Toast.makeText(reflections.this, "You have clicked the previous button - good on you", Toast.LENGTH_SHORT).show();
	            	reflections.this.showPrevQuote();
	            }
	        }); 
		}
        
        /* button to go to the next view */
		if (ButtonsToTrigger.compareTo("Next") ==0  || ButtonsToTrigger.compareTo("All") == 0 ) {
	        final Button button = (Button) findViewById(R.id.next_button_id);
	        button.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                // Perform action on click
	            	// Toast.makeText(reflections.this, "You have clicked the next button - good on you", Toast.LENGTH_SHORT).show();
	            	reflections.this.showNextQuote();
	            }
	        });		
	        
	        final Button buttonNextBottom = (Button) findViewById(R.id.next_button_id_bottom);
	        buttonNextBottom.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                // Perform action on click
	            	// Toast.makeText(reflections.this, "You have clicked the next button - good on you", Toast.LENGTH_SHORT).show();
	            	reflections.this.showNextQuote();
	            }
	        });	
		}
		
        /* button to go to the next random view */
		if (ButtonsToTrigger.compareTo("Random") ==0  || ButtonsToTrigger.compareTo("All") == 0 ) {
	        final Button buttonRandom = (Button) findViewById(R.id.random_button_id);
	        buttonRandom.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                // Perform action on click
	            	// Toast.makeText(reflections.this, "You have clicked the next button - good on you", Toast.LENGTH_SHORT).show();
	            	reflections.this.showRandomQuote();
	            	
	            	
	            }
	        });		
	        
	        
	        if (ButtonsToTrigger.compareTo("All") == 0 ) {
		        final Button buttonRandomBottom = (Button) findViewById(R.id.random_button_id_bottom);
		        buttonRandomBottom.setOnClickListener(new View.OnClickListener() {
		            public void onClick(View v) {
		                // Perform action on click
		            	// Toast.makeText(reflections.this, "You have clicked the next button - good on you", Toast.LENGTH_SHORT).show();
		            	reflections.this.showRandomQuote();
		            }
		        });
	        }
		}
		
		if (ButtonsToTrigger.compareTo("Random") ==0 ) {
	        final Button buttonBack = (Button) findViewById(R.id.back_button_id);
	        buttonBack.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                // Perform action on click
	            	// Toast.makeText(reflections.this, "You have clicked the next button - good on you", Toast.LENGTH_SHORT).show();
	            	reflections.this.showCurrentQuote();
	            }
	        });	
			
		}
		
		
		if (ButtonsToTrigger.compareTo("Random") !=0 ) {
			final Button buttonSendEmail = (Button) findViewById(R.id.send_email_button_id);
			buttonSendEmail.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                // Perform action on click
	            	reflections.this.sendEmail();
	            }
	        });	
			
			
			final Button buttonBottomSendEmail = (Button) findViewById(R.id.send_email_button_id_bottom);
			buttonBottomSendEmail.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                reflections.this.sendEmail();
	            }
	        });	
			
		}
		
	}
	
	public void sendEmail(){
		
		// Perform action on click
    	
    	Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        
        String emailTo[] = {""};
        String emailSubject = "Quote from Reflections";
        String emailBody = quotes[reflections.this.currentQuote].quote;
        emailIntent.setType("text/html");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,emailTo);
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,emailSubject);
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, emailBody);
        startActivity(Intent.createChooser(emailIntent, "Send email in:"));
	}
	
	
	@Override
	public Object onRetainNonConfigurationInstance() {
		
		final savedState currentState = new savedState();
		
		currentState.fontSize = this.fontSize.getCurrent();
    	currentState.quote = this.currentQuote;
		currentState.inAboutUsMenu = this.inAboutUsMenu;
		
	    return currentState;
	}
	
    /** Called when the activity is first created or when application changes orientation */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	super.onCreate(savedInstanceState);
    
    	// setup a basic array
    	
    	quotes = new Quote[] {
    			new Quote("The only way someone can be of help to you is in challenging your ideas. If you’re ready to listen and if you’re ready to be challenged, there’s one thing that you can do, but no one can help you. What is this most important thing of all? I’m talking about self-observation. What’s that? \n\nIt means to watch everything in you and around you as far as possible and watch it as if it were happening to someone else. What does that last sentence mean? It means that you do not personalize what is happening to you. It means that you look at things as if you have no connection with them whatsoever.\n\nClouds come and go: some of them are black and some white, some of them are large, others small. If we want to follow the analogy, you would be the sky, observing the clouds. You are a passive, detached observer.\n\n -- Anthony De Mello, Awareness",1),
    			new Quote("As you identify less and less with the 'me,' you will be more at ease with everybody and with everything. Do you know why? \n\nBecause you are no longer afraid of being hurt or not liked. You no longer desire to impress anyone. Can you imagine the relief when you don't have to impress anybody anymore? Oh, what a relief. Happiness at last! \n\nYou no longer feel the need or the compulsion to explain things anymore. It's all right. What is there to be explained? And you don't feel the need or compulsion to apologize anymore. \n\nI'd much rather hear you say, 'I've come awake,' than hear you say, 'I'm sorry.' \n\nI'd much rather hear you say to me, 'I've come awake since we last met; what I did to you won't happen again,' than to hear you say, 'I'm so sorry for what I did to you.' \n\nWhy would anyone demand an apology? You have something to explore in that. Even when someone supposedly was mean to you, there is no room for apology. \n\n -- Anthony De Mello, Awareness",1),
    			new Quote("Nobody was mean to you. Somebody was mean to what he or she thought was you, but not to you. Nobody ever rejects you; they're only rejecting what they think you are. But that cuts both ways. \n\nNobody ever accepts you either. Until people come awake, they are simply accepting or rejecting their image of you. They've fashioned an image of you, and they're rejecting or accepting that. \n\nSee how devastating it is to go deeply into that. It's a bit too liberating. \n\nBut how easy it is to love people when you understand this. How easy it is to love everyone when you don't identify with what they imagine you are or they are. It becomes easy to love them, to love everybody. \n\n -- Anthony De Mello, Awareness",1),
    			new Quote("Be aware of your presence in this room. Say to yourself, “I’m in this room.” It’s as if you were outside yourself looking at yourself. Notice a slightly different feeling than if you were looking at things in the room. Later we’ll ask, “Who is this person who is doing the looking?” I am looking at me. What’s an “I”? What’s “me”? For the time being it’s enough that I watch me, but if you find yourself condemning yourself or approving yourself, don’t stop the condemnation and don’t stop the judgment or approval, just watch it. I’m condemning me; I’m disapproving of me; I’m approving of me. Just look at it, period. Don’t try to change it! Don’t say, “Oh, we were told not to do this.” Just observe what’s going on. As I said to you before, self-observation means watching — observing whatever is going on in you and around you as if it were happening to someone else.\n\n -- Anthony De Mello, Awareness",1),
    			new Quote("'Name one practical, down-to-earth effect of spirituality,' said the skeptic who was ready for an argument. \n\n'Here's one,' said the Master. 'When someone offends you, you can raise your spirits to heights where offenses cannot reach.'\n\n -- Anthony De Mello, One Minute Nonsense",1),
    			new Quote("Often you can be driven to control the outcome and this comes at a price to your emotional state. Before the outcome arrives comes anxiousness and pressure. If your desired outcome does not eventuate you will get angry. \n\nBut if you surrender to the outcome, you will be calm and composed. If the outcome is not preferred then you can vote with your feet and walk away.",1),
    			new Quote("To a disciple who was forever complaining about others the Master said, 'If it is peace you want, seek to change yourself, not other people. It is easier to protect your feet with slippers than to carpet the whole of the earth.'\n\n -- Anthony De Mello, One Minute Wisdom",1),
    			new Quote("'What is my identity?'\n\n'Nothing,' said the Master.\n\n'You mean that I am an emptiness and a void?' said the incredulous disciple.\n\n'Nothing that can be labeled.' said the Master.\n\n -- Anthony De Mello, One Minute Nonsense",1),
    			new Quote("We depend on the butcher, the baker, the candlestick maker. Interdependence. That’s fine! We set up society this way and we allot different functions to different people for the welfare of everyone, so that we will function better and live more effectively—at least we hope so. But to depend on another psychologically—to depend on another emotionally—what does that imply? It means to depend on another human being for my happiness.\n\nThink about that. Because if you do, the next thing you will be doing, whether you’re aware of it or not, is demanding that other people contribute to your happiness. Then there will be a next step—fear, fear of loss, fear of alienation, fear of rejection, mutual control. Perfect love casts out fear. Where there is love there are no demands, no expectations, no dependency. I do not demand that you make me happy; my happiness does not lie in you. If you were to leave me, I will not feel sorry for myself; I enjoy your company immensely, but I do not cling.\n\n -- Anthony De Mello, Awareness",1),
    			new Quote("Segregation goes hand in hand with labels. Label yourself and you inherently start to segregate people. This can lead to atrocities if it is taken far enough.\n\nThe only label you can give yourself that will not create segregation with other people is if you label yourself a human being.",1),
    			new Quote("Suffering is a sign that you're out of touch with the truth. \n\nSuffering is given to you that you might open your eyes to the truth, that you might understand that there's falsehood somewhere, just as physical pain is given to you so you will understand that there is disease or illness somewhere. \n\nSuffering points out that there is falsehood somewhere. Suffering occurs when you clash with reality. \n\nWhen your illusions clash with reality when your falsehoods clash with the truth, then you have suffering. \n\nOtherwise there is no suffering.\n\n -- Anthony De Mello, Awareness",1),
    			new Quote("Someone once said, “The three most difficult things for a human being are not physical feats or intellectual achievements. They are, first, returning love for hate; second, including the excluded; third, admitting that you are wrong.” But these are the easiest things in the world if you haven’t identified with the “me.” You can say things like “I’m wrong! If you knew me better, you’d see how often I’m wrong. What would you expect from an ass?” But if I haven’t identified with these aspects of “me,” you can’t hurt me. Initially, the old conditioning will kick in and you’ll be depressed and anxious. You’ll grieve, cry, and so on. “Before enlightenment, I used to be depressed: after enlightenment, I continue to be depressed.” But there’s a difference: I don’t identify with it anymore. Do you know what a big difference that is?\n\nYou step outside of yourself and look at that depression, and don’t identify with it. You don’t do a thing to make it go away; you are perfectly willing to go on with your life while it passes through you and disappears. If you don’t know what that means, you really have something to look forward to. And anxiety? There it comes and you’re not troubled. How strange! You’re anxious but you’re not troubled. \n\nIsn’t that a paradox? And you’re willing to let this cloud come in, because the more you fight it, the more power you give it. You’re willing to observe it as it passes by. You can be happy in your anxiety. Isn’t that crazy? You can be happy in your depression.\n\n -- Anthony De Mello, Awareness",1),
    			new Quote("I must not fear.\n\nFear is the mind-killer.\n\nFear is the little-death that brings total obliteration.\n\nI will face my fear.\n\nI will permit it to pass over me and through me.\n\nAnd when it has gone past I will turn the inner eye to see its path.\n\nWhere the fear has gone there will be nothing.\n\nOnly I will remain\n\n -- Litany Against Fear, Frank Herbert, Dune",1),
    			new Quote("It is adult behaviour to ask for something you want.  It is also adult behaviour to accept the situation of someone refusing your request.",1),
    			new Quote("It is adult behaviour to voice your opinion.  It is also adult behaviour to accept if no-one agrees with your opinion.",1),
    			new Quote("A real success is the person who performs at or close to the best of her or his ability, most of the time, in all of the important areas of his or her life.  She or he will be as successful as his or her inherited potential, past experiences and present circumstances permit, in the careeers of her or his choice, in intimate and social relationships, and in the recreations of his or her choice.  She or he is making the realistic best of what he or she got in the lottery of life.\n\n -- The Truth about Success and Motivation by Dr Bob Montgomery",1),
    			new Quote("Ignorance and fear, ignorance caused by fear, that’s where all the evil comes from, that’s where your violence comes from. The person who is truly nonviolent, who is incapable of violence, is the person who is fearless. It’s only when you’re afraid that you become angry. Think of the last time you were angry. Go ahead. Think of the last time you were angry and search for the fear behind it. What were you afraid of losing? What were you afraid would be taken from you? That’s where the anger comes from. Think of an angry person, maybe someone you’re afraid of. Can you see how frightened he or she is? He’s really frightened, he really is. She’s really frightened or she wouldn’t be angry.\n\n -- Anthony De Mello, Awareness",1),
    			new Quote("There’s a lovely saying of Tranxu, a great Chinese sage, that I took the trouble to learn by heart. It goes: “When the archer shoots for no particular prize, he has all his skills; when he shoots to win a brass buckle, he is already nervous; when he shoots for a gold prize, he goes blind, sees two targets, and is out of his mind. His skill has not changed, but the prize divides him. He cares! He thinks more of winning than of shooting, and the need to win drains him of power.” Isn’t that an image of what most people are? When you’re living for nothing, you’ve got all your skills, you’ve got all your energy, you’re relaxed, you don’t care, it doesn’t matter whether you win or lose.\n\n -- Anthony De Mello, Awareness",1),
    			new Quote("Be careful if you are a rescuer as you can end up treating the other person as a victim. Also, by trying to help to gain a reward of thanks you are increasing your chances of being bitter if no thanks arrives. Sometimes this can even turn you into a persecuter.  \n\nInstead, only help if you recognise that each person has the ability to fix their own problems and you don't expect to be thanked but still want to help.",1),
    			new Quote("'Isn't there such a thing as social liberation?' \n\n'Of course there is,' said the Master.\n\n'How would you describe it?'\n\n'Liberation from the need to belong to the herd.'\n\n -- Anthony De Mello, One Minute Nonsense",1),
    			new Quote("The Master was allergic to ideologies. \n\n'In a war of ideas' he said, 'it is people who are the casualties.' \n\nLater he elaborated: 'People kill for money or for power. But the most ruthless murderers are those who kill for their ideas.\n\n -- Anthony De Mello, One Minute Nonsense",1),
    			new Quote("To be a good person you have to think bad thoughts but choose not to follow through with the associated action. A person who does not think bad thoughts is merely innocent or naive.",1),
    			new Quote("'When you speak about Reality,' said the Master, 'you are attempting to put the Inexpressible into words, so your words are certain to be misunderstood. Thus people who read that expression of Reality called the Scriptures become stupid and cruel for they follow, not their common sense, but what they think their Scriptures say.' \n\nHe had the perfect parable to show this: \n\nA village blacksmith found an apprentice willing to work hard at low pay. The smith immediately began his instructions to the lad: 'When I take the metal out of the fire, I'll lay it on the anvil; and when I nod my head you hit it with the hammer.' The apprentice did precisely what he thought he was told. Next day he was the village blacksmith\n\n -- Anthony De Mello, One Minute Nonsense",1),
    			new Quote("'What is the secret of your serenity? \n\nSaid the Master 'Wholehearted cooperation with the inevitable.'\n\n -- Anthony De Mello, One Minute Nonsense",1),
    			new Quote("A scientist observes the behavior of ants with no further end in view than to study ants, to learn as much as possible about them. He has no other aim. He’s not attempting to train them or get anything out of them. He’s interested in ants, he wants to learn as much as possible about them. That’s his attitude. The day you attain a posture like that, you will experience a miracle. You will change—effortlessly, correctly.\n\n -- Anthony De Mello, Awareness",1),
    			new Quote("Be aware of what is actually happening in Reality instead of what is happening within your head. \n\nPeople tend to project their strengths and weaknesses onto others by assuming they think the exact same way. They don't. \n\nIf you want to know what someone is thinking the adult way is to ask them.",1),
    			new Quote("I’m told my great Indian culture has produced all these mystics. I didn’t produce them. I’m not responsible for them. Or they tell me, “That country of yours and its poverty—it’s disgusting.” I feel ashamed. But I didn’t create it. What’s going on? Did you ever stop to think? People tell you, “I think you’re very charming,” so I feel wonderful. I get a positive stroke (that’s why they call it I’m O.K., you’re O.K.). \n\nI’m going to write a book someday and the title will be I’m an Ass, You’re an Ass. That’s the most liberating, wonderful thing in the world, when you openly admit you’re an ass. It’s wonderful. When people tell me, “You’re wrong.” I say, “What can you expect of an ass?”\n\n -- Anthony De Mello, Awareness",1),
    			new Quote("The Master once referred to the Hindu notion that all creation is 'leela' — God's play — and the universe is his playground. The aim of spirituality, he claimed, is to make all life play.\n\nThis seemed too frivolous for a puritanical visitor. 'Is their no room then for work?'\n\n'Of course there is. But work becomes spiritual only when it is transformed into play.'\n\n -- Anthony De Mello, One Minute Nonsense",1),
    			new Quote("'What is my identity?'\n\n'Nothing,' said the Master.\n\n'You mean that I am an emptiness and a void?' said the incredulous disciple.\n\n'Nothing that can be labeled.' said the Master.\n\n -- Anthony De Mello, One Minute Nonsense",1),
    			new Quote("You’re not O.K. and you’re not not O.K., you’re you. I hope that is going to be the big discovery, at least for some of you. If three or four of you make this discovery during these days we spend together, my, what a wonderful thing! Extraordinary! Cut out all the O.K. stuff and the not-O.K. stuff; cut out all the judgments and simply observe, watch. You’ll make great discoveries. These discoveries will change you. \n\n -- Anthony De Mello, Awareness",1),
    			new Quote("The master enjoined not austerity, but moderation. If we truly enjoyed things, he claimed, we would be spontaneously moderate.\n\nAsked why he was so opposed to ascetical practices, he replied, 'Because they produce pleasure-haters who always become people-haters — rigid and cruel.'\n\n -- Anthony De Mello, One Minute Nonsense",1),
    			new Quote("Slow down. Make your everyday actions deliberate by being in the moment and you might make your tension about the future disappear.",1),
    			new Quote("The way to do more good deeds is to slow down enough to have the spare time to do them.",1),
    			new Quote("A disciple had to rush back home when he got news that his house had burnt down.\n\nHe was an old man and everyone commiserated with him on his return.  All that the Master said to him was,\"This will make dying easier.\"\n\n -- Anthony De Mello, One Minute Nonsense",1),
    			new Quote("A religious belief… is not a statement about Reality, but a hint, a clue about something that is a mystery, beyond the grasp of human thought. In short, a religious belief is only a finger pointing to the moon. \n\nSome religious people never get beyond the study of the finger. \n\nOthers are engaged in sucking it. \n\nOthers yet use the finger to gouge their eyes out. These are the bigots whom religion has made blind. \n\nRare indeed is the religionist who is sufficiently detached from the finger to see what it is indicating — these are those who, having gone beyond belief, are taken for blasphemers.\n\n -- Anthony De Mello, One Minute Nonsense",1),
    			new Quote("'What can I do to see Reality as it is?'\n\nThe master smiled and said, 'I have good news and bad news for you, my friend.'\n\n'What's the bad news?'\n\n'There's nothing you can do to see — it is a gift.'\n\n'And what's the good news?'\n\n'There's nothing you can do to see — it is a gift.'\n\n -- Anthony De Mello, One Minute Nonsense",1),
    			new Quote("'I seek the meaning of existence.' said the stranger. \n\n'You are of course, assuming.' said the Master, 'that existence has a meaning.'\n\n'Doesn't it?'\n\n'When you experience existence as it is — not as you think it is — you will discover that your question has no meaning.'\n\n -- Anthony De Mello, One Minute Nonsense",1),
    			new Quote("'Isn't there such a thing as social liberation?' \n\n'Of course there is,' said the Master.\n\n'How would you describe it?'\n\n'Liberation from the need to belong to the herd.'\n\n -- Anthony De Mello, One Minute Nonsense",1),
    			new Quote("One always treads with a joyful step when one has dropped the burden called the ego.\n\n -- Anthony De Mello, One Minute Nonsense",1),
    			new Quote("Happiness is our natural state. Happiness is the natural state of little children, to whom the kingdom belongs until they have been polluted and contaminated by the stupidity of society and culture. \n\nTo acquire happiness you don't have to do anything, because happiness cannot be acquired. Does anybody know why? Because we have it already. \n\nHow can you acquire what you already have? Then why don't you experience it? Because you've got to drop something. You've got to drop illusions. You don't have to add anything in order to be happy; you've got to drop something. \n\nLife is easy, life is delightful. It's only hard on your illusions, your ambitions, your greed, your cravings. Do you know where these things come from? From having identified with all kinds of labels!\n\n -- Anthony De Mello, Awareness",1),
    			new Quote("Step by step, let whatever happens happen. Real change will come when it is brought about, not by your ego, but by reality. Awareness releases reality to change you.\n\n -- Anthony De Mello, Awareness",1),
    			new Quote("As soon as you look at the world through an ideology you are finished. No reality fits an ideology. Life is beyond that. \n\nThat is why people are always searching for a meaning to life. But life has no meaning; it cannot have meaning because meaning is a formula; meaning is something that makes sense to the mind. \n\nEvery time you make sense out of reality, you bump into something that destroys the sense you made. \n\nMeaning is only found when you go beyond meaning. \n\nLife only makes sense when you perceive it as mystery and it makes no sense to the conceptualizing mind.\n\n -- Anthony De Mello, Awareness",1),
    			new Quote("This is what Wisdom means: To be changed without the slightest effort on your part, to be transformed, believe it or not, merely by waking to the reality that is not words, that lies beyond the reach of words. \n\nIf you are fortunate enough to be Awakened thus, you will know why the finest language is the one that is not spoken, the finest action is the one that is not done and the finest change is the one that is not willed.\n\n -- Anthony De Mello, One Minute Nonsense",1),
    			new Quote("To a visitor who asked to become his disciple the Master said, 'You may live with me, but don't become my follower.'\n\n'Whom, then, shall I follow?' \n\n'No one. The day you follow someone you cease to follow Truth.'\n\n -- Anthony De Mello, One Minute Wisdom",1),
    			new Quote("'You are only a disciple because your eyes are closed. The day you open them you will see there is nothing you can learn from me or anyone.'\n\n'What then is a Master for?' \n\n'To make you see the uselessness of having one.'\n\n -- Anthony De Mello, One Minute Wisdom",1),
    			new Quote("When you are guilty, it is not your sins you hate but yourself.\n\n -- Anthony De Mello, One Minute Wisdom",1),
    			new Quote("When you come to see you are not as wise today as you thought you were yesterday, you are wiser today.\n\n -- Anthony De Mello, One Minute Wisdom",1),
    			new Quote("What would you do if you knew you were going to die tomorrow? \n\nWhat would you do if you knew you were going to die next week? \n\nWhat would you do if you were going to die next year? \n\nWhat would you do if you didn't know you were going to die? \n\nBecause not knowing when you are going to die is the situation you are currently in.",1),
    			new Quote("Just remember it is whatever you want it to be. \n\nLife, parenting, school, work, relationships. \n\nYou can either choose to consider it a boon or a burden. It's whatever you want it to be.",1),
    			new Quote("Expectations that are not met turns into annoyance, frustration and anger. Change the expectations and you change the outcome.",1),
    			new Quote("How can you want more than to be content? If you are not content with being content you will never be content.",1),
    			new Quote("People tend to have this idea that children are controllable. But no one can be controlled without their permission.  The best you can do is to provide a good influence through your behaviour and discussions and hope for the best.",1),
    			new Quote("If your highs are very high then your lows are probably very low. Moderation in an emotional sense can bring stability to your life and your relationships.",1),
    			new Quote("Comparing yourself to others is a one way street to disappoinment.  Compare yourself to where you were beforehand - that is the only sane way to judge your performance",1),
    			new Quote("The first test of whether you’ve been brainwashed and have introjected convictions and beliefs occurs the moment they’re attacked. You feel stunned, you react emotionally. That’s a pretty good sign — not infallible, but a pretty good sign that we’re dealing with brainwashing. You’re ready to die for an idea that never was yours.\n\n -- Anthony De Mello, Awareness",1),
    			new Quote("Make a decision when you are calm, composed and know what your long term goals are. It may not always be the right decision but it will be the best you can do at the time. \n\nRemember to review your decisions regularly too. A former bad decision can be made worse if it's not recognised and changed.",1),
    			new Quote("Recognising you are going to die isn't being pessimistic, it is being realistic.\n\nMost people try to avoid this - but eventually they have to face it all at once with the death of a loved one or their own mortality.",1),
    			new Quote("The real test of a holy book is to read it out in it's entirety to it's believers without their knowlege of who wrote the book, but change the words to say the exact opposite.  If the believers think this 'new' book is good, then it probably is.",1),
    			new Quote("If you are courageous enough to risk everything for being alert and aware, enlightenment is going to happen. \n\n -- Buddha, Buddha his life and teachings by Osho ",1),
    			new Quote("Belief as such is the barrier; it does not matter what belief is, true or false. \n\n -- Buddha, Buddha his life and teachings by Osho",1),
    			new Quote("The difference between belief and opinion is that opinion is more open to new information. Belief makes the mind more closed to ideas that lie beyond the belief.\n\nOpinion should change on evidence that is presented whereas belief does not, as belief is based on faith.\n\nA strong opinion that cannot be swayed with logic is not opinion at all but a form of belief.",1),
    			new Quote("Surely it is better to release anger and frustration in healthy, appropriate doses when the situation is still current than to bottle them up and release them all at once at an inappropriate time and place.",1),
    			new Quote("'What, concretely, is Enlightenment?'\n\n'Seeing Reality as it is,' said the Master. \n\n'Doesn't everyone see Reality as it is?' \n\n'Oh, no! Most people see it as they think it is.' \n\n'What's the difference?' \n\n'The difference between thinking you are drowning in a stormy sea and knowing you cannot drown because there isn't any water in sight for miles around.' \n\n -- Anthony De Mello, One Minute Nonsense",1),
    			new Quote("You know you are a Mystic when you wake up one day and ask, am I crazy or are they?\n\n -- Anthony De Mello, One Minute Nonsense",1),
    			// new Quote("",1),
    			new Quote("Assertion, rather than submission, manipulation, or aggression, leads to more satisfying and successful interpersonal relationships and so enriches your life.\n\nEveryone is entitled to act assertively, and to express his or her honest thoughts, feelings and beliefs.\n\n -- The Truth about Success and Motivation by Dr Bob Montgomery",1),
    			new Quote("The Master claimed that the world most people see is not the world of Reality, but a world their head creates.\n\nWhen a scholar came to dispute this, the Master set two sticks on the floor in the form of the letter T and asked, \"What do you see here?\"\n\n\"The letter T\", said the scholar.\n\n\"Just as I thought,\", said the Master. There's no such things as a letter T; that's a symbol in your head.What you have here is two broken branches in the form of sticks.\"",1),
    			new Quote("So there it is: People don’t really want to grow up, people don’t really want to change, people don’t really want to be happy. “Give up, give up, give up,” I say to myself. Say your thing and get out of here. And if they profit, that’s fine, and if they don’t, too bad! \n\n -- Anthony De Mello, Awareness",1),
    			new Quote("Waking up is unpleasant, you know. You are nice and comfortable in bed. It’s irritating to be woken up. That’s the reason the wise guru will not attempt to wake people up. I hope I’m going to be wise here and make no attempt whatsoever to wake you up if you are asleep. It is really none of my business, even though I say to you at times, “Wake up!” My business is to do my thing, to dance my dance. If you profit from it, fine; if you don’t, too bad!\n\n -- Anthony De Mello, Awareness ",1),
    			new Quote("It’s probably too startling for many of you to understand that everyone except the very rare awakened person can be expected to be selfish and to seek his or her own self-interest whether in coarse or in refined ways. This leads you to see that there’s nothing to be disappointed about, nothing to be disillusioned about. If you had been in touch with reality all along, you would never have been disappointed. But you chose to paint people in glowing colors; you chose not to see through human beings because you chose not to see through yourself. So you’re paying the price now.\n\n -- Anthony De Mello, Awareness",1),
    			new Quote("One of the hardest things to do is to let go of your desires.  \n\nIt is so easy to fight, to complain, to argue, to hoard.  \n\nBut to let go is like holding onto a precious object tightly for a lifetime. You get nervous and scared that you are going to drop it.\n\nMost people wouldn't realise that if you did drop it then you wouldn't be nervous and scared anymore. And for the people that do realise that letting go is the right thing to do, they have to content with the fact that their arms are so used to holding that precious object so tightly that is very difficult to let go.",1),
    			new Quote("'Tell me,' said the atheist, 'Is there a God — really?' Said the master, 'If you want me to be perfectly honest with you, I will not answer.' \n\nLater the disciples demanded to know why he had not answered. 'Because the question is unanswerable,' said the Master. 'So you are an atheist?' 'Certainly not. \n\nThe atheist makes the mistake of denying that of which nothing may be said... and the theist makes the mistake of affirming it.\n\n -- Anthony De Mello, One Minute Nonsense",1)  
    		};
    	
    	
    	
    	final Object data = getLastNonConfigurationInstance();
        
        if (data == null) {
        	// do the first quote
        	this.showNextQuote();
            
        } else {
        	final savedState state = (savedState) data;
        	
        	this.fontSize.setCurrent(state.fontSize);
        	
        	this.currentQuote = state.quote; 
        	if (state.inAboutUsMenu){
        		this.showAboutUs();
        	} else {
        		this.showCurrentQuote();
        	}
        	
        	
        }
    	
        
    }

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, R.string.menu_insert_about);
        menu.add(0, 2, 0, R.string.menu_insert_change_font_size);
        menu.add(0, 3, 0, R.string.menu_send_sms);
        menu.add(0, 4, 0, R.string.menu_copy_to_clipboard);
        
        
        return result;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
    	switch (item.getItemId()) {
    	
    		case 1:
    			reflections.this.showAboutUs();
    			return true;
    		case 2:
    			showDialog(DIALOG_CHOOSE_FONT);
    			return true;
    		case 3:
    			
		        // the destination number
		        String number = "";
		        startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)).putExtra("sms_body", quotes[reflections.this.currentQuote].quote));

    			return true;
    		case 4:
    			ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE); 

    			clipboard.setText(quotes[reflections.this.currentQuote].quote);
    			
    			Toast.makeText(reflections.this, "Quote has been copied to the clipboard", Toast.LENGTH_SHORT).show();
    			
    			return true;
    	
    	}
    	
    	
        return true;
    }
    

    
    
    
    
}