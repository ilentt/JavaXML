package ilentt.ilenlab.com.xml.sax;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

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
			saxParser.parse(file, handle);
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
