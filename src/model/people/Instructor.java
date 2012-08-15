package model.people;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import model.course.CourseListing;
import model.institution.Department;

@Entity
public class Instructor extends User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="instructor")
	private List<CourseListing> courseListings;
	
	@ManyToOne
	@JoinColumn(name="department_id")
    private Department department;
	
	public Instructor() {
    }
	
    public Instructor(String firstName, String lastName, char middleInitial,
			String password, String email) {
		super(firstName, lastName, middleInitial, password, email);
	}

	public Instructor(String firstName, String lastName, char middleInitial, 
			String password, String email, Department department) {
        super(firstName, lastName, middleInitial, password, email);
        this.department = department;
    }

	public List<CourseListing> getCourseListings() {
		return courseListings;
	}

	public void setCourseListings(List<CourseListing> courseListings) {
		this.courseListings = courseListings;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public UserType getUserType() {
		return UserType.INSTRUCTOR;
	}
}
