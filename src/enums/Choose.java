package enums;

public enum Choose {
    TCP("TCP"),
    IP("IP");

    private final String type;

    Choose(String type) {
        this.type=type;
    }

    public String getType() {
        return type;
    }
}
