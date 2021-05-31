package org.quali.automation.Pageobjects;

import static org.quali.automation.utils.ConfigPropertyReader.getProperty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.quali.automation.utils.ConfigPropertyReader;

/**
 * This class reads the PageObjectRepository text files. Uses buffer reader.
 *
 * @author qait
 *
 */
public class ObjectFileReader {

	static String tier;
	static String platform;

	static String filepath = "src/test/resources/PageObjectRepository/";
	

	public static String[] getELementFromFile(String pageName,
			String elementName) {
		tier=ConfigPropertyReader.getTier();

		try {
			FileReader specFile = new FileReader(filepath+File.separator+ tier +File.separator+ pageName + ".spec");

			return getElement(specFile, elementName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getPageTitleFromFile(String pageName) {
		setTier();
		BufferedReader br = null;
		String returnElement = "";
		try {
			br = new BufferedReader(new FileReader(filepath + tier + pageName
					+ ".spec"));
			String line = br.readLine();

			while (line != null && !line.startsWith("========")) {
				String titleId = line.split(":", 3)[0];
				if (titleId.equalsIgnoreCase("pagetitle")
						|| titleId.equalsIgnoreCase("title")
						|| titleId.equalsIgnoreCase("page title")) {
					returnElement = line;
					break;
				}
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(returnElement);
		return returnElement.split(":", 2)[1].trim();
	}

	private static String[] getElement(FileReader specFile, String elementName)
            throws Exception {
       
        String[] elementLineSplit;
        ArrayList<String> elementLines = getSpecSection(specFile);
       
        for (String elementLine : elementLines) {
            elementLineSplit = elementLine.split(" ");
           
            if (elementLineSplit[0].trim().equalsIgnoreCase(elementName)) {
                return elementLine.split(" ", 3);
            } else {
                continue;
            }
        }
        throw new Exception();
    }
	

	private static ArrayList<String> getSpecSection(FileReader specfile) {
		String readBuff = null;
		ArrayList<String> elementLines = new ArrayList<String>();

		try {
			BufferedReader buff = new BufferedReader(specfile);
			try {
				boolean flag = false;
				readBuff = buff.readLine();
				while ((readBuff = buff.readLine()) != null) {
					if (readBuff.startsWith("========")) {
						flag = !flag;
					}
					if (flag) {
						elementLines.add(readBuff.trim().replaceAll("[ \t]+",
								" "));
					}
					if (!elementLines.isEmpty() && !flag) {
						break;
					}
				}
			} finally {
				buff.close();
				if (elementLines.get(0).startsWith("========")) {
					elementLines.remove(0);
				}
			}
		} catch (FileNotFoundException e) {
			System.out
					.println("Spec File not found at location :- " + filepath);
		} catch (IOException e) {
			System.out.println("exceptional case");
		}
		return elementLines;
	}

	private static void setTier() {
		switch (Tiers.valueOf(getProperty("Config.properties", "tier"))) {
		case QA:
		case qa:
		case Qa:
			tier = "qa/";
			break;
		case production:
		case PROD:
		case PRODUCTION:
		case Production:
		case prod:
			tier = "prod/";
			break;
		case STAGE:
		case Stage:
		case stage:
		case staging:
		case STAGING:
			tier = "stage/";
			break;
		}
	}
}
