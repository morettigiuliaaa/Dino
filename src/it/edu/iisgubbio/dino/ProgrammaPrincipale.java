package it.edu.iisgubbio.dino;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
public class ProgrammaPrincipale extends Application{
	private final int velocitàDino=20;
	private final int velocitàGioco=5;
	Timeline timelineSfondo = new Timeline(new KeyFrame(
			Duration.millis(velocitàGioco),
			x -> aggiornaSfondo()));
	Timeline timelineMovDino = new Timeline(new KeyFrame(
			Duration.millis(velocitàDino),
			x -> muoviDino()));
	Rectangle rettangoloCactus1 = new Rectangle(15,70);
	Rectangle rettangoloCactus2 = new Rectangle(15,70);
	Rectangle rettangoloUccello1 = new Rectangle(9,50);
	Rectangle rettangoloUccello2 = new Rectangle(9,50);
	Rectangle rettangoloDino = new Rectangle(9,79);
	Rectangle rettangoloDinoCoda = new Rectangle(9,79);
	Rectangle rettangoloFiamma = new Rectangle(2,79);
	Image cielo = new Image(getClass().getResourceAsStream("Sfondoprogramma_cielo.jpg"));
<<<<<<< HEAD
	ImageView cieloView = new ImageView(cielo);
	Image cielo2 = new Image(getClass().getResourceAsStream("Sfondoprogramma_cielo.jpg"));
	ImageView cieloView2 = new ImageView(cielo2);
	Image montagne = new Image(getClass().getResourceAsStream("Sfondoprogramma_montagne.png"));
	ImageView montagneView = new ImageView(montagne);
	Image montagne2 = new Image(getClass().getResourceAsStream("Sfondoprogramma_montagne.png"));
	ImageView montagneView2 = new ImageView(montagne2);
	Image terreno = new Image(getClass().getResourceAsStream("Sfondoprogramma_terreno.PNG"));
	ImageView terrenoView = new ImageView(terreno);
	Image terreno2 = new Image(getClass().getResourceAsStream("Sfondoprogramma_terreno.PNG"));
	ImageView terrenoView2 = new ImageView(terreno2);
	Image dinosauro = new Image(getClass().getResourceAsStream("dinosauroProgramma.PNG"));
	ImageView dinosauroView = new ImageView(dinosauro);
	Image cactus = new Image(getClass().getResourceAsStream("cactusPerProgramma.png"));
	ImageView cactusView = new ImageView(cactus);
	Image cactus2 = new Image(getClass().getResourceAsStream("cactusPerProgramma.png"));
	ImageView cactusView2 = new ImageView(cactus2);
	Image uccello = new Image(getClass().getResourceAsStream("uccelloPerProgramma.png"));
	ImageView uccelloView = new ImageView(uccello);
	Image uccello2 = new Image(getClass().getResourceAsStream("uccelloPerProgramma.png"));
	ImageView uccelloView2 = new ImageView(uccello2);
	boolean arrivatoSù=false;
	boolean arrivatoGiù=false;
	Pane quadro= new Pane();

=======
    ImageView cieloView = new ImageView(cielo);
    Image cielo2 = new Image(getClass().getResourceAsStream("Sfondoprogramma_cielo.jpg"));
    ImageView cieloView2 = new ImageView(cielo2);
    Image montagne = new Image(getClass().getResourceAsStream("Sfondoprogramma_montagne.png"));
    ImageView montagneView = new ImageView(montagne);
    Image montagne2 = new Image(getClass().getResourceAsStream("Sfondoprogramma_montagne.png"));
    ImageView montagneView2 = new ImageView(montagne2);
    Image terreno = new Image(getClass().getResourceAsStream("Sfondoprogramma_terreno.PNG"));
    ImageView terrenoView = new ImageView(terreno);
    Image terreno2 = new Image(getClass().getResourceAsStream("Sfondoprogramma_terreno.PNG"));
    ImageView terrenoView2 = new ImageView(terreno2);
    Image dinosauro = new Image(getClass().getResourceAsStream("dinosauroProgramma.PNG"));
    ImageView dinosauroView = new ImageView(dinosauro);
    Image cactus = new Image(getClass().getResourceAsStream("cactusPerProgramma.png"));
    ImageView cactusView = new ImageView(cactus);
    Image cactus2 = new Image(getClass().getResourceAsStream("cactusPerProgramma.png"));
    ImageView cactusView2 = new ImageView(cactus2);
    Image uccello = new Image(getClass().getResourceAsStream("uccelloPerProgramma.png"));
    ImageView uccelloView = new ImageView(uccello);
    Image uccello2 = new Image(getClass().getResourceAsStream("uccelloPerProgramma.png"));
    ImageView uccelloView2 = new ImageView(uccello2);
    Image fiamma = new Image(getClass().getResourceAsStream("XCVT.gif"));
    ImageView fiammaView = new ImageView(fiamma);
    boolean arrivatoSù=false;
    boolean arrivatoGiù=false;
    Pane quadro= new Pane();
    
>>>>>>> 00880dde32a738d5e6d56b9937c5da3794e81c78
	public void start (Stage finestra) {

		quadro.getChildren().add(cieloView);
<<<<<<< HEAD
		quadro.getChildren().add(cieloView2);
		quadro.getChildren().add(montagneView);
		quadro.getChildren().add(montagneView2);
		quadro.getChildren().add(terrenoView);
		quadro.getChildren().add(terrenoView2);
		quadro.getChildren().add(dinosauroView);
		quadro.getChildren().add(cactusView);
		quadro.getChildren().add(cactusView2);
		quadro.getChildren().add(uccelloView);
		quadro.getChildren().add(uccelloView2);


		timelineSfondo.setCycleCount(Timeline.INDEFINITE);
		timelineSfondo.play();

		timelineMovDino.setCycleCount(Timeline.INDEFINITE);


		montagneView.setY(160);
		montagneView2.setY(160);

		terrenoView.setY(370);
		terrenoView2.setY(370);

		dinosauroView.setX(160);
		dinosauroView.setY(300);


		cactusView.setY(317);
		cactusView2.setY(317);
		cactusView.setX(700);


		uccelloView.setY(270);
		uccelloView2.setY(270);


		Scene scena = new Scene (quadro, 750, 500);
		scena.getStylesheets().add("it/edu/iisgubbio/dino/Dino.css");
		scena.setOnKeyPressed(e -> pigiato(e));

		finestra.setTitle("Dino");
		finestra.setScene(scena);
		finestra.show();


		//aggiunta size
=======
	    quadro.getChildren().add(cieloView2);
	    quadro.getChildren().add(montagneView);
	    quadro.getChildren().add(montagneView2);
	    quadro.getChildren().add(terrenoView);
	    quadro.getChildren().add(terrenoView2);
	    quadro.getChildren().add(dinosauroView);
	    quadro.getChildren().add(cactusView);
	    quadro.getChildren().add(cactusView2);
	    quadro.getChildren().add(uccelloView);
	    quadro.getChildren().add(uccelloView2);
	    quadro.getChildren().add(rettangoloCactus1);
	    quadro.getChildren().add(rettangoloCactus2);
	    quadro.getChildren().add(rettangoloDino);
	    quadro.getChildren().add(rettangoloDinoCoda);
	    quadro.getChildren().add(rettangoloUccello1);
	    quadro.getChildren().add(rettangoloUccello2);
	    
	    
	    
	    
		timelineSfondo.setCycleCount(Timeline.INDEFINITE);
		timelineSfondo.play();
		
		
		timelineMovDino.setCycleCount(Timeline.INDEFINITE);
		
		rettangoloCactus1.setX(782);
		rettangoloCactus1.setY(327);
		rettangoloCactus2.setY(327);
	   
		rettangoloDino.setX(160);
		rettangoloDino.setY(297);
		rettangoloDino.setRotate(68);
		
		rettangoloDinoCoda.setX(130);
		rettangoloDinoCoda.setY(300);
		rettangoloDinoCoda.setRotate(78);
		
		rettangoloUccello1.setY(296);
		rettangoloUccello2.setY(296);
		rettangoloUccello1.setRotate(90);
		rettangoloUccello2.setRotate(90);
		
		rettangoloFiamma.setX(245);
		rettangoloFiamma.setY(287);
		rettangoloFiamma.setRotate(90);
		
		rettangoloDino.setVisible(false);
		rettangoloDinoCoda.setVisible(false);
		rettangoloCactus1.setVisible(false);
		rettangoloCactus2.setVisible(false);
		rettangoloUccello1.setVisible(false);
		rettangoloUccello2.setVisible(false);
		
	    montagneView.setY(160);
	    montagneView2.setY(160);
	    
	    terrenoView.setY(370);
	    terrenoView2.setY(370);
	    
	    dinosauroView.setX(70);
	    dinosauroView.setY(300);
	    
	    cactusView.setY(317);
	    cactusView2.setY(317);
	    cactusView.setX(700);
	    
	    uccelloView.setY(270);
	    uccelloView2.setY(270);
	    
	    
	    Scene scena = new Scene (quadro, 750, 500);
	    scena.getStylesheets().add("it/edu/iisgubbio/dino/Dino.css");
	    scena.setOnKeyPressed(e -> pigiato(e));
	    
		finestra.setTitle("Dino");
		finestra.setScene(scena);
		finestra.show();
		

>>>>>>> 00880dde32a738d5e6d56b9937c5da3794e81c78
		cieloView.setFitWidth(800);
		cieloView2.setX(800);
		montagneView.setFitWidth(800);
		montagneView2.setX(800);
		terrenoView.setFitWidth(800);
		terrenoView2.setX(800);
		dinosauroView.setFitHeight(100);
		dinosauroView.setPreserveRatio(true);
		cactusView.setFitHeight(85);
		cactusView.setPreserveRatio(true);
		cactusView2.setFitHeight(85);
		cactusView2.setPreserveRatio(true);
		uccelloView.setFitHeight(85);
		uccelloView.setPreserveRatio(true);
		uccelloView2.setFitHeight(85);
		uccelloView2.setPreserveRatio(true);
	}
	private void aggiornaSfondo() {
		cieloView.setX(cieloView.getX()-0.25);
		cieloView2.setX(cieloView2.getX()-0.25);
		if(cieloView2.getX()==0) {
			cieloView.setX(735);
		}
		if(cieloView.getX()==0) {
			cieloView2.setX(800);
		}
		montagneView.setX(montagneView.getX()-0.5);
		montagneView2.setX(montagneView2.getX()-0.5);
		if(montagneView2.getX()==0) {
			montagneView.setX(720);
		}
		if(montagneView.getX()==0) {
			montagneView2.setX(800);
		}
		terrenoView.setX(terrenoView.getX()-2);
		terrenoView2.setX(terrenoView2.getX()-2);
		if(terrenoView2.getX()==0) {
			terrenoView.setX(720);
		}
		if(terrenoView.getX()==0) {
			terrenoView2.setX(700);
		}
<<<<<<< HEAD

		//aggiunta loop cactus e uccello + fix alle varie cordinate di tutti gli oggetti
=======
>>>>>>> 00880dde32a738d5e6d56b9937c5da3794e81c78
		cactusView.setX(cactusView.getX()-2);
		rettangoloCactus1.setX(rettangoloCactus1.getX()-2);
		if(cactusView.getX()==0) {
			uccelloView.setX(780);
			rettangoloUccello1.setX(820);
		}
		rettangoloUccello1.setX(rettangoloUccello1.getX()-2);
		uccelloView.setX(uccelloView.getX()-2);
		if(uccelloView.getX()==0) {
			cactusView2.setX(700);
			rettangoloCactus2.setX(782);
		}
		rettangoloCactus2.setX(rettangoloCactus2.getX()-2);
		cactusView2.setX(cactusView2.getX()-2);
		if(cactusView2.getX()==0) {
			uccelloView2.setX(780);
			rettangoloUccello1.setX(820);
		}
		rettangoloUccello2.setX(rettangoloUccello2.getX()-2);
		uccelloView2.setX(uccelloView2.getX()-2);
		if(uccelloView2.getX()==0) {
			cactusView.setX(700);
			rettangoloCactus1.setX(782);
		}
<<<<<<< HEAD

		//contollo collisione beta 1
		Bounds dinosauro = dinosauroView.getBoundsInParent();
		Bounds uccello = uccelloView.getBoundsInParent();
		Bounds uccello2 = uccelloView2.getBoundsInParent();
		Bounds cactus = cactusView.getBoundsInParent();
		Bounds cactus2 = cactusView2.getBoundsInParent();

		if(dinosauro.intersects(cactus)) {
			System.out.print(9);
		}

		if(dinosauro.intersects(cactus2)) {
			System.out.print(9);
		}

		if(dinosauro.intersects(uccello)) {
			System.out.print(9);
		}

		if(dinosauro.intersects(uccello2)) {
			System.out.print(9);
		}
=======
		// contollo collisione beta 2
		Shape intDino1 = Shape.intersect(rettangoloDino, rettangoloCactus1);
		Shape intDino2 = Shape.intersect(rettangoloDino, rettangoloCactus2);
		Shape intDinoCoda1 = Shape.intersect(rettangoloDinoCoda, rettangoloCactus1);
		Shape intDinoCoda2 = Shape.intersect(rettangoloDinoCoda, rettangoloCactus2);
		Shape intDinoUccello1 = Shape.intersect(rettangoloDino, rettangoloUccello1);
		Shape intDinoUccello2 = Shape.intersect(rettangoloDino, rettangoloUccello2);
		Shape intDinoUccelloFiamma1 = Shape.intersect(rettangoloFiamma, rettangoloUccello1);
		Shape intDinoUccelloFiamma2 = Shape.intersect(rettangoloFiamma, rettangoloUccello2);
        
        if (intDino1.getBoundsInLocal().getWidth() != -1){
            timelineSfondo.stop();
        }
        if (intDino2.getBoundsInLocal().getWidth() != -1){
        	timelineSfondo.stop();
        }
        if (intDinoCoda1.getBoundsInLocal().getWidth() != -1){
            timelineSfondo.stop();
        }
        if (intDinoCoda2.getBoundsInLocal().getWidth() != -1){
        	timelineSfondo.stop();
        }
        if (intDinoUccello1.getBoundsInLocal().getWidth() != -1){
            timelineSfondo.stop();
        }
        if (intDinoUccello2.getBoundsInLocal().getWidth() != -1){
        	timelineSfondo.stop();
        }
        if (intDinoUccelloFiamma1.getBoundsInLocal().getWidth() != -1){
        	quadro.getChildren().add(fiammaView);
        }
        if (intDinoUccelloFiamma2.getBoundsInLocal().getWidth() != -1){
        	quadro.getChildren().add(fiammaView);
        }
>>>>>>> 00880dde32a738d5e6d56b9937c5da3794e81c78
	}
	private void muoviDino() {
		if(dinosauroView.getY()>=120 && arrivatoSù==false) {
<<<<<<< HEAD
			dinosauroView.setY(dinosauroView.getY()-10);
			if(dinosauroView.getY()==200) {
				System.out.println("1");
				if(dinosauroView.getY()==120) {
					System.out.println("arrivato!");
					arrivatoSù=true;
				}
			}else {
				if(dinosauroView.getY()<=300 && arrivatoSù) {
					dinosauroView.setY(dinosauroView.getY()+10);

					dinosauroView.setY(dinosauroView.getY()+5);
					System.out.println("2");

					if(dinosauroView.getY()==300) {
						arrivatoGiù=true;
					}
=======
			rettangoloDino.setY(rettangoloDino.getY()-15);
			rettangoloDinoCoda.setY(rettangoloDinoCoda.getY()-15);
			dinosauroView.setY(dinosauroView.getY()-15);
			if(dinosauroView.getY()==120) {
				arrivatoSù=true;
			}
		}else {
			if(dinosauroView.getY()<=300 && arrivatoSù) {
				rettangoloDino.setY(rettangoloDino.getY()+6);
				rettangoloDinoCoda.setY(rettangoloDinoCoda.getY()+6);
				dinosauroView.setY(dinosauroView.getY()+6);
				if(dinosauroView.getY()==300) {
					arrivatoGiù=true;
>>>>>>> 00880dde32a738d5e6d56b9937c5da3794e81c78
				}
			}
			if(arrivatoGiù==true) {
				timelineMovDino.stop();
			}
		}

	}
	private void pigiato(KeyEvent evento) {
		arrivatoSù=false;
		arrivatoGiù=false;
		if(evento.getText().equals("w")) {
			timelineMovDino.play();
		}
		if(evento.getText().equals("W")) {
			timelineMovDino.play();
		}
		if(evento.getCode() == KeyCode.UP ) {
			timelineMovDino.play();
		}
		if(evento.getText().equals("d") ) {
			quadro.getChildren().add(rettangoloFiamma);
			rettangoloFiamma.setVisible(true);
		}
		if(evento.getText().equals("D") ) {
			quadro.getChildren().add(rettangoloFiamma);
			rettangoloFiamma.setVisible(false);
		}
		if(evento.getCode() == KeyCode.RIGHT ) {
			quadro.getChildren().add(rettangoloFiamma);
			rettangoloFiamma.setVisible(false);
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
