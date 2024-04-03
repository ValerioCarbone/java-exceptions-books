package org.experis.books;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int arrayOfBooksLength = 0;

        boolean numberIsValid = false;

        while (!numberIsValid) {
            try {
                System.out.println("How many books do you want to insert into the catalogue?");

                arrayOfBooksLength = Integer.parseInt(scan.nextLine());

                numberIsValid = true;


            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Try again");
            }
        }

        Book[] catalogue = new Book[arrayOfBooksLength];

        for (int i = 0; i < arrayOfBooksLength; i++) {

            String title, author, editor;
            int numberOfPages = 0;

            System.out.println("Insert: Title");

            title = scan.nextLine().trim();

            boolean numberOfPagesIsValid = false;

            while (!numberOfPagesIsValid) {
                try {
                    System.out.println("Insert: Number of pages");

                    numberOfPages = Integer.parseInt(scan.nextLine());

                    numberOfPagesIsValid = true;
                } catch (NumberFormatException e) {
                    System.out.println("The number of pages is invalid");
                }
            }

            System.out.println("Insert: Author");

            author = scan.nextLine().trim();

            System.out.println("Insert: Editor");

            editor = scan.nextLine().trim();

            try {
                Book newBook = new Book(title, numberOfPages, author, editor);

                catalogue[i] = newBook;

                System.out.println("Book added");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

                System.out.println("The book has not been added");

            }


        }

        File books = new File("./Catalogue.txt");

        FileWriter writr = null;

        boolean writingFailure = false;

        try {
            writr = new FileWriter(books);

            for (Book currentBook : catalogue) {
                if (currentBook != null) {
                    writr.write("\nThe title of the book is: " + currentBook.title +
                            "\nThe author of the book is: " + currentBook.author +
                            "\nThe editor of the book is: " + currentBook.editor +
                            "\nThe number of the pages is: " + currentBook.numberOfPages);
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to open file");
            writingFailure = true;
        } finally {
            if (writr != null) {
                try {
                    writr.close();
                } catch (IOException e) {
                    System.out.println("Unable to close file");
                }
            }
        }

        if (!writingFailure) {
            Scanner fileReader = null;
            try {
                fileReader = new Scanner(books);

                while (fileReader.hasNextLine()) {
                    String line = fileReader.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            } finally {
                if (fileReader != null) {
                    fileReader.close();
                }
            }
        }

        scan.close();


    }
}
