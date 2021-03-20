import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TrendyolHomePage extends BasePage{

    private static WebDriver driver;

    String searchBar = ".search-box";
    String description = ".dscrptn>h1";


    String url = "https://www.trendyol.com";
    String nextPage = "https://www.trendyol.com/sr?q=pantolon&qt=pantolon&st=pantolon&os=1&pi=98";
    void goToPage(){
        open(url);
        $(".fancybox-close").click();
    }


    void goToNextPage(){
        open(nextPage);
    }

    public void setValue(String value){
        SelenideElement elem = findByCss(searchBar);
        elem.setValue(value);
        findByCss(searchBar).sendKeys(Keys.ENTER);

    }

    public Boolean checkResult(){
        SelenideElement elem = findByCss(description);
        Boolean result = elem.isDisplayed();
        return result;
    }


}
