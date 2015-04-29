package remote;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PatternStream {
	
	long id;
	String url;
	public PatternStream(long id, String url) {
		this.id=id;
		this.url=url;
	}
	/**
	 * @return A set of data, null if no data is available.
	 * @throws IOException 
	 */
	public DataItem[][] read() throws IOException {
		HashMap<String, String> params=new HashMap<String, String>();
		params.put("id", id+"");
		String res=SendPost.post(url, params, true);
		Gson gson=new GsonBuilder().serializeNulls().create();
		DataItem[][] newdata=new DataItem[0][];
		newdata=gson.fromJson(res, newdata.getClass());
		return newdata;		
	}
	/**
	 * Close the pattern stream.
	 * @throws IOException 
	 */
	public void close() throws IOException {
		HashMap<String, String> params=new HashMap<String, String>();
		params.put("id", id+"");
		params.put("close", "true");
		SendPost.post(url, params, false);		
	}
}
