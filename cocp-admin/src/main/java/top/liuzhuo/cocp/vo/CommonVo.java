package top.liuzhuo.cocp.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("通用返回实体")
public class CommonVo<T> {
    @ApiModelProperty(value = "状态码,0为正常，其他为异常", example = "0")
    private Integer code;

    @ApiModelProperty(value = "返回信息", example = "成功")
    private String msg;

    @ApiModelProperty(value = "返回数据")
    private T data;

    public static <T> CommonVo<T> success(String msg, T data) {
        return new CommonVo(0, "成功", data);
    }

    public static CommonVo error(Integer code, String msg) {
        return new CommonVo(code, msg, null);
    }
}
