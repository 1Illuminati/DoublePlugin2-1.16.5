package doublePlugin.util.map;

public class ServerInfoMaps extends InfoMaps {
	private static final String FILE_LOC = "info/server";
	private static ServerInfoMaps serverInfoMaps;
	
	public static ServerInfoMaps getServerInfoMaps() {
		return serverInfoMaps;
	}
	
	public static void loadServerInfoMaps() {
		serverInfoMaps = new ServerInfoMaps();
	}
	
	public static void saveServerInfoMaps() {
		serverInfoMaps.saveInfoMaps();
	}
	
	protected ServerInfoMaps() {
		super(FILE_LOC);
	}
	
	
}
