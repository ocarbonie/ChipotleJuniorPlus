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
        String [] meatArr = {"chicken meat","steak meat","carnidas meat","chorizo meat","sofritas meat","veggies no meat"};
        String [] beansArr = {"pinto beans", "black beans", "no beans"};
        String[] salsaArr = {"mild salsa", "medium salsa", "hot salsa", "no salsa", "all salsa"};
        String[] veggiesArr = {"lettuce", "fajita", "all veggies", "no veggies at all"};
        String[] cheeseArr = {"cheese", "no cheese"};
        String[] guacArr = {"guac", "no guac"};
        String[] quesoArr = {"queso", "no queso"};
        String[] sourArr = {"sour cream", "no sour cream"};

        //Here are all the possible ingredients
        burritoAssembler.add(ingOption(riceArr));
        burritoAssembler.add(ingOption(meatArr));
        burritoAssembler.add(ingOption(beansArr));
        burritoAssembler.add(ingOption(salsaArr));
        burritoAssembler.add(ingOption(veggiesArr));
        burritoAssembler.add(ingOption(cheeseArr));
        burritoAssembler.add(ingOption(guacArr));
        burritoAssembler.add(ingOption(quesoArr));
        burritoAssembler.add(ingOption(sourArr));

        //Here are the first five ingredients
        for(int i = 0; i < 5 ; i++){
            firstFive.add(burritoAssembler.get(i));
        }
        System.out.print(firstFive.get(0)+", " + firstFive.get(1) + ", " + firstFive.get(2) +
                ", " + firstFive.get(3) + ", " + firstFive.get(4));

        //how many extra ingredients are we going to have after the original ingredients?
        int randNumber = randomNumber(burritoAssembler.size());  //This will randomly choose how many more ingredients

        //Let's get a list of those extra ingredients
        for (int i = 0; i <randNumber ; i++ ){
            extraIng.add(burritoAssembler.get(i));
        }

        //It wouldn't make sense to have certain extra ingredients, let's remove them.
        cleanup(extraIng);


        //Adding the extra ingredients to the list of ingredients
        for(String s: extraIng){
            System.out.print(", " + s);
        }

        //Cleaning up the firstFive array before asking for the price
        cleanup(firstFive);

        //Let's find the price
        System.out.print("\nPrice of Burrito: " + (burritoPrice(firstFive) + (burritoPrice(extraIng)-3.00)));
    }

    public static String ingOption(String [] m){
        return m[randomNumber(m.length)];
    }

    public static int randomNumber(int bnd){
        Random rnd = new Random();
        return (rnd.nextInt(bnd));
    }

    public static ArrayList cleanup(ArrayList<String>m){
        m.remove("no rice");
        m.remove("no salsa");
        m.remove("no beans");
        m.remove("no queso");
        m.remove("no sour cream");
        m.remove("no cheese");
        m.remove("no guac");
        m.remove("no veggies at all");
        return m;
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

