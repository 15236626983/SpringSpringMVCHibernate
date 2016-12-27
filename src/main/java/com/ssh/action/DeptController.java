package com.ssh.action;

import com.ssh.entity.Dept;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(value = "/addDept")
    public void addDept(){
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
        tx.begin();
        Dept dept = new Dept("ff","ff");
        session.save(dept);
        tx.commit();

        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }
    }
}
