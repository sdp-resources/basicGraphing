package ui.component;

import shape.Circle;
import ui.event.MouseEvent;
import ui.event.Event.EventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Graphic extends Component {
  private final JPanel component;
  private final GraphicMouseListener graphicMouseListener =
      new GraphicMouseListener(this);
  private Circle shape;

  public Graphic(Circle shape) {
    this.shape = shape;
    component = createComponent();
  }

  public static void draw(Circle circle, Graphics g) {
    g.drawOval(circle.getCenterX() - circle.getRadius(),
               circle.getCenterY() - circle.getRadius(),
               2 * circle.getRadius(),
               2 * circle.getRadius());
  }

  public JComponent getComponent() {
    return component;
  }

  public void addActionListener(EventListener listener) {
    graphicMouseListener.addHandler(listener);
  }

  private JPanel createComponent() {
    JPanel panel = new JPanel(new BorderLayout()) {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(shape, g);
      }
    };
    panel.addMouseListener(graphicMouseListener);
    panel.setMinimumSize(new Dimension(300, 300));
    return panel;
  }

  public void repaint() {
    component.repaint();
  }

  private static class GraphicMouseListener implements MouseListener {
    private final List<EventListener> handlers = new ArrayList<>();
    private Component component;

    public GraphicMouseListener(Component component) {
      this.component = component;
    }

    private void addHandler(EventListener handler) {
      handlers.add(handler);
    }

    public void mouseClicked(java.awt.event.MouseEvent e) {
      MouseEvent event = MouseEvent.from(component, e);
      for (EventListener handler : handlers) {
        handler.handleEvent(event);
      }
    }

    public void mousePressed(java.awt.event.MouseEvent e) { }

    public void mouseReleased(java.awt.event.MouseEvent e) { }

    public void mouseEntered(java.awt.event.MouseEvent e) { }

    public void mouseExited(java.awt.event.MouseEvent e) { }
  }
}
