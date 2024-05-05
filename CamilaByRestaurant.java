import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import java.io.File;
import java.net.URL;
import javafx.geometry.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ScrollPane;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import java.io.FileWriter;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import java.io.IOException;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextArea;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.scene.control.Separator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import java.util.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.control.ButtonType;


public class CamilaByRestaurant extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("RestaurantApp");
        HBox navPanel = CamilaByRestaurant.createNavigationPanel(primaryStage);

        StackPane pane = new StackPane(navPanel);
        ImageView mainImage = new ImageView("Image/MainImage.jpg");
        mainImage.setFitWidth(1200);
        mainImage.setFitHeight(700);
        Label welcome = new Label("Welcome to Noodles!");
        welcome.setStyle("-fx-font-size: 110px; -fx-font-weight: bold; -fx-text-fill: #ffffff; -fx-padding: 0 0 10px 0; -fx-alignment: center;");

        FadeTransition ft = new FadeTransition(Duration.millis(2000), welcome);
            ft.setFromValue(1.0);
            ft.setToValue(0.1);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();

        pane.getChildren().addAll(mainImage, welcome);
        Scene scene = new Scene(pane, 1200, 800);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static HBox createNavigationPanel(Stage primaryStage) {
    Button homeButton = new Button("Home.Noodles");
    Button bookingButton = new Button("Booking");
    Button galleryButton = new Button("Gallery");
    Button menuButton = new Button("Menu");
    Button contactButton = new Button("Contact");

    homeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
    bookingButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
    galleryButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
    menuButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
    contactButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");

    homeButton.setOnAction(e -> {
        Scene homeScene = new Scene(new HomeScenePane(primaryStage), 1200, 800);
        primaryStage.setTitle("Home.Noodles");
        primaryStage.setScene(homeScene);
    });

    bookingButton.setOnAction(e -> {
        Scene bookingScene = new Scene(new BookingScenePane(primaryStage), 1200, 800);
        primaryStage.setTitle("Booking");
        primaryStage.setScene(bookingScene);
    });

    galleryButton.setOnAction(e -> {
        Scene galleryScene = new Scene(new GalleryScenePane(primaryStage), 1200, 800);
        primaryStage.setTitle("Gallery");
        primaryStage.setScene(galleryScene);
    });

    menuButton.setOnAction(e -> {
        Scene menuScene = new Scene(new MenuScenePane(primaryStage), 1200, 800);
        primaryStage.setTitle("Menu");
        primaryStage.setScene(menuScene);
    });

    contactButton.setOnAction(e -> {
        Scene contactScene = new Scene(new ContactScenePane(primaryStage), 1200, 800);
        primaryStage.setTitle("Contact us");
        primaryStage.setScene(contactScene);
    });

    HBox navPanel = new HBox(homeButton, bookingButton, galleryButton, menuButton, contactButton);
    navPanel.setStyle("-fx-background-color: black;");
    return navPanel;
}

