package com.huait.maven.KeyWordJunitTest;

import com.huait.maven.keyword.webKeyword;
import com.huait.maven.pom.page.BatchProPage;
import com.huait.maven.pom.page.LoginPage;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomProPomTest {
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
        BatchProPage bp = new BatchProPage(web);
//		CustomProcurementPage cp = new CustomProcurementPage(web);
        // String sjmgj = cp.custompro_add();
        // String sjmgj = cp.custompro_add("肥皂客户","2023-05-10","香香肥皂");
        // String sjmgj = bp.batch_add();
        String sjmgj = bp.batch_add("香香肥皂", "100", "011301", "100");
        // Assertions.assertEquals("客户添加成功", sjmgj);
        // Assertions.assertEquals("进货通知添加成功", sjmgj);
        Assertions.assertEquals("批量收货添加成功", sjmgj);
    }

}

