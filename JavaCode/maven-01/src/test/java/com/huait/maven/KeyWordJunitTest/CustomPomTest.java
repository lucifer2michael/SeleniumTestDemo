package com.huait.maven.KeyWordJunitTest;

import com.huait.maven.keyword.webKeyword;
import com.huait.maven.pom.page.CustomPage;
import com.huait.maven.pom.page.LoginPage;
import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomPomTest {
    static webKeyword web;
    static LoginPage lp;

    @BeforeAll
    static void BeforeAll() {
        web = new webKeyword();
        web.openBrowser("chrome");
        lp = new LoginPage(web);
    }

    @AfterAll
    static void AfterAll() {
        web.halt("3");
        web.closeBrowser();
    }

    @Test
    @Order(1)
    void test_login() {

        lp.load();
        String sjmsg = lp.login();
        Assertions.assertEquals("admin", sjmsg);
    }

    @Test
    @Order(2)
    void test_addcustom() {
        CustomPage cp = new CustomPage(web);
        String sjmsj = cp.custom_add();
        Assertions.assertEquals("客戶添加成功1", sjmsj);
    }

}

