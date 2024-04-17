package it.edu.iisgubbio.dino;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

// caricamento elementi necessari ( Label, ecc... )

public class ProgrammaPrincipale extends Application{
	Pane quadro= new Pane();
	Label eTitolo = new Label("Dino game");
	Label eSottoTitolo = new Label("affronta il deserto con Dino!");
	Label ePunteggio = new Label("");
	Label ePunteggioRecord = new Label("Record: 0000");
	Label eSconfitta = new Label("G A M E  O V E R !");
	Label eDifficoltà= new Label("Come vuoi giocare?");
	Button pStart = new Button("start!");
	Button pRestart = new Button("restart!");
	Button pMenù = new Button("");
	Button pFacile = new Button("facile");
	Button pMedio = new Button("medio");
	Button pDifficile = new Button("difficile");
	Button pEstremo = new Button("estremo");

	// variabili per millisec. timeline

	final int VELOCITA_DINO=20;
	double velocitaCielo=0.25;
	double velocitàMontagne=0.5;
	double velocitàCactusUccelli=2;
	double velocitàSaltoSu=20;
	double velocitàSaltoGiu=8;
	double velocitàGioco=5.0;	

	// varie timeline

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
			Duration.millis(52),
			x -> zampette()));
	Timeline timelineEntrataInziale = new Timeline(new KeyFrame(
			Duration.millis(0.1),
			x -> entrataIniziale()));
	Timeline timelineFiammata = new Timeline(new KeyFrame(
			Duration.millis(velocitàGioco),
			x -> spostaFiamma()));

	// creazione dei rettangoli per bound preciso

	Rectangle rettangoloCactus1 = new Rectangle(15,70);
	Rectangle rettangoloCactus2 = new Rectangle(15,70);
	Rectangle rettangoloUccello1 = new Rectangle(9,60);
	Rectangle rettangoloUccello2 = new Rectangle(9,60);
	Rectangle rettangoloDinoTesta = new Rectangle(9,37);
	Rectangle rettangoloDinoCorpo = new Rectangle(9,70);
	Rectangle rettangoloDinoCoda = new Rectangle(9,37);

	// caricamento immagini

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
	Image cactus = new Image(getClass().getResourceAsStream("cactusPerProgramma.png"));
	ImageView cactusView = new ImageView(cactus);
	Image cactus2 = new Image(getClass().getResourceAsStream("cactusPerProgramma.png"));
	ImageView cactusView2 = new ImageView(cactus2);
	Image uccello = new Image(getClass().getResourceAsStream("uccelloPerProgramma.png"));
	ImageView uccelloView = new ImageView(uccello);
	Image uccello2 = new Image(getClass().getResourceAsStream("uccelloPerProgramma.png"));
	ImageView uccelloView2 = new ImageView(uccello2);
	Image esplosione = new Image(getClass().getResourceAsStream("esplosione.gif"));
	ImageView esplosioneView = new ImageView(esplosione);
	Image menù = new Image(getClass().getResourceAsStream("menu.png"));
	ImageView menùView = new ImageView(menù);

	// aggiunta audio effects

	final AudioClip scoreup = new AudioClip(getClass().getResource("scoreup.wav").toString());
	final AudioClip morte = new AudioClip(getClass().getResource("dead.wav").toString());
	final AudioClip salto = new AudioClip(getClass().getResource("jump.wav").toString());
	final AudioClip fiamma = new AudioClip(getClass().getResource("fiamma.wav").toString());

	// varie variabili utili nel programma

	int segnaPunti=0;
	int incrementaFiamme=1;
	int indiceRettangoli=0;
	int contaSec=1;
	int indicePunti=0;
	int record=0;
	int indiceBoundFiamma=0;

	// creazione vettori

	int vettorePunti[]= new int[500];
	ImageView vettoreFiamme[];
	Rectangle rettangoliFiamme[];

	// creazione boolean

	boolean arrivatoSù=false;
	boolean isDinoImage1 = true;
	boolean rilasciatoW=false;
	boolean arrivatoGiù=false;
	boolean sopra=false;
	boolean sopraSecondo=false;

	public void start (Stage finestra) {

		// sistemaz. cyclecount timeline

		timelineSfondo.setCycleCount(Timeline.INDEFINITE);

		timelineFiammata.setCycleCount(Timeline.INDEFINITE);

		timelineMovDino.setCycleCount(Timeline.INDEFINITE);

		timelinePunteggio.setCycleCount(Timeline.INDEFINITE);

		timelineZampette.setCycleCount(Timeline.INDEFINITE);

		// sistemaz. prima schermata

		quadro.getChildren().add(eSconfitta);
		eSconfitta.setLayoutX(-200);
		eSconfitta.setLayoutY(-200);
		eSconfitta.setId("sconfitta");

		quadro.getChildren().add(pRestart);
		pRestart.setLayoutX(-300);
		pRestart.setLayoutY(-300);
		pRestart.setId("restart");

		quadro.getChildren().add(ePunteggio);
		quadro.setId("sottoTitolo");

		quadro.getChildren().add(cieloView);

		quadro.getChildren().add(montagneView);
		montagneView.setY(160);

		quadro.getChildren().add(terrenoView);
		terrenoView.setY(370);

		quadro.getChildren().add(cactusView);
		cactusView.setX(410);
		cactusView.setY(50);

		quadro.getChildren().add(eTitolo);
		eTitolo.setLayoutX(230);
		eTitolo.setLayoutY(80);
		eTitolo.setId("titolo");

		quadro.getChildren().add(pMenù);
		pMenù.setLayoutX(10);
		pMenù.setLayoutY(10);
		pMenù.setGraphic(menùView);
		menùView.setPreserveRatio(true);
		menùView.setFitHeight(15);
		pMenù.getStyleClass().add("menuBottone");

		quadro.getChildren().add(eSottoTitolo);
		eSottoTitolo.setLayoutX(230);
		eSottoTitolo.setLayoutY(150);
		eSottoTitolo.setId("sottoTitolo");

		quadro.getChildren().add(pStart);
		pStart.setLayoutX(330);
		pStart.setLayoutY(230);
		pStart.setId("start");

		//sistemaz. fit dei vari oggetti

		cieloView.setFitWidth(800);
		cieloView2.setFitWidth(800);
		cieloView2.setX(800);
		montagneView.setFitWidth(800);
		montagneView2.setFitWidth(800);
		montagneView2.setX(800);
		terrenoView.setFitWidth(800);
		terrenoView2.setFitWidth(800);
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


		// aggiunta bottoni

		pStart.setOnAction(e -> sceltaDifficoltà());
		pRestart.setOnAction(e -> sceltaDifficoltà());
		pFacile.setOnAction(e -> facile());
		pMedio.setOnAction(e -> medio());
		pDifficile.setOnAction(e -> difficile());
		pEstremo.setOnAction(e -> estremo());
		
		Scene scena = new Scene (quadro, 750, 500);
		scena.getStylesheets().add("it/edu/iisgubbio/dino/Dino.css");
		scena.setOnKeyPressed(e -> pigiato(e));

		// aggiunta icona finestra

		finestra.getIcons().add(dinosauro3);

		finestra.setTitle("Gioca con Dino!");
		finestra.setScene(scena);
		finestra.show();

	}
	public void sceltaDifficoltà(){
		quadro.getChildren().remove(eSconfitta);
		quadro.getChildren().remove(pRestart);
		Region sceltaMenu = new Region();
		sceltaMenu.setPrefWidth(250);
		sceltaMenu.setPrefHeight(300);
		sceltaMenu.setLayoutX(250);
		sceltaMenu.setLayoutY(150);
		quadro.getChildren().remove(pStart);
		quadro.getChildren().remove(eTitolo);
		quadro.getChildren().remove(eSottoTitolo);
		quadro.getChildren().add(sceltaMenu);
		quadro.getChildren().add(eDifficoltà);
		eDifficoltà.setId("difficolta");
		eDifficoltà.setLayoutX(195);
		eDifficoltà.setLayoutY(65);
		sceltaMenu.setId("menu");
		cactusView.setX(-70);
		cactusView.setY(-100);
		quadro.getChildren().add(pFacile);
		pFacile.getStyleClass().add("bottoniDifficolta");
		pFacile.setLayoutX(322);
		pFacile.setLayoutY(180);
		pFacile.setPrefSize(110, 30);
		
		quadro.getChildren().add(pMedio);
		pMedio.getStyleClass().add("bottoniDifficolta");
		pMedio.setLayoutX(322);
		pMedio.setLayoutY(243);
		pMedio.setPrefSize(110, 30);
		
		quadro.getChildren().add(pDifficile);
		pDifficile.getStyleClass().add("bottoniDifficolta");
		pDifficile.setLayoutX(322);
		pDifficile.setLayoutY(307);
		pDifficile.setPrefSize(110, 30);
		
		quadro.getChildren().add(pEstremo);
		pEstremo.getStyleClass().add("bottoniDifficolta");
		pEstremo.setLayoutX(322);
		pEstremo.setLayoutY(372);
		pEstremo.setPrefSize(110, 30);
		
		InnerShadow ombra = new InnerShadow();
		ombra.setRadius(10);
		sceltaMenu.setEffect(ombra);
	}
	public void facile() {
		velocitaCielo=0.05;
		velocitàMontagne=0.25;
		velocitàCactusUccelli=0.5;
		velocitàSaltoSu=15;
		velocitàSaltoGiu=6;
		giocoPrincipale();
	}
	public void medio() {
		velocitaCielo=0.25;
		velocitàMontagne=0.5;
		velocitàCactusUccelli=1;
		velocitàSaltoSu=20;
		velocitàSaltoGiu=8;
		giocoPrincipale();
	}
	public void difficile() {
		velocitaCielo=0.5;
		velocitàMontagne=1;
		velocitàCactusUccelli=2.5;
		velocitàSaltoSu=22;
		velocitàSaltoGiu=10;
		giocoPrincipale();
	}
	public void estremo() {
		velocitaCielo=1;
		velocitàMontagne=2;
		velocitàCactusUccelli=4;
		velocitàSaltoSu=20;
		velocitàSaltoGiu=8;
		giocoPrincipale();
	}
	public void giocoPrincipale() {
		
		// aggiunta elementi a pane

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
		quadro.getChildren().add(eSconfitta);
		quadro.getChildren().add(pRestart);

		// caricamento vettori fiamme e rettangoli fiamme

		vettoreFiamme = new ImageView[1000];
		for(int indiceFiamma=0; indiceFiamma<vettoreFiamme.length;indiceFiamma++) {
			Image fiammata = new Image(getClass().getResourceAsStream("fiammata.png"));
			ImageView fiammataView = new ImageView(fiammata);
			vettoreFiamme[indiceFiamma]=fiammataView;
		}
		rettangoliFiamme = new Rectangle[1000];
		for(indiceRettangoli=0; indiceRettangoli<rettangoliFiamme.length;indiceRettangoli++) {
			Rectangle rettangoloFiamma = new Rectangle(10,60);

			rettangoliFiamme[indiceRettangoli]=rettangoloFiamma;
		}

		// sistemaz. punteggi 

		quadro.getChildren().add(ePunteggio);
		quadro.getChildren().add(ePunteggioRecord);
		quadro.setId("sottoTitolo");

		ePunteggio.setLayoutX(700);
		ePunteggio.setLayoutY(20);
		ePunteggio.setId("punteggio");

		ePunteggioRecord.setLayoutX(30);
		ePunteggioRecord.setLayoutY(20);
		ePunteggioRecord.setId("punteggio");

		// sistemaz. pulsanti

		eSconfitta.setLayoutX(-500);
		pRestart.setLayoutX(-500);

		// sistemaz. GIF esplosione

		esplosioneView.setX(-550);
		esplosioneView.setY(-550);

		// sistemaz. coordinate rettangoli cactus

		rettangoloCactus1.setX(782);
		rettangoloCactus1.setY(327);
		rettangoloCactus2.setY(327);
		rettangoloCactus2.setX(-800);

		// sistemaz. rettangoli dietro del dino

		rettangoloDinoTesta.setX(140);
		rettangoloDinoTesta.setY(290);
		rettangoloDinoTesta.setRotate(90);

		rettangoloDinoCorpo.setX(119);
		rettangoloDinoCorpo.setY(300);

		rettangoloDinoCoda.setX(100);
		rettangoloDinoCoda.setY(350);
		rettangoloDinoCoda.setRotate(90);

		// sistemaz. rettangoli uccelli

		rettangoloUccello1.setRotate(90);
		rettangoloUccello2.setRotate(90);
		rettangoloUccello1.setY(295);
		rettangoloUccello1.setX(-800);
		rettangoloUccello2.setY(220);
		rettangoloUccello2.setX(-800);

		// sistemaz. oggetti da nascondere

		rettangoloDinoTesta.setVisible(false);
		rettangoloDinoCorpo.setVisible(false);
		rettangoloDinoCoda.setVisible(false);
		rettangoloCactus1.setVisible(false);
		rettangoloCactus2.setVisible(false);
		rettangoloUccello1.setVisible(false);
		rettangoloUccello2.setVisible(false);
		uccelloView2.setVisible(false);
		uccelloView.setVisible(false);

		// sistemaz. coordinate elementi grafici terreno e montagne

		montagneView.setY(160);
		montagneView2.setY(160);

		terrenoView.setY(370);
		terrenoView2.setY(370);

		// sistemaz. coordinate elementi grafici dinosauro

		dinosauroView.setX(-30);
		dinosauroView.setY(300);
		dinosauroView2.setX(-30);
		dinosauroView2.setY(300);
		dinosauroView3.setX(70);
		dinosauroView3.setY(300);
		dinosauroView4.setX(70);
		dinosauroView4.setY(300);

		// sistemaz. coordinate elementi grafici cactus e uccello

		cactusView.setX(700);
		cactusView.setY(317);
		cactusView2.setX(2170);
		cactusView2.setY(317);

		uccelloView.setX(0);
		uccelloView.setY(270);
		uccelloView2.setX(2340);
		uccelloView2.setY(200);

		// avvio timeline

		timelinePunteggio.play();
		timelineZampette.play();
	}

	// sistemaz. oggetti vari e aggiornamento dello sfondo

	private void aggiornaSfondo() {
		cieloView.setX(cieloView.getX()-velocitaCielo);
		cieloView2.setX(cieloView2.getX()-velocitaCielo);
		if(cieloView2.getX()==0) {
			cieloView.setX(800);
		}
		if(cieloView.getX()==0) {
			cieloView2.setX(800);
		}
		montagneView.setX(montagneView.getX()-velocitàMontagne);
		montagneView2.setX(montagneView2.getX()-velocitàMontagne);
		if(montagneView2.getX()==0) {
			montagneView.setX(800);
		}
		if(montagneView.getX()==0) {
			montagneView2.setX(800);
		}
		terrenoView.setX(terrenoView.getX()-velocitàCactusUccelli);
		terrenoView2.setX(terrenoView2.getX()-velocitàCactusUccelli);
		if(terrenoView2.getX()==0) {
			terrenoView.setX(800);
		}
		if(terrenoView.getX()==0) {
			terrenoView2.setX(800);
		}
		cactusView.setX(cactusView.getX()-velocitàCactusUccelli);
		rettangoloCactus1.setX(rettangoloCactus1.getX()-velocitàCactusUccelli);
		if(cactusView.getX()==0) {
			uccelloView.setVisible(true);
			uccelloView.setX(720);
			rettangoloUccello1.setX(755);
		}

		//uccelloView Y

		if(uccelloView.getY()==259) {
			sopra=false;
		}
		if(uccelloView.getY()==300) {
			sopra=true;
		}
		if(sopra==false) {
			uccelloView.setY(uccelloView.getY()+0.25);
			rettangoloUccello1.setY(rettangoloUccello1.getY()+0.25);
			rettangoloUccello1.setX(rettangoloUccello1.getX()-velocitàCactusUccelli);
			uccelloView.setX(uccelloView.getX()-velocitàCactusUccelli);
		}else {
			uccelloView.setY(uccelloView.getY()-0.25);
			rettangoloUccello1.setY(rettangoloUccello1.getY()-0.25);
			rettangoloUccello1.setX(rettangoloUccello1.getX()-velocitàCactusUccelli);
			uccelloView.setX(uccelloView.getX()-velocitàCactusUccelli);
		}
		if(uccelloView.getX()==0) {
			cactusView2.setX(700);
			rettangoloCactus2.setX(782);
		}

		rettangoloCactus2.setX(rettangoloCactus2.getX()-velocitàCactusUccelli);
		cactusView2.setX(cactusView2.getX()-velocitàCactusUccelli);
		if(cactusView2.getX()==0) {
			uccelloView2.setVisible(true);
			uccelloView2.setX(720);
			rettangoloUccello2.setX(755);
		}
		if(uccelloView2.getY()==200) {
			sopraSecondo=false;
		}
		if(uccelloView2.getY()==240) {
			sopraSecondo=true;
		}
		if(sopraSecondo==false) {
			uccelloView2.setY(uccelloView2.getY()+0.25);
			rettangoloUccello2.setY(rettangoloUccello2.getY()+0.25);
			rettangoloUccello2.setX(rettangoloUccello2.getX()-velocitàCactusUccelli);
			uccelloView2.setX(uccelloView2.getX()-velocitàCactusUccelli);
		}else {
			uccelloView2.setY(uccelloView2.getY()-0.25);
			rettangoloUccello2.setY(rettangoloUccello2.getY()-0.25);
			rettangoloUccello2.setX(rettangoloUccello2.getX()-velocitàCactusUccelli);
			uccelloView2.setX(uccelloView2.getX()-velocitàCactusUccelli);
		}
		if(uccelloView2.getX()==0) {
			cactusView.setX(700);
			rettangoloCactus1.setX(782);
		}

		// contollo collisione bound 

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

		Shape intDinoUccelloFiamma1 = Shape.intersect(rettangoliFiamme[incrementaFiamme], rettangoloUccello1);
		Shape intDinoUccelloFiamma2 = Shape.intersect(rettangoliFiamme[incrementaFiamme], rettangoloUccello2);


		if (intDino1.getBoundsInLocal().getWidth() != -1){
			sconfitta();
		}
		if (intDino2.getBoundsInLocal().getWidth() != -1){
			sconfitta();
		}
		if (intDinoCorpo1.getBoundsInLocal().getWidth() != -1){
			sconfitta();
		}
		if (intDinoCorpo2.getBoundsInLocal().getWidth() != -1){
			sconfitta();
		}
		if (intDinoCoda1.getBoundsInLocal().getWidth() != -1){
			sconfitta();
		}
		if (intDinoCoda2.getBoundsInLocal().getWidth() != -1){
			sconfitta();
		}
		if (intDinoUccello1.getBoundsInLocal().getWidth() != -1){
			sconfitta();
		}
		if (intDinoUccello2.getBoundsInLocal().getWidth() != -1){
			sconfitta();
		}
		if (intDinoCorpoUccello1.getBoundsInLocal().getWidth() != -1){
			sconfitta();
		}
		if (intDinoCorpoUccello2.getBoundsInLocal().getWidth() != -1){
			sconfitta();
		}
		if (intDinoCodaUccello1.getBoundsInLocal().getWidth() != -1){
			sconfitta();
		}
		if (intDinoCodaUccello2.getBoundsInLocal().getWidth() != -1){
			sconfitta();
		}

		// condizione per bound con fiamma e appariz. GIF 

		if (intDinoUccelloFiamma1.getBoundsInLocal().getWidth() != -1){
			indiceBoundFiamma++;
			contaSec=1;
			esplosioneView.setX(uccelloView.getX());
			esplosioneView.setY(uccelloView.getY());
			esplosioneView.setFitHeight(85);
			esplosioneView.setPreserveRatio(true);
			Timeline timelineRimuoviGIF = new Timeline(new KeyFrame(
					Duration.seconds(1),
					x -> rimuoviGIF()));
			timelineRimuoviGIF.setCycleCount(2);
			timelineRimuoviGIF.play();
			uccelloView.setVisible(false);
			rettangoloUccello1.setX(-600);
		}
		if (intDinoUccelloFiamma2.getBoundsInLocal().getWidth() != -1){
			indiceBoundFiamma++;
			contaSec=1;
			System.out.println("fiamma 2!");
			esplosioneView.setFitHeight(85);
			esplosioneView.setPreserveRatio(true);
			Timeline timelineRimuoviGIF = new Timeline(new KeyFrame(
					Duration.seconds(1),
					x -> rimuoviGIF()));
			timelineRimuoviGIF.setCycleCount(2);
			timelineRimuoviGIF.play();
			uccelloView2.setVisible(false);
			rettangoloUccello2.setX(-600);
		}
	}

	// funzione della rimoz. della GIF dopo bound di uccelli con fiamma

	private void rimuoviGIF(){
		contaSec-=1;
		esplosioneView.setX(esplosioneView.getX()-1);
		esplosioneView.setY(esplosioneView.getY()-1);
		if(contaSec==0) {
			if(quadro.getChildren().contains(esplosioneView)) {
				esplosioneView.setX(-500);
			}
		}
	}

	// funzione giiornamento del punteggio

	private void aggiornaPunteggio() {
		if(dinosauroView.getX()> 70||dinosauroView2.getX()> 70||dinosauroView3.getX()> 70) {
			if(segnaPunti%100==0 && segnaPunti!=0) {
				scoreup.play();
			}
			segnaPunti++;
			ePunteggio.setText(""+segnaPunti);	
		}
	}

	// funzione della sconfitta in caso di bound con oggetti 

	private void sconfitta() {
		morte.play();
		timelineSfondo.stop();
		timelinePunteggio.stop();
		timelineZampette.stop();
		ePunteggio.setText(""+segnaPunti);
		record=segnaPunti;
		vettorePunti[indicePunti]=segnaPunti;
		for(int scorrimento=0; scorrimento < indicePunti; scorrimento++) {
			if(record<vettorePunti[scorrimento]) {
				record=vettorePunti[scorrimento];
			}
		}
		ePunteggioRecord.setText("Record: "+record);
		indicePunti++;
		if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)||quadro.getChildren().contains(dinosauroView3)) {
			quadro.getChildren().remove(dinosauroView);
			quadro.getChildren().remove(dinosauroView2);
			quadro.getChildren().remove(dinosauroView3);
			quadro.getChildren().add(dinosauroView4);
		}

		eSconfitta.setLayoutX(175);
		eSconfitta.setLayoutY(110);

		pRestart.setLayoutX(327);
		pRestart.setLayoutY(200);
	}

	// funzione restart in caso di morte 

	private void restart() {
		quadro.getChildren().clear();
		if(segnaPunti>0) {
			segnaPunti=0;
		}
		giocoPrincipale();
	}

	// funzione del movimento alternato delle zampette del dino

	private void zampette() {
		if (isDinoImage1) {
			if(dinosauroView.getX()<=70) {
				timelineEntrataInziale.play();
			}else {
				timelineSfondo.play();
			}
			if (!quadro.getChildren().contains(dinosauroView)) {
				quadro.getChildren().add(dinosauroView);
			}
			if (quadro.getChildren().contains(dinosauroView2)) {
				quadro.getChildren().remove(dinosauroView2);
			}
		} else {
			if(dinosauroView2.getX()<=70) {
				timelineEntrataInziale.play();
			}else {
				timelineSfondo.play();
			}
			if (!quadro.getChildren().contains(dinosauroView2)) {
				quadro.getChildren().add(dinosauroView2);
			}
			if (quadro.getChildren().contains(dinosauroView)) {
				quadro.getChildren().remove(dinosauroView);
			}
		}
		isDinoImage1 = !isDinoImage1;
	}

	// funzione timer per movimento iniziale da sinistra del dino

	private void entrataIniziale() {
		dinosauroView.setX(dinosauroView.getX()+8);
		dinosauroView2.setX(dinosauroView2.getX()+8);
	}

	// funzione movimento salto dino con tasti w e W 

	private void muoviDino() {
		if(arrivatoSù==false) {
			rettangoloDinoTesta.setY(rettangoloDinoTesta.getY()-velocitàSaltoSu);
			rettangoloDinoCorpo.setY(rettangoloDinoCorpo.getY()-velocitàSaltoSu);
			rettangoloDinoCoda.setY(rettangoloDinoCoda.getY()-velocitàSaltoSu);
			dinosauroView3.setY(dinosauroView3.getY()-velocitàSaltoSu);
			if(dinosauroView3.getY()<=120) {
				salto.play();
				arrivatoSù=true;
			}
		}else {
			if(arrivatoSù) {
				rettangoloDinoTesta.setY(rettangoloDinoTesta.getY()+velocitàSaltoGiu);
				rettangoloDinoCorpo.setY(rettangoloDinoCorpo.getY()+velocitàSaltoGiu);
				rettangoloDinoCoda.setY(rettangoloDinoCoda.getY()+velocitàSaltoGiu);
				dinosauroView3.setY(dinosauroView3.getY()+velocitàSaltoGiu);
				if(dinosauroView3.getY()>=300) {
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
				arrivatoSù=false;
				arrivatoGiù=false;
			}
		}
	}

	// scorrimento vettore fiamme e animaz. fiamma

	private void spostaFiamma() {
		for(int indiceMinoreFiamme=0; indiceMinoreFiamme<incrementaFiamme;indiceMinoreFiamme++) {
			if(quadro.getChildren().contains(vettoreFiamme[indiceMinoreFiamme])) {
				vettoreFiamme[indiceMinoreFiamme].setX(vettoreFiamme[indiceMinoreFiamme].getX()+6);
				rettangoliFiamme[indiceMinoreFiamme].setX(rettangoliFiamme[indiceMinoreFiamme].getX()+6);
			}
		}
		vettoreFiamme[incrementaFiamme].setX(vettoreFiamme[incrementaFiamme].getX()+6);
		rettangoliFiamme[incrementaFiamme].setX(rettangoliFiamme[incrementaFiamme].getX()+6);
		if(rettangoliFiamme[incrementaFiamme].getX()>=700 && vettoreFiamme[incrementaFiamme].getX()>=700) {
			quadro.getChildren().remove(rettangoliFiamme[incrementaFiamme]);
			quadro.getChildren().remove(vettoreFiamme[incrementaFiamme]);
		}
	}
	private void pigiato(KeyEvent evento) {

		// funzione fiamma tasto w e W
		if(dinosauroView.getX()>=70 || dinosauroView2.getX()>=70) {
			if(evento.getText().equals("w") || evento.getText().equals("W")) {
				if (quadro.getChildren().contains(dinosauroView)||quadro.getChildren().contains(dinosauroView2)) {
					quadro.getChildren().remove(dinosauroView);
					quadro.getChildren().remove(dinosauroView2);
					quadro.getChildren().add(dinosauroView3);
				}
				salto.play();
				timelineMovDino.play();
				timelineZampette.stop();
			}
		}
			

		// funzione fiamma tasto d e D
		if(dinosauroView.getX()>=70 || dinosauroView2.getX()>=70) {
			if(evento.getText().equals("d") || evento.getText().equals("D")) {
				incrementaFiamme++;
				fiamma.play();
				vettoreFiamme[incrementaFiamme].setFitHeight(95);
				vettoreFiamme[incrementaFiamme].setPreserveRatio(true);
				vettoreFiamme[incrementaFiamme].setX(158);
				vettoreFiamme[incrementaFiamme].setY(dinosauroView3.getY()-27);
				rettangoliFiamme[incrementaFiamme].setX(200);
				rettangoliFiamme[incrementaFiamme].setY(dinosauroView3.getY()-11);
				rettangoliFiamme[incrementaFiamme].setRotate(90);
				quadro.getChildren().add(rettangoliFiamme[incrementaFiamme]);
				quadro.getChildren().add(vettoreFiamme[incrementaFiamme]);
				rettangoliFiamme[incrementaFiamme].setVisible(false);
				timelineFiammata.play();
			}
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}