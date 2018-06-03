package fr.uv1.bettingServices;

import fr.uv1.utils.MyCalendar;
import java.util.HashSet;
import fr.uv1.bettingServices.exceptions.*;

public class MainCompetitionTestFonctionnalite {
	
	public static void main(String[] args) throws BadParametersException, ExistingCompetitionException, AuthenticationException, CompetitionException, ExistingCompetitorException, SubscriberException, ExistingSubscriberException{
		BettingSite b = new BettingSite();
		HashSet<Competitor> c = new HashSet<Competitor>();
		Team best = new Team("Real de madrid boum boum");
		c.add(best);
		Team loser = new Team("Liverpool les gros nuloss");
		c.add(loser);
		b.addCompetition("Champions League", new MyCalendar(2018, 5, 23), c, "password");
		best.addMember(new Individual("Ronaldo", "Cristiano", "1984/11/20"));
		
		String s1 = b.subscribe("Ates", "Tom",  "tomates",  "1952/02/19",  "password");
		String s2 = b.subscribe("Co", "Harry",  "harryco",  "1967/11/12",  "password");
		
		b.creditSubscriber("tomates",  2000,  "password");
		b.creditSubscriber("harryco",  2000,  "password");
		
		Individual i1 = new Individual("Nadal", "Rafael", "1982/05/19");
		Individual i2 = new Individual("Federer", "Roger", "1983/09/02");
		Individual i3 = new Individual("Ferrer", "David", "1984/11/07");
		HashSet<Competitor> c2 = new HashSet<Competitor>();
		c2.add(i1);
		c2.add(i2);
		c2.add(i3);
		b.addCompetition("Roland Garros",  new MyCalendar(2018, 7, 26),  c2,  "password");

		b.betOnWinner(200,  "Champions League", best, "tomates", s1);
		b.betOnWinner(300,  "Champions League", loser, "harryco", s2);
		b.betOnPodium(200,  "Roland Garros", i1, i2, i3, "harryco", s2);
		System.out.println("DEBUT");
		System.out.println(b.listCompetitions());
		System.out.println(b.infosSubscriber("tomates",  s1));
		System.out.println(b.infosSubscriber("harryco",  s2));
		try {
			b.cancelCompetition("Roland Garros", "mauvais mot de passe");
			System.out.println("Echec de l'extension 3");
		}
		catch (AuthenticationException e) {
			System.out.println("Extension 3 validée");
		}
		try {
			b.cancelCompetition("mauvais nom de compétition", "password");
			System.out.println("Echec de l'extension 4.1");
		}
		catch (ExistingCompetitionException e) {
			System.out.println("Extension 4.1 validée");
		}
		try {
			MyCalendar.setDate(2042, 2, 5);
			b.cancelCompetition("Roland Garros", "password");
			System.out.println("Echec de l'extension 4.2");
		}
		catch (CompetitionException e) {
			System.out.println("Extension 4.2 validée");
			MyCalendar.setDate();
		}
		b.cancelCompetition("Roland Garros",  "password");
		b.cancelCompetition("Champions League",  "password");
		System.out.println("On vérifie que les deux compétitions sont annulées");
		System.out.println(b.listCompetitions());
		System.out.println("On vérifie que les deux joueurs n'ont plus de paris et leurs jetons rendus");
		System.out.println(b.infosSubscriber("tomates",  s1));
		System.out.println(b.infosSubscriber("harryco",  s2));
	}

}
