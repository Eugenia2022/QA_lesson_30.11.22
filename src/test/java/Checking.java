import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checking extends TestBase {

    @Test
    public void managerLogIn() throws InterruptedException {
        logger.info("Running ManagerLogIN test");
        pageDown();
        Thread.sleep(3000);
        manager();
        Thread.sleep(3000);
        wd.findElement(By.partialLinkText("PROJECT OVERVIEW"));
        wd.findElement(By.partialLinkText("CLIENTS"));
        wd.findElement(By.partialLinkText("TEAM"));
        wd.findElement(By.partialLinkText("INVOICES"));
        Thread.sleep(3000);
        logOutManager();
    }

    @Test
    public void clientLogIn() throws InterruptedException {
        logger.info("Running ClientLogIN test");

        pageDown();
        Thread.sleep(3000);
        client();
        Thread.sleep(3000);
        wd.findElement(By.partialLinkText("PROJECTS OVERVIEW"));
        wd.findElement(By.partialLinkText("INVOICES"));
        Thread.sleep(3000);

        Assert.assertFalse(navBarForClient("CLIENTS"));
        Assert.assertFalse(navBarForClient("TEAM"));
        Thread.sleep(3000);

        Assert.assertTrue(wd.findElements(By.partialLinkText("CLIENTS")).isEmpty());
        Assert.assertTrue(wd.findElements(By.partialLinkText("TEAM")).isEmpty());
        Thread.sleep(3000);

        logOutClient();
    }

    @Test
    public void consultantLogIn() throws InterruptedException {
        logger.info("Running ConsultantLogIN test");
        pageDown();
        Thread.sleep(3000);
        consultant();
        Thread.sleep(3000);
        wd.findElement(By.partialLinkText("PROJECT OVERVIEW"));
        wd.findElement(By.partialLinkText("CLIENTS"));
        wd.findElement(By.partialLinkText("TEAM"));
        wd.findElement(By.partialLinkText("INVOICES"));
        Thread.sleep(3000);
        logOutConsultant();
    }

}

