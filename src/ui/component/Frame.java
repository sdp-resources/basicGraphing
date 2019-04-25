package ui.component;

import javax.swing.*;
import javax.swing.border.Border;

public class Frame {
  private JFrame component;

  public Frame() {
    component = createFrame();
  }

  public java.awt.Component getComponent() {
    return component;
  }

  private JFrame createFrame() {
    JPanel contentPane = new JPanel();
    Border border = BorderFactory.createSoftBevelBorder(1);
    contentPane.setBorder(border);
    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
    JFrame frame = new JFrame("A circle!");
    frame.setContentPane(contentPane);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    return frame;
  }

  public void setVisible() {
    getComponent().setVisible(true);
  }

  public java.awt.Component add(Component child) {
    return component.add(child.getComponent());
  }

  public void addVerticalGlue() {
    component.add(Box.createVerticalGlue());
  }

  public void addAll(Component... fields) {
    for (Component field : fields)
      add(field);
  }
}
