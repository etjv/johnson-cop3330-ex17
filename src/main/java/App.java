/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Edmund Johnson V
 */

/*
Sometimes you have to perform a more complex calculation based on some provided inputs and then use that result to make a determination.

Create a program that prompts for your weight, gender, number of drinks, the amount of alcohol by volume of the drinks consumed (as a percent), and the amount of time since your last drink. Calculate your blood alcohol content (BAC) using this formula

BAC = (A × 5.14 / W × r) − .015 × H
where

A = (number of drinks * alcohol by volume) is total alcohol consumed, in ounces (oz).
W is body weight in pounds.
r is the alcohol distribution ratio:
0.73 for men
0.66 for women
H is number of hours since the last drink.
Display whether or not it’s legal to drive by comparing the blood alcohol content to 0.08.

Example Output
Your BAC is 0.08
It is not legal for you to drive.
Constraint
Prevent the user from entering non-numeric values.
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] arg){
        float weight = getWeight();
        int gender = getGender();
        float drinks = getDrinks();
        float abv = getABV();
        float hours = getHours();
        System.out.println(canYouDrive(weight, gender, drinks, abv, hours));

    }

    private static float getWeight(){
        System.out.print("What is your weight? ");
        String x = in.nextLine();
        return Float.parseFloat(x.replace(" ", ""));
    }

    private static int getGender(){
        System.out.print("What is your gender? ");
        String x = in.nextLine();
        if(x.equals("man")){
            return 1;
        }
        else if(x.equals("woman")){
            return 0;
        }
        else{
            System.out.println("Enter a valid gender (man/woman)");
            return getGender();
        }
    }

    private static float getDrinks(){
        System.out.print("How many drinks have you had? ");
        String x = in.nextLine();
        return Float.parseFloat(x.replace(" ", ""));
    }

    private static float getABV(){
        System.out.print("What is the ABV of the drinks you have been drinking? ");
        String x = in.nextLine();
        return Float.parseFloat(x.replace(" ", ""));
    }

    private static float getHours(){
        System.out.print("How many hours has it been since your last alcoholic beverage? ");
        String x = in.nextLine();
        return Float.parseFloat(x.replace(" ", ""));
    }

    private static String canYouDrive(float w, int g, float d, float abv, float h){
        double bac;
        DecimalFormat dc = new DecimalFormat("0.00");
        if(g == 1){
            bac = ((d * (abv)) / (w * 0.73)) + (-0.015 * h);
        }
        else{
            bac = ((d * (abv)) / (w * 0.66)) + (-0.015 * h);
        }
        return bac >= 0.08
                ? "Your BAC is " + dc.format(bac) + "\nIt is legal for you to drive."
                : "Your BAC is " + dc.format(bac) + "\nIt is not legal for you to drive.";
    }
}
