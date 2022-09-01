package doublePlugin.file;

import java.io.File;

import doublePlugin.DoublePlugin;

public class Folder {

	private void makeFolder(String folderLoc) {
		File folder = new File("plugins/" + folderLoc);
		if(!folder.exists()) {
			folder.mkdir();
			DoublePlugin.sendLog(folderLoc + " mkdir");
		}
	}
	
	public void folder(String folderLoc) {
		File folder = new File("plugins/doublePlugin/" + folderLoc);
		if(!folder.exists()) {
			folder.mkdir();
			DoublePlugin.sendLog("doublePlugin/" + folderLoc + " mkdir");
		}
	}

	public void setDoublePluginFolder() {
		this.makeFolder("doublePlugin");
		this.makeFolder("doublePlugin/info");
		this.makeFolder("doublePlugin/info/plugin");
		this.makeFolder("doublePlugin/info/player");
		this.makeFolder("doublePlugin/info/server");
		this.makeFolder("doublePlugin/properties");
	}
}
