package lectures.Lecture6.examples.AccessModifiers.src;

import lectures.Lecture6.examples.AccessModifiers.src.Document.Document;

public class Main {
    public static void main(String[] args) {
        Document docs = new Document();

        System.out.println(docs.title); // title field is publicly available.

        // get content method is public method so we access it here.
        System.out.println(docs.getContent());
    }
}
