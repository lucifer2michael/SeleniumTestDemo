package com.huait.maven.KeyWordJunitTest;


import com.huait.maven.keyword.webKeyword;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginwebPramJunitTest {
    //优化LoginJunitTest26

    webKeyword web;

    @BeforeEach
    void BeforeEach() {
        web = new webKeyword();
        web.openBrowser("chrome");
        web.visitUrl("http;//127.0.0.1;8080/jeewms/");
    }

    @AfterEach
    void AfterEach() {
        web.closeBrowser();
    }


    //		测试 正确的用户名 密码 验证码
//	    正确的用户名 错误的密码 验证码
//	    正确的用户名 错误的密码 错误的验证码
    @ParameterizedTest
    @CsvFileSource(resources = "/login2.csv", numLinesToSkip = 1)
    void test_login2(String username, String password, String randcode, String expect) {
        web.locator("name", "userName").clear();
        web.input("name", "userName", username);
        web.locator("name", "password").clear();
        web.input("name", "password", password);
        web.input("name", "randCode", randcode);
        web.click("id", "but_login");
        String sjmsg = web.getSingleText("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/a/span/small");
        System.out.println(sjmsg);
        Assertions.assertEquals(expect, sjmsg);
    }


}


