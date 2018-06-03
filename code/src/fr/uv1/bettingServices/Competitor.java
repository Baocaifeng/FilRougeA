package fr.uv1.bettingServices;

import fr.uv1.bettingServices.exceptions.*;

import java.util.Collection;

/**
 * 
 * @author segarra <br>
 * <br>
 *         This interface declares all methods that should be provided by a
 *         competitor. <br>
 * 
 */
public interface Competitor {

	/**
	 * tells if the name of the competitor is a valid one.
	 * 
	 * @return true if the competitor has a valid name.
	 */
	boolean hasValidName();
	
	/**
	 * add a member to a team competitor.
	 * 
	 * @param member
	 *            the new member.
	 *            
	 * @throws ExistingCompetitorException
	 *             raised if the member is already registered for the team.
	 * @throws BadParametersException
	 *             raised if the member is not instantiated.
	 */
	void addMember(Competitor member) throws ExistingCompetitorException,
			BadParametersException;

	/**
	 * delete a member from a team competitor.
	 * 
	 * @param member
	 *            the member to delete.
	 *            
	 * @throws BadParametersException
	 *             raised if the member is not instantiated.
	 * @throws ExistingCompetitorException
	 *             raised if the member is not registered for the team.
	 */
	void deleteMember(Competitor member) throws BadParametersException,
			ExistingCompetitorException;


    /**
     *
     * @return Competitition list in wich the competitor is participating.
     */
    Collection<Competition> getCompetitions() ;

    /**
     *
     * @return Competititors (Individuals) list in wich the Team.
     */

    Collection<Competitor> getMembers();

    /**
     * adds a competition to the list of competitions of the competitor
     * @param competition
     *          The competition to add the list of competitions of the competitor
     * @throws BadParametersException
     * 				raised if the competition is not initialized.
     */

	void addCompetition(Competition competition)throws BadParametersException;

    /**
     * remove a competition from the list of competitions of the competitor
     * @param competition
     *          The competition to remove the list of competitions of the competitor
     * @throws BadParametersException
     * 				raised if the competition is not initialized.
     */

	void removeCompetition(Competition competition)throws BadParametersException;

    /**
     * checks if the name is the same in this competitors name
     * @param name
     *          The competitor"s (Team) name
     * @return boolean
     *          wether the name is the same or not
     *          for this competitor
     */

    boolean equals(String name);
    /**
     * checks if the last name and the first name is the same in this competitors name
     * @param lastName
     *          The competitor"s (Individual) lastname
     * @param firstName
     *          The competitor"s (Individual) lastname
     * @return boolean
     *          wether the last name and the first name are the same or not
     *          for this competitor
     */

    boolean equals(String lastName, String firstName);

}