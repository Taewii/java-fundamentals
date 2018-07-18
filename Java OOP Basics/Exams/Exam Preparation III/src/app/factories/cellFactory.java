package app.factories;

import app.entities.cells.Cell;
import app.entities.cells.RedBloodCell;
import app.entities.cells.WhiteBloodCell;
import app.entities.microbes.Bacteria;
import app.entities.microbes.Fungi;
import app.entities.microbes.Virus;

public class cellFactory {
    public static Cell createCell(String cellType, String cellId, int health,
                                  int positionRow, int positionCol, int additionalProperty) {

        switch (cellType) {
            case "RedBloodCell": return new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
            case "WhiteBloodCell": return new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
            case "Bacteria": return new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
            case "Fungi": return new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
            case "Virus": return new Virus(cellId, health, positionRow, positionCol, additionalProperty);
            default: return null;
        }
    }
}
