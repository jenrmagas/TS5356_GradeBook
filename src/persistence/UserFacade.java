package persistence;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.people.User;

@Stateless
@LocalBean
public class UserFacade extends TS5356Facade<User> {

	public UserFacade() {
	}
	
	public UserFacade(Class<User> entityClass) {
		super(entityClass);
	}

	public User findUserByCredentials(String email, String password) {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("email", email);
		params.put("password", password);
		return findSingleByParams("findUserByCredentials", params);
	}
	
	public User findUserByEmail(String email) {
		return findSingleByParam("findUserByEmail", "email", email);
	}
	
	public void createUser(User user) {
		getEm().persist(user);
	}
	
}
