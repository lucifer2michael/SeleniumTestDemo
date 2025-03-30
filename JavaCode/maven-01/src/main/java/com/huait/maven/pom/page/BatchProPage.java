package com.huait.maven.pom.page;

import com.huait.maven.keyword.webKeyword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BatchProPage {
    public webKeyword kw;

    @FindBy(xpath = "/span[text()=\"进货管理\"]")
    public WebElement procurement_manger;

    @FindBy(xpath = "/a[text()='批量收货']")
    public WebElement batchpro;

    @FindBy(xpath = "/*[@id=\"tab_4028b8815e5272f8015e527538d80001\"]/iframe")
    public WebElement iframe1;

    @FindBy(name = "goodsName")
    public WebElement productname;

    @FindBy(xpath = "//span[text()=\"查询\"]")
    public WebElement search_btn;

    @FindBy(xpath = "//*[text()=\"验收\"][1]")
    public WebElement yanshou_btn;

    @FindBy(xpath = "//iframe")
    public WebElement iframe2;

    @FindBy(xpath = "//*[@id=\"qmOkQuat\"]")
    public WebElement number;

    @FindBy(xpath = "//*[@id=\"tinId\"]")
    public WebElement tuopan;

    //添加储位 为什么要加储位 是因为 客户出货要关系到这个储位
    @FindBy(xpath = "//*[@id=\"binld\"]")
    public WebElement chuwei;

    @FindBy(xpath = "//*[@value=\"确定\"]")
    public WebElement surebutton;

    public BatchProPage(webKeyword keyword) {
        kw = keyword;

        PageFactory.initElements(kw.driver, this);
    }

    public String batch_add() {

        procurement_manger.click();
        batchpro.click();
        kw.driver.switchTo().frame(iframe1);
        productname.sendKeys("香香肥皂");
        search_btn.click();
        yanshou_btn.click();
        kw.driver.switchTo().defaultContent();
        kw.driver.switchTo().frame(iframe2);
        number.clear();
        number.sendKeys("100");
        chuwei.sendKeys("010301");
        tuopan.sendKeys("100");
        kw.driver.switchTo().defaultContent();
        surebutton.click();
        kw.driver.switchTo().frame(iframe1);
        String text = kw.getSingleText("//*[@id=\"layui-layerl\"]/div[2]");
        return text;
    }

    public String batch_add(String name, String number1, String chuwei1, String tuopan1) {

        procurement_manger.click();
        batchpro.click();
        kw.driver.switchTo().frame(iframe1);
        productname.sendKeys(name);
        search_btn.click();
        yanshou_btn.click();
        kw.driver.switchTo().defaultContent();
        kw.driver.switchTo().frame(iframe2);
        number.clear();
        number.sendKeys(number1);
        chuwei.sendKeys(chuwei1);
        tuopan.sendKeys(tuopan1);
        kw.driver.switchTo().defaultContent();
        surebutton.click();
        kw.driver.switchTo().frame(iframe1);
        String text = kw.getSingleText("//*[@id=\"layui-layerl\"]/div[2]");
        return text;
    }
}

