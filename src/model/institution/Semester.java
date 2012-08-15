package model.institution;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import model.course.CourseListing;

@Entity
public class Semester implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="SemesterSeq", sequenceName="1257538.semester_seq")
	@GeneratedValue(generator="SemesterSeq", strategy= GenerationType.SEQUENCE)
	private Long id;

	@Column(name="year")
    private Integer year;
	
	@Column(name="quarter")
    private Integer quarter;
	
	@OneToMany(mappedBy="semesterOffered")
	private List<CourseListing> courseListings;

    public Semester() {
    }
    
    public Semester(Integer quarter, Integer year) {
        this.quarter = quarter;
        this.year = year;
    }
    
    public Semester(Integer quarter, Integer year, List<CourseListing> courseListings) {
    	this.quarter = quarter;
    	this.year = year;
    	this.courseListings = courseListings;
    }
}
