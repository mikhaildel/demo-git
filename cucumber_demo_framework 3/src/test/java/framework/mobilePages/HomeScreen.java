package framework.mobilePages;

import framework.MobileBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;

public class HomeScreen extends MobileBasePage {
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='SKIP ']")
    @iOSFindBy(accessibility = "undefined")
    private MobileElement skipButton;

    @AndroidFindBy(xpath = "//android.webkit.WebView/android.view.View/android.widget.Button[1]")
    @iOSFindBy(accessibility = "undefined")
    private MobileElement mainMenu;

    @AndroidFindBy(xpath = "//android.webkit.WebView/android.view.View[@content-desc='information circle About ']")
    @iOSFindBy(accessibility = "undefined")
    private MobileElement aboutButton;

    public void tapOnSkipButton() {
        tapOn(skipButton);
    }

    public void tapOnMainMenuButton() {
        tapOn(mainMenu);
    }

    public void tapOnAboutButton() {
        tapOn(aboutButton);
    }
}
