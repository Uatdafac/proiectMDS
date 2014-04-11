package com.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
@SequenceGenerator(name = "GEN", sequenceName = "USEQ", allocationSize = 1)
public class User {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN")
	private Long id;

	@Column(name = "USERNAME", nullable = false, length = 256)
	private String username;

	@Column(name = "USER_PASSWORD", nullable = false, length = 256)
	private String userPassword;

	@Column(name = "FIRST_NAME", length = 256)
	private String firstName;

	@Column(name = "MIDDLE_NAME", length = 256)
	private String middleName;

	@Column(name = "LAST_NAME", length = 256)
	private String lastName;

	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;

	@Column(name = "HOME_PHONE_NUMBER")
	private String homePhoneNumber;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "JOIN_DATE")
	private String joinDate;

	// e mai simplu sa folosesc mappedBy decat cu join table :)
//	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "friendOf")
	// @JoinTable(name = "BUDDIES", joinColumns = @JoinColumn(name =
	// "BUSER_ID"), inverseJoinColumns = @JoinColumn(name = "BUDDY_ID"))
//	private Set<User> friends;

//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "BUDDIES", joinColumns = @JoinColumn(name = "BUDDY_ID"), inverseJoinColumns = @JoinColumn(name = "BUSER_ID"))
//	private Set<User> friendOf;
	
	@OneToMany(mappedBy = "friendPK.user", cascade = CascadeType.ALL)
	public Set<Friend> friends;

	@OneToMany(mappedBy = "friendPK.friend", cascade = CascadeType.ALL)
	public Set<Friend> friendOf;
	
	public User() {
	}

	public User(String username, String userPassword) {
		this.username = username;
		this.userPassword = userPassword;
		firstName = null;
		middleName = null;
		lastName = null;
		mobileNumber = null;
		homePhoneNumber = null;
		address = null;
		joinDate = null;
	}

	public User(String uName, String pass, String fName, String mName, String lName,
			String mNumber, String hpNumber, String _address, String jDate) {
		username = uName;
		userPassword = pass;
		firstName = fName;
		middleName = mName;
		lastName = lName;
		mobileNumber = mNumber;
		homePhoneNumber = hpNumber;
		address = _address;
		joinDate = jDate;
	}

//	public Set<User> getFriends() {
//		return friends;
/*	}

	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}

	public Set<User> getFriendOf() {
		return friendOf;
	}

	public void setFriendOf(Set<User> friendOf) {
		this.friendOf = friendOf;
	}
*/
	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
