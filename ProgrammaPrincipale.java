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
	public void start (Stage finestra) {
		Pane quadro= new Pane();
		
		timelineSfondo.setCycleCount(Animation.INDEFINITE);
		timelineSfondo.play();
	    
	    Image montagne = new Image(getClass().getResourceAsStream("Sfondoprogramma_montagne.png"));
	    ImageView montagneView = new ImageView(montagne);
	    
	    montagneView.setY(160);
	    
	    quadro.getChildren().add(cieloView);
	    quadro.getChildren().add(montagneView);
	    
	    Scene scena = new Scene (quadro, 700, 500);
		finestra.setTitle("Dino");
		finestra.setScene(scena);
		finestra.show();
		scena.getStylesheets().add("it/edu/iisgubbio/dino/Dino.css");
		cieloView.setId("pannello");
	}
	private void aggiornaSfondo() {
		cieloView.setX(cieloView.getX()-1);
	}
	public static void main(String[] args) {
	    launch(args);
	}
}
