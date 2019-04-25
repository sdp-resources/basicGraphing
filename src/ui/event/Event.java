package ui.event;

import ui.component.Component;

public class Event {
  public EventType type;
  private Component component;

  public Event(Component component) {
    this(component, EventType.Action);
  }

  public Event(Component component, EventType type) {
    this.type = type;
    this.component = component;
  }

  public Component getComponent() {
    return component;
  }

  public interface EventListener {
    void handleEvent(Event event);
  }

  public enum EventType {
    Action, Mouse
  }
}
