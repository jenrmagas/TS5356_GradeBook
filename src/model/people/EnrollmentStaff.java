package model.people;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class EnrollmentStaff extends User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	public EnrollmentStaff() {
        super();
    }
    
	public EnrollmentStaff(String firstName, String lastName, char middleInitial,
			String password, String email) {
		super(firstName, lastName, middleInitial, password, email);
	}

	@Override
	public UserType getUserType() {
		return UserType.ENROLLMENT_STAFF;
	}
}
