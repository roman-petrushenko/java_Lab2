package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            //matrix_calc matrix_calc1 = new matrix_calc(4,4);
            //matrix_calc1.matrix_mas_setval();
            //File file1.txt = new File("file1.txt");
            //matrix_calc1.matrix_mas_setval();
            //System.out.println(matrix_calc1.dsize_get(matrix_calc1));
            //double[][] mas11 = matrix_calc1.matrix_mas_get();
            //matrix_calc matrix_calc2 = new matrix_calc(4,4);
            //matrix_calc2.matrix_mas_set(mas11);
            //double[][] mas22 = matrix_calc1.matrix_mas_get();
            //for (int i1 = 0; i1<4; i1+=1){
            //for (int j1 = 0; j1<4; j1+=1){
            //System.out.print(mas22[i1][j1]+" ");
            //}
            //System.out.println("");
            //}

            //System.out.println("\n"+matrix_calc2.matr_toString());
            //matrix_calc matrix_calc3 = new matrix_calc(matrix_calc1);
            //System.out.println("\n"+matrix_calc3.matr_toString());
            //matrix_calc matrix_calc11 = new matrix_calc(4,4);
            //matrix_calc matrix_calc22 = new matrix_calc(4,4);
            //matrix_calc11.matrix_mas_setval("file1.txt");
            //matrix_calc22.matrix_mas_setval("file3.txt");
            //matrix_calc matrix_calc33 = matrix_calc.matrix_multiply(matrix_calc11, matrix_calc22);
            //System.out.println("\n"+matrix_calc33.matr_toString());
            //matrix_calc11.matrix_mas_setval("file1.txt");
            //matrix_calc11.matrix_mas_setval("file1.txt");
            //matrix_calc matrix_calc44 = matrix_calc11.matrix_multiply_n(5.0);
            //matrix_calc44.matrix_mas_setval("file1.txt");
            //matrix_calc matrix_calc44 = matrix_calc.matrix_add(matrix_calc11, matrix_calc33);
            //System.out.println("\n"+matrix_calc44.matr_toString());

            //matrix_calc11.matrix_mas_setval("file1.txt");
            //matrix_calc matrix_calc1111 = matrix_calc11.matrix_transpone();
            //matrix_calc1111.matrix_writer("file4.txt");}

            //double[] a3 = {2.4, -10, 4, 108.8};
            //System.out.println(matrix_calc11111.matr_toString());}
            //matrix_calc matrix_calc111111 = matrix_calc.get_rand_matr(5, 7);
            //System.out.println(matrix_calc111111.matr_toString());}
            //matrix_calc matrix_calc10 = matrix_calc.get_rand_matr(5, 5);
            //matrix_calc matrix_calc11 = matrix_calc10.matr_strip(matrix_calc10,1,2);
            //System.out.println(matrix_calc10.matr_toString());
            //System.out.println("");
            //System.out.println(matrix_calc11.matr_toString());
            /*matrix_calc matrix_calc12 = new matrix_calc(2,2);
            matrix_calc12.matrix_mas_setval("file7.txt");
            //System.out.println(matrix_calc12.get_det());
            matrix_calc matrix_calc13 = matrix_calc.get_rev_matrix(matrix_calc12);
            //System.out.println(matrix_calc12.matr_toString());
            System.out.println();
            System.out.println(matrix_calc13.matr_toString());*/

            matrix_calc matr1 = new matrix_calc(3,3);
            matrix_calc matr2 = new matrix_calc(3,3);
            matr1.matrix_mas_setval("file9.txt");
            matr2.matrix_mas_setval("file10.txt");
            matrix_calc matr3 = matrix_calc.matrix_add(matr1, matr2);
            matr3.matrix_writer("file11.txt");
            matrix_calc matr4 = matrix_calc.matrix_multiply(matr1, matr2);
            matr4.matrix_writer("file11.txt");
            matrix_calc matr5 = matr1.matrix_multiply_n(3.0);
            matr5.matrix_writer("file11.txt");
            matrix_calc matr6 = matrix_calc.get_rev_matrix(matr1);
            matr6.matrix_writer("file11.txt");
            matrix_calc matr7 = matr1.matrix_transpone();
            matr7.matrix_writer("file11.txt");

            matrix_calc matr8 = matrix_calc.get_rand_matr(3, 6);
            matr8.matrix_writer("file12.txt");

            double[] mas9 = {3.5, -10.25, 400.4, -11, 0, 3};
            matrix_calc matr9 = matrix_calc.get_diag(mas9);
            matr9.matrix_writer("file12.txt");

            matrix_calc matr10 = matrix_calc.matrix_multiply(matr8, matr9);
            matr10.matrix_writer("file12.txt");

            //matrix_calc_immut matr11 = new matrix_calc_immut(5,5);
            matrix_calc_immut matr110 = new matrix_calc_immut(5,5);
            matrix_calc_immut matr11 = new matrix_calc_immut(matr110.get_diag1(5));
            //matr110.get_diag1(5).matrix_writer("file13.txt");
            //matr11 = matr11.get_diag1(5);
            matrix_calc_immut matr12 = new matrix_calc_immut(matr11.matrix_multiply_n(-10.1));
            matr12.matrix_writer("file13.txt");

            matr_gen_el<String> mel1 = new matr_gen_el<>("1");
            matr_gen_el<String> mel2 = new matr_gen_el<>("2");
            matr_gen_el<String> mel3 = new matr_gen_el<>("-5");
            matr_gen_el<String> mel4 = new matr_gen_el<>("10");
            //matr_gen_el<String>[][] matr_gen;
            //matr_gen[0][0] = m_el1;
            matrix_calc_immut matr13 = new matrix_calc_immut(mel1, mel2, mel3, mel4);
            matrix_calc_immut matr14 = matr13.get_rev_matrix(matr13);
            matr13.matrix_writer("file14.txt");
            matr14.matrix_writer("file14.txt");



        }

        catch (Exception exc) {
            System.out.println(exc);
        }

        //System.out.println("Hello world!");
    }
}