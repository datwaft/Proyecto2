package airline.logic;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "trip")
@NamedQueries(
{
  @NamedQuery(name = "Trip.findAll", query = "SELECT t FROM Trip t"),
  @NamedQuery(name = "Trip.findByIdentifier", query = "SELECT t FROM Trip t WHERE t.identifier = :identifier"),
  @NamedQuery(name = "Trip.findByDeparture", query = "SELECT t FROM Trip t WHERE t.departure = :departure"),
  @NamedQuery(name = "Trip.findByArrival", query = "SELECT t FROM Trip t WHERE t.arrival = :arrival")
})
public class Trip implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "identifier")
  private Integer identifier;
  @Basic(optional = false)
  @Column(name = "departure")
  @Temporal(TemporalType.DATE)
  private Date departure;
  @Column(name = "arrival")
  @Temporal(TemporalType.DATE)
  private Date arrival;
  @JoinColumn(name = "inward", referencedColumnName = "identifier")
  @ManyToOne
  private Flight inward;
  @JoinColumn(name = "outward", referencedColumnName = "identifier")
  @ManyToOne(optional = false)
  private Flight outward;
  @JoinColumn(name = "plane", referencedColumnName = "identifier")
  @ManyToOne(optional = false)
  private Plane plane;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "trip")
  private List<Reservation> reservationList;

  public Trip()
  {
  }

  public Trip(Integer identifier)
  {
    this.identifier = identifier;
  }

  public Trip(Integer identifier, Date departure)
  {
    this.identifier = identifier;
    this.departure = departure;
  }

  public Integer getIdentifier()
  {
    return identifier;
  }

  public void setIdentifier(Integer identifier)
  {
    this.identifier = identifier;
  }

  public Date getDeparture()
  {
    return departure;
  }

  public void setDeparture(Date departure)
  {
    this.departure = departure;
  }

  public Date getArrival()
  {
    return arrival;
  }

  public void setArrival(Date arrival)
  {
    this.arrival = arrival;
  }

  public Flight getInward()
  {
    return inward;
  }

  public void setInward(Flight inward)
  {
    this.inward = inward;
  }

  public Flight getOutward()
  {
    return outward;
  }

  public void setOutward(Flight outward)
  {
    this.outward = outward;
  }

  public Plane getPlane()
  {
    return plane;
  }

  public void setPlane(Plane plane)
  {
    this.plane = plane;
  }

  public List<Reservation> getReservationList()
  {
    return reservationList;
  }

  public void setReservationList(List<Reservation> reservationList)
  {
    this.reservationList = reservationList;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (identifier != null ? identifier.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Trip))
    {
      return false;
    }
    Trip other = (Trip) object;
    if ((this.identifier == null && other.identifier != null) || (this.identifier != null && !this.identifier.equals(other.identifier)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return this.outward.toString() + " | " + this.inward.toString();
  }

}
