package utills;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;



public class Property {
	
	public static String getPropertyValue(String filePath,String key)
	{
		String value="";
		Properties property=new Properties();
		try {
			property.load(new FileInputStream(filePath));
			value=property.getProperty(key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
	}
	
	
} 
