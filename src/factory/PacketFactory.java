package factory;


import header.BaseHeader;
import header.IPHeader;
import header.TCPHeader;
import networkInterface.NetworkInterface;
import packet.Packet;
import strategy.IPPacketStrategy;
import strategy.TCPPacketStrategy;

public class PacketFactory {
    public static Packet createPacket(BaseHeader header, NetworkInterface networkInterface) {
        if (header instanceof IPHeader) {
            return new Packet(header, networkInterface,new IPPacketStrategy());
        } else if (header instanceof TCPHeader) {
            return new Packet(header, networkInterface,new TCPPacketStrategy());
        }
        return null;
    }
}
