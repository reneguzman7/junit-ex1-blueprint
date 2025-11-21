package ec.edu.epn;

public class EmailValidator {
    
    public boolean isValid(String email) {
            return email != null && email.contains("@") && email.contains(".");
    }
}

