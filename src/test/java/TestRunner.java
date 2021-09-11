import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.Login;
import page.SIgnUp;

import java.io.FileReader;
import java.io.FileWriter;

public class TestRunner extends Setup {

    Login objLogin;
    SIgnUp objSIgnUp;



    @Test(priority = 1, description = "User Login", enabled = true)
    public void doLogin() throws Exception {
        driver.get("http://automationpractice.com");
        objLogin = new Login(driver);

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject json = (JSONObject) jsonArray.get(0);

        String email = (String) json.get("email");
        String password = (String) json.get("password");

        String user = objLogin.doLogin(email, password);
        Assert.assertEquals(user, "Test User");
        driver.findElement(By.xpath("//a[@class='logout']")).click();
    }

    @Test(enabled = true)
    public void doLoginForWrongPassword() throws Exception {
        driver.get("http://automationpractice.com");
        objLogin = new Login(driver);

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject json = (JSONObject) jsonArray.get(1);

        String email = (String) json.get("email");
        String password = (String) json.get("password");

        String authError = objLogin.doLoginForWrongPassword(email, password);
        Assert.assertEquals(authError, "Authentication failed.");
    }

    @Test(enabled = true)
    public void doLoginForInvalidEmail() throws Exception {
        driver.get("http://automationpractice.com");
        objLogin = new Login(driver);

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject json = (JSONObject) jsonArray.get(2);

        String email = (String) json.get("email");
        String password = (String) json.get("password");

        String authError = objLogin.doLoginForWrongEmail(email, password);
        Assert.assertEquals(authError, "Invalid email address.");
    }
    @Test(enabled = true)
    public void writeJson() throws Exception {
        JSONObject userObj = new JSONObject();
        userObj.put("email","mkd1112@gmail.com");
        userObj.put("password","12345");

        FileWriter writer = new FileWriter("./src/test/resources/user.json");
        writer.write(userObj.toJSONString());
        writer.flush();
        writer.close();
    }

    @Test(enabled = true)
    public void doSignUpFor() throws Exception {
        driver.get("http://automationpractice.com");
        objSIgnUp = new SIgnUp(driver);

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/user.json"));
        JSONObject jsonObject = (JSONObject) obj;
        String email = (String) jsonObject.get("email");
        String password = (String) jsonObject.get("password");

        String authError = objSIgnUp.doSignUp(email,password);
        Assert.assertEquals(authError, "Moshiur Rahman");
    }

}
