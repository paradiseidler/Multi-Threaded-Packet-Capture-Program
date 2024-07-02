package packet;

import exceptions.NetException;
import frame.component.SelectionComboBoxComponent;
import header.BaseHeader;
import networkInterface.NetworkInterface;
import org.jnetpcap.Pcap;
import org.jnetpcap.PcapBpfProgram;
import strategy.PacketStrategy;

import javax.swing.*;

public class Packet {

    private BaseHeader baseHeader;  //策略模式,IP/TCP

    private String payloadData;  //数据载荷

    private NetworkInterface networkInterface;//网络接口

    private PacketStrategy packetStrategy;//对应于TCP以及IP的不同抓包方式

    private int snapMaxLen;

    private int flags;

    private int timeout;

    private StringBuilder errBuf;

    public Packet(BaseHeader baseHeader, NetworkInterface networkInterface,PacketStrategy packetStrategy){
        this.baseHeader=baseHeader;
        this.networkInterface=networkInterface;
        this.packetStrategy=packetStrategy;
        this.snapMaxLen=64*1024;
        this.flags= Pcap.MODE_PROMISCUOUS;
        this.timeout=10*1000;
        this.errBuf=new StringBuilder();
    }

    public Packet() {
    }



    public void capture(JTextArea outPutArea,String captureNumString) throws NetException {
        int captureNum = Integer.parseInt(captureNumString);
        Pcap pcap = netInit(outPutArea, this);
        packetStrategy.capture(outPutArea,this,captureNum,pcap);
    }

    protected Pcap netInit(JTextArea outPutArea,Packet packetToUse) throws NetException {
        Pcap pcap = Pcap.openLive(packetToUse.getNetworkInterface().getName(), packetToUse.getSnapMaxLen(),
                packetToUse.getFlags(), packetToUse.getTimeout(),
                packetToUse.getErrBuf());
        if (pcap == null) {
            outPutArea.append("无效网卡，请重新填写。\n");
            throw new NetException("Error while opening device for capture: " + packetToUse.getErrBuf());
        }
        if(!packetToUse.getNetworkInterface().getIpAddresses().equals("")){
            // 设置过滤器
            PcapBpfProgram filter = new PcapBpfProgram();
            String expression = "host " + packetToUse.getNetworkInterface().getIpAddresses();
            int optimize = 0; // 0表示不优化
            int netmask = 0xFFFFFF00; // 掩码，这里使用默认掩码
            int compileResult = pcap.compile(filter, expression, optimize, netmask);
            if (compileResult != Pcap.OK) {
                throw new NetException("Error setting filter: "+ packetToUse.getErrBuf());
            }
            pcap.setFilter(filter);
        }
        return pcap;
    }

    public BaseHeader getBaseHeader() {
        return baseHeader;
    }

    public void setBaseHeader(BaseHeader baseHeader) {
        this.baseHeader = baseHeader;
    }


    public String getPayloadData() {
        return payloadData;
    }


    public void setPayloadData(String payloadData) {
        this.payloadData = payloadData;
    }


    public NetworkInterface getNetworkInterface() {
        return networkInterface;
    }

    public void setNetworkInterface(NetworkInterface networkInterface) {
        this.networkInterface = networkInterface;
    }

    public PacketStrategy getPacketStrategy() {
        return packetStrategy;
    }


    public void setPacketStrategy(PacketStrategy packetStrategy) {
        this.packetStrategy = packetStrategy;
    }


    public int getSnapMaxLen() {
        return snapMaxLen;
    }


    public void setSnapMaxLen(int snapMaxLen) {
        this.snapMaxLen = snapMaxLen;
    }


    public int getFlags() {
        return flags;
    }


    public void setFlags(int flags) {
        this.flags = flags;
    }


    public int getTimeout() {
        return timeout;
    }


    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }


    public StringBuilder getErrBuf() {
        return errBuf;
    }


    public void setErrBuf(StringBuilder errBuf) {
        this.errBuf = errBuf;
    }

    public String toString() {
        return "Packet{baseHeader = " + baseHeader + ", payloadData = " + payloadData + ", networkInterface = " + networkInterface + ", packetStrategy = " + packetStrategy + ", snapMaxLen = " + snapMaxLen + ", flags = " + flags + ", timeout = " + timeout + ", errBuf = " + errBuf + "}";
    }
}
