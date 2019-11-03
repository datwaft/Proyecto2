package airline.logic;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "flight")
@NamedQueries(
{
  @NamedQuery(name = "Flight.findAll", query = "SELECT f FROM Flight f"),
  @NamedQuery(name = "Flight.findByIdentifier", query = "SELECT f FROM Flight f WHERE f.identifier = :identifier"),
  @NamedQuery(name = "Flight.findByWeekday", query = "SELECT f FROM Flight f WHERE f.weekday = :weekday"),
  @NamedQuery(name = "Flight.findByDeparture", query = "SELECT f FROM Flight f WHERE f.departure = :departure"),
  @NamedQuery(name = "Flight.findByDuration", query = "SELECT f FROM Flight f WHERE f.duration = :duration"),
  @NamedQuery(name = "Flight.findByArrival", query = "SELECT f FROM Flight f WHERE f.arrival = :arrival"),
  @NamedQuery(name = "Flight.findByPrice", query = "SELECT f FROM Flight f WHERE f.price = :price"),
  @NamedQuery(name = "Flight.findByDiscount", query = "SELECT f FROM Flight f WHERE f.discount = :discount")
})
public class Flight implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "identifier")
  private Integer identifier;
  @Basic(optional = false)
  @Column(name = "weekday")
  private int weekday;
  @Basic(optional = false)
  @Column(name = "departure")
  @Temporal(TemporalType.TIME)
  private Date departure;
  @Basic(optional = false)
  @Column(name = "duration")
  @Temporal(TemporalType.TIME)
  private Date duration;
  @Column(name = "arrival", insertable = false, updatable = false)
  @Temporal(TemporalType.TIME)
  private Date arrival;
  @Basic(optional = false)
  @Column(name = "price")
  private double price;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Basic(optional = false)
  @Column(name = "discount")
  private BigDecimal discount;
  @JoinColumn(name = "origin", referencedColumnName = "code")
  @ManyToOne(optional = false)
  private City origin;
  @JoinColumn(name = "destination", referencedColumnName = "code")
  @ManyToOne(optional = false)
  private City destination;
  @OneToMany(mappedBy = "inward")
  private List<Trip> tripList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "outward")
  private List<Trip> tripList1;

  public Flight()
  {
  }

  public Flight(Integer identifier)
  {
    this.identifier = identifier;
  }

  public Flight(Integer identifier, int weekday, Date departure, Date duration, double price, BigDecimal discount)
  {
    this.identifier = identifier;
    this.weekday = weekday;
    this.departure = departure;
    this.duration = duration;
    this.price = price;
    this.discount = discount;
  }

  public Integer getIdentifier()
  {
    return identifier;
  }

  public void setIdentifier(Integer identifier)
  {
    this.identifier = identifier;
  }

  public int getWeekday()
  {
    return weekday;
  }

  public void setWeekday(int weekday)
  {
    this.weekday = weekday;
  }

  public Date getDeparture()
  {
    return departure;
  }

  public void setDeparture(Date departure)
  {
    this.departure = departure;
  }

  public Date getDuration()
  {
    return duration;
  }

  public void setDuration(Date duration)
  {
    this.duration = duration;
  }

  public Date getArrival()
  {
    return arrival;
  }

  public void setArrival(Date arrival)
  {
    this.arrival = arrival;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public BigDecimal getDiscount()
  {
    return discount;
  }

  public void setDiscount(BigDecimal discount)
  {
    this.discount = discount;
  }

  public City getOrigin()
  {
    return origin;
  }

  public void setOrigin(City origin)
  {
    this.origin = origin;
  }

  public City getDestination()
  {
    return destination;
  }

  public void setDestination(City destination)
  {
    this.destination = destination;
  }

  public List<Trip> getTripList()
  {
    return tripList;
  }

  public void setTripList(List<Trip> tripList)
  {
    this.tripList = tripList;
  }

  public List<Trip> getTripList1()
  {
    return tripList1;
  }

  public void setTripList1(List<Trip> tripList1)
  {
    this.tripList1 = tripList1;
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
    if (!(object instanceof Flight))
    {
      return false;
    }
    Flight other = (Flight) object;
    if ((this.identifier == null && other.identifier != null) || (this.identifier != null && !this.identifier.equals(other.identifier)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return this.origin.getName() + " - " + this.destination.getName()+ " " + this.identifier;
  }

}
