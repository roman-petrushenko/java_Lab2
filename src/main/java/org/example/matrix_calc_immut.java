package org.example;

import com.google.common.collect.Collections2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static java.lang.Math.round;

final public class matrix_calc_immut implements mcalc_interface<matrix_calc_immut> {
    private final Integer m;
    private final Integer n;
    private final Double[][] matrix_mas;
    matrix_calc_immut() {
        this.matrix_mas = new Double[0][0];
        this.m = 0;
        this.n = 0;
    }

    matrix_calc_immut(int m1, int n1, double[][] mas_m) {
        this.m = m1;
        this.n = n1;
        this.matrix_mas = new Double[m1][n1];
        for(int ik = 0; ik<m; ik+=1){
            for(int jk = 0; jk<n; jk+=1){
                this.matrix_mas[ik][jk] = mas_m[ik][jk];

            }
        }
    }
    matrix_calc_immut(int m1, int n1) {
        this.m = m1;
        this.n = n1;
        this.matrix_mas = new Double[m1][n1];
    }

    matrix_calc_immut(matrix_calc_immut matr1) {
        this.m = matr1.m;
        this.n = matr1.n;
        this.matrix_mas = matr1.matrix_mas;
    }
    matrix_calc_immut(matrix_calc matr1) {
        this.m = matr1.matrix_mas_get().length;
        this.n = matr1.matrix_mas_get()[0].length;
        this.matrix_mas = new Double[m][n];
        for (int i = 0; i<m; i+=1)
            for (int j = 0; j<n; j+=1)
            {
                this.matrix_mas[i][j] = matr1.matrix_mas_get()[i][j];

            }

        //this.matrix_mas = matr1.matrix_mas_get();
    }
    /*<T11>matrix_calc_immut(matr_gen_el<T11>[][] gen_el_mas, int m11, int n11){
        this.m = m11;
        this.n = n11;
        this.matrix_mas = new Double[m11][n11];
        for (int i20 = 0; i20<m11; i20+=1){
            for (int j20 = 0; j20<n11; j20+=1){
                this.matrix_mas[i20][j20] = gen_el_mas[i20][j20].get_numeric_format(gen_el_mas[i20][j20].m_el1);
            }

        }
    }*/
    <S1,S2,S3,S4>matrix_calc_immut(matr_gen_el<S1> g1, matr_gen_el<S2> g2, matr_gen_el<S3> g3, matr_gen_el<S4> g4){
        this.matrix_mas = new Double[2][2];
        this.m = (Integer)2;
        this.n = (Integer)2;
        matrix_mas[0][0] = g1.get_numeric_format(g1.m_el1);
        matrix_mas[0][1] = g2.get_numeric_format(g2.m_el1);
        matrix_mas[1][0] = g3.get_numeric_format(g3.m_el1);
        matrix_mas[1][1] = g4.get_numeric_format(g4.m_el1);
    }
  
    //public int matrix_mas_set(double[][] matr_mas)
    public Double[][] matrix_mas_get() {
        return this.matrix_mas;
    }
    public Double[] matrix_mas_get_row(int n_r) {
        return this.matrix_mas[n_r];
    }
    public double[] matrix_mas_get_column(int n_col) {
        double[]col = new double[this.m];
        for (int ic = 0; ic<m;ic+=1)
        {
            col[ic] = this.matrix_mas[ic][n_col];
        }
        return col;
    }

    public String dsize_get(matrix_calc_immut matr) {
        return (((Integer) this.m).toString() + "x" + ((Integer) this.n).toString());
    }

    /*public int matrix_mas_setval(String path1) {
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
                j += 1;
                line1 = bufferedreader.readLine();

            }
            bufferedreader.close();
            filereader.close();
            j = 0;

            System.out.println("Your entered matrix:\n");
            for (int i1 = 0; i1 < m; i1 += 1) {
                for (int j1 = 0; j1 < n; j1 += 1) {
                    System.out.print(this.matrix_mas[i1][j1] + " ");
                }
                System.out.println("");
            }

        } catch (FileNotFoundException exc) {
            System.out.println(exc);
        } catch (IOException exc) {
            System.out.println(exc);
        }
        return 0;
    }*/

    public String matr_toString() {
        String str11 = "";
        for (int i1 = 0; i1 < m; i1 += 1) {
            for (int j1 = 0; j1 < n - 1; j1 += 1) {
                str11 = str11 + ((Double) this.matrix_mas[i1][j1]).toString() + " ";
            }
            str11 = str11 + ((Double) this.matrix_mas[i1][n - 1]).toString() + "\n";
        }
        str11 = str11.substring(0, str11.length() - 1);
        return str11;
    }

