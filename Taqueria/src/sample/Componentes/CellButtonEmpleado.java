package sample.Componentes;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import sample.ModelosDAO.EmpleadoDAO;
import sample.Vistas.Empleado;

public class CellButtonEmpleado extends TableCell<EmpleadoDAO, String> {
    private Button CellButtonEmpleado;
    private int opc;
    EmpleadoDAO empDAO;

    public CellButtonEmpleado(int opc){
        this.opc = opc;
        if (opc == 1){
            CellButtonEmpleado = new Button("Editar");
            CellButtonEmpleado.setOnAction(event -> Editar());
    }else{
            CellButtonEmpleado = new Button("Eliminar");
            CellButtonEmpleado.setOnAction(event -> Eliminar());
        }
}
private void Editar() {
    empDAO = CellButtonEmpleado.this.getTableView().getItems().get(CellButtonEmpleado.this.getIndex());
    new Empleado(CellButtonEmpleado.this.getTableView()).setEmpleadoDAO(empDAO);
}
    private void Eliminar(){
        empDAO = CellButtonEmpleado.this.getTableView().getItems().get(CellButtonEmpleado.this.getIndex());
        empDAO.DELETE();
        CellButtonEmpleado.this.getTableView().setItems(empDAO.SELECT());
        CellButtonEmpleado.this.getTableView().refresh();
    }
    @Override
    protected void updateItem(String item, boolean empty){
        super.updateItem(item, empty);
        if (!empty)
            setGraphic(CellButtonEmpleado);
    }
}
