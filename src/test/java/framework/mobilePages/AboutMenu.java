package framework.mobilePages;

import framework.MobileBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AboutMenu extends MobileBasePage {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='About']")
    private MobileElement sideBarAbout;

    public boolean isAboutMenuPresent() {
        return isElementDisplayed(sideBarAbout);
    }
}
