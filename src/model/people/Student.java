package model.people;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import model.course.CourseListing;
import model.course.Grade;

@Entity
public class Student extends User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@ManyToMany
	@JoinTable(name="student_to_course_listing",
	    joinColumns=@JoinColumn(name="student_id"),
	    inverseJoinColumns=@JoinColumn(name="course_listing_id"))
	private List<CourseListing> enrolledCourses;
	
	@OneToMany(mappedBy="student")
	private List<Grade> grades;
	
	public Student() {
        super();
        this.enrolledCourses = new ArrayList<CourseListing>();
    }
    
	public Student(String firstName, String lastName, char middleInitial,
			String password, String email) {
		super(firstName, lastName, middleInitial, password, email);
	}

	public Student(String firstName, String lastName, char middleInitial, 
			String password, String email, List<CourseListing> coursesEnrolled) {
		super(firstName, lastName, middleInitial, password, email);
		this.enrolledCourses = coursesEnrolled;
    }

	public List<CourseListing> getCoursesEnrolled() {
		return enrolledCourses;
	}

	public void setCoursesEnrolled(List<CourseListing> coursesEnrolled) {
		this.enrolledCourses = coursesEnrolled;
	}

	@Override
	public UserType getUserType() {
		return UserType.STUDENT;
	}

}
