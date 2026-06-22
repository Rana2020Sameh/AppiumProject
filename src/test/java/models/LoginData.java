package models;

public class LoginData {

    private String email;
    private String password;
    private String expectedResult;

    // Getters
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getExpectedResult() { return expectedResult; }

    // Setters
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setExpectedResult(String expectedResult) { this.expectedResult = expectedResult; }
}
