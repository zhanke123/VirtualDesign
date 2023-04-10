package design.Service.ServiceImpl;

import design.Service.VtbDataService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Zk
 * @date 2023/03/21/11:40
 */
@Service
public class VtbDataServiceImpl implements VtbDataService {
    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public String getVtbData() {
        String vtbData = null;
        try{
            vtbData = (String) redisTemplate.opsForValue().get("vtbData");
            if(vtbData!=null)
            return vtbData;
        }catch (Exception e){
            System.out.println("redis not found");
        }
        try {
            Connection connect = Jsoup.connect("https://www.vtbs.fun:8050/sumRecord/topSumRecord");
            connect.header("Content-Type", "application/json; charset=utf-8");
            connect.ignoreContentType(true);
            Document document = connect.get();
            Element body = document.body();
            String data  = body.text();
            vtbData = data;
            redisTemplate.opsForValue().set("vtbData",data,600, TimeUnit.SECONDS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vtbData;
    }

    @Override//每日营收
    public String getIncomeDate() {
        String income = null;
        try{
            income = (String) redisTemplate.opsForValue().get("incomeData");
            if(income!=null)
                return income;
        }catch (Exception e){
            System.out.println("redis not found");
        }
        try {
            Connection connect = Jsoup.connect("https://www.vtbs.fun:8050/rank/income?dateRange=%E6%97%A5%E6%A6%9C&current=1&size=100");
            connect.header("Content-Type", "application/json; charset=utf-8");
            connect.ignoreContentType(true);
            Document document = connect.get();
            Element body = document.body();
            String data  = body.text();
            income = data;
            redisTemplate.opsForValue().set("incomeData",data,600, TimeUnit.SECONDS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return income;
    }

    @Override//每周营收
    public String getWeekIncome() {
        String weekIncome = null;
        try{
            weekIncome = (String) redisTemplate.opsForValue().get("weekIncome");
            if(weekIncome!=null)
                return weekIncome;
        }catch (Exception e){
            System.out.println("redis not found");
        }
        try {
            Connection connect = Jsoup.connect("https://www.vtbs.fun:8050/rank/income?dateRange=%E5%91%A8%E6%A6%9C&current=1&size=100");
            connect.header("Content-Type", "application/json; charset=utf-8");
            connect.ignoreContentType(true);
            Document document = connect.get();
            Element body = document.body();
            String data  = body.text();
            weekIncome = data;
            redisTemplate.opsForValue().set("weekIncome",data,600, TimeUnit.SECONDS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weekIncome;
    }

    @Override
    public String getFansInc() {
        String fansInc = null;
        try{
            fansInc = (String) redisTemplate.opsForValue().get("fansInc");
            if(fansInc!=null)
                return fansInc;
        }catch (Exception e){
            System.out.println("redis not found");
        }
        try {
            Connection connect = Jsoup.connect("https://www.vtbs.fun:8050/rank/incfans?dateRange=%E6%97%A5%E6%A6%9C&current=1&size=100");
            connect.header("Content-Type", "application/json; charset=utf-8");
            connect.ignoreContentType(true);
            Document document = connect.get();
            Element body = document.body();
            String data  = body.text();
            fansInc = data;
            redisTemplate.opsForValue().set("fansInc",data,600, TimeUnit.SECONDS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fansInc;
    }
    @Override
    public String getWeekFans() {
        String weekFans = null;
        try{
            weekFans = (String) redisTemplate.opsForValue().get("weekFans");
            if(weekFans!=null)
                return weekFans;
        }catch (Exception e){
            System.out.println("redis not found");
        }
        try {
            Connection connect = Jsoup.connect("https://www.vtbs.fun:8050/rank/incfans?dateRange=%E5%91%A8%E6%A6%9C&current=1&size=100");
            connect.header("Content-Type", "application/json; charset=utf-8");
            connect.ignoreContentType(true);
            Document document = connect.get();
            Element body = document.body();
            String data  = body.text();
            weekFans = data;
            redisTemplate.opsForValue().set("weekFans",data,600, TimeUnit.SECONDS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weekFans;
    }


    @Override
    public String getInfo(String UID) {
        String info = null;
        try{
            info = (String) redisTemplate.opsForValue().get("info");
            if(info!=null)
                return info;
        }catch (Exception e){
            System.out.println("redis not found");
        }
        try {
            Connection connect = Jsoup.connect("https://www.vtbs.fun:8050/vtb/"+UID);
            connect.header("Content-Type", "application/json; charset=utf-8");
            connect.ignoreContentType(true);
            Document document = connect.get();
            Element body = document.body();
            String data  = body.text();
            info = data;
            redisTemplate.opsForValue().set(UID+"info",data,600, TimeUnit.SECONDS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }
}
