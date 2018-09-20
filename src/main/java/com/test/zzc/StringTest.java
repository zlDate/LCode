package com.test.zzc;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author le
 * @date 2017/10/21
 */
public class StringTest {

    public static void main(String[] args) {
        String str = "{\"velocityCheck\":{\"mobile\":{\"timeScopes\":[{\"pidCount\":0,\"subWindowSize\":30,\"crossTenantAppsNumber\":0},{\"pidCount\":1,\"subWindowSize\":60,\"crossTenantAppsNumber\":1},{\"pidCount\":1,\"subWindowSize\":90,\"crossTenantAppsNumber\":4},{\"pidCount\":1,\"subWindowSize\":180,\"crossTenantAppsNumber\":8}]},\"pid\":{\"timeScopes\":[{\"mobileCount\":1,\"subWindowSize\":30,\"crossTenantAppsNumber\":1},{\"mobileCount\":1,\"subWindowSize\":60,\"crossTenantAppsNumber\":4},{\"mobileCount\":1,\"subWindowSize\":90,\"crossTenantAppsNumber\":4},{\"mobileCount\":1,\"subWindowSize\":180,\"crossTenantAppsNumber\":8}]}},\"blacklist\":{\"ipAddress\":{\"lastConfirmStatus\":\"\",\"blackLevel\":\"none\",\"last6MQueryCount\":0,\"lastConfirmAtDays\":-1,\"last12MMaxConfirmStatus\":\"\",\"last6MTenantCount\":0},\"mobile\":{\"lastConfirmStatus\":\"\",\"blackLevel\":\"none\",\"last6MQueryCount\":0,\"lastConfirmAtDays\":-1,\"last12MMaxConfirmStatus\":\"\",\"last6MTenantCount\":0},\"deviceId\":{\"lastConfirmStatus\":\"\",\"blackLevel\":\"none\",\"last6MQueryCount\":0,\"lastConfirmAtDays\":-1,\"last12MMaxConfirmStatus\":\"\",\"last6MTenantCount\":0},\"pid\":{\"lastConfirmStatus\":\"\",\"blackLevel\":\"none\",\"last6MQueryCount\":0,\"lastConfirmAtDays\":-1,\"last12MMaxConfirmStatus\":\"\",\"last6MTenantCount\":0}},\"loanInfo\":{\"ipAddress\":{\"timeScopes\":{\"D90\":{\"loanTenantCount\":0,\"loanCount\":0,\"queryCount\":0},\"D360\":{\"loanTenantCount\":0,\"loanCount\":0,\"queryCount\":0}}},\"mobile\":{\"timeScopes\":{\"D90\":{\"maxOverdueDays\":-1,\"overdueLoanCount\":-1,\"averageTenantGapDays\":0,\"averageLoanAmount\":0,\"maxLoanAmount\":0,\"maxLoanPeriodDays\":0,\"loanTenantCount\":0,\"loanCount\":0,\"overdueTenantCount\":-1,\"averageLoanGapDays\":0,\"queryCount\":4,\"overdueFor2TermTenantCount\":-1},\"D360\":{\"overdueLoanCount\":-1,\"monthsFromLastOverdue\":-1,\"averageLoanAmount\":1000,\"remainingAmount\":0,\"maxLoanAmount\":1000,\"loanTenantCount\":1,\"overdueTenantCount\":-1,\"daysFromLastLoan\":176,\"queryCount\":9,\"overdueFor2TermTenantCount\":-1,\"maxOverdueDays\":-1,\"averageTenantGapDays\":14,\"monthsForNormalRepay\":-1,\"maxLoanPeriodDays\":14,\"loanCount\":1,\"averageLoanGapDays\":11,\"monthsFromFirstLoan\":6}}},\"deviceId\":{\"timeScopes\":{\"D90\":{\"loanTenantCount\":0,\"loanCount\":0,\"queryCount\":0},\"D360\":{\"loanTenantCount\":0,\"loanCount\":0,\"queryCount\":0}}},\"pid\":{\"timeScopes\":{\"D90\":{\"maxOverdueDays\":-1,\"overdueLoanCount\":-1,\"averageTenantGapDays\":-1,\"averageLoanAmount\":0,\"maxLoanAmount\":0,\"maxLoanPeriodDays\":14,\"loanTenantCount\":2,\"loanCount\":2,\"overdueTenantCount\":-1,\"averageLoanGapDays\":2,\"queryCount\":4,\"overdueFor2TermTenantCount\":-1},\"D360\":{\"overdueLoanCount\":-1,\"monthsFromLastOverdue\":-1,\"averageLoanAmount\":0,\"remainingAmount\":0,\"maxLoanAmount\":0,\"loanTenantCount\":2,\"overdueTenantCount\":-1,\"daysFromLastLoan\":-1,\"queryCount\":0,\"overdueFor2TermTenantCount\":-1,\"maxOverdueDays\":-1,\"averageTenantGapDays\":-1,\"monthsForNormalRepay\":-1,\"maxLoanPeriodDays\":14,\"loanCount\":2,\"averageLoanGapDays\":2,\"monthsFromFirstLoan\":-1}}}}}";

        Map<String,String> resultMap = new HashMap<>();
        getResult(str,resultMap,"");

        System.out.println(resultMap.size());


    }

    private static void getResult(String jsonStr,Map<String,String> result,String parStr){
        Integer jsonType = isJson(jsonStr);
        if(jsonType==1){
            Map map = JSON.parseObject(jsonStr,Map.class);

            map.forEach((k,v) -> {
                getResult(v.toString(),result,parStr+"_"+k);
            });

        }else if(jsonType==2){
            List list = JSON.parseObject(jsonStr,List.class);
            for (int i=0;i<list.size();i++){
                getResult(list.get(i).toString(),result,parStr+i);
            }

        }else {
            result.put(parStr,jsonStr);
        }
    }

    /**
     * 1:map 2:array 0:exception
     * @param json
     * @return
     */
    private static Integer isJson(String json) {
        try {
            JSON.parseObject(json, Map.class);
            return 1;
        } catch (Exception e) {
            try {
                JSON.parseObject(json,List.class);
                return 2;
            }catch (Exception e1){
                return 0;
            }
        }


    }


}