private ImageView createImageView(String imagePath) {
    ImageView imageView = new ImageView(imagePath);
    imageView.setFitWidth(1200);
    imageView.setFitHeight(300);
    return imageView;
    }
}

    class HomeScenePane extends BorderPane{
        private int currentIndex = 0;
        public HomeScenePane(Stage primaryStage) {

        ImageView imageView = new ImageView("Image/home.jpg");
        imageView.setFitWidth(1200);
        imageView.setFitHeight(800);

        Label noodles = new Label("Noodles");
        noodles.setStyle("-fx-font-size: 120px; -fx-text-fill: white; -fx-font-family: Georgia; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 10, 0, 0, 0);");

        Timeline change = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
            Image currentImage = imageView.getImage();
            String currentImagePath = currentImage.getUrl();

    if (currentImagePath.endsWith("home.jpg")) {
        imageView.setImage(new Image("Image/home1.jpg"));
    } else if (currentImagePath.endsWith("home1.jpg")) {
        imageView.setImage(new Image("Image/home2.jpg"));
    } else if (currentImagePath.endsWith("home2.jpg")) {
        imageView.setImage(new Image("Image/home3.jpg"));
    }else if(currentImagePath.endsWith("home3.jpg")){
        imageView.setImage(new Image("Image/home4.jpg"));
    }else if(currentImagePath.endsWith("home4.jpg")){
        imageView.setImage(new Image("Image/home.jpg"));
    }
    }));

    change.setCycleCount(Timeline.INDEFINITE);
    change.play();
        
        StackPane imagePane = new StackPane();
        imagePane.getChildren().addAll(imageView, noodles);

        ImageView menuImage = new ImageView("Image/image.jpg");
        menuImage.setFitWidth(1200);
        menuImage.setFitHeight(600);
        
        Label txt = new Label("We are committed to working with family farms,\n small scale fishing boats.\n \nOur chefs prepare dishes that we are sure you will like!");
        txt.setStyle("-fx-font-size: 25px; -fx-text-fill: black; -fx-font-family: Roboto;");
        Button menu = new Button("VIEW MENUS");
        menu.setStyle("-fx-background-image: url('Image/home.jpg'); " + 
        "-fx-text-fill: white; " + 
        "-fx-background-radius: 15; " + 
        "-fx-border-color: transparent; " + 
        "-fx-padding: 10px 20px;" + 
        "-fx-font-size: 25px;"  +
        "-fx-font-family: Roboto;"
    );

    menu.setOnMousePressed(e -> menu.setScaleX(1.1));
    menu.setOnMouseReleased(e -> menu.setScaleX(1.0));
        menu.setOnAction(e -> {
        Scene menuScene = new Scene(new MenuScenePane(primaryStage), 1200, 800);
        primaryStage.setTitle("Menu");
        primaryStage.setScene(menuScene);
    });


        AnchorPane menuPane = new AnchorPane();
        AnchorPane.setTopAnchor(menu, 400.0);
        AnchorPane.setTopAnchor(txt, 200.0);
        AnchorPane.setLeftAnchor(menu, 220.0);
        AnchorPane.setLeftAnchor(txt, 30.0);

        menuPane.getChildren().addAll(menuImage, menu, txt);


        AnchorPane bookPane = new AnchorPane();
        ImageView book = new ImageView("Image/home4.jpg");
        Label bookTxt = new Label("Book your table");
        book.setFitWidth(1200);
        book.setFitHeight(600);
        bookTxt.setStyle("-fx-font-size: 100px; -fx-text-fill: white; -fx-font-family: Georgia; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 10, 0, 0, 0);");

        Button booking = new Button("Book table");
        booking.setStyle("-fx-background-color: black;" + 
        "-fx-text-fill: white; " + 
        "-fx-border-color: white; " + 
        "-fx-padding: 10px 20px;" + 
        "-fx-font-size: 25px;"  +
        "-fx-font-family: Roboto;"); 

        booking.setOnMousePressed(e -> booking.setScaleX(1.1));
        booking.setOnMouseReleased(e -> booking.setScaleX(1.0));

        booking.setOnAction(e -> {
            Scene bookingScene = new Scene(new BookingScenePane(primaryStage), 1200, 800);
            primaryStage.setTitle("Booking");
            primaryStage.setScene(bookingScene);
        });

        AnchorPane.setLeftAnchor(booking, 100.0);
        AnchorPane.setTopAnchor(booking, 200.0);
        bookPane.getChildren().addAll(book, bookTxt, booking);

        VBox imageVBox = new VBox(imagePane);
        imageVBox.setAlignment(Pos.TOP_CENTER);

        AnchorPane info = new AnchorPane();
        ImageView contact = new ImageView("Image/info.jpg");
        contact.setFitWidth(1200);
        contact.setFitHeight(600);

        Label address = new Label("Avenue Dostyk, 52/2, Almaty \n TEL. +1234567890");
        address.setStyle("-fx-font-size: 45px; -fx-text-fill: white; -fx-font-family: Georgia; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 10, 0, 0, 0);");

        TextField reply = new TextField();
        reply.setPromptText("Send your comments here:");
        reply.setStyle("-fx-background-color: darkgreen; -fx-text-fill: white; -fx-pref-width: 200px; -fx-pref-height: 40px; -fx-background-radius: 15px;");

        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: lightgreen;");
        submitButton.setOnAction(e -> {
            String text = reply.getText();
            try {
                FileWriter leaveReply = new FileWriter("Comment.txt", true);
                leaveReply.write("Comment from user: " + text + "\n");
                leaveReply.close();
                showAlert("Comment successfully submitted.");
            } catch (IOException ex) {
                ex.printStackTrace();
                showAlert("Failed to save comment.");
            }
        }); 

        AnchorPane.setLeftAnchor(submitButton, 400.0);
        AnchorPane.setTopAnchor(submitButton, 500.0);

        AnchorPane.setLeftAnchor(reply, 400.0);
        AnchorPane.setTopAnchor(reply, 400.0);

        AnchorPane.setLeftAnchor(address, 200.0);
        AnchorPane.setTopAnchor(address, 200.0);
        info.getChildren().addAll(contact, address, reply, submitButton);

        AnchorPane reviews = new AnchorPane();
        Label review = new Label("REVIEW OUR CUSTOMERS");
        review.setStyle("-fx-font-size: 80px; -fx-text-fill: white; -fx-font-family: Georgia; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 10, 0, 0, 0);");
        ImageView star = new ImageView("Image/home1.jpg");
        star.setFitWidth(1200);
        star.setFitHeight(600);

        Image[] images = {
            new Image("Image/review1.jpg"),
            new Image("Image/review2.jpg"),
            new Image("Image/review3.jpg"),
            new Image("Image/reviews4.jpg"),
            new Image("Image/review5.jpg"),
            new Image("Image/review6.jpg")
        };
        
        HBox box = new HBox();
        ImageView imageReview = new ImageView(images[currentIndex]);
        imageReview.setFitWidth(600);
        imageReview.setFitHeight(500);
        

        box.setOnMouseClicked(e -> {
            currentIndex = (currentIndex + 1) % images.length;
            imageReview.setImage(images[currentIndex]);
        });
        box.getChildren().add(imageReview);

        AnchorPane.setLeftAnchor(review, 100.0);
        AnchorPane.setTopAnchor(box, 100.0);
        AnchorPane.setLeftAnchor(box, 300.0);

        reviews.getChildren().addAll(star, review, box);

        WebView webView = new WebView();
        webView.setPrefSize(600, 400);
        WebEngine webEngine = webView.getEngine();
        webEngine.load("https://maps.app.goo.gl/PvSDxtu7sNEnr1xv9");

        AnchorPane gps = new AnchorPane();
        gps.getChildren().add(webView);

        VBox contentPane = new VBox(imageVBox, menuPane, bookPane, info, reviews, gps);
        contentPane.setAlignment(Pos.TOP_CENTER);

        ScrollPane scrollPane = new ScrollPane(contentPane);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        HBox navPanel = CamilaByRestaurant.createNavigationPanel(primaryStage);
        this.setTop(navPanel);
        this.setCenter(scrollPane);
    }
    public static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Comment Submission");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

