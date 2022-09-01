package doublePlugin.properties;

import java.io.IOException;

import doublePlugin.DoublePlugin;
import doublePlugin.file.json.JsonReadWrite;
import doublePlugin.util.map.NotNullStrMap;

public class ServerProperties {
	private static final NotNullStrMap<Boolean> properties = new NotNullStrMap<>();
	private static final JsonReadWrite json = new JsonReadWrite();
	private static final String FILE_LOC = "properties/properties";
	
	public static void loadProperties() {
		try {
			NotNullStrMap<Boolean> map = json.jsonRead(FILE_LOC, Boolean.class);
			for(String key : map.keySet()) {
				properties.put(key, map.get(key));
			}
		} catch(IOException e) {   
			DoublePlugin.sendLog("§4properties 파일이 null 상태 (ServerProperties - loadProperties : " + FILE_LOC + ")");
        	DoublePlugin.sendLog("§4플러그인을 처음 적용 시켰을때도 발생하는 에러입니다.");
		}
		
		properties.setNormalValue(true);
	}

	public static void saveProperties() {
		try {
			json.jsonWrite(FILE_LOC, properties);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void change(PropertiesEnum pro) {
		properties.put(pro.name(), !properties.get(pro.name()));
	}
	
	public static boolean get(PropertiesEnum pro) {
		return properties.get(pro.name());
	}
}
