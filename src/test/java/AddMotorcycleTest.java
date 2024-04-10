import org.example.helper.Helper;
import org.example.pageObjects.AddCarPage;
import org.example.pageObjects.AddMotorcyclePage;
import org.example.pageObjects.ChooseCategoryPage;
import org.example.pageObjects.LoginPage;
import org.junit.Assert;
import org.junit.Test;

public class AddMotorcycleTest extends BaseTest{

    @Test

    public void chooseMotorcycleTest() {
        ChooseCategoryPage postAnAddPage = new ChooseCategoryPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        Helper helper = new Helper(driver);
        postAnAddPage.chooseCategory();
        loginPage.login();
        helper.waitForPageToLoad();
        postAnAddPage.chooseMotorcycleCategory();
    }

    @Test
    public void addMotorcycleTest() {
        AddMotorcyclePage motorcyclePage = new AddMotorcyclePage(driver);
        Helper helper = new Helper(driver);
        chooseMotorcycleTest();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url ,"https://profile.stg.polovni.dev/motori");
        motorcyclePage.fillAddMotorcycleForm();
    }
}