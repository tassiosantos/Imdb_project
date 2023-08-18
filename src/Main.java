import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Scanner;

//Adicionei dtNascimento para atores;
//Retirei DiretorService de dentro de DiretorRepository
//
public class Main {
    public static MenuController menuController = new MenuController();

    public static void main(String[] args) throws IOException {
        while(true) {
            menuController.exibirMenuInicial();
            int escolha = menuController.selecionarEscolha();
            switch (escolha) {
                case (1):
                    menuController.exibirMenuAtor();
                    escolha = menuController.selecionarEscolha();
                    switch (escolha) {
                        case (1):
                            menuController.listarAtor();
                            break;
                        case (2):
                            menuController.cadastrarAtor();
                            break;
                        case (3):
                            menuController.vincularAtor();
                            break;

                    }
                    break;
                case (2):
                    menuController.exibirMenuDiretor();
                    escolha = menuController.selecionarEscolha();
                    switch (escolha) {
                        case (1):
                            menuController.listarDiretor();
                            break;
                        case (2):
                            menuController.cadastrarDiretor();
                            break;
                        case (3):
                            menuController.vincularDiretor();
                            break;
                    }
                    break;
                case (3):
                    menuController.exibirMenuFilme();
                    escolha = menuController.selecionarEscolha();
                    switch (escolha) {
                        case (1):
                            menuController.listarFilmes();
                            break;
                        case (2):
                            menuController.buscarFilmesPorNome();
                            break;
                        case (3):
                            menuController.cadastrarFilme();

                    }
                    break;
            }


        }



    }

}