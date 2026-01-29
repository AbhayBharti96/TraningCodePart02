package PracticeQuestionScenarioBased;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

class DataCenter {

    private String dataCenterId;
    private String location;
    private String supervisorName;
    private double coolingPowerUsage;

    // No-argument constructor
    public DataCenter() {
    }

    // Four-argument constructor
    public DataCenter(String dataCenterId, String location,
                      String supervisorName, double coolingPowerUsage) {
        this.dataCenterId = dataCenterId;
        this.location = location;
        this.supervisorName = supervisorName;
        this.coolingPowerUsage = coolingPowerUsage;
    }

    public String getDataCenterId() {
        return dataCenterId;
    }

    public void setDataCenterId(String dataCenterId) {
        this.dataCenterId = dataCenterId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public double getCoolingPowerUsage() {
        return coolingPowerUsage;
    }

    public void setCoolingPowerUsage(double coolingPowerUsage) {
        this.coolingPowerUsage = coolingPowerUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataCenter)) return false;
        DataCenter d = (DataCenter) o;
        return dataCenterId.equals(d.dataCenterId);
    }

    @Override
    public int hashCode() {
        return dataCenterId.hashCode();
    }
}

class DataCenterUtil {

    private Set<DataCenter> dataCenterSet = new LinkedHashSet<>();

    public Set<DataCenter> getDataCenterSet() {
        return dataCenterSet;
    }

    public void setDataCenterSet(Set<DataCenter> dataCenterSet) {
        this.dataCenterSet = dataCenterSet;
    }

    // Requirement 1
    public void addDataCenter(DataCenter dataCenter) {
        dataCenterSet.add(dataCenter);
    }

    // Requirement 2
    public DataCenter getDataCenterById(String dataCenterId) {
        for (DataCenter d : dataCenterSet) {
            if (d.getDataCenterId().equals(dataCenterId)) {
                return d;
            }
        }
        return null;
    }

    // Requirement 3
    public List<DataCenter> getDataCentersWithMaximumCoolingPowerUsage() {
        double max = dataCenterSet.stream()
                .mapToDouble(DataCenter::getCoolingPowerUsage)
                .max()
                .orElse(0);

        return dataCenterSet.stream()
                .filter(d -> d.getCoolingPowerUsage() == max)
                .collect(Collectors.toList());
    }
}

class UI{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DataCenterUtil util = new DataCenterUtil();

        System.out.println("Enter the number of data centers to be added");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter data center details");
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] data = input.split(":");

            DataCenter dc = new DataCenter(
                    data[0],
                    data[1],
                    data[2],
                    Double.parseDouble(data[3])
            );

            util.addDataCenter(dc);
        }

        System.out.println("Enter the Data Center ID to get details");
        String id = sc.nextLine();

        DataCenter result = util.getDataCenterById(id);
        if (result != null) {
            System.out.println(result.getDataCenterId() + " | "
                    + result.getLocation() + " | "
                    + result.getSupervisorName() + " | "
                    + result.getCoolingPowerUsage());
        } else {
            System.out.println("Data Center not found for the ID " + id);
        }

        System.out.println("Data Centers with maximum cooling power usage");
        List<DataCenter> maxList = util.getDataCentersWithMaximumCoolingPowerUsage();

        for (DataCenter d : maxList) {
            System.out.println(d.getDataCenterId() + " | "
                    + d.getLocation() + " | "
                    + d.getSupervisorName() + " | "
                    + d.getCoolingPowerUsage());
        }
    }
}

