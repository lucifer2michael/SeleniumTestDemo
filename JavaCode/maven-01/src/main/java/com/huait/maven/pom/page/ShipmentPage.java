package com.huait.maven.pom.page;

import com.huait.maven.keyword.webKeyword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShipmentPage {
    public webKeyword kw;
    @FindBy(xpath = "//span[text()=\"出货管理\"]")
    public WebElement shipment_manger;

    @FindBy(xpath = "//a[text()='客户出货']")
    public WebElement coustom_shipment;

    @FindBy(xpath = "//*[@id=\"tab_402881885eab29a8015eaba58ebe0043\"]/iframe")
    public WebElement iframe1;

    @FindBy(xpath = "/span[text()='录入']")
    public WebElement enter;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr[2]/td[2]/div/table/tbody/tr[2]/td [2]/div/iframe")
    public WebElement iframe2;

    @FindBy(xpath = "//input [ename=\"delvData\"]")
    public WebElement delivery_time;

    @FindBy(xpath = "//*[@id=\"wmOmNoticelList[0]. goodsId\"]")
    public WebElement shipment_pro;

    @FindBy(xpath = "/*[@name=\"goodsName\"]")
    public WebElement productname;

    @FindBy(xpath = "//*[text()=\"查询\"]")
    public WebElement searchbtn;

    @FindBy(xpath = "//*[@id=\"datagrid-row-r2-1-0\"]/td[2]/div/input")
    public WebElement product;

    @FindBy(xpath = "//*[@id=\"add_wmOmNoticeI_table\"]/tr/td[3]/input")
    public WebElement shipment_number;

    @FindBy(xpath = "//*[evalue=\"确定\"]")
    public WebElement surebutton;

    public ShipmentPage(webKeyword keyword) {
        kw = keyword;

        PageFactory.initElements(kw.driver, this);
    }

    public String shipment_add() {
        shipment_manger.click();
        coustom_shipment.click();
        kw.driver.switchTo().frame(iframe1);
        enter.click();
        kw.driver.switchTo().defaultContent();
        kw.driver.switchTo().frame(iframe2);
        kw.select("//*[@name=\"cusCode\"]", "text", "桃桃");
        delivery_time.sendKeys("2023-05-10");
        shipment_number.sendKeys("100");
        shipment_pro.click();
        kw.driver.switchTo().defaultContent();
        kw.driver.switchTo().frame(iframe2);
        productname.sendKeys("淘淘玩具");
        searchbtn.click();
        product.click();
        kw.driver.switchTo().defaultContent();
        surebutton.click();
        kw.runJs("window. scrollTo (0, document. body. scrollHeight); ");
        surebutton.click();
        // 跳转iframe
        kw.driver.switchTo().defaultContent();
        kw.driver.switchTo().frame(iframe1);
        // 滚动顶部
        kw.runJs("window.scrollTo(0,0);");
        // 断言
        String text = kw.getSingleText("//*[@id=\"layui-layerI\"]/div[2]");
        return text;
    }

    public String shipment_add(String huozhu, String time1, String number, String proname) {
        shipment_manger.click();
        coustom_shipment.click();
        kw.driver.switchTo().frame(iframe1);
        enter.click();
        kw.driver.switchTo().defaultContent();
        kw.driver.switchTo().frame(iframe2);
        kw.select("//*[@name=\"cusCode\"]", "text", huozhu);
        delivery_time.sendKeys(time1);
        shipment_number.sendKeys(number);
        shipment_pro.click();
        kw.driver.switchTo().defaultContent();
        kw.driver.switchTo().frame(iframe2);
        productname.sendKeys(proname);
        searchbtn.click();
        product.click();
        kw.driver.switchTo().defaultContent();
        surebutton.click();
        kw.runJs("window. scrollTo (0, document. body. scrollHeight); ");
        surebutton.click();
        // 跳转iframe
        kw.driver.switchTo().defaultContent();
        kw.driver.switchTo().frame(iframe1);
        // 滚动顶部
        kw.runJs("window.scrollTo(0,0);");
        // 断言
        String text = kw.getSingleText("//*[@id=\"layui-layerI\"]/div[2]");
        return text;
    }
}

