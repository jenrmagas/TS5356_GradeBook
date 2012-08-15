package beans.people;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import model.people.User;
import model.people.UserType;

import persistence.UserFacade;
import util.JsfUtil;

@ManagedBean
public class UserMgmtBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB private UserFacade userFacade;
	private String email;
	private String firstName;
	private String lastName;
	private String middleInitial;
	private UserType userType;
	private List<User> userList;

	public void findUsers() {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuilder queryBuilder = new StringBuilder();

		queryBuilder.append("SELECT u FROM User u WHERE 1 = 1 ");
		
		if(!email.isEmpty()) {
			addSearchCriteria(params, queryBuilder, "email", email);
		}
		
		if(!firstName.isEmpty()) {
			addSearchCriteria(params, queryBuilder, "firstName", firstName);
		}
		
		if(!lastName.isEmpty()) {
			addSearchCriteria(params, queryBuilder, "lastName", lastName);
		}
		
		if(!middleInitial.isEmpty()) {
			addSearchCriteria(params, queryBuilder, "middleInitial", middleInitial);
		}
		
		if(!(userType == null)) {
			addSearchCriteria(params, queryBuilder, "userType", userType);
		}
		
		if(!params.isEmpty()) {
			userList = userFacade.executeQuery(User.class, 
					queryBuilder.toString(), params);
			if(userList.isEmpty()) {
				JsfUtil.addMessage("No results Found.");
			}
		} else {
			userList = new ArrayList<User>();
			JsfUtil.addErrorMessage("At least one criteria must be provided.");
		}
	}

	private void addSearchCriteria(Map<String, Object> params,
			StringBuilder queryString, String param, Object arg) {
		queryString.append( "AND u.").append(param).append("= :").append(param);
		params.put(param, arg);
	}
	
	public UserFacade getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(UserFacade userFacade) {
		this.userFacade = userFacade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public boolean isResults() {
		return !userList.isEmpty();
	}

	public void setResults(boolean results) {
		// no action
	}

	public List<UserType> getAllUserTypes() {
		return User.getAllUserTypes();
	}
}