    public matrix_calc_immut matrix_multiply_n(double k) {
        double[][] mas_m1 = new double[m][n];
        //matrix_calc_immut matr1 = new matrix_calc_immut(m, n);
        for (int i2 = 0; i2 < m; i2 += 1) {
            for (int j2 = 0; j2 < n; j2 += 1) {
                mas_m1[i2][j2] = this.matrix_mas[i2][j2] * k;
            }
        }
        matrix_calc_immut matr1 = new matrix_calc_immut(m, n, mas_m1);
        return matr1;
    }
    //@Override
    public matrix_calc_immut matrix_add(matrix_calc_immut matr1, matrix_calc_immut matr2) {
        double[][] mas_m1 = new double[m][n];
        if ((matr1.m != matr2.m) || (matr1.n != matr2.n)) {
            matrix_calc_immut matr0 = new matrix_calc_immut();
            return matr0;
        }
        //matrix_calc_immut matr3 = new matrix_calc_immut(matr1.m, matr1.n);
        for (int i2 = 0; i2 < matr1.m; i2 += 1) {
            for (int j2 = 0; j2 < matr1.n; j2 += 1) {
                mas_m1[i2][j2] = matr1.matrix_mas[i2][j2] + matr2.matrix_mas[i2][j2];
            }
        }
        matrix_calc_immut matr3 = new matrix_calc_immut(matr1.m, matr1.n, mas_m1);
        return matr3;
    }

    public matrix_calc_immut matrix_transpone() {
        double[][] mas_m1 = new double[m][n];
        //matrix_calc_immut matr_t = new matrix_calc_immut(this.n, this.m);
        for (int i4 = 0; i4 < m; i4 += 1) {
            for (int j4 = 0; j4 < m; j4 += 1) {
                //matr_t.matrix_mas[j4][i4] = this.matrix_mas[i4][j4];
                mas_m1[j4][i4] = this.matrix_mas[i4][j4];
            }
        }
        matrix_calc_immut matr_t = new matrix_calc_immut(this.n, this.m, mas_m1);
        return matr_t;
    }

    public matrix_calc_immut matrix_multiply(matrix_calc_immut matr1, matrix_calc_immut matr2) {
        double[][] mas_m1 = new double[m][n];
        //matrix_calc_immut matr3 = new matrix_calc_immut(matr1.m, matr1.n);
        //matrix_calc_immut matr2_t = new matrix_calc_immut(matr2.matrix_transpone());
        for (int i5 = 0; i5 < matr1.m; i5 += 1) {
            for (int j5 = 0; j5 < matr2.n; j5 += 1) {
                double k1 = 0;
                for (int i55 = 0; i55 < matr1.n; i55 += 1) {
                    k1 += matr1.matrix_mas[i5][i55] * matr2.matrix_mas[i55][j5];
                }
                //matr3.matrix_mas[i5][j5] = k1;
                mas_m1[i5][j5] = k1;
            }
        }
        matrix_calc_immut matr3 = new matrix_calc_immut(matr1.m, matr1.n, mas_m1);
        return matr3;
    }

    public int matrix_writer(String path2) {
        try {
            //File file2 = new File(path2);
            FileWriter filewriter = new FileWriter(path2, true);
            //BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
            filewriter.write(this.matr_toString());
            //filewriter.append("")
            filewriter.write("\n\n\n");
            filewriter.close();
        } catch (IOException exc) {
            System.out.println(exc);
        }
        return 0;
    }

    //@Override
    public boolean equals(matrix_calc_immut matr6){
    try{
        if ((this.m != matr6.m) || (this.n != matr6.n)) {
            return false;
        }

        for (int i6 = 0; i6 < m; i6 += 1) {
            for (int j6 = 0; j6 < n; j6 += 1) {
                if (this.matrix_mas[i6][j6] != matr6.matrix_mas[i6][j6]) {
                    return false;
                }
            }
        }
        return true;
    }
    catch (Exception exc10){
        return false;
    }
    }

    @Override
    public int hashCode() {
        double k3 = 0.0;
        for (int i7 = 0; i7 < this.m; i7 += 1) {
            for (int j7 = 0; j7 < this.n; j7 += 1) {
                k3 += this.matrix_mas[i7][j7];
            }
        }
        int k31 = Math.round((float) k3);
        return k31;
    }

    //public matrix_calc_immut get_diag(double[] mas3)
    public matrix_calc_immut get_diag(double[] mas3) {
        double[][] mas_m1 = new double[mas3.length][mas3.length];
        //matrix_calc_immut matr7 = new matrix_calc_immut(mas3.length, mas3.length);
        for (int i73 = 0; i73 < mas3.length; i73 += 1) {
            //matr7.matrix_mas[i73][i73] = mas3[i73];
            mas_m1[i73][i73] = mas3[i73];
        }
        matrix_calc_immut matr7 = new matrix_calc_immut(mas3.length, mas3.length, mas_m1);
        return matr7;
    }

