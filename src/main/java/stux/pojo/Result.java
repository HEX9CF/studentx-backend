package stux.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 前后端数据协议
 *
 * @author HEX9CF
 * @date 2023/02/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Boolean flag;
    private Object data;
    private String msg;

    /**
     * @param flag
     */
    public Result(Boolean flag) {
        this.flag = flag;
    }

    /**
     * @param flag
     * @param data
     */
    public Result(Boolean flag, Object data){
        this.flag = flag;
        this.data = data;
    }

    /**
     * @param flag
     * @param msg
     */
    public Result(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    /**
     * @param msg
     */
    public Result(String msg){
        this.flag = false;
        this.msg = msg;
    }
}
