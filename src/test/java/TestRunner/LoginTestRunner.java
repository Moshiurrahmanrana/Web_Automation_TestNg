package TestRunner;

import Setup.Setup;
import Utils.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.Login;
import java.io.IOException;
import java.text.ParseException;

public class LoginTestRunner extends Setup {

    Login objLogin;
    Utils utils;


    @Test(enabled = true, groups = "login")
    public void doLogin() throws Exception {
        driver.get("http://automationpractice.com");
        objLogin = new Login(driver);

        utils = new Utils(driver);
        utils.readJSONArray(0);

        String user = objLogin.doLogin(utils.getEmail(), utils.getPassword());
        Assert.assertEquals(user, "Test User");
        driver.findElement(By.xpath("//a[@class='logout']")).click();
    }

    @Test(enabled = true,groups = "login")
    public void doLoginForWrongPassword() throws IOException, ParseException, InterruptedException, org.json.simple.parser.ParseException {
        driver.get("http://automationpractice.com");
        objLogin = new Login(driver);
        utils = new Utils(driver);
        utils.readJSONArray(1);

        String authError = objLogin.doLoginForWrongPassword(utils.getEmail(), utils.getPassword());
        Assert.assertEquals(authError, "Authentication failed.");
    }

    @Test(enabled = true,groups = "login")
    public void doLoginForInvalidEmail() throws Exception {
        driver.get("http://automationpractice.com");
        objLogin = new Login(driver);

        utils = new Utils(driver);
        utils.readJSONArray(2);
        String error = objLogin.doLoginForWrongEmail(utils.getEmail(), utils.getPassword());
        Assert.assertEquals(error, "Invalid email address.");
    }

}
