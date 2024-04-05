package it.edu.iisgubbio.dino;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	Label eTitolo = new Label("Dino game");
	Label eSottoTitolo = new Label("affronta il deserto con Dino!");
	Label ePunteggio = new Label("");
	Button pStart = new Button("start!");
	private final int VELOCITA_DINO=20;
	double velocitàGioco=5;
	int segnaPunti=0;
	Timeline timelineSfondo = new Timeline(new KeyFrame(
			Duration.millis(velocitàGioco),
			x -> aggiornaSfondo()));
	Timeline timelineMovDino = new Timeline(new KeyFrame(
			Duration.millis(VELOCITA_DINO),
			x -> muoviDino()));
	Timeline timelinePunteggio = new Timeline(new KeyFrame(
			Duration.millis(100),
			x -> aggiornaPunteggio()));
	Timeline timelineZampette = new Timeline(new KeyFrame(
			Duration.millis(59),
			x -> Zampette()));
	Timeline timelineZampetteAbbassate = new Timeline(new KeyFrame(
			Duration.millis(59),
			x -> ZampetteDinoAbbassate()));
	Rectangle rettangoloCactus1 = new Rectangle(15,70);
	Rectangle rettangoloCactus2 = new Rectangle(15,70);
	Rectangle rettangoloUccello1 = new Rectangle(9,60);
	Rectangle rettangoloUccello2 = new Rectangle(9,60);
	Rectangle rettangoloDinoTesta = new Rectangle(9,37);
	Rectangle rettangoloDinoCorpo = new Rectangle(9,70);
	Rectangle rettangoloDinoCoda = new Rectangle(9,37);
	Rectangle rettangoloFiamma = new Rectangle(2,79);
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
	Image dinosauro = new Image(getClass().getResourceAsStream("dino 1.png"));
	ImageView dinosauroView = new ImageView(dinosauro);
	Image dinosauro2 = new Image(getClass().getResourceAsStream("dino 2.png"));
	ImageView dinosauroView2 = new ImageView(dinosauro2);
	Image dinosauro3 = new Image(getClass().getResourceAsStream("dino 3.png"));
	ImageView dinosauroView3 = new ImageView(dinosauro3);
	Image dinosauro4 = new Image(getClass().getResourceAsStream("dino 4.png"));
	ImageView dinosauroView4 = new ImageView(dinosauro4);
	Image dinosauro5 = new Image(getClass().getResourceAsStream("dino 5.png"));
	ImageView dinosauroView5 = new ImageView(dinosauro5);
	Image dinosauro6 = new Image(getClass().getResourceAsStream("dino 6.png"));
	ImageView dinosauroView6 = new ImageView(dinosauro6);
	Image cactus = new Image(getClass().getResourceAsStream("cactusPerProgramma.png"));
	ImageView cactusView = new ImageView(cactus);
	Image cactus2 = new Image(getClass().getResourceAsStream("cactusPerProgramma.png"));
	ImageView cactusView2 = new ImageView(cactus2);
	Image uccello = new Image(getClass().getResourceAsStream("uccelloPerProgramma.png"));
	ImageView uccelloView = new ImageView(uccello);
	Image uccello2 = new Image(getClass().getResourceAsStream("uccelloPerProgramma.png"));
	ImageView uccelloView2 = new ImageView(uccello2);
	Image esplosione = new Image(getClass().getResourceAsStream("XCVT.gif"));
	ImageView esplosioneView = new ImageView(esplosione);
	Image fiammata = new Image(getClass().getResourceAsStream("fiammata.png"));
	ImageView fiammataView = new ImageView(fiammata);
	boolean arrivatoSù=false;
	private boolean isDinoImage1 = true;
	private boolean isDinoImage2 = true;
	boolean arrivatoGiù=false;
	Pane quadro= new Pane();
	public void start (Stage finestra) {
		quadro.getChildren().add(eTitolo);
		eTitolo.setLayoutX(252);
		eTitolo.setLayoutY(80);
		eTitolo.setId("titolo");

		quadro.getChildren().add(eSottoTitolo);
		eSottoTitolo.setLayoutX(230);
		eSottoTitolo.setLayoutY(150);
		eSottoTitolo.setId("sottoTitolo");

		quadro.getChildren().add(pStart);
		pStart.setLayoutX(330);
		pStart.setLayoutY(230);
		pStart.setId("start");

		quadro.getChildren().add(ePunteggio);
		quadro.setId("sottoTitolo");

		timelineSfondo.setCycleCount(Timeline.INDEFINITE);

		timelineMovDino.setCycleCount(Timeline.INDEFINITE);

		timelinePunteggio.setCycleCount(Timeline.INDEFINITE);


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
		dinosauroView2.setFitHeight(100);
		dinosauroView2.setPreserveRatio(true);
		dinosauroView3.setFitHeight(100);
		dinosauroView3.setPreserveRatio(true);
		dinosauroView4.setFitHeight(100);
		dinosauroView4.setPreserveRatio(true);
		cactusView.setFitHeight(85);
		cactusView.setPreserveRatio(true);
		cactusView2.setFitHeight(85);
		cactusView2.setPreserveRatio(true);
		uccelloView.setFitHeight(85);
		uccelloView.setPreserveRatio(true);
		uccelloView2.setFitHeight(85);
		uccelloView2.setPreserveRatio(true);
		fiammataView.setFitHeight(95);
		fiammataView.setPreserveRatio(true);

		pStart.setOnAction(e -> giocoPrincipale());
	}
	public void giocoPrincipale() {
		quadro.getChildren().clear();
		quadro.getChildren().add(cieloView);
		quadro.getChildren().add(cieloView2);
		quadro.getChildren().add(montagneView);
		quadro.getChildren().add(montagneView2);
		quadro.getChildren().add(terrenoView);
		quadro.getChildren().add(terrenoView2);
		quadro.getChildren().add(cactusView);
		quadro.getChildren().add(cactusView2);
		quadro.getChildren().add(uccelloView);
		quadro.getChildren().add(uccelloView2);
		quadro.getChildren().add(rettangoloCactus1);
		quadro.getChildren().add(rettangoloCactus2);
		quadro.getChildren().add(rettangoloDinoTesta);
		quadro.getChildren().add(rettangoloDinoCorpo);
		quadro.getChildren().add(rettangoloDinoCoda);
		quadro.getChildren().add(rettangoloUccello1);
		quadro.getChildren().add(rettangoloUccello2);
		quadro.getChildren().add(esplosioneView);
		
		esplosioneView.setX(-550);
		esplosioneView.setY(-550);
		
		quadro.getChildren().add(ePunteggio);
		quadro.setId("sottoTitolo");

		ePunteggio.setLayoutX(700);
		ePunteggio.setLayoutY(20);
		ePunteggio.setId("punteggio");

		rettangoloCactus1.setX(782);
		rettangoloCactus1.setY(327);
		rettangoloCactus2.setY(327);

		rettangoloDinoTesta.setX(140);
		rettangoloDinoTesta.setY(290);
		rettangoloDinoTesta.setRotate(90);

		rettangoloDinoCorpo.setX(119);
		rettangoloDinoCorpo.setY(300);

		rettangoloDinoCoda.setX(100);
		rettangoloDinoCoda.setY(350);
		rettangoloDinoCoda.setRotate(90);

		rettangoloUccello1.setRotate(90);
		rettangoloUccello2.setRotate(90);

		rettangoloDinoTesta.setVisible(false);
		rettangoloDinoCorpo.setVisible(false);
		rettangoloDinoCoda.setVisible(false);
		rettangoloCactus1.setVisible(false);
		rettangoloCactus2.setVisible(false);
		rettangoloUccello1.setVisible(false);
		rettangoloUccello2.setVisible(false);
		uccelloView2.setVisible(false);
		uccelloView.setVisible(false);

		montagneView.setY(160);
		montagneView2.setY(160);

		terrenoView.setY(370);
		terrenoView2.setY(370);

		dinosauroView.setX(70);
		dinosauroView.setY(300);
		dinosauroView2.setX(70);
		dinosauroView2.setY(300);
		dinosauroView3.setX(70);
		dinosauroView3.setY(300);
		dinosauroView4.setX(70);
		dinosauroView4.setY(300);
		
		cactusView.setX(700);
		cactusView.setY(317);
		cactusView2.setX(2170);
		cactusView2.setY(317);
		
		timelineSfondo.play();
		timelinePunteggio.play();
		timelineZampette.setCycleCount(Timeline.INDEFINITE);
		timelineZampette.play();
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
		cactusView.setX(cactusView.getX()-2);
		rettangoloCactus1.setX(rettangoloCactus1.getX()-2);
		if(cactusView.getX()==0) {
			uccelloView.setVisible(true);
			uccelloView.setX(780);
			rettangoloUccello1.setX(800);

			boolean yCasuale = (Math.random()>0.5);
			if(yCasuale) {
				uccelloView.setY(230);
				rettangoloUccello1.setY(259);
			}else {
				uccelloView.setY(270);
				rettangoloUccello1.setY(299);
			}

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
			uccelloView2.setVisible(true);
			uccelloView2.setX(780);
			rettangoloUccello2.setX(800);

			boolean yCasuale = (Math.random()>0.5);
			if(yCasuale) {
				uccelloView2.setY(230);
				rettangoloUccello2.setY(259);
			}else {
				uccelloView2.setY(270);
				rettangoloUccello2.setY(299);
			}
		}
		rettangoloUccello2.setX(rettangoloUccello2.getX()-2);
		uccelloView2.setX(uccelloView2.getX()-2);
		if(uccelloView2.getX()==0) {
			cactusView.setX(700);
			rettangoloCactus1.setX(782);
		}
		fiammataView.setX(fiammataView.getX()+6);
		rettangoloFiamma.setY(rettangoloFiamma.getX()+6);
		if(rettangoloFiamma.getX()>=650 && fiammataView.getX()>=650) {
			quadro.getChildren().remove(rettangoloFiamma);
			quadro.getChildren().remove(fiammataView);
		}
		// contollo collisione beta 2
		Shape intDino1 = Shape.intersect(rettangoloDinoTesta, rettangoloCactus1);
		Shape intDino2 = Shape.intersect(rettangoloDinoTesta, rettangoloCactus2);
		Shape intDinoCorpo1 = Shape.intersect(rettangoloDinoCorpo, rettangoloCactus1);
		Shape intDinoCorpo2 = Shape.intersect(rettangoloDinoCorpo, rettangoloCactus2);
		Shape intDinoCoda1 = Shape.intersect(rettangoloDinoCoda, rettangoloCactus1);
		Shape intDinoCoda2 = Shape.intersect(rettangoloDinoCoda, rettangoloCactus2);
		Shape intDinoUccello1 = Shape.intersect(rettangoloDinoTesta, rettangoloUccello1);
		Shape intDinoUccello2 = Shape.intersect(rettangoloDinoTesta, rettangoloUccello2);
		Shape intDinoCorpoUccello1 = Shape.intersect(rettangoloDinoCorpo, rettangoloUccello1);
		Shape intDinoCorpoUccello2 = Shape.intersect(rettangoloDinoCorpo, rettangoloUccello2);
		Shape intDinoCodaUccello1 = Shape.intersect(rettangoloDinoCoda, rettangoloUccello1);
		Shape intDinoCodaUccello2 = Shape.intersect(rettangoloDinoCoda, rettangoloUccello2);
		Shape intDinoUccelloFiamma1 = Shape.intersect(rettangoloFiamma, rettangoloUccello1);
		Shape intDinoUccelloFiamma2 = Shape.intersect(rettangoloFiamma, rettangoloUccello2);

		if (intDino1.getBoundsInLocal().getWidth() != -1){
			timelineSfondo.stop();
			timelineMovDino.stop();
			timelinePunteggio.stop();
			timelineZampette.stop();
			if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)||quadro.getChildren().contains(dinosauroView3)) {
				quadro.getChildren().remove(dinosauroView);
				quadro.getChildren().remove(dinosauroView2);
				quadro.getChildren().remove(dinosauroView3);
				quadro.getChildren().add(dinosauroView4);
			}
		}
		if (intDino2.getBoundsInLocal().getWidth() != -1){
			timelineSfondo.stop();
			timelinePunteggio.stop();
			timelineZampette.stop();
			if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)||quadro.getChildren().contains(dinosauroView3)) {
				quadro.getChildren().remove(dinosauroView);
				quadro.getChildren().remove(dinosauroView2);
				quadro.getChildren().remove(dinosauroView3);
				quadro.getChildren().add(dinosauroView4);
			}
		}
		if (intDinoCorpo1.getBoundsInLocal().getWidth() != -1){
			timelineSfondo.stop();
			timelinePunteggio.stop();
			timelineZampette.stop();
			if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)||quadro.getChildren().contains(dinosauroView3)) {
				quadro.getChildren().remove(dinosauroView);
				quadro.getChildren().remove(dinosauroView2);
				quadro.getChildren().remove(dinosauroView3);
				quadro.getChildren().add(dinosauroView4);
			}
		}
		if (intDinoCorpo2.getBoundsInLocal().getWidth() != -1){
			timelineSfondo.stop();
			timelinePunteggio.stop();
			timelineZampette.stop();
			if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)||quadro.getChildren().contains(dinosauroView3)) {
				quadro.getChildren().remove(dinosauroView);
				quadro.getChildren().remove(dinosauroView2);
				quadro.getChildren().remove(dinosauroView3);
				quadro.getChildren().add(dinosauroView4);
			}
		}
		if (intDinoCoda1.getBoundsInLocal().getWidth() != -1){
			timelineSfondo.stop();
			timelinePunteggio.stop();
			timelineZampette.stop();
			if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)||quadro.getChildren().contains(dinosauroView3)) {
				quadro.getChildren().remove(dinosauroView);
				quadro.getChildren().remove(dinosauroView2);
				quadro.getChildren().remove(dinosauroView3);
				quadro.getChildren().add(dinosauroView4);
			}
		}
		if (intDinoCoda2.getBoundsInLocal().getWidth() != -1){
			timelineSfondo.stop();
			timelinePunteggio.stop();
			timelineZampette.stop();
			if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)||quadro.getChildren().contains(dinosauroView3)) {
				quadro.getChildren().remove(dinosauroView);
				quadro.getChildren().remove(dinosauroView2);
				quadro.getChildren().remove(dinosauroView3);
				quadro.getChildren().add(dinosauroView4);
			}
		}
		if (intDinoUccello1.getBoundsInLocal().getWidth() != -1){
			timelineSfondo.stop();
			timelinePunteggio.stop();
			timelineZampette.stop();
			if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)||quadro.getChildren().contains(dinosauroView3)) {
				quadro.getChildren().remove(dinosauroView);
				quadro.getChildren().remove(dinosauroView2);
				quadro.getChildren().remove(dinosauroView3);
				quadro.getChildren().add(dinosauroView4);
			}
		}
		if (intDinoUccello2.getBoundsInLocal().getWidth() != -1){
			timelineSfondo.stop();
			timelinePunteggio.stop();
			timelineZampette.stop();
			if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)||quadro.getChildren().contains(dinosauroView3)) {
				quadro.getChildren().remove(dinosauroView);
				quadro.getChildren().remove(dinosauroView2);
				quadro.getChildren().remove(dinosauroView3);
				quadro.getChildren().add(dinosauroView4);
			}
		}
		if (intDinoCorpoUccello1.getBoundsInLocal().getWidth() != -1){
			timelineSfondo.stop();
			timelinePunteggio.stop();
			timelineZampette.stop();
			if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)||quadro.getChildren().contains(dinosauroView3)) {
				quadro.getChildren().remove(dinosauroView);
				quadro.getChildren().remove(dinosauroView2);
				quadro.getChildren().remove(dinosauroView3);
				quadro.getChildren().add(dinosauroView4);
			}
		}
		if (intDinoCorpoUccello2.getBoundsInLocal().getWidth() != -1){
			timelineSfondo.stop();
			timelinePunteggio.stop();
			timelineZampette.stop();
			if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)||quadro.getChildren().contains(dinosauroView3)) {
				quadro.getChildren().remove(dinosauroView);
				quadro.getChildren().remove(dinosauroView2);
				quadro.getChildren().remove(dinosauroView3);
				quadro.getChildren().add(dinosauroView4);
			}
		}
		if (intDinoCodaUccello1.getBoundsInLocal().getWidth() != -1){
			timelineSfondo.stop();
			timelinePunteggio.stop();
			timelineZampette.stop();
			if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)||quadro.getChildren().contains(dinosauroView3)) {
				quadro.getChildren().remove(dinosauroView);
				quadro.getChildren().remove(dinosauroView2);
				quadro.getChildren().remove(dinosauroView3);
				quadro.getChildren().add(dinosauroView4);
			}
		}
		if (intDinoCodaUccello2.getBoundsInLocal().getWidth() != -1){
			timelineSfondo.stop();
			timelinePunteggio.stop();
			timelineZampette.stop();
			if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)||quadro.getChildren().contains(dinosauroView3)) {
				quadro.getChildren().remove(dinosauroView);
				quadro.getChildren().remove(dinosauroView2);
				quadro.getChildren().remove(dinosauroView3);
				quadro.getChildren().add(dinosauroView4);
			}
		}
		/*
		if (intDinoUccelloFiamma1.getBoundsInLocal().getWidth() != -1){
			System.out.println("fiamma 1!");
			esplosioneView.setX(uccelloView.getX()-2);
			esplosioneView.setY(uccelloView.getY());
			esplosioneView.setFitHeight(85);
			esplosioneView.setPreserveRatio(true);
		}
		if (intDinoUccelloFiamma2.getBoundsInLocal().getWidth() != -1){
			System.out.println("fiamma 2!");
			// quadro.getChildren().add(esplosioneView);
			esplosioneView.setX(uccelloView2.getX()-2);
			esplosioneView.setY(uccelloView2.getY());
			esplosioneView.setFitHeight(85);
			esplosioneView.setPreserveRatio(true);
		}
		*/
	}

