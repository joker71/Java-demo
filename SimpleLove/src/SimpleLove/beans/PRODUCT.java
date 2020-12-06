package SimpleLove.beans;



public class PRODUCT {
    private String code;
    private String brand;
    private String color;
    private String name;
    private int size;
    private float priceint;
    private float priceout;
    private String description;

    public PRODUCT(String code, String name, int size, String brand, String color, float priceint, float priceout) {
        this.code = code;
        this.name = name;
        this.size = size;
        this.brand = brand;
        this.color = color;
        this.priceout = priceout;
        this.priceint = priceint;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String code) {
        this.color = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getSize()
    {
        return this.size;
    }
    public void setSize(int size)
    {
        this.size = size;
    }
    public float getPriceint() {
        return priceint;
    }

    public void setPriceint(float price) {
        this.priceint = price;
    }

    public float getPriceout() {
        return priceout;
    }

    public void setPrice(float price) {
        this.priceout = price;
    }
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String des) {
        this.description = des;
    }
}