     public matrix_calc_immut get_diag1(int n1) {
        double[][] mas_m = new double[n1][n1];
        //matrix_calc_immut matr8 = new matrix_calc_immut((Integer)n1, (Integer) n1);
        for (int i8 = 0; i8 < n1; i8 += 1) {
            //matr8.matrix_mas[i8][i8] = 1.0;
            mas_m[i8][i8]= 1.0;
        }
        matrix_calc_immut matr8 = new matrix_calc_immut((Integer)n1, (Integer) n1, mas_m);
        return matr8;
    }

     public matrix_calc_immut get_rand_matr(int m2, int n2) {
        double[][] mas_m1 = new double[m2][n2];
        //matrix_calc_immut matr9 = new matrix_calc_immut(m2, n2);
        Random rand = new Random();
        for (int i9 = 0; i9 < m2; i9 += 1) {
            for (int j9 = 0; j9 < n2; j9 += 1) {
                mas_m1[i9][j9] = (double) round(200.0 * (rand.nextDouble() - 0.5));
            }
        }
        matrix_calc_immut matr9 = new matrix_calc_immut(m2, n2, mas_m1);
        return matr9;
    }

    public matrix_calc_immut matr_strip(matrix_calc_immut matr_1, int m3, int n3) {
        double[][] mas_m1 = new double[matr_1.m][matr_1.n];
        //  matrix_calc_immut matr10 = new matrix_calc_immut(matr_1.m - 1, matr_1.n - 1);
        int i10 = 0;
        int j10 = 0;
        int i11 = 0;
        int j11 = 0;
        for (Double[] t11 : matr_1.matrix_mas) {
            if (i10 == m3) {
                i10 += 1;
                continue;
            }
            //i10-=1;
            for (double t12 : t11) {
                if (j10 == n3) {
                    j10 += 1;
                    continue;
                }
                //j10-=1;
                //matr10.matrix_mas[i11][j11] = t12;
                mas_m1[i11][j11] = t12;
                //System.out.println();
                j11 += 1;
                j10 += 1;
                //j10+=2;
            }
            j11 = 0;
            j10 = 0;
            i11 += 1;
            i10 += 1;
            //i10+=2;
        }
        matrix_calc_immut matr10 = new matrix_calc_immut(matr_1.m - 1, matr_1.n - 1, mas_m1);
        return matr10;
    }

    public double get_det() {
        //Integer[] d = new Integer[this.m];
        // Collection<Double> ArrayList;
        ArrayList<Integer> d2 = new ArrayList<>();
        //Collections.
        for (int i = 0; i < m; i += 1) {
            d2.add(i);
            //d[i] = i;
        }
        //Collections2.permutations()
        Collection<List<Integer>> d1 = Collections2.permutations(d2);
        double det1 = 0;
        for (List<Integer> a1 : d1) {
            double l1 = 1.0;
            int p1 = 0;
            for (int i11 = 0; i11 < m; i11 += 1) {
                for (int i111 = i11 + 1; i111 < m; i111 += 1) {
                    if (a1.get(i11) > a1.get(i111)) {
                        p1 += 1;
                    }
                }
                //a1.subList(i11,m-1);
            }
            for (int j = 0; j < n; j += 1) {
                l1 *= this.matrix_mas[j][a1.get(j)];


            }
            det1 += Math.pow(-1, p1 % 2) * l1;
        }
        return det1;}
    public matrix_calc_immut get_rev_matrix(matrix_calc_immut matr11){
        double[][] mas_m1 = new double[matr11.m][matr11.n];
        //matrix_calc_immut matr12 = new matrix_calc_immut(matr11.m, matr11.n);
        double det_matr11 = matr11.get_det();
        for (int i15 = 0; i15<matr11.m; i15+=1){
            for (int j15=0; j15<matr11.n; j15+=1){
                //double det_matr11 = matr11.get_det();
                matrix_calc_immut matr11_1 = matr11.matr_strip(matr11, i15, j15);
                //matr12.matrix_mas[i15][j15] = Math.pow(-1, (i15+j15)%2)*matr11_1.get_det()/det_matr11;
                //matrix_calc_immut matr120 matr12
                mas_m1[i15][j15] = Math.pow(-1, (i15+j15)%2)*matr11_1.get_det()/det_matr11;
            }
        }
        matrix_calc_immut matr12 = new matrix_calc_immut(matr11.m, matr11.n, mas_m1);
        matrix_calc_immut matr120 = new matrix_calc_immut(matr12.matrix_transpone());
        return matr120;}
}
