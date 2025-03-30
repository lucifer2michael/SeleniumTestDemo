package com.huait.maven.KeyWordJunitTest;

import com.huait.maven.keyword.webKeyword;
import com.huait.maven.pom.page.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginPomTest {
    //原型-LoginTempJunitTest36.java
    webKeyword web;

    @BeforeEach
    void BeforeEach() {
        web = new webKeyword();
        web.openBrowser("chrome");

    }

    @AfterEach
    void AfterEach() {
        web.halt("3");
        web.closeBrowser();
    }

    @Test
    void test_login() {
        LoginPage lp = new LoginPage(web);
        lp.load();
        String sjmsg = lp.login();
        Assertions.assertEquals("admin", sjmsg);

//		web.locator("name","userName").clear();
//		web.input("name","userName","admin");
//		web.locator("name","password").clear();
//		web.input("name","password","11g123");
//		web.input("name","randCode","0000");
//		web.click("id","but_login");
//		String sjmsg =web.getSingleText("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/a/span/small");
//		System.out.println(sjmsg);
//		Assertions.assertEquals("admin1", sjmsg);
//		driver.findElement(By.name("userName")).clear();
//		driver.findElement(By.name("userName")).sendKeys("admin");
//		driver.findElement(By.name("password")).clear();
//		driver.findElement(By.name("password")).sendKeys("11g123");
//		验证码一般在自动化不测试验证码 给个万能验证码 去掉验证码
//		driver.findElement(By.name("randCode")).sendKeys("0000");
//		driver.findElement(By.id("but_login")).click();
//		取实际结果
//		String sjmsg = driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/a/span/small")).getText();
//		System.out.println(sjmsg);
//		Assertions.assertEquals("admin", sjmsg);
    }

}

