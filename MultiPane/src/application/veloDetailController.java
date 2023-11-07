package application;

import java.io.File; // Add this import statement
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;

public class veloDetailController {

    @FXML
    private Button back;

    @FXML
    private Button colorOne;

    @FXML
    private Button colorTwo;

    @FXML
    private Button colorThree;

    @FXML
    private Button validButton;

    @FXML
    private ImageView imgBike;

    @FXML
    private Text totalPriceText;

    @FXML
    private Text colorPriceText;

    @FXML
    private Text customText;

    private Image selectedImage;

    private String selectedVelo;

    private double basePrice;
    private double colorPrice;
    private double customPrice;
    private boolean customAdded = false;

    @FXML
    private TextField customInput;
    public void initialize() {
        customInput.textProperty().addListener((observable, oldValue, newValue) -> {
            customAdded = false;
        });
    }

    public void backIndex(MouseEvent e) throws IOException {
        Parent backIndex = FXMLLoader.load(getClass().getResource("index.fxml"));
        Scene sceneBackIndex = new Scene(backIndex);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(sceneBackIndex);
        stage.show();
    }

    public Image getSelectedImage() {
        return selectedImage;
    }

    public void setSelectedImage(Image selectedImage) {
        this.selectedImage = selectedImage;
        imgBike.setImage(selectedImage);
    }

    public void setSelectedVelo(String veloType) {
        this.selectedVelo = veloType;
        if (this.selectedVelo.equals("course")) {
            basePrice = 400.0;
            File file = new File("src/asset/course/velo_course_jaune.jpg");
            Image newImage = new Image(file.toURI().toString());
            imgBike.setImage(newImage);
        } else if (this.selectedVelo.equals("city")) {
            File file = new File("src/asset/ville/velo_ville_jaune.jpg");
            Image newImage = new Image(file.toURI().toString());
            imgBike.setImage(newImage);
            basePrice = 300.0;
        }
        updatePriceLabels();
    }

    public void onClickColorOne(ActionEvent event) {
        if (this.selectedVelo != null) {
            String imagePath = "";
            if (this.selectedVelo.equals("course")) {
                imagePath = "src/asset/course/velo_course_jaune.jpg";
                colorPrice = 15.0;
            } else if (this.selectedVelo.equals("city")) {
                imagePath = "src/asset/ville/velo_ville_jaune.jpg";
                colorPrice = 15.0;
            }
            File file = new File(imagePath);
            Image newImage = new Image(file.toURI().toString());
            imgBike.setImage(newImage);
            if (customAdded) {
                customPrice = 25.0;
                customAdded = true;
            }
            updatePriceLabels();
        }
    }

    public void onClickColorTwo(ActionEvent event) {
        if (this.selectedVelo != null) {
            String imagePath = "";
            if (this.selectedVelo.equals("course")) {
                imagePath = "src/asset/course/velo_course_rouge.jpg";
                colorPrice = 25.0;
            } else if (this.selectedVelo.equals("city")) {
                imagePath = "src/asset/ville/velo_ville_rouge.jpg";
                colorPrice = 25.0;
            }
            File file = new File(imagePath);
            Image newImage = new Image(file.toURI().toString());
            imgBike.setImage(newImage);
            if (!customAdded) {
                customPrice = 25.0;
                customAdded = true;
            }
            updatePriceLabels();
        }
    }

    public void onClickColorThree(ActionEvent event) {
        if (this.selectedVelo != null) {
            String imagePath = "";
            if (this.selectedVelo.equals("course")) {
                imagePath = "src/asset/course/velo_course_bleu.jpg";
                colorPrice = 18.0;
            } else if (this.selectedVelo.equals("city")) {
                imagePath = "src/asset/ville/velo_ville_bleu.jpg";
                colorPrice = 18.0;
            }
            File file = new File(imagePath);
            Image newImage = new Image(file.toURI().toString());
            imgBike.setImage(newImage);
            if (!customAdded) {
                customPrice = 25.0;
                customAdded = true;
            }
            updatePriceLabels();
        }
    }

    public void onValidButtonClick(ActionEvent event) {
        String customTextValue = customInput.getText();
        customText.setText("Personnalisé : " + customTextValue);
        if (!customAdded) {
            customPrice = 25.0;
            customAdded = true;
            updatePriceLabels();
        }
    }

    private void updatePriceLabels() {
        double totalPrice = basePrice + colorPrice + customPrice;
        totalPriceText.setText("Prix total : " + totalPrice + "€");
        colorPriceText.setText("Prix de la couleur : " + colorPrice + "€");
    }
}
