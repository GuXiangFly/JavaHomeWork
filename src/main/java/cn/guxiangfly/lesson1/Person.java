package cn.guxiangfly.lesson1;

/**
 * Test1
 *
 * @author guxiang
 * @date 2017/10/9
 */
public class Person {
    private String name;
    private String sex;
    private Integer age;
    private String idNo;
    private Boolean isMerried;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Boolean getMerried() {
        return isMerried;
    }

    public void setMerried(Boolean merried) {
        isMerried = merried;
    }

    public Person(String idNo) {
        this.idNo = idNo;
    }
}
