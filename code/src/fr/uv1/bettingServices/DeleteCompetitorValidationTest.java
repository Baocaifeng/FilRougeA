package fr.uv1.bettingServices;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import fr.uv1.bettingServices.BettingSite;
import fr.uv1.bettingServices.Competition;
import fr.uv1.bettingServices.Competitor;
import fr.uv1.bettingServices.Manager;
import fr.uv1.bettingServices.Subscriber;
import fr.uv1.utils.MyCalendar;

/**
 * 
 *  @author Mohamed Habib DHIF & Mohamed Amine BEN AMIRA
 * 
 */
public class DeleteCompetitorValidationTest {

	
	private BettingSite bettingSite;
	private Competitor paris, brest, renne,nante;
	private Competitor winner, second, third;
	private Scanner sc;
	private Competition ligue;
	private ArrayList<Competitor> competitors;

	public DeleteCompetitorValidationTest() {

		this.setUp();

		this.testDeletCompetitorNullParameters();
		System.out.println("  >>>>> Fin tests param�tre non instanci�\n");

		this.testDeletCompetitorInvalidParameters();
		System.out.println("  >>>>> Fin tests param�tre invalide\n");
		
		this.testDeleteCompetitorFromCompetitionInThePast();
		System.out.println("  >>>>> Fin tests Competition finie\n");
		MyCalendar.setDate(2011, 8, 1);

		
		this.testCompetitionNotEnoughCompetitors();
		System.out.println("  >>>>> Fin tests pas assez de comp�titeurs\n");
		this.setUpOK();
		this.testDeleteCompetitorOK();
		System.out.println("  >>>>> Fin tests param�tres valides\n");
	}

	private void setUp() {
		try {
			MyCalendar.setDate(2011, 8, 1);

			bettingSite = new BettingSite();
			 competitors = new ArrayList<Competitor>();
			 this.brest = bettingSite.createCompetitor("Brest", "password");
			 competitors.add(this.brest);
			 this.paris = bettingSite.createCompetitor("Paris","password");
			 competitors.add(this.paris);
			 this.renne= bettingSite.createCompetitor("Renne", "password");
			 competitors.add(this.renne);
			 this.nante= bettingSite.createCompetitor("Nante", "password");
			 competitors.add(this.nante);
			 bettingSite.addCompetition("Ligue 1", new MyCalendar(2020, 5, 20), competitors, "password");
			 

		} catch (Exception e) {
			System.out.println(e.getClass());
		}
	}
	private void setUpOK() {
		try {
			MyCalendar.setDate(2011, 8, 1);

			 competitors.add(this.brest);
			 competitors.add(this.renne);

			 bettingSite.addCompetition("Ligue 1(2020)", new MyCalendar(2030, 5, 20), competitors, "password");
			 

		} catch (Exception e) {
			System.out.println(e.getClass());
		}
	}
	private void setUpError() {
		try {
			MyCalendar.setDate(1999, 1, 1);

			 
			 bettingSite.addCompetition("Ligue 1(1999)", new MyCalendar(1999, 5, 20), competitors, "password");
			 

		} catch (Exception e) {
			System.out.println(e.getClass());
		}
	}
	private void setUpBet() {
		try {
			 competitors.add(this.brest);

			 bettingSite.addCompetition("Ligue FR", new MyCalendar(2020, 5, 20), competitors, "password");

			
			

			 
			String fanfan = bettingSite.subscribe(new String("Duran"),
					new String("Albert"), new String("fanfan"),
					new String("11/03/1955"), "password");
			
			// Credit account subscriber 'fanfan'
						bettingSite.creditSubscriber(new String("fanfan"), 1500,
								"password");
						
			// salto and fanfan bet on competition 'a_compet'
			
			bettingSite.betOnPodium(200, "Ligue FR",
					paris, renne, brest, new String("fanfan"), fanfan);
		} catch (Exception e) {
			System.out.println(e.getClass());
		}
	}

