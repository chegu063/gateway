package top.chegu.common.consts;

/**
 * @author chegu
 * @date 2021/4/12  11:18
 */
public enum GuGateExceptionEnum {

    /**
     *
     */
    ss(1,"2");

    private Integer code;

    private String message;

    GuGateExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
