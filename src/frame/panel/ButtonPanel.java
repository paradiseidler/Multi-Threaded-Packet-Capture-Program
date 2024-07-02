package frame.panel;

import frame.component.LabelComponent;
import frame.component.OptionButtonComponent;
import frame.component.TextFieldComponent;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel{
    private LabelComponent        modelChooseLabel;

    private ButtonGroup           buttonGroup;

    private OptionButtonComponent IPButton;

    private OptionButtonComponent TCPButton;

    private GridBagConstraints    constraints;


    public ButtonPanel(String words,String buttonOne,String buttonSecond,int gridx,int gridy,int gridwidth,int gridheight){
        constraints=new GridBagConstraints();
        buttonGroup=new ButtonGroup();
        constraints.fill = GridBagConstraints.HORIZONTAL; // 设置组件水平填充
        constraints.insets = new Insets(5, 5, 5, 5); // 设置组件之间的间距
        constraints.gridx=gridx;
        constraints.gridy=gridy;
        constraints.gridheight=gridheight;
        constraints.gridwidth=gridwidth;
        modelChooseLabel=new LabelComponent(words,1,3,1,1);
        IPButton=new OptionButtonComponent(buttonOne,2,3,1,1);
        TCPButton=new OptionButtonComponent(buttonSecond,3,3,1,1);

        buttonGroup.add(IPButton.getOptionButtonComponent());
        buttonGroup.add(TCPButton.getOptionButtonComponent());
        this.Init();
    }

    public void Init(){
        this.setLayout(new GridBagLayout());
        this.add(modelChooseLabel.getLabel(),modelChooseLabel.getConstraints());
        this.add(IPButton.getOptionButtonComponent(),IPButton.getConstraints());
        this.add(TCPButton.getOptionButtonComponent(),TCPButton.getConstraints());
    }

    public GridBagConstraints getConstraints(){
        return constraints;
    }

    public LabelComponent getModelChooseLabel() {
        return modelChooseLabel;
    }

    public void setModelChooseLabel(LabelComponent modelChooseLabel) {
        this.modelChooseLabel = modelChooseLabel;
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }

    public OptionButtonComponent getIPButton() {
        return IPButton;
    }

    public void setIPButton(OptionButtonComponent IPButton) {
        this.IPButton = IPButton;
    }

    public OptionButtonComponent getTCPButton() {
        return TCPButton;
    }

    public void setTCPButton(OptionButtonComponent TCPButton) {
        this.TCPButton = TCPButton;
    }

    public String toString() {
        return "ButtonPanel{modelChooseLabel = " + modelChooseLabel + ", buttonGroup = " + buttonGroup + ", IPButton = " + IPButton + ", TCPButton = " + TCPButton + "}";
    }

}
