import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class App {

	public static void createJSON() throws JSONException, IOException {
		JSONObject obj = new JSONObject();
		obj.put("name", "Alan");
		obj.put("id", "1");
		JSONArray classes = new JSONArray();
		classes.put(0, "COD");
		classes.put(1, "Java");
		obj.put("Subjects", classes);
		
		try(FileWriter file = new FileWriter("example.json")) {
			file.write(obj.toString());
		}
	}
	public static void readJSON() throws FileNotFoundException, IOException, JSONException {
		try(FileReader file = new FileReader("example.json")) {
			JSONTokener tok = new JSONTokener(file);
			JSONObject obj = new JSONObject(tok);
			System.out.println(obj.get("name"));
			System.out.println(obj.get("id"));
			JSONArray classes = (JSONArray) obj.getJSONArray("Subjects");
			for(int i=0; i < classes.length(); i++) {
				System.out.println(classes.get(i));
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, JSONException {
		// TODO Auto-generated method stub
		//call The read or write Functions
	}
	
}
