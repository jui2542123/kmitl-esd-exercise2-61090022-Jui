package kmitl.esd.exercise2.model;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

    private long id;
    private String name;
    private long age;
    private String remark;


    public CustomerDTO(int id, String name) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
