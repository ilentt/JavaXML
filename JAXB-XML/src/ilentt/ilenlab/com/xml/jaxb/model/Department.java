package ilentt.ilenlab.com.xml.jaxb.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://ilentt.ilenlab.com/jaxb", name ="DEPARTMENT")
@XmlAccessorType(XmlAccessType.FIELD)

public class Department {
	private String deptNo;
	private String deptName;
	private String location;
	
	@XmlElementWrapper(name ="Employees")
	@XmlElement(name = "Employee")
	private List<Employee> employees;
	
	public Department() {
		// constructor
	}
	
	public Department(String deptNo, String deptName, String location) {
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.location = location;
	}
	
	public String getDeptNo() {
		return this.deptNo;
	}
	
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	
	public String getDeptName() {
		return this.deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
