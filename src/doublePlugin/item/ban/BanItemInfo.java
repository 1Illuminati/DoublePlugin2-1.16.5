package doublePlugin.item.ban;

import java.util.HashMap;

import org.bukkit.Material;

public class BanItemInfo {
	private static final String serStr = ";;";
	private static final String cross = "::";
	private final Material material;
	private HashMap<BanItemInfoEnum, Boolean> infoMap = new HashMap<>();
	
	public static BanItemInfo strToInfo(String str) {
		String[] args = str.split(serStr);
		BanItemInfo banItemInfo = new BanItemInfo(Material.valueOf(args[0]));
		
		for(int i = 1; i < args.length; i++) {
			String[] arg = args[i].split(cross);
			banItemInfo.setAllow(BanItemInfoEnum.valueOf(arg[0]), Boolean.valueOf(arg[1]));
		}
		
		return banItemInfo;
	}
	
	public BanItemInfo(Material material) {
		this.material = material;
	}
	
	public Material getMaterial() {
		return this.material;
	}
	
	public void setAllow(BanItemInfoEnum infoEnum, boolean value) {
		infoMap.put(infoEnum, value);
	}
	
	public boolean getAllow(BanItemInfoEnum infoEnum) {
		return infoMap.get(infoEnum);
	}
	
	public String InfoToStr() {
		StringBuilder strBuilder = new StringBuilder(this.getMaterial().name());
		for(BanItemInfoEnum infoEnum : infoMap.keySet()) {
			strBuilder.append(serStr).append(infoEnum.name()).append(cross).append(getAllow(infoEnum));
		}
		
		return strBuilder.toString();
	}
	
	public enum BanItemInfoEnum {
		BREAK(),
		PLACE(),
		CRAFT(),
		CLICK(),
		INV(),
		DROP();
	}
}
