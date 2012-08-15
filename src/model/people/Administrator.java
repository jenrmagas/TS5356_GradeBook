package model.people;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import model.institution.Department;

@Entity
public class Administrator extends User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="department_id")
    private Department department;
	
    public Administrator() {
        super();
        this.department = null;
    }
    
    public Administrator(String firstName, String lastName, char middleInitial,
			String password, String email) {
		super(firstName, lastName, middleInitial, password, email);
	}

	public Administrator(String firstName, String lastName, char middleInitial, 
			String password, String email, Department department) {
        super(firstName, lastName, middleInitial, password, email);
        this.department = department;
    }

	@Override
	public UserType getUserType() {
		return UserType.ADMINISTRATOR;
	}
    
}
