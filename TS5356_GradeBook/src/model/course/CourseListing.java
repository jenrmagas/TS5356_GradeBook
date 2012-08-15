package model.course;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import model.institution.Semester;
import model.people.Instructor;
import model.people.Student;

@Entity
@Table(name="course_listing", schema="1257538")
public class CourseListing implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CourseListingSeq", sequenceName="1257538.course_listing_seq")
	@GeneratedValue(generator="CourseListingSeq", strategy= GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="name")
    private String name;
	
	@Column(name="sess")
	private Integer session;
	
	@ManyToOne
	@JoinColumn(name="course_id")
    private Course parentCourse;
	
	@OneToMany(mappedBy="courseListing")
	private List<Grade> grades;
	
	@ManyToOne
	@JoinColumn(name="semester_id")
	private Semester semesterOffered;
	
	@ManyToMany(mappedBy="enrolledCourses", targetEntity=Student.class)
	private List<Student> enrolledStudents;
	
	@ManyToOne
	@JoinColumn(name="instructor_id")
	private Instructor instructor;

    public CourseListing() {
    }
    
    public CourseListing(String name, Course parentCourse, Integer session, 
    		Semester semesterOffered, Instructor instructor, List<Student> enrolledStudents) {
        this.name = name;
        this.parentCourse = parentCourse;
        this.session = session;
        this.semesterOffered = semesterOffered;
        this.instructor = instructor;
        this.enrolledStudents = enrolledStudents;
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

	public Course getParentCourse() {
		return parentCourse;
	}

	public void setParentCourse(Course parentCourse) {
		this.parentCourse = parentCourse;
	}

	public Semester getSemesterOffered() {
		return semesterOffered;
	}

	public void setSemesterOffered(Semester semesterOffered) {
		this.semesterOffered = semesterOffered;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public List<Student> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(List<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public Integer getSession() {
		return session;
	}

	public void setSession(Integer session) {
		this.session = session;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
}
