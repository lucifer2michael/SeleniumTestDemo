package com.huait.maven.pom.page;

import com.huait.maven.keyword.webKeyword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomProcurementPage {
    public webKeyword kw;
    @FindBy(xpath = "//span[text()=\"进货管理\"]")
    public WebElement procurement_manger;

    @FindBy(xpath = "//a[text()='客户进货']")
    public WebElement custom;

    @FindBy(xpath = "//span[text()='录入']")
    public WebElement enter;

    @FindBy(xpath = "//*[@id=\"tab_402881885eab29a8015eaba50b460041\"]/iframe")
    public WebElement iframe1;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr[2]/td[2]/div/table/tbody/tr[3]/td[2]/div/iframe")
    public WebElement iframe2;

    @FindBy(xpath = "//*[@id=\"imData\"]")
    public WebElement arrival_time;

    @FindBy(xpath = "/*[@id=\"wmImNoticeIList[0].goodsCode\"]")
    public WebElement code;

    @FindBy(xpath = "/*[@name=\"goodsName\"]")
    public WebElement productname;

    @FindBy(xpath = "//*[text()=\"查询\"]")
    public WebElement searchbtn;

    @FindBy(xpath = "/*[@id=\"datagrid-row-r2-1-0\"]/td[2]/div/input")
    public WebElement product;

    @FindBy(xpath = "//*[@value=\"确定\"]")
    public WebElement surebutton;

    public CustomProcurementPage(webKeyword keyword) {
        kw = keyword;

        PageFactory.initElements(kw.driver, this);
    }

    public String custompro_add() {
        procurement_manger.click();
        custom.click();

        kw.driver.switchTo().frame(iframe1);
        enter.click();
        kw.driver.switchTo().defaultContent();

        kw.driver.switchTo().frame(iframe2);
        kw.select("//*[@id=\"formobj\"]/div[1]/div/div[1]/div[1]/div[2]/select", "text", "肥皂客户");
        arrival_time.sendKeys("2023-05-10");
        code.click();
        kw.driver.switchTo().defaultContent();
        kw.driver.switchTo().frame(iframe2);
        productname.sendKeys("香香肥皂");
        searchbtn.click();
        product.click();
        kw.driver.switchTo().defaultContent();
        surebutton.click();
        kw.runJs("window. scrollTo(0, document. body. scrollHeight);");
        kw.halt("3");
        surebutton.click();
        // 加个滚动
        kw.runJs(
                "window. scrollTo(0, (document. documentElement. scrollHeight- document. documentElement. clientHeight)*percentage/100)");
        // 回到iframe
        kw.driver.switchTo().frame(iframe1);
        // 断言
        String text = kw.getSingleText("//*[@id=\"lavui-layerI\"]/div[2]");
        return text;

    }

    public String custompro_add(String huozhu, String time, String name) {
        procurement_manger.click();
        custom.click();

        kw.driver.switchTo().frame(iframe1);
        enter.click();
        kw.driver.switchTo().defaultContent();

        kw.driver.switchTo().frame(iframe2);
        kw.select("//*[@id=\"formobj\"]/div[1]/div/div[1]/div[1]/div[2]/select", "text", huozhu);
        arrival_time.sendKeys(time);
        code.click();
        kw.driver.switchTo().defaultContent();
        kw.driver.switchTo().frame(iframe2);
        productname.sendKeys(name);
        searchbtn.click();
        product.click();
        kw.driver.switchTo().defaultContent();
        surebutton.click();
        kw.runJs("window. scrollTo(0, document. body. scrollHeight);");
        kw.halt("3");
        surebutton.click();
        // 加个滚动
        String js = "var percentage =50;" + "var scrollHeight = document. documentElement. scrollHeight;"
                + "var clientHeight= document. documentElement. clientHeight;"
                + "if(scrollHeight && clientHeight && percentage >=0&& percentage<=100){"
                + "window.scrollTo(0,(scrollHeight-clientHeight)*percentage /100);" +
                "}";
        kw.runJs(js);
//		kw.runJs(
//				"window. scrollTo(0, (document. documentElement. scrollHeight- document. documentElement. clientHeight)*percentage/100)");
        // 回到iframe
        kw.driver.switchTo().frame(iframe1);
        // 断言
        String text = kw.getSingleText("//*[@id=\"lavui-layerI\"]/div[2]");
        return text;

    }
}

