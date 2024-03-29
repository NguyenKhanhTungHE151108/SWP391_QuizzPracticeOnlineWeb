package model;

public class Teacher {
  private String rollno,name;

    public Teacher() {
    }

    public Teacher(String rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
