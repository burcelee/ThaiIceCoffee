package rr.thaiicecoffee.sitegenerator.webpage.stylesheet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ExternalStylesheet extends Stylesheet{

	private File externalFile;
	
	public ExternalStylesheet(String path) {
		externalFile = new File(path);
	}
	
	@Override
	public String getFileName() {
		return externalFile.getName();
	}

	@Override
	public byte[] getPageSource() {
		String pageSource = "";
		try {
			FileReader fr = new FileReader(externalFile);
			BufferedReader br = new BufferedReader(fr);
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				pageSource += line + "\n";
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return pageSource.getBytes();
	}

	@Override
	public String getPath() {
		return getSubdirectory() + "/" + getFileName();
	}
}
