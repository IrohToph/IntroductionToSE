package User;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DBConnection.DBConnection;

public class User {
	
	private String name;
	private int age;
	private String gender;
	private String address;
	private String status;
	private String username;
	private String password;
	private Date birthday;
	private String phoneNumber;
	private String RID;
	private String ID;
	private String email;
	
	public User() {
		
	}
	
	public User(String username) throws SQLException {
		String sql = "Select * from Resident r, Accounts a where a.Username = '" + username + "' and r.RID = a.RID";
		DBConnection connection = new DBConnection();
		Statement st = connection.makeConnection().createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			this.name = rs.getString("Name");
			this.age = rs.getInt("Age");
			this.gender = rs.getString("Gender");
			this.address = rs.getString("Address");
			this.username = rs.getString("Username");
			this.password = rs.getString("Password");
			this.birthday = rs.getDate("Birthday");
			this.phoneNumber = rs.getString("Phone Number");
			this.RID = rs.getString("RID");
			this.status = rs.getString("Status");
			this.ID = rs.getString("Identification Number");
			this.email = rs.getString("Email");
		}
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRID() {
		return RID;
	}

	public void setRID(String rID) {
		RID = rID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRoom() {
		return address;
	}
	public void setRoom(String room) {
		this.address = room;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}
}
