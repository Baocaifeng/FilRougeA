package fr.uv1.bettingServices.exceptions;

public class AuthenticationException extends Exception {

    public AuthenticationException() {
         super();
    }
    
    public AuthenticationException(String motif) {
         super(motif);
    }
}
