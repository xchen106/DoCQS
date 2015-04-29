package remote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class QueryHandler {
	
	String server;
	
	public QueryHandler(String server){
		this.server=server;
		
	}
	
	/**
	 * @param pattern DoCQS Pattern, e.g., {university of illinois}, "[{tokyo tower} #number]<40>"
	 * @param count The number of occurrences that would be returned.
	 * @param timeout Pattern stream will be closed, after the given time span (in milliseconds);
	 * @return A pattern stream for reading the data.
	 * @throws IOException 
	 */
	public PatternStream getPatternStream(String pattern, int count, int timeout) throws IOException {
		HashMap<String, String> params=new HashMap<String, String>();
		params.put("query", pattern);
		params.put("count", count+"");
		params.put("timeout", timeout+"");
		String url="http://"+server+":8080/DoCQS-Server/PatternServlet";
		String res=SendPost.post(url, params, true);
		if (res!=null){
			try {
				long id=Long.parseLong(res);
				return new PatternStream(id, url);
			} catch (NumberFormatException e) {
				return null;
			}
		}
		return null;		
	}
	/**
	 * @param docList A list of document ids.
	 * @param timeout Document stream will be closed, after the given time span (in milliseconds);
	 * @return A document stream for reading the data.
	 * @throws IOException 
	 */
	public DocumentStream getDocumentStream(ArrayList<Long> docList, int timeout) throws IOException {
		HashMap<String, String> params=new HashMap<String, String>();
		StringBuffer buf=new StringBuffer();
		for (int i=0;i<docList.size();i++){
			if (i>0) buf.append(",");
			buf.append(docList.get(i));
		}
		params.put("doc", buf.toString());
		params.put("timeout", timeout+"");
		String url="http://"+server+":8080/DoCQS-Server/DocumentServlet";
		String res=SendPost.post(url, params, true);
		if (res!=null){
			try {
				long id=Long.parseLong(res);
				return new DocumentStream(id, url);
			} catch (NumberFormatException e) {
				return null;
			}
		}
		return null;	
	}
	/**
	 * @param pattern as above
	 * @return getPatternStream(pattern, default_count, default_timeout);
	 * @throws IOException 
	 */
	public PatternStream getPatternStream(String pattern) throws IOException {
		return getPatternStream(pattern, -1, -1);
	}
	
	/**
	 * @param docList as above
	 * @return getDocumentStream(docList, default_timeout)
	 * @throws IOException 
	 */
	public DocumentStream getDocumentStream(ArrayList<Long> docList) throws IOException {
		return getDocumentStream(docList, -1);
	}
}
