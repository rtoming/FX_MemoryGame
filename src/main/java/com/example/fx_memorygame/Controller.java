package com.example.fx_memorygame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    List<ImgInfoObject> myList;
    int turns=0;
    int firstOpenedIndex=0;
    int solved=0;
    boolean success;
    ImageView firstOpened, secondOpened;
    Image clickMe;
    Long startTime;



    @FXML
    public void click(MouseEvent e){
    turns++;
        ImageView tempImgV = (ImageView) e.getSource();
        String id = tempImgV.getId();
        int index = Integer.valueOf(id);

    if(turns%2 != 0){
        if( (!success) && (turns!=1) ){
            firstOpened.setImage(clickMe);
            secondOpened.setImage(clickMe);
        }
        else{
            success=false;
        }
        firstOpened = tempImgV;
        firstOpenedIndex = index;

    }
    else{
        secondOpened = tempImgV;

        ImgInfoObject obj2 = myList.get(index);
        String name2 = obj2.getImgName();

        ImgInfoObject obj1 = myList.get(firstOpenedIndex);
        String name1 = obj1.getImgName();

        if(name1.equals(name2)){
            success=true;
            solved=solved + 2;
        }

    }


    ImgInfoObject obj = myList.get(index);
    Image image = obj.getImg();
    tempImgV.setImage(image);

        if(solved==16){
            long timeTaken = System.currentTimeMillis()-startTime;
            int t = (int)(timeTaken/1000);
           Celebration(t);
        }
}

    private void Celebration(int t) {
        AlertBox.display("VICTORY", "Turns: " + turns + "\nTime: " + t);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    clickMe = new Image(getClass().getResourceAsStream("/img/big_red_button.jpg"));
    myList = new ArrayList<>();
    ImgInfoObject obj;


        obj = new ImgInfoObject("capt", new Image(getClass().getResourceAsStream("/img/capt.png")));
        myList.add(obj);
        myList.add(obj);
        obj = new ImgInfoObject("bat", new Image(getClass().getResourceAsStream("/img/bat.png") ));
        myList.add(obj);
        myList.add(obj);
        obj = new ImgInfoObject("flash", new Image(getClass().getResourceAsStream("/img/flash.png") ));
        myList.add(obj);
        myList.add(obj);
        obj = new ImgInfoObject("hulk", new Image(getClass().getResourceAsStream("/img/hulk.png") ));
        myList.add(obj);
        myList.add(obj);
        obj = new ImgInfoObject("iron", new Image(getClass().getResourceAsStream("/img/iron.jpeg") ));
        myList.add(obj);
        myList.add(obj);
        obj = new ImgInfoObject("super", new Image(getClass().getResourceAsStream("/img/super.png") ));
        myList.add(obj);
        myList.add(obj);
        obj = new ImgInfoObject("thor", new Image(getClass().getResourceAsStream("/img/thor.jpeg") ));
        myList.add(obj);
        myList.add(obj);
        obj = new ImgInfoObject("wolf", new Image(getClass().getResourceAsStream("/img/wolf.png") ));
        myList.add(obj);
        myList.add(obj);

        myList.forEach(img -> System.out.println(img.getImgName()));
        System.out.println(".....all images added....");

       Random rnd = new Random();
        for (int i = 0; i < 10 ; i++){
            int x = rnd.nextInt(16);
            int y = rnd.nextInt(16);
            ImgInfoObject tempObjX = myList.get(x); //pick up x
            ImgInfoObject tempObjY = myList.get(y); //pick up y

            System.out.println("swapping index " + x +" with index " + y);
            myList.set(x,tempObjY); //set, ehk mix
            myList.set(y,tempObjX); //set, ehk mix
        }

        System.out.println("=======Mixed List========");
        myList.forEach(o -> System.out.println(o.getImgName()));

    startTime = System.currentTimeMillis();
    }

}


