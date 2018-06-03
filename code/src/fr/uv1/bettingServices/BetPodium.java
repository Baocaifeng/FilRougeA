package fr.uv1.bettingServices;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import fr.uv1.bettingServices.exceptions.*;
import fr.uv1.utils.MyCalendar;

/**
 * 
 * <br>
 *         This class describes all the attributes and methods of a betPodium  <br>
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
 * @param competitors
 * 		list of competitors chosen by a subscriber.
 * 
 * 			
 */

public class BetPodium extends Bet {
	
	private boolean podiumSettled=false;
	private Competitor first;
	private Competitor second;
	private Competitor third;
	ArrayList<Competition> podiumBet ;


    //Constructor
	public BetPodium(long numberTokens,Subscriber subscriber,Competition competition, Competitor first, Competitor second, Competitor third) throws BadParametersException, CompetitionException {
		super(numberTokens,subscriber,competition);
		this.first = first;
		this.second = second;
		this.third = third;
		competition.addBet(this); // ajout du bet à la compétion 
		
	} 
	
	//podium getter
	@Override
  	public ArrayList<Competitor> getCompetitors(){
  		ArrayList<Competitor> podiumBet = new ArrayList<Competitor>();
  		if(this.podiumSettled){
  			podiumBet.add(this.first);
  			podiumBet.add(this.second);
  			podiumBet.add(this.third);
  		}
  		
  		return podiumBet;
  	}
	
	//settleWinner
  	public void settlePodium(Competitor first,Competitor second,Competitor third) throws BadParametersException{
  			//credits the users who won the on winner bet in this competition
  			//stocking and updating podium
  		if (first!=null && second!=null && third !=null) {
	  		if (this.first.equals(first) && this.first.equals(second) && this.first.equals(third)) {
	  			subscriber.creditSubscriber(this.numberTokens) ; //credits the users who won the on winner bet in this competition 
	  			// stocking the podium
	  			this.first = first ;
	  	  		this.second = second;
	  	  		this.third = third;
	  	  		this.podiumSettled = true;
	  		}
  		}
  		else throw new BadParametersException("L'un des competiteurs est invalide");
  			
  	}
  	
  	
 // To String
    public String toString() {
		return "Son pari s'élève à "+this.numberTokens+ " sur la compétion "+competition.getName()+". Ses vainqueurs sont dans l'ordre : "+this.first+","+ this.second+","+this.third;
	}
  	
  		
}
