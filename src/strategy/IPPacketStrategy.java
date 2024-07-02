package strategy;

import exceptions.NetException;
import frame.component.SelectionComboBoxComponent;
import header.IPHeader;
import org.jnetpcap.Pcap;
import org.jnetpcap.PcapBpfProgram;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.protocol.lan.Ethernet;
import org.jnetpcap.protocol.network.Ip4;
import org.jnetpcap.protocol.network.Ip6;
import org.jnetpcap.protocol.tcpip.Http;
import org.jnetpcap.protocol.tcpip.Tcp;
import org.jnetpcap.protocol.tcpip.Udp;
import packet.Packet;
import thread.ThreadPool;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class IPPacketStrategy extends PacketStrategy {

    public void processPacket(JTextArea outPutArea, Packet packetToUse, PcapPacket packet,int packetOrder){
        Ip4 ip4 = new Ip4();
        if (packet.hasHeader(ip4)) {
            getElement(packetToUse,ip4);
            SwingUtilities.invokeLater(() -> {
                outPutArea.append("第"+packetOrder+"个包:(由于是多线程抓包,因此该顺序为乱序)\n"+packetToUse.getBaseHeader()+"负载数据:"+
                        packetToUse.getPayloadData()+"\n----------------------------------------\n");
            });
        }
    }

    private void getElement(Packet packetToUse,Ip4 ip4){
        int version = ip4.version();
        int headerLength =  ip4.getHeaderLength();
        int typeOfService =  ip4.tos();
        int totalLength = (ip4.getPayloadLength()+ip4.getHeaderLength());
        int identification = ip4.id();
        int flagsAndFragmentOffset =  ip4.flags();
        int timeToLive = ip4.ttl();
        int protocol = ip4.type();
        int headerChecksum = ip4.checksum();
        int sourceIP = ip4.sourceToInt();
        int destinationIP = ip4.destinationToInt();
        IPHeader ipHeader = (IPHeader) packetToUse.getBaseHeader();
        ipHeader.setElement(version,headerLength,typeOfService,totalLength,identification,
                flagsAndFragmentOffset,timeToLive,protocol,headerChecksum,sourceIP,destinationIP);
        byte[] payload = ip4.getPayload();
        String hexPayload = bytesToHex(payload);

        packetToUse.setPayloadData(hexPayload);
    }


}
