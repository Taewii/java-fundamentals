package p01_event_implementation;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private String name;
    private List<NameChangeListener> listeners;

    public Dispatcher() {
        this.listeners = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
        NameChange event = new NameChange(name);
        this.fireNameChangeEvent(event);
    }

    public void addNameChangeListener(NameChangeListener listener) {
        this.listeners.add(listener);
    }

    public void removeNameChangeListener(NameChangeListener listener) {
        this.listeners.remove(listener);
    }

    public void fireNameChangeEvent(NameChange event) {
        this.listeners.forEach(listener -> listener.handleChangedName(event));
    }
}
