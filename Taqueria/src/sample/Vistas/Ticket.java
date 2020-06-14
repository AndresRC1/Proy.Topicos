package sample.Vistas;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import sample.ModelosDAO.Compra_detalleDAO;

import java.awt.*;
import java.awt.Font;
import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

public class Ticket implements Initializable {

    public static final String DEST = "results/chapter01/compra_detalle.pdf";


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void ini() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación de Impresión de Compra detalle");
        alert.setHeaderText("Estás a punto de imprimir la compra detalle");
        alert.setContentText("¿Deseas continuar?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            create();
        } else {
        }
    }

    public void imprimirSeleccion(Compra_detalleDAO compra){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación de Impresión de Compra detalle");
        alert.setHeaderText("Estás a punto de imprimir la compra detalle");
        alert.setContentText("¿Deseas continuar?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            try {
                String sql = "SELECT cd.id_compra, cd.id_orden, c.fecha, p.nombre_producto, cd.cantidad, cd.precio_unitario, (cd.cantidad*cd.precio_unitario) as sumatoria \n" +
                        "from compra_detalle cd INNER JOIN producto p ON cd.id_producto=p.id_producto \n" +
                        "\t\t\t\t\t   INNER JOIN compra c ON cd.id_compra=c.id_compra \n" +
                        "                       where cd.id_compra = "+ compra.getId_compra();
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/taqueria", "root", "1234");
                Statement estado = con.createStatement();
                ResultSet resultado = estado.executeQuery(sql);

                OutputStream file = new FileOutputStream(new File("results/chapter01/Ticket.pdf"));
                Document document = new Document();


                PdfWriter.getInstance(document, file);

                document.open();
                PdfPTable tabla = new PdfPTable(7);
                Paragraph p = new Paragraph("compra_detalle.\n\n", FontFactory.getFont("Arial", 16, Font.ITALIC, BaseColor.RED));

                p.setAlignment(Element.ALIGN_CENTER);
                document.add(p);

                document.add(new Paragraph(""));

                float[] mediaCeldas = {3.30f, 3.50f, 3.50f, 3.70f, 3.70f, 3.70f, 3.70f};

                tabla.setWidths(mediaCeldas);
                tabla.addCell(new Paragraph("Id_compra", FontFactory.getFont("Arial", 12)));
                tabla.addCell(new Paragraph("id_orden", FontFactory.getFont("Arial", 12)));
                tabla.addCell(new Paragraph("fecha", FontFactory.getFont("Arial", 12)));
                tabla.addCell(new Paragraph("id_producto", FontFactory.getFont("Arial", 12)));
                tabla.addCell(new Paragraph("cantidad", FontFactory.getFont("Arial", 12)));
                tabla.addCell(new Paragraph("precio_unitario", FontFactory.getFont("Arial", 12)));
                tabla.addCell(new Paragraph("sumatoria", FontFactory.getFont("Arial", 12)));

                while (resultado.next()) {
                    tabla.addCell(new Paragraph(String.valueOf(resultado.getInt("id_compra")), FontFactory.getFont("Arial", 10)));
                    tabla.addCell(new Paragraph(String.valueOf(resultado.getInt("id_orden")), FontFactory.getFont("Arial", 10)));
                    tabla.addCell(new Paragraph(resultado.getString("fecha"), FontFactory.getFont("Arial", 10)));
                    tabla.addCell(new Paragraph(resultado.getString("nombre_producto"), FontFactory.getFont("Arial", 10)));
                    tabla.addCell(new Paragraph(String.valueOf(resultado.getInt("cantidad")), FontFactory.getFont("Arial", 10)));
                    tabla.addCell(new Paragraph(String.valueOf(resultado.getInt("precio_unitario")), FontFactory.getFont("Arial", 10)));
                    tabla.addCell(new Paragraph(String.valueOf(resultado.getInt("sumatoria")), FontFactory.getFont("Arial", 12)));
                }

                document.add(tabla);
                document.close();
                file.close();
            } catch (SQLException | DocumentException | FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                File file = new File("results/chapter01/Ticket.pdf");
                Desktop.getDesktop().open(file);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        } else {
        }
    }

    public void create() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/taqueria", "root", "1234");
            Statement estado = con.createStatement();
            ResultSet resultado = estado.executeQuery("   SELECT cd.id_compra, cd.id_orden, c.fecha, p.nombre_producto, cd.cantidad, cd.precio_unitario,  \n" +
                    "                    (cd.cantidad*cd.precio_unitario) as sumatoria from compra_detalle cd \n" +
                    "                       INNER JOIN producto p ON cd.id_producto=p.id_producto \n" +
                    "                       INNER JOIN compra c ON cd.id_compra=c.id_compra order by 1,2,3,4,5,6");

            OutputStream file = new FileOutputStream(new File("results/chapter01/compra_detalle.pdf"));
            Document document = new Document();


            PdfWriter.getInstance(document, file);

            document.open();
            PdfPTable tabla = new PdfPTable(7);
            Paragraph p = new Paragraph("compra_detalle.\n\n", FontFactory.getFont("Arial", 16, Font.ITALIC, BaseColor.RED));

            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);

            document.add(new Paragraph(""));

            float[] mediaCeldas = {3.30f, 3.50f, 3.50f, 3.70f, 3.70f, 3.70f, 3.70f};

            tabla.setWidths(mediaCeldas);
            tabla.addCell(new Paragraph("Id_compra", FontFactory.getFont("Arial", 12)));
            tabla.addCell(new Paragraph("id_orden", FontFactory.getFont("Arial", 12)));
            tabla.addCell(new Paragraph("fecha", FontFactory.getFont("Arial", 12)));
            tabla.addCell(new Paragraph("id_producto", FontFactory.getFont("Arial", 12)));
            tabla.addCell(new Paragraph("cantidad", FontFactory.getFont("Arial", 12)));
            tabla.addCell(new Paragraph("precio_unitario", FontFactory.getFont("Arial", 12)));
            tabla.addCell(new Paragraph("sumatoria", FontFactory.getFont("Arial", 12)));

            while (resultado.next()) {
                tabla.addCell(new Paragraph(String.valueOf(resultado.getInt("id_compra")), FontFactory.getFont("Arial", 10)));
                tabla.addCell(new Paragraph(String.valueOf(resultado.getInt("id_orden")), FontFactory.getFont("Arial", 10)));
                tabla.addCell(new Paragraph(resultado.getString("fecha"), FontFactory.getFont("Arial", 10)));
                tabla.addCell(new Paragraph(resultado.getString("nombre_producto"), FontFactory.getFont("Arial", 10)));
                tabla.addCell(new Paragraph(String.valueOf(resultado.getInt("cantidad")), FontFactory.getFont("Arial", 10)));
                tabla.addCell(new Paragraph(String.valueOf(resultado.getInt("precio_unitario")), FontFactory.getFont("Arial", 10)));
                tabla.addCell(new Paragraph(String.valueOf(resultado.getInt("sumatoria")), FontFactory.getFont("Arial", 12)));
            }

            document.add(tabla);
            document.close();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            File file = new File("results/chapter01/compra_detalle.pdf");
            Desktop.getDesktop().open(file);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}