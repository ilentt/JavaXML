package ilentt.ilenlab.com.xml.sax;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

public class MainReadXML {

	public MainReadXML() {
		// constructor
	}
	
	public void ReadXML() {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			DefaultHandler handle = new SaxHandle();
			
			File file = new File("DepartmentData.xml");
			
			// Parser Unicode XML file
			InputStream inputStream = new FileInputStream(file);
			Reader reader = new InputStreamReader(inputStream,"UTF-8");
			InputSource is = new InputSource(reader);
			is.setEncoding("UTF-8");
			
			//saxParser.parse(file, handle);
			saxParser.parse(is, handle);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainReadXML m = new MainReadXML();
		m.ReadXML();
	}

}
