package task5;

public class DeliveryDepartment {
    private String address;
    private boolean isAvailableForTruck;
    private boolean isAvailableForTrain;
    private boolean isAvailableForBus;
    public DeliveryDepartment(final String address, final boolean isAvailableForTruck,final  boolean isAvailableForTrain,final  boolean isAvailableForBus) {
        if (address.length() < 1)
            throw new IllegalArgumentException("Порожня адреса");
        else
            this.address = address;
        this.isAvailableForTruck = isAvailableForTruck;
        this.isAvailableForTrain = isAvailableForTrain;
        this.isAvailableForBus = isAvailableForBus;
    }
    public double getMaxWeight(){
        if(isAvailableForTrain)
            return 1000;
        if(isAvailableForTruck)
            return 500;
        if(isAvailableForBus)
            return 100;
        return 30;
    }
    public String getAddress(){
        return address;
    }
}
