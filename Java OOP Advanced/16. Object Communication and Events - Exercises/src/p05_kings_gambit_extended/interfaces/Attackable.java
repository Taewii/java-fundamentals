package p05_kings_gambit_extended.interfaces;

public interface Attackable {

    void addResponder(Responder responder);

    void respond();

    void notifyResponders();
}
