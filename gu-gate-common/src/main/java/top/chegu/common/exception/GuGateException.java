package top.chegu.common.exception;

import top.chegu.common.consts.GuGateExceptionEnum;

/**
 * @author chegu
 * @date 2021/4/9  20:42
 */
public class GuGateException extends RuntimeException{

    private Integer code;

    private String message;

    public GuGateException(String message){
        super(message);
        this.message = message;
        this.code = 5000;
    }

    public GuGateException(GuGateExceptionEnum gateExceptionEnum){
        super(gateExceptionEnum.getMessage());
        this.code = gateExceptionEnum.getCode();
        this.message = gateExceptionEnum.getMessage();
    }

}
