package org.experis.books;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int arrayOfBooksLength = 0;

        boolean numberIsValid = false;

        while (!numberIsValid)  {
            try{
                System.out.println("How many books do you want to insert into the catalogue?");

                arrayOfBooksLength = Integer.parseInt(scan.nextLine());

                numberIsValid = true;


            }
            catch(NumberFormatException e) {
                System.out.println("Invalid number! Try again");
            }
        }

        Book[] catalogue = new Book[arrayOfBooksLength];

        for ( int i = 0; i < arrayOfBooksLength; i++ ){

        String title,author,editor;
        int numberOfPages;

            System.out.println("Insert: Title");

            title = scan.nextLine().trim();

            System.out.println("Insert: Number of pages");

            numberOfPages = Integer.parseInt(scan.nextLine());

            System.out.println("Insert: Author");

            author = scan.nextLine().trim();

            System.out.println("Insert: Editor");

            editor = scan.nextLine().trim();

            try{
                Book newBook = new Book(title,numberOfPages,author,editor);

                catalogue[i] = newBook;

                System.out.println("Book added");
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }


        }

        scan.close();


    }
}
