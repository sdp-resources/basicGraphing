package shape;

public class Point {
  final int x;
  final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  double distanceFrom(Point p) {
    int dx = x - p.x;
    int dy = y - p.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

}
