import com.codeborne.selenide.testng.ScreenShooter;
import extensions.RetryAnalyzer;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertTrue;

@Listeners({ ScreenShooter.class })
public class UITests{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void searchAndFindResults() throws InterruptedException {
        TrendyolHomePage homePage = new TrendyolHomePage();

        homePage.goToPage();

        homePage.setValue("pantolon");

        assertTrue( homePage.checkResult());

        homePage.goToNextPage();
        $("#sticky>div>div:nth-child(18)>div.fltr-cntnr-ttl").scrollIntoView(false);
        Thread.sleep(2000);

        $(".dscrptn>h1").scrollIntoView(false);
        Thread.sleep(2000);

        String result=$(".dscrptn>h1").getText();
        if(result=="pantolon"){
            System.out.println("Test Başarılı");
        }
        else
            System.out.println("Test Basarisiz!");

    }
}