package ilentt.ilenlab.com.xml.jaxb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)

public class Employee {
	private String empNo;
	private String empName;
	private String mngNo;
	
	public Employee() {
		// constructor
	}
	
	public Employee(String empNo, String empName, String mngNo) {
		this.empNo = empNo;
		this.empName = empName;
		this.mngNo = mngNo;
	}
	
	public String getEmpNo() {
		return this.empNo;
	}
	
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	
	public String getEmpName() {
		return this.empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getMngNo() {
		return this.mngNo;
	}
	
	public void setMngNo(String mngNo) {
		this.mngNo = mngNo;
	}
}
