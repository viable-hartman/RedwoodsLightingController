package edu.redwoods.cis18.views;

import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import java.util.ResourceBundle;

import com.gluonhq.connect.GluonObservableObject;
import com.gluonhq.connect.converter.InputStreamInputConverter;
import com.gluonhq.connect.provider.DataProvider;
import com.gluonhq.connect.provider.RestClient;
import edu.redwoods.cis18.models.Device;
import edu.redwoods.cis18.util.SingleItemInputConverter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DevicesPresenter {

    @FXML
    private View devices;

    @FXML
    private Label label;

    @FXML
    private ResourceBundle resources;
    
    public void initialize() {
        devices.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppManager appManager = AppManager.getInstance();
                AppBar appBar = appManager.getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e ->
                        appManager.getDrawer().open()));
                appBar.setTitleText("Devices");
                appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> 
                        System.out.println("Search")));
            }
        });
    }
    
    @FXML
    void btnRainbowClick() {
        // create a RestClient to the specific URL
        RestClient rc = RestClient.create().method("GET").host("http://127.0.0.1:8080").path("/device/rainbow");
        // create a custom Converter that is able to parse the response into a single object
        InputStreamInputConverter<Device> converter = new SingleItemInputConverter<>(Device.class);
        // retrieve an object from the DataProvider
        GluonObservableObject<Device> device = DataProvider.retrieveObject(rc.createObjectDataReader(converter));
        // when the object is initialized, bind its properties to the JavaFX UI controls
        device.initializedProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                label.setText(device.get().toString());
                //label.textProperty().bind(device.get().deviceNameProperty());
            }
        });
    }
    
}
