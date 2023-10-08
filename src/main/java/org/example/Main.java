package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try{
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
        matrix_calc matrix_calc11 = new matrix_calc(4,4);
        matrix_calc matrix_calc22 = new matrix_calc(4,4);
        matrix_calc11.matrix_mas_setval("file1.txt");
        matrix_calc22.matrix_mas_setval("file3.txt");
        matrix_calc matrix_calc33 = matrix_calc.matrix_multiply(matrix_calc11, matrix_calc22);
        System.out.println("\n"+matrix_calc33.matr_toString());
        //matrix_calc11.matrix_mas_setval("file1.txt");
            //matrix_calc11.matrix_mas_setval("file1.txt");
        //matrix_calc matrix_calc44 = matrix_calc11.matrix_multiply_n(5.0);
        //matrix_calc44.matrix_mas_setval("file1.txt");
            matrix_calc matrix_calc44 = matrix_calc.matrix_add(matrix_calc11, matrix_calc33);
            System.out.println("\n"+matrix_calc44.matr_toString());
        }
        catch (Exception exc) {
            System.out.println(exc);
        }

        //System.out.println("Hello world!");
    }
}