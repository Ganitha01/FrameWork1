package smsGenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class consists of all the methods related to property file
 * @author ANITHA
 *
 */

public class PropertyUtility {
/**
 * this method is used to fetch the value for respected key from the preperty file
 * @param key
 * @return
 * @throws IOException
 */
	
	public String fetchDataFromPropertiesFile(String key) throws IOException
	{
		FileInputStream fileInputStream=new FileInputStream(IPathconstants.propertyFilepath);
		Properties properties=new Properties();
		properties.load(fileInputStream);
		String value=properties.getProperty(key);
		
		return value;
		
	}
}
