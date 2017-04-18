package fr.android.androidexercises;

// TODO use parcel

class Book {

    private String name;
    private String author;

    Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    String getAuthor() {
        return author;
    }
}
