package validation;

public class ContactValidationImpl implements ContactValidation {

    @Override
    public String contactValidation(String name, String email, String message) {
        String result = "";
        try {
            if (name.length() < 2 || name.length() > 30) {
                result = "Invalid name length (should be between 2 and 30 characters)";
            } else if (email.length() < 7 || email.length() > 38) {
                result = "Invalid email length (should be between 7 and 38 characters)";
            } else if (message.length() < 2 || message.length() > 50) {
                result = "Invalid message length (should be between 2 and 50 characters)";
            } else {
                result = "Valid";
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            result = "NullPointerException occurred";
        } catch (Exception e) {
            e.printStackTrace();
            result = "Something went wrong";
        }
        return result;
    }
}
