package ilentt.ilenlab.com.xml.xpath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class xPathXML {

	public xPathXML () {
		// constructor
	}
	
	public void xPathApp() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc  = null;
		
		
		try {
			builder = factory.newDocumentBuilder();
			doc = builder.parse("DepartmentData.xml");
			
			// create xpath factory object
			XPathFactory xpathFactory = XPathFactory.newInstance();
			
			// create xpath object
			XPath xpath = xpathFactory.newXPath();
			
			String name1 = getEmployeeById(doc, xpath, 1);
			System.out.println("Employee with ID = 1 is: " + name1);
			
			String name2 = getEmployeeByNo(doc, xpath, "E003");
			System.out.println("Employee with empNO = E003 is: " + name2);
			
			List<String> lstEmployee = getEmployeeNameBySalary(doc, xpath, 50000);
			System.out.println("Employee with salary = 50000 are: " + lstEmployee.toString());
			
		}catch(ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private List<String> getEmployeeNameBySalary(Document doc, XPath xpath, int salary) {
		List<String> lstEmployee = new ArrayList<>();
		try {
			// create xPathExpression object
			XPathExpression xPathExpress = xpath.compile("/department/employee[salary="+salary+"]/empName/text()");
			
			// evaluate expression result on XML Document
			NodeList nodes = (NodeList) xPathExpress.evaluate(doc, XPathConstants.NODESET);
			for(int i=0; i<nodes.getLength(); i++) {
				lstEmployee.add(nodes.item(i).getNodeValue());
			}
		}catch(XPathExpressionException e) {
			e.printStackTrace();
		}
			
		return lstEmployee;
	}
	
	private String getEmployeeByNo(Document doc, XPath xpath, String empNo) {
		String name = null;
		try {
			XPathExpression xPathExpress = xpath.compile("/department/employee[empNo='"+empNo+"']/empName/text()");
			name = (String) xPathExpress.evaluate(doc, XPathConstants.STRING);
		}catch(XPathExpressionException e) {
			e.printStackTrace();
		}
		return name;
	}
	
	private String getEmployeeById(Document doc, XPath xpath, int id) {
		String name = null;
		try {
			XPathExpression xPathExpress = xpath.compile("/department/employee[@id='"+id+"']/empName/text()");
			name = (String) xPathExpress.evaluate(doc, XPathConstants.STRING);
		}catch(XPathExpressionException e) {
			e.printStackTrace();
		}
		return name;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		xPathXML x = new xPathXML();
		x.xPathApp();
	}

}
