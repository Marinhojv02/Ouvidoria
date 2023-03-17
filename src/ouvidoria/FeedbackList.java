package ouvidoria;

import java.util.ArrayList;

public class FeedbackList {
    ArrayList<Feedback> feedbacks;

    public FeedbackList() {
        this.feedbacks = new ArrayList<Feedback>();
    }

    public void addFeedback(Feedback feedback) {
        this.feedbacks.add(feedback);
    }

    public String listFeedback() {

        if (this.feedbacks.isEmpty()) {

            return "Nenhuma sugestao cadastrada!";

        } else {

            String list = "";

            for (int i = 0; i < this.feedbacks.size(); i++) {
                list += String.format("Id: %d | %s", i + 1,
                        this.feedbacks.get(i).toString() + System.lineSeparator());
            }

            return list;
        }

    }

    public boolean deleteFeedbacks(int position) {

        if (position < this.feedbacks.size()) {
            this.feedbacks.remove(position);
            return true;
            }
        System.err.println("Opcao inexistente, tente outra.");
        return false;
    }

    public void deleteAll() {
        this.feedbacks.removeAll(this.feedbacks);
    }
}
