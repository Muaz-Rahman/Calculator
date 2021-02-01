package sample;

import javafx.scene.control.CheckBox;

public abstract class ExtraFuncs {

    public static Boolean showDecimal(CheckBox x){
        if(x.isSelected()){
            return true;
        }
        else return false;
    }

}
