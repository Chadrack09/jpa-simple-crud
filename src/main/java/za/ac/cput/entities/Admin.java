package za.ac.cput.entities;

import java.io.Serializable;
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
 * @since     30 Jul 2021 | 21:50:32
 */

@Entity
@Table(name = "admin")
public class Admin implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Column(name = "admin_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int adminId;
  
  @Column(name = "admin_name")
  private String adminName;
  
  @Column(name = "admin_password")
  private String adminPassword;

  public Admin() {/** empty constructor **/}

  public Admin(int adminId, String adminName, String adminPassword) {
    this.adminId = adminId;
    this.adminName = adminName;
    this.adminPassword = adminPassword;
  }

  public int getAdminId() {
    return adminId;
  }

  public void setAdminId(int adminId) {
    this.adminId = adminId;
  }

  public String getAdminName() {
    return adminName;
  }

  public void setAdminName(String adminName) {
    this.adminName = adminName;
  }

  public String getAdminPassword() {
    return adminPassword;
  }

  public void setAdminPassword(String adminPassword) {
    this.adminPassword = adminPassword;
  }

  @Override
  public String toString() {
    return "Admin{" + "adminId=" + adminId + ", adminName=" + adminName + ", "
            + "adminPassword=" + adminPassword + '}';
  }
  
}