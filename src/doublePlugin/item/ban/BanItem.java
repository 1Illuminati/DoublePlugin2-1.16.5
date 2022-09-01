package doublePlugin.item.ban;

import java.io.IOException;
import java.util.Collection;

import org.bukkit.Material;

import doublePlugin.DoublePlugin;
import doublePlugin.file.json.JsonReadWrite;
import doublePlugin.util.map.NotNullStrMap;

public class BanItem {
	private static NotNullStrMap<BanItemInfo> banItemMap = new NotNullStrMap<>();
	private static final String FILE_LOC = "properties/banitem";
	private static final JsonReadWrite json = new JsonReadWrite();
	
	public static void addBanItem(Material material) {
		banItemMap.put(material.toString(), new BanItemInfo(material));
	}
	
	public static void addBanItem(Material material, BanItemInfo info) {
		if(material != info.getMaterial()) {
			throw new IllegalArgumentException();
		}
		
		banItemMap.put(material.toString(), info);
	}
	
	public static boolean checkBanItem(Material material) {
		return banItemMap.containsKey(material.toString());
	}
	
	public static BanItemInfo getBanitemInfo(Material material) {
		return banItemMap.get(material.toString());
	}
	
	public static NotNullStrMap<BanItemInfo> getMap() {
		return banItemMap;
	}
	
	public static Collection<BanItemInfo> getList() {
		return banItemMap.values();
	}
	
	public static void clear() {
		banItemMap.clear();
	}
	
	public static void save() {
		try {
			NotNullStrMap<String> map = new NotNullStrMap<>();
			for(String key : banItemMap.keySet()) {
				map.put(key, banItemMap.get(key).InfoToStr());
			}
			
			json.jsonWrite(FILE_LOC, map);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void load() {
		try {
			NotNullStrMap<String> map = json.jsonRead(FILE_LOC, String.class);
			for(String key : map.keySet()) {
				banItemMap.put(key, BanItemInfo.strToInfo(map.get(key)));
			}
			
		} catch(IOException e) {
			DoublePlugin.sendLog("§4properties 파일이 null 상태 (BanItem - load : " + FILE_LOC + ")");
        	DoublePlugin.sendLog("§4플러그인을 처음 적용 시켰을때도 발생하는 에러입니다.");
		}
		
		banItemMap.setNormalValue(new BanItemInfo(Material.AIR));
	}
}


