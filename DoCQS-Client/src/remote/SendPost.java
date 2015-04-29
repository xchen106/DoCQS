package remote;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;

public class SendPost {
	public static String post(String url, HashMap<String, String> params, boolean withRes) throws IOException{
		URLConnection conn=new URL(url).openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		DataOutputStream output=new DataOutputStream(conn.getOutputStream());
		StringBuffer content=new StringBuffer();
		for (String key:params.keySet()){
			if (content.length()!=0) content.append("&");
			content.append(key+"="+URLEncoder.encode(params.get(key), "UTF-8"));
		}
		output.writeBytes(content.toString());
		output.flush();
		output.close();
		
		if (!withRes) return null;
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(new GZIPInputStream(conn.getInputStream())));
		String line;
		StringBuffer c=new StringBuffer();
		while ((line=reader.readLine())!=null){
			c.append(line);
		}
		reader.close();
		return c.toString();
	}
}