class BookingScenePane extends BorderPane{

    private int tableNumber;
    private TextField nameField;
    private TextField emailField;
    private TextField phoneField;
    private TextField specialRequestField;
    private DatePicker datePicker;
    private ComboBox<String> timeComboBox;
    private ComboBox<String> size;
    private String nameTrue;
    private String emailTrue;
    private LocalDate dateTrue;
    private String sizeTrue;
    private String timeTrue;    
    private String specialRequest;

    public  BookingScenePane(Stage primaryStage) {
         
        HBox navPanel = CamilaByRestaurant.createNavigationPanel(primaryStage);
        String labelStyle = "-fx-background-color: lightgreen; -fx-padding: 5px; -fx-border-radius: 15px; -fx-background-radius: 15px;";
   

        VBox bookingForm = new VBox();
        bookingForm.setSpacing(10);

        Label booking = new Label("Booking");
        booking.setFont(Font.font("Roboto", FontWeight.BOLD, 35));
        booking.setTextFill(Color.BLACK);

        bookingForm.setStyle("-fx-background-color: lightgreen; -fx-padding: 10px; -fx-border-radius: 15px; -fx-background-radius: 15px;");
        bookingForm.setPrefWidth(220.0);

        Label name = new Label("Name (required)");
        name.setFont(Font.font("Roboto", FontWeight.BOLD, 18));
        nameField = new TextField();
        nameField.setPromptText("Enter your name");
        nameField.setMaxWidth(200);

        Label email = new Label("Email (required)");
        email.setFont(Font.font("Roboto", FontWeight.BOLD, 18));
        emailField = new TextField();
        emailField.setPromptText("Enter your email");
        emailField.setMaxWidth(200);
        
        Label phone = new Label("Phone");
        phone.setFont(Font.font("Roboto", FontWeight.BOLD, 18));
        phoneField = new TextField();
        phoneField.setPromptText("Enter your phone: +7 *** *** ******");
        phoneField.setMaxWidth(200);
        
        Label date = new Label("Date (required)");
        datePicker = new DatePicker();
        date.setFont(Font.font("Roboto", FontWeight.BOLD, 18));
        datePicker.setPromptText("Enter the date:");
        
        Label sizeW = new Label("Size(required)");
        sizeW.setFont(Font.font("Roboto", FontWeight.BOLD, 18));
        size = new ComboBox<>();
        size.getItems().addAll("1 person", "2 person", "3 person", "4 person", "5 person", "6 person", "7 person");


        Label timeLabel = new Label("Time (required)");
        timeComboBox = new ComboBox<>();
        timeComboBox.getItems().addAll(
            "09:00 AM", "10:00 AM", "11:00 AM", 
            "12:00 PM", "01:00 PM", "02:00 PM",
            "03:00 PM", "04:00 PM", "05:00 PM",
            "06:00 PM", "07:00 PM", "08:00 PM",
            "09:00 PM", "10:00 PM"
        );

        Label specialRequests = new Label("Special Request");
        specialRequests.setFont(Font.font("Roboto", FontWeight.BOLD, 18));
        specialRequestField = new TextField();
        specialRequestField.setPromptText("Enter your requests");
        specialRequestField.setMaxWidth(200);

        Button bookButton = new Button("Book Table");
        bookButton.setLayoutX(300);
        bookButton.setLayoutY(1200);
        bookButton.setOnAction(event -> {
            nameTrue = nameField.getText();
            emailTrue = emailField.getText();
            dateTrue = datePicker.getValue();
            String timeTrue = timeComboBox.getValue(); 
            sizeTrue = size.getValue();
            specialRequest = specialRequestField.getText(); 

                if (nameTrue.isEmpty() || emailTrue.isEmpty() || dateTrue == null || timeTrue.isEmpty() || sizeTrue.isEmpty() || tableNumber == 0) {
                showAlert("Please fill in all fields and check it corrects.");
            }else{
                showAlert();
            }
            });

        timeComboBox.setPromptText("Select time");
        bookingForm.getChildren().addAll(booking, name, nameField, email, emailField, phone, phoneField, date, datePicker, timeLabel, timeComboBox, sizeW, size, specialRequests, specialRequestField, bookButton);
        
     


        Image backgroundImage = new Image("Image/bookingTable.jpg");

        BackgroundPosition position = new BackgroundPosition(Side.RIGHT, 0.0, false, Side.TOP,0, false);
        BackgroundImage background = new BackgroundImage(
            backgroundImage,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            position,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false)
        );

