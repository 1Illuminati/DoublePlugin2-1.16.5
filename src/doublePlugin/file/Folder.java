package doublePlugin.file;

import java.io.File;

import doublePlugin.DoublePlugin;

public class Folder {

	private File makeFolder(String folderLoc) {
		File folder = new File("plugins/" + folderLoc);
		if(!folder.exists()) {
			folder.mkdir();
			DoublePlugin.sendLog(folderLoc + " mkdir");
		}

		return folder;
	}
	
	public File mkdir(String folderLoc) {
		File folder = new File("plugins/doublePlugin/" + folderLoc);
		if(!folder.exists()) {
			folder.mkdir();
			DoublePlugin.sendLog("doublePlugin/" + folderLoc + " mkdir");
		}

		return folder;
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
