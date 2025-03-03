package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddBook_page {


    WebDriver driver;

    @FindBy(xpath = "//h2[contains(text(),'Add a New Book')]")
    public WebElement Add_new_book_heading;

    @FindBy(id = "title")
    public WebElement book_title;

    @FindBy(id = "author")
    public WebElement book_author;

    @FindBy(id = "genre")
    public  WebElement book_genre;

    @FindBy(id = "isbn")
    public WebElement book_isbn;

    @FindBy(id = "publicationDate")
    public  WebElement book_publication_date;

    @FindBy(id = "price")
    public  WebElement book_price;

    @FindBy(xpath = "//h3[contains(text(),'Please correct the following errors:')]")
    public WebElement error_message;



    public AddBook_page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
