package TestRunner;

import Setup.Setup;
import org.testng.annotations.Test;
import page.Signup;

public class SignupTestRunner extends Setup {
    Signup objSignup;
    @Test
    public void doSignup() throws Exception{
        driver.get("http://automationpractice.com");
        objSignup = new Signup(driver);
        objSignup.doSignUp();
    }
}
