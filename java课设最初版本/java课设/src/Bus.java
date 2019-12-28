//公交车类
public class Bus {
    private int busNum;
    private String startStation;
    private String endStation;
    private String passStation;

    public Bus(int busNum, String startStation, String endStation, String passStation) {
        this.busNum = busNum;
        this.startStation = startStation;
        this.endStation = endStation;
        this.passStation = passStation;
    }

    public int getBusNum() {
        return busNum;
    }

    public void setBusNum(int busNum) {
        this.busNum = busNum;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getPassStation() {
        return passStation;
    }

    public void setPassStation(String passStation) {
        this.passStation = passStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }
}
