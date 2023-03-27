package top.liuzhuo.cocp.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("测试实体")
@Data
public class TestDto {
    @ApiModelProperty(value = "姓名", example = "刘卓",required = true)
    @NotNull(message = "姓名不能为空")
    private String name;

    @ApiModelProperty(value = "年龄", example = "18")

    private Integer age;
}
