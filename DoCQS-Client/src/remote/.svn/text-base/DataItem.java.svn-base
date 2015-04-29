package remote;

import java.io.Serializable;


public class DataItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 928468506246207170L;
	public String schema;
	public int pos;
	public int len;
	public long doc;
	public String value;
	
	public DataItem(String schema, long doc, int pos, int len, String value){
		this.schema=schema;
		this.doc=doc;
		this.pos=pos;
		this.len=len;
		this.value=value;
	}
	
	public String toString(){
		return "<s:"+schema+" d:"+doc+" p:"+pos+" l:"+len+" v:"+value+">";
	}
}
