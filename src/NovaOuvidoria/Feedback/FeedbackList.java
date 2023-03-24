package NovaOuvidoria.Feedback;

import NovaOuvidoria.Usuario.Usuario;

import java.util.ArrayList;

public class FeedbackList {
    ArrayList<Feedback> feedbackList;

    int feedbackID;

    public FeedbackList() {
        this.feedbackList = new ArrayList<Feedback>();
        this.feedbackID = 0;
    }

    public void addFeedback(String tipo, String manifestacao, String autor) {
        Feedback feedback = new Feedback(tipo, manifestacao, autor, feedbackID);
        this.feedbackList.add(feedback);

        this.feedbackID += 1;
    }

    public void addFeedback(Feedback feedback) {
        this.feedbackList.add(feedback);
    }

    public void printAll(){
        try{
            for (Feedback feedback : this.feedbackList) {
                System.out.println(feedback);
            }
        }catch (Exception e){
            return;
        }
    }

    public void printUserFeedback(Usuario user){
        try{
            for (Feedback feedback : this.feedbackList) {
                if(feedback.getAuthor().equals(user.getMatricula())){
                    System.out.println(feedback);
                }
            }
        }catch (Exception e){
            System.out.println("Usuario não encontrado");
        }
    }

    public void printUserFeedbackByMatricula(String matricula){
        try{
            for (Feedback feedback : this.feedbackList) {
                if(feedback.getAuthor().equals(matricula)){
                    System.out.println(feedback);
                }
            }
        }catch (Exception e){
            System.out.println("Usuario não encontrado");
        }
    }

    public Feedback deleteFeedbacks(int feedbackID) {
        try {
            for (Feedback feedback : this.feedbackList) {
                if(feedback.getId() == feedbackID){
                    feedbackList.remove(feedback);
                    return feedback;
                }
            }
        }catch (Exception e){
            System.out.println("FeedBack não encontrado");
        }
        return null;
    }

    public void deleteAll() {
        this.feedbackList.clear();
    }
}
