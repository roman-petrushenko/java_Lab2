package org.example;
import java.io.*;
//import java.util.Scanner;

public class matrix_calc {
    private int m;
    private int n;
    private double[][] matrix_mas;

    matrix_calc(){
        this.matrix_mas = new double[0][0];
        this.m = 0;
        this.n = 0;
    }
    matrix_calc(int m1, int n1){
        this.m = m1;
        this.n = n1;
        this.matrix_mas = new double[m1][n1];
    }
    matrix_calc(matrix_calc matr1){
        this.m = matr1.m;
        this.n = matr1.n;
        this.matrix_mas = matr1.matrix_mas;
    }

    public double[][] matrix_mas_get(){
        return this.matrix_mas;
    }
    public int matrix_mas_set(double[][] matr_mas){
        this.matrix_mas = matr_mas;
        this.m = matrix_mas.length;
        this.n = matrix_mas[0].length;
        return 0;}
    public String dsize_get(matrix_calc matr){
        return (((Integer)this.m).toString()+ "x" + ((Integer)this.n).toString());
    }
    public int matrix_mas_setval(String path1) {
        try {
            //Scanner scanner = new Scanner(System.in);
            File file1 = new File(path1);
            FileReader filereader = new FileReader(file1);
            BufferedReader bufferedreader = new BufferedReader(filereader);
            String line1;
            double[] mas1;
            String[] mas2;
            int j = 0;
            line1 = bufferedreader.readLine();
            while (line1 != null) {
                mas2 = line1.split(" ");
                mas1 = new double[mas2.length];
                for (int i = 0; i < mas2.length; i += 1) {
                    mas1[i] = Double.parseDouble(mas2[i]);
                    this.matrix_mas[j][i] = mas1[i];
                    //System.out.print(this.matrix_mas[j][i]+" ");
                }
                j+=1;
                line1 = bufferedreader.readLine();

            }
            bufferedreader.close();
            filereader.close();
            j = 0;

            System.out.println("Your entered matrix:\n");
            for (int i1 = 0; i1<m; i1+=1){
                for (int j1 = 0; j1<n; j1+=1){
                    System.out.print(this.matrix_mas[i1][j1]+" ");
                }
                System.out.println("");
            }

        } catch (FileNotFoundException exc) {
            System.out.println(exc);
        } catch (IOException exc) {
            System.out.println(exc);}
    return 0;}

    public String matr_toString() {
        String str11 = "";
        for (int i1 = 0; i1 < m; i1 += 1) {
            for (int j1 = 0; j1 < n - 1; j1 += 1) {
                str11 = str11 + ((Double) this.matrix_mas[i1][j1]).toString() + " ";
            }
            str11 = str11 + ((Double) this.matrix_mas[i1][n - 1]).toString() + "\n";
        }
        return str11;
    }
    public matrix_calc matrix_multiply_n(double k){
        matrix_calc matr1 = new matrix_calc(m, n);
        for (int i2 = 0; i2<m; i2+=1){
            for (int j2 = 0; j2<n; j2+=1){
                matr1.matrix_mas[i2][j2] = this.matrix_mas[i2][j2]*k;}
            }
        return matr1;
        }
    public static matrix_calc matrix_add(matrix_calc matr1, matrix_calc matr2){
        if ((matr1.m != matr2.m) || (matr1.n != matr2.n)){
            matrix_calc matr0 = new matrix_calc();
            return matr0;
        }
        matrix_calc matr3 = new matrix_calc(matr1.m, matr1.n);
        for (int i2 = 0; i2<matr1.m; i2+=1){
            for (int j2 = 0; j2<matr1.n; j2+=1){
                matr3.matrix_mas[i2][j2] = matr1.matrix_mas[i2][j2] + matr2.matrix_mas[i2][j2];}
        }
        return matr3;
    }

    public matrix_calc matrix_transpone(){
        matrix_calc matr_t = new matrix_calc(this.n, this.m);
        for (int i4 = 0; i4<m; i4+=1){
            for (int j4 = 0; j4<m; j4+=1){
                matr_t.matrix_mas[j4][i4] = this.matrix_mas[i4][j4];
            }
        }
        return matr_t;
    }
    public static matrix_calc matrix_multiply(matrix_calc matr1, matrix_calc matr2){

        matrix_calc matr3 = new matrix_calc(matr1.m, matr1.n);
        //matrix_calc matr2_t = new matrix_calc(matr2.matrix_transpone());
        for (int i5 = 0; i5<matr1.m; i5+=1){
            for (int j5 = 0; j5<matr2.n; j5+=1){
                double k1 = 0;
                for (int i55 = 0; i55< matr1.n; i55+=1){
                    k1 += matr1.matrix_mas[i5][i55]*matr2.matrix_mas[i55][j5];
                }
                matr3.matrix_mas[i5][j5] = k1;
                }
            }
        return matr3;}

    }

















