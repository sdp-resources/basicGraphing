import shape.Circle;
import shape.Point;
import ui.component.*;
import ui.event.MouseEvent;
import ui.event.Event;

public class Main implements Event.EventListener {

  private Circle circle;
  private LabeledField radiusField;
  private LabeledField xField;
  private LabeledField yField;
  private Frame frame;
  private Graphic circleArea;
  private LabeledField areaField;
  private LabeledField perimeterField;

  public static void main(String[] args) {
    new Main().run();
  }

  public void run() {
    circle = new Circle(new Point(100, 100), 50);
    frame = new Frame();
    prepareFields();
    frame.addAll(radiusField, xField, yField,
                 new Label("Click to see if the point is in the circle!"),
                 areaField, perimeterField);
    frame.addVerticalGlue();
    frame.add(circleArea);
    frame.setVisible();
  }

  private void prepareFields() {
    makeRadiusField();
    makeXField();
    makeYField();
    makeAreaField();
    makePerimeterField();
    makeCircleArea();
  }

  public void handleEvent(Event e) {
    switch (e.type) {
    case Action:
      updateCircleValuesFromFields();
      updateComputedFieldValues();
      circleArea.repaint();
      break;
    case Mouse:
      System.out.println(
          circle.contains(((MouseEvent) e).getPoint()) ?
              "Inside the circle!" :
              "NOT inside the circle!");
      break;
    }

  }

  private void updateComputedFieldValues() {
    areaField.setValue(stringFromDouble(circle.getArea()));
    perimeterField.setValue(stringFromDouble(circle.getPerimeter()));
  }

  private void updateCircleValuesFromFields() {
    circle.setRadius(radiusField.getIntValue());
    circle.setCenter(xField.getIntValue(), yField.getIntValue());
  }

  private LabeledField makeRadiusField() {
    radiusField = new LabeledField("Radius", stringFromInt(circle.getRadius()));
    radiusField.addActionListener(this);
    return radiusField;
  }

  private LabeledField makeXField() {
    xField = new LabeledField("Center x", stringFromInt(circle.getCenterX()));
    xField.addActionListener(this);
    return xField;
  }

  private LabeledField makeYField() {
    yField = new LabeledField("Center y", stringFromInt(circle.getCenterY()));
    yField.addActionListener(this);
    return yField;
  }

  private void makeCircleArea() {
    circleArea = new Graphic(circle);
    circleArea.addActionListener(this);

  }

  private void makeAreaField() {
    areaField = new LabeledField("Area of circle:",
                                 stringFromDouble(circle.getArea()));
  }

  private void makePerimeterField() {
    perimeterField = new LabeledField("Perimeter of circle:",
                                      stringFromDouble(circle.getPerimeter()));
  }

  private String stringFromInt(int radius) {
    return String.valueOf(radius);
  }

  private String stringFromDouble(double d) {
    return String.format("%.2f", d);
  }

}
