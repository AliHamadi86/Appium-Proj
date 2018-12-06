package bl;

import core.automation.SeleniumDriverCore;
import core.reports.LogResults;
import core.utilities.RandomValuesGenerator;

public class Base {
	protected SeleniumDriverCore driver;
	protected RandomValuesGenerator generator;
	protected BaseElement element;
	protected LogResults log;

	public Base(SeleniumDriverCore driver,LogResults log) {
		this.driver = driver;
		this.element = new BaseElement(driver);
		this.log = log;
		this.generator = new RandomValuesGenerator();
	}

}
