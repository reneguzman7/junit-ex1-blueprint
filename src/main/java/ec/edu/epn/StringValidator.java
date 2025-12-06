package ec.edu.epn;

public class StringValidator {

    /**
     * Checks if a string is null or empty.
     * @param input The string to check.
     * @throws IllegalArgumentException if the input is null or empty.
     */
    public void validateNotEmpty(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty.");
        }
        
    }

    public boolean isPalindrome(String text) {
        if (text == null) {
            return false;
        }

        String cleaned = text.replaceAll(" ", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();

        return cleaned.equals(reversed);
    }
}