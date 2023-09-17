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
    private Integer code;   // 响应码：1 OK，0 Error
    private String msg;     // 响应信息
    private Object data;    // 返回数据

    public static Result success() {
        return new Result(1, "OK", null);
    }

    public static Result success(Object data) {
        return new Result(1, "OK", data);
    }

    public static Result success(String msg, Object data) {
        return new Result(1, msg, data);
    }

    public static Result error() {
        return new Result(0, "Error", null);
    }

    public static Result error(Object data) {
        return new Result(0, "Error", data);
    }

    public static Result error(String msg, Object data) {
        return new Result(0, msg, data);
    }
}
