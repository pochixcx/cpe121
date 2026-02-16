package lectures.Lecture6.examples.AccessModifiers.src.Document;

public class Docs {
    public static void main(String[] args) {
        Document docs = new Document();

        // author field is default field, can only be accessed within the same package.
        System.out.println(docs.author);
        // category field is protected field, and can be access within subclass or same
        // package
        System.out.println(docs.category);

        System.out.println(docs.title);

    }
}
