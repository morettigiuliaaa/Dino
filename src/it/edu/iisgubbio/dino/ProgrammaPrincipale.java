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
	public void start (Stage finestra) {
		Pane quadro= new Pane();
		
		timelineSfondo.setCycleCount(Timeline.INDEFINITE);
		timelineSfondo.play();
	    
	    
	    
	    montagneView.setY(160);
	    montagneView2.setY(160);
	    
	    quadro.getChildren().add(cieloView);
	    quadro.getChildren().add(cieloView2);
	    quadro.getChildren().add(montagneView);
	    quadro.getChildren().add(montagneView2);
	    
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
	}
	private void aggiornaSfondo() {
		cieloView.setX(cieloView.getX()-0.2);
		cieloView2.setX(cieloView2.getX()-0.2);
		if(cieloView2.getX()==0) {
			cieloView.setX(720);
		}
		if(cieloView.getX()==0) {
			cieloView2.setX(800);
		}
		montagneView.setX(montagneView.getX()-0.3);
		montagneView2.setX(montagneView2.getX()-0.3);
		if(montagneView2.getX()==0) {
			montagneView.setX(720);
		}
		if(montagneView.getX()==0) {
			montagneView2.setX(800);
		}
	}
	public static void main(String[] args) {
	    launch(args);
	}
}
