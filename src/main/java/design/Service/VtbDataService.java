package design.Service;

/**
 * @author Zk
 * @date 2023/03/21/11:39
 */
public interface VtbDataService {
    String getVtbData();
    String getIncomeDate();
    String getWeekIncome();
    String getInfo(String UID);//获取个人具体数据
    String getFansInc();
    String getWeekFans();
}
