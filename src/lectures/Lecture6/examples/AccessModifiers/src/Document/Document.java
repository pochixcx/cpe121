package lectures.Lecture6.examples.AccessModifiers.src.Document;

public class Document {
    public String title; // accessible anywhere
    protected String category; // accessible in subclasses or same package
    String author; // default/package-private: same package only
    private String content; // accessible only inside Document class

    // Private setter for content: cannot be modified directly outside
    private void setContent(String content) {
        this.content = content;
    }

    public void updateContent(String newContent) {
        if (newContent != null && !newContent.isEmpty()) {
            setContent(newContent);
        }
    }

    public String getContent() {
        return content;
    }
}
