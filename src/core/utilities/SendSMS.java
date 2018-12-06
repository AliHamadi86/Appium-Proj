package core.utilities;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class SendSMS {
	
	public SendSMS(String url,String username,String password) {
		this.url=url;
		this.username=username;
		this.password=password;
	}

	private static final String PARAM_USER = "username";
	private static final String PARAM_PASSWORD = "password";
	private static final String PARAM_TO_NUMBET = "msisdn";
	private static final String PARAM_TEXT = "message";
	private static final String DCA = "dca";
	private static final String CHARSET = "UTF-16BE";
	private static final String ALLOW_CONCAT = "allow_concat_text_sms";

	private String username;
	private String password;
	private String url;

	public void sendMessage(String number, String message) throws Exception{
		Map<String, String> params = new HashMap<>();

		String result = null;

		try {
			String hex = bytesToHex(message.getBytes(CHARSET));
			params.put(PARAM_TEXT, hex);
			params.put(PARAM_USER, username);
			params.put(PARAM_PASSWORD, password);
			params.put(PARAM_TO_NUMBET, number);
			params.put(ALLOW_CONCAT, "1");
			params.put(DCA, "16bit");

			result = httpPost(url, params);
			System.out.println(result);
			String[] errors = result.split("\\|");
			if (!errors[0].equals("0")) {
			}
			// remove new line character
			// return errors[2].replaceAll("\\\\n", "");
		} catch (Exception e) {
			throw e;
		}

	}

	public static String bytesToHex(byte[] bytes) {
		char[] hexArray = "0123456789ABCDEF".toCharArray();
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}

	public static String encode(Map<String, String> params) {
		StringBuilder result = new StringBuilder();
		if (params == null) {
			return "";
		}
		for (Map.Entry<String, String> param : params.entrySet()) {
			if (param.getKey() == null || param.getValue() == null) {
				continue;
			}

			// do it for all subsequent parameters
			if (result.length() > 0) {
				result.append("&");
			}
			result.append(param.getKey()).append("=").append(param.getValue());
		}

		return result.toString();
	}
	
	public static String httpPost(String urlS, Map<String, String> params)
	        throws Exception {
	        String postData = encode(params);
	        return httpPost(urlS, postData, null);
	    }

	public static String httpPost(String urls, String postData, Map<String, String> requestProps) throws Exception {

		InputStream in = null;
		HttpURLConnection connection = null;
		try {
			URL url = new URL(urls);
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			if (requestProps != null) {
				for (Map.Entry<String, String> prop : requestProps.entrySet()) {
					connection.setRequestProperty(prop.getKey(), prop.getValue());
				}
			}
			OutputStream out = connection.getOutputStream();
			out.write(postData.getBytes());
			out.flush();

			in = connection.getInputStream();

			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			while (true) {
				int rc = in.read(buf);
				if (rc <= 0)
					break;
				else
					bout.write(buf, 0, rc);
			}

			out.close();
			in.close();

			return bout.toString();
		} catch (IOException e) {
			throw new Exception("Cannot load URL: " + e.getMessage(), e);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (Exception e) {
				throw e;
			}
		}
	}
	
}