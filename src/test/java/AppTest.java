import com.galenframework.testng.GalenTestNgTestBase;
import domain.Device;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Collections;

public class AppTest extends GalenTestNgTestBase {

    @Override
    public WebDriver createDriver(Object[] args) {
        return new FirefoxDriver(DesiredCapabilities.firefox());
    }

    @DataProvider(name = "devices")
    public Object[][] devices() {
        return new Object[][]{
                {new Device("mobile", new Dimension(480, 800), Collections
                        .singletonList("mobile"))},
                {new Device("tablet", new Dimension(1024, 768), Collections
                        .singletonList("tablet"))},
                {new Device("desktop", new Dimension(1280, 1024), Collections
                        .singletonList("desktop"))}
        };
    }

    @Test(dataProvider = "devices")
    public void exampleTest1(Device device) throws IOException {
        String url = "http://www.expoqa.com/expoqa16/es-schedule-day1" +
                ".html#schedule-day1";

        load(url, device.getSize().getWidth(), device.getSize().getHeight());
        checkLayout("src/main/java/resources/example1.gspec", device.getTags());
    }

    @Test(dataProvider = "devices")
    public void exampleTest2(Device device) throws IOException {
        String url = "http://2016.typographics.com/";

        load(url, device.getSize().getWidth(), device.getSize().getHeight());
        checkLayout("src/main/java/resources/example2.gspec", device.getTags());
    }

    @Test(dataProvider = "devices")
    public void exampleTest3(Device device) throws IOException {
        String url = "http://www.expoqa.com/sessions.php";

        load(url, device.getSize().getWidth(), device.getSize().getHeight());
        checkLayout("src/main/java/resources/example3.gspec", device.getTags());
    }

    @Test(dataProvider = "devices")
    public void exampleTest4(Device device) throws IOException {
        String url = "http://www.expoqa.com/sessions.php";

        load(url, device.getSize().getWidth(), device.getSize().getHeight());
        checkLayout("src/main/java/resources/example4.gspec", device.getTags());
    }

    @Test(dataProvider = "devices")
    public void exampleTest5(Device device) throws IOException {
        String url = "http://www.expoqa.com/sessions.php";

        load(url, device.getSize().getWidth(), device.getSize().getHeight());
        checkLayout("src/main/java/resources/example5.gspec", device.getTags());
    }

}
