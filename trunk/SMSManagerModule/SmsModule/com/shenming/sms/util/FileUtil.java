/**
 * 
 */
package com.shenming.sms.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * @author justin
 *
 */
public class FileUtil {
	private static final Log log = LogFactory.getLog(FileUtil.class);
	
	private static FileUtil theFileUtil = null;
	
	/**
	 * 
	 */
	private FileUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static synchronized FileUtil getInstance() {
		if ( theFileUtil == null ) {
			theFileUtil = new FileUtil();
		}
		
		return theFileUtil;
	}
	
	/*
	public String getFileContent(File pFile) {
		StringBuffer stringBuffer = new StringBuffer();
		InputStream inputStream = null;
		
		try {
			if ( pFile != null ) {
				inputStream =  new FileInputStream(pFile);
				InputStreamReader inputReader = new InputStreamReader(inputStream);
				BufferedReader bufferReader = new BufferedReader(inputReader);
				
				String lineString = "";
				while ( lineString != null ) {
					lineString = bufferReader.readLine();
					
					if ( lineString != null ) {
						stringBuffer.append(lineString+ "\r\n");
					}
				}
				bufferReader.close();
				inputReader.close();
			}
		}
		catch (Exception ex_open) {
			log.warn("Open file has exception! "+ ex_open.toString());
		}
		finally {
			if ( inputStream != null ) {
				try {
					inputStream.close();
				}
				catch (Exception ex_close){
				}
			}
				
		}
		
		return stringBuffer.toString();
	}
	*/
	
	public String getFileContent(File pFile) {
		String fileContent = null;
		
		try {
			if ( pFile != null ) {
				InputStream inputStream =  new FileInputStream(pFile);
				
				fileContent = getFileContent(inputStream);
			}
		}
		catch (Exception ex_open) {
			log.warn("Open file has exception! "+ ex_open.toString());
		}
		
		return fileContent;
	}
	
	public String getFileContent(InputStream pInputStream) {
		StringBuffer stringBuffer = new StringBuffer();
		
		try {
			if ( pInputStream != null ) {
				InputStreamReader inputReader = new InputStreamReader(pInputStream);
				BufferedReader bufferReader = new BufferedReader(inputReader);
				
				String lineString = "";
				while ( lineString != null ) {
					lineString = bufferReader.readLine();
					
					if ( lineString != null ) {
						stringBuffer.append(lineString+ "\r\n");
					}
				}
				bufferReader.close();
				inputReader.close();
			}
		}
		catch (Exception ex_open) {
			log.warn("Open file has exception! "+ ex_open.toString());
		}
		finally {
			if ( pInputStream != null ) {
				try {
					pInputStream.close();
				}
				catch (Exception ex_close){
				}
			}
				
		}
		
		return stringBuffer.toString();
	}
	
	public InputStream getResourceFromJar(File pJarFile, String pResourceName) throws IOException {
		//URL urlFilePath = this.getClass().getResource("/");
		InputStream inputStream = null;
		
		JarFile jarFile = new JarFile(pJarFile);
	    Enumeration enumJar = jarFile.entries();
	    
	    while (enumJar.hasMoreElements()) {
	        JarEntry entry = (JarEntry)enumJar.nextElement();
	        
	        if ( entry.isDirectory() ) continue;
	        
	        String fileName = entry.getName();
	        log.info(">>>>>>>>>>>>>File Path:"+ fileName);
	        if ( fileName != null && fileName.indexOf("/") > 0 ) {
	        	int lastSlash = fileName.lastIndexOf("/") + 1;
	        	fileName = fileName.substring(lastSlash);
	        	//System.out.println("File Name:"+ fileName);
	        }
	        
	        if ( fileName.equals(pResourceName) ) {
	            inputStream = jarFile.getInputStream(entry);
	            
	            if (inputStream == null) {
	                throw new IOException("Unable to load resource " + pResourceName + " using " + this);
	            }
	            else {
	            	break;
	            }
	        }
	    }

	            
		return inputStream;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Test
		/*
		File testFile = new File("D:/Test/java/File/application_reapply.html");
		FileUtil fileInstance = FileUtil.getInstance();
		System.out.println(fileInstance.getFileContent(testFile));
		
		File jarFile = new File("D:/Test/java/File/alchip-bpm-process.jar");
		
		try {
			InputStream input = fileInstance.getResourceFromJar(jarFile, "application_reapply.html");
			System.out.println(fileInstance.getFileContent(input));
		}
		catch (Exception ex){
			
		}
		*/

	}

}
