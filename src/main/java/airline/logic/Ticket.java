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
  @NamedQuery(name = "Ticket.findByRow", query = "SELECT t FROM Ticket t WHERE t.row = :row"),
  @NamedQuery(name = "Ticket.findBySeat", query = "SELECT t FROM Ticket t WHERE t.seat = :seat")
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
  @Column(name = "row")
  private int row;
  @Basic(optional = false)
  @Column(name = "seat")
  private String seat;
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

  public Ticket(Integer id, String name, int row, String seat)
  {
    this.id = id;
    this.name = name;
    this.row = row;
    this.seat = seat;
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

  public int getRow()
  {
    return row;
  }

  public void setRow(int row)
  {
    this.row = row;
  }

  public String getSeat()
  {
    return seat;
  }

  public void setSeat(String seat)
  {
    this.seat = seat;
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
