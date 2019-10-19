package airline.logic;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "city")
@NamedQueries(
{
  @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
  @NamedQuery(name = "City.findByCode", query = "SELECT c FROM City c WHERE c.code = :code"),
  @NamedQuery(name = "City.findByName", query = "SELECT c FROM City c WHERE c.name = :name")
})
public class City implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "code")
  private String code;
  @Basic(optional = false)
  @Column(name = "name")
  private String name;
  @JoinColumns(
  {
    @JoinColumn(name = "country", referencedColumnName = "code"),
    @JoinColumn(name = "country", referencedColumnName = "code")
  })
  @ManyToOne(optional = false)
  private Country country;

  public City()
  {
  }

  public City(String code)
  {
    this.code = code;
  }

  public City(String code, String name)
  {
    this.code = code;
    this.name = name;
  }

  public String getCode()
  {
    return code;
  }

  public void setCode(String code)
  {
    this.code = code;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Country getCountry()
  {
    return country;
  }

  public void setCountry(Country country)
  {
    this.country = country;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (code != null ? code.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof City))
    {
      return false;
    }
    City other = (City) object;
    if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "airline.logic.City[ code=" + code + " ]";
  }

}
