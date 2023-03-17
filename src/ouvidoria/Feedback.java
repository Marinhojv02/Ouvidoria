package ouvidoria;

public class Feedback {
    private String feedback;

    public Feedback(String input) {
        this.feedback = input;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        String toString = String.format("Feedback: %s", getFeedback());
        return toString;
    }
}
