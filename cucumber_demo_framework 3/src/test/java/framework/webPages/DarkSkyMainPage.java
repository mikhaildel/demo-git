package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.*;

import static stepdefinition.SharedSD.getDriver;

public class DarkSkyMainPage extends BasePage {

    private By currentTemperatureLocator = By.xpath("//span[@class='summary swap']");
    private By currentTemperatureTimeline = By.xpath("//div[@id='timeline']//div[@class='timeline']//div[@class='temps']/span/span");
    private By hoursTimeline = By.xpath("//div[@id='timeline']//div[@class='timeline']//div[@class='hours']//span[@class='hour' or @class='hour first']//span");
    private By expandDayTimeline = By.xpath("//a[1]//span[3]//span[1]");
    private By minTempDisplayed = By.xpath("//a[@class='day revealed']//span[@class='tempRange']//span[@class='minTemp']");
    private By minTempExpanded = By.xpath("//div[@class='dayDetails revealed']//div[@class='highLowTemp swip']//span[@class='highTemp swip']//span[@class='temp']");
    private By maxTempDisplayed = By.xpath("//a[@class='day revealed']//span[@class='tempRange']//span[@class='maxTemp']");
    private By maxTempExpanded = By.xpath("//div[@class='dayDetails revealed']//div[@class='highLowTemp swip']//span[@class='lowTemp swap']//span[@class='temp']");


    private int increment = 2;

    public boolean isDarkSkyTitleDisplayed() {
        return getDriver().getTitle().contains("Dark Sky");
    }

    public boolean isHourTimelineDisplayedCorrectly() {
        Calendar calendar = new GregorianCalendar();
        calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("ha");
        List<String> actualValues = new ArrayList<>();
        List<WebElement> hours = getDriver().findElements(hoursTimeline);
        for (WebElement hour: hours)  {
            actualValues.add(hour.getText().toUpperCase());
        }
        List<String> arrayOfExpectedValues = new ArrayList<>();
        arrayOfExpectedValues.add("NOW");
        calendar.add(Calendar.HOUR,increment);
        arrayOfExpectedValues.add(format.format(calendar.getTime()));
        for (int i = 2; i < actualValues.size(); i++) {
            calendar.add(Calendar.HOUR,increment);
            arrayOfExpectedValues.add(format.format(calendar.getTime()));
        }
        return actualValues.equals(arrayOfExpectedValues);
    }

    public boolean isLowestAndHighestTempDisplayedCorrectly() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,650)", "");
        Thread.sleep(1000);
        clickOn(expandDayTimeline);
        Thread.sleep(2000);
         return getTextFromElement(minTempDisplayed).equals(getTextFromElement(minTempExpanded)) &&
                 getTextFromElement(maxTempDisplayed).equals(getTextFromElement(maxTempExpanded));
    }

    public boolean isCurrentTemperatureWithinTheTimeline() {
        ArrayList<Integer> numsOfTimeline = new ArrayList<>();
        List<WebElement> temperatures = getDriver().findElements(currentTemperatureTimeline);
        for (WebElement temperature : temperatures) {
            numsOfTimeline.add(Integer.parseInt(temperature.getText().substring(0, temperature.getText().length() - 1)));
        }
        int currentTemperature = getCurrentTemperature(currentTemperatureLocator);
        Collections.sort(numsOfTimeline);
        return (currentTemperature >= numsOfTimeline.get(0)) && (currentTemperature <= numsOfTimeline.get(numsOfTimeline.size() -1));
    }

}
