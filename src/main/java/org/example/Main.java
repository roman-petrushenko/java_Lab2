package org.example;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {

            matrix_calc matr1 = new matrix_calc(3,3);
            matrix_calc matr2 = new matrix_calc(3,3);
            //matrix_calc_immut matr111 = new matrix_calc_immut(matr1);
            /*System.out.println(matr1.matr_toString());
            System.out.println(matr2.matr_toString());
            System.out.println(matr111.matr_toString());*/
            matr1.matrix_mas_setval("file9.txt");
            matr2.matrix_mas_setval("file10.txt");
            /*matrix_calc_immut matr111 = new matrix_calc_immut(matr1);
            System.out.println();
            System.out.println(matr1.matr_toString());
            System.out.println();
            System.out.println(matr2.matr_toString());
            System.out.println();
            System.out.println(matr111.matr_toString());
            System.out.println();*/
            matrix_calc matr6 = matrix_calc.get_rev_matrix(matr1);
            System.out.println();
            System.out.println(matr1.matr_toString());
            System.out.println();
            System.out.println(matr1.get_det());
            System.out.println();
            matrix_calc_immut matr66 = new matrix_calc_immut(matr6);
            System.out.println(matr66.matr_toString());
            System.out.println();
            System.out.println(matrix_calc.matrix_multiply(matr6, matr1).matr_toString());


            /*matrix_calc matr3 = matrix_calc.matrix_add(matr1, matr2);
            matr3.matrix_writer("file11.txt");
            matrix_calc matr4 = matrix_calc.matrix_multiply(matr1, matr2);
            matr4.matrix_writer("file11.txt");
            matrix_calc matr5 = matr1.matrix_multiply_n(3.0);
            matr5.matrix_writer("file11.txt");
            matrix_calc matr6 = matrix_calc.get_rev_matrix(matr1);
            matr6.matrix_writer("file11.txt");
            matrix_calc matr7 = matr1.matrix_transpone();
            matr7.matrix_writer("file11.txt");

            //System.out.println(matr4.dsize_get(matr4));
            //System.out.println(matr4.hashCode());


            matrix_calc matr8 = matrix_calc.get_rand_matr(3, 6);
            matr8.matrix_writer("file12.txt");

            double[] mas9 = {3.5, -10.25, 400.4, -11, 0, 3};
            matrix_calc matr9 = matrix_calc.get_diag(mas9);
            matr9.matrix_writer("file12.txt");

            //System.out.println(Arrays.toString(matr9.matrix_mas_get_row(2)));
            //System.out.println(Arrays.toString(matr9.matrix_mas_get_column(1)));

            matrix_calc matr10 = matrix_calc.matrix_multiply(matr8, matr9);
            matr10.matrix_writer("file12.txt");

            //matrix_calc_immut matr11 = new matrix_calc_immut(5,5);
            matrix_calc_immut matr110 = new matrix_calc_immut(5,5);
            matrix_calc_immut matr11 = new matrix_calc_immut(matr110.get_diag1(5));
            //matr110.get_diag1(5).matrix_writer("file13.txt");
            //matr11 = matr11.get_diag1(5);
            matrix_calc_immut matr12 = new matrix_calc_immut(matr11.matrix_multiply_n(-10.1));
            matrix_calc_immut matr121 = new matrix_calc_immut(matr12);



            //System.out.println(matr121.equals(matr12));

            //System.out.println(matr12.equals(matr1));

            matr12.matrix_writer("file13.txt");

            matr_gen_el<Integer> mel1 = new matr_gen_el<>(4);
            matr_gen_el<String> mel2 = new matr_gen_el<>("2");
            matr_gen_el<Double> mel3 = new matr_gen_el<>(-6.0);
            matr_gen_el<String> mel4 = new matr_gen_el<>("10");
            //matr_gen_el<String>[][] matr_gen;
            //matr_gen[0][0] = m_el1;
            matrix_calc_immut matr13 = new matrix_calc_immut(mel1, mel2, mel3, mel4);
            matrix_calc_immut matr14 = matr13.get_rev_matrix(matr13);
            matr13.matrix_writer("file14.txt");
            matr14.matrix_writer("file14.txt");*/



        }

        catch (Exception exc) {
            System.out.println(exc);
        }

        //System.out.println("Hello world!");
    }
}