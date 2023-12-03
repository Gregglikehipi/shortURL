package HAYE.demo.data;

public class UserRegistration {
    private String name;
    private String pass;
    private String passConfirmation;

    public UserRegistration() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPassConfirmation() {
        return passConfirmation;
    }

    public void setPassConfirmation(String passConfirmation) {
        this.passConfirmation = passConfirmation;
    }
}
