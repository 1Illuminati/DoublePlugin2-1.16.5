package doublePlugin.file.json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import doublePlugin.util.map.NotNullStrMap;

public class JsonReadWrite {
	
    @SuppressWarnings("unchecked")
	public <T> NotNullStrMap<T> jsonRead(String fileLoc, Class<T> clazz) throws IOException{
        JSONParser parser = new JSONParser();
        String loc = "plugins/doublePlugin/" + fileLoc + ".json";
        Reader reader = new FileReader(loc);
        
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(reader);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
		if(clazz == Integer.class) {
            JSONObject finalJsonObject = jsonObject;
            Objects.requireNonNull(jsonObject).replaceAll((k, v) -> Integer.valueOf(finalJsonObject.get(k).toString()));
		}
        
        return NotNullStrMap.getMap(Objects.requireNonNull(jsonObject));
    }
   
    
    public <T> void jsonWrite(String fileLoc, NotNullStrMap<T> map) throws IOException {
    	JSONObject obj = new JSONObject(map);
    	String jsonStr = obj.toJSONString();
    	String loc = "plugins/doublePlugin/" + fileLoc + ".json";
    	File file = new File(loc);

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(jsonStr);
        writer.close();
    }
}
