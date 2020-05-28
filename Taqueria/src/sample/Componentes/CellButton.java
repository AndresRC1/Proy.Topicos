package sample.Componentes;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import sample.ModelosDAO.ProveedoresDAO;
import sample.Vistas.Proveedor;

public class CellButton extends TableCell<ProveedoresDAO, String> {

    private Button cellButton;
    private int opc;
    ProveedoresDAO provDAO;

    public CellButton(int opc){
        this.opc = opc;
        if (opc == 1){
            cellButton = new Button("Editar");
            cellButton.setOnAction(event -> Editar());
        } else {
            cellButton = new Button("Eliminar");
            cellButton.setOnAction(event -> Eliminar());
        }
    }

    private void Editar(){
        provDAO = CellButton.this.getTableView().getItems().get(CellButton.this.getIndex());
        new Proveedor(CellButton.this.getTableView()).setProveedoresDAO(provDAO);
    }

    private void Eliminar(){
        provDAO = CellButton.this.getTableView().getItems().get(CellButton.this.getIndex());
        provDAO.DELETE();
        CellButton.this.getTableView().setItems(provDAO.SELECT());
        CellButton.this.getTableView().refresh();
    }

    @Override
    protected void updateItem(String item, boolean empty){
        super.updateItem(item, empty);
        if (!empty)
            setGraphic(cellButton);
    }
}
