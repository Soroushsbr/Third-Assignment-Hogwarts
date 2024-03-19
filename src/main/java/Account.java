import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private String username;
    private String password;
    private UUID accountID; //todo: whats is this? :(


    //@Override
    public boolean validatePassword(String enteredPassword) {
        Pattern pattern = Pattern.compile(password);
        Matcher matcher = pattern.matcher(enteredPassword);
        return matcher.find();
    }

    //@Override
    public void changeUsername(String newUsername) {
        username = newUsername;
    }

    //@Override
    public void changePassword(String newPassword) {
        password = newPassword;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
