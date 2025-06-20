package com.xworkz.cafe.constant;

public enum DBProperties {

    URL("jdbc:mysql://localhost:3306/duster"),
    USER_NAME("root"),
    SECRET("afs313"),
    /* JDBC_DRIVER ("com.mysql.cj.jdbc.Driver"),*/
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
