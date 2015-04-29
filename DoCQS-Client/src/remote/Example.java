package remote;

import java.rmi.Naming;
import java.util.ArrayList;


public class Example {
	
	public static void patternExample() throws Exception{
		System.out.println("xxx");
		QueryHandler handler=new QueryHandler("harrier01.cs.illinois.edu");
		PatternStream patternStream=handler.getPatternStream("[Titanic^a {Tom Cruise}^b]<20>",100,10000);
		System.out.println("xxx");
		DataItem[][] items;
		while ((items=patternStream.read())!=null){
			for (DataItem[] item:items){
				for (int j=0;j<item.length;j++)
					System.out.print(item[j]+" ");
				System.out.println();
			}
			//Add a time interval here to avoid over-frequent query. 
			Thread.sleep(1000);
		}
		patternStream.close();
		
	}
	
	public static void documentExample() throws Exception {
		System.out.println("xxx");
		QueryHandler handler=new QueryHandler("harrier01.cs.illinois.edu");
		
		ArrayList<Long> docList=new ArrayList<Long>();
		docList.add(1312021l);
//		docList.add(1000370749l);
		DocumentStream documentStream=handler.getDocumentStream(docList);
		
		System.out.println("xxx");
		
		TextTokens[] tokens;

		
		while ((tokens=documentStream.read())!=null){
			for (TextTokens token:tokens)
			{
				System.out.println(token.toString());
					for(int i=0;i<token.tokens.size();i++)
					{
						if(i>=400&&i<=430)
							System.out.println(token.doc+":"+token.tokens.get(i));
					}
			}
			Thread.sleep(200);
		}
		documentStream.close();
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		patternExample();
		documentExample();

	}

}
