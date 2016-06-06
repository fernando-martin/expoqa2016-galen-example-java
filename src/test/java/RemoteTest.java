import com.galenframework.testng.GalenTestNgTestBase;
import domain.Device;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

import static domain.Credentials.KEY;
import static domain.Credentials.USERNAME;

public class RemoteTest extends GalenTestNgTestBase {

    private static final String URL = "http://" + USERNAME + ":" + KEY + "@ondemand.saucelabs.com:80/wd/hub";

    @Override
    public WebDriver createDriver(Object[] args) {
        try {
            return new RemoteWebDriver(new URL(URL), DesiredCapabilities.firefox());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
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

}