        Background backgroundImg = new Background(background);

        this.setBackground(backgroundImg);
            
            Table table1 = new Table();
            Table table2 = new Table();
            Table table3 = new Table();

            ToggleButton buttonTable1 = new ToggleButton("Table 1");
            buttonTable1.setStyle("-fx-background-color: #008000; -fx-text-fill: #ffffff; -fx-background-radius: 50em;");

            ToggleButton buttonTable2 = new ToggleButton("Table 2");
            buttonTable2.setStyle("-fx-background-color: #008000; -fx-text-fill: #ffffff; -fx-background-radius: 50em;");

            ToggleButton buttonTable3 = new ToggleButton("Table 3");
            buttonTable3.setStyle("-fx-background-color: #008000; -fx-text-fill: #ffffff; -fx-background-radius: 50em;");

            ToggleGroup toggleGroup = new ToggleGroup(); // Создаем группу для кнопок
            buttonTable1.setToggleGroup(toggleGroup);
            buttonTable2.setToggleGroup(toggleGroup);
            buttonTable3.setToggleGroup(toggleGroup);

            
             buttonTable1.setOnAction(e -> {
                if (tableNumber == 1) {
                table1.release();
                buttonTable1.setStyle("-fx-background-color: #008000;" + "-fx-text-fill: #ffffff;" + "-fx-background-radius: 25em;");
                tableNumber = 0;
            } else {
                if (table1.isAvailable()) {
                    table1.reserve();
                    buttonTable1.setStyle("-fx-background-color: #ff0000;" + "-fx-text-fill: #ffffff;" + "-fx-background-radius: 25em;");
                    tableNumber = 1;
                } else {
                    showAlert("This table is already booked!");
                }
            }
        });

            buttonTable2.setRotate(-80);

            buttonTable2.setOnAction(e -> {
                if (tableNumber == 2) {
                    table2.release();
                    buttonTable2.setStyle("-fx-background-color: #008000;" + "-fx-text-fill: #ffffff;" + "-fx-background-radius: 25em;");
                    tableNumber = 0;
                } else {
                    if (table2.isAvailable()) {
                        table2.reserve();
                        buttonTable2.setStyle("-fx-background-color: #ff0000;" + "-fx-text-fill: #ffffff;" + "-fx-background-radius: 25em;");
                        tableNumber = 2;
                    } else {
                        showAlert("This table is already booked!");
                    }
                }
            });

            buttonTable3.setOnAction(e -> {
                if (tableNumber == 3) {
                    table3.release();
                    buttonTable3.setStyle("-fx-background-color: #008000;" + "-fx-text-fill: #ffffff;" + "-fx-background-radius: 25em;");
                    tableNumber = 0;
                } else {
                    if (table3.isAvailable()) {
                        table3.reserve();
                        buttonTable3.setStyle("-fx-background-color: #ff0000;" + "-fx-text-fill: #ffffff;" + "-fx-background-radius: 25em;");
                        tableNumber = 3;
                    } else {
                        showAlert("This table is already booked!");
                    }
                }
            });


        AnchorPane button = new AnchorPane();

        AnchorPane.setLeftAnchor(buttonTable1, 650.0);
        AnchorPane.setTopAnchor(buttonTable1, 560.0);

