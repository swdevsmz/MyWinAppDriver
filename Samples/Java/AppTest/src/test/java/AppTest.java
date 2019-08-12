//******************************************************************************
//
// Copyright (c) 2016 Microsoft Corporation. All rights reserved.
//
// This code is licensed under the MIT License (MIT).
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.
//
//******************************************************************************

import org.apache.commons.io.FileUtils;
import org.apache.regexp.recompile;
import org.junit.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class AppTest {

    private static WindowsDriver session = null;
    private static WebElement result = null;

    private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmsss");

    Robot robot;
    Rectangle bounds;

    @BeforeClass
    public static void setup() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
            capabilities.setCapability("app", "C:\\00_data\\90_repos\\csharp\\WindowsFormsApp1\\bin\\Debug\\WindowsFormsApp1.exe");
            session = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            session.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

//            CalculatorResult = CalculatorSession.findElementByAccessibilityId("CalculatorResults");
//            Assert.assertNotNull(CalculatorResult);
            result = session.findElementByAccessibilityId("textBox1");



        }catch(Exception e){
            e.printStackTrace();
        } finally {
        }
    }

    @Before
    public void Clear()
    {
//        CalculatorSession.findElementByAccessibilityId("clearButton").click();
//        Assert.assertEquals("0", _GetCalculatorResultText());
        initScreenCapture();
    }
//
//    @AfterClass
//    public static void TearDown()
//    {
//        CalculatorResult = null;
//        if (CalculatorSession != null) {
//            CalculatorSession.quit();
//        }
//        CalculatorSession = null;
//    }

    @Test
    public void Input() {

        try {
            session.findElementByAccessibilityId("textBox1").sendKeys("ABCD");

            File file =session.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("C:\\temp\\cap0.png"));

            //this.createScreenCapture();
            session.findElementByAccessibilityId("button1").click();
            file =session.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("C:\\temp\\cap1.png"));

            //this.createScreenCapture();
            session.findElementByAccessibilityId("textBox1").clear();
            //this.createScreenCapture();
            session.findElementByAccessibilityId("textBox1").sendKeys("よしかつ");
            file =session.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(file, new File("C:\\temp\\cap2.png"));
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        //this.createScreenCapture();
        //CalculatorSession.findElementByAccessibilityId("2").click();
    }

//    @Test
//    public void Addition()
//    {
//        CalculatorSession.findElementByAccessibilityId("num1Button").click();
//        CalculatorSession.findElementByAccessibilityId("plusButton").click();
//        CalculatorSession.findElementByAccessibilityId("num7Button").click();
//        CalculatorSession.findElementByAccessibilityId("equalButton").click();
//        Assert.assertEquals("8", _GetCalculatorResultText());
//    }
//
//    @Test
//    public void Combination()
//    {
//        CalculatorSession.findElementByName("Seven").click();
//        CalculatorSession.findElementByName("Multiply by").click();
//        CalculatorSession.findElementByName("Nine").click();
//        CalculatorSession.findElementByName("Plus").click();
//        CalculatorSession.findElementByName("One").click();
//        CalculatorSession.findElementByName("Equals").click();
//        CalculatorSession.findElementByName("Divide by").click();
//        CalculatorSession.findElementByName("Eight").click();
//        CalculatorSession.findElementByName("Equals").click();
//        Assert.assertEquals("8", _GetCalculatorResultText());
//    }
//
//    @Test
//    public void Division()
//    {
//        CalculatorSession.findElementByName("Eight").click();
//        CalculatorSession.findElementByName("Eight").click();
//        CalculatorSession.findElementByName("Divide by").click();
//        CalculatorSession.findElementByName("One").click();
//        CalculatorSession.findElementByName("One").click();
//        CalculatorSession.findElementByName("Equals").click();
//        Assert.assertEquals("8", _GetCalculatorResultText());
//    }
//
//    @Test
//    public void Multiplication()
//    {
//        CalculatorSession.findElementByName("Nine").click();
//        CalculatorSession.findElementByName("Multiply by").click();
//        CalculatorSession.findElementByName("Nine").click();
//        CalculatorSession.findElementByName("Equals").click();
//        Assert.assertEquals("81", _GetCalculatorResultText());
//    }
//
//    @Test
//    public void Subtraction()
//    {
//        CalculatorSession.findElementByName("Nine").click();
//        CalculatorSession.findElementByName("Minus").click();
//        CalculatorSession.findElementByName("One").click();
//        CalculatorSession.findElementByName("Equals").click();
//        Assert.assertEquals("8", _GetCalculatorResultText());
//    }

    protected String _GetCalculatorResultText()
    {
        // trim extra text and whitespace off of the display value
        return result.getText().replace("表示は", "").replace("です", "").trim();
    }

    protected void initScreenCapture() {
        try {
            robot = new Robot();
            bounds = new Rectangle(0, 0, 1920, 1000);
        }catch(AWTException ex){
            ex.printStackTrace();
        }

    }

    protected void createScreenCapture()
    {
        BufferedImage image = robot.createScreenCapture(bounds);

        // 以下、出力処理
        String dirName = "C:\\Users\\swdev\\OneDrive\\デスクトップ\\";
        String fileName = "test_" + format.format(new Date()) + ".jpg";
        try {
            ImageIO.write(image, "jpg", new File(dirName, fileName));
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
