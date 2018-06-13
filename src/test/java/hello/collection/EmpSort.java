package hello.collection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class EmpSort {
	
	static final Comparator<Employee> SENIORITY_ORDER = new Comparator<Employee>() {
		public int compare(Employee e1, Employee e2) {
			return e2.getHireDate().compareTo(e1.getHireDate());
		}
	};

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Collection<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(new Name("zhang", "san"), 5, new Date()));
		employees.add(new Employee(new Name("li", "san"), 5, sdf.parse("2017-08-09")));
		employees.add(new Employee(new Name("wang", "san"), 5, sdf.parse("2017-08-09")));
		employees.add(new Employee(new Name("zhao", "san"), 5, sdf.parse("2017-08-10")));
		employees.add(new Employee(new Name("liu", "san"), 5, sdf.parse("2017-08-09")));
		
		List<Employee> list = new ArrayList<Employee>(employees);
		Collections.sort(list, SENIORITY_ORDER);
		System.out.println(list);
	}
}