private void Zampette() {
	if (isDinoImage1) {
		if (!quadro.getChildren().contains(dinosauroView)) {
			quadro.getChildren().add(dinosauroView);
		}
		if (quadro.getChildren().contains(dinosauroView2)) {
			quadro.getChildren().remove(dinosauroView2);
		}
	} else {
		if (!quadro.getChildren().contains(dinosauroView2)) {
			quadro.getChildren().add(dinosauroView2);
		}
		if (quadro.getChildren().contains(dinosauroView)) {
			quadro.getChildren().remove(dinosauroView);
		}
	}
	isDinoImage1 = !isDinoImage1;
}
private void ZampetteDinoAbbassate() {
	if (isDinoImage2) {
		if (!quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)||quadro.getChildren().contains(dinosauroView3)) {
			quadro.getChildren().add(dinosauroView5);
		}
		if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)||quadro.getChildren().contains(dinosauroView3)) {
			quadro.getChildren().remove(dinosauroView);
			quadro.getChildren().remove(dinosauroView2);
			quadro.getChildren().remove(dinosauroView3);
		}
	} else {
		if (!quadro.getChildren().contains(dinosauroView6)) {
			quadro.getChildren().add(dinosauroView6);
		}
		if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)||quadro.getChildren().contains(dinosauroView3)) {
			quadro.getChildren().remove(dinosauroView);
			quadro.getChildren().remove(dinosauroView2);
			quadro.getChildren().remove(dinosauroView3);
		}
	}
	isDinoImage2 = !isDinoImage2;
}

