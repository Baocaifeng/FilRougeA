package tests.unitaires;

import static org.junit.Assert.*;

import java.util.ArrayList;

import fr.uv1.bettingServices.* ;
import fr.uv1.bettingServices.exceptions.*;
import fr.uv1.utils.MyCalendar;

import org.junit.Test;


/**  @author Caifeng BAO & Arthus Anin <br>
 * 
 * Cette classe permet de faire des tests sur la classe BetWinner. Seule le test de la méthode settleWinner() qui a été 
 * cependant mis en avant car elle est au coeur de cette classe. 
 *         
 * Les éléments testés sont : 
 * 
 * @methode settleWinnerTest()  : description du scénario nominal pour solder un pari 
 * 	
 * @methode	testTockenValue() : cas alternatif du scénario nominal ( test sur la valeur de la mise ), return BadParametersException
 * 
 * @methode	testNullParameter() :cas alternatif du scénario nominal( test si au moins un paramètre est null),return BadParametersException
 */

public class BetWinnerTest {

	@Test
	public void settleWinnerTest() throws AuthenticationException, ExistingSubscriberException, BadParametersException, CompetitionException{
		
			
	//Description du cas nominal de la methode settleWinner()
			Subscriber subs = new Subscriber("Alban", "GOUGOUA", "NABLA", "MonbonPetit");
			subs.creditSubscriber(100);
			
			Competitor competitor1 = new Team("Real");
			Competitor competitor2 = new Team("Barça");
			ArrayList<Competitor> competitors = new ArrayList<Competitor>() ;
			competitors.add(competitor1);
			competitors.add(competitor2);
			
			Competition comp = new Competition("LIGUA",new MyCalendar(2018, 5, 20),competitors);
			
			System.out.println("INFOS DU SUBSCRIBER AVANT SON PARI ");
			System.out.println(subs.toString());
			
			BetWinner betWinner = new BetWinner(15,subs,comp,competitor2);
			
			System.out.println("INFOS SUR PARI DU SUBSCRIBER ");
			System.out.println(betWinner.toString());
			
			betWinner.settleWinner(competitor2); //Test de la méthode settleWinner() où le joueur gagne son pari	
			
			System.out.println("INFOS DU SUBSCRIBER APRES SON PARI ");
			System.out.println(subs.toString());	
			
			betWinner.settleWinner(competitor1); //Test de la méthode settleWinner() où le joueur permet son pari
			
			System.out.println("INFOS DU SUBSCRIBER APRES SON PARI ");
			System.out.println(subs.toString());
	}
	
	//Description des scénarios alternatifs de la methode settleWinner() , classe BetWinner en gros car cette méthode est au coeur de la classe
	
	@Test (expected=BadParametersException.class )
	public void testTockenValue() throws AuthenticationException, ExistingSubscriberException, BadParametersException, CompetitionException{
		
			Subscriber subs = new Subscriber("Alban", "GOUGOUA", "NABLA", "MonbonPetit");
			
			Competitor competitor1 = new Team("Real");
			Competitor competitor2 = new Team("Barça");
			ArrayList<Competitor> competitors = new ArrayList<Competitor>() ;
			competitors.add(competitor1);
			competitors.add(competitor2);
			
			Competition comp = new Competition("LIGUA",new MyCalendar(2018, 5, 20),competitors);
			
			System.out.println("INFOS DU SUBSCRIBER AVANT SON PARI ");
			System.out.println(subs.toString());
			
			BetWinner betWinner = new BetWinner(-10,subs,comp,competitor2); 
			
			betWinner.settleWinner(competitor2); //Test de settleWinner() si paramètre (la mise du subscriber) n'est pas approprié
			
			System.out.println("INFOS DU SUBSCRIBER APRES SON PARI ");
			System.out.println(subs.toString());
	}
	
	@Test (expected=BadParametersException.class )
	public void testNullParameter() throws AuthenticationException, ExistingSubscriberException, BadParametersException, CompetitionException{
		
			Subscriber subs = new Subscriber("Alban", "GOUGOUA", "NABLA", "MonbonPetit");
			
			Competitor competitor1 = new Team("Real");
			Competitor competitor2 = new Team("Barça");
			ArrayList<Competitor> competitors = new ArrayList<Competitor>() ;
			competitors.add(competitor1);
			competitors.add(competitor2);
			
			Competition comp = new Competition("LIGUA",new MyCalendar(2018, 5, 20),competitors);
			
			System.out.println("INFOS DU SUBSCRIBER AVANT SON PARI ");
			System.out.println(subs.toString());
			
			BetWinner betWinner = new BetWinner(10,subs,comp,competitor1); 
			
			betWinner.settleWinner(null); //Test de la méthode settleWinner() avec paramètre null
			
			System.out.println("INFOS DU SUBSCRIBER APRES SON PARI ");
			System.out.println(subs.toString());
	}
	
	
	


}
