package app.interfaces.cells;

public interface CellInterface {

    String getId();

    int getHealth();

    int getPositionRow();

    int getPositionCol();

    int getEnergy();

    void setHealth(int health);

    void setPositionRow(int positionRow);

    void setPositionCol(int positionCol);
}
