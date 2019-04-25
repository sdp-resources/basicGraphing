package ui.component;

import ui.event.Event;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Component {
  protected java.awt.Component component;
  protected List<Event.EventListener> listeners = new ArrayList<>();

  public Component() {
    this.component = new JPanel(new BorderLayout());
  }

  public java.awt.Component getComponent() {
    return component;
  }

  public void addActionListener(Event.EventListener listener) {
    listeners.add(listener);
  }
}
