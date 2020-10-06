package com.company;

public class Main {


        public static int drapeauBicolorAux(int[] t, int i) {
//prérequis :
// t ne contient que des 0 et des 1
// 0 <= i <= t.length
//action :
// modifie t[i..t.length-1] pour placer d’abord tous les 0 puis tous les 1, et
// retourne l’indice du premier 1 dans le nouveau sous tableau t[i..length-1] (et retourne t.length si il n’y a pas de 1)
            if(i==t.length-1){
                int j=0;
                while(j<t.length && t[j] !=1){
                    j++;
                }

                return j;
            }
            else {
                if(t[i]==1){
                    t[i]=0;
                    int d=drapeauBicolorAux(t,i+1)-1;
                    t[d]=1;
                    return d;
                }
                return drapeauBicolorAux(t,i+1);

            }
        }

    void drapeauBicolor(int[] t){
            drapeauBicolorAux(t,0);
    }

    public static int indiceMax(int[]t, int i){
//prérequis : 0<= i < t.length
//action : retourne l’indice du plus grand élément de t[i..t.length-1]
        if(i==t.length-1){
            return i;
        }
        else{
            if(t[i]>t[indiceMax(t,i+1)])
                return i;
            else
                return indiceMax(t,i+1);
        }
    }

    public static void flipAux(int[]t, int i, int j){
//prérequis : 0<= i < t.length
// et 0<= j < t.length
// (mais on impose pas i<=j)
//action : retourne le sous tableau t[i..j]
        if(i<=j){
            if(i!=j){
                int x= t[i];
                t[i]=t[j];
                t[j]=x;
                flipAux(t,i+1,j-1);
            }

        }
    }

    public static void flip(int[]t, int i){
//prérequis : 0<= i < t.length
//action : effectue un flip en i
        flipAux(t,i,t.length-1);
    }

    public static void triPancake(int[]t, int i){
//prérequis : 0<= i < t.length
//action : trie t[i..t.length-1] par ordre décroissant
        if(i!=t.length-1){
            flip(t,indiceMax(t,i));
            flip(t,i);
            triPancake(t,i+1);
        }
    }



    public static void main(String[] args) {
            /*
        int[] t = { 1 , 0 ,1,1,1,0};
        System.out.println( drapeauBicolorAux(t,0));
        for(int i=0;i<t.length;i++)
            System.out.print(" " + t[i]);
             */
        int[] t = {8, 5, 7, 14, 11, 12, 9, 6, 3};
        triPancake(t,0);
        for(int i=0;i<t.length;i++)
            System.out.println(t[i]);
    }
    }

