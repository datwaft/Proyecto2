package airline.logic;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "ticket")
@NamedQueries(
{
  @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
  @NamedQuery(name = "Ticket.findById", query = "SELECT t FROM Ticket t WHERE t.id = :id"),
  @NamedQuery(name = "Ticket.findByName", query = "SELECT t FROM Ticket t WHERE t.name = :name"),
  @NamedQuery(name = "Ticket.findByRownumber", query = "SELECT t FROM Ticket t WHERE t.rownumber = :rownumber"),
  @NamedQuery(name = "Ticket.findBySeatletter", query = "SELECT t FROM Ticket t WHERE t.seatletter = :seatletter")
})
public class Ticket implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @Column(name = "name")
  private String name;
  @Basic(optional = false)
  @Column(name = "rownumber")
  private int rownumber;
  @Basic(optional = false)
  @Column(name = "seatletter")
  private String seatletter;
  @JoinColumn(name = "reservation", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Reservation reservation;

  public Ticket()
  {
  }

  public Ticket(Integer id)
  {
    this.id = id;
  }

  public Ticket(Integer id, String name, int rownumber, String seatletter)
  {
    this.id = id;
    this.name = name;
    this.rownumber = rownumber;
    this.seatletter = seatletter;
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

  public int getRownumber()
  {
    return rownumber;
  }

  public void setRownumber(int rownumber)
  {
    this.rownumber = rownumber;
  }

  public String getSeatletter()
  {
    return seatletter;
  }

  public void setSeatletter(String seatletter)
  {
    this.seatletter = seatletter;
  }

  public Reservation getReservation()
  {
    return reservation;
  }

  public void setReservation(Reservation reservation)
  {
    this.reservation = reservation;
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
    if (!(object instanceof Ticket))
    {
      return false;
    }
    Ticket other = (Ticket) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "airline.logic.Ticket[ id=" + id + " ]";
  }

}
