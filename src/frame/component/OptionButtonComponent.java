package frame.component;

import javax.swing.*;
import java.awt.*;

public class OptionButtonComponent  {
    private JRadioButton optionButtonComponent;

    private GridBagConstraints constraints;


    public OptionButtonComponent(String words,int gridx,int gridy,int gridwidth,int gridheight) {
        constraints=new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL; // 设置组件水平填充
        constraints.insets = new Insets(5, 5, 5, 5); // 设置组件之间的间距
        constraints.gridx=gridx;
        constraints.gridy=gridy;
        constraints.gridheight=gridheight;
        constraints.gridwidth=gridwidth;
        optionButtonComponent=new JRadioButton(words);
    }

    public OptionButtonComponent(JRadioButton optionButtonComponent) {
        this.optionButtonComponent = optionButtonComponent;
    }


    public JRadioButton getOptionButtonComponent() {
        return optionButtonComponent;
    }

    public GridBagConstraints getConstraints(){
        return constraints;
    }


    public void setOptionButtonComponent(JRadioButton optionButtonComponent) {
        this.optionButtonComponent = optionButtonComponent;
    }

    public String toString() {
        return "OptionButtonComponent{optionButtonComponent = " + optionButtonComponent + "}";
    }
}
