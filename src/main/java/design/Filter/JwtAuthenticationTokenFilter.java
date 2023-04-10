package design.Filter;



import com.fasterxml.jackson.databind.ObjectMapper;
import design.pojo.loginUserDetail;
import design.tool.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


/**
 * @author Zk
 * @date 2023/03/17/16:31
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    RedisTemplate redisTemplate;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       //获取请求头的token
        String token = request.getHeader("token");
        if(!StringUtils.hasText(token)){
            filterChain.doFilter(request,response);
            return;
        }
        String userId = "login:";
        try {
            //解析token
            Claims claims = JwtUtil.parseJWT(token);
            String userID = claims.getSubject();
            userId = userId + userID;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("token error");
        }
        //jackson反序列化返回的是通用link，必须先转化成json再转成指定类型；
        Object o = redisTemplate.opsForValue().get(userId);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(o);
        loginUserDetail loginUserDetail = objectMapper.readValue(s, loginUserDetail.class);
        //redis中获取user对象
        if(Objects.isNull(loginUserDetail)){
            throw  new RuntimeException("unLogin");
        }
        //存入认证
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginUserDetail,null,null);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        filterChain.doFilter(request,response);

    }
}
