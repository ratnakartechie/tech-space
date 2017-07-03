package com.test.java;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class PhraseCounter {
	
	/*
	 * This method gets the Phrase Count in the file
	 */
	
	public Map<String,Integer> getPhraseCount(String fileName) throws FileNotFoundException,IOException
	{
		FileInputStream fis = null;
        DataInputStream dis = null;
        BufferedReader br = null;
        Map<String, Integer> phraseMap = new HashMap<String, Integer>();
    	//Read from the file
		fis=new FileInputStream(fileName);
		 dis = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(dis));
            String line = null;
            //Break it up into Tokens 
            while((line = br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(line, "|");
                while(st.hasMoreTokens()){
                    String tmp = st.nextToken().toLowerCase();
                    if(phraseMap.containsKey(tmp)){
                    	phraseMap.put(tmp, phraseMap.get(tmp)+1);
                    } else {
                    	phraseMap.put(tmp, 1);
                    }
                }
            }
          br.close();
        System.out.println(phraseMap);
        return phraseMap;
	}
	
	/*
	 * This method takes the phrase Map as argument, and then sorts the phrases, to come up with the count
	 */
	public List<Entry<String, Integer>> sortByValue(Map<String, Integer> phraseMap){
        
        Set<Entry<String, Integer>> set = phraseMap.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        return list;
    }
	
	public static void main(String[] args)
	{
		PhraseCounter pc=new PhraseCounter();	
		String fileName="C://PreTestSelections//nolan.txt";
		List<Entry<String, Integer>> phraseList;
		try {
			phraseList = pc.sortByValue(pc.getPhraseCount(fileName));
			for(Map.Entry<String, Integer> entry:phraseList){
	            System.out.println(entry.getKey()+" ==== "+entry.getValue());
	        }
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
	}

}
