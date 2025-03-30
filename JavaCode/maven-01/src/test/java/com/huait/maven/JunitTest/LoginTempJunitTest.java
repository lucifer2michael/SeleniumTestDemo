package com.huait.maven.JunitTest;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTempJunitTest {
    // 优化LoginJunitTest26

    static WebDriver driver = null;

    @BeforeAll
    static void BeforeEach() {
        driver = new ChromeDriver();
        driver.get("http;//127.0.0.1;8080/jeewms/");
    }

    @AfterAll
    static void AfterEach() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    //		第一条登录成功用例 改变
    @Test
    @Order(1)
    void test_login() {

        driver.findElement(By.name("userName")).clear();
        driver.findElement(By.name("userName")).sendKeys("admin");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("11g123");
//		验证码一般在自动化不测试验证码 给个万能验证码 去掉验证码
        driver.findElement(By.name("randCode")).sendKeys("0000");
        driver.findElement(By.id("but_login")).click();
//		取实际结果
        String sjmsg = driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/a/span/small")).getText();
        System.out.println(sjmsg);
        Assertions.assertEquals("admin", sjmsg);
    }

    //		第两条登录成功用例用户名错误的用例
    @Test
    @Order(2)
    void test_temp() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()=\"每日检查\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()=\"温度维护\"]")).click();
        // 第一 ，检查表达式，第二，加等待时间，第三，看有没有iframe
        Thread.sleep(3000);
        WebElement eleiframe = driver.findElement(By.xpath("//*[@id=\"tab_40288188606ec04d016071f3bce00e9\"]/iframe"));
        driver.switchTo().frame(eleiframe);
        driver.findElement(By.xpath("//*[text()=\"录入\"]")).click();
        driver.switchTo().defaultContent();
        WebElement eleFrame2 = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(eleFrame2);
        driver.findElement(By.name("wendu_dd")).sendKeys("二楼");
        driver.findElement(By.name("wendu_cjsj")).sendKeys("2023-5-8");
        driver.findElement(By.name("wendu_zhi")).sendKeys("-0");
        driver.findElement(By.name("wendu_bz")).sendKeys("我是来测试的");
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[@value=\"确定\"]")).click();

    }

//		第三条登录成功用例密码错误的用例.步骤一样,数据不同,重复案例,可以优化

}


