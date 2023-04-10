package design.Service;

import design.pojo.ResponseResult;
import design.pojo.manager;

/**
 * @author Zk
 * @date 2023/03/11/16:29
 */
public interface LoginService {

    ResponseResult login(manager manager);
}
