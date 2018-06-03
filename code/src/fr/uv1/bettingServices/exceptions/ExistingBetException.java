package fr.uv1.bettingServices.exceptions;

public class ExistingBetException extends Exception {
	
	public ExistingBetException() {
        super();
   }
   
   public ExistingBetException(String motif) {
        super(motif);
   }
}