        AnchorPane.setLeftAnchor(buttonTable2, 350.0);
        AnchorPane.setBottomAnchor(buttonTable2, 80.0);

        AnchorPane.setLeftAnchor(buttonTable3, 480.0);
        AnchorPane.setTopAnchor(buttonTable3, 630.0);

        button.getChildren().addAll(buttonTable1, buttonTable2, buttonTable3);


        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(button);
        this.setLeft(bookingForm);
        this.setTop(navPanel);
        this.setCenter(vbox);
     }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning");
        alert.setHeaderText("Are you sure you entered all the correct information?");
        alert.setContentText("Please confirm your action:");

        ButtonType buttonTypeYes = new ButtonType("Yes");
        ButtonType buttonTypeNo = new ButtonType("No");
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        alert.showAndWait().ifPresent(response -> {
        
        if (response == buttonTypeYes) {

                saveBooking(nameTrue, emailTrue, dateTrue, timeTrue, sizeTrue, tableNumber, specialRequest);
                nameField.clear();
                emailField.clear();
                phoneField.clear();
                datePicker.setValue(null);
                timeComboBox.setValue(null);
                size.setValue(null);
                specialRequestField.clear();

        }else if(response == buttonTypeNo){
            alert.close();
        }
    });
}

public static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
}

    private void saveBooking(String name, String email, LocalDate date, String selectedTime, String size, int tableNumber, String specialRequest) {
        try {
            FileWriter writer = new FileWriter("bookings.txt", true);
            writer.write("Name: " + name + " \n Email: " + email + "\n Date: " + date + "\n Time: "  + selectedTime + "\n Size: " + size + "\n Table: " + tableNumber + "\n Special Request: " + specialRequest + "\n");
            writer.close();
            showAlert("Table successfully booked.");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Failed to save booking.");
        }
    }
}
    class Table {

    private boolean isAvailable;

    public Table() {
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void reserve() {
        if (isAvailable) {
            isAvailable = false;
        } else {
            throw new IllegalStateException("The table is already reserved");
        }
    }
    public void release() {
        isAvailable = true;
    }
}


class GalleryScenePane extends VBox{
    public ImageView imageView;
    public  GalleryScenePane(Stage primaryStage) {

        String[] imagePaths = {
    "Image/Breakfast-1.jpg",
    "Image/Breakfast-2.jpg",
    "Image/Breakfast-3.jpg", 
    "Image/HumusAndMeat.jpg", 
    "Image/quesadilla.jpg",
    "Image/Salad.jpg",
    "Image/Steak.jpg",
    "Image/Turkish_breakfast.jpg"
};

        String[] dishDescription = {
    "Breakfast Bowl - Oatmeal, yogurt, berries. Price: 1750 KZT",
    "Pancake - Pancake, honey, chocolate, strawberry. Price: 1500 KZT",
    "Breakfast - Egg, cheese, sandwich. Price: 1350 KZT",
    "Mediterranean breakfast - Hummus, basturma, cherry tomato salad, toast. Price: 4650 KZT",
    "Quesadilla with salmon and shrimp - Shrimp, salmon, cheddar cheese, guacamole sauce, avocado. Price: 4900 KZT",
    "Salad - Grilled chicken, avocado, lettuce, red beans, cucumber, bell pepper, corn, sauce. Price: 3900 KZT",
    "Beef ribs BBQ - Beef ribs, vegetables, barbecue sauce, mashed potatoes. Price: 6400 KZT",
    "Turkish breakfast - Cheese, adjika, hummus, olives, fruits, honey, kaymak, jam, cheese rolls, vegetables. Price: 7600 KZT"
};

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5));
        pane.setHgap(10);
        pane.setVgap(10);

        int colum = 4;
        int rows = (int)Math.ceil(imagePaths.length/(double) colum);

        for (int i = 0; i < imagePaths.length; i++) {
            imageView = new ImageView(new Image(imagePaths[i]));
            imageView.setFitWidth(300);
            imageView.setFitHeight(400);
            pane.add(imageView, i % colum, i / colum);

        final int index = i;
        imageView.setOnMouseClicked(event -> {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Dish Description");
        alert.setHeaderText(null);
        alert.setContentText(dishDescription[index]);
        alert.showAndWait();
        });
    }

String[] imagePathRandom = {
                "Image/Turkish_breakfast.jpg",
                "Image/miso.jpg",
                "Image/chelbir.png",
                "Image/mango.jpg",
                "Image/cheesecakes.jpg",
                "Image/Panini.jpg",
                "Image/waffles.jpg",
                "Image/ramen.jpg",
                "Image/lentil-soup.jpg",
                "Image/chicken-noodle.jpg",
                "Image/traditional.jpg",
                "Image/fish.jpg",
                "Image/masala.jpg",
                "Image/karashi.jpg"
        };

        List<String> imagePathR = new ArrayList<>();
        Collections.addAll(imagePathR, imagePathRandom);
        
        GridPane random = new GridPane();
random.setPadding(new Insets(6));
random.setHgap(20);
random.setVgap(20);

Timeline timeline = new Timeline(
    new KeyFrame(Duration.seconds(5), event -> {
        Collections.shuffle(imagePathR);
        random.getChildren().clear();
        int columnIndex = 0;
        int rowIndex = 0;
        for (String imagePath : imagePathR) {
            ImageView imageRandom = new ImageView(new Image(imagePath));
            imageRandom.setFitWidth(300);
            imageRandom.setFitHeight(400);
            random.add(imageRandom, columnIndex, rowIndex);
            columnIndex++;
            if (columnIndex >= colum) {
                columnIndex = 0;
                rowIndex++;
            }
        }
    })
);
timeline.setCycleCount(Timeline.INDEFINITE);
timeline.play();

        VBox images = new VBox();
        images.getChildren().addAll(random, pane);
        images.setStyle("-fx-background-image: url('Image/gallery.jpg'); -fx-alignment: center;");

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(images);
        scrollPane.setFitToWidth(true);
        
        images.setAlignment(Pos.CENTER);
        
        HBox navPanel = CamilaByRestaurant.createNavigationPanel(primaryStage);
        getChildren().addAll(navPanel, scrollPane);
    }
}

    class MenuScenePane extends BorderPane {
        public MenuScenePane(Stage primaryStage) {
            Label menuLabel = new Label("Menu");
            menuLabel.setStyle("-fx-font-size: 60px; -fx-font-weight: bold; -fx-text-fill: #ffffff; -fx-padding: 0 0 10px 0; -fx-alignment: center;");


            FadeTransition ft = new FadeTransition(Duration.millis(1000), menuLabel);
            ft.setFromValue(1.0);
            ft.setToValue(0.1);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();

            HBox navPanel = CamilaByRestaurant.createNavigationPanel(primaryStage);
            this.setTop(navPanel);

            HBox menuPane = new HBox();
            menuPane.setAlignment(Pos.CENTER);
            menuPane.getChildren().add(menuLabel);
             
            VBox menuBox = new VBox(10);
            Label breakfastLabel = new Label("-----------Breakfast-----------");
            menuBox.setAlignment(Pos.CENTER);
            breakfastLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-alignment: center; -fx-text-fill: #ffffff;  -fx-padding: 5px; -fx-background-radius: 5; -fx-background-color: lightblue;");
            menuBox.getChildren().addAll(menuPane, breakfastLabel);
            menuBox.setStyle("-fx-background-radius: 10px; -fx-background-image: url('Image/backgroundMenu.jpg'); -fx-padding: 10px;");

            String [] Breakfast = {
                "Chelbyr", 
                "Turkish breakfast", 
                "Waffles with fruits and berries",
                "Panini with vegetables", 
                "Cheesecakes",
                "Chia mango with muesli"
            };

        String [] breakfastDescription = {
        "Poached egg, yogurt, garlic, Toast with chilli sauce. \n                                 2600 KZT",
        "Three types of cheese, adjika, hummus, green olives, black olives, \n fruits, honey and kaymak, jam, simit, cheese rolls, tomatoes,\n  cucumbers, menemen, black and white raisins, dried apricots. \n                                          7600 KZT",
        "Waffles, whipped cream, bananas, strawberries, raspberries and mangos. \n                                                1900 KZT",
        "Ciabatta, eggplant, zucchini, bell pepper, mozzarella, green mix with pesto sauce. \n                                                       1900 KZT",
        "Cheesecakes with strawberries, raspberries, orange and Nutella. \n                                          2900 KZT", 
        "Chia seeds, mango puree, fresh mango, strawberries, granola, mint, French toast. \n                                                       3900 KZT"
        };

        for (int i = 0; i < Breakfast.length; i++) {
            Label titleLabel = new Label(Breakfast[i]);
            titleLabel.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #ffffff; -fx-alignment: center; -fx-max-width: infinity;");

            Label descriptionLabel = new Label(breakfastDescription[i]);
            descriptionLabel.setStyle("-fx-font-size: 14; -fx-text-fill: #ffffff; -fx-alignment: center; -fx-max-width: infinity;");
        
            VBox itemBox = new VBox(titleLabel, descriptionLabel);
                menuBox.getChildren().add(itemBox);

                 Separator line = new Separator();
                 line.setMaxWidth(150);
                 line.setStyle("-fx-background-color: black");
                 menuBox.getChildren().add(line);
    }       
            Separator separator = new Separator();
            separator.setPrefWidth(180);
            separator.setStyle("-fx-background-color: black");
            menuBox.getChildren().add(separator);
            
            Label soupsLabel = new Label("-----------Soups-----------");
            soupsLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-alignment: center; -fx-text-fill: #ffffff;  -fx-padding: 5px; -fx-background-color: lightblue;");
            menuBox.getChildren().add(soupsLabel);

            String [] soups = {
                "Traditional nomadic soup",
                "Lentil soup",
                "Chicken noodle soup",
            };
            
            String [] soupDescription = {
                "Dough, kazy, zhaya, green onions;  served with kurt and sour cream. \n                                             2900 KZT",
                "Classic red lentil soup, served with croutons and a slice of lemon. \n                                             2200 KZT ",
                "Chicken broth, noodles, chicken, quail eggs and fresh herbs. \n                                            2200 KZT"
            };

            for(int i = 0; i < soups.length; i++){
                Label titleLabel = new Label(soups[i]);
                titleLabel.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #ffffff; -fx-alignment: center; -fx-max-width: infinity;");

                Label descriptionLabel = new Label(soupDescription[i]);
                descriptionLabel.setStyle("-fx-font-size: 14; -fx-text-fill: #ffffff; -fx-alignment: center; -fx-max-width: infinity;");
        
                VBox itemBox = new VBox(titleLabel, descriptionLabel);
                menuBox.getChildren().add(itemBox);

                        Separator line = new Separator();
                        line.setMaxWidth(150);
                        line.setStyle("-fx-background-color: black");
                        menuBox.getChildren().add(line);
                    }

                    Separator separator2 = new Separator();
                    separator.setPrefWidth(180);
                    separator.setStyle("-fx-background-color: black");
                    menuBox.getChildren().add(separator2);

                    Label wokLabel = new Label("-----------Wok dish-----------");
                    wokLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-alignment: center; -fx-text-fill: #ffffff;  -fx-padding: 5px; -fx-background-color: lightblue;");
                    menuBox.getChildren().add(wokLabel);

            String [] wok = {
                "Miso soup",
                "Ramen",
                "Karashi",
                "Chicken masala",
                "Thai fried rice",
                "Squirrel fish"
            };
            
            String [] wokDescription = {
                "Tofu, seaweed, shiitake mushrooms, green onions.   \n                                      1390 KZT",
                "Seafood, enoki mushrooms, eggs, bok choy, shiitake mushrooms.  \n                                              4900 KZT ",
                "Shrimp, squid, mussels, tofu, shiitake mushrooms, bok choy, rice noodles.   \n                                                 2900 KZT",
                "Chicken, masala sauce, boiled rice, coriander. \n                          2700 KZT",
                "Thai rice, eggs, carrots, green onions, served separately with Khao Pad sauce.  \n                                               3900 KZT",
                "Deep-fried seabass with sweet and sour sauce.  \n                          6900 KZT"
            };

            for(int i = 0; i < wok.length; i++){
                Label titleLabel = new Label(wok[i]);
                titleLabel.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #ffffff; -fx-alignment: center; -fx-max-width: infinity;");

                Label descriptionLabel = new Label(wokDescription[i]);
                descriptionLabel.setStyle("-fx-font-size: 14; -fx-text-fill: #ffffff; -fx-alignment: center; -fx-max-width: infinity;");
        
                VBox itemBox = new VBox(titleLabel, descriptionLabel);
                menuBox.getChildren().add(itemBox);
                
                        Separator line = new Separator();
                        line.setMaxWidth(150);
                        line.setStyle("-fx-background-color: black");
                        menuBox.getChildren().add(line);
                 }


             StackPane menu = new StackPane();
             Image backgroundImage = new Image("Image/backgroundMenu.jpg");

            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(menuBox);
            scrollPane.setFitToWidth(true);

            menu.getChildren().addAll(scrollPane);
            this.setCenter(menu);

            menuBox.setStyle("-fx-background-image: url('" + backgroundImage.getUrl() + "'); -fx-background-size: cover;");
        }
    }


