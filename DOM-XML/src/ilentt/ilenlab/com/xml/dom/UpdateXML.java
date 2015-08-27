package ilentt.ilenlab.com.xml.dom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class UpdateXML {

	public UpdateXML() {
		// constructor
	}
	
	public void runUpdateXML() {
		try {
			File file = new File("DepartmentData.xml");
			//String xmlFile = "DepartmentData.xml";
			
			// Parser Unicode XML file
			
			InputStream inputStream = new FileInputStream(file);
			Reader reader = new InputStreamReader(inputStream,"UTF-8");
			InputSource is = new InputSource(reader);
			is.setEncoding("UTF-8");
						
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			//Document doc = dBuilder.parse(xmlFile);
			Document doc = dBuilder.parse(is);
			doc.getDocumentElement().normalize();
			
			// get root element
			//Node department = doc.getFirstChild();
			
			// get the employee element by tag name directory
			Node employee = doc.getElementsByTagName("employee").item(0);
			
			// update employee attribute
			NamedNodeMap attribute = employee.getAttributes();
			Node attrNode = attribute.getNamedItem("id");
			attrNode.setTextContent("IE009");
			
			// append new node to staff
			Element manager = doc.createElement("Manager");
			manager.appendChild(doc.createTextNode("Trần Thanh I Len"));
			employee.appendChild(manager);
			
			// loop the employee node
			NodeList lstNode = employee.getChildNodes();
			for(int i=0; i<lstNode.getLength(); i++) {
				Node node = lstNode.item(i);
				
				// get the element salary and update new value
				if("salary".equals(node.getNodeName())) {
					node.setTextContent("20000");
				}
				
				// remove note
				if("note".equals(node.getNodeName())) {
					employee.removeChild(node);
				}
			}
			
			// write the content into xml 
			TransformerFactory transformFactory = TransformerFactory.newInstance();
			Transformer transformer = transformFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			//StreamResult result = new StreamResult(new File(xmlFile));
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);
			
			System.out.println("Done!");
			
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(TransformerException te) {
			te.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UpdateXML u = new UpdateXML();
		u.runUpdateXML();
 	}

}
