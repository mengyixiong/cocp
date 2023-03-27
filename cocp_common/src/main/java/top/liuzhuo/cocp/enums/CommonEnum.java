package top.liuzhuo.cocp.enums;

public enum CommonEnum {
    SUCCESS(0, "成功"),
    ERROR(10000, "失败"),
    PRAM_NOT_MATCH(10001, "参数类型不匹配"),
    VALIDATE_FAILED(10002, "参数校验失败");

    private Integer code;
    private String msg;

    private CommonEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

}
