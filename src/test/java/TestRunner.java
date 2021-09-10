import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.Login;

import java.io.FileReader;

public class TestRunner extends Setup {

    Login objLogin;

    @Test(priority = 1, description = "User Login", enabled = true)
    public void doLogin() throws Exception {
        driver.get("http://automationpractice.com");
        objLogin = new Login(driver);

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject json  = (JSONObject) jsonArray.get(0);

        String email = (String) json.get("email");
        String password = (String) json.get("password");

        String user =objLogin.doLogin(email, password);
        Assert.assertEquals(user, "Test User");
        driver.findElement(By.xpath("//a[@class='logout']")).click();
    }
    @Test(enabled = true)
    public void doLoginForWrongPassword1() throws Exception {
        driver.get("http://automationpractice.com");
        objLogin = new Login(driver);

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject json  = (JSONObject) jsonArray.get(1);

        String email = (String) json.get("email");
        String password = (String) json.get("password");

        String authError =objLogin.doLoginForNegativeScenario1(email, password);
        Assert.assertEquals(authError, "Authentication failed.");
    }
    @Test(enabled = true)
    public void doLoginForWrongPassword2() throws Exception {
        driver.get("http://automationpractice.com");
        objLogin = new Login(driver);

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject json  = (JSONObject) jsonArray.get(2);

        String email = (String) json.get("email");
        String password = (String) json.get("password");

        String authError =objLogin.doLoginForNegativeScenario2(email, password);
        Assert.assertEquals(authError, "Authentication failed.");
    }
}
