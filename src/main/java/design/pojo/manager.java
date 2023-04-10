package design.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Zk
 * @date 2023/03/05/18:28
 */
@Data
@TableName("manager")
public class manager {
    @TableId("username")
    private String username;
    private String password;
}
