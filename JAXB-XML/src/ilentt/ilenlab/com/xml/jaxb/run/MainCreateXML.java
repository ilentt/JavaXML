package ilentt.ilenlab.com.xml.jaxb.run;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import ilentt.ilenlab.com.xml.jaxb.model.Department;
import ilentt.ilenlab.com.xml.jaxb.model.Employee;

public class MainCreateXML {
	
	private static final String XML_FILE = "dept-data.xml";
	
	private Employee emp1, emp2, emp3;
	private Department dept;
	
	public MainCreateXML() {
		// constructor
		emp1 = new Employee("E001", "Tom", null);
		emp2 = new Employee("E002", "Mary", "E001");
		emp3 = new Employee("E003", "John", null);
		
		List<Employee> lstEmployee = new ArrayList<Employee>();
		lstEmployee.add(emp1);
		lstEmployee.add(emp2);
		lstEmployee.add(emp3);
		
		dept = new Department("D001", "Research", "HO Chi Minh" );
		dept.setEmployees(lstEmployee);
	}
	
	public void runCreateXML() {
		try {
			
			// create JABX object context
			JAXBContext context = JAXBContext.newInstance(Department.class);
			
			// 1. Marsheller: convert Java objecet into XML
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			// write Java object(dept) into console
			m.marshal(dept, System.out);
			
			// write Java object(dept) into file
			File outFile = new File(XML_FILE);
			m.marshal(dept, outFile);
			
			System.err.println("Write to file: " + outFile.getAbsolutePath());
			
			// 2. UnMarsheller: convert data xml into Java object
			Unmarshaller um = context.createUnmarshaller();
			
			// Analysis XML file create in previous step
			Department deptFile = (Department)um.unmarshal(new FileReader(XML_FILE));
			List<Employee> emps = deptFile.getEmployees();
			
			for(Employee emp : emps) {
				System.out.println("Employee: " + emp.getEmpName());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MainCreateXML m = new MainCreateXML();
		m.runCreateXML();
	}
}
