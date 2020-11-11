package stringtype.registration;

public class UserValidator {
    private String username;
    private String password1;
    private String password2;
    private String email;

    public UserValidator(String username, String password1, String password2) {
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
    }

    public boolean isValidUsername(String username) {
        return !"".equals(username);                                               // ? "A felhasználónév megadása sikeres." : "A felhasználónév megadása kötelező.";
    }                                                                              // (username == true);

    public boolean isValidPassword(String password1, String password2) {
        return  (password1.equals(password2)) && (password1.length() >= 8);         // ? "A jelszó megadása sikeres" : "A jelszó megadása sikertelen.";
    }

}
