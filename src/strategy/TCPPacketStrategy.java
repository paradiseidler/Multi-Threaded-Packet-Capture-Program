package strategy;

import exceptions.NetException;
import header.TCPHeader;
import org.jnetpcap.Pcap;
import org.jnetpcap.PcapBpfProgram;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.protocol.network.Ip4;
import org.jnetpcap.protocol.tcpip.Tcp;
import packet.Packet;
import thread.ThreadPool;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TCPPacketStrategy extends PacketStrategy{

    public void processPacket(JTextArea outPutArea, Packet packetToUse, PcapPacket packet,int packetOrder){
        Tcp tcp=new Tcp();
        if (packet.hasHeader(tcp)) {
            getElement(packetToUse,tcp);
            SwingUtilities.invokeLater(() -> {
                outPutArea.append("第"+packetOrder+"个包:(由于是多线程抓包,因此该顺序为乱序)\n"+packetToUse.getBaseHeader()+"负载数据:"+
                        packetToUse.getPayloadData()+"\n----------------------------------------\n");
            });
        }
    }


    private void getElement(Packet packetToUse,Tcp tcp){
        int sourcePort = tcp.source();
        int destinationPort = tcp.destination();
        long sequenceNumber =  tcp.seq();
        long acknowledgmentNumber = tcp.ack();
        int dataOffsetAndFlags =  tcp.flags();
        int windowSize = tcp.window();
        int checksum =  tcp.checksum();
        int urgentPointer =  tcp.urgent();
        TCPHeader ipHeader = (TCPHeader) packetToUse.getBaseHeader();
        ipHeader.setElement(sourcePort,destinationPort,sequenceNumber,acknowledgmentNumber,dataOffsetAndFlags,
                windowSize,checksum,urgentPointer);
        byte[] payload = tcp.getPayload();
        String hexPayload = bytesToHex(payload);
        packetToUse.setPayloadData(hexPayload);
    }

}
