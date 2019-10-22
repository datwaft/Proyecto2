package airline.logic;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "plane")
@NamedQueries(
{
  @NamedQuery(name = "Plane.findAll", query = "SELECT p FROM Plane p"),
  @NamedQuery(name = "Plane.findByIdentifier", query = "SELECT p FROM Plane p WHERE p.identifier = :identifier")
})
public class Plane implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "identifier")
  private String identifier;
  @JoinColumn(name = "type", referencedColumnName = "identifier")
  @ManyToOne(optional = false)
  private Planetype type;

  public Plane()
  {
  }

  public Plane(String identifier)
  {
    this.identifier = identifier;
  }

  public String getIdentifier()
  {
    return identifier;
  }

  public void setIdentifier(String identifier)
  {
    this.identifier = identifier;
  }

  public Planetype getType()
  {
    return type;
  }

  public void setType(Planetype type)
  {
    this.type = type;
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
    if (!(object instanceof Plane))
    {
      return false;
    }
    Plane other = (Plane) object;
    if ((this.identifier == null && other.identifier != null) || (this.identifier != null && !this.identifier.equals(other.identifier)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "airline.logic.Plane[ identifier=" + identifier + " ]";
  }

}
