package fr.uv1.bettingServices;

import java.util.regex.Pattern;

import fr.uv1.bettingServices.exceptions.*;

/**
 * 
 * @author Alban GOUGOUA <br>
 * <br>
 * 			This class describes all the attributes and methods that the manager 
 * 			could use on the betting software.<br>
 * 
 * @param mdp
 * 			The password of manager.
 *
 */
public class Manager {

    private String mdp;
    
    /**
     * Manager(String mdp) is the constructor of the class Manager.
     * 
     * @param mdp
     * 			The password of manager.
     * 
     * @throws BadParametersException
     * 			raised if password doesn't respect the syntax of password.
     * 
     */
    public Manager(String mdp) throws BadParametersException {
        
    	boolean check = Pattern.matches("[a-zA-Z0-9]{8,}+", mdp);
    	
    	if(check == false) throw new BadParametersException("La syntaxe du mot de passe entré est incorrect.\nLe mot de passe doit avoir 8 caractères minimum "
    			+ "et doit être constitué de chiffres et de lettres uniquement.");
    	
    	else {
    		this.mdp = mdp;
    	}
    }
    
    /**
     * checks if the password input matches with the password of manager.
     * 
     * @param mdp
     * 			The password input.
     * 
     * @throws AuthenticationException
     * 			raised if the password input doesn't match with the password of manager.
     * 			raised if password input doesn't respect the syntax of password.
     * 
     */
    public void authenticateMngr(String mdp) throws AuthenticationException {
    	
    	boolean check = Pattern.matches("[a-zA-Z0-9]{8,}+", mdp);
    	
    	if(check == false) throw new AuthenticationException("La syntaxe du mot de passe entré est incorrect.\nLe mot de passe doit avoir 8 caractères minimum "
    			+ "et doit être constitué de chiffres et de lettres uniquement.");
    	
    	else {
    		if(this.mdp != mdp) throw new AuthenticationException("Le mot de passe entré est incorrect.");
    	}
    }

}
