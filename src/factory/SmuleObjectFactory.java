package factory;

import org.openqa.selenium.support.events.WebDriverEventListener;

import core.automation.SeleniumDriverCore;
import core.reports.LogResults;

public class SmuleObjectFactory {
	public SeleniumDriverCore driver;
	public LogResults log;

	public SmuleObjectFactory(String driverConfig,WebDriverEventListener eventListener) {
		
		this.driver = new SeleniumDriverCore(driverConfig,eventListener);
		log = new LogResults(driver.eventDriver);
		
	}
}
