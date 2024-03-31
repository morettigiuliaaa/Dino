package it.edu.iisgubbio.dino;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ProgrammaPrincipale extends Application{
	int velocitàDino=20;
	Timeline timelineSfondo = new Timeline(new KeyFrame(
			Duration.millis(6),
			x -> aggiornaSfondo()));
	Timeline timelineMovDino = new Timeline(new KeyFrame(
			Duration.millis(velocitàDino),
			x -> muoviDino()));
	Image cielo = new Image(getClass().getResourceAsStream("Sfondoprogramma_cielo.jpg"));
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
<<<<<<< HEAD
=======
    Pane quadro= new Pane();
    
>>>>>>> 9a876bb7949bc654cf86a59b41c64ebe2a70bb9b
	public void start (Stage finestra) {
		
		quadro.getChildren().add(cieloView);
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
		
		//aggiunta loop cactus e uccello + fix alle varie cordinate di tutti gli oggetti
		cactusView.setX(cactusView.getX()-2);
		if(cactusView.getX()==0) {
			uccelloView.setX(700);
		}
		uccelloView.setX(uccelloView.getX()-2);
		if(uccelloView.getX()==0) {
			cactusView2.setX(700);
		}
		cactusView2.setX(cactusView2.getX()-2);
		if(cactusView2.getX()==0) {
			uccelloView2.setX(700);;
		}
		uccelloView2.setX(uccelloView2.getX()-2);
		if(uccelloView2.getX()==0) {
			cactusView.setX(700);
		}
		
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
	}
	private void muoviDino() {
		//fix salto dinosauro per bound
		if(dinosauroView.getY()>=120 && arrivatoSù==false) {
			dinosauroView.setY(dinosauroView.getY()-10);
<<<<<<< HEAD
			if(dinosauroView.getY()==200) {
=======
			System.out.println("1");
			if(dinosauroView.getY()==120) {
>>>>>>> 9a876bb7949bc654cf86a59b41c64ebe2a70bb9b
				System.out.println("arrivato!");
				arrivatoSù=true;
			}
		}else {
			if(dinosauroView.getY()<=300 && arrivatoSù) {
<<<<<<< HEAD
				dinosauroView.setY(dinosauroView.getY()+10);
=======
				dinosauroView.setY(dinosauroView.getY()+5);
				System.out.println("2");
>>>>>>> 9a876bb7949bc654cf86a59b41c64ebe2a70bb9b
				if(dinosauroView.getY()==300) {
					arrivatoGiù=true;
				}
			}
		}
		if(arrivatoGiù==true) {
			timelineMovDino.stop();
		}
	}
	private void pigiato(KeyEvent evento) {
		// aggiunta chiave UP e W maiusc.
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
	}
	public static void main(String[] args) {
	    launch(args);
	}
}
