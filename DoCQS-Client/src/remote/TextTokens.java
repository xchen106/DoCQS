package remote;

import java.io.Serializable;
import java.util.ArrayList;

public class TextTokens implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4016350284761681005L;
	
	public ArrayList<String> tokens;
	public long doc;
	public String url;
	
	public String toString(){
		StringBuffer buf=new StringBuffer();
		buf.append("<d:"+doc+" text:{");
		for (int i=0;i<tokens.size();i++)
			buf.append(tokens.get(i)+" ");
		buf.append("}>");
		return buf.toString();
	}
}
