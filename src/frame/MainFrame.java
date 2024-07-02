package frame;

import frame.panel.MainPanel;

import javax.swing.*;

public class MainFrame extends JFrame {

    private MainPanel mainPanel;

    public MainFrame(){
        this.setTitle("网络抓包程序");
        this.setSize(1000, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel=new MainPanel();
        this.add(mainPanel);
    }

}
