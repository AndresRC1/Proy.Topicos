package sample.Componentes;

import javafx.scene.control.Button;
import sample.ModelosDAO.Compra_detalleDAO;
import javafx.scene.control.TableCell;
import sample.Vistas.compra_detalle;

public class CellButtonCompra_detalle extends TableCell<Compra_detalleDAO, String> {
private Button CellButtonCompra_detalle;
private int opc;
        Compra_detalleDAO cdDAO;

public CellButtonCompra_detalle(int opc){
        this.opc = opc;
        if (opc == 1){
            CellButtonCompra_detalle = new Button("Editar");
            CellButtonCompra_detalle.setOnAction(event -> Editar());
        } else {
            CellButtonCompra_detalle = new Button("Eliminar");
            CellButtonCompra_detalle.setOnAction(event -> Eliminar());
        }
        }

private void Editar(){
    cdDAO = CellButtonCompra_detalle.this.getTableView().getItems().get(CellButtonCompra_detalle.this.getIndex());
        new compra_detalle(CellButtonCompra_detalle.this.getTableView()).setCompra_detalleDAO(cdDAO);
        }

private void Eliminar(){
    cdDAO = CellButtonCompra_detalle.this.getTableView().getItems().get(CellButtonCompra_detalle.this.getIndex());
    cdDAO.DELETE();
    CellButtonCompra_detalle.this.getTableView().setItems(cdDAO.SELECT());
    CellButtonCompra_detalle.this.getTableView().refresh();
        }

    private void Imprimir(){
        cdDAO = CellButtonCompra_detalle.this.getTableView().getItems().get(CellButtonCompra_detalle.this.getIndex());
        new compra_detalle(CellButtonCompra_detalle.this.getTableView()).setCompra_detalleDAO(cdDAO);
    }



    @Override
protected void updateItem(String item, boolean empty){
        super.updateItem(item, empty);
        if (!empty)
        setGraphic(CellButtonCompra_detalle);
        }
        }
