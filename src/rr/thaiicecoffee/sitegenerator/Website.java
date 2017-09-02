package rr.thaiicecoffee.sitegenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import rr.thaiicecoffee.sitegenerator.webpage.Webpage;

public class Website {
	
	static final String NAVBAR_START = "<div class='navbar'>";
	static final String NAVBAR_END = "</div>";
	static final String DEFAULT_OUTPUT_FOLDER = "site";
	
	static final String SIGNATURE = "\n<!--This page was generated by ThaiIceCoffee -->";
	
	private ArrayList<SiteFile> siteFiles;
	
	private String outputFolderName;
	
	public Website() {
		siteFiles = new ArrayList<SiteFile>();
		outputFolderName = DEFAULT_OUTPUT_FOLDER;
	}
	
	public SiteFile addSiteFile(SiteFile siteFile) {
		siteFiles.add(siteFile);
		return siteFile;
	}
	
	public ArrayList<SiteFile> getSiteFiles() {
		return siteFiles;
	}
	
	public void setOutputFolder(String folderName) {
		outputFolderName = folderName;
	}
	
	public void generateWebsite(String path) throws IOException {
		
		
		File outputFolder = new File(outputFolderName);
		outputFolder.mkdir();

		for (SiteFile siteFile : siteFiles) {
			File file;
			if (siteFile.getSubdirectory() != null) {
				//Create subdirectory if necessary
				File subdirectory = new File(outputFolder, siteFile.getSubdirectory());
				if (!subdirectory.exists()) {
					boolean canMakeSubdirectory = subdirectory.mkdirs();
					if (!canMakeSubdirectory)
					{
						throw new IllegalStateException("Failed to create directory: " + subdirectory.getName());
					}
				}
				file = new File(subdirectory,siteFile.getFileName());
			}
			else {
				file = new File(outputFolder,siteFile.getFileName());
			}
			
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			fw.write(siteFile.getPageSource());
			fw.close();
		}
	}
}
