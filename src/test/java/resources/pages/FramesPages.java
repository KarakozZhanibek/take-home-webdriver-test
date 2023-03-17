package resources.pages;

import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.utilities.BaseClass;

public class FramesPages extends BaseClass {

    public FramesPages() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="#mce_0_ifr")
    WebElement iFrame;

    @FindBy(css="#tinymce>p")
    WebElement iFrameTextBox;

    public void swtIFrame() {
        //driver.switchTo().frame("#mce_0_ifr");
        try {
            driver.switchTo().frame(0);
        }catch(NoSuchFrameException e) {
            System.out.println(e.getMessage());

        }
    }

    public void enterTextIframe() {
        iFrameTextBox.clear();
        iFrameTextBox.sendKeys(prop.getProperty("TextOnIframe"));
    }

    public String verifyIframeText() {
        String iframeText=iFrameTextBox.getText();
        return iframeText;
    }

}