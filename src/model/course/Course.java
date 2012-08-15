package model.course;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import model.institution.Department;

@Entity
@Table(name="course", schema="1257538")
public class Course implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CourseSeq", sequenceName="1257538.course_seq")
	@GeneratedValue(generator="CourseSeq", strategy= GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="name")
    private String name;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	
	@OneToMany(mappedBy="course", targetEntity=Assignment.class)
	private List<Assignment> assignments;
	
	@OneToMany(mappedBy="parentCourse", targetEntity=CourseListing.class)
	private List<CourseListing> courseListings;
	
    public Course() {
        this.name = "";
    }
    
    public Course(String name) {
    	this.name = name;
    }
    
    public Course(String name, List<Assignment> assignments, List<CourseListing> courseListings) {
    	this.name = name;
    	this.assignments = assignments;
    	this.courseListings = courseListings;
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	public List<CourseListing> getCourseListings() {
		return courseListings;
	}

	public void setCourseListings(List<CourseListing> courseListings) {
		this.courseListings = courseListings;
	}
	
}
