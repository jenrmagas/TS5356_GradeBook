package beans.course;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import persistence.DepartmentFacade;

import model.course.Course;
import model.institution.Department;

public class CourseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB private DepartmentFacade deptFacade;
	private String name;
	private Long id;
	private Department department;
	private List<Course> courseList;
	
	public void findCourses() {
		// TODO build query for "findCourses" method
	}
	
	public List<Department> getAllDepartments() {
		return deptFacade.findAllDepartments();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public boolean isResults() {
		return !courseList.isEmpty();
	}
}
