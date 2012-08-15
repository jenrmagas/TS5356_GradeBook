package model.people;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@ManagedBean
@Table(name="users", schema="1257538")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="UserSeq", sequenceName="User1257538.user_seq")
	@GeneratedValue(generator="UserSeq", strategy= GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="first_name")
    private String firstName;
    
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="middle_initial")
    private char middleInitial;

    public User() {
        this.firstName = "";
        this.lastName = "";
        this.middleInitial = ' ';
    }
    
    public User(String firstName, String lastName, char middleInitial, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.password = password;
        this.email = email;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public char getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(char middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public UserType getUserType() {
		return UserType.USER;
	}
	
	public static List<UserType> getAllUserTypes() {
		List<UserType> types = new ArrayList<UserType>();
		for(UserType user : UserType.values()) {
			types.add(user);
		}
		return types;
	}
}
