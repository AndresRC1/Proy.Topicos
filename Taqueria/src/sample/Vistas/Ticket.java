package sample.Vistas;



import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.List;

public class Ticket {
    public static final String DATA = "src/resources/united_states.csv";
    public void createPdf(String dest, List<compra_detalle> comdetaList) throws IOException {

        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf, PageSize.A4.rotate());
        document.setMargins(20, 20, 20, 20);

        PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
        Table table = new Table(new float[]{5,5});
        process(table, null, bold, true);
        for (compra_detalle e: comdetaList) {
            process(table, e, font, false);
        }
        document.add(table);

        //Close document
        document.close();



    }
    public void process(Table table, compra_detalle comdeta, PdfFont font, boolean isHeader){
        if (isHeader) {
            table.addHeaderCell(new Cell().add(new Paragraph("id_compra").setFont(font)));
            table.addHeaderCell(new Cell().add(new Paragraph("id_orden").setFont(font)));
            table.addHeaderCell(new Cell().add(new Paragraph("id_producto").setFont(font)));
            table.addHeaderCell(new Cell().add(new Paragraph("cantidad").setFont(font)));
            table.addHeaderCell(new Cell().add(new Paragraph("precio_unitario").setFont(font)));
        }
        else {
            table.addCell(new Cell().add(new Paragraph(" "+comdeta.getId_compra()).setFont(font)));
            table.addCell(new Cell().add(new Paragraph(" "+comdeta.getId_orden()).setFont(font)));
            table.addCell(new Cell().add(new Paragraph(" "+comdeta.geId_producto()).setFont(font)));
            table.addCell(new Cell().add(new Paragraph(" "+comdeta.getCantidad()).setFont(font)));
            table.addCell(new Cell().add(new Paragraph(" "+comdeta.getPrecio_unitario()).setFont(font)));
        }
    }
}
