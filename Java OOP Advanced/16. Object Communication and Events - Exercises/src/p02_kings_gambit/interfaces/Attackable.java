package p02_kings_gambit.interfaces;

public interface Attackable {

    void addResponder(Responder responder);

    void respond();

    void notifyResponders();
}
