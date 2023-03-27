package top.liuzhuo.cocp.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.liuzhuo.cocp.dto.TestDto;
import top.liuzhuo.cocp.enums.CommonEnum;
import top.liuzhuo.cocp.vo.CommonVo;

@Api(tags = "测试接口")
@RestController
@RequestMapping("/api/admin/test")
public class TesController {

    @GetMapping("/")
    @ApiOperation(value = "测试方法", notes = "用户测试notes")
    public String test() {
        return "test";
    }

    @PostMapping("/post")
    @ApiOperation(value = "测试方法post", notes = "用户测试notes")
    public CommonVo post(@RequestBody @Validated TestDto dto) {
        return CommonVo.success("测试成功",dto);
    }

}
