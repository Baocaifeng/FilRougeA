package fr.uv1.bettingServices.exceptions;

public class BadParametersException extends Exception {
	
	
	public BadParametersException() {
        super();
    }
     
    public BadParametersException(String motif) {
        super(motif);
    }
}
