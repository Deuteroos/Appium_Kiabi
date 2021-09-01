package kiabi.pages;

import kiabi.manager.AndroidDriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Utils {

    protected final AppiumDriver<MobileElement> driver;

    protected WebDriverWait wait;
    protected WebDriverWait loadingWait;
    protected WebDriverWait longWait;
    protected WebDriverWait shortWait;

    public Utils() {
        this.driver = AndroidDriverManager.getDriver();

        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
        this.wait = new WebDriverWait(this.driver, 5);
        this.loadingWait = new WebDriverWait(this.driver, 30);
        this.longWait = new WebDriverWait(this.driver, 60);
        this.shortWait = new WebDriverWait(this.driver, 1);
    }

    protected <V> boolean shortWaitUntil(Function<? super WebDriver, V> isTrue) {
        try {
            shortWait.until(isTrue);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected <V> boolean waitUntil(Function<? super WebDriver, V> isTrue) {
        try {
            wait.until(isTrue);
            return true;
        } catch (TimeoutException | StaleElementReferenceException e) {
            return false;
        }
    }

    protected <V> boolean loadingWaitUntil(Function<? super WebDriver, V> isTrue) {
        try {
            loadingWait.until(isTrue);
            return true;
        } catch (TimeoutException | StaleElementReferenceException e) {
            return false;
        }
    }

    protected <V> boolean longWaitUntil(Function<? super WebDriver, V> isTrue) {
        try {
            this.longWait.until(isTrue);
            return true;
        } catch (TimeoutException | StaleElementReferenceException e) {
            return false;
        }
    }

    protected boolean hasClass(WebElement element, String expectedClass) {
        return element.getAttribute("class").contains(expectedClass);
    }

    protected void set(MobileElement elem, String text, String placeHolder) {
        elem.sendKeys(text);
    }

    protected void set(MobileElement elem, String text) {
        this.set(elem, text, null);
    }

    protected void click(MobileElement elem) {
        loadingWaitUntil(elementToBeClickable(elem));
        elem.click();
    }

    protected void longPress(MobileElement elem) {
        this.wait.until(elementToBeClickable(elem));
        new Actions(this.driver)
                .clickAndHold(elem)
                .perform();
    }

    protected void swipeScreen(String direction, int perc) {
        Dimension size = this.driver.manage().window().getSize();
        Integer fromX = null, fromY = null,
                toX = null, toY = null;

        switch (direction) {
            case "UP":
                fromX = toX = size.width / 2;
                toY = 0;
                fromY = (int) ((double) size.height * (((double) perc) / 100));
                break;
            case "DOWN":
                fromX = toX = size.width / 2;
                toY = (int) ((double) size.height * (((double) perc) / 100));
                fromY = 0;
                break;
        }
        swipe(
                PointOption.point(fromX, fromY),
                PointOption.point(toX, toY)
        );
    }

    protected void swipe(PointOption from, PointOption to) {
        new TouchAction(this.driver)
                .longPress(from)
                .moveTo(to)
                .release().perform();
    }

    public AndroidDriver getAndoidDriver() {
        return (AndroidDriver<MobileElement>) driver;
    }

    protected boolean isDisplayed(MobileElement elem) {
        return this.waitUntil(visibilityOf(elem));
    }
}
