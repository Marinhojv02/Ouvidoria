package ouvidoria;

public class Formatter {
    public String mainMenu() {

        String menu = "\t[1] Adicionar Manifestacoes:\n"
                + "\t[2] Listar Manifestacoes:\n"
                + "\t[3] Apagar Manifestacoes:\n"
                + "\t[4] Sair:";

        return menu;

    }

    public String menuType() {
        String menu = "\t[1] Reclamacoes:\n"
                + "\t[2] Elogios:\n"
                + "\t[3] Sugestoes:";
        return menu;

    }

}
