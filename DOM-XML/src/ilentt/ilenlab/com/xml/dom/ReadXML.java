package ilentt.ilenlab.com.xml.dom;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class ReadXML {
	
	public ReadXML() {
		// constructor
	}
	
	public void runReadXML() {
		try {
			File file = new File("DepartmentData.xml");
			
			// Parser Unicode XML file
			InputStream inputStream = new FileInputStream(file);
			Reader reader = new InputStreamReader(inputStream,"UTF-8");
			InputSource is = new InputSource(reader);
			is.setEncoding("UTF-8");
						
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			//Document doc = dBuilder.parse(file);
			Document doc = dBuilder.parse(is);
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("employee");
			System.out.println("\n---");
			
			for(int i=0; i<nList.getLength(); i++) {
				Node node = nList.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("ID: " + element.getAttribute("id"));
					System.out.println("Emp No: " + element.getElementsByTagName("empNo").item(0).getTextContent());
					System.out.println("Emp Name: " + element.getElementsByTagName("empName").item(0).getTextContent());
					System.out.println("Hire Date: " + element.getElementsByTagName("hireDate").item(0).getTextContent());
					System.out.println("Salary: " + element.getElementsByTagName("salary").item(0).getTextContent());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadXML r = new ReadXML();
		r.runReadXML();
	}

}
