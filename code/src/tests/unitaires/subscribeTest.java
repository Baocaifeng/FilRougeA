package tests.unitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.uv1.bettingServices.*;

import fr.uv1.bettingServices.exceptions.AuthenticationException;
import fr.uv1.bettingServices.exceptions.BadParametersException;
import fr.uv1.bettingServices.exceptions.ExistingSubscriberException;
import fr.uv1.bettingServices.exceptions.SubscriberException;

class subscribeTest {

	@Test
	void test1() throws AuthenticationException, ExistingSubscriberException, SubscriberException, BadParametersException {
		
		BettingSite test = new BettingSite();
		
		// Tous les paramètres sont bien rentrés
		System.out.println("-------------- Test 1 de subscribe un joueur ---------------------");
		System.out.println("On entre tous les bons paramètres.\n");
		test.subscribe(new String("Arthus"), new String("ANIN"), new String("Eric1er"), new String("14/05/1977"), test.getManagerPassword());
		System.out.println(">>>>>>>>>>>>  Test réussi --------------------------------------------\n");
	}
	
	@Test
	void test2() throws AuthenticationException, ExistingSubscriberException, SubscriberException, BadParametersException {
		
		BettingSite test = new BettingSite();
		
		// Paramètre mal instancié
		Assertions.assertThrows(BadParametersException.class, () -> {
			System.out.println("-------------- Test 2 de subscribe un joueur ---------------------");
			System.out.println("On entre un espace pour le lastname du joueur.\n");
			test.subscribe(new String(" "), new String("ANIN"), new String("Eric1er"), new String("14/05/1977"), test.getManagerPassword());
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	
	@Test
	void test3() throws AuthenticationException, ExistingSubscriberException, SubscriberException, BadParametersException {
		
		BettingSite test = new BettingSite();
		
		// Paramètre mal instancié
		Assertions.assertThrows(BadParametersException.class, () -> {
			System.out.println("-------------- Test 3 de subscribe un joueur ---------------------");
			System.out.println("On entre un seul caractère (tiret ou underscore) pour le lastname du joueur.\n");
			test.subscribe(new String("-"), new String("ANIN"), new String("Eric1er"), new String("14/05/1977"), test.getManagerPassword());
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	
	@Test
	void test4() throws AuthenticationException, ExistingSubscriberException, SubscriberException, BadParametersException {
		
		BettingSite test = new BettingSite();
		
		// Paramètre mal instancié
		Assertions.assertThrows(BadParametersException.class, () -> {
			System.out.println("-------------- Test 4 de subscribe un joueur ---------------------");
			System.out.println("On entre un username avec moins de 4 caractères.\n");
			test.subscribe(new String("Arthus"), new String("ANIN"), new String("Eri"), new String("14/05/1977"), test.getManagerPassword());
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	
	@Test
	void test5() throws AuthenticationException, ExistingSubscriberException, SubscriberException, BadParametersException {
		
		BettingSite test = new BettingSite();
		
		// Paramètre mal instancié
		Assertions.assertThrows(SubscriberException.class, () -> {
			System.out.println("-------------- Test 5 de subscribe un joueur ---------------------");
			System.out.println("On donne une année de naissance de tel sorte que le joueur soit mineur.\n");
			test.subscribe(new String("Arthus"), new String("ANIN"), new String("Eric1er"), new String("14/05/3000"), test.getManagerPassword());
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	
	@Test
	void test6() throws AuthenticationException, ExistingSubscriberException, SubscriberException, BadParametersException {
		
		BettingSite test = new BettingSite();
		
		// Paramètre mal instancié
		Assertions.assertThrows(AuthenticationException.class, () -> {
			System.out.println("-------------- Test 6 de subscribe un joueur ---------------------");
			System.out.println("On entre un mot de passe du gestionnaire incorrect.\n");
			test.subscribe(new String("Arthus"), new String("ANIN"), new String("Eric1er"), new String("14/05/1977"), new String("badPassword"));
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	
	@Test
	void test7() throws AuthenticationException, ExistingSubscriberException, SubscriberException, BadParametersException {
		
		BettingSite test = new BettingSite();
		
		// Joueur déjà existant
		Assertions.assertThrows(ExistingSubscriberException.class, () -> {
			System.out.println("-------------- Test 7 de subscribe un joueur ---------------------");
			System.out.println("On crée deux joueurs de même username.\n");
			test.subscribe(new String("Arthus"), new String("ANIN"), new String("Eric1er"), new String("14/05/1977"), test.getManagerPassword());
			test.subscribe(new String("Alban"), new String("GOUGOUA"), new String("Eric1er"), new String("10/01/1980"), test.getManagerPassword());
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
}
