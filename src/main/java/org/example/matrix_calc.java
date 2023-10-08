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
    public int matrix_mas_setval() {
        try {
            //Scanner scanner = new Scanner(System.in);
            File file1 = new File("file1.txt");
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














}
