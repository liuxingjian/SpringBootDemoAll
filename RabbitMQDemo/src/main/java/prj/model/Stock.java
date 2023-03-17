package prj.model;

import java.io.Serializable;

public class Stock implements Serializable {
	private int ID;
	private String name;
	private int num;
	private String description;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public String getDescription() {
        return description;
    }
}

