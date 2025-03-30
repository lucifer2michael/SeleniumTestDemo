package com.huait.maven.pom.page;

import com.huait.maven.keyword.webKeyword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends webKeyword {

    public webKeyword kw;
    public String Url = "http://127.0.0. 1:8080/jeewms/";
    // 登录相关的内容都写在这个页面
    // 元素定位 FindBy是 Selenium WebDriver中的一个注解,用于定位Web元素。
    // @FindBy注解通常与Page Object模式一起使用，用于将页面元素和测试代码分离开来。
    @FindBy(xpath = "//*[=\name\'userName\"]")
    public WebElement user;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@name='randCode']")
    public WebElement verifyCode;

    @FindBy(xpath = "//button[@id='but_login']")
    public WebElement submitBtn;

    // WebKeyword对象保存为该类的实例变量kw。
    // 通过调用PageFactory.initElements()方法，
    // 将 WebDriver对象和页面对象(this)传递进去,
    public LoginPage(webKeyword keyword) {
        kw = keyword;
        PageFactory.initElements(kw.driver, this);
    }

    public void load() {
        kw.visitUrl(Url);
        kw.maxwindow();
    }

    // 登录方法写出来
    public String login() {
        user.clear();
        user.sendKeys("admin");
        password.clear();
        password.sendKeys("11g123");
        verifyCode.sendKeys("0000");
        submitBtn.click();
        String sjmsg = kw.getSingleText("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/a/span/small");
        System.out.println(sjmsg);
        return sjmsg;
    }

    public String login(String username, String pwd, String vcode) {
        user.clear();
        user.sendKeys(username);
        password.clear();
        password.sendKeys(pwd);
        verifyCode.sendKeys(vcode);
        submitBtn.click();
        String sjmsg = kw.getSingleText("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/a/span/small");
        System.out.println(sjmsg);
        return sjmsg;
    }

}
