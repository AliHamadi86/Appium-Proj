package tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import core.automation.EventListener;
import core.utilities.RandomValuesGenerator;

public class BaseTest {
	protected RandomValuesGenerator names;
	private Properties config;

	protected String url;
	
	EventListener eventListener = new EventListener();

	@BeforeClass(alwaysRun = true)
	@Parameters({ "config" })

	public void testInitialize(@Optional("config/demoProdConfig") String appConfig) {
		try {
			this.names = new RandomValuesGenerator();
			this.config = new Properties();

			this.config.load(new FileInputStream(appConfig));
			this.url = this.config.getProperty("url");


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
