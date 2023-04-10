package design.Service.ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import design.mapper.managerMapper;
import design.pojo.loginUserDetail;
import design.pojo.manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author Zk
 * @date 2023/03/10/23:09
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    managerMapper managerMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        LambdaQueryWrapper<manager> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(manager::getUsername,username);
        manager manager = managerMapper.selectOne(lambdaQueryWrapper);
        if(manager == null){
            throw new RuntimeException("查找失败");
        }
        return new loginUserDetail(manager);
    }
}
