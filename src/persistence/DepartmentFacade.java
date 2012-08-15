package persistence;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.institution.Department;

@Stateless
@LocalBean
public class DepartmentFacade extends TS5356Facade<Department> {

	public List<Department> findAllDepartments() {
		return findAll(Department.class);
	}

}
