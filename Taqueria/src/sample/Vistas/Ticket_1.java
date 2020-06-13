package sample.Vistas;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.awt.*;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

public class Ticket_1 implements Initializable {

    private Scene scene;
    Button bebidaPDF;
    public static final String DEST = "results/chapter01/productos.pdf";


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void ini() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación de Impresión de Productos");
        alert.setHeaderText("Estás a punto de imprimir la lista de productos");
        alert.setContentText("¿Deseas continuar?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            create();
        } else {

        }
    }

    public void create(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/taqueria", "root", "RACA971201");
            Statement estado = con.createStatement();
            ResultSet resultado = estado.executeQuery(" SELECT p.id_producto, p.nombre_producto, p.descripcion, p.cantidad, p.costo, p2.nombre_proveedor, c.categoria FROM proveedor p2 INNER JOIN producto p ON p2.id_proveedor = p.id_proveedor LEFT JOIN categoria_producto c ON p.id_categoria = c.id_categoria ");

            OutputStream file = new FileOutputStream(new File("results/chapter01/productos.pdf"));
            Document document = new Document();


            PdfWriter.getInstance(document, file);

            document.open();
            PdfPTable tabla = new PdfPTable(7);
            Paragraph p = new Paragraph("Lista de Productos de la Taquería.\n\n", FontFactory.getFont("Arial",16, Font.ITALIC, BaseColor.RED));

            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);

            document.add(new Paragraph(""));



            float[] mediaCeldas ={3.30f,3.50f,3.50f,3.70f,3.70f,3.70f,3.70f};

            tabla.setWidths(mediaCeldas);
            tabla.addCell(new Paragraph("Id_producto", FontFactory.getFont("Arial",12)));
            tabla.addCell(new Paragraph("Nombre_producto", FontFactory.getFont("Arial",12)));
            tabla.addCell(new Paragraph("Descripcion", FontFactory.getFont("Arial",12)));
            tabla.addCell(new Paragraph("Cantidad", FontFactory.getFont("Arial",12)));
            tabla.addCell(new Paragraph("Costo", FontFactory.getFont("Arial",12)));
            tabla.addCell(new Paragraph("Id_proveedor", FontFactory.getFont("Arial",12)));
            tabla.addCell(new Paragraph("Id_categoria", FontFactory.getFont("Arial",12)));



            while (resultado.next()){
                tabla.addCell(new Paragraph(String.valueOf(resultado.getInt("id_producto")), FontFactory.getFont("Arial",10)));
                tabla.addCell(new Paragraph(resultado.getString("nombre_producto"), FontFactory.getFont("Arial",10)));
                tabla.addCell(new Paragraph(resultado.getString("descripcion"), FontFactory.getFont("Arial",10)));
                tabla.addCell(new Paragraph(String.valueOf(resultado.getInt("cantidad")), FontFactory.getFont("Arial",10)));
                tabla.addCell(new Paragraph(String.valueOf(resultado.getDouble("costo")), FontFactory.getFont("Arial",10)));
                tabla.addCell(new Paragraph(resultado.getString("nombre_proveedor"), FontFactory.getFont("Arial",10)));
                tabla.addCell(new Paragraph(resultado.getString("categoria"), FontFactory.getFont("Arial",10)));
            }

            document.add(tabla);
            document.close();
            file.close();


        }

        catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }



        try {
            File file = new File("results/chapter01/productos.pdf");
            Desktop.getDesktop().open(file);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }
}