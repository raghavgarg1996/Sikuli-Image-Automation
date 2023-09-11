package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Main {
 //   static final String IMAGES_PATH = System.getProperty("user.dir") + "/Images/";
    static final String IMAGES_PATH = System.getProperty("user.dir") + "\\src\\Images\\";


    public static void main(String[] args) {
    //    System.setProperty("webdriver.chrome.driver", "/Users/raghav.garg/Downloads/chromedriver"); // For Mac
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe"); // For Windows
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.dc.com/characters/batman");
        clickOnDcIconUsingImage();
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.dc.com/")) {
            System.out.println("DC page successfully opened through Batman page using images");
        } else {
            System.out.println("DC page not opened");
        }
        driver.quit();
    }

    public static void clickOnDcIconUsingImage() {
  //      final String IMAGES_PATH = System.getProperty("user.dir") + "/Images/";

        Screen screen = new Screen();
        System.out.println(IMAGES_PATH);
        Pattern DCLogo = new Pattern(IMAGES_PATH + "dcLogo.png");
        Pattern searchLogin = new Pattern(IMAGES_PATH + "searchLogin.png");
        try {
            screen.wait(DCLogo, 5);
            screen.click(DCLogo);
            screen.wait(searchLogin, 10);
        } catch (FindFailed e) {
            throw new RuntimeException(e);
        }
    }


}