package p05_kings_gambit_extended.models;

import p05_kings_gambit_extended.interfaces.Attackable;
import p05_kings_gambit_extended.interfaces.Responder;

import java.util.LinkedHashMap;
import java.util.Map;

public class King extends BasePerson implements Attackable {

    private Map<String, Responder> responders;

    public King(String name) {
        super(name);
        this.responders = new LinkedHashMap<>();
    }

    @Override
    public void addResponder(Responder responder) {
        this.responders.put(responder.getName(), responder);
    }

    @Override
    public void notifyResponders() {
        this.responders.values().forEach(Responder::respond);
    }

    public Responder getResponder(String name) {
        return this.responders.get(name);
    }

    @Override
    public void respond() {
        System.out.println(String.format("King %s is under attack!", super.getName()));
        notifyResponders();
    }
}
