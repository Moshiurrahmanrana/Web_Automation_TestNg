package page;


import Utils.Utils;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import java.io.FileWriter;
import java.io.IOException;

public class Signup {
    WebDriver driver;
    @FindBy(className = "login")
    WebElement linkLogin;
    @FindBy(id = "email_create")
    WebElement EmailAddress;
    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]/span")
    WebElement CreateAccountButton;
    @FindBy(id = "id_gender1")
    WebElement SelectGender;
    @FindBy(id = "customer_firstname")
    WebElement FirstName;
    @FindBy(id = "customer_lastname")
    WebElement LastName;
    @FindBy(id = "passwd")
    WebElement Password;
    @FindBy(id = "days")
    WebElement BDays;
    @FindBy(id = "months")
    WebElement BMonths;
    @FindBy(id = "years")
    WebElement BYears;
    @FindBy(id = "newsletter")
    WebElement Newsletter;
    @FindBy(id = "company")
    WebElement CompanyName;
    @FindBy(id = "address1")
    WebElement Address1;
    @FindBy(id = "address2")
    WebElement Address2;
    @FindBy(id = "city")
    WebElement City;
    @FindBy(id = "id_state")
    WebElement State;
    @FindBy(id = "postcode")
    WebElement PostCode;
    @FindBy(id = "other")
    WebElement Information;
    @FindBy(id = "phone")
    WebElement HomePhone;
    @FindBy(id = "phone_mobile")
    WebElement MobilePhone;
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")
    WebElement lblUserName;
    @FindBy(xpath = "//*[@id=\"submitAccount\"]/span")
    WebElement RegisterButton;
    @FindBy(id = "my-account")
    WebElement LogOutBtn;



    public Signup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    Utils utils;
    public void doSignUp () throws Exception{
        linkLogin.click();
        utils=new Utils(driver);
        String email=utils.generateRandomEmail(100000,999999);
        Reporter.log(email);
        EmailAddress.sendKeys(email);
        CreateAccountButton.click();
        JSONObject obj = new JSONObject();
        obj.put("email",email);
        obj.put("password","password1234");
        FileWriter file = new FileWriter("./src/test/resources/user.json");
        file.write(obj.toJSONString());
        file.flush();
        System.out.println(obj);

        SelectGender.click();
        FirstName.sendKeys("Moshiur");
        LastName.sendKeys("Rahman");
        Password.sendKeys("password1234");
        Select day = new Select(BDays);
        day.selectByValue("1");
        Select month = new Select(BMonths);
        month.selectByValue("1");
        Select year = new Select(BYears);
        year.selectByIndex(3);
        Newsletter.click();
        CompanyName.sendKeys("DSL");
        Address1.sendKeys("Dhanmondi,27");
        Address2.sendKeys("SkillJobs");
        City.sendKeys("Dhaka");
        Select state = new Select(State);
        state.selectByValue("2");
        PostCode.sendKeys("10001");
        Information.sendKeys("Hlw");
        HomePhone.sendKeys("12334556");
        MobilePhone.sendKeys("01761685266");
        RegisterButton.click();

        LogOutBtn.click();
    }
}