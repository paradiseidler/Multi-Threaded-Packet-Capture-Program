package frame.component;


import enums.Choose;
import exceptions.NetException;
import factory.PacketFactory;
import frame.panel.ButtonPanel;
import header.IPHeader;
import header.TCPHeader;
import networkInterface.NetworkInterface;
import packet.Packet;
import strategy.IPPacketStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonComponent {
    private JButton buttonComponent;

    private GridBagConstraints constraints;


    public ButtonComponent(String words,int gridx,int gridy,int gridwidth,int gridheight) {
        constraints=new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL; // 设置组件水平填充
        constraints.insets = new Insets(5, 5, 5, 5); // 设置组件之间的间距
        constraints.gridx=gridx;
        constraints.gridy=gridy;
        constraints.gridheight=gridheight;
        constraints.gridwidth=gridwidth;
        buttonComponent=new JButton(words);
    }

    public ButtonComponent() {}

    public GridBagConstraints getConstraints(){
        return constraints;
    }

    public JButton getButtonComponent() {
        return buttonComponent;
    }


    public void setButtonComponent(JButton buttonComponent) {
        this.buttonComponent = buttonComponent;
    }

    public String toString() {
        return "ButtonComponent{buttonComponent = " + buttonComponent + "}";
    }

    public void setStartActionListener(JTextArea outPutArea, ButtonPanel buttonPanel,
                                  TextFieldComponent interfaceTextField,TextFieldComponent ipTextField,
                                       SelectionComboBoxComponent selectionComboBoxComponent,TextFieldComponent captureNumTextField) {

        buttonComponent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 Packet packet=null;
                 Choose buttonSelected=buttonPanel.getIPButton().getOptionButtonComponent().isSelected()==true?Choose.IP:Choose.TCP;
                 if(buttonSelected==Choose.IP){
                     packet = PacketFactory.createPacket(new IPHeader(),
                             new NetworkInterface(interfaceTextField.getTextFieldComponent().getText(),
                                     ipTextField.getTextFieldComponent().getText()));
                 }else{
                     packet = PacketFactory.createPacket(new TCPHeader(),
                             new NetworkInterface(interfaceTextField.getTextFieldComponent().getText(),
                                     ipTextField.getTextFieldComponent().getText()));
                 }
                try {
                    packet.capture(outPutArea,captureNumTextField.getTextFieldComponent().getText());
                } catch (NetException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

}
