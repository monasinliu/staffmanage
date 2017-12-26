package com.soft1611.manage.model;

/**
 *
 * @author 朱广旭
 * @date 2017/12/20
 *
 *   部门实体类
 */
public class Department {
    private Integer id;
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
