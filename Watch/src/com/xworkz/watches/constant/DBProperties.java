package com.xworkz.watches.constant;

public enum DBProperties {

    URL("jdbc:mysql://localhost:3306/xworkz"),
    USER_NAME("root"),
    SECRET("afs313"),
    VERSION_8;

    private String prop;

    private  DBProperties(String prop)
    {
        this.prop=prop;
    }
    private DBProperties()
    {

    }

    public String getProp() {
        return prop;
    }
}
