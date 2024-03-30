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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ProgrammaPrincipale extends Application{
	int velocitàDino=20;
	Timeline timelineSfondo = new Timeline(new KeyFrame(
			Duration.millis(8),
			x -> aggiornaSfondo()));
	Timeline timelineMovDino = new Timeline(new KeyFrame(
			Duration.millis(velocitàDino),
			x -> muoviDino()));
	Image cielo = new Image(getClass().getResourceAsStream("Sfondoprogramma_cielo.jpg"));
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
    boolean arrivatoSù=false;
    boolean arrivatoGiù=false;
    
	public void start (Stage finestra) {
		Pane quadro= new Pane();
		
		quadro.getChildren().add(cieloView);
	    quadro.getChildren().add(cieloView2);
	    quadro.getChildren().add(montagneView);
	    quadro.getChildren().add(montagneView2);
	    quadro.getChildren().add(terrenoView);
	    quadro.getChildren().add(terrenoView2);
	    quadro.getChildren().add(dinosauroView);
	    
		timelineSfondo.setCycleCount(Timeline.INDEFINITE);
		timelineSfondo.play();
		
		timelineMovDino.setCycleCount(Timeline.INDEFINITE);
		
	   
	    montagneView.setY(160);
	    montagneView2.setY(160);
	    
	    terrenoView.setY(370);
	    terrenoView2.setY(370);
	    
	    dinosauroView.setX(50);
	    dinosauroView.setY(300);
	    
	    Scene scena = new Scene (quadro, 750, 500);
	    scena.getStylesheets().add("it/edu/iisgubbio/dino/Dino.css");
	    scena.setOnKeyPressed(e -> pigiato(e));
	    
		finestra.setTitle("Dino");
		finestra.setScene(scena);
		finestra.show();
		
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
		terrenoView.setX(terrenoView.getX()-5);
		terrenoView2.setX(terrenoView2.getX()-5);
		if(terrenoView2.getX()==0) {
			terrenoView.setX(720);
		}
		if(terrenoView.getX()==0) {
			terrenoView2.setX(800);
		}
	}
	private void muoviDino() {
		if(dinosauroView.getY()>=200 && arrivatoSù==false) {
			dinosauroView.setY(dinosauroView.getY()-10);
			System.out.println("1");
			if(dinosauroView.getY()==200) {
				System.out.println("arrivato!");
				arrivatoSù=true;
			}
		}else {
			if(dinosauroView.getY()<=300 && arrivatoSù) {
				dinosauroView.setY(dinosauroView.getY()+10);
				System.out.println("2");
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
		arrivatoSù=false;
		arrivatoGiù=false;
		if(evento.getText().equals("w")) {
			timelineMovDino.play();
		}
	}
	public static void main(String[] args) {
	    launch(args);
	}
}
