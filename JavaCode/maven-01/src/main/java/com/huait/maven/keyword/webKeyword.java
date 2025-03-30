package com.huait.maven.keyword;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

//项目经常要做的操作 提前封装起来，要用的时候 直接使用
//点击在不断的点击
//不断的输入
//打开浏览器
//关闭浏览器
//访问网址
public class webKeyword {
    public WebDriver driver = null;

    public void openBrowser(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--remote-allow-origins=*");
                // 不同浏览器驱动版本
                driver = new ChromeDriver(option);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            case "ff":
                WebDriverManager.firefoxdriver().setup();
                ChromeOptions option1 = new ChromeOptions();
                option1.addArguments("-remote-allow-origins=*");
                // 不同浏览器驱动版本
                driver = new ChromeDriver(option1);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            case "edge":
                WebDriverManager.edgedriver().setup();
                ChromeOptions option2 = new ChromeOptions();
                option2.addArguments("-remote-allow-origins=*");
                // 不同浏览器驱动版本
                driver = new ChromeDriver(option2);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }

    // 封裝窗口最大化
    public void maxwindow() {
        try {
            driver.manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 访问网址
    public void visitUrl(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 关闭浏览器
    public void closeBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //	找到元素 by什么方式 Locator 具体的值
    public WebElement locator(String by, String Locator) {
        WebElement element = null;
        try {
            switch (by) {
                case "id":
                    element = driver.findElement(By.id(Locator));
                    break;
                case "name":
                    element = driver.findElement(By.name(Locator));
                    break;
                case "tag":
                    element = driver.findElement(By.tagName(Locator));
                    break;
                case "xpath":
                    element = driver.findElement(By.xpath(Locator));
                    break;
                case "css":
                    element = driver.findElement(By.cssSelector(Locator));
                    break;
                default:
                    element = driver.findElement(By.xpath(Locator));
            }
            return element;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 输入 找到元素 进行输入
    public void input(String by, String Locator, String content) {
        try {
            locator(by, Locator).sendKeys(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 点击 找到元素 进行点击
    public void click(String by, String Locator) {
        try {
            locator(by, Locator).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 等待
    public void halt(String seconds) {
        try {

            double time = Double.parseDouble(seconds);
            Thread.sleep((long) time * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 断言
    public String getSingleText(String xpath) {
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText();
            return text;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 常用的操作封装完全点11
    // 等待显示等待
    public void waitForelement(WebElement locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // js脚本
    public void runJs(String js) {
        try {
            JavascriptExecutor runner = (JavascriptExecutor) driver;
            runner.executeScript(js);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 窗口切换
    public void switchWindowByTitile(String expectedTitle) {
        try {
            // 先获取所有的句柄
            Set<String> windowHandles = driver.getWindowHandles();
            // 遍历所有的句柄，尝试切换窗口获取它的标题，如果标题和预期一致就是需要的窗口
            for (String windowHandle : windowHandles) {
                // 先切换到当前句柄所代表的窗口
                driver.switchTo().window(windowHandle);
                // 判断当前窗口的标题是否等于预期标题，如果相等，则break退出循环，不再遍历后续句柄
                if (driver.getTitle().equals(expectedTitle)) {
//            			break:
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 下拉框
    // xpath:下拉框元素的XPath表达式。
    // via：选项值的查找方式，可以是“ value”或“text”，分别表示根据选项值或文本内容来查找选项。
    // content：要选择的选项的值或文本内容。
    public void select(String xpath, String via, String content) {
        try {
            Select sel = new Select(driver.findElement(By.xpath(xpath)));
            // 获得所有文本
            List<WebElement> options = sel.getOptions();
            switch (via) {
                case "value":
                    sel.selectByValue(content);
                    break;
                case "text":
                    for (WebElement option : options) {
                        if (option.getText().contains(content)) {
                            sel.selectByVisibleText(option.getText());
                            break;
                        }
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


