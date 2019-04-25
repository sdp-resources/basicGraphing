package ui.component;

import ui.event.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LabeledField extends Component {
  private JTextField textField;

  public LabeledField(String label, String initialText) {
    super();
    ;
    setUpPanel(label, initialText);
  }

  private void setUpPanel(String label, String initialText) {
    JPanel componentPanel = (JPanel) component;
    componentPanel.add(new Label(label).getComponent(), BorderLayout.LINE_START);
    textField = new JTextField(initialText, 8);
    textField.addActionListener(this::actOn);
    textField.setHorizontalAlignment(JTextField.RIGHT);
    componentPanel.add(textField, BorderLayout.LINE_END);
    componentPanel.setMaximumSize(new Dimension(300, 40));
  }

  private void actOn(ActionEvent e) {
    Event event = new Event(this);
    for (Event.EventListener handler : listeners) {
      handler.handleEvent(event);
    }
  }

  public String getValue() {
    return textField.getText();
  }

  public Integer getIntValue() {
    return Integer.valueOf(getValue());
  }

  public void setValue(String s) {
    textField.setText(s);
  }
}
