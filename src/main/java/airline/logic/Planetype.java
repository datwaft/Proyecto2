package airline.logic;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "planetype")
@NamedQueries(
{
  @NamedQuery(name = "Planetype.findAll", query = "SELECT p FROM Planetype p"),
  @NamedQuery(name = "Planetype.findByIdentifier", query = "SELECT p FROM Planetype p WHERE p.identifier = :identifier"),
  @NamedQuery(name = "Planetype.findByYear", query = "SELECT p FROM Planetype p WHERE p.year = :year"),
  @NamedQuery(name = "Planetype.findByModel", query = "SELECT p FROM Planetype p WHERE p.model = :model"),
  @NamedQuery(name = "Planetype.findByBrand", query = "SELECT p FROM Planetype p WHERE p.brand = :brand"),
  @NamedQuery(name = "Planetype.findByRownumber", query = "SELECT p FROM Planetype p WHERE p.rownumber = :rownumber"),
  @NamedQuery(name = "Planetype.findByRowseats", query = "SELECT p FROM Planetype p WHERE p.rowseats = :rowseats")
})
public class Planetype implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "identifier")
  private String identifier;
  @Basic(optional = false)
  @Column(name = "year")
  private int year;
  @Basic(optional = false)
  @Column(name = "model")
  private String model;
  @Basic(optional = false)
  @Column(name = "brand")
  private String brand;
  @Basic(optional = false)
  @Column(name = "rownumber")
  private int rownumber;
  @Basic(optional = false)
  @Column(name = "rowseats")
  private int rowseats;

  public Planetype()
  {
  }

  public Planetype(String identifier)
  {
    this.identifier = identifier;
  }

  public Planetype(String identifier, int year, String model, String brand, int rownumber, int rowseats)
  {
    this.identifier = identifier;
    this.year = year;
    this.model = model;
    this.brand = brand;
    this.rownumber = rownumber;
    this.rowseats = rowseats;
  }

  public String getIdentifier()
  {
    return identifier;
  }

  public void setIdentifier(String identifier)
  {
    this.identifier = identifier;
  }

  public int getYear()
  {
    return year;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public String getModel()
  {
    return model;
  }

  public void setModel(String model)
  {
    this.model = model;
  }

  public String getBrand()
  {
    return brand;
  }

  public void setBrand(String brand)
  {
    this.brand = brand;
  }

  public int getRownumber()
  {
    return rownumber;
  }

  public void setRownumber(int rownumber)
  {
    this.rownumber = rownumber;
  }

  public int getRowseats()
  {
    return rowseats;
  }

  public void setRowseats(int rowseats)
  {
    this.rowseats = rowseats;
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
    if (!(object instanceof Planetype))
    {
      return false;
    }
    Planetype other = (Planetype) object;
    if ((this.identifier == null && other.identifier != null) || (this.identifier != null && !this.identifier.equals(other.identifier)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "airline.logic.Planetype[ identifier=" + identifier + " ]";
  }

}
