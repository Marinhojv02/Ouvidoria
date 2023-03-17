package NovaOuvidoria.Feedback;

import java.util.ArrayList;

public class FeedbackList {
    ArrayList<Feedback> feedbackList;

    public FeedbackList() {
        this.feedbackList = new ArrayList<Feedback>();
    }

    public void addFeedback(Feedback feedback) {
        this.feedbackList.add(feedback);
    }

    public String listFeedback() {

        if (this.feedbackList.isEmpty()) {

            return "Nenhuma sugestao cadastrada!";

        } else {

            String list = "";

            for (Feedback feedback : this.feedbackList) {
                System.out.printf("Tipo: %s\n", feedback.getTipo());
                System.out.printf("Feedback: %s\n", feedback.getFeedback());
            }

            return list;
        }

    }

    public boolean deleteFeedbacks(int position) {

        if (position < this.feedbackList.size()) {
            this.feedbackList.remove(position);

            return true;
        }
        System.err.println("Opcao inexistente, tente outra.");

        return false;
    }

    public void deleteAll() {
        this.feedbackList.removeAll(this.feedbackList);
    }
}
