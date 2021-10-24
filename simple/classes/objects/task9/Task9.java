package by.epam.module4.simple.classes.objects.task9;

//Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
//метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
//методами. Задать критерии выбора данных и вывести эти данные на консоль.
//Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
//Найти и вывести:
//a) список книг заданного автора;
//b) список книг, выпущенных заданным издательством;
//c) список книг, выпущенных после заданного года.

import java.util.Arrays;

public class Task9 {
    public static void main(String[] args) {
        Author author = new Author("King", "Stephen");
        Author author1 = new Author("Bulgakov", "Mikhail");
        Author author2 = new Author("Wilde", "Oscar");
        Author author3 = new Author("Ivanov", "Ivan");
        Author author4 = new Author("Petrov", "Petr");


        Book book = new Book(1, "Green Mile", new Author[]{author}, "Publishing Association",
                1996, 300, 500, "Simple-Value Bindings");
        Book book1 = new Book(2, "Master and Margarita", new Author[]{author1}, "Moskow Publishing house",
                1940, 500, 1000, "Multiple-Value Bindings");
        Book book2 = new Book(3, "Portrait of Dorian Gray", new Author[]{author2}, "Publishing Association",
                1890, 400, 600, "Simple-Value Bindings");
        Book book3 = new Book(4, "Ivanovo", new Author[]{author3}, "Ivanov House",
                2020, 100, 50, "Simple-Value Bindings");
        Book book4 = new Book(5, "Petrovshino", new Author[]{author4}, "Petrov Press",
                2021, 95, 70, "Simple-Value Bindings");
        Book book5 = new Book(5, "City", new Author[]{author3, author4}, "Ivanov House",
                2021, 10, 10, "Simple-Value Bindings");

        Book[] books = new Book[6];
        books[0] = book;
        books[1] = book1;
        books[2] = book2;
        books[3] = book3;
        books[4] = book4;
        books[5] = book5;

        ArrayBooks arrayBooks = new ArrayBooks(books);

        System.out.println("Books of: " + author4 + "\n" + arrayBooks.findBooksOfAuthor(author4).toString());

        System.out.println();

        System.out.println("Books of: Publishing Association" + "\n" + arrayBooks.findBooksOfPublishingHouse("Publishing Association").toString());

        System.out.println();

        System.out.println("Books after year: 2000" + "\n" + arrayBooks.findBooksPublishedAfterYear(2000).toString());
    }
}

class Book {
    private int id;
    private String title;
    private Author[] authors;
    private String publishingHouse;
    private int yearOfPublication;
    private int numberOfPages;
    private double price;
    private String typeOfBinding;

    public Book(int id, String title, Author[] authors, String publishingHouse, int yearOfPublication,
                int numberOfPages, double price, String typeOfBinding) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.publishingHouse = publishingHouse;
        this.yearOfPublication = yearOfPublication;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.typeOfBinding = typeOfBinding;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthor(Author[] authors) {
        this.authors = authors;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTypeOfBinding() {
        return typeOfBinding;
    }

    public void setTypeOfBinding(String typeOfBinding) {
        this.typeOfBinding = typeOfBinding;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors='" + Arrays.toString(authors) + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", numberOfPages=" + numberOfPages +
                ", price=" + price +
                ", typeOfBinding='" + typeOfBinding + '\'' +
                '}';
    }
}

class Author {
    private final String surName;
    private final String name;
    private int age;

    public Author(String surName, String name) {
        this.surName = surName;
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return surName + " " + name;
    }
}

class ArrayBooks {
    Book[] books;

    public ArrayBooks(Book[] books) {
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "ArrayBooks{" +
                "books=" + Arrays.toString(books) +
                '}';
    }

    public ArrayBooks findBooksOfAuthor(Author author) {
        int length = 0;
        for (Book book : books) {
            for (Author author1 : book.getAuthors())
                if (author.equals(author1)) {
                    length++;
                }
        }
        Book[] booksOfAuthor = new Book[length];
        int index = 0;
        for (Book book : books) {
            for (Author author1 : book.getAuthors())
                if (author.equals(author1)) {
                    booksOfAuthor[index++] = book;
                }
        }
        return new ArrayBooks(booksOfAuthor);
    }

    public ArrayBooks findBooksOfPublishingHouse(String publishingHouse) {
        int length = 0;
        for (Book book : books) {
            if (publishingHouse.equals(book.getPublishingHouse())) {
                length++;
            }
        }
        Book[] books1 = new Book[length];
        int index = 0;
        for (Book book : books) {
            if (publishingHouse.equals(book.getPublishingHouse())) {
                books1[index++] = book;
            }
        }
        return new ArrayBooks(books1);
    }

    public ArrayBooks findBooksPublishedAfterYear(int year) {
        int length = 0;
        for (Book book : books) {
            if (book.getYearOfPublication() > year) {
                length++;
            }
        }
        Book[] books1 = new Book[length];
        int index = 0;
        for (Book book : books) {
            if (book.getYearOfPublication() > year) {
                books1[index++] = book;
            }
        }
        return new ArrayBooks(books1);
    }
}


