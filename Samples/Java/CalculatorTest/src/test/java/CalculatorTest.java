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

import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class CalculatorTest {

    private static WindowsDriver CalculatorSession = null;
    private static WebElement CalculatorResult = null;

    @BeforeClass
    public static void setup() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
            capabilities.setCapability("app", "C:\\00_data\\90_repos\\csharp\\WindowsFormsApp1\\bin\\Debug\\WindowsFormsApp1.exe");
            CalculatorSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            CalculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

//            CalculatorResult = CalculatorSession.findElementByAccessibilityId("CalculatorResults");
//            Assert.assertNotNull(CalculatorResult);
            CalculatorResult = CalculatorSession.findElementByAccessibilityId("textBox1");

        }catch(Exception e){
            e.printStackTrace();
        } finally {
        }
    }

//    @Before
//    public void Clear()
//    {
//        CalculatorSession.findElementByAccessibilityId("clearButton").click();
//        Assert.assertEquals("0", _GetCalculatorResultText());
//    }
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
        CalculatorSession.findElementByAccessibilityId("textBox1").sendKeys("ABCD");
        CalculatorSession.findElementByAccessibilityId("button1").click();
        CalculatorSession.findElementByAccessibilityId("textBox1").clear();
        CalculatorSession.findElementByAccessibilityId("textBox1").sendKeys("よしかつ");
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
        return CalculatorResult.getText().replace("表示は", "").replace("です", "").trim();
    }

}
