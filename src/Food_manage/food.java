package Food_manage;

public class food {

    private Integer id;
    private String name;

    public food(Integer id,String name){
        super();
        this.id = id;
        this.name = name;
    }

    public food(){}

    public Integer getId(){return id;}
    public String getName(){return name;}

    public void setId(Integer id){this.id = id;}
    public void setName(String name){this.name = name;}

}
