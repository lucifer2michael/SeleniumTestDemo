package com.huait.maven.JunitTest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginPramJunitTest {
    //优化LoginJunitTest26

    WebDriver driver = null;

    @BeforeEach
    void BeforeEach() {
        driver = new ChromeDriver();
        driver.get("http;//127.0.0.1;8080/jeewms/");
    }

    @AfterEach
    void AfterEach() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


    //	测试 正确的用户名 密码 验证码
    // 正确的用户名 错误的密码 验证码
    // 正确的用户名 错误的密码 错误的验证码
    @ParameterizedTest
    @CsvFileSource(resources = "/login.csv", numLinesToSkip = 1)
    void test_login2(String username, String password, String randcode, String expect) {

        driver.findElement(By.name("userName")).clear();

        driver.findElement(By.name("userName")).sendKeys("username");

        driver.findElement(By.name("password")).clear();

        driver.findElement(By.name("password")).sendKeys("randcode");

//		验证码一般在自动化不测试验证码 给个万能验证码 去掉验证码
        driver.findElement(By.name("randCode")).sendKeys("randcode");
        driver.findElement(By.id("but_login")).click();
        String sjmsg = driver.findElement(By.xpath("/*[@id=\"showErrMsg\"]")).getText();
        System.out.println(sjmsg);
        Assertions.assertEquals(expect, sjmsg);
    }

//		第三条登录成功用例密码错误的用例.步骤一样,数据不同,重复案例,可以优化


}
