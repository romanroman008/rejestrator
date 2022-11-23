package com.example.Rejestrator;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

public class ChartApplication extends Application {
    public static ConfigurableApplicationContext applicationContext;

   @Override
   public void init(){
       applicationContext=new SpringApplicationBuilder(RejestratorApplication.class).run();
   }

    @Override
    public void start(Stage stage) throws Exception {
        applicationContext.publishEvent(new StageReadyEvent(stage));
    }
    @Override
    public void stop(){
       applicationContext.close();
        Platform.exit();
    }

    static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }
        public Stage getStage(){
            return (Stage) getSource();
        }
    }

    public static ConfigurableApplicationContext getCtx(){
       return applicationContext;
    }

}
