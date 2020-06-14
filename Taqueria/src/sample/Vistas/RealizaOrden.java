package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.ModelosDAO.Compra_detalleDAO;
import sample.ModelosDAO.Conexion;

import java.sql.Connection;

public class RealizaOrden extends Stage {

    public Scene escena;
    private Label lblTacos, lblCombos, lblBebidas, lblOtros;
    private Label lblT1, lblT2, lblT3, lblT4;
    private Label lblC1, lblC2, lblC3, lblC4;
    private Label lblB1, lblB2, lblB3, lblB4;
    private Label lblO1, lblO2, lblO3, lblO4;
    private Button btnt1, btnt2, btnt3, btnt4, btnt5, btnt6, btnt7, btnt8;
    private Button btnc1, btnc2, btnc3, btnc4, btnc5, btnc6, btnc7, btnc8;
    private Button btnb1, btnb2, btnb3, btnb4, btnb5, btnb6, btnb7, btnb8;
    private Button btno1, btno2, btno3, btno4, btno5, btno6, btno7, btno8;
    private TextField txtt1,txtt2,txtt3,txtt4,txtc1,txtc2,txtc3,txtc4;
    private TextField txtb1,txtb2,txtb3,txtb4,txto1,txto2,txto3,txto4;
    private Button btnTicket, btnCancelar;
    private HBox hboxTa,hboximaT,hboxbtnT,hboxTCom,hboximaC,hboxbtnC,hboxTBe, hboximaB,hboxbtnB,hboxTOt,hboximaO,hboxbtnO, hboxbtnPDF;
    private VBox vBox;
    public RealizaOrden(){
        CreatGUI();
        escena = new Scene(vBox,1000,500);
        setScene(escena);
        //escena.getStylesheets().add("sample/Estilos/estilo_mesero.css");
        setTitle("Menu mesero (Seleccionar platillos)");
        //setMaximized(true);
        //escena.getStylesheets().add(getClass().getResource("../Estilos/estilos_principal.css").toExternalForm());
        show();

    }

