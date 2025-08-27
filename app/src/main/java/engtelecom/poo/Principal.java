package engtelecom.poo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    /** Erros conhecidos no programa:
     * 1 - Não executa o "gradle run" pelo terminal, mesmo utilizando o comando "entrada.nextLine()" na linha que apresenta o erro.
     * Funcinou a compilação pelo VS Code;
     * 2 - try...catch não funciona dentro do loop "while(true)", então precisei deixá-lo fora do loop para que o programa não ficasse
     * executando a mensagem de erro repetidamente até ser encerrado a força;
     * 3 - Ao invocar o método toString da classe Evento está sendo apresentando algumas informações que não deveriam dentro da String,
     * como se fosse algum resíduo do teclado que permaneceu (enviei um exemplo ao senhor por e-mail).
     * 4 - Por mais que o loop para a exclusão do evento pelo UID esteja correto, o programa informa que não foi possível localizar uma
     * instância com essa informação. Quando coloquei um system.out dentro do método "getUid" ele me mostrou o mesmo UID que foi inserido
     * no teclado, então não havia motivo para ele não localizar o objeto.
     */

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        boolean estado;

        System.out.println("Nome da empresa: ");
        String nomeE = entrada.nextLine();
        System.out.println("Nome do aplicativo: ");
        String nomeA = entrada.nextLine();

        Icalendar c = new Icalendar(nomeE, nomeA);

        try {

            while (true) {
                //Fazer uma pausa no programa
                int frequencia = 0;
                int intervalo = 0;
                int diaR = 0;
                int mesR = 0;
                int anoR = 0;
                int horaR = 0;
                int minutoR = 0;
                int segundoR = 0;
                int diaSemana = -1;
                ArrayList<String> datasExcluidas = new ArrayList<>();
    
                System.out.println("***** Seja bem-vindo(a) ao construtor de calendário! *****");
                System.out.println("1 - Cadastrar um novo evento");
                System.out.println("2 - Remover um evento");
                System.out.println("3 - Listar os eventos criados");
    
                int opcao = entrada.nextInt();
    
                int i = 0;
                int definirFrequencia = 1;
                int excluirDatas = 2;
    
                switch (opcao){
    
                    case 1:
                    //Definir um assunto para o evento;
                    System.out.println("Sumario do evento: ");
                    entrada.nextLine();
                    String sumario = entrada.nextLine();
                    System.out.println("Local do evento: ");
                    String local = entrada.nextLine();
    
                    
                    //Definir a data inicial e final do evento;
                    System.out.println("Dia inicial do evento: ");
                    int diaI = entrada.nextInt();
                    System.out.println("Mês inicial do evento: ");
                    int mesI = entrada.nextInt();
                    System.out.println("Ano inicial do evento: ");
                    int anoI = entrada.nextInt();
                    System.out.println("Dia final do evento: ");
                    int diaF = entrada.nextInt();
                    System.out.println("Mês final do evento: ");
                    int mesF = entrada.nextInt();
                    System.out.println("Ano final do evento: ");
                    int anoF = entrada.nextInt();
    
                    //Definir o horário inicial e final do evento;
                    System.out.println("Hora inicial: ");
                    int horaI = entrada.nextInt();
                    System.out.println("Minuto inicial: ");
                    int minutoI = entrada.nextInt();
                    System.out.println("Segundo inicial: ");
                    int segundoI = entrada.nextInt();
                    System.out.println("Hora final: ");
                    int horaF = entrada.nextInt();
                    System.out.println("Minuto final: ");
                    int minutoF = entrada.nextInt();
                    System.out.println("Segundo final: ");
                    int segundoF = entrada.nextInt();
                    
                    while (true) {
    
                        System.out.println("Configurar um extra: ");
                        System.out.println("1 - Frequencia de repetição");
                        System.out.println("2 - Data a ser excluída");
                        System.out.println("Qualquer outro número para finalizar");
                        int repeticao = entrada.nextInt();
    
                        switch (repeticao){
    
                            case 1:
                            System.out.println("Defina a frequencia: ");
                            System.out.println("1 - Dariamente");
                            System.out.println("2 - Semanalmente");
                            System.out.println("3 - Mensalmente");
                            System.out.println("4 - Anualmente");
                            frequencia = entrada.nextInt();
    
                            System.out.println("Defina o intervalo: ");
                            intervalo = entrada.nextInt();
    
                            System.out.println("Defina a data e hora para o término da repetição: ");
                            System.out.println("Dia: ");
                            diaR = entrada.nextInt();
                            System.out.println("Mês: ");
                            mesR = entrada.nextInt();
                            System.out.println("Ano: ");
                            anoR = entrada.nextInt();
                            System.out.println("Hora: ");
                            horaR = entrada.nextInt();
                            System.out.println("Minuto: ");
                            minutoR = entrada.nextInt();
                            System.out.println("Segundo: ");
                            segundoR = entrada.nextInt();
    
                            System.out.println("Defina o dia da semana da repetição: ");
                            System.out.println("0 - Domingo");
                            System.out.println("1 - Segunda-Feira");
                            System.out.println("2 - Terça-Feira");
                            System.out.println("3 - Quarta-Feira");
                            System.out.println("4 - Quinta-Feira");
                            System.out.println("5 - Sexta-Feira");
                            System.out.println("6 - Sábado");
                            diaSemana = entrada.nextInt();
                            break;
    
                            case 2:
                            System.out.println("Defina a data e hora a ser excluída: ");
                            System.out.println("Dia: ");
                            int diaE = entrada.nextInt();
                            System.out.println("Mês: ");
                            int mesE = entrada.nextInt();
                            System.out.println("Ano: ");
                            int anoE = entrada.nextInt();
                            System.out.println("Hora: ");
                            int horaE = entrada.nextInt();
                            System.out.println("Minuto: ");
                            int minutoE = entrada.nextInt();
                            System.out.println("Segundo: ");
                            int segundoE = entrada.nextInt();
    
                            datasExcluidas.add(Integer.toString(diaE) + "," +
                            Integer.toString(mesE) + "," + Integer.toString(anoE) + "," +
                            Integer.toString(horaE) + "," + Integer.toString(minutoE) +
                            "," + Integer.toString(segundoE));
    
                            break;
    
                            default:
                            break;
    
                        }
    
                        if (repeticao != definirFrequencia && repeticao != excluirDatas) {
                            break;
                        }
    
                    }
    
                    estado = c.criarEvento(sumario, local, diaI, mesI, anoI, diaF, mesF, anoF, horaI, minutoI,
                    segundoI, horaF, minutoF, segundoF, frequencia, intervalo, diaR, mesR, anoR, horaR, minutoR,
                    segundoR, diaSemana, datasExcluidas);
    
                    if (estado == true) {
                        System.out.println("Evento criado com sucesso!");
                    } else System.out.println("Não foi possível criar o evento.");
    
                    break;
    
                    case 2:
                    System.out.println("UID do evento a ser removido: ");
                    String uidR = entrada.nextLine();
                    entrada.nextLine();
    
                    estado = c.removerEvento(uidR);
    
                    if (estado == true) {
                        System.out.println("Evento removido com sucesso!");
                    } else System.out.println("Não foi possível localizar um evento com este assunto");
    
                    break;
    
                    case 3:
                    System.out.println(c);
                    break;
    
                    default: 
                    System.out.println("A opção digitada não existe");
                }
    
            }
            
        } catch (InputMismatchException e) {
            System.out.println("Valor inserido é inválido.");
        }
    
    }
}