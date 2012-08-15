package beans.people;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import persistence.UserFacade;
import util.JsfUtil;

import model.people.Administrator;
import model.people.EnrollmentStaff;
import model.people.Instructor;
import model.people.Student;
import model.people.User;
import model.people.UserType;


/**
 * @author 1257538
 * 
 * Login approach loosely based on 
 * http://wowjava.wordpress.com/2010/01/21/jsf-database-application/
 * and http://java.net/projects/educationmanagement
 */
@ManagedBean
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB private UserFacade userFacade;
	@EJB private User user;
	
	private String emailReplacement;
	private String emailConfirm;
	private String passwordReplacement;
	private String passwordConfirm;
	private UserType userType;
	private boolean loggedIn;

	public UserBean() {
		super();
	}

	public String login() {
		boolean validLogin = false;
		User tempUser = userFacade.findUserByCredentials(getEmail(), getPassword());
		
		if(tempUser != null) {
			validLogin = true;
			setLoggedIn(true);
			setUserType(tempUser.getUserType());
		}
		
		return (validLogin ? "loginSuccess" : "loginFailure");
	}
	
	public String register() {
		boolean validRegistration = true;
		User newUser = null;
		
		if(userFacade.findUserByEmail(getEmail()) != null) {
			JsfUtil.addErrorMessage("A user already exists with this email.");
			validRegistration = false;
		}
		
		if(!getEmail().equals(emailConfirm)) {
			JsfUtil.addErrorMessage("Email addresses provided do not match. Please reenter.");
			validRegistration = false;
		}

		if(getPassword().equals(passwordConfirm) ) {
			JsfUtil.addErrorMessage("Passwords provided do not match. Please reenter.");
			validRegistration = false;
		}
		
		switch(userType) {
		case ADMINISTRATOR:
			newUser = new Administrator(getFirstName(), getLastName(), getMiddleInitial(), getPassword(), getEmail());
			break;
		case INSTRUCTOR:
			newUser = new Instructor(getFirstName(), getLastName(), getMiddleInitial(), getPassword(), getEmail());
			break;
		case ENROLLMENT_STAFF:
			newUser = new EnrollmentStaff(getFirstName(), getLastName(), getMiddleInitial(), getPassword(), getEmail());
			break;
		case STUDENT:
			newUser = new Student(getFirstName(), getLastName(), getMiddleInitial(), getPassword(), getEmail());
			break;
		default:
			validRegistration = false;
			JsfUtil.addErrorMessage("Error: Unknown user type.");
			break;
		}

		if(validRegistration) {
			userFacade.createUser(newUser);
		}
		
		return (validRegistration ? "registrationPass" : "registrationFailure");
	}
	
	private boolean replacementCheck(String newVal) {
		return (newVal == null || "".equals(newVal)) ? false : true;
	}
	
	public String saveChanges() {
		boolean makeChanges = true;
		User tempUser = userFacade.findUserByCredentials(getEmail(), getPassword());
		
		if(tempUser == null) {
			JsfUtil.addErrorMessage("ERROR: User email address could not be found.");
			makeChanges = false;
		} else {
			if(replacementCheck(passwordReplacement) && !passwordReplacement.equals(passwordConfirm)) {
				JsfUtil.addErrorMessage("Replacement passwords provided do not match. Please reenter.");
				makeChanges = false;
			}
			
			if(replacementCheck(emailReplacement) && !emailReplacement.equals(emailConfirm)) {
				JsfUtil.addErrorMessage("Replacement email addresses provided do not match. Please reenter.");
				makeChanges = false;
			}
			
			if(makeChanges) {
				if(replacementCheck(getEmailReplacement())) {
					tempUser.setEmail(getEmail());
				}
				if(replacementCheck(passwordReplacement)) {
					tempUser.setPassword(getPassword());
				}
				tempUser.setFirstName(getFirstName());
				tempUser.setLastName(getLastName());
				tempUser.setMiddleInitial(getMiddleInitial());
				userFacade.merge(tempUser);
			}
		}
		
		return (makeChanges ? "changeSuccess" : "changeFailure");
	}
	
	public void logout() {
		setLoggedIn(false);
		setUserType(null);
	}
	
	protected String getPassword() {
		return user.getPassword();
	}
	
	public void setPassword(String password) {
		user.setPassword(password);
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getEmail() {
		return user.getEmail();
	}

	public void setEmail(String email) {
		user.setEmail(email);
	}

	public String getEmailConfirm() {
		return emailConfirm;
	}

	public void setEmailConfirm(String emailConfirm) {
		this.emailConfirm = emailConfirm;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	public boolean isAdministrator() {
		return UserType.ADMINISTRATOR == userType;
	}

	public boolean isStudent() {
		return UserType.STUDENT == userType;
	}

	public boolean isInstructor() {
		return UserType.INSTRUCTOR == userType;
	}
	
	public List<UserType> getAllUserTypes() {
		return User.getAllUserTypes();
	}

	public String getFirstName() {
		return user.getFirstName();
	}

	public void setFirstName(String firstName) {
		user.setFirstName(firstName);
	}

	public String getLastName() {
		return user.getLastName();
	}

	public void setLastName(String lastName) {
		user.setLastName(lastName);
	}

	public char getMiddleInitial() {
		return user.getMiddleInitial();
	}

	public void setMiddleInitial(char middleInitial) {
		user.setMiddleInitial(middleInitial);
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getEmailReplacement() {
		return emailReplacement;
	}

	public void setEmailReplacement(String emailReplacement) {
		this.emailReplacement = emailReplacement;
	}

	public String getPasswordReplacement() {
		return passwordReplacement;
	}

	public void setPasswordReplacement(String passwordReplacement) {
		this.passwordReplacement = passwordReplacement;
	}

	public UserFacade getFacade() {
		return userFacade;
	}
}
