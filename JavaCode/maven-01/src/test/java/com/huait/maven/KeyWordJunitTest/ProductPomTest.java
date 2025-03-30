package com.huait.maven.KeyWordJunitTest;

import com.huait.maven.keyword.webKeyword;
import com.huait.maven.pom.page.LoginPage;
import com.huait.maven.pom.page.ProductPage;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductPomTest {
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

//	@Test
//	@Order(2)
//	void test_addcustom() {
//		CustomPage4243 cp = new CustomPage4243(web);
//		String sjmsj=cp.custom_add();
//		Assertions.assertEquals("客戶添加成功1", sjmsj);
//	}

    @Test
    @Order(2)
    void test_addproduct() {
        ProductPage pp = new ProductPage(web);
        String sjmgj = pp.product_add("肥皂客户", "恒温", "加工食品", "100", "香香肥皂2", "盒");
        Assertions.assertEquals("商品添加成功", sjmgj);
    }

}

