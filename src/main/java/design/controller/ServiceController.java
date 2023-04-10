package design.controller;

import com.fasterxml.jackson.databind.JsonNode;
import design.Service.ServiceImpl.MangaServiceImpl;
import design.Service.VtbDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Zk
 * @date 2023/03/15/22:04
 */
@RestController
@ResponseBody
public class ServiceController {
    @Resource
    MangaServiceImpl mangaService;
    @Autowired
    VtbDataService vtbDataService;
    @RequestMapping("/getManga")
    public JsonNode get(){
        JsonNode mangaJson = mangaService.getMangaJson();
        return mangaJson;
    }

    @RequestMapping("/getVtbData")
    public String getVtbData(){
        String vtbData = vtbDataService.getVtbData();
        return vtbData;
    }

    @RequestMapping("/getIncomeData")
    public String getIncomeData(){
        String incomeDate = vtbDataService.getIncomeDate();
        return incomeDate;
    }

    @RequestMapping("/getWeekIncome")
    public String getWeekIncome(){
        String WeekIncome = vtbDataService.getWeekIncome();
        return WeekIncome;
    }

    @RequestMapping("/getFansInc")
    public String getFansInc(){
        String getFansInc = vtbDataService.getFansInc();
        return getFansInc;
    }
    @RequestMapping("/getWeekFans")
    public String getWeekFans(){
        String getWeekFans = vtbDataService.getWeekFans();
        return getWeekFans;
    }

    @RequestMapping("/getInfo/{UID}")
    public String getInfo(@PathVariable String UID){
        String info = vtbDataService.getInfo(UID);
        return info;
    }
}
