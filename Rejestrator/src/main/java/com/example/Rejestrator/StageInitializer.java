package com.example.Rejestrator;

import com.example.Rejestrator.controllers.MenuController;
import com.google.common.eventbus.EventBus;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StageInitializer implements ApplicationListener<ChartApplication.StageReadyEvent> {

    @Value("classpath:/fxml/menu.fxml")
        private Resource chartResource;




        @Override
        public void onApplicationEvent(ChartApplication.StageReadyEvent event) {
            try {
                FXMLLoader loader = new FXMLLoader(chartResource.getURL());
                Parent parent=loader.load();
                Stage stage = event.getStage();
                stage.setScene(new Scene(parent));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

