package shape;

import java.awt.*;

public class Circle {
  Point center;
  private int radius;

  public Circle(Point center, int radius) {
    this.center = center;
    this.radius = radius;
  }

  public boolean contains(Point point) {
    return radius >= center.distanceFrom(point);
  }

  public double getArea() {
    return Math.PI * radius * radius;
  }

  public double getPerimeter() {
    return 2 * Math.PI * radius;
  }

  public int getRadius() {
    return radius;
  }

  public void setRadius(int newRadius) {
    radius = newRadius;
  }

  public int getCenterY() {
    return center.y;
  }

  public int getCenterX() {
    return center.x;
  }

  public void setCenter(Integer x, Integer y) {
    center = new Point(x, y);
  }

  public void draw(Graphics g) {
    g.drawOval(center.x - radius,
               center.y - radius,
               2 * radius,
               2 * radius);
  }
}
