package com.ssh.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="tb_dept")
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deptno;
    private String dname;
    private String loc;

    public Dept(String dname, String loc) {
        this.dname = dname;
        this.loc = loc;
    }

    public Dept() {

    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }

    /////////////////////////////////////////////////////////////////////
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "dept")
    private Set<Emp> emps;

    public Set<Emp> getEmps() {
        return emps;
    }

    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
    }
}
