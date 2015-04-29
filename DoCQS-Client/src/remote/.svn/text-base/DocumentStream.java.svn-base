package remote;

import java.io.IOException;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DocumentStream {
	
	long id;
	String url;
	public DocumentStream(long id, String url) {
		this.id=id;
		this.url=url;
	}
	/**
	 * @return A set of documents (not in order). Null if not data is available.
	 * @throws IOException 
	 */
	public TextTokens[] read() throws IOException {
		HashMap<String, String> params=new HashMap<String, String>();
		params.put("id", id+"");
		String res=SendPost.post(url, params, true);
		Gson gson=new GsonBuilder().serializeNulls().create();
		TextTokens[] newdata=new TextTokens[0];
		newdata=gson.fromJson(res, newdata.getClass());
		return newdata;		
	}
	/**
	 * @throws IOException 
	 */
	public void close() throws IOException {
		HashMap<String, String> params=new HashMap<String, String>();
		params.put("id", id+"");
		params.put("close", "true");
		SendPost.post(url, params, false);		
	}
}