private void muoviDino() {
	if(dinosauroView3.getY()>=120 && arrivatoSù==false) {
		rettangoloDinoTesta.setY(rettangoloDinoTesta.getY()-15);
		rettangoloDinoCorpo.setY(rettangoloDinoCorpo.getY()-15);
		rettangoloDinoCoda.setY(rettangoloDinoCoda.getY()-15);
		rettangoloFiamma.setY(rettangoloFiamma.getY()-15);
		fiammataView.setY(fiammataView.getY()-15);
		dinosauroView3.setY(dinosauroView3.getY()-15);
		if(dinosauroView3.getY()<=120) {
			arrivatoSù=true;
		}
	}else {
		if(dinosauroView3.getY()<=300 && arrivatoSù) {
			rettangoloDinoTesta.setY(rettangoloDinoTesta.getY()+6);
			rettangoloDinoCorpo.setY(rettangoloDinoCorpo.getY()+6);
			rettangoloDinoCoda.setY(rettangoloDinoCoda.getY()+6);
			rettangoloFiamma.setY(rettangoloFiamma.getY()+6);
			fiammataView.setY(fiammataView.getY()+6);
			dinosauroView3.setY(dinosauroView3.getY()+6);
			if(dinosauroView3.getY()==300) {
				arrivatoGiù=true;
			}
		}
	}
	if(arrivatoGiù==true) {
		timelineMovDino.stop();
		if (quadro.getChildren().contains(dinosauroView3)) {
			quadro.getChildren().remove(dinosauroView3);
			quadro.getChildren().add(dinosauroView);
			timelineZampette.play();
		}
	}
}
private void aggiornaPunteggio() {
	segnaPunti++;
	ePunteggio.setText(""+segnaPunti);
}
private void pigiato(KeyEvent evento) {
	arrivatoSù=false;
	arrivatoGiù=false;
	if(evento.getText().equals("w")) {
		if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)) {
			quadro.getChildren().remove(dinosauroView);
			quadro.getChildren().remove(dinosauroView2);
			quadro.getChildren().add(dinosauroView3);
		}
		timelineZampette.stop();
		timelineMovDino.play();
	}
	if(evento.getText().equals("W")) {
		if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)) {
			quadro.getChildren().remove(dinosauroView);
			quadro.getChildren().remove(dinosauroView2);
			quadro.getChildren().add(dinosauroView3);
		}
		timelineZampette.stop();
		timelineMovDino.play();
	}
	if(evento.getCode() == KeyCode.UP ) {
		if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)) {
			quadro.getChildren().remove(dinosauroView);
			quadro.getChildren().remove(dinosauroView2);
			quadro.getChildren().add(dinosauroView3);
		}
		timelineZampette.stop();
		timelineMovDino.play();
	}
	if(evento.getText().equals("s")) {
		if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)||quadro.getChildren().contains(dinosauroView3)) {
			quadro.getChildren().remove(dinosauroView);
			quadro.getChildren().remove(dinosauroView2);
			quadro.getChildren().remove(dinosauroView3);
		}
		timelineZampette.stop();
		for (int i=0;i<10;i++) {
			timelineZampetteAbbassate.play();
		}
		timelineZampetteAbbassate.stop();
		timelineMovDino.play();
	}
	if(evento.getText().equals("S")) {
		if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)||quadro.getChildren().contains(dinosauroView3)) {
			quadro.getChildren().remove(dinosauroView);
			quadro.getChildren().remove(dinosauroView2);
			quadro.getChildren().remove(dinosauroView3);
		}
		timelineZampette.stop();
		for (int i=0;i<10;i++) {
			timelineZampetteAbbassate.play();
		}
		timelineZampetteAbbassate.stop();
		timelineMovDino.play();
	}
	if(evento.getCode() == KeyCode.DOWN ) {
		if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)||quadro.getChildren().contains(dinosauroView3)) {
			quadro.getChildren().remove(dinosauroView);
			quadro.getChildren().remove(dinosauroView2);
			quadro.getChildren().remove(dinosauroView3);
		}
		timelineZampette.stop();
		for (int i=0;i<10;i++) {
			timelineZampetteAbbassate.play();
		}
		timelineZampetteAbbassate.stop();
		timelineMovDino.play();
	}
	if(evento.getText().equals("d") ) {
		if(quadro.getChildren().contains(rettangoloFiamma) && quadro.getChildren().contains(fiammataView)) {
			quadro.getChildren().remove(fiammataView);
			quadro.getChildren().remove(rettangoloFiamma);
		}else {
			quadro.getChildren().add(fiammataView);
			quadro.getChildren().add(rettangoloFiamma);
			fiammataView.setX(158);
			fiammataView.setY(273);
			rettangoloFiamma.setX(200);
			rettangoloFiamma.setY(289);
			rettangoloFiamma.setRotate(90);
			rettangoloFiamma.setVisible(false);
		}
		
	}
	if(evento.getText().equals("D") ) {
		fiammataView.setX(158);
		fiammataView.setY(273);
		rettangoloFiamma.setX(200);
		rettangoloFiamma.setY(289);
		rettangoloFiamma.setRotate(90);
		quadro.getChildren().add(fiammataView);
		quadro.getChildren().add(rettangoloFiamma);
		rettangoloFiamma.setVisible(false);
	}
	if(evento.getCode() == KeyCode.RIGHT ) {
		fiammataView.setX(158);
		fiammataView.setY(273);
		rettangoloFiamma.setX(200);
		rettangoloFiamma.setY(289);
		rettangoloFiamma.setRotate(90);
		quadro.getChildren().add(fiammataView);
		quadro.getChildren().add(rettangoloFiamma);
		rettangoloFiamma.setVisible(false);

	}
}
public static void main(String[] args) {
	launch(args);
}
}
