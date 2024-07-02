package frame.component;


import exceptions.NetException;
import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SelectionComboBoxComponent  {
    private JComboBox<String> selectionComboBoxComponent;

    private GridBagConstraints constraints;

    public SelectionComboBoxComponent(int gridx,int gridy,int gridwidth,int gridheight) {
        constraints=new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL; // 设置组件水平填充
        constraints.insets = new Insets(5, 5, 5, 5); // 设置组件之间的间距
        constraints.gridx=gridx;
        constraints.gridy=gridy;
        constraints.gridheight=gridheight;
        constraints.gridwidth=gridwidth;
        selectionComboBoxComponent=new JComboBox<>();
        try {
            netInit();
        } catch (NetException e) {
            e.printStackTrace();
        }

    }

    public void netInit() throws NetException{
        StringBuilder errBuf = new StringBuilder();
        List<PcapIf> allDevs = new ArrayList<PcapIf>(); // Will be filled with
        int r = Pcap.findAllDevs(allDevs, errBuf);
        if (r == Pcap.NOT_OK || allDevs.isEmpty()) {
            throw new NetException("Can't read list of devices, error is %s"+ errBuf);
        }
        // 迭代找到的所有网卡
        int i = 0;
        for (PcapIf device : allDevs) {
            String description = (device.getDescription() != null) ? device
                    .getDescription() : "No description available";
            System.out.printf("#%d: %s [%s]\n", i++, device.getName(),
                    description);
            selectionComboBoxComponent.addItem(device.getName());
        }
    }

    public void setActionListener(TextFieldComponent textFieldComponent){
        selectionComboBoxComponent.addActionListener(e -> {
            String selectedOption = (String) selectionComboBoxComponent.getSelectedItem();
            textFieldComponent.getTextFieldComponent().setText(selectedOption); // 将选中的选项赋值给文本框
        });
    }

    public SelectionComboBoxComponent(JComboBox<String> selectionComboBoxComponent) {
        this.selectionComboBoxComponent = selectionComboBoxComponent;
    }

    public JComboBox<String> getSelectionComboBoxComponent() {
        return selectionComboBoxComponent;
    }

    public GridBagConstraints getConstraints(){
        return constraints;
    }


    public void setSelectionComboBoxComponent(JComboBox<String> selectionComboBoxComponent) {
        this.selectionComboBoxComponent = selectionComboBoxComponent;
    }

    public String toString() {
        return "SelectionComboBoxComponent{selectionComboBoxComponent = " + selectionComboBoxComponent + "}";
    }
}
