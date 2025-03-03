import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;

@RunWith(Cucumber.class)
@CucumberOptions(
           features = "src/test/resources/Login.feature",

        tags = "@sample",
        plugin = {"pretty","html:target1/crept.html"}
)


public class TestRunner {


    public static WebDriver driver;

    @BeforeClass

    public  static void startBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://applicationforlibrarymanagementsystem.onrender.com/login");
    }

    @AfterClass

    public static void end(){
        driver.close();
    }


}
