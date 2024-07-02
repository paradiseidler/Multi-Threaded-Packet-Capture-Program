package exceptions;

public class NetException extends Exception{
    public NetException(){}

    public NetException(String errorMessage){
        super(errorMessage);
    }
}
