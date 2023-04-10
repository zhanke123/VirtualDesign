package design.Service.ServiceImpl;

import design.Service.LoginService;
import design.pojo.ResponseResult;
import design.pojo.loginUserDetail;
import design.pojo.manager;
import design.tool.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author Zk
 *  2023/03/11/16:30
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    AuthenticationManager authenticationManager;
    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public ResponseResult login(manager manager) {
        //认证
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(manager.getUsername(), manager.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        //没通过
        if(authenticate == null){
            throw new RuntimeException("fail");
        }
        //通过，生成jwt
        loginUserDetail loginUser = (loginUserDetail) authenticate.getPrincipal();
        String username = loginUser.getManager().getUsername();
        System.out.println(username);
        String jwt = JwtUtil.createJWT(username);
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("token",jwt);

        //存入redis
        redisTemplate.opsForValue().set("login:"+username,loginUser,6000, TimeUnit.SECONDS);
        return new ResponseResult(200,"ok",stringStringHashMap);
    }
}
