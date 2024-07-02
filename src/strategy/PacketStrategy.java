package strategy;

import exceptions.NetException;
import frame.component.SelectionComboBoxComponent;
import org.jnetpcap.Pcap;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.protocol.network.Ip4;
import org.jnetpcap.protocol.tcpip.Tcp;
import packet.Packet;
import thread.ThreadPool;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class PacketStrategy {

    private volatile AtomicInteger capturedCount;

    abstract void processPacket(JTextArea outPutArea, Packet packetToUse, PcapPacket packet,int packetOrder);

    public Packet capture(JTextArea outPutArea, Packet packetToUse, int captureNum, Pcap pcap){
        capturedCount=new AtomicInteger(captureNum);
        new Thread(() -> {
            PcapPacketHandler<String> packetHandler = new PcapPacketHandler<String>() {
                @Override
                public void nextPacket(PcapPacket packet, String user) {
                    int packetSum = capturedCount.decrementAndGet();
                    ThreadPool.execute(()->processPacket(outPutArea,packetToUse,packet,captureNum-packetSum));
                    if(packetSum==0){
                        pcap.breakloop();
                    }
                }
            };
            pcap.loop(Pcap.LOOP_INFINITE,packetHandler, "start capturing!!!");
            pcap.close();
        }).start();
        return null;
    }

    protected String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < bytes.length; i++){
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
            if (i < bytes.length - 1) {
                hexString.append(' ');
            }
        }
        return hexString.toString();
    }

}
