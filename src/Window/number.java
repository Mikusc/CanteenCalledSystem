package Window;

public class number {
    private Integer number;
    private String food_name;
    private String status;
    public number(Integer number,String food_name,String status){
        this.number = number;
        this.food_name = food_name;
        this.status = status;
    }
    public number(){}

    public Integer getNumber() {
        return number;
    }
    public String getFood_name() {
        return food_name;
    }
    public String getStatus() {
        return status;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
