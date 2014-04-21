/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javausahibernate;

import java.util.*;
import org.hibernate.*;
import pojos.*;

/**
 *
 * @author alumno
 */
public class ManagerEmpleados {
    public Empleado getEmpleado(Integer id){
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Empleado em=(Empleado) ses.get(Empleado.class, id);
        return em;
    }
    
    public void addEmpleado(Empleado em){
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        ses.beginTransaction();
        ses.save(em);
        ses.getTransaction().commit();
    }
    
    public void delEmpleado(Empleado em)
    {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        ses.beginTransaction();
        ses.delete(em);
        ses.getTransaction().commit();
    }
    
    public void updateEmpleado(Empleado em)
    {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        ses.beginTransaction();
        ses.update(em);
        ses.getTransaction().commit();
    }
    
    public Collection<Empleado> getAllEmpleados(){
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Query q = ses.createQuery("from Empleados");
        List<Empleado> emple = q.list();
        return emple;
    }
}
