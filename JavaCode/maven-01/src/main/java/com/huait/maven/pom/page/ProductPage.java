package com.huait.maven.pom.page;


import com.huait.maven.keyword.webKeyword;
import com.huait.maven.utils.RandomUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public webKeyword kw;
    // 元素定位
    @FindBy(xpath = "//span[text()=\"基础资料\"]")
    public WebElement basicdata;

    @FindBy(xpath = "//a[text()=\"商品\"]")
    public WebElement product;

    @FindBy(xpath = "//span[text()='录入']")
    public WebElement enter;

    @FindBy(name = "gaoDanPin")
    public WebElement price;

    // 商品编码
    @FindBy(xpath = "//*[@id=\"shpBianMa\"]")
    public WebElement productcode;

    // 商品名称
    @FindBy(xpath = "/*[@id=\"shpMingCheng\"]")
    public WebElement productname;

    // 确定
    @FindBy(xpath = "//*[@value=\"确定\"]")
    public WebElement surebutton;

    @FindBy(xpath = "//*[@id=\"tab_8a7ba3345d93bb87015d93e6e8dd0023\"]/iframe")
    public WebElement iframe1;

    @FindBy(xpath = "//iframe")
    public WebElement iframe2;

    public ProductPage(webKeyword keyword) {
        kw = keyword;
        PageFactory.initElements(kw.driver, this);
    }

    // 测试流程
    public String product_add() {
        kw.driver.switchTo().defaultContent();
        basicdata.click();
        product.click();
        kw.driver.switchTo().frame(iframe1);
        enter.click();
        kw.driver.switchTo().defaultContent();
        kw.driver.switchTo().frame(iframe2);
        kw.select("//*[@name=\"suoShuKeHu\"]", "text", "肥皂客户");
        kw.select("//*[@name=\"cfWenCeng\"]", "text", "恒温");
        kw.select("//*[@name=\"chpShuXing\"]", "text", "加工食品");
        price.sendKeys("1000");
        int str = RandomUtil.randomInt(1, 10);
        productcode.sendKeys("spbm" + str);
        productname.sendKeys("香香肥皂");
        kw.select("/*[@name=\"shlDanWei\"]", "text", "盒");
        kw.driver.switchTo().defaultContent();
        surebutton.click();
        kw.driver.switchTo().defaultContent();
        kw.driver.switchTo().frame(iframe1);
        String text = kw.getSingleText("//*[@id=\"layui-layerl\"]/div[2]");
        return text;

    }

    public String product_add(String kehu, String wendu, String shuxing, String price1, String productname1,
                              String danwei) {
        basicdata.click();
        product.click();
        kw.driver.switchTo().frame(iframe1);
        enter.click();
        kw.driver.switchTo().defaultContent();
        kw.driver.switchTo().frame(iframe2);
        kw.select("//*[@name=\"suoShuKeHu\"]", "text", kehu);
        kw.select("//*[@name=\"cfWenCeng\"]", "text", wendu);
        kw.select("//*[@name=\"chpShuXing\"]", "text", shuxing);
        price.sendKeys(price1);
        //int str = RandomUtil.randomInt(1, 10);
        String str = RandomUtil.randomString(8);
        productcode.sendKeys("spbm" + str);
        productname.sendKeys(productname1);
        kw.select("/*[@name=\"shlDanWei\"]", "text", danwei);
        kw.driver.switchTo().defaultContent();
        surebutton.click();
        kw.driver.switchTo().defaultContent();
        kw.driver.switchTo().frame(iframe1);
        String text = kw.getSingleText("//*[@id=\"layui-layerl\"]/div[2]");
        return text;

    }
}

