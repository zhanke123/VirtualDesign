package design.Service.ServiceImpl;

import design.Service.ChatGPTService;
import io.github.asleepyfish.util.OpenAiUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zk
 * @date 2023/03/10/11:54
 */
@Service
public class ChatGPTServiceImpl implements ChatGPTService {
    public String getResult(String question){
        List<String> chatCompletion = OpenAiUtils.createChatCompletion(question);
        for(String result :chatCompletion){
            if(result.equals(null)){
                continue;
            }else return result;
        }
        return null;
    }

}