class ContactScenePane extends BorderPane {
    private String rating;

    public ContactScenePane(Stage primaryStage) {
        
        this.setStyle("-fx-background-color: lightgreen;");

        Label contact = new Label("Contact US");
        contact.setFont(Font.font("Roboto-Regular", FontWeight.BOLD, 50));
        contact.setTextFill(Color.WHITE);
        
        HBox navPanel = CamilaByRestaurant.createNavigationPanel(primaryStage);

        Label nameLabel = new Label("Your Name (required)");
        nameLabel.setFont(Font.font("Roboto-Regular", FontWeight.BOLD, 20));
        nameLabel.setTextFill(Color.WHITE);

        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");
        nameField.setMaxWidth(300);
        nameField.setStyle("-fx-font-family: 'Roboto-Regular'; -fx-font-size: 16px; -fx-text-fill: black; -fx-background-color: white; -fx-padding: 10px;");

        Label emailLabel = new Label("Your Email (required)");
        emailLabel.setFont(Font.font("Roboto-Regular", FontWeight.BOLD, 20));
        emailLabel.setTextFill(Color.WHITE);

        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");
        emailField.setMaxWidth(300);
        emailField.setStyle("-fx-font-family: 'Roboto-Regular'; -fx-font-size: 16px; -fx-text-fill: black; -fx-background-color: white; -fx-padding: 10px;");

        Label recommend = new Label("How likely are you recommend us to a friend? ");
        recommend.setStyle("-fx-font-size: 20px; -fx-text-fill: white; -fx-font-family: 'Roboto-Regular'; -fx-font-weight: bold;");
        RadioButton[] buttons = new RadioButton[11];
        ToggleGroup group = new ToggleGroup();
        for (int i = 0; i <= 10; i++) {
            final int select = i;
            buttons[i] = new RadioButton(String.valueOf(i));
            buttons[i].setStyle("-fx-font-size: 14; -fx-background-color: white; -fx-border-color: #000000;");
            buttons[i].setToggleGroup(group);

            buttons[i].selectedProperty().addListener((observable, wasPreviouslySelected, isNowSelected) -> {
                if (isNowSelected) {
                    RadioButton selectedButton = (RadioButton) group.getSelectedToggle();
                    rating = selectedButton.getText();
                    buttons[select].setStyle("-fx-font-size: 14; -fx-background-color: green; -fx-border-color: #000000;");
                } else {
                    buttons[select].setStyle("-fx-font-size: 14; -fx-background-color: white; -fx-border-color: #000000;");
                }
            });
        }

        HBox ratePanel = new HBox();
        ratePanel.setAlignment(Pos.CENTER);
        ratePanel.getChildren().add(recommend);
        for (int i = 0; i <= 10; i++) {
        ratePanel.getChildren().add(buttons[i]);
    }

        Label feedbackLabel = new Label("Your Feedback (required)");
        feedbackLabel.setFont(Font.font("Roboto-Regular", FontWeight.BOLD, 20));
        feedbackLabel.setTextFill(Color.WHITE);

        TextArea feedbackArea = new TextArea();
        feedbackArea.setPromptText("Enter your feedback here");
        feedbackArea.setMaxWidth(300);
        feedbackArea.setMaxHeight(200);
        feedbackArea.setStyle("-fx-font-family: 'Roboto-Regular'; -fx-font-size: 16px; -fx-text-fill: black; -fx-background-color: white; -fx-padding: 10px;");

        Button submitButton = new Button("Submit Feedback");
        submitButton.setStyle("-fx-font-family: 'Roboto-Regular'; -fx-font-size: 18px; -fx-text-fill: white; -fx-background-color: #4CAF50; -fx-padding: 10px;");
        submitButton.setOnAction(event -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String feedback = feedbackArea.getText();
            if (name.isEmpty() || email.isEmpty() || feedback.isEmpty()) {
                showAlert("Please enter your name/email and feedback.");
            } else {
                saveFeedback(name, email, feedback, rating);
            }
        });

