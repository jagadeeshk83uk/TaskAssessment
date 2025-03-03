package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
    WebDriver driver;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public  WebElement password;

    @FindBy(id = "login-button")
    public  WebElement login_btn;


    public Login_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

}
