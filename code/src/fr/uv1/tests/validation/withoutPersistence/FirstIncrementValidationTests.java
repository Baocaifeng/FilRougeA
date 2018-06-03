package fr.uv1.tests.validation.withoutPersistence;

public abstract class FirstIncrementValidationTests extends ValidationTest {

	private static FirstIncrementValidationTests increment;

	public FirstIncrementValidationTests() {
		super();
		FirstIncrementValidationTests.increment = this;
		launchTests();
	}

	private void launchTests() {

		// Validation de la cr�ation de joueurs
		System.out.println("\n ** ------------------------------- **");
		System.out.println(" ** Tests pour inscrire des joueurs **");
		System.out.println(" ** ------------------------------- **\n");
		new SubscribeValidationTests();

		// Validation de la d�sinscription de joueurs
		System.out.println("\n ** ---------------------------------- **");
		System.out.println(" ** Tests pour d�sinscrire des joueurs **");
		System.out.println(" ** ---------------------------------- **\n");
		// Cr�ation nouvelle instance de BettingSoft
		this.setBetting(this.plugToBetting());
		new UnSubscribeValidationTests();

		// Validation de lister joueurs
		System.out.println("\n ** ----------------------------- **");
		System.out.println(" ** Tests pour lister les joueurs **");
		System.out.println(" ** ----------------------------- **\n");
		// Cr�ation nouvelle instance de BettingSoft
		this.setBetting(this.plugToBetting());
		new ListPlayersValidationTests();

		// Validation de "ajouter comp�tition"
		System.out.println("\n ** ---------------------------------- **");
		System.out.println(" ** Tests pour ajouter une comp�tition **");
		System.out.println(" ** ---------------------------------- **\n");
		// Cr�ation nouvelle instance de BettingSoft
		this.setBetting(this.plugToBetting());
		new AddCompetitionValidationTests();

		// Validation de "cr�diter joueur"
		System.out.println("\n ** ----------------------------- **");
		System.out.println(" ** Tests pour cr�diter un joueur **");
		System.out.println(" ** ----------------------------- **\n");
		// Cr�ation nouvelle instance de BettingSoft
		this.setBetting(this.plugToBetting());
		new CreditValidationTests();
		
		// Validation de "d�biter joueur"
		System.out.println("\n ** ---------------------------- **");
		System.out.println(" ** Tests pour d�biter un joueur **");
		System.out.println(" ** ---------------------------- **\n");
		// Cr�ation nouvelle instance de BettingSoft
		this.setBetting(this.plugToBetting());
		new DebitValidationTests();
		
		// Validation de "annuler comp�tition"
//		 System.out.println("\n * Tests pour annuler une comp�tition\n");
		// Cr�ation nouvelle instance de BettingSoft
//		 this.setBetting(this.plugToBetting());
//		 new CancelCompetitionValidationTests();

		// Validation de "ajouter comp�titeur"
//		 System.out.println("\n * Tests pour ajouter comp�titeur\n");
		// Cr�ation nouvelle instance de BettingSoft
//		 this.setBetting(this.plugToBetting());
//		 new AddCompetitorValidationTests();

		// Validation de "supprimer comp�titeur"
		 //System.out.println("\n * Tests pour supprimer comp�titeur\n");
		// Cr�ation nouvelle instance de BettingSoft
		 //this.setBetting(this.plugToBetting());
		 //new DeleteCompetitorValidationTests();

		// Validation de la liste des comp�titeurs d'une comp�tition
		// System.out.println("\n * Tests pour lister les comp�titeurs d'une comp�tition\n");
		// Cr�ation nouvelle instance de BettingSoft
		 //this.setBetting(this.plugToBetting());
		 //System.out.println("\n * Tests pour supprimer comp�titeur\n");
		 //new ListCompetitorsValidationTests();
	}

	public static FirstIncrementValidationTests getIncrement() {
		return increment;
	}
}
