package header;

import networkInterface.NetworkInterface;

public class IPHeader extends BaseHeader{
    private int version; // 版本   4bit

    private int headerLength; // 头部长度  4bit

    private int typeOfService; // 服务类型  8bit

    private int totalLength; // 总长度  16bit

    private int identification; // 标识  16bit

    private int flagsAndFragmentOffset; // 标志和偏移  16bit

    private int timeToLive; // 生存时间  8bit

    private int protocol; // 协议   8bit

    private int headerChecksum; // 头部校验和  16bit

    private int sourceIP; // 源IP地址   32bit

    private int destinationIP; // 目标IP地址  32bit

    public IPHeader() {
    }

    public IPHeader(int version, int headerLength, int typeOfService, int totalLength, int identification,
                    int flagsAndFragmentOffset, int timeToLive, int protocol, int headerChecksum, int sourceIP, int destinationIP) {
        this.version = version;
        this.headerLength = headerLength;
        this.typeOfService = typeOfService;
        this.totalLength = totalLength;
        this.identification = identification;
        this.flagsAndFragmentOffset = flagsAndFragmentOffset;
        this.timeToLive = timeToLive;
        this.protocol = protocol;
        this.headerChecksum = headerChecksum;
        this.sourceIP = sourceIP;
        this.destinationIP = destinationIP;
    }


    public int getVersion() {
        return version;
    }


    public void setVersion(int version) {
        this.version = version;
    }


    public int getHeaderLength() {
        return headerLength;
    }


    public void setHeaderLength(int headerLength) {
        this.headerLength = headerLength;
    }


    public int getTypeOfService() {
        return typeOfService;
    }


    public void setTypeOfService(int typeOfService) {
        this.typeOfService = typeOfService;
    }


    public int getTotalLength() {
        return totalLength;
    }


    public void setTotalLength(int totalLength) {
        this.totalLength = totalLength;
    }


    public int getIdentification() {
        return identification;
    }


    public void setIdentification(int identification) {
        this.identification = identification;
    }


    public int getFlagsAndFragmentOffset() {
        return flagsAndFragmentOffset;
    }


    public void setFlagsAndFragmentOffset(int flagsAndFragmentOffset) {
        this.flagsAndFragmentOffset = flagsAndFragmentOffset;
    }

    public int getTimeToLive() {
        return timeToLive;
    }


    public void setTimeToLive(byte timeToLive) {
        this.timeToLive = timeToLive;
    }


    public int getProtocol() {
        return protocol;
    }


    public void setProtocol(int protocol) {
        this.protocol = protocol;
    }


    public int getHeaderChecksum() {
        return headerChecksum;
    }


    public void setHeaderChecksum(int headerChecksum) {
        this.headerChecksum = headerChecksum;
    }


    public int getSourceIP() {
        return sourceIP;
    }


    public void setSourceIP(int sourceIP) {
        this.sourceIP = sourceIP;
    }


    public int getDestinationIP() {
        return destinationIP;
    }


    public void setDestinationIP(int destinationIP) {
        this.destinationIP = destinationIP;
    }

    public  String integerToIp(int ipAddress) {
        return ((ipAddress >> 24) & 0xFF) + "." +
                ((ipAddress >> 16) & 0xFF) + "." +
                ((ipAddress >> 8) & 0xFF) + "." +
                (ipAddress & 0xFF);
    }

    public String protocolToString(int protocol) {
        switch (protocol) {
            case 1:
                return "ICMP"; // Internet Control Message Protocol
            case 6:
                return "TCP"; // Transmission Control Protocol
            case 17:
                return "UDP"; // User Datagram Protocol
            default:
                return "OTHERS"; // 其他协议
        }
    }

    public String typeOfServiceToString(int typeOfService) {
        // 服务类型包含三个比特段：优先级、延迟和吞吐量
        int priority = (typeOfService >> 5) & 0x07;
        int delay = (typeOfService >> 4) & 0x01;
        int throughput = (typeOfService >> 3) & 0x01;
        StringBuilder sb = new StringBuilder();
        sb.append("Priority: ");
        sb.append(priority);
        sb.append(", ");
        if (delay == 1) {
            sb.append("Low Delay, ");
        } else {
            sb.append("Normal Delay, ");
        }
        if (throughput == 1) {
            sb.append("High Throughput");
        } else {
            sb.append("Normal Throughput");
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IP 头部信息:\n");
        sb.append("版本:").append(version).append("\n");
        sb.append("头部长度:").append(headerLength).append(" 字节\n");
        sb.append("服务类型:").append(typeOfService).append(" (").append(typeOfServiceToString(typeOfService)).append(")\n");
        sb.append("总长度:").append(totalLength).append(" 字节\n");
        sb.append("标识:").append(identification).append("\n");
        sb.append("标志和偏移:").append(flagsAndFragmentOffset).append("\n");
        sb.append("生存时间:").append(timeToLive).append(" 跳\n");
        sb.append("协议:").append(protocol).append(" (").append(protocolToString(protocol)).append(")\n");
        sb.append("头部校验和:").append(headerChecksum).append("\n");
        sb.append("源IP地址:").append(integerToIp(sourceIP)).append("\n");
        sb.append("目标IP地址:").append(integerToIp(destinationIP)).append("\n");
        return sb.toString();
    }

    public void setElement(int version, int headerLength, int typeOfService, int totalLength, int identification, int flagsAndFragmentOffset, int timeToLive, int protocol, int headerChecksum, int sourceIP, int destinationIP){
        this.version = version;
        this.headerLength = headerLength;
        this.typeOfService = typeOfService;
        this.totalLength = totalLength;
        this.identification = identification;
        this.flagsAndFragmentOffset = flagsAndFragmentOffset;
        this.timeToLive = timeToLive;
        this.protocol = protocol;
        this.headerChecksum = headerChecksum;
        this.sourceIP = sourceIP;
        this.destinationIP = destinationIP;
    }
}
