package airline.logic;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "user")
@NamedQueries(
{
  @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
  @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
  @NamedQuery(name = "User.findByAdmin", query = "SELECT u FROM User u WHERE u.admin = :admin"),
  @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
  @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
  @NamedQuery(name = "User.findByBirthday", query = "SELECT u FROM User u WHERE u.birthday = :birthday"),
  @NamedQuery(name = "User.findByAddress", query = "SELECT u FROM User u WHERE u.address = :address"),
  @NamedQuery(name = "User.findByWorkphone", query = "SELECT u FROM User u WHERE u.workphone = :workphone"),
  @NamedQuery(name = "User.findByCellphone", query = "SELECT u FROM User u WHERE u.cellphone = :cellphone")
})
public class User implements Serializable
{
  @Basic(optional = false)
  @Column(name = "name")
  private String name;
  @Basic(optional = false)
  @Column(name = "lastname")
  private String lastname;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
  private List<Reservation> reservationList;
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "username")
  private String username;
  @Basic(optional = false)
  @Column(name = "admin")
  private boolean admin;
  @Basic(optional = false)
  @Column(name = "password")
  private String password;
  @Basic(optional = false)
  @Column(name = "email")
  private String email;
  @Basic(optional = false)
  @Column(name = "birthday")
  @Temporal(TemporalType.DATE)
  private Date birthday;
  @Basic(optional = false)
  @Column(name = "address")
  private String address;
  @Basic(optional = false)
  @Column(name = "workphone")
  private String workphone;
  @Basic(optional = false)
  @Column(name = "cellphone")
  private String cellphone;

  public User()
  {
  }

  public User(String username)
  {
    this.username = username;
  }

  public User(String username, boolean admin, String password, String email, Date birthday, String address, String workphone, String cellphone)
  {
    this.username = username;
    this.admin = admin;
    this.password = password;
    this.email = email;
    this.birthday = birthday;
    this.address = address;
    this.workphone = workphone;
    this.cellphone = cellphone;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public boolean getAdmin()
  {
    return admin;
  }

  public void setAdmin(boolean admin)
  {
    this.admin = admin;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public Date getBirthday()
  {
    return birthday;
  }

  public void setBirthday(Date birthday)
  {
    this.birthday = birthday;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getWorkphone()
  {
    return workphone;
  }

  public void setWorkphone(String workphone)
  {
    this.workphone = workphone;
  }

  public String getCellphone()
  {
    return cellphone;
  }

  public void setCellphone(String cellphone)
  {
    this.cellphone = cellphone;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (username != null ? username.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof User))
    {
      return false;
    }
    User other = (User) object;
    return !((this.username == null && other.username != null) || (this.username != null && this.password != null 
      && !this.username.equals(other.username) && !this.password.equals(other.password)));
  }

  @Override
  public String toString()
  {
    return this.username;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getLastname()
  {
    return lastname;
  }

  public void setLastname(String lastname)
  {
    this.lastname = lastname;
  }

  public List<Reservation> getReservationList()
  {
    return reservationList;
  }

  public void setReservationList(List<Reservation> reservationList)
  {
    this.reservationList = reservationList;
  }

}
