public class BusStation implements Comparable {
    private String stNum;   //车站编号
    private String stName;    //车牌名
    private String location;    //具体位置
    private String passingBusNo;       //经过公交车号
    private String isRun;       //“运行” “维修” “停运”

    public BusStation(String stNum, String stName, String location, String passingBusNo, String isRun) {
        this.stNum = stNum;
        this.stName = stName;
        this.location = location;
        this.passingBusNo = passingBusNo;
        this.isRun = isRun;
    }

    @Override
    public int compareTo(Object o) {
        BusStation bus = (BusStation)o;
        if (Integer.parseInt(this.stNum) > Integer.parseInt(bus.stNum)) {
            return 1;
        } else if (Integer.parseInt(this.stNum) < Integer.parseInt(bus.stNum)) {
            return -1;
        } return 0;
    }

    public String getStNum() {
        return stNum;
    }

    public void setStNum(String stNum) {
        this.stNum = stNum;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPassingBusNo() {
        return passingBusNo;
    }

    public void setPassingBusNo(String passingBusNo) {
        this.passingBusNo = passingBusNo;
    }

    public String getIsRun() {
        return isRun;
    }

    public void setIsRun(String isRun) {
        this.isRun = isRun;
    }
}
