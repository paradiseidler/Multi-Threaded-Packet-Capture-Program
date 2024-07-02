package frame.component;

import javax.swing.*;
import java.awt.*;

public class TextFieldComponent  {
    private JTextField textFieldComponent;

    private GridBagConstraints constraints;


    public TextFieldComponent(int length,int gridx,int gridy,int gridwidth,int gridheight) {
        constraints=new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL; // 设置组件水平填充
        constraints.insets = new Insets(5, 5, 5, 5); // 设置组件之间的间距
        constraints.gridx=gridx;
        constraints.gridy=gridy;
        constraints.gridheight=gridheight;
        constraints.gridwidth=gridwidth;
        textFieldComponent=new JTextField(length);
    }

    public TextFieldComponent(JTextField textFieldComponent) {
        this.textFieldComponent = textFieldComponent;
    }


    public JTextField getTextFieldComponent() {
        return textFieldComponent;
    }

    public GridBagConstraints getConstraints(){
        return constraints;
    }


    public void setTextFieldComponent(JTextField textFieldComponent) {
        this.textFieldComponent = textFieldComponent;
    }

    public String toString() {
        return "TextFieldComponent{textFieldComponent = " + textFieldComponent + "}";
    }
}
