package org.example.uitests;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTestClass {

    @Test
    public void BasicAuthTest() throws InterruptedException {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Basic Auth");
// First try
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        javascriptExecutor.executeScript("sessionStorage.clear();");
//        javascriptExecutor.executeScript("localStorage.clear();");
// Second try
//        driver.manage().deleteAllCookies();
//        Thread.sleep(10000);
// Third try
//        driver.get("chrome://settings/clearBrowserData");
//        Thread.sleep(3000);
//        WebElement bt = driver.findElement(By.xpath("//settings-ui"));
//        Thread.sleep(3000);
//        bt.sendKeys(Keys.ENTER);
//        Thread.sleep(10000);
// New try
//        driver.get("chrome://settings/clearBrowserData");
//        Thread.sleep(10000);
//        WebElement bt = driver.findElement(By.xpath("//*[@id=\"clearBrowsingDataConfirm\"]"));
//        bt.click();
//        Thread.sleep(10000);
//        //*[@id="clearBrowsingDataConfirm"]
// Success try
        driver.get("chrome://settings/clearBrowserData");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        String script = "return document.querySelector(\"body > settings-ui\").shadowRoot.querySelector(\"#main\").shadowRoot.querySelector(\"settings-basic-page\").shadowRoot.querySelector(\"#basicPage > settings-section:nth-child(10) > settings-privacy-page\").shadowRoot.querySelector(\"settings-clear-browsing-data-dialog\").shadowRoot.querySelector(\"#clearBrowsingDataConfirm\");";
        String script = "return document.querySelector('settings-ui').shadowRoot.querySelector('settings-main').shadowRoot.querySelector('settings-basic-page').shadowRoot.querySelector('#basicPage > settings-section > settings-privacy-page').shadowRoot.querySelector('settings-clear-browsing-data-dialog').shadowRoot.querySelector('#clearBrowsingDataDialog > div:nth-child(4) > #clearBrowsingDataConfirm')";
        WebElement clearData =  (WebElement) jse.executeScript(script);
        clearData.click();


        driver.get("https://the-internet.herokuapp.com/basic_auth");
//        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Basic Auth");
    }

    @Test
    public void BasicAuthTestWithoutAuth() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Basic Auth");
    }
}


