package org.experis.books;

public class Book {
    // Variabili

    protected String title, author, editor;
    protected int numberOfPages;

    // Costruttore

    public Book(String title, int numberOfPages, String author, String editor){

        if(title == null || title.isEmpty() || (author == null || author.isEmpty()) || editor == null || editor.isEmpty() ){
            throw new IllegalArgumentException("Title and/or Author and/or Editor is not valid!");
        }

        if(numberOfPages <= 0){
            throw new IllegalArgumentException("The number of pages is not valid!");
        }

        this.title = title;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.editor = editor;

    }

    // Metodi

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        if (title == null) {
            throw new IllegalArgumentException("Title is not valid!");
        } else { this.title = title; }

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {

        if(author == null){
            throw new IllegalArgumentException("Author is not valid!");
        } else { this.author = author; }

    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {

        if(editor == null){
            throw new IllegalArgumentException("Editor is not valid!");
        } else { this.editor = editor; }

    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {

        if(numberOfPages <= 0){
            throw new IllegalArgumentException("The number of pages is not valid!");
        } else { this.numberOfPages = numberOfPages; }

    }
}
