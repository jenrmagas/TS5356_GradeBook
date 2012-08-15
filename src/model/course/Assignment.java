package model.course;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="assignment", schema="1257538")
public class Assignment implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AssnSeq", sequenceName="1257538.assignment_seq")
	@GeneratedValue(generator="AssnSeq", strategy= GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull
	@Column(name="name")
    private String name;

	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	@NotNull
	@Column(name="week_due")
	private Integer weekDue;
	
	@Column(name="description")
    private String description;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private AssignmentType type;
	
	@OneToMany(mappedBy="assignment")
    private List<Grade> grades;

	public Assignment() {
    }
    
    public Assignment(Course course, String name, Integer weekDue, String description, AssignmentType type) {
        this.course = course;
    	this.name = name;
        this.weekDue = weekDue;
        this.description = description;
        this.type = type;
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

	public Integer getWeekDue() {
		return weekDue;
	}

	public void setWeekDue(Integer weekDue) {
		this.weekDue = weekDue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AssignmentType getType() {
		return type;
	}

	public void setType(AssignmentType type) {
		this.type = type;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	
}
