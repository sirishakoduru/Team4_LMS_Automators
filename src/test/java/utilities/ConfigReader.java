package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop = null;
	private static String browserType = null;

	public static void setBrowserType(String browser) {
		browserType = browser;
	}
	
//	public static String getBrowserType() throws Throwable {
//		if (browserType != null)
//			return browserType;
//		else
//			throw new RuntimeException("browser not specified in the testng.xml");
//	}

	public static String getProperty(String key) {

		if (prop == null)
			intializeProperties();
		return prop.getProperty(key);

	}

	public static Properties intializeProperties() {

		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/Config/Config.properties");
			prop.load(fis);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
	//BaseURL
	public static String baseUrl()
    {    	
         String BaseURL=prop.getProperty("baseURL");
         if (BaseURL != null)
            return BaseURL;
         else
             throw new RuntimeException("Username not specified in the Config.properties file");
    }

	// UserName
    public static String userName()
    {    	
    	 String loginUserName=prop.getProperty("username");
    	 if (loginUserName != null)
		    return loginUserName;
    	 else
    		 throw new RuntimeException("Username not specified in the Config.properties file");
    }
    // Password
    public static String passWord()
    {    	
    	 String loginPassword=prop.getProperty("password");
    	 if (loginPassword != null)
		    return loginPassword;
    	 else
    		 throw new RuntimeException("Password not specified in the Config.properties file");
    }
    //Read program name from Config file
    public static String ProgramName() {
    	String ProgName=prop.getProperty("ProgramName");
    	if (ProgName != null)
            return ProgName;
        else
            throw new RuntimeException("Program name not specified in the Config.properties file");
    }
    //Read BatchNumber
    public static String BatchNum() {
    	String Number=prop.getProperty("BatchNumber");
    	if (Number != null)
            return Number;
        else
            throw new RuntimeException("Batch number not specified in the Config.properties file");
    }
    //Read BatchDescription
    public static String BatchDescription() {
    	String Desc=prop.getProperty("BatchDescription");
    	if (Desc != null)
            return Desc;
        else
            throw new RuntimeException("BatchDescription not specified in the Config.properties file");
    }
    //Read No_Of_Classes
    public static String No_Of_Classes() {
    	String No_Of_Classes=prop.getProperty("No_Of_Classes");
    	if (No_Of_Classes != null)
            return No_Of_Classes;
        else
            throw new RuntimeException("No_Of_Classes not specified in the Config.properties file");
    }
}
