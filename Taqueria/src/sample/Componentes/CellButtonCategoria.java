package sample.Componentes;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import sample.ModelosDAO.CategoriaDAO;
import sample.Vistas.Categoria;

public class CellButtonCategoria extends TableCell<CategoriaDAO, String> {

    private Button CellButtonCategoria;
    private int opc;
    CategoriaDAO catDAO;

    public CellButtonCategoria(int opc){
        this.opc = opc;
        if (opc == 1){
            CellButtonCategoria = new Button("Editar");
            CellButtonCategoria.setOnAction(event -> Editar());
        } else {
            CellButtonCategoria = new Button("Eliminar");
            CellButtonCategoria.setOnAction(event -> Eliminar());
        }
    }
    private void Editar(){
        catDAO = CellButtonCategoria.this.getTableView().getItems().get(CellButtonCategoria.this.getIndex());
        new Categoria(CellButtonCategoria.this.getTableView()).setCategoriaDAO(catDAO);
    }
    private void Eliminar(){
        catDAO = CellButtonCategoria.this.getTableView().getItems().get(CellButtonCategoria.this.getIndex());
        catDAO.DELETE();
        CellButtonCategoria.this.getTableView().setItems(catDAO.SELECT());
        CellButtonCategoria.this.getTableView().refresh();
    }
    @Override
    protected void updateItem(String item, boolean empty){
        super.updateItem(item, empty);
        if (!empty)
            setGraphic(CellButtonCategoria);
    }
    }
