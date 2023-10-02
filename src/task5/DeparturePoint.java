package task5;

public class DeparturePoint {
    private DeliveryDepartment deliveryDepartment;
    public DeparturePoint(final DeliveryDepartment deliveryDepartment){
        this.deliveryDepartment = deliveryDepartment;
    }
    public double getMaxWeight(){
        return  deliveryDepartment.getMaxWeight();
    }
    public String getAddress(){
        return deliveryDepartment.getAddress();
    }
}
