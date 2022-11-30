import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.slf4j.Logger; //-----------добавляем сами
import org.slf4j.LoggerFactory; //----добавляем сами


public class TestBase {

    //-------------------------------Create Object Logger------------------------------------------------
    final static Logger logger = LoggerFactory.getLogger(TestBase.class);

    //------------------------------------Driver----------------------------------------------------------
    WebDriver wd = new ChromeDriver();


    //-----------------------------------PreConditions----------------------------------------------------
    @BeforeTest
    public void start() {
//        wd = new ChromeDriver();
        wd.get("https://derrick686.softr.app/login");
        wd.manage().window().maximize();
        logger.info("Running a test: start");
    }


    //--------------------------------Repeating actions------------------------------------------------------
    public void enterToAccount(String email, String pass) throws InterruptedException  {
        //------Enter Email
        WebElement username = wd.findElement(By.id("sw-form-capture-email-input"));
        username.click();
        username.clear();
        username.sendKeys(email);

        //-------Enter Password
        WebElement password = wd.findElement(By.id("sw-form-password-input"));
        password.click();
        password.clear();
        password.sendKeys(pass);

        //-------Submit the Form
        WebElement button = wd.findElement(By.id("sw-sign-in-submit-btn"));
        button.click();

        Thread.sleep(2000);
    }


    // --------------------------- Login, Password for User -------------------------------------------------
    public void manager() throws InterruptedException {
//        pageDown();
        enterToAccount("billye@example.com", "123456");
    }
    public void client() throws InterruptedException {
        enterToAccount("lucie@example.com", "123456");
    }
    public void consultant() throws InterruptedException {
        enterToAccount("edra@example.com", "123456");
    }


    //----------------------------Nav Bar for Clients ---------------------------------------------------------
    public Boolean navBarForClient(String text){
        return wd.getPageSource().contains(text);
    }


    //-------------------------(pageDown) Makes Click be possible to use----------------------------------------
    public void pageDown() {
        Actions actions = new Actions(wd);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }


    //-------------------------------Log Out For Every User--------------------------------------------------------------
    public void logOutManager() { //sing in
        wd.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/ul/li[5]/a")).click();
        wd.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/ul/li[5]/div")).click();
    }
    public void logOutClient() { //sing in
        wd.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/ul/li[3]/a")).click();
        wd.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/ul/li[3]/div/a")).click();
    }
    public void logOutConsultant() { // just singout
        wd.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/ul/li[5]/a")).click();
        wd.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/ul/li[5]/div")).click();
    }


    //------------------------------------End of Test-----------------------------------------------------
    @AfterTest
    public void close() {
        logger.info("Close");
        wd.close();
    }
}

