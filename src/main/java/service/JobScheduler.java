package service;

import model.JobTask;

import java.util.Timer;

public class JobScheduler {
    private static Timer timer;
    private static long periodTime = 3600 * 1000 ; //second
    private static long startupDelayTime = 10 * 1000; //second
    private static String propertiesUrl = "Your-Properties.json";
    public static boolean schedule() {
        try {
            JobTask task = new JobTask();
            task.setPropertiesUrl(propertiesUrl);
            if (timer == null) {
                timer = new Timer();
            }
//        設定計時器
//        第一個參數為 "欲執行的工作", 會呼叫對應的run() method
//        第二個參數為程式啟動後, "延遲" 指定的毫秒數後 "第一次" 執行該工作
//        第三個參數為每間隔多少毫秒執行該工作
            timer.schedule(task, startupDelayTime, periodTime);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void setPeriodTime(int second) {
        if (timer == null) {
            timer = new Timer();
        }
        periodTime = second * 1000L;
    }

    public static void setStartupTime(int second) {
        if (timer == null) {
            timer = new Timer();
        }
        startupDelayTime = second * 1000L;
    }

    public static void setPropertiesUrl(String url) {
        propertiesUrl = url;
    }
}
