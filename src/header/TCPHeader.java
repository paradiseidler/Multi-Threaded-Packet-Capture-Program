package header;

public class TCPHeader extends BaseHeader{

    private static final int URG_MASK = 0x20; // 紧急指针标志位

    private static final int ACK_MASK = 0x10; // 应答标志位

    private static final int PSH_MASK = 0x08; // 推送标志位

    private static final int RST_MASK = 0x04; // 复位标志位

    private static final int SYN_MASK = 0x02; // 同步标志位

    private static final int FIN_MASK = 0x01; // 结束标志位

    private int sourcePort; // 源端口  16bit

    private int destinationPort; // 目标端口  16bit

    private long sequenceNumber; // 序列号   32bit

    private long acknowledgmentNumber; // 应答号  32bit

    private int dataOffsetAndFlags; // 数据偏移和标志位

    private int windowSize; // 窗口大小    16bit

    private int checksum; // 校验和   16bit

    private int urgentPointer; // 紧急指针  16bit

    public void setElement(int sourcePort, int destinationPort, long sequenceNumber,
                           long acknowledgmentNumber, int dataOffsetAndFlags,
                           int windowSize, int checksum, int urgentPointer) {
        this.sourcePort = sourcePort;
        this.destinationPort = destinationPort;
        this.sequenceNumber = sequenceNumber;
        this.acknowledgmentNumber = acknowledgmentNumber;
        this.dataOffsetAndFlags = dataOffsetAndFlags;
        this.windowSize = windowSize;
        this.checksum = checksum;
        this.urgentPointer = urgentPointer;
    }

    public static String parseFlags(int flags) {
        StringBuilder builder = new StringBuilder();
        if ((flags & URG_MASK) != 0) {
            builder.append("URG标志位被设置  ");
        }
        if ((flags & ACK_MASK) != 0) {
            builder.append("ACK标志位被设置  ");
        }
        if ((flags & PSH_MASK) != 0) {
            builder.append("PSH标志位被设置  ");
        }
        if ((flags & RST_MASK) != 0) {
            builder.append("RST标志位被设置  ");
        }
        if ((flags & SYN_MASK) != 0) {
            builder.append("SYN标志位被设置  ");
        }
        if ((flags & FIN_MASK) != 0) {
            builder.append("FIN标志位被设置  ");
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TCP 头部信息：")
                .append("\n源端口: ").append(sourcePort)
                .append("\n目标端口: ").append(destinationPort)
                .append("\n序列号及其raw: ").append(sequenceNumber)
                .append("\n应答号及其raw: ").append(acknowledgmentNumber)
                .append("\n数据偏移和标志位: ").append(dataOffsetAndFlags)
                .append("\n").append(TCPHeader.parseFlags(dataOffsetAndFlags))
                .append("\n窗口大小: ").append(windowSize).append("字节")
                .append("\n校验和: ").append(checksum)
                .append("\n紧急指针: ").append(urgentPointer+"\n");



        return builder.toString();
    }



}
