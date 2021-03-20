import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.Selenide.$;


public class BasePage {




    BasePage(){
        Configuration.browser = "Chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        ChromePopUp();
    }

    SelenideElement findByCss(String css){ return $(By.cssSelector(css)); }

    public void ChromePopUp (){
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        Configuration.browserCapabilities= opt;

    }



}
