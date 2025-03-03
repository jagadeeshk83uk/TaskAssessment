import Pages.AddBook_page;
import Pages.Home_Page;
import Pages.Login_Page;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyStepdefs {

    WebDriver driver;
    Login_Page login_page;
    Home_Page home_page;
    AddBook_page addBook_page;

    @Before
    public void start(){

        driver = TestRunner.driver;
        login_page =new Login_Page(driver);
        home_page = new Home_Page(driver);
        addBook_page = new AddBook_page(driver);
    }


    @Given("User navigates to the application")
    public void userNavigatesToTheApplication() {

        String acttitle = driver.getTitle();
        String exptitle = "Books Inventory App";
        Assert.assertEquals(exptitle,acttitle);

    }



    @And("User clicks on PIM option")
    public void userClicksOnPIMOption() {
       // driver.findElement(By.id("menu_pim_viewPimModule")).click();
    }

    @And("User clicks on Employee List")
    public void userClicksOnEmployeeList() {

       // driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
    }

    @Then("User is able to see Employee information")
    public void userIsAbleToSeeEmployeeInformation() {

        String actdata = driver.findElement(By.xpath("//*[contains(text(),'Employee Information')]")).getText();
        String expdata = "Employee Information";
        Assert.assertEquals(expdata,actdata);

    }


    @When("User enters {string} and {string}")
    public void userEntersAnd(String userid, String password) {
        login_page.username.sendKeys(userid);
        login_page.password.sendKeys(password);
        login_page.login_btn.click();


    }

    @And("User navigates to Book List page")
    public void userNavigatesToBookListPage() {

        String actvalue = home_page.welcome_heading.getText();
        String expvalue = "Welcome, Admin!";
        Assert.assertEquals(expvalue,actvalue);

        Assert.assertEquals("Book List",home_page.heading.getText());
    }

    @And("User clicks on Add option to add book")
    public void userClicksOnAddOptionToAddBook() {

        home_page.addbook_btn.click();
        Assert.assertEquals(true,addBook_page.Add_new_book_heading.isDisplayed());

    }

    @And("User add details {string} {string} {string} {string} {string} {string}")
    public void userAddDetails(String Title, String Author, String ISBN, String Price, String Publicationdate, String Genre) {

        addBook_page.book_title.sendKeys(Title);
        addBook_page.book_author.sendKeys(Author);
        addBook_page.book_isbn.sendKeys(ISBN);
        addBook_page.book_price.sendKeys(Price);
        addBook_page.book_publication_date.sendKeys(Publicationdate);
        addBook_page.book_genre.sendKeys(Genre);

        home_page.addbook_btn.click();
    }

    @Then("Book with {string} is displayed under the added list of homepage")
    public void bookWithIsDisplayedUnderTheAddedListOfHomepage(String Title) {
        List<WebElement> rows = home_page.book_table_data.findElements(By.tagName("tr"));
        String expectedvalue = Title;
        boolean datafound = false;

        for(int i=1;i< rows.size();i++){
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            for(WebElement col : cols){
                if(col.getText().contains(expectedvalue)){
                    datafound = true;
                    System.out.println(" Data found in table");
                }break;

            }
            if(datafound)break;
        }

    }

    @And("User clicks on Add book button without entering the data")
    public void userClicksOnAddBookButtonWithoutEnteringTheData() {
        home_page.addbook_btn.click();
    }

    @Then("User is displayed with error {string}")
    public void userIsDisplayedWithError(String message) {
        Assert.assertEquals(message,addBook_page.error_message.getText());

    }
}
