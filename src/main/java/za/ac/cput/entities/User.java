package za.ac.cput.entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author    Chadrack B. Boudzoumou
 * @email     219383847@mycput.ac.za
 * @student   219383847
 * @uni       Cape Peninsula University Of Technology
 * @since     30 Jul 2021 | 21:50:23
 */

@Entity
@Table(name = "user")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Column(name = "user_id")
  private int userId;
  
  @Column(name = "user_name")
  private String userName;
  
  @Column(name = "user_password")
  private String userPassword;
  
  @Column(name = "country")
  private String country;
  
  @Column(name = "dob")
  private Date dob;

  public User() {/** empty constructor **/}

  public User(String userName, String userPassword, String country, Date dob) {
    this.userName = userName;
    this.userPassword = userPassword;
    this.country = country;
    this.dob = dob;
  }
  
  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  @Override
  public String toString() {
    return "User{" + "userId=" + userId + ", userName=" + userName + ", "
            + "userPassword=" + userPassword + ", country=" + country + ", dob=" + dob + '}';
  }
          
}