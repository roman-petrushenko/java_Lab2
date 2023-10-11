package org.example;

public class matr_gen_el<T1> implements matr_el_interface<T1>{
    T1 m_el1;
    matr_gen_el(T1 l11){
        m_el1 = l11;
    }
    public double get_numeric_format (double m_el1){
        return m_el1;
    }
    public double get_numeric_format (T1 m_el1){
        double m_el_d = Double.parseDouble((String) m_el1);
        return m_el_d;
    }
}
