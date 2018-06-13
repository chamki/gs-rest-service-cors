package hello.collection;

import java.util.Comparator;
import java.util.Date;

public class Employee implements Comparator<Employee>{
	
	private Name name;
	
	private int number;
	
	private Date hireDate;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Name name, int number, Date hireDate) {
		super();
		this.name = name;
		this.number = number;
		this.hireDate = hireDate;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public int compare(Employee e1, Employee e2) {
		//return e1.hireDate.compareTo(e2.hireDate);
		return 0;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", number=" + number + ", hireDate=" + hireDate + "]";
	}

}
