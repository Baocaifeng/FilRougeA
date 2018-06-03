package fr.uv1.bettingServices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fr.uv1.bettingServices.exceptions.*;

/**
 * 
 * <br>
 *         This class abstract describes all the attributes and methods  <br>
 *         
 * @author Caifeng BAO & Arthus Anin<br>
 * 
 * @param numberTokens
 * 			The stake of a subscriber.
 * 
 * @param subscriber
 * 			the subscriber of a bet.
 * 
 * @param competitions
 * 			list of competitions about a bet.
 * 
 * 			
 */

public abstract class Bet {
	
    protected Competition competition;
    protected ArrayList<Competitor> competitors ;
    protected Subscriber subscriber ;
    protected long numberTokens;
    
    
	/*
	 *  Constructor 
	 */
	
	public Bet( long numberTokens, Subscriber subscriber,Competition competition) throws BadParametersException, CompetitionException{
		if (numberTokens <= 0)
			throw new BadParametersException("numberTokens is inferior than O");
		else {
			if (numberTokens>subscriber.getNumberTokens()) throw new BadParametersException("numberTokens is inferior than O");
			else this.numberTokens=numberTokens ;
		}
           
		if (competition.competitionEnded()) {
			throw new CompetitionException("bet impossible cause competition is closed");
		}
		
		else 
		    this.competition=competition;
		
		this.subscriber = subscriber;
		
	}
	
	
	// Getter methods
	/**
	 * give the numberTokens of a Bet.
	 * 
	 * @return firstName
	 * 			The numberTokensfor a bet.
	 * 
	 */
    public long getNumberTokens() {
		return this.numberTokens;
	}
    
    /**
	 * give the subscriber of a Bet.
	 * 
	 * @return subscriber
	 * 			The subscriber who made a bet.
	 * 
	 */
    public Subscriber getSubscriber() {
		return this.subscriber;
	}
    
    /**
   	 * give the list competitors of a Bet.
   	 * 
   	 * @return list competitors
   	 * 
   	 */
    
    public ArrayList<Competitor> getCompetitors(){
    	return competitors ;
    }
    
    public Competition getCompetition(){
    	return competition ;
    }
    
    
    // is Subscriber existe
    public boolean isSubscriber(Subscriber subscriber) {
    	boolean bool =false ;
        if (this.subscriber.equals(subscriber)) bool=true;
        if (this.subscriber== null) bool=false;
        return bool ;
  
    }
     
    
    //Setter methods

    public void setNumberTokens(long numberTokens) {
        this.numberTokens= numberTokens;
    }

    
}
