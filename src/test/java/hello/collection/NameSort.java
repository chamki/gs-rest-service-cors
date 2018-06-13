package hello.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NameSort {

	public static void main(String[] args) {
		Name[] nameArray = {
				new Name("John", "Smith"),
	            new Name("Karl", "Ng"),
	            new Name("Jeff", "Smith"),
	            new Name("Tom", "Rich")
		};
		
		List<Name> list = Arrays.asList(nameArray);
		Collections.sort(list);
		System.out.println(list);

	}

}
