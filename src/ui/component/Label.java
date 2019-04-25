package ui.component;

import javax.swing.*;

public class Label extends Component {
  private final JLabel component;

  public Label(String label) {
    this.component = new JLabel(label);
  }

  public java.awt.Component getComponent() {
    return component;
  }
}
