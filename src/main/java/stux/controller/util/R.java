package stux.controller.util;

import lombok.Data;

/**
 * 前后端数据协议
 *
 * @author HEX9CF
 * @date 2023/02/27
 */
@Data
public class R {
    private Boolean flag;
    private Object data;
    private String msg;
    public R() {}

    /**
     * @param flag
     */
    public R(Boolean flag) {
        this.flag = flag;
    }

    /**
     * @param flag
     * @param data
     */
    public R(Boolean flag, Object data){
        this.flag = flag;
        this.data = data;
    }

    /**
     * @param flag
     * @param msg
     */
    public R(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    /**
     * @param msg
     */
    public R(String msg){
        this.flag = false;
        this.msg = msg;
    }
}
