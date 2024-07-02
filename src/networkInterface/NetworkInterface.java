package networkInterface;

import org.jnetpcap.Pcap;
import packet.Packet;

public class NetworkInterface {

    private String name; // 接口名称

    private String ipAddress; // 接口的IP地址选择

    public NetworkInterface(){}

    public NetworkInterface(String name,String ipAddress) {
        this.name = name;
        this.ipAddress = ipAddress;
    }


    public NetworkInterface(String name, String ipAddress, int snapMaxLen, int flags, int timeout) {
        this.name = name;
        this.ipAddress = ipAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddresses() {
        return ipAddress;
    }

    public void setIpAddresses(String ipAddresses) {
        this.ipAddress = ipAddresses;
    }

}
