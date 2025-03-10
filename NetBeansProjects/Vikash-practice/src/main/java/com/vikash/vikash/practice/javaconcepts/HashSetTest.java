package com.vikash.vikash.practice.javaconcepts;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/*
 if you do not override hashCode and equals in the Book class, the HashSet will treat book and book1 as two different objects,
 even if they have the same id and name. This is because the default implementation of hashCode in the Object class generates a unique hash code
  for each instance, and the default equals method compares object references, not their content.
 */

public class HashSetTest {

   static Set<Book> set=new HashSet<>();

    public static void main(String[] args) {

        Book book=new Book(123, "Ramayan");
        Book book1=new Book(123, "Ramayan");
        set.add(book1);
        set.add(book);

        Iterator<Book> it=set.iterator();

        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}

class Book{

    private int seq;
    private String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return seq == book.seq && Objects.equals(title, book.title);   //checking content of Object
    }

    @Override
    public int hashCode() {
        return Objects.hash(seq, title);
    }

    public Book(int seq, String title) {
        this.seq = seq;
        this.title = title;
    }
}
