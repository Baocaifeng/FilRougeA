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

public class Individual implements Competitor {

    private String lastName, firstName, bornDate;
    private Collection<Competitor> members;
    private Collection<Competition> competitions;

    public Individual(String lastName, String firstName, String bornDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.bornDate = bornDate;

        this.members = new HashSet<Competitor>();
        this.competitions = new HashSet<Competition>();
    }

    public boolean hasValidName() {
        return ((Pattern.matches("[a-zA-Z]{1}[ a-zA-Z_]*?", this.firstName)&&(Pattern.matches("[a-zA-Z]{1}[ a-zA-Z_]*?", this.lastName))));
    }
    public Collection<Competitor> getMembers() {
        return members;
    }

    public void addMember(Competitor member) throws ExistingCompetitorException, BadParametersException {

    }

    public String toString() {
        return "\n***Individual{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", bornDate='" + bornDate + '\'' +
                '}'+"***";
    }

    public void deleteMember(Competitor member) throws BadParametersException, ExistingCompetitorException {

    }

    public Collection<Competition> getCompetitions() {
        return this.competitions;
    }

    public void addCompetition(Competition competition) throws BadParametersException {
        if (competition==null) throw new BadParametersException("Competition not initialized");
        this.competitions.add(competition);
    }

    public void removeCompetition(Competition competition)throws BadParametersException {
        if (competition==null) throw new BadParametersException("Competition not initialized");
        this.competitions.remove(competition);
    }

    public boolean equals(String name) {
        return false;
    }

    public boolean equals(String lastName, String firstName) {
        return ((this.lastName.equals(lastName))&&(this.firstName.equals(firstName)));
    }
    
}
