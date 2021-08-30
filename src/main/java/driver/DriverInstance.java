package driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverInstance extends RemoteWebDriver {

    /** Constructor for {@link DriverInstance}*/
    public DriverInstance(URL remoteAddress, Capabilities capabilities) {
        super(remoteAddress, capabilities);
    }

    public DriverInstance(String remoteAddress, BrowserType browser) throws MalformedURLException {
        this(new URL(remoteAddress), generateCapabilities(browser));
    }

    private static Capabilities generateCapabilities(BrowserType browser){
        Capabilities capabilities = null;
        switch(browser) {
        case FIREFOX:
            capabilities = new FirefoxOptions();
            break;
        case CHROME:
        default:
            capabilities = new ChromeOptions();
        }
        return capabilities;
    }
}
