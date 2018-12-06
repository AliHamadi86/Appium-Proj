package core.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomValuesGenerator {

	private final String dateTimeFormatMinutes = "yyyy-MM-dd-HH-mm";
	private final String dateTimeFormatSeconds = "ddMMyy-HHmmss";
	private final String dateTimeFormatMiliseconds = "yyyy-MM-dd-HHmmssSSS";
	
	public String getDateTime(String dateTimeFormat) {

		Date dateTime = new Date();
		SimpleDateFormat simpleFormat = new SimpleDateFormat(dateTimeFormat);

		return simpleFormat.format(dateTime);
	}

	private String getRandomNumber(int size) {

		String number ="";
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			number = number + Integer.toString(random.nextInt(9));
		}

		return number;
	}
	
	public String getDateTimeMinutesAccuracy() {
		
		return getDateTime(dateTimeFormatMinutes);
	}

	public String getDateTimeSecondsAccuracy() {
		
		return getDateTime(dateTimeFormatSeconds);
	}
	
	public String getDateTimeMillisecondsAccuracy() {
		
		return getDateTime(dateTimeFormatMiliseconds);
	}

	public boolean getRandomBoolean() {

		Random random = new Random();
		return random.nextBoolean();
	}

	public int getRandomArrayIndexValue(int arraySize) {

		Random random = new Random();
		int number = random.nextInt(arraySize);
		return number;
	}

	public String getTodaysDate() {

		Date dateTime = new Date();
		SimpleDateFormat simpleFormat = new SimpleDateFormat("M/d/yyyy");

		return simpleFormat.format(dateTime);
	}

	public String getTSEmail() {

		return "testcase_" + this.getDateTime(dateTimeFormatSeconds) + "QA@sharklasers.com";
	}

	public String getTSFirstname() {

		return this.getDateTime(dateTimeFormatSeconds) + "firstname";
	}

	public String getTSLastname() {

		return this.getDateTime(dateTimeFormatSeconds) + "lastname";
	}

	public String getTSUsername() {

		return this.getDateTime(dateTimeFormatSeconds) + "username";
	}

	public String getPassword() {

		return this.getRandomNumber(7) + "C0ncep!";
	}

	public String getTSCustomName(String name) {

		return name + this.getDateTime(dateTimeFormatSeconds);
	}

	public String getTSAddress() {

		return "http://" + this.getDateTime(dateTimeFormatSeconds)
				+ "address/TestAPI/";
	}

	public String getBGPhoneNumber() {

		return "887"+this.getRandomNumber(6);
	}
	
	public String getALPhoneNumber() {

		return "692"+this.getRandomNumber(6);
	}
}
