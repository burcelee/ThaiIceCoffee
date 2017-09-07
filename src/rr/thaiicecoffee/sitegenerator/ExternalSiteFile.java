package rr.thaiicecoffee.sitegenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

public class ExternalSiteFile implements SiteFile {

	File externalFile;
	String subdirectory;
	
	public ExternalSiteFile(String filePath, String subdirectory) {
		externalFile = new File(filePath);
		this.subdirectory = subdirectory;
	}
	
	@Override
	public String getFileName() {
		return externalFile.getName();
	}

	@Override
	public String getSubdirectory() {
		return subdirectory;
	}

	@Override
	public byte[] getPageSource() {
		byte[] source = new byte[(int)externalFile.length()];
		try {
			InputStream is = new FileInputStream(externalFile);
			
			is.read(source);
			is.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return source;
	}

	@Override
	public String getPath() {
		if (getSubdirectory() == null)
			return getFileName();
		return getSubdirectory() + "/" + getFileName();
	}

}
