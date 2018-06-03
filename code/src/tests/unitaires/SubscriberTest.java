package tests.unitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.uv1.bettingServices.Bet;
import fr.uv1.bettingServices.BetWinner;
import fr.uv1.bettingServices.Subscriber;
import fr.uv1.bettingServices.exceptions.AuthenticationException;
import fr.uv1.bettingServices.exceptions.BadParametersException;
import fr.uv1.bettingServices.exceptions.CompetitionException;
import fr.uv1.bettingServices.exceptions.ExistingBetException;

class SubscriberTest {

	@Test
	void subscriber1() throws BadParametersException {
		
		// Tous les paramètres sont bien rentrés
		System.out.println("-------------- Test 1 du constructeur de Subscriber ---------------------");
		System.out.println("On entre tous les bons paramètres pour le joueur.\n");
		Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla02", "password");
		System.out.println(">>>>>>>>>>>>  Test réussi --------------------------------------------\n");
	}
	
	@Test
	void subscriber2() throws BadParametersException {
		
		// Paramètres mal instanciés
		Assertions.assertThrows(BadParametersException.class, () -> {
			System.out.println("-------------- Test 2 du constructeur de Subscriber ---------------------");
			System.out.println("On entre un espace  au début pour le lastname ou le firstname.\n");
			Subscriber subs = new Subscriber(" Alban", "GOUGOUA", "Nabla02", "password");
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	
	@Test
	void subscriber3() throws BadParametersException {
		
		// Paramètres mal instanciés
		Assertions.assertThrows(BadParametersException.class, () -> {
			System.out.println("-------------- Test 3 du constructeur de Subscriber ---------------------");
			System.out.println("On entre un lastname ou firstname en le commençant par un tiret.\n");
			Subscriber subs = new Subscriber("-Alban", "GOUGOUA", "Nabla02", "password");
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	
	@Test
	void subscriber4() throws BadParametersException {
		
		// Paramètres mal instanciés
		Assertions.assertThrows(BadParametersException.class, () -> {
			System.out.println("-------------- Test 4 du constructeur de Subscriber ---------------------");
			System.out.println("On entre un username avec moins de 4 caractères.\n");
			Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Na2", "password");
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	
	@Test
	void subscriber5() throws BadParametersException {
		
		// Paramètres mal instanciés
		Assertions.assertThrows(BadParametersException.class, () -> {
			System.out.println("-------------- Test 5 du constructeur de Subscriber ---------------------");
			System.out.println("On introduit des caractères autre que des chiffres et des "
					+ "lettres dans le username.\n");
			Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla-02", "password");
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	
	@Test
	void subscriber6() throws BadParametersException {
		
		// Paramètres mal instanciés
		Assertions.assertThrows(BadParametersException.class, () -> {
			System.out.println("-------------- Test 6 du constructeur de Subscriber ---------------------");
			System.out.println("On entre un mot de passe avec moins de 8 caractères.\n");
			Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla-02", "pass");
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	
	@Test
	void subscriber7() throws BadParametersException {
		
		// Paramètres mal instanciés
		Assertions.assertThrows(BadParametersException.class, () -> {
			System.out.println("-------------- Test 7 du constructeur de Subscriber ---------------------");
			System.out.println("On entre un mot de passe en introduisant des caractères "
					+ "différents de chiffres et lettres.\n");
			Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla-02", "password#");
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	
	@Test
	void authenticateSubscriber1() throws AuthenticationException, BadParametersException {
		
		// On entre les bons paramètres
		System.out.println("-------------- Test 1 de l'authentification d'un joueur ---------------------");
		System.out.println("On authentifie correctement un joueur : mot de passe identique à celui "
				+ "de la création.\n");
		Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla02", "password");
		subs.authenticateSubscriber("password");
		System.out.println(">>>>>>>>>>>>  Test réussi --------------------------------------------\n");
	}
	
	@Test
	void authenticateSubscriber2() throws AuthenticationException, BadParametersException {
		
		// Paramètres mal instanciés
		Assertions.assertThrows(AuthenticationException.class, () -> {
			System.out.println("-------------- Test 2 de l'authentification d'un joueur ---------------------");
			System.out.println("On n'authentifie pas correctement un joueur : mot de passe différent de celui "
					+ "de la création.\n");
			Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla02", "password");
			subs.authenticateSubscriber("password1234");
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	
	@Test
	void changeSubsPwd1() throws AuthenticationException, BadParametersException {
		
		// On entre les bons paramètres
		System.out.println("-------------- Test 1 de changement du mot de passe d'un joueur ---------------------");
		System.out.println("On change le mot de passe d'un joueur avec de bons paramètres.\n");
		Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla02", "password");
		subs.changeSubsPwd("password1234", "password");
		System.out.println(">>>>>>>>>>>>  Test réussi --------------------------------------------\n");
	}
	
	@Test
	void changeSubsPwd2() throws AuthenticationException, BadParametersException {
		
		// Paramètres mal instanciés
		Assertions.assertThrows(BadParametersException.class, () -> {
			System.out.println("-------------- Test 2 de changement du mot de passe d'un joueur ---------------------");
			System.out.println("On se trompe sur le mot de passe courant du joueur.\n");
			Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla02", "password");
			subs.changeSubsPwd("password1234", "passw");
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	
	@Test
	void changeSubsPwd3() throws AuthenticationException, BadParametersException {
		
		// Paramètres mal instanciés
		Assertions.assertThrows(BadParametersException.class, () -> {
			System.out.println("-------------- Test 3 de changement du mot de passe d'un joueur ---------------------");
			System.out.println("On se trompe dans la syntaxe du nouveau mot de passe du joueur.\n");
			Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla02", "password");
			subs.changeSubsPwd("password_1234", "password");
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	
	@Test
	void isDebitPossible1() throws BadParametersException {
		
		// On entre les bons paramètres
		System.out.println("-------------- Test 1 de débit possible ---------------------");
		System.out.println("On entre un nombre de tokens pour un débit possible :\n"
				+ "\tLe joueur a 50 tokens et on lui débite 20 tokens.\n");
		Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla02", "password");
		subs.creditSubscriber(50L);
		System.out.println(subs.isDebitPossible(20L));
		System.out.println(">>>>>>>>>>>>  Test réussi --------------------------------------------\n");
	}
	
	@Test
	void isDebitPossible2() throws BadParametersException {
		
		// On entre les bons paramètres
		System.out.println("-------------- Test 2 de débit possible ---------------------");
		System.out.println("On entre un nombre de tokens supérieur aux tokens du joueur pour un débit impossible :\n"
				+ "\tLe joueur a 50 tokens et on lui débite 100 tokens.\n");
		Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla02", "password");
		subs.creditSubscriber(50L);
		System.out.println(subs.isDebitPossible(100L));
		System.out.println(">>>>>>>>>>>>  Test réussi --------------------------------------------\n");
	}
	
	@Test
	void isDebitPossible3() throws BadParametersException {
		
		// Paramètres mal instanciés
		Assertions.assertThrows(BadParametersException.class, () -> {
			System.out.println("-------------- Test 3 de débit possible ---------------------");
			System.out.println("On entre un nombre de tokens inférieur à 0 pour un débit impossible :\n"
					+ "\tLe joueur a 50 tokens et on lui débite -20 tokens.\n");
			Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla02", "password");
			subs.creditSubscriber(50L);
			subs.isDebitPossible(-20L);
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	
	@Test
	void isDebitPossible4() throws BadParametersException {
		
		// Paramètres mal instanciés
		Assertions.assertThrows(BadParametersException.class, () -> {
			System.out.println("-------------- Test 4 de débit possible ---------------------");
			System.out.println("On entre un nombre de tokens égale à 0 pour un débit impossible :\n"
					+ "\tLe joueur a 50 tokens et on lui débite 0 tokens.\n");
			Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla02", "password");
			subs.creditSubscriber(50L);
			subs.isDebitPossible(0L);
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	
	@Test
	void creditSubscriber1() throws BadParametersException {
		
		// On entre les bons paramètres
		System.out.println("-------------- Test 1 de créditer compte du joueur ---------------------");
		System.out.println("On crédite de 50 tokens le compte du joueur.\n");
		Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla02", "password");
		subs.creditSubscriber(50L);
		System.out.println(">>>>>>>>>>>>  Test réussi --------------------------------------------\n");
	}
	
	@Test
	void creditSubscriber2() throws BadParametersException {
		
		// Paramètres mal instanciés
		Assertions.assertThrows(BadParametersException.class, () -> {
			System.out.println("-------------- Test 2 de créditer compte du joueur ---------------------");
			System.out.println("On crédite de 0 tokens le compte du joueur.\n");
			Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla02", "password");
			subs.creditSubscriber(0L);
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	
	@Test
	void creditSubscriber3() throws BadParametersException {
		
		// Paramètres mal instanciés
		Assertions.assertThrows(BadParametersException.class, () -> {
			System.out.println("-------------- Test 3 de créditer compte du joueur ---------------------");
			System.out.println("On crédite de -50 tokens le compte du joueur.\n");
			Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla02", "password");
			subs.creditSubscriber(-50L);
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	
	@Test
	void debitSubscriber1() throws BadParametersException {
		
		// On entre les bons paramètres
		System.out.println("-------------- Test 1 de débiter compte du joueur ---------------------");
		System.out.println("On crédite de 50 tokens le compte du joueur puis on le débite de 50 tokens.\n");
		Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla02", "password");
		subs.creditSubscriber(50L);
		subs.debitSubscriber(50L);
		System.out.println(">>>>>>>>>>>>  Test réussi --------------------------------------------\n");
	}
	
	@Test
	void debitSubscriber2() throws BadParametersException {
		
		// Paramètres mal instanciés
		Assertions.assertThrows(BadParametersException.class, () -> {
			System.out.println("-------------- Test 2 de débiter compte du joueur ---------------------");
			System.out.println("On crédite de 50 tokens le compte du joueur puis on le débite de 0 tokens.\n");
			Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla02", "password");
			subs.creditSubscriber(50L);
			subs.debitSubscriber(0L);
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	
	@Test
	void debitSubscriber3() throws BadParametersException {
		
		// Paramètres mal instanciés
		Assertions.assertThrows(BadParametersException.class, () -> {
			System.out.println("-------------- Test 3 de débiter compte du joueur ---------------------");
			System.out.println("On crédite de 50 tokens le compte du joueur puis on le débite de 100 tokens.\n");
			Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla02", "password");
			subs.creditSubscriber(50L);
			subs.debitSubscriber(100L);
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	
	@Test
	void debitSubscriber4() throws BadParametersException {
		
		// Paramètres mal instanciés
		Assertions.assertThrows(BadParametersException.class, () -> {
			System.out.println("-------------- Test 4 de débiter compte du joueur ---------------------");
			System.out.println("On crédite de 50 tokens le compte du joueur puis on le débite de -20 tokens.\n");
			Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla02", "password");
			subs.creditSubscriber(50L);
			subs.debitSubscriber(-20L);
		});
		System.out.println(">>>>>>>>>>>>  Test échoué --------------------------------------------\n");
	}
	/*
	@Test
	void cancelBet1() throws BadParametersException, CompetitionException, ExistingBetException {
		
		// On entre les bons paramètres
		System.out.println("-------------- Test 1 d'annuler un pari du joueur ---------------------");
		System.out.println("On effectue un pari et on l'annule ensuite.\n");
		Subscriber subs = new Subscriber("Alban", "GOUGOUA", "Nabla02", "password");
		subs.creditSubscriber(50L);
		Bet bet = new BetWinner(20L, subs, null, null);
		subs.debitSubscriber(20L);
		subs.addBet(bet);
		subs.cancelBet(bet);
		System.out.println(">>>>>>>>>>>>  Test réussi --------------------------------------------\n");
	}
	*/
}
