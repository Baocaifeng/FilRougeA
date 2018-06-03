package fr.uv1.bettingServices;

import java.util.ArrayList;

import fr.uv1.bettingServices.exceptions.*;
import fr.uv1.utils.MyCalendar;

/**
 * 
 * <br>
 *         This class describes all the attributes and methods of a betWinner  <br>
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
 * @param competitor
 * 		competitors chosen by a subscriber.
 * 
 * 			
 */

public class BetWinner extends Bet {

    private boolean winnerSettled=false ; 
    private Competitor first ;

    /**
     * @Constructor BetWinner
     * 			
     */
	public BetWinner(long numberTokens, Subscriber subscriber,Competition competition, Competitor winner) throws BadParametersException, CompetitionException {
		super(numberTokens,subscriber,competition);
		this.first=winner ;
		competition.addBet(this);
		
	} 
    
  	//winner getter
	@Override
  	public ArrayList<Competitor> getCompetitors(){
  		ArrayList<Competitor> winnerBet = new ArrayList<Competitor>();
  		if(this.winnerSettled){
  			winnerBet.add(this.first);
  			return winnerBet;
  		}
  		return null ;
  	}
  		
	//settleWinner
  	public void settleWinner(Competitor winner) throws BadParametersException{
  		if (winner!=null) {
  			if (this.first.equals(winner)){
  	  			subscriber.creditSubscriber(this.numberTokens) ; //credits the users who won the on winner bet in this competition 
  	  			this.first=winner; // stocking the winner
  			}
  		}
  		else throw new BadParametersException("Competitor invalide");
  		
  	}
  	
  	 // To String
    public String toString() {
		return  "Son pari s'élève à "+this.numberTokens+ " sur la compétion "+competition.getName()+". Son vainqueur est : "+this.first;
		
    }	
    
    
}
