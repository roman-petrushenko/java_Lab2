package org.example;
import com.google.common.collect.Collections2;

import java.io.*;
//import java.util.Collection;
import java.util.*;

import static java.lang.Math.round;
//import com.google.common.collect.Collections2;
//import java.util.Scanner;

public class matrix_calc {
    private int m;
    private int n;
    private double[][] matrix_mas;

    matrix_calc() {
        this.matrix_mas = new double[0][0];
        this.m = 0;
        this.n = 0;
    }

    matrix_calc(int m1, int n1) {
        this.m = m1;
        this.n = n1;
        this.matrix_mas = new double[m1][n1];
    }

    matrix_calc(matrix_calc matr1) {
        this.m = matr1.m;
        this.n = matr1.n;
        this.matrix_mas = matr1.matrix_mas;
    }

    public double[][] matrix_mas_get() {
        return this.matrix_mas;
    }
    public double[] matrix_mas_get_row(int n_r) {
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


    public int matrix_mas_set(double[][] matr_mas) {
        this.matrix_mas = matr_mas;
        this.m = matrix_mas.length;
        this.n = matrix_mas[0].length;
        return 0;
    }

    public String dsize_get(matrix_calc matr) {
        return (((Integer) this.m).toString() + "x" + ((Integer) this.n).toString());
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
    }

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

    public matrix_calc matrix_multiply_n(double k) {
        matrix_calc matr1 = new matrix_calc(m, n);
        for (int i2 = 0; i2 < m; i2 += 1) {
            for (int j2 = 0; j2 < n; j2 += 1) {
                matr1.matrix_mas[i2][j2] = this.matrix_mas[i2][j2] * k;
            }
        }
        return matr1;
    }

    public static matrix_calc matrix_add(matrix_calc matr1, matrix_calc matr2) {
        if ((matr1.m != matr2.m) || (matr1.n != matr2.n)) {
            matrix_calc matr0 = new matrix_calc();
            return matr0;
        }
        matrix_calc matr3 = new matrix_calc(matr1.m, matr1.n);
        for (int i2 = 0; i2 < matr1.m; i2 += 1) {
            for (int j2 = 0; j2 < matr1.n; j2 += 1) {
                matr3.matrix_mas[i2][j2] = matr1.matrix_mas[i2][j2] + matr2.matrix_mas[i2][j2];
            }
        }
        return matr3;
    }

    public matrix_calc matrix_transpone() {
        matrix_calc matr_t = new matrix_calc(this.n, this.m);
        for (int i4 = 0; i4 < m; i4 += 1) {
            for (int j4 = 0; j4 < m; j4 += 1) {
                matr_t.matrix_mas[j4][i4] = this.matrix_mas[i4][j4];
            }
        }
        return matr_t;
    }

    public static matrix_calc matrix_multiply(matrix_calc matr1, matrix_calc matr2) {

        matrix_calc matr3 = new matrix_calc(matr1.m, matr1.n);
        //matrix_calc matr2_t = new matrix_calc(matr2.matrix_transpone());
        for (int i5 = 0; i5 < matr1.m; i5 += 1) {
            for (int j5 = 0; j5 < matr2.n; j5 += 1) {
                double k1 = 0;
                for (int i55 = 0; i55 < matr1.n; i55 += 1) {
                    k1 += matr1.matrix_mas[i5][i55] * matr2.matrix_mas[i55][j5];
                }
                matr3.matrix_mas[i5][j5] = k1;
            }
        }
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
    public boolean equals(matrix_calc matr6) {
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

    //public matrix_calc get_diag(double[] mas3)
    static public matrix_calc get_diag(double[] mas3) {
        matrix_calc matr7 = new matrix_calc(mas3.length, mas3.length);
        for (int i73 = 0; i73 < matr7.m; i73 += 1) {
            matr7.matrix_mas[i73][i73] = mas3[i73];
        }
        return matr7;
    }

    static public matrix_calc get_diag1(int n1) {
        matrix_calc matr8 = new matrix_calc(n1, n1);
        for (int i8 = 0; i8 < matr8.m; i8 += 1) {
            matr8.matrix_mas[i8][i8] = 1.0;
        }
        return matr8;
    }

    static public matrix_calc get_rand_matr(int m2, int n2) {
        matrix_calc matr9 = new matrix_calc(m2, n2);
        Random rand = new Random();
        for (int i9 = 0; i9 < matr9.m; i9 += 1) {
            for (int j9 = 0; j9 < matr9.n; j9 += 1) {
                matr9.matrix_mas[i9][j9] = round(200.0 * (rand.nextDouble() - 0.5));
            }
        }
        return matr9;
    }

    public matrix_calc matr_strip(matrix_calc matr_1, int m3, int n3) {
        matrix_calc matr10 = new matrix_calc(matr_1.m - 1, matr_1.n - 1);
        int i10 = 0;
        int j10 = 0;
        int i11 = 0;
        int j11 = 0;
        for (double[] t11 : matr_1.matrix_mas) {
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
                matr10.matrix_mas[i11][j11] = t12;
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
        public static matrix_calc get_rev_matrix(matrix_calc matr11){
        matrix_calc matr12 = new matrix_calc(matr11.m, matr11.n);
        double det_matr11 = matr11.get_det();
        for (int i15 = 0; i15<matr11.m; i15+=1){
            for (int j15=0; j15<matr11.n; j15+=1){
                //double det_matr11 = matr11.get_det();
                matrix_calc matr11_1 = matr11.matr_strip(matr11, i15, j15);
                matr12.matrix_mas[i15][j15] = Math.pow(-1, (i15+j15)%2)*matr11_1.get_det()/det_matr11;
                //matrix_calc matr120 matr12
            }
        }
        matrix_calc matr120 = matr12.matrix_transpone();
        return matr120;}

        }



    


    


















