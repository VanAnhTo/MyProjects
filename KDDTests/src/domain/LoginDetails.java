package domain;

/**
 * Created with IntelliJ IDEA.
 * User: Sukeshk
 * Date: 09/03/13
 * Time: 9:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginDetails {


    private String username;
    private String password;

    public LoginDetails( String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
