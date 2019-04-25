package ui.event;

import shape.Point;
import ui.component.Component;

public class MouseEvent extends Event {
  private final Point point;

  public MouseEvent(Component component, Point point) {
    super(component, EventType.Mouse);
    this.point = point;
  }

  public Point getPoint() {
    return point;
  }

  public static MouseEvent from(Component component, java.awt.event.MouseEvent e) {
    return new MouseEvent(component, pointOfEvent(e));
  }

  private static Point pointOfEvent(java.awt.event.MouseEvent e) {
    java.awt.Point clickLocation = e.getPoint();
    return new Point(clickLocation.x, clickLocation.y);
  }
}
