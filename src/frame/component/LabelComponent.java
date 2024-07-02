package frame.component;

import javax.swing.*;
import java.awt.*;

public class LabelComponent  {
    private JLabel labelComponent;

    private GridBagConstraints constraints;

    public LabelComponent() {
    }

    public LabelComponent(String words,int gridx,int gridy,int gridwidth,int gridheight) {
        constraints=new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL; // 设置组件水平填充
        constraints.insets = new Insets(5, 5, 5, 5); // 设置组件之间的间距
        constraints.gridx=gridx;
        constraints.gridy=gridy;
        constraints.gridheight=gridheight;
        constraints.gridwidth=gridwidth;
        labelComponent=new JLabel(words);
    }

    public LabelComponent(JLabel labelComponent) {
        this.labelComponent = labelComponent;
    }


    public JLabel getLabel() {
        return labelComponent;
    }

    public GridBagConstraints getConstraints(){
        return constraints;
    }


    public void setLabel(JLabel labelComponent) {
        this.labelComponent = labelComponent;
    }

    public String toString() {
        return "LabelComponent{interfaceLabel = " + labelComponent + "}";
    }
}
