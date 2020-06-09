package sample.Componentes;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import sample.ModelosDAO.ProductoDAO;
import sample.Vistas.Producto;

public class CellButtonProducto extends TableCell<ProductoDAO, String> {
    private Button CellButtonProducto;
    private int opc;
    ProductoDAO prodDAO;

    public CellButtonProducto(int opc){
        this.opc = opc;
        if (opc == 1){
            CellButtonProducto = new Button("Editar");
            CellButtonProducto.setOnAction(event -> Editar());
        } else {
            CellButtonProducto = new Button("Eliminar");
            CellButtonProducto.setOnAction(event -> Eliminar());
        }
    }

    private void Editar(){
        prodDAO = CellButtonProducto.this.getTableView().getItems().get(CellButtonProducto.this.getIndex());
        new Producto(CellButtonProducto.this.getTableView()).setProductoDAO(prodDAO);
    }

    private void Eliminar(){
        prodDAO = CellButtonProducto.this.getTableView().getItems().get(CellButtonProducto.this.getIndex());
        prodDAO.DELETE();
        CellButtonProducto.this.getTableView().setItems(prodDAO.SELECT());
        CellButtonProducto.this.getTableView().refresh();
    }

    @Override
    protected void updateItem(String item, boolean empty){
        super.updateItem(item, empty);
        if (!empty)
            setGraphic(CellButtonProducto);
    }
}
