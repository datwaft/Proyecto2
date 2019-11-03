package airline.logic;

import java.awt.Color;
import java.awt.Rectangle;

public class Seat extends Rectangle
{
  private Color color;
  private Integer row;
  private Character seat;

  public Seat(int x, int y, int width, int height)
  {
    super(x, y, width, height);
  }

  public Color getColor()
  {
    return color;
  }

  public void setColor(Color color)
  {
    this.color = color;
  }

  public Integer getRow()
  {
    return row;
  }

  public void setRow(Integer row)
  {
    this.row = row;
  }

  public Character getSeat()
  {
    return seat;
  }

  public void setSeat(Character seat)
  {
    this.seat = seat;
  }
}
