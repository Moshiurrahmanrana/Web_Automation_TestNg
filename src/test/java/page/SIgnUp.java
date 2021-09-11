package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SIgnUp {
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



    public SIgnUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String doSignUp (String email,String password) throws InterruptedException {
        linkLogin.click();
        EmailAddress.sendKeys(email);
        CreateAccountButton.click();
        SelectGender.click();
        FirstName.sendKeys("Moshiur");
        LastName.sendKeys("Rahman");
        Password.sendKeys(password);
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
//        Reference.sendKeys("pantopath");
        RegisterButton.click();

        return lblUserName.getText();
    }
}