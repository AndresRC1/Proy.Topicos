package sample.Componentes;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import sample.ModelosDAO.CompraDAO;
import sample.Vistas.Compra;
import sample.Vistas.Producto;

public class CellButtonCompra extends TableCell<CompraDAO, String> {
    private Button CellButtonCompra;
    private int opc;
    CompraDAO comDAO;

    public CellButtonCompra(int opc){
        this.opc = opc;
        if (opc == 1){
            CellButtonCompra = new Button("Editar");
            CellButtonCompra.setOnAction(event -> Editar());
        } else {
            CellButtonCompra = new Button("Eliminar");
            CellButtonCompra.setOnAction(event -> Eliminar());
        }
    }

    private void Editar(){
        comDAO = CellButtonCompra.this.getTableView().getItems().get(CellButtonCompra.this.getIndex());
        new Compra(CellButtonCompra.this.getTableView()).setCompraDAO(comDAO);
    }

    private void Eliminar(){
        comDAO = CellButtonCompra.this.getTableView().getItems().get(CellButtonCompra.this.getIndex());
        comDAO.DELETE();
        CellButtonCompra.this.getTableView().setItems(comDAO.SELECT());
        CellButtonCompra.this.getTableView().refresh();
    }

    @Override
    protected void updateItem(String item, boolean empty){
        super.updateItem(item, empty);
        if (!empty)
            setGraphic(CellButtonCompra);
    }
}
