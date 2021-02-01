package sample;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
    @FXML
    private Label output;
    @FXML
    private TextField formula;
    @FXML
    private CheckBox decChecker;

    @FXML
    public void getExpression(KeyEvent enterpress){
        if(enterpress.getCode().equals(KeyCode.ENTER)){
            String x= formula.getText();
            Boolean dec = ExtraFuncs.showDecimal(decChecker);

            try{
            if(x.indexOf('+')!=-1){
                double n1 = Double.parseDouble(x.split("\\+")[0]);
                double n2 = Double.parseDouble(x.split("\\+")[1]);
                if(dec) output.setText(""+(n1+n2));
                else output.setText(""+(int)(n1+n2));
            }
            else if(x.indexOf('-')!=-1){
                double n1 = Double.parseDouble(x.split("-")[0]);
                double n2 = Double.parseDouble(x.split("-")[1]);
                if(dec) output.setText(""+(n1-n2));
                else output.setText(""+(int)(n1-n2));
            }
            else if(x.indexOf('*')!=-1){
                double n1 = Double.parseDouble(x.split("\\*")[0]);
                double n2 = Double.parseDouble(x.split("\\*")[1]);
                if(dec) output.setText(""+(n1*n2));
                else output.setText(""+(int)(n1*n2));
            }
            else if(x.indexOf('/')!=-1){
                double n1 = Double.parseDouble(x.split("/")[0]);
                double n2 = Double.parseDouble(x.split("/")[1]);
                if(n2==0) output.setText("Cannot divide by zero!");
                if(dec) output.setText(""+(n1/n2));
                else output.setText(""+(int)(n1/n2));
            }
            }
            catch (NumberFormatException nfe){
                output.setText("Enter expression in shown format!");
            }
        }
    }

    @FXML
    public void reuse(){
        try {
            Boolean dec = ExtraFuncs.showDecimal(decChecker);
            double num = Double.parseDouble(output.getText());
            if(dec)
            formula.setText(""+num);
            else formula.setText(""+(int)num);
        }
        catch (NumberFormatException nfe){
            output.setText("Nothing to copy!");
        }
        finally {
            formula.requestFocus();
        }
    }
}
