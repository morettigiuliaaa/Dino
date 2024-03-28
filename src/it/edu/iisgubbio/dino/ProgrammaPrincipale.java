package it.edu.iisgubbio.dino;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ProgrammaPrincipale extends Application{
	Timeline timelineSfondo = new Timeline(new KeyFrame(
			Duration.millis(8),
			x -> aggiornaSfondo()));
	Image cielo = new Image(getClass().getResourceAsStream("Sfondoprogramma_cielo.jpeg"));
    ImageView cieloView = new ImageView(cielo);
    Image cielo2 = new Image(getClass().getResourceAsStream("Sfondoprogramma_cielo.jpeg"));
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
	public void start (Stage finestra) {
		Pane quadro= new Pane();
		
		timelineSfondo.setCycleCount(Timeline.INDEFINITE);
		timelineSfondo.play();
	   
	    montagneView.setY(160);
	    montagneView2.setY(160);
	    
	    terrenoView.setY(370);
	    terrenoView2.setY(370);
	    
	    dinosauroView.setX(50);
	    dinosauroView.setY(300);
	    
	    quadro.getChildren().add(cieloView);
	    quadro.getChildren().add(cieloView2);
	    quadro.getChildren().add(montagneView);
	    quadro.getChildren().add(montagneView2);
	    quadro.getChildren().add(terrenoView);
	    quadro.getChildren().add(terrenoView2);
	    quadro.getChildren().add(dinosauroView);
	    
	    Scene scena = new Scene (quadro, 750, 500);
		finestra.setTitle("Dino");
		finestra.setScene(scena);
		finestra.show();
		scena.getStylesheets().add("it/edu/iisgubbio/dino/Dino.css");
		cieloView.setId("pannello");
		
		cieloView.setFitWidth(800);
		cieloView2.setX(800);
		montagneView.setFitWidth(800);
		montagneView2.setX(800);
		terrenoView.setFitWidth(800);
		terrenoView2.setX(800);
		dinosauroView.setFitHeight(100);
		dinosauroView.setPreserveRatio(true);
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
		terrenoView.setX(terrenoView.getX()-1);
		terrenoView2.setX(terrenoView2.getX()-1);
		if(terrenoView2.getX()==0) {
			terrenoView.setX(720);
		}
		if(terrenoView.getX()==0) {
			terrenoView2.setX(800);
		}
	}
	public static void main(String[] args) {
	    launch(args);
	}
}
