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
import javax.persistence.Table;

import model.course.Course;
import model.people.Administrator;
import model.people.Instructor;

@Entity
@Table(name="department", schema="1257538")
public class Department implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="DeptSeq", sequenceName="1257538.department_seq")
	@GeneratedValue(generator="DeptSeq", strategy= GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="department", targetEntity=Instructor.class)
	private List<Instructor> instructors;
	
	@OneToMany(mappedBy="department", targetEntity=Administrator.class)
	private List<Administrator> administrators;
	
	@OneToMany(mappedBy="department", targetEntity=Course.class)
	private List<Course> courses;
	
    public Department() {
    }
    
	public Department(String name) {
		this.name = name;
    }
	
	public Department(String name, List<Instructor> instructors, List<Administrator> administrators) {
		this.name = name;
		this.instructors = instructors;
		this.administrators = administrators;
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

	public List<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}

	public List<Administrator> getAdministrators() {
		return administrators;
	}

	public void setAdministrators(List<Administrator> administrators) {
		this.administrators = administrators;
	}
	
}
