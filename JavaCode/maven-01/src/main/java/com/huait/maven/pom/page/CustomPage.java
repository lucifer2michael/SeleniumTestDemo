package com.huait.maven.pom.page;


import com.huait.maven.keyword.webKeyword;
import com.huait.maven.utils.PhoneNumberUtils;
import com.huait.maven.utils.RandomUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomPage {
    public webKeyword kw;

    // 元素定位
    @FindBy(xpath = "//*[text()=\"基础资料\"]")
    public WebElement basicdata;

    @FindBy(xpath = "//a[text()='客户']")
    public WebElement custom;

    @FindBy(xpath = "//span[text()='录入']")
    public WebElement enter;

    // 编码
    @FindBy(xpath = "//*[@id=\"kehuBianMa\"]")
    public WebElement code;

    // 中文全程
    @FindBy(xpath = "//*[@id=\"zhongWenQch\"]")
    public WebElement name;

    // 地址
    @FindBy(xpath = "//*[@id=\"diZhi\"]")
    public WebElement address;

    // 负责人
    @FindBy(id = "zhulianXiRen")
    public WebElement leader;

    // 手机
    @FindBy(xpath = "//*[@id=\"shouJi\"]")
    public WebElement mobile;

    // 确定
    @FindBy(xpath = "//*[@value=\"确定\"]")
    public WebElement surebutton;

    @FindBy(xpath = "//*[@id=\"tab_8a7ba3345d93bb87015d3e67ba4001f\"]/iframe")
    public WebElement iframe1;

    @FindBy(xpath = "//iframe")
    public WebElement iframe2;

    public CustomPage(webKeyword keyword) {
        kw = keyword;
        PageFactory.initElements(kw.driver, this);
    }

    // 添加方法
    public String custom_add() {
        basicdata.click();
        custom.click();
        kw.driver.switchTo().frame(iframe1);

        enter.click();
        // iframe跳出去
        kw.driver.switchTo().defaultContent();
        kw.driver.switchTo().frame(iframe2);
        kw.select("//*[@name=\"xingYeFenlei\"]", "value", "01");
        String str = RandomUtil.randomString(8);
        // String str=RandomUtil.randomString(8);
        // code.sendKeys("kehu001");
        code.sendKeys("kehu" + str);
        kw.select("//*[@name=\"keHuShuXing\"]", "text", "整体计重");
        kw.select("//*[@name=\"keHuZhuangTai\"]", "text", "按托盘");
        name.sendKeys("肥皂客户");
        address.sendKeys("长沙市天心区");
        leader.sendKeys("小小");
        String phonenumber = PhoneNumberUtils.getValidPhoneNumber();
        mobile.sendKeys(phonenumber);
        kw.driver.switchTo().defaultContent();
        surebutton.click();
        kw.driver.switchTo().defaultContent();
        kw.driver.switchTo().frame(iframe1);
        String text = kw.getSingleText("//*[@id=\"layui-layer6\"]/div[2]");
        return text;

    }

    public String custom_add(String kehu, String keHuShuXing, String keHuZhuangTai, String kehuname, String kehuaddress,
                             String leader1) {
        kw.driver.switchTo().defaultContent();
        basicdata.click();
        custom.click();
        kw.driver.switchTo().frame(iframe1);

        enter.click();
        // iframe跳出去
        kw.driver.switchTo().defaultContent();
        kw.driver.switchTo().frame(iframe2);
        kw.select("//*[@name=\"xingYeFenlei\"]", "text", kehu);
        String str = RandomUtil.randomString(8);
        // String str=RandomUtil43.randomString(8);
        // code.sendKeys("kehu001");
        code.sendKeys("kehu" + str);
        kw.select("//*[@name=\"keHuShuXing\"]", "text", keHuShuXing);
        kw.select("//*[@name=\"keHuZhuangTai\"]", "text", keHuZhuangTai);
        name.sendKeys(kehuname);
        address.sendKeys(kehuaddress);
        leader.sendKeys(leader1);
        String phonenumber = PhoneNumberUtils.getValidPhoneNumber();
        mobile.sendKeys(phonenumber);
        kw.driver.switchTo().defaultContent();
        surebutton.click();
        kw.driver.switchTo().defaultContent();
        kw.driver.switchTo().frame(iframe1);
        String text = kw.getSingleText("//*[@id=\"layui-layer6\"]/div[2]");
        return text;

    }
}

