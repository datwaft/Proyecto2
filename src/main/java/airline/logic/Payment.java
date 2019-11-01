package airline.logic;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "payment")
@NamedQueries(
{
  @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
  @NamedQuery(name = "Payment.findById", query = "SELECT p FROM Payment p WHERE p.id = :id"),
  @NamedQuery(name = "Payment.findByName", query = "SELECT p FROM Payment p WHERE p.name = :name")
})
public class Payment implements Serializable
{
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "payment")
  private List<Reservation> reservationList;
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @Column(name = "name")
  private String name;

  public Payment()
  {
  }

  public Payment(Integer id)
  {
    this.id = id;
  }

  public Payment(Integer id, String name)
  {
    this.id = id;
    this.name = name;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Payment))
    {
      return false;
    }
    Payment other = (Payment) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "airline.logic.Payment[ id=" + id + " ]";
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
