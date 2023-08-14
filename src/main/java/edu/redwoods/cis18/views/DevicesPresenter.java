package edu.redwoods.cis18.views;

import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import java.util.ResourceBundle;
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
    void buttonClick() {
        label.setText(resources.getString("label.text.2"));
    }
    
}
