package frame.component;

import javax.swing.*;
import java.awt.*;

public class CheckBoxComponent  {
    private JCheckBox checkBoxComponent;

    private GridBagConstraints constraints;

    public CheckBoxComponent(String words,int gridx,int gridy,int gridwidth,int gridheight) {
        constraints=new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL; // 设置组件水平填充
        constraints.insets = new Insets(5, 5, 5, 5); // 设置组件之间的间距
        constraints.gridx=gridx;
        constraints.gridy=gridy;
        constraints.gridheight=gridheight;
        constraints.gridwidth=gridwidth;
        checkBoxComponent=new JCheckBox(words);
    }

    public CheckBoxComponent(JCheckBox checkBoxComponent) {
        this.checkBoxComponent = checkBoxComponent;
    }

    public JCheckBox getCheckBoxComponent() {
        return checkBoxComponent;
    }

    public GridBagConstraints getConstraints(){
        return constraints;
    }

    public void setCheckBoxComponent(JCheckBox checkBoxComponent) {
        this.checkBoxComponent = checkBoxComponent;
    }

    public String toString() {
        return "CheckBoxComponent{checkBoxComponent = " + checkBoxComponent + "}";
    }
}
