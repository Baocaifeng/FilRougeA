package fr.uv1.bettingServices;

import fr.uv1.bettingServices.exceptions.BadParametersException;
import fr.uv1.bettingServices.exceptions.ExistingCompetitorException;

import java.util.Collection;
import java.util.HashSet;
import java.util.regex.Pattern;
/**
 *
 * @author Mohamed Habib DHIF & Mohamed Amine BEN AMIRA
 * <br>
 *         This is the Team class it implements the Competitor interface
 *
 */

public class Team implements Competitor {

    private String name;

    private Collection<Competitor> members;
    private Collection<Competition> competitions;


    public Team(String name) {
        this.name = name;
        this.competitions = new HashSet<Competition>();
        this.members = new HashSet<Competitor>();
    }

    public boolean hasValidName() {
        return ((Pattern.matches("[a-zA-Z]{1}[ a-zA-Z_]*?", this.name)));
    }

    public Collection<Competitor> getMembers() {
        return members;
    }

    public void addMember(Competitor member) throws ExistingCompetitorException, BadParametersException {
        if ((member==null)) throw new BadParametersException("Member not initialized");
        if ((this.members.contains(member))) throw new ExistingCompetitorException("Member Does not exist");
        this.members.add(member);
    }

    public void deleteMember(Competitor member) throws BadParametersException, ExistingCompetitorException {
        if (member==null) throw new BadParametersException("Member not initialized");
        if (!(this.members.contains(member))) throw new ExistingCompetitorException("Member Does not exist");
        members.remove(member);

    }
    public void addCompetition(Competition competition) throws BadParametersException {
        if (competition==null) throw new BadParametersException("Competition not initialized");
        this.competitions.add(competition);
        for (Competitor competitor : this.members) competitor.addCompetition(competition);
    }

    public void removeCompetition(Competition competition) throws BadParametersException{
        if (competition==null) throw new BadParametersException("Competition not initialized");
        this.competitions.remove(competition);
        for (Competitor competitor : this.members) competitor.removeCompetition(competition);
    }

    public Collection<Competition> getCompetitions() {
        return competitions;
    }


    public boolean equals(String name) {
        return (this.name.equals(name));
    }

    public boolean equals(String lastName, String firstName) {
        return false;
    }

    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", members=" + members +
                '}'+'\n'+"--------------------\n";
    }
    
}
