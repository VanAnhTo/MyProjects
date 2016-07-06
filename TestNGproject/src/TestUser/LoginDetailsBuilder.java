package TestUser;


public class LoginDetailsBuilder {
	
    private String username;
    private String password;


    public LoginDetailsBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public LoginDetailsBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public LoginDetails build() {
        return new LoginDetails(username, password);
    }
}
