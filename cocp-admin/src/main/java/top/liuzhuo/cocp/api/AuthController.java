package top.liuzhuo.cocp.api;


import io.swagger.annotations.Api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "授权管理")
@RestController
@RequestMapping("/api/admin/auth")
public class AuthController {
//
//    @Resource
//    private AuthenticationManager authenticationManager;
//
//
//    @PostMapping("/login")
//    public CommonVo<String> login(@RequestBody @Validated LoginDto req) {
//
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());
//
//        authenticationManager.authenticate(authenticationToken);
//
//        //上一步没有抛出异常说明认证成功，我们向用户颁发jwt令牌
//        String token = JWT.create()
//                .setPayload("username", req.getUsername())
//                .setKey(CommonConstant.ADMIN_TOKEN_KEY.getBytes(StandardCharsets.UTF_8))
//                .sign();
//
//        return CommonVo.success("登录成功", token);
//    }
}
