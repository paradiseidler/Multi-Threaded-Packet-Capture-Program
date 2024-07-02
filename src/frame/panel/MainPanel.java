package frame.panel;

import packet.Packet;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private InputPanel inputPanel;

    private JTextArea  outPutArea;

    private JScrollPane scrollPane;

    public MainPanel(){
        this.inputPanel=new InputPanel();
        this.outPutArea=new JTextArea();
        this.scrollPane=new JScrollPane(outPutArea);
        this.Init();
    }

    public void Init(){
        this.setLayout(new BorderLayout());
        this.add(inputPanel,BorderLayout.NORTH);
        inputPanel.getButtonStart().setStartActionListener(outPutArea,inputPanel.getButtonPanel(),
                inputPanel.getInterfaceTextField(),inputPanel.getIpTextField(),inputPanel.getSelectionComboBoxComponent(),
                inputPanel.getCaptureNumTextField());
        this.add(scrollPane);
    }

}