	private void testDeletCompetitorNullParameters() {
		try {
			bettingSite.deleteCompetitor(null, brest,"password" );
			System.out
					.println("retirer un competiteur avec nom non instanci� d'une comp�tition et mdp gestionnaire correct n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		try {
			bettingSite.deleteCompetitor("Ligue 1", null,"password" );
			System.out
					.println("retirer un competiteur avec un nom inconnu d'une competition connue et mdp gestionnaire correct n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		try {
			bettingSite.deleteCompetitor("Ligue 1", brest,null );
			System.out
					.println("retirer un competiteur avec nom connu d'une comp�tition et mdp gestionnaire incorrect n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
	}

	private void testDeletCompetitorInvalidParameters() {
		// Tests parameters: invalid format
		try {
			bettingSite.deleteCompetitor(" ", brest, "password");
			System.out
					.println("retirer un competiteur avec un nom  (\" \"), d'une competition invalide et un mdp correct n'a pas lev� d'exception ");
		} catch (Exception e) {
		}

		try {
			bettingSite.deleteCompetitor("Ligue 1", bettingSite.createCompetitor(" ","password"),"password");
			System.out
					.println(" retirer un competiteur avec un nom inconnu, une competition et un mdp gestionnaire valide (\" \") n'a pas lev� d'exception ");
		} catch (Exception e) {
		}

		try {
			bettingSite.deleteCompetitor("Ligue 1", brest, " ");
			System.out
					.println(" retirer un competiteur avec un nom connu, une competition connue et un mdp gestionnaire invalide (\"jki\") n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		try {
			bettingSite.deleteCompetitor("Ligue 1", brest, "aaaaa");
			System.out
					.println(" retirer un competiteur avec un nom connu, une competition connue et un mdp gestionnaire invalide (\"jki\") n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		try {
			bettingSite.deleteCompetitor(" ", brest, " ");
			System.out
					.println(" retirer un competiteur avec un nom connu, une competition inconnue et un mdp gestionnaire invalide (\"jki\") n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		try {
			bettingSite.deleteCompetitor("Ligue 1", bettingSite.createCompetitor(" ", "password"), " ");
			System.out
					.println(" retirer un competiteur avec un nom inconnu, une competition connue et un mdp gestionnaire invalide (\"jki\") n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		try {
			bettingSite.deleteCompetitor(" ", bettingSite.createCompetitor(" ", "password"), " ");
			System.out
					.println(" retirer un competiteur avec un nom inconnu, une competition inconnue et un mdp gestionnaire invalide (\"jki\") n'a pas lev� d'exception ");
		} catch (Exception e) {
		}
		
	}

	private void testDeleteCompetitorFromCompetitionInThePast() {
		try {
			bettingSite.deleteCompetitor("Ligue 1(1999)", brest, "password");
			System.out
			.println(" retirer un competiteur d'une competition deja finie  n'a pas lev� d'excpetion");

		} catch (Exception e) {
		}
	}
	
	private void testCompetitionNotEnoughCompetitors() {
		try {
			bettingSite.deleteCompetitor("Ligue 1", brest, "password");
			bettingSite.deleteCompetitor("Ligue 1", renne, "password");
			bettingSite.deleteCompetitor("Ligue 1", nante, "password");

			System.out
			.println(" retirer un competiteur d'une competition qui n'a pas assez de joueurs n'a pas lev� d'excpetion");

		} catch (Exception e) {
		}
	}

	private void testDeleteCompetitorOK() {
		// Unsubscribe an existing subscriber that has no unsettled bets
		try {
			bettingSite.deleteCompetitor("Ligue 1(2020)", brest, "password");
			System.out.println("  >>>>> Fin tests param�tres valides pour un competiteur sans bets\n");

		} catch (Exception e) {
			System.out
					.println("retirer le competiteur brest de la competition ligue 1 a lev� une exception "
							+ e.getClass());
		}

		System.out
				.print("  ----- Supprimer un competiteur ayant des paris en cours ? (y/n)\n");
		sc = new Scanner(System.in);
		String c = getResponse();
		if (c.equals("y")) {
			// Setup a competition and at least a bet for a subscriber.
			// Suppose used functions already tested
			setUpBet();

			try {
				bettingSite.deleteCompetitor("Ligue FR", brest, "password");
				ArrayList<String> tokens = bettingSite.infosSubscriber("fanfan", "password");
				// Verify the specification. Just with number of tokens
				String token = tokens.get(3);
				if ( Integer.parseInt(token) !=1300  )
					System.out
							.println("Le nombre de jetons � donner au joueur fanfan est incorrect (1500 != "
									+ tokens.get(3));
			} catch (Exception e) {
				System.out
						.println("retirer un competiteur a lev� l'exception "
								+ e.getClass());
			}
		}
	}

	private String getResponse() {
		String s = "x";
		while (!s.equals("y") && !s.equals("n")) {
			s = sc.next();
		}
		return s;
	}

	public static void main(String[] args) {
		DeleteCompetitorValidationTest testDelete = new DeleteCompetitorValidationTest();
	}

}
