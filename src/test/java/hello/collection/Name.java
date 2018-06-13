package hello.collection;

public class Name implements Comparable<Name> {
	
	private final String firstName, lastName;
	
	public Name(String firstName, String lastName) {
		if(firstName == null || lastName == null) {
			throw new NullPointerException();
		}
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public int compareTo(Name n) {
		int lastCmp = lastName.compareTo(n.lastName);
		return (lastCmp != 0 ? lastCmp : firstName.compareTo(n.firstName));
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	@Override
	public int hashCode() {
		return 31 * firstName.hashCode() + lastName.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Name)) {
			return false;
		}
		Name n = (Name) obj;
		return n.firstName.equals(this.firstName) && n.lastName.equals(this.lastName);
	}
	
	

}
