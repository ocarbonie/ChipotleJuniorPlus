package com.company;

import java.util.Random;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        for(int i = 0; i < 25; i++){
            System.out.print("\n\nBurrito " + (i+1) + ": ");
            burritoMaker();
        }

    }

    public static void burritoMaker(){
        //variables
        ArrayList<String> firstFive = new ArrayList<>();
        ArrayList<String>burritoAssembler = new ArrayList<>();
        ArrayList<String> extraIng = new ArrayList<>();
        String [] riceArr = {"white rice", "brown rice", "no rice"};

        //This is an ArrayList of all the possible ingredients
        //Let's get the rice option
        burritoAssembler.add(riceOptions());

        //Let's get the meat option
        burritoAssembler.add(meatOptions());

        //Let's get the beans option
        burritoAssembler.add(beansOptions());

        //Let's get the Salsa option
        burritoAssembler.add(salsaOptions());

        //Let's get the Veggies option
        burritoAssembler.add(veggiesOptions());

        //Let's get the cheese option
        burritoAssembler.add(cheeseOptions());

        //Let's get the queso option
        burritoAssembler.add(quesoOptions());

        //Let's get the  guac option
        burritoAssembler.add(guacOptions());

        //Let's get the sour cream option
        burritoAssembler.add(sourCreamOptions());

        //This is the first five ingredients of the burrito; I'll put them in their own arrayList
        String A = riceOptions();
        String B = meatOptions();
        String C = beansOptions();
        String D = salsaOptions();
        String E = veggiesOptions();


        firstFive.add(A);
        firstFive.add(B);
        firstFive.add(C);
        firstFive.add(D);
        firstFive.add(E);

        System.out.print(A +", " + B + ", " + C + ", " + D + ", " + E);

        //how many extra ingredients are we going to have after the original ingredients?
        int randNumber = randomNumber(burritoAssembler.size());  //This will randomly choose how many more ingredients

        for (int i = 0; i<randNumber ; i++ ){
            extraIng.add(burritoAssembler.get(randomNumber(randNumber)));
            extraIng.remove("no rice");
            extraIng.remove("no salsa");
            extraIng.remove("no beans");
            extraIng.remove("no queso");
            extraIng.remove("no sour cream");
            extraIng.remove("no cheese");
            extraIng.remove("no guac");
            extraIng.remove("no veggies at all");
        }

        //Adding the extra ingredients to the list of ingredients
        for(String s: extraIng){
            System.out.print(", " + s);
        }

        //pricing
        firstFive.remove("no rice");
        firstFive.remove("no salsa");
        firstFive.remove("no beans");
        firstFive.remove("no queso");
        firstFive.remove("no sour cream");
        firstFive.remove("no cheese");
        firstFive.remove("no guac");
        firstFive.remove("no veggies at all");
        System.out.print("\nPrice of Burrito: " + (burritoPrice(firstFive) + (burritoPrice(extraIng)-3.00)));
    }

    public static String riceOptions(){
        String [] riceArr = {"white rice", "brown rice", "no rice"};
        return riceArr[randomNumber(riceArr.length)];

    }

    public static String meatOptions(){
        String [] meatArr = {"chicken meat","steak meat","carnidas meat","chorizo meat","sofritas meat","veggies no meat"};
        return meatArr[randomNumber(meatArr.length)];
    }

    public static String beansOptions(){
        String [] beansArr = {"pinto beans", "black beans", "no beans"};
        return beansArr[randomNumber(beansArr.length)];
    }

    public static String salsaOptions() {
        String[] salsaArr = {"mild salsa", "medium salsa", "hot salsa", "no salsa", "all salsa"};
        return salsaArr[randomNumber(salsaArr.length)];
    }

    public static String veggiesOptions() {
        String[] veggiesArr = {"lettuce", "fajita", "all veggies", "no veggies at all"};
        return veggiesArr[randomNumber(veggiesArr.length)];
    }
    public static String cheeseOptions() {
        String[] cheeseArr = {"cheese", "no cheese"};
        return cheeseArr[randomNumber(cheeseArr.length)];
    }

    public static String guacOptions() {
        String[] guacArr = {"guac", "no guac"};
        return guacArr[randomNumber(guacArr.length)];
    }

    public static String quesoOptions() {
        String[] quesoArr = {"queso", "no queso"};
        return quesoArr[randomNumber(quesoArr.length)];
    }

    public static String sourCreamOptions() {
        String[] quesoArr = {"sour cream", "no sour cream"};
        return quesoArr[randomNumber(quesoArr.length)];
    }

    public static int randomNumber(int bnd){
        Random rnd = new Random();
        return (rnd.nextInt(bnd));
    }

    public static double burritoPrice(ArrayList<String>m){
        double price = (3.00 + (m.size() * 0.50));

        if (m.equals("no rice"))
            price-= 0.50;

        if(m.equals("no salsa"))
            price-= 0.50;

        if(m.equals("no beans"))
            price-= 0.50;

        if(m.equals("no queso"))
            price-= 0.50;

        if(m.equals("no sour cream"))
            price-= 0.50;

        if(m.equals("no cheese"))
            price-= 0.50;

        if(m.equals("no guac"))
            price-= 0.50;

        if(m.equals("no veggies at all"))
            price-= 0.50;

        return price;
    }

}

