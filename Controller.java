package com.mahima.connect4;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller  implements Initializable {
	private  static  final  int COLUMNS= 7;
	private  static final int ROWS= 6;
	private static final int CIRCLE_DIAMETER= 80;
	public static final String discColor1= "#24303E";
	public static final String discColor2= "#4CAA88";
	private static String PLAYER_ONE= "Player One";
	private static String PLAYER_TWO= "Player Two";
	private boolean isPlayerOneTurn= true;



	@FXML
	public GridPane RootGridPane;
	@FXML
	public Pane insertedDiskPane;
	@FXML
	public Label playerNameLabel;

	public void createPlayground()
	{
		Shape rectangleWithHoles= createGameStructuralGrid();

		RootGridPane.add(rectangleWithHoles,0,1);

		List<Rectangle> rectangleList= createClickableColumns();
		for(Rectangle rectangle:rectangleList)
		{
			RootGridPane.add(rectangle,0,1);
		}

	}

	private Shape createGameStructuralGrid()
	{
		Shape rectangleWithHoles=new Rectangle((COLUMNS+1)*CIRCLE_DIAMETER, (ROWS+1)*CIRCLE_DIAMETER);

		for(int row=0;row<ROWS;row++)
		{
			for(int col=0;col<COLUMNS;col++)
			{
				Circle circle= new Circle();
				circle.setRadius(CIRCLE_DIAMETER/2);
				circle.setCenterX(CIRCLE_DIAMETER/2);
				circle.setCenterY(CIRCLE_DIAMETER/2);
				circle.setTranslateX(col*(CIRCLE_DIAMETER+5)+CIRCLE_DIAMETER/4);
				circle.setTranslateY(row*(CIRCLE_DIAMETER+5)+CIRCLE_DIAMETER/4);

				rectangleWithHoles= Shape.subtract(rectangleWithHoles, circle);

			}
		}
		rectangleWithHoles.setFill(Color.WHITE);

		return rectangleWithHoles;
	}
	private List<Rectangle> createClickableColumns()
	{
		List<Rectangle> rectangleList= new ArrayList<>();
		for(int col=0;col<COLUMNS;col++) {
			Rectangle rectangle = new Rectangle(CIRCLE_DIAMETER, (ROWS + 1) * CIRCLE_DIAMETER);
			rectangle.setFill(Color.BLUE);
			rectangle.setTranslateX(col*(CIRCLE_DIAMETER+5)+CIRCLE_DIAMETER/4);

			rectangle.setOnMouseEntered(event->rectangle.setFill(Color.RED));
			rectangle.setOnMouseExited(event->rectangle.setFill(Color.BLUE));
			rectangleList.add(rectangle);
		}
		return  rectangleList;
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

	}
}
