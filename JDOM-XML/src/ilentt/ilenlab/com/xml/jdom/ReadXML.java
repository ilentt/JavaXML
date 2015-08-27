package ilentt.ilenlab.com.xml.jdom;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ReadXML {
	
	
	public ReadXML() {
		// constructor
	}
	
	public void runReadXML() {
		SAXBuilder builder = new SAXBuilder();
		File file = new File("DepartmentData.xml");
		System.out.println("Parsing file: " + file.getAbsolutePath());
		
		try {
			Document document = (Document) builder.build(file);
			Element rootNode = document.getRootElement();
			List<Element> lstElement = rootNode.getChildren("employee");
			
			for(int i=0; i<lstElement.size(); i++) {
				Element element = (Element)lstElement.get(i);
				System.out.println("\n...");
				System.out.println("Emp No: " + element.getChildText("empNo"));
				System.out.println("Emp Name: " + element.getChildText("empName"));
				System.out.println("Hire Date: " + element.getChildText("hireDate"));
				System.out.println("Salary: " + element.getChildText("salary"));
			}
		}catch(IOException e) {
			e.printStackTrace();
		}catch(JDOMException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadXML r = new ReadXML();
		r.runReadXML();
	}

}
