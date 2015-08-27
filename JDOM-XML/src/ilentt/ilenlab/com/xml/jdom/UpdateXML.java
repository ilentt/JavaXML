package ilentt.ilenlab.com.xml.jdom;

import java.io.File;
//import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class UpdateXML {

	public UpdateXML() {
		// constructor
	}
	
	public void runUpdateXML() {
		try {
			SAXBuilder builder = new SAXBuilder();
			File file = new File("DepartmentData.xml");
			
			Document doc = (Document) builder.build(file);
			Element rootElement = doc.getRootElement();
			//Element employee = rootElement.getChild("employee");
			List<Element> lstElement = rootElement.getChildren("employee");
			
			for(int i=0; i<lstElement.size();i++) {
				Element element = (Element)lstElement.get(i);
				// add new mngNo
				Element manager = new Element("manager").setText("M001");
				element.addContent(manager);
				
				// update salary value
				if("50000".equals(element.getChild("salary").getValue().toString()))
					element.getChild("salary").setText("200.000");
				
				// remove note element
				element.removeChild("note");
			}
			
			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());
			// output to screen console
			xmlOutput.output(doc, System.out);
			
			// output to xml file(if needed)
			//xmlOutput.output(doc, new FileWriter("DepartmentDataUpdate.xml"));
		}catch(IOException e) {
			e.printStackTrace();
		}catch(JDOMException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UpdateXML u = new UpdateXML();
		u.runUpdateXML();
	}

}
