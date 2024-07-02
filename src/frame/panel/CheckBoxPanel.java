package frame.panel;

import frame.component.CheckBoxComponent;
import frame.component.LabelComponent;
import frame.component.TextFieldComponent;

import javax.swing.*;
import java.awt.*;

public class CheckBoxPanel extends JPanel{

    private CheckBoxComponent iPCheckedBox;

    private GridBagConstraints constraints;


    public CheckBoxPanel(String words,int gridx,int gridy,int gridwidth,int gridheight){
        iPCheckedBox = new CheckBoxComponent(words,0,0,0,0);
        constraints=new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL; // 设置组件水平填充
        constraints.insets = new Insets(5, 5, 5, 5); // 设置组件之间的间距
        constraints.gridx=gridx;
        constraints.gridy=gridy;
        constraints.gridheight=gridheight;
        constraints.gridwidth=gridwidth;
        this.Init();
    }

    public void Init(){
        this.add(iPCheckedBox.getCheckBoxComponent(),iPCheckedBox.getConstraints());
    }

    public GridBagConstraints getConstraints(){
        return constraints;
    }


    public CheckBoxComponent getIPCheckedBox() {
        return iPCheckedBox;
    }

    public void setIPCheckedBox(CheckBoxComponent iPCheckedBox) {
        this.iPCheckedBox = iPCheckedBox;
    }

    public String toString() {
        return "CheckBoxPanel{iPCheckedBox = " + iPCheckedBox + "}";
    }

    public void setActionListener(LabelComponent ipLabel, TextFieldComponent ipTextField) {
        iPCheckedBox.getCheckBoxComponent().addActionListener(e -> {
            boolean selected = iPCheckedBox.getCheckBoxComponent().isSelected();
            ipLabel.getLabel().setVisible(selected);
            ipTextField.getTextFieldComponent().setVisible(selected);
            if(selected==false){
                ipTextField.getTextFieldComponent().setText("");
            }
        });
    }
}
