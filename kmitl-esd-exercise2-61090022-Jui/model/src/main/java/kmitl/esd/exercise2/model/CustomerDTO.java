package kmitl.esd.exercise2.model;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

    private long id;
    private String name;
    private long age;
    private String remark;

    //Constructor id + name
    public CustomerDTO(int id, String name) {
        this.id = id;
        this.name = name;

    }
    //getter
    public long getId() {
        return id;
    }

    //setter
    public void setId(long id) {
        this.id = id;
    }

    //show detail
    public String toString(){
        return "Name: " + name + " ID:" + id;
    }

}
