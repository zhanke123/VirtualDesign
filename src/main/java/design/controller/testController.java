package design.controller;

import com.fasterxml.jackson.databind.JsonNode;
import design.Service.ChatGPTService;
import design.Service.ServiceImpl.MangaServiceImpl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Zk
 * @date 2023/03/07/11:34
 */
@RestController
public class testController {
//    @Resource
//    RedisTemplate redisTemplate;
    @Resource
    MangaServiceImpl mangaService;
    @Resource
    ChatGPTService chatGPTService;
    @RequestMapping("/GetRedis")
    @ResponseBody
    public JsonNode getRedis(){
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        valueOperations.increment("openWeb",1);
//        return (Integer) valueOperations.get("openWeb");
        return mangaService.getMangaJson();
    }

    @ResponseBody
    @RequestMapping("/get/{question}")
    public String get(@PathVariable String question){
        String result = chatGPTService.getResult(question);
        return result;
    }
}
