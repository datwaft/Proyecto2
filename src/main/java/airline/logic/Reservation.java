package airline.logic;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "reservation")
@NamedQueries(
{
  @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r"),
  @NamedQuery(name = "Reservation.findById", query = "SELECT r FROM Reservation r WHERE r.id = :id"),
  @NamedQuery(name = "Reservation.findByAmount", query = "SELECT r FROM Reservation r WHERE r.amount = :amount")
})
public class Reservation implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @Column(name = "amount")
  private double amount;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservation")
  private List<Ticket> ticketList;
  @JoinColumn(name = "payment", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Payment payment;
  @JoinColumn(name = "user", referencedColumnName = "username")
  @ManyToOne(optional = false)
  private User user;

  public Reservation()
  {
  }

  public Reservation(Integer id)
  {
    this.id = id;
  }

  public Reservation(Integer id, double amount)
  {
    this.id = id;
    this.amount = amount;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public double getAmount()
  {
    return amount;
  }

  public void setAmount(double amount)
  {
    this.amount = amount;
  }

  public List<Ticket> getTicketList()
  {
    return ticketList;
  }

  public void setTicketList(List<Ticket> ticketList)
  {
    this.ticketList = ticketList;
  }

  public Payment getPayment()
  {
    return payment;
  }

  public void setPayment(Payment payment)
  {
    this.payment = payment;
  }

  public User getUser()
  {
    return user;
  }

  public void setUser(User user)
  {
    this.user = user;
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
    if (!(object instanceof Reservation))
    {
      return false;
    }
    Reservation other = (Reservation) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "airline.logic.Reservation[ id=" + id + " ]";
  }

}
