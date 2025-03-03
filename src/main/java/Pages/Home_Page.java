package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

    WebDriver driver;


    @FindBy(xpath = "//h2[contains(text(),'Book List')]")
    public WebElement heading;

    @FindBy(xpath = "//h2[contains(text(),'Welcome')]")
    public  WebElement welcome_heading;

    @FindBy(xpath = "//*[@class='min-w-full border-collapse border border-gray-300']")
    public WebElement book_table_data;
    @FindBy(xpath = "//button[contains(text(),'Add Book')]")
    public  WebElement addbook_btn;

    @FindBy(xpath = "//button[contains(text(),'Previous')]")
    public WebElement previous_btn;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    public WebElement next_btn;

    @FindBy(xpath = "//button[contains(text(),'Log Out')]")
    public WebElement logout_btn;

    public Home_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
