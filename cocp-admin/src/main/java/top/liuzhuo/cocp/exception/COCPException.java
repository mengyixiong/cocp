package top.liuzhuo.cocp.exception;

public class COCPException extends RuntimeException {
    private String msg;

    public COCPException(String msg) {
        super(msg);
        this.msg = msg;
    }

}