    private void CreatGUI() {

        btnTicket=new Button("Ticket");
        btnTicket.setOnAction(event -> CrearTicket());
        btnCancelar=new Button("Cancelar");
        //btnt1.setOnAction(event -> EventoItem(1));

        lblTacos=new Label();
        lblTacos.setText("------------TACOS-----------");
        lblT1=new Label();
        lblT1.setGraphic(new ImageView("sample/Imagenes/tacoChori.jpg"));
        lblT1.setMinHeight(50.0);
        lblT2=new Label();
        lblT2.setGraphic(new ImageView("sample/Imagenes/tacoPasto.png"));
        lblT2.setMinHeight(50.0);
        lblT3=new Label();
        lblT3.setGraphic(new ImageView("sample/Imagenes/tacosAsada.png"));
        lblT3.setMinHeight(50.0);
        lblT4=new Label();
        lblT4.setGraphic(new ImageView("sample/Imagenes/tacosTripa.jpg"));
        lblT4.setMinHeight(50.0);

        btnt1= new Button("+");
        //btnt1.setOnAction(event -> EventoItem(1));
        txtt1=new TextField();
        txtt1.setStyle("-fx-translate-y: 2");
        txtt1.setStyle("-fx-background-radius: 2");
        btnt2 =new Button("-");
        //btnt1.setOnAction(event -> EventoItem(1));

        btnt3=new Button("+");
        //btnt1.setOnAction(event -> EventoItem(1));
        txtt2=new TextField();
        txtt2.setStyle("-fx-translate-y: 5");
        txtt2.setStyle("-fx-background-radius: 5");
        btnt4=new Button("-");
        //btnt1.setOnAction(event -> EventoItem(1));

        btnt5=new Button("+");
        //btnt1.setOnAction(event -> EventoItem(1));
        txtt3=new TextField();
        txtt3.setStyle("-fx-translate-y: 5");
        txtt3.setStyle("-fx-background-radius: 5");
        btnt6=new Button("-");
        //btnt1.setOnAction(event -> EventoItem(1));

        btnt7= new Button("+");
        //btnt1.setOnAction(event -> EventoItem(1));
        txtt4=new TextField();
        txtt4.setStyle("-fx-translate-y: 5");
        txtt4.setStyle("-fx-background-radius: 5");
        btnt8=new Button("-");
        //btnt1.setOnAction(event -> EventoItem(1));


        lblCombos=new Label();
        lblCombos.setText("-----------COMBOS-----------");
        lblC1=new Label();
        lblC1.setGraphic(new ImageView("sample/Imagenes/combo1.jpg"));
        lblC1.setMinHeight(50.0);
        lblC2=new Label();
        lblC2.setGraphic(new ImageView("sample/Imagenes/combo2.jpg"));
        lblC2.setMinHeight(50.0);
        lblC3=new Label();
        lblC3.setGraphic(new ImageView("sample/Imagenes/combo3.png"));
        lblC3.setMinHeight(50.0);
        lblC4=new Label();
        lblC4.setGraphic(new ImageView("sample/Imagenes/combo4.jpeg"));
        lblC4.setMinHeight(50.0);

        btnc1= new Button("+");
        //btnt1.setOnAction(event -> EventoItem(1));
        txtc1=new TextField();
        txtc1.setStyle("-fx-translate-y: 5");
        txtc1.setStyle("-fx-background-radius: 5");
        btnc2 =new Button("-");
        //btnt1.setOnAction(event -> EventoItem(1));

        btnc3=new Button("+");
        //btnt1.setOnAction(event -> EventoItem(1));
        txtc2=new TextField();
        txtc2.setStyle("-fx-translate-y: 5");
        txtc2.setStyle("-fx-background-radius: 5");
        btnc4=new Button("-");
        //btnt1.setOnAction(event -> EventoItem(1));

        btnc5=new Button("+");
        //btnt1.setOnAction(event -> EventoItem(1));
        txtc3=new TextField();
        txtc3.setStyle("-fx-translate-y: 5");
        txtc3.setStyle("-fx-background-radius: 5");
        btnc6=new Button("-");
        //btnt1.setOnAction(event -> EventoItem(1));

        btnc7= new Button("+");
        //btnt1.setOnAction(event -> EventoItem(1));
        txtc4=new TextField();
        txtc4.setStyle("-fx-translate-y: 5");
        txtc4.setStyle("-fx-background-radius: 5");
        btnc8=new Button("-");
        //btnt1.setOnAction(event -> EventoItem(1));


        lblBebidas=new Label();
        lblBebidas.setText("------------BEBIDAS-----------");
        lblB1=new Label();
        lblB1.setGraphic(new ImageView("sample/Imagenes/bebidaHor.jpg"));
        lblB1.setMinHeight(50.0);
        lblB2=new Label();
        lblB2.setGraphic(new ImageView("sample/Imagenes/cerveza.jpg"));
        lblB2.setMinHeight(50.0);
        lblB3=new Label();
        lblB3.setGraphic(new ImageView("sample/Imagenes/jugo.png"));
        lblB3.setMinHeight(50.0);
        lblB4=new Label();
        lblB4.setGraphic(new ImageView("sample/Imagenes/refres.jpg"));
        lblB4.setMinHeight(50.0);

        btnb1= new Button("+");
        //btnt1.setOnAction(event -> EventoItem(1));
        txtb1=new TextField();
        txtb1.setStyle("-fx-translate-y: 5");
        txtb1.setStyle("-fx-background-radius: 5");
        btnb2 =new Button("-");
        //btnt1.setOnAction(event -> EventoItem(1));

        btnb3=new Button("+");
        //btnt1.setOnAction(event -> EventoItem(1));
        txtb2=new TextField();
        txtb2.setStyle("-fx-translate-y: 5");
        txtb2.setStyle("-fx-background-radius: 5");
        btnb4=new Button("-");
        //btnt1.setOnAction(event -> EventoItem(1));

        btnb5=new Button("+");
        //btnt1.setOnAction(event -> EventoItem(1));
        txtb3=new TextField();
        txtb3.setStyle("-fx-translate-y: 5");
        txtb3.setStyle("-fx-background-radius: 5");
        btnb6=new Button("-");
        //btnt1.setOnAction(event -> EventoItem(1));

        btnb7= new Button("+");
        //btnt1.setOnAction(event -> EventoItem(1));
        txtb4=new TextField();
        txtb4.setStyle("-fx-translate-y: 5");
        txtb4.setStyle("-fx-background-radius: 5");
        btnb8=new Button("-");
        //btnt1.setOnAction(event -> EventoItem(1));


        lblOtros=new Label();
        lblOtros.setText("------------OTROS-----------");
        lblO1=new Label();
        lblO1.setGraphic(new ImageView("sample/Imagenes/postres1.jpg"));
        lblO1.setMinHeight(50.0);
        lblO2=new Label();
        lblO2.setGraphic(new ImageView("sample/Imagenes/postre2.jpg"));
        lblO2.setMinHeight(50.0);
        lblO3=new Label();
        lblO3.setGraphic(new ImageView("sample/Imagenes/postre3.jpg"));
        lblO3.setMinHeight(50.0);
        lblO4=new Label();
        lblO4.setGraphic(new ImageView("sample/Imagenes/postre4.jpg"));
        lblO4.setMinHeight(50.0);

        btno1= new Button("+");
        //btnt1.setOnAction(event -> EventoItem(1));
        txto1=new TextField();
        txto1.setStyle("-fx-translate-y: 5");
        txto1.setStyle("-fx-background-radius: 5");
        btno2 =new Button("-");
        //btnt1.setOnAction(event -> EventoItem(1));

        btno3=new Button("+");
        //btnt1.setOnAction(event -> EventoItem(1));
        txto2=new TextField();
        txto2.setStyle("-fx-translate-y: 5");
        txto2.setStyle("-fx-background-radius: 5");
        btno4=new Button("-");
        //btnt1.setOnAction(event -> EventoItem(1));

        btno5=new Button("+");
        //btnt1.setOnAction(event -> EventoItem(1));
        txto3=new TextField();
        txto3.setStyle("-fx-translate-y: 5");
        txto3.setStyle("-fx-background-radius: 5");
        btno6=new Button("-");
        //btnt1.setOnAction(event -> EventoItem(1));

        btno7= new Button("+");
        //btnt1.setOnAction(event -> EventoItem(1));
        txto4=new TextField();
        txto4.setStyle("-fx-translate-y: 5");
        txto4.setStyle("-fx-background-radius: 5");
        btno8=new Button("-");
        //btnt1.setOnAction(event -> EventoItem(1));

        hboxTa=new HBox();
        hboxTa.getChildren().addAll(lblTacos);
        hboximaT=new HBox();
        hboximaT.getChildren().addAll(lblT1,lblT2,lblT3,lblT4);
        hboxbtnT=new HBox();
        hboxbtnT.getChildren().addAll(btnt1,txtt1,btnt2,btnt3,txtt2,btnt4,btnt5,txtt3,btnt6,btnt7,txtt4,btnt8);
        hboxTCom=new HBox();
        hboxTCom.getChildren().addAll(lblCombos);
        hboximaC=new HBox();
        hboximaC.getChildren().addAll(lblC1,lblC2,lblC3,lblC4);
        hboxbtnC=new HBox();
        hboxbtnC.getChildren().addAll(btnc1,txtc1,btnc2,btnc3,txtc2,btnc4,btnc5,txtc3,btnc6,btnc7,txtc4,btnc8);
        hboxTBe=new HBox();
        hboxTBe.getChildren().addAll(lblBebidas);
        hboximaB=new HBox();
        hboximaB.getChildren().addAll(lblB1,lblB2,lblB3,lblB4);
        hboxbtnB=new HBox();
        hboxbtnB.getChildren().addAll(btnb1,txtb1,btnb2,btnb3,txtb2,btnb4,btnb5,txtb3,btnb6,btnb7,txtb4,btnb8);
        hboxTOt=new HBox();
        hboxTOt.getChildren().addAll(lblOtros);
        hboximaO=new HBox();
        hboximaO.getChildren().addAll(lblO1,lblO2,lblO3,lblO4);
        hboxbtnO=new HBox();
        hboxbtnO.getChildren().addAll(btno1,txto1,btno2,btno3,txto2,btno4,btno5,txto3,btno6,btno7,txto4,btno8);
        hboxbtnPDF=new HBox();
        hboxbtnPDF.getChildren().addAll(btnTicket,btnCancelar);

        vBox=new VBox();
        vBox.getChildren().addAll(hboxTa,hboximaT,hboxbtnT,hboxTCom,hboximaC,hboxbtnC,hboxTBe,hboximaB,hboxbtnB,hboxTOt,hboximaO,hboxbtnO,hboxbtnPDF);

    }
    private void CrearTicket(){ new Ticket(); }

    public void getScena(Scene scene){
    }

    Conexion cc = new Conexion();
    Connection con = cc.Connect();

}
