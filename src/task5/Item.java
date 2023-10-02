package task5;

public class Item {
    private String description;
    private double weight;
    public Item(final double weight,final String description) {
        if (weight < 0)
            throw new IllegalArgumentException("Вага повинна бути додатним числом.");;
        this.weight = weight;
        if (description.length() > 1) {
            this.description = description;
        } else this.description = "No description";
    }
    public double getWeight(){
        return weight;
    }
    public String getDescription(){
        return description;
    }

}
