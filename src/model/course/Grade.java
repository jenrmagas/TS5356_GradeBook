package model.course;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import model.people.Student;

@Entity
@Table(name="grade", schema="1257538")
public class Grade implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GradeSeq", sequenceName="1257538.grade_seq")
	@GeneratedValue(generator="GradeSeq", strategy= GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="number_grade")
    private BigDecimal numberGrade;
	
	@ManyToOne
	@JoinColumn(name="course_listing_id")
	private CourseListing courseListing;
	
	@ManyToOne
	@JoinColumn(name="assignment_id")
	private Assignment assignment;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Student student;
	
    public Grade() {
        numberGrade = BigDecimal.ZERO;
    }

    public Grade(BigDecimal numberGrade, CourseListing courseListing, 
    		Assignment assignment, Student student) {
        this.numberGrade = numberGrade;
        this.courseListing = courseListing;
        this.assignment = assignment;
        this.student = student;
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getNumberGrade() {
		return numberGrade;
	}

	public void setNumberGrade(BigDecimal numberGrade) {
		this.numberGrade = numberGrade;
	}

	public CourseListing getCourseListing() {
		return courseListing;
	}

	public void setCourseListing(CourseListing courseListing) {
		this.courseListing = courseListing;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
