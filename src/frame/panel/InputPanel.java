package frame.panel;

import enums.Choose;
import frame.component.ButtonComponent;
import frame.component.LabelComponent;
import frame.component.SelectionComboBoxComponent;
import frame.component.TextFieldComponent;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel{
    private LabelComponent interfaceLabel;
    private LabelComponent ipLabel;
    private LabelComponent interfaceChooseLabel;

    private TextFieldComponent interfaceTextField;
    private TextFieldComponent ipTextField;

    private SelectionComboBoxComponent selectionComboBoxComponent;

    private CheckBoxPanel checkBoxPanel;

    private ButtonPanel buttonPanel;

    private LabelComponent captureNumLabel;
    private TextFieldComponent captureNumTextField;

    private ButtonComponent buttonStart;

    public InputPanel(){
        //第0行
        interfaceLabel=new LabelComponent("网络接口:",0,0,1,1);
        interfaceTextField=new TextFieldComponent(30,1,0,1,1);
        interfaceChooseLabel=new LabelComponent("本地网络接口选择:",2,0,1,1);
        selectionComboBoxComponent = new SelectionComboBoxComponent(3,0,1,1);
        selectionComboBoxComponent.setActionListener(interfaceTextField);

        //第1行
        ipLabel=new LabelComponent("目标IP地址:",0,1,1,1);
        ipTextField=new TextFieldComponent(30,1,1,1,1);
        ipLabel.getLabel().setVisible(false);
        ipTextField.getTextFieldComponent().setVisible(false);

        //第2行
        checkBoxPanel=new CheckBoxPanel("是否指定IP",2,2,1,1);
        checkBoxPanel.setActionListener(ipLabel,ipTextField);

        //第3行
        buttonPanel=new ButtonPanel("选择解析模式:","IP","TCP",3,3,1,1);

        //第4行
        captureNumLabel=new LabelComponent("抓包数目:",0,4,1,1);
        captureNumTextField=new TextFieldComponent(30,1,4,1,1);

        //第5行
        buttonStart=new ButtonComponent("点击开始抓包",2,5,1,1);
        this.Init();
    }

    public void Init(){
        this.setLayout(new GridBagLayout());
        this.add(interfaceLabel.getLabel(),interfaceLabel.getConstraints());
        this.add(interfaceTextField.getTextFieldComponent(),interfaceTextField.getConstraints());
        this.add(ipLabel.getLabel(),ipLabel.getConstraints());
        this.add(ipTextField.getTextFieldComponent(),ipTextField.getConstraints());
        this.add(interfaceChooseLabel.getLabel(),interfaceChooseLabel.getConstraints());
        this.add(selectionComboBoxComponent.getSelectionComboBoxComponent(),selectionComboBoxComponent.getConstraints());
        this.add(checkBoxPanel,checkBoxPanel.getConstraints());
        this.add(buttonPanel,buttonPanel.getConstraints());
        this.add(buttonStart.getButtonComponent(),buttonStart.getConstraints());
        this.add(captureNumLabel.getLabel(),captureNumLabel.getConstraints());
        this.add(captureNumTextField.getTextFieldComponent(),captureNumTextField.getConstraints());
    }

    public ButtonComponent getButtonStart(){
        return buttonStart;
    }

    public ButtonPanel getButtonPanel(){
        return buttonPanel;
    }

    public TextFieldComponent getInterfaceTextField(){
        return this.interfaceTextField;
    }

    public TextFieldComponent getIpTextField(){
        return this.ipTextField;
    }

    public SelectionComboBoxComponent getSelectionComboBoxComponent(){
        return this.selectionComboBoxComponent;
    }

    public TextFieldComponent getCaptureNumTextField(){return this.captureNumTextField;}

}
