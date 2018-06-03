package tests.unitaires;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import fr.uv1.bettingServices.*;
import fr.uv1.bettingServices.exceptions.*;

import fr.uv1.utils.MyCalendar;

public class BetPodiumTest {

	


	/**  @author Caifeng BAO & Arthus Anin <br>
	 * 
	 * Cette classe permet de faire des tests sur la classe BetPodium. Le test se fait sur les méthodes settlePodium() 
	 *         
	 * Les éléments testés sont : 
	 * 
	 * @methode settlePodiumTest()  : description du scénario nominal pour solder un pari 
	 * 	
	 * @methode	testTockenValue() : cas alternatif du scénario nominal ( test sur la valeur de la mise ), return BadParametersException
	 * 
	 * @methode	testNullParameter() :cas alternatif du scénario nominal( test si au moins un paramètre est null),return BadParametersException
	 * 
	 */

	@Test
	public void settlePodiumTest() throws AuthenticationException, ExistingSubscriberException, BadParametersException, CompetitionException{
		
			
	//Description du cas nominal de la methode settlePodium()
			Subscriber subs = new Subscriber("Alban", "GOUGOUA", "NABLA", "MonbonPetit");
			subs.creditSubscriber(100); 
			
			Competitor competitor1 = new Individual("lastName", "firstName", "bornDate");
			Competitor competitor2 = new Individual("lastName", "firstName", "bornDate");
			Competitor competitor3 = new Individual("lastName", "firstName", "bornDate");
			Competitor competitor4 = new Individual("lastName", "firstName", "bornDate");
			Competitor competitor5 = new Individual("lastName", "firstName", "bornDate");
			ArrayList<Competitor> competitors = new ArrayList<Competitor>() ;
			competitors.add(competitor1);
			competitors.add(competitor2);
			competitors.add(competitor3);
			competitors.add(competitor4);
			competitors.add(competitor5);
			
			Competition comp = new Competition("Maraton",new MyCalendar(2018, 5, 20),competitors);
			
			System.out.println("INFOS DU SUBSCRIBER AVANT SON PARI ");
			System.out.println(subs.toString());
			
			BetPodium betPodium = new BetPodium(15,subs,comp,competitor1,competitor2,competitor3);
			
			System.out.println("INFOS SUR PARI DU SUBSCRIBER ");
			System.out.println(betPodium.toString());
			
			betPodium.settlePodium(competitor1,competitor2,competitor3); //Test de la méthode settlePodium() où le joueur gagne son pari	
			
			System.out.println("INFOS DU SUBSCRIBER APRES SON PARI ");
			System.out.println(subs.toString());
			
			betPodium.settlePodium(competitor3,competitor2,competitor1); //Test de la méthode settlePodium() où le joueur pert son pari
			
			System.out.println("INFOS DU SUBSCRIBER APRES SON PARI ");
			System.out.println(subs.toString());
				
				
	}
	
	//Description des scénarios alternatifs de la methode settlePodium() 
	
	@Test (expected=BadParametersException.class)
	public void testTockenValue() throws AuthenticationException, ExistingSubscriberException, BadParametersException, CompetitionException{
		
		Subscriber subs = new Subscriber("Alban", "GOUGOUA", "NABLA", "MonbonPetit");
		subs.creditSubscriber(100); 
		
		Competitor competitor1 = new Individual("lastName", "firstName", "bornDate");
		Competitor competitor2 = new Individual("lastName", "firstName", "bornDate");
		Competitor competitor3 = new Individual("lastName", "firstName", "bornDate");
		Competitor competitor4 = new Individual("lastName", "firstName", "bornDate");
		Competitor competitor5 = new Individual("lastName", "firstName", "bornDate");
		ArrayList<Competitor> competitors = new ArrayList<Competitor>() ;
		competitors.add(competitor1);
		competitors.add(competitor2);
		competitors.add(competitor3);
		competitors.add(competitor4);
		competitors.add(competitor5);
		
		Competition comp = new Competition("Maraton",new MyCalendar(2018, 5, 20),competitors);
		
		System.out.println("INFOS DU SUBSCRIBER AVANT SON PARI ");
		System.out.println(subs.toString());
		
		BetPodium betPodium = new BetPodium(-100,subs,comp,competitor1,competitor2,competitor3); //Test de settleWinner() si paramètre (la mise du subscriber) n'est pas approprié
		
		System.out.println("INFOS SUR PARI DU SUBSCRIBER ");
		System.out.println(betPodium.toString());
		
			
	}
	
	@Test (expected=BadParametersException.class)
	public void testNullParameter() throws AuthenticationException, ExistingSubscriberException, BadParametersException, CompetitionException{
		
		Subscriber subs = new Subscriber("Alban", "GOUGOUA", "NABLA", "MonbonPetit");
		subs.creditSubscriber(100); 
		
		Competitor competitor1 = new Individual("lastName", "firstName", "bornDate");
		Competitor competitor2 = new Individual("lastName", "firstName", "bornDate");
		Competitor competitor3 = new Individual("lastName", "firstName", "bornDate");
		Competitor competitor4 = new Individual("lastName", "firstName", "bornDate");
		Competitor competitor5 = new Individual("lastName", "firstName", "bornDate");
		ArrayList<Competitor> competitors = new ArrayList<Competitor>() ;
		competitors.add(competitor1);
		competitors.add(competitor2);
		competitors.add(competitor3);
		competitors.add(competitor4);
		competitors.add(competitor5);
		
		Competition comp = new Competition("Maraton",new MyCalendar(2018, 5, 20),competitors);
		
		System.out.println("INFOS DU SUBSCRIBER AVANT SON PARI ");
		System.out.println(subs.toString());
		
		BetPodium betPodium = new BetPodium(15,subs,comp,competitor1,competitor2,competitor3);
		
		System.out.println("INFOS SUR PARI DU SUBSCRIBER ");
		System.out.println(betPodium.toString());
		
		betPodium.settlePodium(competitor1,competitor2,competitor3); //Test de la méthode settlePodium() où le joueur gagne son pari	
		
		System.out.println("INFOS DU SUBSCRIBER APRES SON PARI ");
		System.out.println(subs.toString());
		
		betPodium.settlePodium(null,competitor2,null); //Test de la méthode settlePodium() avec paramètre null
		
		System.out.println("INFOS DU SUBSCRIBER APRES SON PARI ");
		System.out.println(subs.toString());
	}
		
		
	}



