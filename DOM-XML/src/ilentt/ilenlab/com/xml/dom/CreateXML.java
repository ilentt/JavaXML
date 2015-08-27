package ilentt.ilenlab.com.xml.dom;

//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.io.OutputStreamWriter;
//import java.io.Reader;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXML {
	
	public static final String DOM_FILE ="dom-data.xml";
	
	public CreateXML() {
		// constructor
	}
	
	public void runCreateXML() {
		try {
			//OutputStream outputStream = new FileOutputStream(DOM_FILE);
			//OutputStreamWriter write = new OutputStreamWriter(outputStream, "UTF-8");
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = docFactory.newDocumentBuilder();
			 
			// root element
			Document doc = builder.newDocument();
			Element rootElement = doc.createElement("company");
			doc.appendChild(rootElement);
			
			// staff element
			Element staff = doc.createElement("Staff");
			rootElement.appendChild(staff);
			
			// set attribute to staff element
			Attr attr = doc.createAttribute("id");
			attr.setValue("S001");
			staff.setAttributeNode(attr);
			
			// first name element
			Element firstName = doc.createElement("FistName");
			firstName.appendChild(doc.createTextNode("Trần Thanh"));
			staff.appendChild(firstName);
			
			// last name element
			Element lastName = doc.createElement("LastName");
			lastName.appendChild(doc.createTextNode("I Len"));
			staff.appendChild(lastName);
			
			// hire date name element
			Element hireDate = doc.createElement("HireDate");
			hireDate.appendChild(doc.createTextNode("25/08/2015"));
			staff.appendChild(hireDate);
			
			// first name element
			Element salary = doc.createElement("Salary");
			salary.appendChild(doc.createTextNode("100000"));
			staff.appendChild(salary);
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			
			// output to xml file
			//StreamResult result = new StreamResult(new File(DOM_FILE));
			
			// output to console for test
			//StreamResult result = new StreamResult(System.out);
			StreamResult result = new StreamResult(new StringWriter());
			
			transformer.transform(source, result);
			String xmlString = result.getWriter().toString();
			System.out.println(xmlString);
			
			System.out.println("\nFile saved");
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(TransformerException te) {
			te.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateXML c = new CreateXML();
		c.runCreateXML();
	}

}
