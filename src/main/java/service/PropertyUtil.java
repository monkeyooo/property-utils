package service;

public class PropertyUtil {

    /**
     * @param  second of period
     */
    public static void setPeriodTime(int second) {
        if (second <= 0) second = 1;
        JobScheduler.setPeriodTime(second);
    }
    /**
     * @param  second of startup delay time
     */
    public static void setStartupTime(int second) {
        if (second <= 0) second = 1;
        JobScheduler.setStartupTime(second);
    }
    /**
     * @param  url of json properties file
     */
    public static void setPropertiesUrl(String url) {
        if (url == null) return;
        JobScheduler.setPropertiesUrl(url);
    }

    public static boolean setPropertyParams() {
        return JobScheduler.schedule();
    }
}
