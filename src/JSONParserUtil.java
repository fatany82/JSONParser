import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParserUtil {
	
	private static String readAll(Reader rd) throws IOException{
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

	
	 private static JSONArray readJSONFromUrl(String url) throws IOException, JSONException {
		    InputStream is = new URL(url).openStream();
		    try {
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONArray json = new JSONArray(jsonText);
		      return json;
		    } finally {
		      is.close();
		    }
		  }
	 
	 public static List parseJSONFromUrl(String url) throws IOException, JSONException{
		 JSONArray array = readJSONFromUrl(url);
		 return buildJSONObject(array);
	 }
	 
	 private static List buildJSONObject(JSONArray json) throws JSONException {
		List<HTMLElement> htmlElements = new LinkedList<HTMLElement>();
		for(int i=0; i<json.length(); i++){
			  JSONArray jsonArray = (JSONArray) json.get(i);
			  JSONObject jObject = jsonArray.getJSONObject(0);
			  HTMLElement htmlEl = new HTMLElement();
			  htmlEl.setViewType(jObject.get("viewType").toString());
			  htmlEl.setValue(jObject.get("value").toString());	  
			  htmlElements.add(htmlEl);
			  
		  } 
	
		return htmlElements;
		
	 }
}
