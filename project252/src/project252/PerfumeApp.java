/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project252;import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PerfumeApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // إعداد التكوين
        ConfigManager config = ConfigManager.getInstance();
        String currency = config.getConfig("currency");
        String region = config.getConfig("region");

        // واجهة التطبيق
        VBox mainLayout = new VBox(10);
        mainLayout.setStyle("-fx-background-color: orange; -fx-padding: 20;");

        Label currencyLabel = new Label("Currency: " + currency);
        Label regionLabel = new Label("Region: " + region);
        Label welcomeLabel = new Label("Welcome to the Perfume Shop!");

        Button viewProductButton = new Button("View Chanel No. 5");
        viewProductButton.setOnAction(e -> showProductDetails(primaryStage));

        mainLayout.getChildren().addAll(welcomeLabel, currencyLabel, regionLabel, viewProductButton);
        Scene mainScene = new Scene(mainLayout, 300, 250);
        
        primaryStage.setTitle("Perfume Shop");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    private void showProductDetails(Stage parentStage) {
        // إنشاء منتج جديد
        Product chanelNo5 = ProductFactory.createProduct("chanel");

        // واجهة تفاصيل المنتج
        VBox detailsLayout = new VBox(10);
        detailsLayout.setStyle("-fx-background-color: orange; -fx-padding: 20;");

        Label productNameLabel = new Label("Product: " + chanelNo5.getName());
        Label productPriceLabel = new Label("Price: " + chanelNo5.getPrice());
        Label productDescriptionLabel = new Label("Description: " + chanelNo5.getDescription());
        
        // زر إضافة إلى السلة
        Button addToCartButton = new Button("Add to Cart");
        addToCartButton.setOnAction(e -> {
            // هنا يمكنك إضافة منطق إضافة المنتج إلى السلة
            System.out.println(chanelNo5.getName() + " added to cart.");
        });

        detailsLayout.getChildren().addAll(productNameLabel, productPriceLabel, productDescriptionLabel, addToCartButton);
        Scene detailsScene = new Scene(detailsLayout, 300, 250);
        
        // الانتقال إلى واجهة تفاصيل المنتج
        parentStage.setScene(detailsScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
