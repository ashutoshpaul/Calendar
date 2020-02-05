//Calendar App
import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javafx.application.Application;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.collections.*;
import javafx.scene.effect.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import java.net.URL;
import java.util.*;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.animation.FadeTransition;


public class Cal extends Application
{
	int width = 440;
	int height = 400+120+50;
	int current_skin = 0;
	int now , month , year , max_day;
	int current_day , current_month , current_year;
	boolean month_display = false , first_time = true;
	
	Label title = new Label();
	AnchorPane root = new AnchorPane();
	AnchorPane up = new AnchorPane();
	TranslateTransition show_opts = new TranslateTransition();
	Label copyright = new Label();
	String bgcolor = "#81E61A";
	String bcolor = "#1F3C1C";
	String background = "-fx-background-color: '"+ bgcolor + "';";
	Label board = new Label();
	Button today = new Button("Today");
	Button options = new Button("...");
	Tooltip ott = new Tooltip("Options");
	Label calback = new Label();
	Label cal = new Label();
	Button back = new Button("");
	Tooltip btt = new Tooltip("Go back to Calendar");
	Button colon = new Button(">");
	Label div = new Label();
	Label skin = new Label("                     Skin");
	
	Button[] day = new Button[7];
	Button[] date = new Button[35];
	Button[] month_name = new Button[12];
	
	AnchorPane month_view = new AnchorPane();
	
	Image image0 = new Image(getClass().getResourceAsStream("app icons/layout0.png"));
	Image image1 = new Image(getClass().getResourceAsStream("app icons/layout1.png"));
	Image image2 = new Image(getClass().getResourceAsStream("app icons/layout2.png"));
	Image image3 = new Image(getClass().getResourceAsStream("app icons/layout3.png"));
	Image image4 = new Image(getClass().getResourceAsStream("app icons/layout4.png"));
	
	Button skin0 = new Button("" , new ImageView(image0));
	Button skin1 = new Button("" , new ImageView(image1));
	Button skin2 = new Button("" , new ImageView(image2));
	Button skin3 = new Button("" , new ImageView(image3));
	Button skin4 = new Button("" , new ImageView(image4));
	
	Image tick_icon0 = new Image(getClass().getResourceAsStream("app icons/selected0.png"));
	Image tick_icon1 = new Image(getClass().getResourceAsStream("app icons/selected1.png"));
	Image tick_icon2 = new Image(getClass().getResourceAsStream("app icons/selected2.png"));
	Image tick_icon3 = new Image(getClass().getResourceAsStream("app icons/selected3.png"));
	Image tick_icon4 = new Image(getClass().getResourceAsStream("app icons/selected4.png"));
	
	Label circle0 = new Label();
	Label circle1 = new Label();
	Label circle2 = new Label();
	Label circle3 = new Label();
	Label circle4 = new Label();
	
	Tooltip ntt = new Tooltip("Towards future");
	Tooltip ptt = new Tooltip("Towards past");
	
	Image image_next0 = new Image(getClass().getResourceAsStream("app icons/next0.png"));
	Image image_prev0 = new Image(getClass().getResourceAsStream("app icons/prev0.png"));
	Button next0 = new Button("" , new ImageView(image_next0));
	Button prev0 = new Button("" , new ImageView(image_prev0));
	
	Image image_next1 = new Image(getClass().getResourceAsStream("app icons/next1.png"));
	Image image_prev1 = new Image(getClass().getResourceAsStream("app icons/prev1.png"));
	Button next1 = new Button("" , new ImageView(image_next1));
	Button prev1 = new Button("" , new ImageView(image_prev1));
	
	Image image_next2 = new Image(getClass().getResourceAsStream("app icons/next2.png"));
	Image image_prev2 = new Image(getClass().getResourceAsStream("app icons/prev2.png"));
	Button next2 = new Button("" , new ImageView(image_next2));
	Button prev2 = new Button("" , new ImageView(image_prev2));
	
	Image image_next3 = new Image(getClass().getResourceAsStream("app icons/next3.png"));
	Image image_prev3 = new Image(getClass().getResourceAsStream("app icons/prev3.png"));
	Button next3 = new Button("" , new ImageView(image_next3));
	Button prev3 = new Button("" , new ImageView(image_prev3));
	
	Image image_next4 = new Image(getClass().getResourceAsStream("app icons/next4.png"));
	Image image_prev4 = new Image(getClass().getResourceAsStream("app icons/prev4.png"));
	Button next4 = new Button("" , new ImageView(image_next4));
	Button prev4 = new Button("" , new ImageView(image_prev4));
	
