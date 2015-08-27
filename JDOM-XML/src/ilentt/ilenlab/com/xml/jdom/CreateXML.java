package ilentt.ilenlab.com.xml.jdom;

//import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class CreateXML {

	public CreateXML() {
		// constructor
	}
	
	public void runCreateXML() {
		try {
			Element deparment = new Element("deparment");
			Document doc = new Document(deparment);
			//doc.setRootElement(deparment);
			
			Element employee1 = new Element("employee");
			employee1.setAttribute(new Attribute("ID", "ID001"));
			employee1.addContent(new Element("empNo").setText("E001"));
			employee1.addContent(new Element("empName").setText("Trần Thanh I Len"));
			employee1.addContent(new Element("hireDate").setText("25/08/2015"));
			employee1.addContent(new Element("salary").setText("5500000"));
			
			doc.getRootElement().addContent(employee1);
			
			Element employee2 = new Element("employee");
			employee2.setAttribute(new Attribute("ID", "ID002"));
			employee2.addContent(new Element("empNo").setText("E002"));
			employee2.addContent(new Element("empName").setText("OBana"));
			employee2.addContent(new Element("hireDate").setText("25/09/2016"));
			employee2.addContent(new Element("salary").setText("2200000"));
			
			doc.getRootElement().addContent(employee2);
			
			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());
			
			// output into console
			xmlOutput.output(doc, System.out);
			
			// output xml file
			//xmlOutput.output(doc, new FileWriter("DepartmentDateNew.xml"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateXML c = new CreateXML();
		c.runCreateXML();
	}

}
