package doublePlugin.util;

import doublePlugin.util.map.InfoMaps;

public class CoolTime {
	
	private final InfoMaps infoMaps;	
	public CoolTime(InfoMaps infoMaps) {
		this.infoMaps = infoMaps;
	}

	private static final String COOL_TIME_SYSTEM = "Cool_Time_System_";

    public void setCoolTimeSecond(String coolTimeName, double second) {
        this.infoMaps.setLongValue(COOL_TIME_SYSTEM + coolTimeName, System.currentTimeMillis() + (long) (second * 1000));
    }

    public void setCoolTimeMinute(String coolTimeName, int minute) {
        this.infoMaps.setLongValue(COOL_TIME_SYSTEM + coolTimeName, System.currentTimeMillis() + (long) (minute * 1000 * 60));
    }

    public void setCoolTimeHour(String coolTimeName, int hour) {
        this.infoMaps.setLongValue(COOL_TIME_SYSTEM + coolTimeName, System.currentTimeMillis() + (long) (hour * 1000 * 3600));
    }

    public void setCoolTimeDay(String coolTimeName, int day) {
        this.infoMaps.setLongValue(COOL_TIME_SYSTEM + coolTimeName, System.currentTimeMillis() + (long) (day * 1000 * 3600 * 24));
    }

    /**
     * 한달의 경우 30일을 기준으로 한다.
     */
    public void setCoolTimeMonth(String coolTimeName, int month) {
        this.infoMaps.setLongValue(COOL_TIME_SYSTEM + coolTimeName, System.currentTimeMillis() + (long) (month * 1000 * 3600 * 24 * 30));
    }

    public void setCoolTimeYear(String coolTimeName, int year) {
        this.infoMaps.setLongValue(COOL_TIME_SYSTEM + coolTimeName, System.currentTimeMillis() + (long) (year * 1000 * 3600 * 24 * 365));
    }

    public double getLessCoolTime(String coolTimeName) {
        return (this.infoMaps.getLongValue(COOL_TIME_SYSTEM + coolTimeName) - System.currentTimeMillis()) / 1000;
    }

    public void removeCoolTime(String coolTimeName) {
        this.infoMaps.removeLongValue(COOL_TIME_SYSTEM + coolTimeName);
    }

    public void reduceCoolTime(String coolTimeName, double reduceSecond) {
        this.infoMaps.setLongValue(COOL_TIME_SYSTEM + coolTimeName, this.infoMaps.getLongValue(COOL_TIME_SYSTEM + coolTimeName) - (long) (reduceSecond * 1000));
    }

    public boolean checkCoolTime(String coolTimeName) {
        if (this.infoMaps.containsLongValue(COOL_TIME_SYSTEM + coolTimeName)) {
            if (this.infoMaps.getLongValue(COOL_TIME_SYSTEM + coolTimeName) > System.currentTimeMillis()) {
                return false;
            } else {
                this.infoMaps.removeLongValue(COOL_TIME_SYSTEM + coolTimeName);
                return true;
            }
        } else
            return true;
    }
}
