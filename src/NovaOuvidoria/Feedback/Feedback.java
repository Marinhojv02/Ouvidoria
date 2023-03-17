package NovaOuvidoria.Feedback;

public class Feedback {
    String tipo;
    String feedback;



    public Feedback (String tipo, String feedback){
        this.tipo = tipo;
        this.feedback = feedback;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
