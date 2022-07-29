package school21.spring.service.models;

public class User {
    private Long identifier;
    private String email;

    @Override
    public String toString() {
        return "User id: " + identifier + '\n' +
                "User email: " + email;
    }

    public User() {

    }

    public User(Long identifier, String email) {
        this.email = email;
        this.identifier = identifier;
    }

    public Long getIdentifier() {
        return identifier;
    }

    public String getEmail() {
        return email;
    }

    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
