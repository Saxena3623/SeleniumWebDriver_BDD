package org.quali.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.quali.automation.Pageobjects.ObjectFileReader;


public class PropFileHandler extends ObjectFileReader {
	static Properties properties= new Properties();
;
	
	static String filePath = "./src/test/resources/temp-data";
	String folderName;
	static File file;
	/**
	 * This method is used to read the value of the given property from the
	 * properties file.
	 * 
	 * @param property
	 *            : the property whose value is to be fetched.
	 * @return the value of the given property.
	 * @throws IOException 
	 */
	
	

	public static void createPropFile(File file)
	{
		
        try {
        	 file = new File(filePath);
			    System.out.println("Filepath is-------- "+file);

				if (file.createNewFile()) {
			    System.out.println(filePath+" File Created");
			}else 
				{System.out.println("File "+filePath+" already exists");
				file.delete();}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static String propFilePath(){
		filePath = "./src/test/resources/temp-data/" + ConfigPropertyReader.getTier() + File.separator
				+ ConfigPropertyReader.getTier()+ ".properties";
		
		
		
		return filePath;
	}
	
	
	/**
	 * This method is used to read the value of the given property from the properties file.
	 * 
	 * @param property : the property whose value is to be fetched.
	 * @return the value of the given property.
	 */

	public static String readProperty(String property) {
	
		filePath=propFilePath();
		InputStream inPropFile = null;
		try {
			inPropFile = new FileInputStream(filePath);
			properties.load(inPropFile);
			System.out.println("!!!Reading file path: " + filePath);
		} catch (IOException e) {
			createPropFile(file);
		}
		String value = properties.getProperty(property.replace("\\:", ":"));
		System.out.println("Reading property value: " + value);
		return value;
	}

	/**
	 * This method is used to write the value of the property in property file.
	 * 
	 * @param property
	 * @param value
	 * @throws IOException
	 */
	public static void writeToFile(String property, String value) {
		filePath=propFilePath();
		InputStream inPropFile;
		OutputStream outPropFile;
		try {
			File file=new File(filePath);
			if(file.exists()) {
			 inPropFile = new FileInputStream(filePath);
			properties.load(inPropFile);
			inPropFile.close();
			 outPropFile = new FileOutputStream(filePath);
			properties.setProperty(property, value);
			properties.store(outPropFile, null);
			outPropFile.close();
			System.out.println("Successfully updated/write for property:" + property + "\n write property value:" + value);
			}
			else {
				createPropFile(file);
				 inPropFile = new FileInputStream(filePath);
				properties.load(inPropFile);
				inPropFile.close();
				 outPropFile = new FileOutputStream(filePath);
				properties.setProperty(property, value);
				properties.store(outPropFile, null);
				outPropFile.close();
				System.out.println("Successfully updated/write for property:" + property + "\n write property value:" + value);
			}
		} catch (IOException e) {
			createPropFile(file);
			
		}
		
	}

}
