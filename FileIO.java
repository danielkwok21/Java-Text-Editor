package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Formatter;
import java.util.Scanner;

public class FileIO{
	private Formatter x;
	private String fileDIR;
	private String fileName = "sample.txt";
	
	
	public FileIO(String fileDIR) {
		this.fileDIR = fileDIR;
	}
	
	public boolean save(String content) {
    	try {  

    		FileOutputStream fn = new FileOutputStream(fileName);
			OutputStreamWriter out = new OutputStreamWriter(fn);
			BufferedWriter bufferedWriter = new BufferedWriter(out);
        	  
		    bufferedWriter.write(content);
		    
		    bufferedWriter.close();
		    return true;
		     
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 return false;
    }
	
	
	public String read(){
		
		String nextChar;
        String line = "";
  	  	StringBuffer sb = new StringBuffer();
        
        try {

        	InputStream is = new FileInputStream(fileName);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			while((nextChar = br.readLine()) != null) {
            	line = line.concat(nextChar);
            } 
			
			br.close();
			return line;
        	
        	
        	/*
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader br = new BufferedReader(fileReader);
        	
        	while((nextChar = br.readLine()) != null) {
            	line = line.concat(nextChar);
            }   
        	br.close();
        	
        	*/
        	/*
        	InputStream is = getClass().getResourceAsStream(fileName);
        	InputStreamReader isr = new InputStreamReader(is);
        	BufferedReader br = new BufferedReader(isr);
        	while ((line = br.readLine()) != null) 
        	{
        		sb.append(line);
        	}
        	br.close();
        	isr.close();
        	is.close();
        	*/
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return sb.toString();
	}
	
	public Formatter openFile() {
		try {
			x = new Formatter(fileName);
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
		return x;
	}
}

