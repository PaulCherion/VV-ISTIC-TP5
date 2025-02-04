# Random Wikipedia walker

Using Selenium, create a small program that, starting from the main page https://www.wikipedia.org/, walks trough a sequence of random links and takes a snapshot of the last page.
The process is as follows:

 1. Navigate to the main page https://www.wikipedia.org/
 2. Select a random link in the page
 3. Navigate to the link
 4. Repeat steps 2 to 3 until you have visited 10 different pages
 5. Take a snapshot of the current page and save it

Include the code of the walker and the snapshot in this document.

## Answer
Nous avons ajouté un try/catch atour de la boucle pour terminer correctement l'exécution en cas de timout du driver.
En effet, pour une raison inconnue le driver échoue parfois à cliquer sur le lien choisi et s'arrête là. 
Enfin, nous avons restreint le choix des liens à ceux du corps de la page Wikipedia afin de rester sur des pages internes et éviter les pages sans lien/avec sécurité.

### Capture d'une des pages trouvées
![page](../images/savedPage.png)

### Code java

```java
package fr.istic.vv;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class RandomWalker {
    static final String URL = "https://fr.wikipedia.org/wiki/Institut_sup%C3%A9rieur_des_technologies_en_informatique_et_communication";

    public static WebDriver configureDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        return new ChromeDriver(options);
    }

    public static void main(String[] args) {

        WebDriver driver = configureDriver();
        
        driver.get(URL);
        String title = driver.getTitle();
        System.out.println("Bienvenue sur " + title);

        try {
            for (int i = 0; i<5; i++) {
                WebElement e = getRandomLink(driver);

                // Scroll to the element
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].scrollIntoView(true);", e);

                // Wait for the render of e
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(e));

                // Click on it
                System.out.println("Clicking on " + e.getAttribute("href"));
                e.click();
            }
        } catch (TimeoutException e) {
            System.out.println("Erreur de clickage, j'en reste là...");
        }

        System.out.println("Dernière page : " + driver.getTitle());
        //Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File("/tmp/savedPage.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Fini !");

        driver.quit();
    }



    public static WebElement getRandomLink(WebDriver driver) {
        List<WebElement> links = driver.findElements(By.xpath("//main//a[starts-with(@href, '/wiki/') and not(@disabled)]"));
        Random r = new Random();
        return links.get(r.nextInt(links.size()));
    }
}

```