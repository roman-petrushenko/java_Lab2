package org.example;

public class matr_gen_el<T1> implements matr_el_interface<T1>{
    T1 m_el1;
    matr_gen_el(T1 l11){
        m_el1 = l11;
        //String cl = l11.getClass().getName();
        //System.out.println(cl);
    }
    //public double get_numeric_format (Double m_el1){
        //return m_el1;
    //}
    public double get_numeric_format (T1 m_el1){
        double m_el_d = 0.0;
        //System.out.println("1");
        if (m_el1 instanceof String){
            //System.out.println("1");
        m_el_d = Double.parseDouble((String) m_el1);}
        else if (m_el1 instanceof Double){
        m_el_d = (Double)m_el1;}
        else if (m_el1 instanceof Integer){
            Integer m_el_d2 =(Integer)m_el1;
            m_el_d = m_el_d2.doubleValue();
        }
        else{  m_el_d = 0.0;}
        return m_el_d;
    }
}
