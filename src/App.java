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
		// Creating A JSON object
		JSONObject obj = new JSONObject();
/*		Adding data to the json file based on a structure I've decided
		The structure is follows 
		{
			"name" : "Alan",
			"id" : "1",
			"Subjects" {
				"COD",
				"Java"
			}
		}*/
		obj.put("name", "Alan");
		obj.put("id", "1");
		// JSON array to add al my classes
		JSONArray classes = new JSONArray();
		classes.put(0, "COD");
		classes.put(1, "Java");
		// Adding the  array to the object itself
		obj.put("Subjects", classes);
		// Writing the object into my json file
		try(FileWriter file = new FileWriter("example.json")) {
			file.write(obj.toString());
		}
	}
	public static void readJSON() throws FileNotFoundException, IOException, JSONException {
		// Reading the json file creating a stream for it
		try(FileReader file = new FileReader("example.json")) {
			// Parsing the json file into an object
			JSONTokener tok = new JSONTokener(file);
			JSONObject obj = new JSONObject(tok);
			// Displaying teh data
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