	public Cal()
	{
		
		//month_name
		month_name[0] = new Button("Jan");
		month_name[1] = new Button("Feb");
		month_name[2] = new Button("Mar");
		month_name[3] = new Button("Apr");
		month_name[4] = new Button("May");
		month_name[5] = new Button("Jun");
		month_name[6] = new Button("Jul");
		month_name[7] = new Button("Aug");
		month_name[8] = new Button("Sep");
		month_name[9] = new Button("Oct");
		month_name[10] = new Button("Nov");
		month_name[11] = new Button("Dec");
		
		month_view.setPrefSize(382.0 , 337.0);
		for(int i = 0 ; i < 12 ; i++)
		{
			month_name[i].setPrefSize(105.0 , 63.31);
			month_view.getChildren().addAll(month_name[i]);
		}
		
		for(int i = 0 ; i < 11 ; i += 3)
			AnchorPane.setLeftAnchor(month_name[i], 16.75);
		for(int i = 1 ; i < 11 ; i += 3)
			AnchorPane.setLeftAnchor(month_name[i], 16.75 + 105.0 + 16.75);
		for(int i = 2 ; i < 12 ; i += 3)
			AnchorPane.setLeftAnchor(month_name[i], 16.75 + 105.0 + 16.75 + 105.0 + 16.75);
		
		for(int i = 0 ; i < 3 ; i++)
			AnchorPane.setTopAnchor(month_name[i], 16.75);
		for(int i = 3 ; i < 6 ; i++)
			AnchorPane.setTopAnchor(month_name[i], 16.75 + 63.31 + 16.75);
		for(int i = 6 ; i < 9 ; i++)
			AnchorPane.setTopAnchor(month_name[i], 16.75 + (63.31 + 16.75) * 2);
		for(int i = 9 ; i < 12 ; i++)
			AnchorPane.setTopAnchor(month_name[i], 16.75 + (63.31 + 16.75) * 3);
		
		next0.setTooltip(ntt);
		next1.setTooltip(ntt);
		next2.setTooltip(ntt);
		next3.setTooltip(ntt);
		next4.setTooltip(ntt);
		
		prev0.setTooltip(ptt);
		prev1.setTooltip(ptt);
		prev2.setTooltip(ptt);
		prev3.setTooltip(ptt);
		prev4.setTooltip(ptt);
		
		circle0.setGraphic(new ImageView(tick_icon0));
		circle1.setGraphic(new ImageView(tick_icon1));
		circle2.setGraphic(new ImageView(tick_icon2));
		circle3.setGraphic(new ImageView(tick_icon3));
		circle4.setGraphic(new ImageView(tick_icon4));
		
		colon.setRotate(-90.0);
		
		day[0] = new Button("SUN");
		day[1] = new Button("MON");
		day[2] = new Button("TUE");
		day[3] = new Button("WED");
		day[4] = new Button("THU");
		day[5] = new Button("FRI");
		day[6] = new Button("SAT");
		
		//day
		for(int i = 0 ; i < 7 ; i++)
		{
			day[i].setPrefSize(50.0 , 50.0);
		    day[i].setStyle("-fx-font-family: 'Franklin Gothic Medium Cond';"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;"+"-fx-background-color: '#19B227';"+"-fx-text-fill: white;");
		}
		
		//date
		for(int i = 0 ; i < 35 ; i++)
		{
			//available date = #61F8F7   .....  sky blue
			date[i] = new Button();
			date[i].setPrefSize(50.0 , 50.0);
		    date[i].setStyle("-fx-font-family: 'Century Schoolbook';"+"-fx-font-weight: normal;"+"-fx-font-size: 15px;"+"-fx-background-color: '#C7C8C8';"+"-fx-text-fill: black;");
		}
		
		calback.setStyle("-fx-background-color: '#F680DF';");
		cal.setText("	   CALENDAR");
		
		ott.setStyle("-fx-background-color: white;"+"-fx-text-fill: black;"+"-fx-font-weight: normal;"+"-fx-font-size: 15px;");
		options.setTooltip(ott);
		btt.setStyle("-fx-font-family: 'Ariel';"+"-fx-background-color: white;"+"-fx-text-fill: black;"+"-fx-font-weight: normal;"+"-fx-font-size: 15px;");
		back.setTooltip(btt);
		colon.setTooltip(btt);
		
		ntt.setStyle(ott.getStyle());
		ptt.setStyle(ott.getStyle());
		
		board.setStyle("-fx-background-color: '" + bcolor + "';");
		
		
		copyright.setText((char)169 + " All Rights Reserved By Ashutosh Paul.");
		copyright.setStyle("-fx-text-fill: orangered;"+"-fx-font-size: 12px;");
	}
	
	public void SetLayout(int num)
	{
		current_skin = num;
		RetrieveSkinData(true);
		if(num == 0)
		{
			bgcolor = "#81E61A";
			bcolor = "#1F3C1C";
			
			month_view.setStyle("-fx-background-color: '" + bgcolor + "';");
			for(int i = 0 ; i < 12 ; i++)
			{
				month_name[i].setStyle("-fx-font-size: 15px;"+"-fx-font-weight: bold;"+"-fx-text-fill: white;"+"-fx-background-color: '" + bcolor + "';");
			}
				
			next0.setStyle("-fx-background-color: '" + bcolor + "';");
			prev0.setStyle("-fx-background-color: '" + bcolor + "';");
			
			title.setStyle("-fx-text-fill: white;"+"-fx-font-size: 30px;"+"-fx-font-weight: bold;"+"-fx-background-color: '" + bcolor + "';");
			
			next0.setVisible(true);
			prev0.setVisible(true);
			
			next1.setVisible(false);
			prev1.setVisible(false);
			next2.setVisible(false);
			prev2.setVisible(false);
			next3.setVisible(false);
			prev3.setVisible(false);
			next4.setVisible(false);
			prev4.setVisible(false);
			
			
			circle0.setVisible(true);
			circle1.setVisible(false);
			circle2.setVisible(false);
			circle3.setVisible(false);
			circle4.setVisible(false);
			
			skin0.setStyle("-fx-background-color: '#56E60F';");
			skin1.setStyle(skin0.getStyle());
			skin2.setStyle(skin0.getStyle());
			skin3.setStyle(skin0.getStyle());
			skin4.setStyle(skin0.getStyle());
			skin.setStyle("-fx-text-fill: '" + bcolor + "';"+"-fx-border-color: '" + bcolor + "';"+"-fx-background-color: '#56E60F';"+"-fx-font-size: 30px;"+"-fx-font-weight: bold;"+"-fx-border-width: 4px;");
			up.setStyle("-fx-background-color: '#56E60F';");
			div.setStyle("-fx-background-color: '" + bcolor + "';");
			colon.setStyle("-fx-font-family: 'Ravie';"+"-fx-font-weight: normal;"+"-fx-text-fill: white;"+"-fx-font-size: 20px;"+"-fx-background-color: '#1F3C1C';");
			back.setStyle("-fx-font-family: 'Ravie';"+"-fx-font-weight: normal;"+"-fx-text-fill: white;"+"-fx-font-size: 20px;"+"-fx-background-color: '#1F3C1C';");
			copyright.setStyle("-fx-text-fill: '#1F3C1C';"+"-fx-font-size: 13px;");
			cal.setStyle("-fx-font-family: 'Centaury';"+"-fx-font-weight: bold;"+"-fx-font-size: 32px;"+"-fx-text-fill: '" + bcolor + "';"+"-fx-border-color: '" + bcolor + "';"+"-fx-border-width: 2px;");
			options.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: '#1F3C1C';"+"-fx-background-color: '#81E61A';"+"-fx-font-size: 40px;");
			today.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: white;"+"-fx-font-size: 20px;"+"-fx-background-color: '#1F3C1C';");
			background = "-fx-background-color: '"+ bgcolor + "';";
			board.setStyle("-fx-background-color: '" + bcolor + "';");
			root.setStyle(background);
			
			today.setOnMouseEntered(e-> today.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: '"+bcolor+"';"+"-fx-font-size: 18px;"+"-fx-background-color: '"+bgcolor+"';"+"-fx-border-width: 3px;"+"-fx-border-color: '"+bcolor+"';"));
			today.setOnMouseExited(e-> today.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: white;"+"-fx-font-size: 20px;"+"-fx-background-color: '"+bcolor+"';"));
			
			return;
		}
		else if(num == 1)
		{
			bgcolor = "#08EEDE";
			bcolor = "#03073B";
			
			month_view.setStyle("-fx-background-color: '" + bgcolor + "';");
			for(int i = 0 ; i < 12 ; i++)
			{
				month_name[i].setStyle("-fx-font-size: 15px;"+"-fx-font-weight: bold;"+"-fx-text-fill: white;"+"-fx-background-color: '" + bcolor + "';");
			}
			
			next1.setStyle("-fx-background-color: '" + bcolor + "';");
			prev1.setStyle("-fx-background-color: '" + bcolor + "';");
			
			title.setStyle("-fx-text-fill: white;"+"-fx-font-size: 30px;"+"-fx-font-weight: bold;"+"-fx-background-color: '" + bcolor + "';");
			
			next1.setVisible(true);
			prev1.setVisible(true);
			next0.setVisible(false);
			prev0.setVisible(false);
			next2.setVisible(false);
			prev2.setVisible(false);
			next3.setVisible(false);
			prev3.setVisible(false);
			next4.setVisible(false);
			prev4.setVisible(false);
			
			circle0.setVisible(false);
			circle1.setVisible(true);
			circle2.setVisible(false);
			circle3.setVisible(false);
			circle4.setVisible(false);
			
			skin0.setStyle("-fx-background-color: '#13A1F6';");
			skin1.setStyle(skin0.getStyle());
			skin2.setStyle(skin0.getStyle());
			skin3.setStyle(skin0.getStyle());
			skin4.setStyle(skin0.getStyle());
			skin.setStyle("-fx-text-fill: '" + bcolor + "';"+"-fx-border-color: '" + bcolor + "';"+"-fx-background-color: '#13A1F6';"+"-fx-font-size: 30px;"+"-fx-font-weight: bold;"+"-fx-border-width: 4px;");
			up.setStyle("-fx-background-color: '#13A1F6';");
			div.setStyle("-fx-background-color: '" + bcolor + "';");
			colon.setStyle("-fx-font-family: 'Ravie';"+"-fx-font-weight: normal;"+"-fx-text-fill: white;"+"-fx-font-size: 20px;"+"-fx-background-color: '#03073B';");
			back.setStyle("-fx-font-family: 'Ravie';"+"-fx-font-weight: normal;"+"-fx-text-fill: white;"+"-fx-font-size: 20px;"+"-fx-background-color: '#03073B';");
			copyright.setStyle("-fx-text-fill: '#03073B';"+"-fx-font-size: 13px;");
			cal.setStyle("-fx-font-family: 'Centaury';"+"-fx-font-weight: bold;"+"-fx-font-size: 32px;"+"-fx-text-fill: '" + bcolor + "';"+"-fx-border-color: '" + bcolor + "';"+"-fx-border-width: 2px;");
			options.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: '#03073B';"+"-fx-background-color: '#08EEDE';"+"-fx-font-size: 40px;");
			today.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: white;"+"-fx-font-size: 20px;"+"-fx-background-color: '#03073B';");
			background = "-fx-background-color: '"+ bgcolor + "';";
			board.setStyle("-fx-background-color: '" + bcolor + "';");
			root.setStyle(background);
			today.setOnMouseEntered(e-> today.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: '"+bcolor+"';"+"-fx-font-size: 18px;"+"-fx-background-color: '"+bgcolor+"';"+"-fx-border-width: 3px;"+"-fx-border-color: '"+bcolor+"';"));
			today.setOnMouseExited(e-> today.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: white;"+"-fx-font-size: 20px;"+"-fx-background-color: '"+bcolor+"';"));
			
			return;
		}
		else if(num == 2)
		{
			bgcolor = "#E79123";
			bcolor = "#3C1206";
			
			month_view.setStyle("-fx-background-color: '" + bgcolor + "';");
			for(int i = 0 ; i < 12 ; i++)
			{
				month_name[i].setStyle("-fx-font-size: 15px;"+"-fx-font-weight: bold;"+"-fx-text-fill: white;"+"-fx-background-color: '" + bcolor + "';");
			}
			
			next2.setStyle("-fx-background-color: '" + bcolor + "';");
			prev2.setStyle("-fx-background-color: '" + bcolor + "';");
			
			title.setStyle("-fx-text-fill: white;"+"-fx-font-size: 30px;"+"-fx-font-weight: bold;"+"-fx-background-color: '" + bcolor + "';");
			
			next2.setVisible(true);
			prev2.setVisible(true);
			next0.setVisible(false);
			prev0.setVisible(false);
			next1.setVisible(false);
			prev1.setVisible(false);
			next3.setVisible(false);
			prev3.setVisible(false);
			next4.setVisible(false);
			prev4.setVisible(false);
			
			circle0.setVisible(false);
			circle1.setVisible(false);
			circle2.setVisible(true);
			circle3.setVisible(false);
			circle4.setVisible(false);
			
			skin0.setStyle("-fx-background-color: '#C68108';");
			skin1.setStyle(skin0.getStyle());
			skin2.setStyle(skin0.getStyle());
			skin3.setStyle(skin0.getStyle());
			skin4.setStyle(skin0.getStyle());
			skin.setStyle("-fx-text-fill: '" + bcolor + "';"+"-fx-border-color: '" + bcolor + "';"+"-fx-background-color: '#C68108';"+"-fx-font-size: 30px;"+"-fx-font-weight: bold;"+"-fx-border-width: 4px;");
			up.setStyle("-fx-background-color: '#C68108';");
			div.setStyle("-fx-background-color: '" + bcolor + "';");
			colon.setStyle("-fx-font-family: 'Ravie';"+"-fx-font-weight: normal;"+"-fx-text-fill: white;"+"-fx-font-size: 20px;"+"-fx-background-color: '#3C1206';");
			back.setStyle("-fx-font-family: 'Ravie';"+"-fx-font-weight: normal;"+"-fx-text-fill: white;"+"-fx-font-size: 20px;"+"-fx-background-color: '#3C1206';");
			copyright.setStyle("-fx-text-fill: '#3C1206';"+"-fx-font-size: 13px;");
			cal.setStyle("-fx-font-family: 'Centaury';"+"-fx-font-weight: bold;"+"-fx-font-size: 32px;"+"-fx-text-fill: '" + bcolor + "';"+"-fx-border-color: '" + bcolor + "';"+"-fx-border-width: 2px;");
			options.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: '#3C1206';"+"-fx-background-color: '#E79123';"+"-fx-font-size: 40px;");
			today.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: white;"+"-fx-font-size: 20px;"+"-fx-background-color: '#3C1206';");
			background = "-fx-background-color: '"+ bgcolor + "';";
			board.setStyle("-fx-background-color: '" + bcolor + "';");
			root.setStyle(background);
			today.setOnMouseEntered(e-> today.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: '"+bcolor+"';"+"-fx-font-size: 18px;"+"-fx-background-color: '"+bgcolor+"';"+"-fx-border-width: 3px;"+"-fx-border-color: '"+bcolor+"';"));
			today.setOnMouseExited(e-> today.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: white;"+"-fx-font-size: 20px;"+"-fx-background-color: '"+bcolor+"';"));
			
			return;
		}
		else if(num == 3)
		{
			bgcolor = "#989797";
			bcolor = "black";
			
			month_view.setStyle("-fx-background-color: '" + bgcolor + "';");
			for(int i = 0 ; i < 12 ; i++)
			{
				month_name[i].setStyle("-fx-font-size: 15px;"+"-fx-font-weight: bold;"+"-fx-text-fill: white;"+"-fx-background-color: '" + bcolor + "';");
			}
			
			next3.setStyle("-fx-background-color: '" + bcolor + "';");
			prev3.setStyle("-fx-background-color: '" + bcolor + "';");
			
			title.setStyle("-fx-text-fill: white;"+"-fx-font-size: 30px;"+"-fx-font-weight: bold;"+"-fx-background-color: '" + bcolor + "';");
			
			next3.setVisible(true);
			prev3.setVisible(true);
			next0.setVisible(false);
			prev0.setVisible(false);
			next2.setVisible(false);
			prev2.setVisible(false);
			next1.setVisible(false);
			prev1.setVisible(false);
			next4.setVisible(false);
			prev4.setVisible(false);
			
			circle0.setVisible(false);
			circle1.setVisible(false);
			circle2.setVisible(false);
			circle3.setVisible(true);
			circle4.setVisible(false);
			
			skin0.setStyle("-fx-background-color: '#727272';");
			skin1.setStyle(skin0.getStyle());
			skin2.setStyle(skin0.getStyle());
			skin3.setStyle(skin0.getStyle());
			skin4.setStyle(skin0.getStyle());
			skin.setStyle("-fx-text-fill: '" + bcolor + "';"+"-fx-border-color: '" + bcolor + "';"+"-fx-background-color: '#727272';"+"-fx-font-size: 30px;"+"-fx-font-weight: bold;"+"-fx-border-width: 4px;");
			up.setStyle("-fx-background-color: '#727272';");
			div.setStyle("-fx-background-color: '" + bcolor + "';");
			colon.setStyle("-fx-font-family: 'Ravie';"+"-fx-font-weight: normal;"+"-fx-text-fill: white;"+"-fx-font-size: 20px;"+"-fx-background-color: 'black';");
			back.setStyle("-fx-font-family: 'Ravie';"+"-fx-font-weight: normal;"+"-fx-text-fill: white;"+"-fx-font-size: 20px;"+"-fx-background-color: 'black';");
			copyright.setStyle("-fx-text-fill: black;"+"-fx-font-size: 13px;");
			cal.setStyle("-fx-font-family: 'Centaury';"+"-fx-font-weight: bold;"+"-fx-font-size: 32px;"+"-fx-text-fill: '" + bcolor + "';"+"-fx-border-color: '" + bcolor + "';"+"-fx-border-width: 2px;");
			options.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: 'black';"+"-fx-background-color: '#989797';"+"-fx-font-size: 40px;");
			today.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: white;"+"-fx-font-size: 20px;"+"-fx-background-color: 'black';");
			background = "-fx-background-color: '"+ bgcolor + "';";
			board.setStyle("-fx-background-color: '" + bcolor + "';");
			root.setStyle(background);
			today.setOnMouseEntered(e-> today.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: '"+bcolor+"';"+"-fx-font-size: 18px;"+"-fx-background-color: '"+bgcolor+"';"+"-fx-border-width: 3px;"+"-fx-border-color: '"+bcolor+"';"));
			today.setOnMouseExited(e-> today.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: white;"+"-fx-font-size: 20px;"+"-fx-background-color: '"+bcolor+"';"));
			
			return;
		}
		else if(num == 4)
		{
			bgcolor = "#E3FE29";
			bcolor = "#5F3105";
			
			month_view.setStyle("-fx-background-color: '" + bgcolor + "';");
			for(int i = 0 ; i < 12 ; i++)
			{
				month_name[i].setStyle("-fx-font-size: 15px;"+"-fx-font-weight: bold;"+"-fx-text-fill: white;"+"-fx-background-color: '" + bcolor + "';");
			}
			
			next4.setStyle("-fx-background-color: '" + bcolor + "';");
			prev4.setStyle("-fx-background-color: '" + bcolor + "';");
			
			title.setStyle("-fx-text-fill: white;"+"-fx-font-size: 30px;"+"-fx-font-weight: bold;"+"-fx-background-color: '" + bcolor + "';");
			
			next4.setVisible(true);
			prev4.setVisible(true);
			next0.setVisible(false);
			prev0.setVisible(false);
			next2.setVisible(false);
			prev2.setVisible(false);
			next3.setVisible(false);
			prev3.setVisible(false);
			next1.setVisible(false);
			prev1.setVisible(false);
			
			circle0.setVisible(false);
			circle1.setVisible(false);
			circle2.setVisible(false);
			circle3.setVisible(false);
			circle4.setVisible(true);
			
			skin0.setStyle("-fx-background-color: '#D1B700';");
			skin1.setStyle(skin0.getStyle());
			skin2.setStyle(skin0.getStyle());
			skin3.setStyle(skin0.getStyle());
			skin4.setStyle(skin0.getStyle());
			skin.setStyle("-fx-text-fill: '" + bcolor + "';"+"-fx-border-color: '" + bcolor + "';"+"-fx-background-color: '#D1B700';"+"-fx-font-size: 30px;"+"-fx-font-weight: bold;"+"-fx-border-width: 4px;");
			up.setStyle("-fx-background-color: '#D1B700';");
			div.setStyle("-fx-background-color: '" + bcolor + "';");
			colon.setStyle("-fx-font-family: 'Ravie';"+"-fx-font-weight: normal;"+"-fx-text-fill: white;"+"-fx-font-size: 20px;"+"-fx-background-color: '#5F3105';");
			back.setStyle("-fx-font-family: 'Ravie';"+"-fx-font-weight: normal;"+"-fx-text-fill: white;"+"-fx-font-size: 20px;"+"-fx-background-color: '#5F3105';");
			copyright.setStyle("-fx-text-fill: '#5F3105';"+"-fx-font-size: 13px;");
			cal.setStyle("-fx-font-family: 'Centaury';"+"-fx-font-weight: bold;"+"-fx-font-size: 32px;"+"-fx-text-fill: '" + bcolor + "';"+"-fx-border-color: '" + bcolor + "';"+"-fx-border-width: 2px;");
			options.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: '#5F3105';"+"-fx-background-color: '#E3FE29';"+"-fx-font-size: 40px;");
			today.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: white;"+"-fx-font-size: 20px;"+"-fx-background-color: '#5F3105';");
			background = "-fx-background-color: '"+ bgcolor + "';";
			board.setStyle("-fx-background-color: '" + bcolor + "';");
			root.setStyle(background);
			today.setOnMouseEntered(e-> today.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: '"+bcolor+"';"+"-fx-font-size: 18px;"+"-fx-background-color: '"+bgcolor+"';"+"-fx-border-width: 3px;"+"-fx-border-color: '"+bcolor+"';"));
			today.setOnMouseExited(e-> today.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: white;"+"-fx-font-size: 20px;"+"-fx-background-color: '"+bcolor+"';"));
			
			return;
		}
		
	}
	
	public void ShowOptions(Stage s , Boolean val)
	{
		/* If val == true : Display Options (up)
		 * If val == false : Hide Options (up)
		 * */
		if(val == true)	//show opts
		{
			show_opts.setNode(up);
			show_opts.setToY(0.0);
			show_opts.setDuration(Duration.seconds(0.5));
		}
		else
		{
			show_opts.setNode(up);
			show_opts.setToY(-height - 12.0 - 50.0);
			show_opts.setDuration(Duration.seconds(0.5));
		}
		show_opts.play();
	}
	public void set_title(int monthX , int yearX)
	{
		if(month_display == false)
		{
			if(monthX == 0)
				title.setText("  January, " + Integer.toString(yearX));
			else if(monthX == 1)
				title.setText(" February, " + Integer.toString(yearX));
			else if(monthX == 2)
				title.setText("     March, " + Integer.toString(yearX));
			else if(monthX == 3)
				title.setText("      April, " + Integer.toString(yearX));
			else if(monthX == 4)
				title.setText("       May, " + Integer.toString(yearX));
			else if(monthX == 5)
				title.setText("      June, " + Integer.toString(yearX));
			else if(monthX == 6)
				title.setText("      July, " + Integer.toString(yearX));
			else if(monthX == 7)
				title.setText("   August, " + Integer.toString(yearX));
			else if(monthX == 8)
				title.setText("September, " + Integer.toString(yearX));
			else if(monthX == 9)
				title.setText("  October, " + Integer.toString(yearX));
			else if(monthX == 10)
				title.setText(" November, " + Integer.toString(yearX));
			else if(monthX == 11)
				title.setText(" December, " + Integer.toString(yearX));
		}
		else
		{
			title.setText("\t  "+Integer.toString(yearX));
		}
		
		
	}
	
	int dateup , back_to_current;
	public void set_calendar()
	{
		
		if(month_display == false)
			month_view.setVisible(false);
		else
			month_view.setVisible(true);
		//month_display = false;
		//show other buttons
		for(int i = 0 ; i < 7 ; i++)
			day[i].setVisible(true);
		for(int i = 0; i < 35 ; i++)
			date[i].setVisible(true);
		
		//clearing previous date text
		for(int i = 0 ; i < 35 ; i++)
		{
			date[i].setText("");
			date[i].setStyle("-fx-font-family: 'Century Schoolbook';"+"-fx-font-weight: normal;"+"-fx-font-size: 15px;"+"-fx-background-color: '#C7C8C8';"+"-fx-text-fill: black;");
		}
		
		Calendar calc = Calendar.getInstance();
		if(month == 0)
			 calc.set(Calendar.MONTH, Calendar.JANUARY);
		else if(month == 1)
		 	calc.set(Calendar.MONTH, Calendar.FEBRUARY);
		else if(month == 2)
		 	calc.set(Calendar.MONTH, Calendar.MARCH);
		else if(month == 3)
		 	calc.set(Calendar.MONTH, Calendar.APRIL);
		else if(month == 4)
		 	calc.set(Calendar.MONTH, Calendar.MAY);
		else if(month == 5)
		 	calc.set(Calendar.MONTH, Calendar.JUNE);
		else if(month == 6)
		 	calc.set(Calendar.MONTH, Calendar.JULY);
		else if(month == 7)
		 	calc.set(Calendar.MONTH, Calendar.AUGUST);
		else if(month == 8)
		 	calc.set(Calendar.MONTH, Calendar.SEPTEMBER);
		else if(month == 9)
		 	calc.set(Calendar.MONTH, Calendar.OCTOBER);
		else if(month == 10)
		 	calc.set(Calendar.MONTH, Calendar.NOVEMBER);
		else if(month == 11)
		 	calc.set(Calendar.MONTH, Calendar.DECEMBER);
		
		calc.set(Calendar.YEAR, year);
		calc.set(Calendar.DAY_OF_MONTH, 1);
		Date firstDayOfMonth = calc.getTime();  
		DateFormat sdf = new SimpleDateFormat("EEEEEEEE");   
		String dayy = sdf.format(firstDayOfMonth);
		
		       
		if(dayy.equalsIgnoreCase("SUNDAY"))
		{
			date[0].setText("1"); startx = 0;
		}
		else if(dayy.equalsIgnoreCase("MONDAY"))
		{
			date[1].setText("1"); startx = 1;
		}
		else if(dayy.equalsIgnoreCase("TUESDAY"))
		{
			date[2].setText("1"); startx = 2;
		}
		else if(dayy.equalsIgnoreCase("WEDNESDAY"))
		{
			date[3].setText("1"); startx = 3;
		}
		else if(dayy.equalsIgnoreCase("THURSDAY"))
		{
			date[4].setText("1"); startx = 4;
		}
		else if(dayy.equalsIgnoreCase("FRIDAY"))
		{
			date[5].setText("1"); startx = 5;
		}
		else if(dayy.equalsIgnoreCase("SATURDAY"))
		{
			date[6].setText("1"); startx = 6;
		}
		
		//checking leap year
		if((calc.getActualMaximum(Calendar.DAY_OF_YEAR) > 365) == true)
			get_max_day(month , true);
		else
			get_max_day(month , false);
		
		for(int i = 0 ; i < max_day ; i++)
		{
			int x = startx + i;
			if(x >= 35)
			{
				dateup = x - 35;
				date[dateup].setText(Integer.toString(i + 1));
				date[dateup].setStyle("-fx-font-family: 'Century Schoolbook';"+"-fx-font-weight: normal;"+"-fx-font-size: 15px;"+"-fx-background-color: '#61F8F7';"+"-fx-text-fill: black;");
				continue;
			}
			
			date[x].setText(Integer.toString(i + 1));
			date[x].setStyle("-fx-font-family: 'Century Schoolbook';"+"-fx-font-weight: normal;"+"-fx-font-size: 15px;"+"-fx-background-color: '#61F8F7';"+"-fx-text-fill: black;");
		}
		
		//setting current date in calendar
		back_to_current = now + startx - 1;
		if(current_month == month && current_year == year)
		{
			date[back_to_current].setStyle("-fx-font-family: 'Century Schoolbook';"+"-fx-font-weight: bold;"+"-fx-font-size: 17px;"+"-fx-background-color: '#1195FB';"+"-fx-text-fill: black;");
		}
		set_title(month , year);
	}
	
	public void Next_Button_Pressed(Stage s)
	{
		if(month_display == false)
		{
			//month and year
			if(month == 11)
			{
				month = 0;
				year++;
			}
			else
				month++;
			
			set_calendar();
		}
		else
		{
			year++;
			set_title(month , year);
		}	
			
	}
	
	public void Prev_Button_Pressed(Stage s)
	{
		if(month_display == false)
		{
			//month and year
			if(month == 0)
			{
				month = 11;
				year--;
			}
			else
				month--;
			
			set_calendar();
		}	
		else
		{
			year--;
			set_title(month , year);
		}	
			
	}
	
	public void front(Stage s)
	{
		month_display = false;
		options.setOnAction(e-> ShowOptions(s , true));
		back.setOnAction(e-> ShowOptions(s , false));
		colon.setOnAction(e-> ShowOptions(s , false));
		
		skin0.setOnMouseClicked(e-> SetLayout(0));
		skin1.setOnMouseClicked(e-> SetLayout(1));
		skin2.setOnMouseClicked(e-> SetLayout(2));
		skin3.setOnMouseClicked(e-> SetLayout(3));
		skin4.setOnMouseClicked(e-> SetLayout(4));
		
		next0.setOnAction(e-> Next_Button_Pressed(s));
		prev0.setOnAction(e-> Prev_Button_Pressed(s));
		next1.setOnAction(e-> Next_Button_Pressed(s));
		prev1.setOnAction(e-> Prev_Button_Pressed(s));
		next2.setOnAction(e-> Next_Button_Pressed(s));
		prev2.setOnAction(e-> Prev_Button_Pressed(s));
		next3.setOnAction(e-> Next_Button_Pressed(s));
		prev3.setOnAction(e-> Prev_Button_Pressed(s));
		next4.setOnAction(e-> Next_Button_Pressed(s));
		prev4.setOnAction(e-> Prev_Button_Pressed(s));
		
		
		//options below
		up.setTranslateY(-height - 12.0 - 50.0);
		//div
		AnchorPane.setLeftAnchor(div, 0.0);
		AnchorPane.setRightAnchor(div, 0.0);
		AnchorPane.setBottomAnchor(div, 0.0);
		//back
		AnchorPane.setLeftAnchor(back, 100.0);
		AnchorPane.setRightAnchor(back, 100.0);
		AnchorPane.setBottomAnchor(back, 100.0);
		//colon
		AnchorPane.setLeftAnchor(colon, 205.0);
		AnchorPane.setBottomAnchor(colon, 100.0);
		//skin
		AnchorPane.setTopAnchor(skin, 18.0);
		AnchorPane.setLeftAnchor(skin, 20.0);
		AnchorPane.setRightAnchor(skin, 20.0);
		AnchorPane.setBottomAnchor(skin, 552.0);
		//skin0
		AnchorPane.setTopAnchor(skin0, 100.0 - 5.0);
		AnchorPane.setLeftAnchor(skin0, 45.0);
		//skin1
		AnchorPane.setTopAnchor(skin1, 180.0 - 5.0);
		AnchorPane.setLeftAnchor(skin1, 45.0);
		//skin2
		AnchorPane.setTopAnchor(skin2, 260.0 - 5.0);
		AnchorPane.setLeftAnchor(skin2, 45.0);
		//skin3
		AnchorPane.setTopAnchor(skin3, 340.0 - 5.0);
		AnchorPane.setLeftAnchor(skin3, 45.0);
		//skin4
		AnchorPane.setTopAnchor(skin4, 420.0 - 5.0);
		AnchorPane.setLeftAnchor(skin4, 45.0);
		//circle0
		AnchorPane.setTopAnchor(circle0, 420.0 - 15.0 - (80.0 * 4.0) + 5.0);
		AnchorPane.setRightAnchor(circle0, 37.0 + 10.0);
		//circle1
		AnchorPane.setTopAnchor(circle1, 420.0 - 15.0 - (80.0 * 3.0) + 5.0);
		AnchorPane.setRightAnchor(circle1, 37.0 + 10.0);
		//circle2
		AnchorPane.setTopAnchor(circle2, 420.0 - 15.0 - (80.0 * 2.0) + 5.0);
		AnchorPane.setRightAnchor(circle2, 37.0 + 10.0);
		//circle3
		AnchorPane.setTopAnchor(circle3, 420.0 - 15.0 - 80.0 + 5.0);
		AnchorPane.setRightAnchor(circle3, 37.0 + 10.0);
		//circle4
		AnchorPane.setTopAnchor(circle4, 420.0 - 15.0 + 5.0);
		AnchorPane.setRightAnchor(circle4, 37.0 + 10.0 + 10.0 - 10.0 );
		
		up.getChildren().addAll(back , colon , div , skin , skin0 , skin1 , skin2 , skin3 , skin4 , circle0 , circle1 , circle2 , circle3 , circle4);
		up.setPrefSize(width + 12.0, height + 12.0 + 50.0);
		
		//options up
		
		
		//board
		AnchorPane.setTopAnchor(board , 34.0);
		AnchorPane.setLeftAnchor(board , 30.0);
		AnchorPane.setRightAnchor(board , 30.0);
		AnchorPane.setBottomAnchor(board , 84.0);
		//calback
		AnchorPane.setTopAnchor(calback , 40.0);
		AnchorPane.setLeftAnchor(calback , 36.0);
		AnchorPane.setRightAnchor(calback , 36.0);
		AnchorPane.setBottomAnchor(calback , 480.0);
		//cal
		AnchorPane.setTopAnchor(cal , 44.0);
		AnchorPane.setLeftAnchor(cal , 40.0);
		AnchorPane.setRightAnchor(cal , 40.0);
		AnchorPane.setBottomAnchor(cal , 484.0);
		//today
		AnchorPane.setTopAnchor(today , 518.0);
		AnchorPane.setLeftAnchor(today , 260.0);
		AnchorPane.setRightAnchor(today , 15.0);
		AnchorPane.setBottomAnchor(today , 22.0);
		//options
		AnchorPane.setTopAnchor(options , -40.0);
		AnchorPane.setRightAnchor(options , -10.0);
		//copyright
		AnchorPane.setLeftAnchor(copyright , 5.0);
		AnchorPane.setBottomAnchor(copyright , 5.0);
		//days bottom
		for(int i = 0 ; i < 7 ; i++)
			AnchorPane.setBottomAnchor(day[i] , 256.0 + 120.0);
		
		AnchorPane.setLeftAnchor(day[0] , 36.0);
		AnchorPane.setLeftAnchor(day[1] , 36.0 + ( 50.20 * 1.0 + 5.0 * 1.0));
		AnchorPane.setLeftAnchor(day[2] , 36.0 + ( 50.20 * 2.0 + 5.0 * 2.0));
		AnchorPane.setLeftAnchor(day[3] , 36.0 + ( 50.20 * 3.0 + 5.0 * 3.0));
		AnchorPane.setLeftAnchor(day[4] , 36.0 + ( 50.20 * 4.0 + 5.0 * 4.0));
		AnchorPane.setLeftAnchor(day[5] , 36.0 + ( 50.20 * 5.0 + 5.0 * 5.0));
		AnchorPane.setLeftAnchor(day[6] , 36.0 + ( 50.20 * 6.0 + 5.0 * 6.0));
		
		//date[0] to date[6] top
		for(int i = 0; i < 7 ; i++)
			AnchorPane.setBottomAnchor(date[i] , 256.0 + 80.0 - 50.0 - 5.0 + 36.0);
		
		//date[7] to date[13] top
				for(int i = 7; i < 14 ; i++)
					AnchorPane.setBottomAnchor(date[i] , 256.0 + 80.0 - ((50.0 + 5.0 - 17.0) * 2.0));
		
		//date[14] to date[20] top
		for(int i = 14; i < 21 ; i++)
					AnchorPane.setBottomAnchor(date[i] , 256.0 + 80.0 - ((50.0 + 5.0 - 11.0) * 3.0));
		
		//date[21] to date[27] top
		for(int i = 21; i < 28 ; i++)
			AnchorPane.setBottomAnchor(date[i] , 256.0 + 80.0 - ((50.0 + 5.0 - 8.0) * 4.0));
		
		//date[28] to date[34] top
		for(int i = 28; i < 35 ; i++)
			AnchorPane.setBottomAnchor(date[i] , 256.0 + 80.0 - ((50.0 + 5.0 - 6.0) * 5.0));
		
		AnchorPane.setLeftAnchor(date[0] , 36.0);
		AnchorPane.setLeftAnchor(date[7] , 36.0);
		AnchorPane.setLeftAnchor(date[14] , 36.0);
		AnchorPane.setLeftAnchor(date[21] , 36.0);
		AnchorPane.setLeftAnchor(date[28] , 36.0);
				
		AnchorPane.setLeftAnchor(date[1] , 36.0 + ( 50.20 * 1.0 + 5.0 * 1.0));
		AnchorPane.setLeftAnchor(date[8] , 36.0 + ( 50.20 * 1.0 + 5.0 * 1.0));
		AnchorPane.setLeftAnchor(date[15] , 36.0 + ( 50.20 * 1.0 + 5.0 * 1.0));
		AnchorPane.setLeftAnchor(date[22] , 36.0 + ( 50.20 * 1.0 + 5.0 * 1.0));
		AnchorPane.setLeftAnchor(date[29] , 36.0 + ( 50.20 * 1.0 + 5.0 * 1.0));
		
		AnchorPane.setLeftAnchor(date[2] , 36.0 + ( 50.20 * 2.0 + 5.0 * 2.0));
		AnchorPane.setLeftAnchor(date[9] , 36.0 + ( 50.20 * 2.0 + 5.0 * 2.0));
		AnchorPane.setLeftAnchor(date[16] , 36.0 + ( 50.20 * 2.0 + 5.0 * 2.0));
		AnchorPane.setLeftAnchor(date[23] , 36.0 + ( 50.20 * 2.0 + 5.0 * 2.0));
		AnchorPane.setLeftAnchor(date[30] , 36.0 + ( 50.20 * 2.0 + 5.0 * 2.0));
		
		AnchorPane.setLeftAnchor(date[3] , 36.0 + ( 50.20 * 3.0 + 5.0 * 3.0));
		AnchorPane.setLeftAnchor(date[10] , 36.0 + ( 50.20 * 3.0 + 5.0 * 3.0));
		AnchorPane.setLeftAnchor(date[17] , 36.0 + ( 50.20 * 3.0 + 5.0 * 3.0));
		AnchorPane.setLeftAnchor(date[24] , 36.0 + ( 50.20 * 3.0 + 5.0 * 3.0));
		AnchorPane.setLeftAnchor(date[31] , 36.0 + ( 50.20 * 3.0 + 5.0 * 3.0));
		
		AnchorPane.setLeftAnchor(date[4] , 36.0 + ( 50.20 * 4.0 + 5.0 * 4.0));
		AnchorPane.setLeftAnchor(date[11] , 36.0 + ( 50.20 * 4.0 + 5.0 * 4.0));
		AnchorPane.setLeftAnchor(date[18] , 36.0 + ( 50.20 * 4.0 + 5.0 * 4.0));
		AnchorPane.setLeftAnchor(date[25] , 36.0 + ( 50.20 * 4.0 + 5.0 * 4.0));
		AnchorPane.setLeftAnchor(date[32] , 36.0 + ( 50.20 * 4.0 + 5.0 * 4.0));
		
		AnchorPane.setLeftAnchor(date[5] , 36.0 + ( 50.20 * 5.0 + 5.0 * 5.0));
		AnchorPane.setLeftAnchor(date[12] , 36.0 + ( 50.20 * 5.0 + 5.0 * 5.0));
		AnchorPane.setLeftAnchor(date[19] , 36.0 + ( 50.20 * 5.0 + 5.0 * 5.0));
		AnchorPane.setLeftAnchor(date[26] , 36.0 + ( 50.20 * 5.0 + 5.0 * 5.0));
		AnchorPane.setLeftAnchor(date[33] , 36.0 + ( 50.20 * 5.0 + 5.0 * 5.0));
		
		AnchorPane.setLeftAnchor(date[6] , 36.0 + ( 50.20 * 6.0 + 5.0 * 6.0));
		AnchorPane.setLeftAnchor(date[13] , 36.0 + ( 50.20 * 6.0 + 5.0 * 6.0));
		AnchorPane.setLeftAnchor(date[20] , 36.0 + ( 50.20 * 6.0 + 5.0 * 6.0));
		AnchorPane.setLeftAnchor(date[27] , 36.0 + ( 50.20 * 6.0 + 5.0 * 6.0));
		AnchorPane.setLeftAnchor(date[34] , 36.0 + ( 50.20 * 6.0 + 5.0 * 6.0));
		
		//next0
		AnchorPane.setTopAnchor(next0 , 104.0);
		AnchorPane.setRightAnchor(next0 , 30.0);
		//prev0
		AnchorPane.setTopAnchor(prev0 , 104.0);
		AnchorPane.setLeftAnchor(prev0 , 30.0);
		//next1
		AnchorPane.setTopAnchor(next1 , 104.0);
		AnchorPane.setRightAnchor(next1 , 30.0);
		//prev1
		AnchorPane.setTopAnchor(prev1 , 104.0);
		AnchorPane.setLeftAnchor(prev1 , 30.0);
		//next2
		AnchorPane.setTopAnchor(next2 , 104.0);
		AnchorPane.setRightAnchor(next2 , 30.0);
		//prev2
		AnchorPane.setTopAnchor(prev2 , 104.0);
		AnchorPane.setLeftAnchor(prev2 , 30.0);
		//next3
		AnchorPane.setTopAnchor(next3 , 104.0);
		AnchorPane.setRightAnchor(next3 , 30.0);
		//prev3
		AnchorPane.setTopAnchor(prev3 , 104.0);
		AnchorPane.setLeftAnchor(prev3 , 30.0);
		//next4
		AnchorPane.setTopAnchor(next4 , 104.0);
		AnchorPane.setRightAnchor(next4 , 30.0);
		//prev4
		AnchorPane.setTopAnchor(prev4 , 104.0);
		AnchorPane.setLeftAnchor(prev4 , 30.0);
		//title
		AnchorPane.setTopAnchor(title , 106.0);
		AnchorPane.setLeftAnchor(title , 110.0);
		//month_view
		AnchorPane.setTopAnchor(month_view , 155.0);
		AnchorPane.setLeftAnchor(month_view , 36.0);
		
		root.getChildren().addAll(options , board , today , calback , cal , day[0] , day[1] , day[2] , day[3] , day[4] , day[5] , day[6]);
		root.getChildren().addAll(title , next0 , prev0 , next1 , prev1 , next2 , prev2 , next3 , prev3 , next4 , prev4);
		for(int i = 0 ; i < 35 ; i++)
			root.getChildren().add(date[i]);
		root.getChildren().addAll(month_view , up , copyright);
		
		Scene scene;
		scene = new Scene(root , width , height);
		
		
		s.setResizable(false);
		s.setScene(scene);
		s.show();
	}
	public int RetrieveSkinData(boolean write)
	{
		if(write == false)	//read
		{
			try(FileReader fr = new FileReader("related files/skin index.txt"))
	        {
	            int c;
	            while((c = fr.read()) != -1)
	            {
	                return(c - 48);
	            }
	        }
	        catch(IOException e)
	        {
	            return(-1);
	        }
		}
		else 	//write
		{
			String source = Integer.toString(current_skin);
			char buffer[] = new char[source.length()];
			source.getChars(0, source.length(), buffer, 0);
			try(FileWriter fw = new FileWriter("related files/skin index.txt"))
			{
				fw.write(buffer);
				return(-1);
			}
			catch(IOException e)
			{
				return(-1);
			}
		}
		return(-1);
	}
	public void get_max_day(int m , boolean leap)
	{
		month_display = false;
		if(m == 0)
			max_day = 31;
		else if(m == 1)
		{
			if(leap == true)
				max_day = 29;
			else
				max_day = 28;
		}
		else if(m == 2)
			max_day = 31;
		else if(m == 3)
			max_day = 30;
		else if(m == 4)
			max_day = 31;
		else if(m == 5)
			max_day = 30;
		else if(m == 6)
			max_day = 31;
		else if(m == 7)
			max_day = 31;
		else if(m == 8)
			max_day = 30;
		else if(m == 9)
			max_day = 31;
		else if(m == 10)
			max_day = 30;
		else if(m == 11)
			max_day = 31;
	}
	int startx;
	public void set_current_month(int monthx , int yearx , int this_day)
	{
		month_display = false;
		//show other buttons
		for(int i = 0 ; i < 7 ; i++)
			day[i].setVisible(true);
		for(int i = 0; i < 35 ; i++)
			date[i].setVisible(true);
		
		//clearing previous date text
		for(int i = 0 ; i < 35 ; i++)
		{
			date[i].setText("");
			date[i].setStyle("-fx-font-family: 'Century Schoolbook';"+"-fx-font-weight: normal;"+"-fx-font-size: 15px;"+"-fx-background-color: '#C7C8C8';"+"-fx-text-fill: black;");
		}
		Calendar calc = Calendar.getInstance();
        if(monthx == 0)
        	calc.set(Calendar.MONTH, Calendar.JANUARY);
        else if(monthx == 1)
        	calc.set(Calendar.MONTH, Calendar.FEBRUARY);
        else if(monthx == 2)
        	calc.set(Calendar.MONTH, Calendar.MARCH);
        else if(monthx == 3)
        	calc.set(Calendar.MONTH, Calendar.APRIL);
        else if(monthx == 4)
        	calc.set(Calendar.MONTH, Calendar.MAY);
        else if(monthx == 5)
        	calc.set(Calendar.MONTH, Calendar.JUNE);
        else if(monthx == 6)
        	calc.set(Calendar.MONTH, Calendar.JULY);
        else if(monthx == 7)
        	calc.set(Calendar.MONTH, Calendar.AUGUST);
        else if(monthx == 8)
        	calc.set(Calendar.MONTH, Calendar.SEPTEMBER);
        else if(monthx == 9)
        	calc.set(Calendar.MONTH, Calendar.OCTOBER);
        else if(monthx == 10)
        	calc.set(Calendar.MONTH, Calendar.NOVEMBER);
        else if(monthx == 11)
        	calc.set(Calendar.MONTH, Calendar.DECEMBER);
        
        calc.set(Calendar.YEAR, yearx);
        calc.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDayOfMonth = calc.getTime();  
        DateFormat sdf = new SimpleDateFormat("EEEEEEEE");   
        String dayy = sdf.format(firstDayOfMonth);
        
        
		if(dayy.equalsIgnoreCase("SUNDAY"))
		{
			date[0].setText("1"); startx = 0;
		}
		else if(dayy.equalsIgnoreCase("MONDAY"))
		{
			date[1].setText("1"); startx = 1;
		}
		else if(dayy.equalsIgnoreCase("TUESDAY"))
		{
			date[2].setText("1"); startx = 2;
		}
		else if(dayy.equalsIgnoreCase("WEDNESDAY"))
		{
			date[3].setText("1"); startx = 3;
		}
		else if(dayy.equalsIgnoreCase("THURSDAY"))
		{
			date[4].setText("1"); startx = 4;
		}
		else if(dayy.equalsIgnoreCase("FRIDAY"))
		{
			date[5].setText("1"); startx = 5;
		}
		else if(dayy.equalsIgnoreCase("SATDAY"))
		{
			date[6].setText("1"); startx = 6;
		}
		
		//checking leap year
		if((calc.getActualMaximum(Calendar.DAY_OF_YEAR) > 365) == true)
			get_max_day(month , true);
		else
			get_max_day(month , false);
		
		FadeTransition fd = new FadeTransition(Duration.seconds(0.4));
    	fd.setFromValue(0.3);
    	fd.setToValue(1.0);
    	//fd.setCycleCount(Animation.INDEFINITE);
    	fd.setCycleCount(2);
		
		for(int i = 0 ; i < max_day ; i++)
		{
			int x = startx + i;
			if((x - startx + 1) == now)
			{
				date[x].setText(Integer.toString(i + 1));
				date[x].setStyle("-fx-font-family: 'Century Schoolbook';"+"-fx-font-weight: bold;"+"-fx-font-size: 17px;"+"-fx-background-color: '#1195FB';"+"-fx-text-fill: black;");
				fd.setNode(date[x]);
				continue;
			}
			
			date[x].setText(Integer.toString(i + 1));
			date[x].setStyle("-fx-font-family: 'Century Schoolbook';"+"-fx-font-weight: normal;"+"-fx-font-size: 15px;"+"-fx-background-color: '#61F8F7';"+"-fx-text-fill: black;");
		}
		
		if(first_time == false)
			fd.play();
		first_time = false;
		
	}
	public void set_icon(Stage s , int cd)	//cd = current_day
	{
		if(current_month == 0)
			s.setTitle("January " + Integer.toString(current_day) + ", " + Integer.toString(current_year) + " | Calendar");
		else if(current_month == 1)
			s.setTitle("February " + Integer.toString(current_day) + ", " + Integer.toString(current_year) + " | Calendar");
		else if(current_month == 2)
			s.setTitle("March " + Integer.toString(current_day) + ", " + Integer.toString(current_year) + " | Calendar");
		else if(current_month == 3)
			s.setTitle("April " + Integer.toString(current_day) + ", " + Integer.toString(current_year) + " | Calendar");
		else if(current_month == 4)
			s.setTitle("May " + Integer.toString(current_day) + ", " + Integer.toString(current_year) + " | Calendar");
		else if(current_month == 5)
			s.setTitle("June " + Integer.toString(current_day) + ", " + Integer.toString(current_year) + " | Calendar");
		else if(current_month == 6)
			s.setTitle("July " + Integer.toString(current_day) + ", " + Integer.toString(current_year) + " | Calendar");
		else if(current_month == 7)
			s.setTitle("August " + Integer.toString(current_day) + ", " + Integer.toString(current_year) + " | Calendar");
		else if(current_month == 8)
			s.setTitle("September " + Integer.toString(current_day) + ", " + Integer.toString(current_year) + " | Calendar");
		else if(current_month == 9)
			s.setTitle("October " + Integer.toString(current_day) + ", " + Integer.toString(current_year) + " | Calendar");
		else if(current_month == 10)
			s.setTitle("November " + Integer.toString(current_day) + ", " + Integer.toString(current_year) + " | Calendar");
		else if(current_month == 11)
			s.setTitle("December " + Integer.toString(current_day) + ", " + Integer.toString(current_year) + " | Calendar");
		
		if(cd == 1)
			s.getIcons().add(new Image("date icons/date_01.png"));
		else if(cd == 2)
			s.getIcons().add(new Image("date icons/date_02.png"));
		else if(cd == 3)
			s.getIcons().add(new Image("date icons/date_03.png"));
		else if(cd == 4)
			s.getIcons().add(new Image("date icons/date_04.png"));
		else if(cd == 5)
			s.getIcons().add(new Image("date icons/date_05.png"));
		else if(cd == 6)
			s.getIcons().add(new Image("date icons/date_06.png"));
		else if(cd == 7)
			s.getIcons().add(new Image("date icons/date_07.png"));
		else if(cd == 8)
			s.getIcons().add(new Image("date icons/date_08.png"));
		else if(cd == 9)
			s.getIcons().add(new Image("date icons/date_09.png"));
		else if(cd == 10)
			s.getIcons().add(new Image("date icons/date_10.png"));
		else if(cd == 11)
			s.getIcons().add(new Image("date icons/date_11.png"));
		else if(cd == 12)
			s.getIcons().add(new Image("date icons/date_12.png"));
		else if(cd == 13)
			s.getIcons().add(new Image("date icons/date_13.png"));
		else if(cd == 14)
			s.getIcons().add(new Image("date icons/date_14.png"));
		else if(cd == 15)
			s.getIcons().add(new Image("date icons/date_15.png"));
		else if(cd == 16)
			s.getIcons().add(new Image("date icons/date_16.png"));
		else if(cd == 17)
			s.getIcons().add(new Image("date icons/date_17.png"));
		else if(cd == 18)
			s.getIcons().add(new Image("date icons/date_18.png"));
		else if(cd == 19)
			s.getIcons().add(new Image("date icons/date_19.png"));
		else if(cd == 20)
			s.getIcons().add(new Image("date icons/date_20.png"));
		else if(cd == 21)
			s.getIcons().add(new Image("date icons/date_21.png"));
		else if(cd == 22)
			s.getIcons().add(new Image("date icons/date_22.png"));
		else if(cd == 23)
			s.getIcons().add(new Image("date icons/date_23.png"));
		else if(cd == 24)
			s.getIcons().add(new Image("date icons/date_24.png"));
		else if(cd == 25)
			s.getIcons().add(new Image("date icons/date_25.png"));
		else if(cd == 26)
			s.getIcons().add(new Image("date icons/date_26.png"));
		else if(cd == 27)
			s.getIcons().add(new Image("date icons/date_27.png"));
		else if(cd == 28)
			s.getIcons().add(new Image("date icons/date_28.png"));
		else if(cd == 29)
			s.getIcons().add(new Image("date icons/date_29.png"));
		else if(cd == 30)
			s.getIcons().add(new Image("date icons/date_30.png"));
		else if(cd == 31)
			s.getIcons().add(new Image("date icons/date_31.png"));
		
	}
	public void set_current(Stage s)
	{
		month_view.setVisible(false);
		month_display = false;
		Calendar cal = Calendar.getInstance();
	    year = cal.get(Calendar.YEAR);
	    month = cal.get(Calendar.MONTH);      // 0 to 11
	    now = cal.get(Calendar.DAY_OF_MONTH);
	    
	    current_day = now;
	    current_month = month;
	    current_year = year;
	    
	    //setting app icon
	    set_icon(s , current_day);
	    
	    set_current_month(month , year , now);
	    set_title(month , year);
	}
	public void month_display()
	{
		month_view.setVisible(true);
		month_display = true;
		title.setText("\t  " + Integer.toString(year));
		//hide other buttons
		for(int i = 0 ; i < 7 ; i++)
			day[i].setVisible(false);
		for(int i = 0; i < 35 ; i++)
			date[i].setVisible(false);
		
	}
	public void month_hover(int number , boolean hover)
	{
		if(hover == true)	//pointer in
		{
			month_name[number].setStyle("-fx-font-size: 17px;"+"-fx-font-weight: bold;"+"-fx-text-fill: '" + bcolor + "';"+"-fx-background-color: '" + bgcolor + "';"+"-fx-border-color: '" + bcolor + "';"+"-fx-border-width: 3px;");
		}
		else	//pointer exit
		{
			month_name[number].setStyle("-fx-font-size: 15px;"+"-fx-font-weight: bold;"+"-fx-text-fill: white;"+"-fx-background-color: '" + bcolor + "';");
		}
	}
	public void intermediate(int month_num)
	{
		month_view.setVisible(false);
		month_display = false;
		
		if(month_num == 0)
		{
			month = 0;
			set_calendar();
		}
		else if(month_num == 1)
		{
			month = 1;
			set_calendar();
		}
		else if(month_num == 2)
		{
			month = 2;
			set_calendar();
		}
		else if(month_num == 3)
		{
			month = 3;
			set_calendar();
		}
		else if(month_num == 4)
		{
			month = 4;
			set_calendar();
		}
		else if(month_num == 5)
		{
			month = 5;
			set_calendar();
		}
		else if(month_num == 6)
		{
			month = 6;
			set_calendar();
		}
		else if(month_num == 7)
		{
			month = 7;
			set_calendar();
		}
		else if(month_num == 8)
		{
			month = 8;
			set_calendar();
		}
		else if(month_num == 9)
		{
			month = 9;
			set_calendar();
		}
		else if(month_num == 10)
		{
			month = 10;
			set_calendar();
		}
		else if(month_num == 11)
		{
			month = 11;
			set_calendar();
		}
		
		
	}
	
	public void start(Stage s)
	{
		month_view.setVisible(false);
		
		month_name[0].setOnMouseEntered(e-> month_hover(0 , true));
		month_name[1].setOnMouseEntered(e-> month_hover(1 , true));
		month_name[2].setOnMouseEntered(e-> month_hover(2 , true));
		month_name[3].setOnMouseEntered(e-> month_hover(3 , true));
		month_name[4].setOnMouseEntered(e-> month_hover(4 , true));
		month_name[5].setOnMouseEntered(e-> month_hover(5 , true));
		month_name[6].setOnMouseEntered(e-> month_hover(6 , true));
		month_name[7].setOnMouseEntered(e-> month_hover(7 , true));
		month_name[8].setOnMouseEntered(e-> month_hover(8 , true));
		month_name[9].setOnMouseEntered(e-> month_hover(9 , true));
		month_name[10].setOnMouseEntered(e-> month_hover(10 , true));
		month_name[11].setOnMouseEntered(e-> month_hover(11 , true));
		
		month_name[0].setOnMouseExited(e-> month_hover(0 , false));
		month_name[1].setOnMouseExited(e-> month_hover(1 , false));
		month_name[2].setOnMouseExited(e-> month_hover(2 , false));
		month_name[3].setOnMouseExited(e-> month_hover(3 , false));
		month_name[4].setOnMouseExited(e-> month_hover(4 , false));
		month_name[5].setOnMouseExited(e-> month_hover(5 , false));
		month_name[6].setOnMouseExited(e-> month_hover(6 , false));
		month_name[7].setOnMouseExited(e-> month_hover(7 , false));
		month_name[8].setOnMouseExited(e-> month_hover(8 , false));
		month_name[9].setOnMouseExited(e-> month_hover(9 , false));
		month_name[10].setOnMouseExited(e-> month_hover(10 , false));
		month_name[11].setOnMouseExited(e-> month_hover(11 , false));
		
		month_name[0].setOnAction(e-> intermediate(0));
		month_name[1].setOnAction(e-> intermediate(1));
		month_name[2].setOnAction(e-> intermediate(2));
		month_name[3].setOnAction(e-> intermediate(3));
		month_name[4].setOnAction(e-> intermediate(4));
		month_name[5].setOnAction(e-> intermediate(5));
		month_name[6].setOnAction(e-> intermediate(6));
		month_name[7].setOnAction(e-> intermediate(7));
		month_name[8].setOnAction(e-> intermediate(8));
		month_name[9].setOnAction(e-> intermediate(9));
		month_name[10].setOnAction(e-> intermediate(10));
		month_name[11].setOnAction(e-> intermediate(11));
		
		month_display = false;
		title.setOnMouseClicked(e-> month_display());
		today.setOnAction(e-> set_current(s));
		int skin_index = RetrieveSkinData(false);
		if(skin_index == -1)
			SetLayout(0);
		else
			SetLayout(skin_index);
		front(s);
		
		set_current(s);
		
	}
	public static void main(String args[])
	{
		launch(args);
	}
}