package tests.unitaires;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import fr.uv1.bettingServices.*;

import fr.uv1.bettingServices.exceptions.AuthenticationException;
import fr.uv1.bettingServices.exceptions.BadParametersException;
import fr.uv1.bettingServices.exceptions.CompetitionException;
import fr.uv1.bettingServices.exceptions.ExistingCompetitionException;
import fr.uv1.bettingServices.exceptions.ExistingSubscriberException;
import fr.uv1.bettingServices.exceptions.SubscriberException;
import fr.uv1.utils.MyCalendar;

class unsubscribeTest {

	@Test
	void test() throws AuthenticationException, ExistingSubscriberException, SubscriberException, BadParametersException, ExistingCompetitionException, CompetitionException {
		
		BettingSite test = new BettingSite();
		
		// Tous les paramètres sont bien rentrés
		System.out.println("-------------- Test 1 de unsubscribe un joueur ---------------------");
		System.out.println("On crée un joueur : ");
		String pwdSubs = test.subscribe(new String("Arthus"), new String("ANIN"), new String("Eric1er"), new String("14/05/1977"), test.getManagerPassword());
		System.out.println(test.infosSubscriber("Eric1er", test.getManagerPassword()) + "\n");
		
		// On crée deux compétiteurs
		System.out.println("On crée deux compétiteurs.");
		Competitor competitor1 = test.createCompetitor(new String("Observateur"), new String("KOUAKOU"), new String("01/01/1970"), test.getManagerPassword());
		Competitor competitor2 = test.createCompetitor(new String("La Beaute"), new String("ARAFAT"), new String("01/01/1980"), test.getManagerPassword());
		
		// On crée une compétition
		System.out.println("On crée une compétition avec les deux compétiteurs.");
		Collection<Competitor> competitors = new HashSet<Competitor>();
		competitors.add(competitor1);
		competitors.add(competitor2);
		Calendar closingDate = new MyCalendar(2018, 5, 18);
		test.addCompetition(new String("Ligue 1"), closingDate, competitors, test.getManagerPassword());
		System.out.println(test.listCompetitions());
		
		// On crédite le compte du joueur
		System.out.println("On crédite le compte du joueur avec 200 tokens.");
		test.creditSubscriber("Eric1er", 200L, test.getManagerPassword());
		
		// On crée un pari sur la compétition crée pour le joueur
		System.out.println("On effectue un pari gagnant de 50 tokens sur le compétiteur 1 de la compétition.");
		test.betOnWinner(50L, "Ligue 1", competitor1, "Eric1er", pwdSubs);
		
		
		System.out.println(">>>>>>>>>>>>  Test réussi --------------------------------------------\n");
	}

}
