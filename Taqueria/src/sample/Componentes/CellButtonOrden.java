package sample.Componentes;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import sample.ModelosDAO.OrdenDAO;
import sample.Vistas.Orden;

public class CellButtonOrden extends TableCell<OrdenDAO, String> {

    private Button CellButtonOrden;
    private int opc;
    OrdenDAO ordDAO;

    public CellButtonOrden(int opc){
        this.opc = opc;
        if (opc == 1){
            CellButtonOrden = new Button("Editar");
            CellButtonOrden.setOnAction(event -> Editar());
        } else {
            CellButtonOrden = new Button("Cancelar");
            CellButtonOrden.setOnAction(event -> Cancelar());
        }
    }
    private void Editar(){
        ordDAO = CellButtonOrden.this.getTableView().getItems().get(CellButtonOrden.this.getIndex());
        new Orden(CellButtonOrden.this.getTableView()).setOrdenDAO(ordDAO);
    }

    private void Cancelar(){
        ordDAO = CellButtonOrden.this.getTableView().getItems().get(CellButtonOrden.this.getIndex());
        ordDAO.DELETE();
        CellButtonOrden.this.getTableView().setItems(ordDAO.SELECT());
        CellButtonOrden.this.getTableView().refresh();
    }
    @Override
    protected void updateItem(String item, boolean empty){
        super.updateItem(item, empty);
        if (!empty)
            setGraphic(CellButtonOrden);
    }
}
