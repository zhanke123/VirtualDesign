package design.controller;

import design.Service.LoginService;
import design.pojo.ResponseResult;
import design.pojo.manager;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Zk
 * @date 2023/03/11/16:20
 */
@RestController
public class LoginController {
    @Resource
    LoginService loginService;
    @PostMapping("/login")
    @CrossOrigin
    public ResponseResult login(@RequestBody manager manager){
        return loginService.login(manager);
    }

    @PostMapping("/tokenAdmin")
    @CrossOrigin
    public ResponseResult admin(){
        return new ResponseResult(200,"ok");
    }
}