        Label hoursLabel = new Label("Working Hours: 9:00 AM - 10:00 PM");
        hoursLabel.setFont(Font.font("Roboto-Regular", FontWeight.BOLD, 20));
        hoursLabel.setTextFill(Color.WHITE);

        Label phoneLabel = new Label("Contact Number: +1234567890");
        phoneLabel.setFont(Font.font("Roboto-Regular", FontWeight.BOLD, 20));
        phoneLabel.setTextFill(Color.WHITE);

        VBox feedbackBox = new VBox();
        feedbackBox.getChildren().addAll(nameLabel, nameField, emailLabel, emailField, ratePanel, feedbackLabel, feedbackArea, submitButton, hoursLabel, phoneLabel);
        feedbackBox.setAlignment(Pos.CENTER);
        feedbackBox.setSpacing(10);

        VBox contactBox = new VBox();
        contactBox.getChildren().addAll(navPanel, contact, feedbackBox);
        contactBox.setAlignment(Pos.CENTER);
        contactBox.setSpacing(20);

        this.setTop(contactBox);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void saveFeedback(String name, String email, String feedback, String rating) {
        try {
            FileWriter writer = new FileWriter("feedback.txt", true);
            writer.write("\n Name: " + name + "\n Email: " + email + "\n Feedback: " + feedback + "\n" + "Rating: " + rating);
            writer.close();
            showAlert("Feedback successfully submitted.");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Failed to save feedback.");
        }
    }
}
