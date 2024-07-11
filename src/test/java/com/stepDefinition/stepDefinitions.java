package com.stepDefinition;

import java.time.Duration;

import pages.SignUpPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepDefinitions {

	private static WebDriver driver;       
    public final static int TIMEOUT = 10;
    String baseURL = "https://www.google.com";
    SignUpPages signup= new SignUpPages();

    @Before
    public void setUp() {
 
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to Windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--disable-in-process-stack-traces");
        options.addArguments("--disable-logging");
        options.addArguments("--log-level=3");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @Given("^user searches for a \"([^\"]*)\"$")
    public void user_searches_for_a(String arg1) throws Throwable {
    	
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(arg1);
    }

    @And("^click on search button$")
    public void click_on_search_button() throws Throwable {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.submit();
    }

    @Then("^results retreived should contain the \"([^\"]*)\" used$")
    public void results_retreived_should_contain_the_used(String resultString) throws Throwable {
        WebElement result = driver.findElement(By.className("LC20lb"));
        if (resultString.equalsIgnoreCase(result.getText())) {
            System.out.println("Text is matching");
        } else {
            System.out.println("Text is not matching");

        }
        
    }
    

    
    @Given("^USer clicks on signup$")
    public void user_CLicks_on_signup() throws Throwable {
    	
       driver.findElement(signup.SIGN_UP).click();;
        

    }
    @Then("^User clicks on FreeLancher$")
    public void user_CLicks_on_FreeLanchers() throws Throwable {
    	
        WebElement searchBox = driver.findElement(By.name("q"));
      
    }
    @Then("^User Create an Account$")
    public void user_CLicks_on_Accounts() throws Throwable {
    	
        WebElement searchBox = driver.findElement(By.name("q"));
        
    }
    
        
    @After
    public void postExecution()
    {
    	driver.quit();
    }

}