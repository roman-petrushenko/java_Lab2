package org.example;

public interface mcalc_interface<T> {

    ///double[][] matrix_mas;
    public Double[][] matrix_mas_get();
    //public int matrix_mas_set(double[][] matr_mas);
  // public int matrix_mas_setval(String path1);
    public String matr_toString();
    public T matrix_multiply_n(double k);
    public T matrix_add(T matr1, T matr2);

   // matrix_calc_immut matrix_add(matrix_calc_immut matr1, matrix_calc_immut matr2);

    public T matrix_transpone();
    public T matrix_multiply(T matr1, T matr2);
    public int matrix_writer(String path2);
    public T get_diag(double[] mas3);
    public T get_diag1(int n1);
    public T get_rand_matr(int m2, int n2);
    public T matr_strip(T matr_1, int m3, int n3);
    public double get_det();
    public T get_rev_matrix(T matr11);}