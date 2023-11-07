package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class IndexController {
	
	@FXML
    private ImageView imgBikeCity = new ImageView();

	@FXML
    private ImageView imgBikeRace = new ImageView();
	
	public void goToDetailRace(MouseEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("veloDetail.fxml"));
        Parent detailBike = loader.load();
        Scene sceneDetailBike = new Scene(detailBike);
        veloDetailController detailController = loader.getController();
        detailController.setSelectedImage(imgBikeRace.getImage());
        detailController.setSelectedVelo("course");
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(sceneDetailBike);
        stage.show();
	}
	
	
	public void goToDetailCity(MouseEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("veloDetail.fxml"));
        Parent detailBike = loader.load();
        Scene sceneDetailBike = new Scene(detailBike);
        veloDetailController detailController = loader.getController();
        detailController.setSelectedImage(imgBikeCity.getImage());
        detailController.setSelectedVelo("city");
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(sceneDetailBike);
        stage.show();
	}
}


