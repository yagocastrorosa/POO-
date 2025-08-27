package engtelecom.poo;

import java.util.ArrayList;
import java.util.UUID;

public class Evento {

    private String sumario;
    private String local;
    private String uID;

    private String dataI;
    private String dataF;
    private String dataR;
    private String dataE;
    private String dataCriacao;

    private String frequencia;
    private int intervalo;
    private String diaSemana;
    private boolean rrule;
    private boolean exdate;

    public Evento() {

        FormatarData f = new FormatarData();

        this.uID = UUID.randomUUID().toString();
        this.dataCriacao = f.definirDataAtual();

    }

    public boolean criarEvento(String sumario, String local, int diaI, int mesI, int anoI, int diaF, int mesF,
                               int anoF, int horaI, int minutoI, int segundoI, int horaF, int minutoF, int segundoF,
                               int frequencia, int intervalo, int diaR, int mesR, int anoR, int horaR, int minutoR,
                               int segundoR, int diaSemana, ArrayList<String> datasExcluidas) {

        FormatarData f = new FormatarData();

        this.sumario = sumario;
        this.local = local;
        
        this.dataI = f.definirDataEvento(horaI, minutoI, segundoI, diaI, mesI, anoI);
        this.dataF = f.definirDataEvento(horaF, minutoF, segundoF, diaF, mesF, anoF);

        if (this.dataI.isEmpty() || this.dataF.isEmpty()) {
            return false;
        }

        //Loop para verificar se foi configurado um RRULE ou EXDATE
        while (true) {

            //Verifica se o usuário selecionou um intervalo ou não;
            if (frequencia == 0) {
                break;
            }
 
            //Como ele selecionou, definimos o dia da semana escolhido;
            switch (frequencia) {
                case 0:
                break;
               
                case 1:
                this.frequencia = "DAILY";
                break;
   
                case 2:
                this.frequencia = "WEEKLY";
                break;
   
                case 3:
                this.frequencia = "MONTLHY";
                break;
   
                case 4:
                this.frequencia = "YEARLY";
                break;
   
                default:
                System.out.println("Frequência selecionada não existe.");
                return false;
            }
  
            //Verifica se foi selecionado um valor válido para a repetição;
            if (intervalo >= 0) {
                this.intervalo = intervalo;
            } else {
                System.out.println("Não foi selecionado um intervalo de repetição válido.");
                return false;
            }

            this.dataR = f.definirDataEvento(horaR, minutoR, segundoR, diaR, mesR, anoR);
            if (dataR.isEmpty()) {
                return false;
            }

  
            //Verifica se foi selecionado um valor válido para o dia da semana;
            switch (diaSemana) {
                case 0:
                this.diaSemana = "SU";
                break;
               
                case 1:
                this.diaSemana = "MO";
                break;
   
                case 2:
                this.diaSemana = "TU";
                break;
   
                case 3:
                this.diaSemana = "WE";
                break;
   
                case 4:
                this.diaSemana = "TH";
                break;
  
                case 5:
                this.diaSemana = "FR";
                break;
  
                case 6:
                this.diaSemana = "SA";
                break;
   
                default:
                System.out.println("Dia selecionada não existe.");
                return false;
            }

            rrule = true;

            while (true) {

                for (int i=0; i<datasExcluidas.size(); i++) {
                    

                    String data = datasExcluidas.get(i);
                    int primeiraVirgula = data.indexOf(",");
                    int segundaVirgula = data.indexOf(",",primeiraVirgula+1);
                    int terceiraVirgula = data.indexOf(",", segundaVirgula+1);
                    int quartaVirgula = data.indexOf(",", terceiraVirgula+1);
                    int quintaVirgula = data.indexOf(",", quartaVirgula+1);

                    String dia = data.substring(0, primeiraVirgula);
                    String mes = data.substring(primeiraVirgula+1, segundaVirgula);
                    String ano = data.substring(segundaVirgula+1, terceiraVirgula);
                    String hora = data.substring(terceiraVirgula+1, quartaVirgula);
                    String minuto = data.substring(quartaVirgula+1, quintaVirgula);
                    String segundo = data.substring(quintaVirgula+1, data.length());

                    System.out.println(dia);
                    System.out.println(mes);
                    System.out.println(ano);
                    System.out.println(hora);
                    System.out.println(minuto);
                    System.out.println(segundo);
    
                    String exclusao = f.definirDataEvento(Integer.parseInt(hora), Integer.parseInt(minuto),
                    Integer.parseInt(segundo), Integer.parseInt(dia), Integer.parseInt(mes), Integer.parseInt(ano));
    
                    if (exclusao.isEmpty()) {
                        System.out.println("A data informada para a exclusão não existe.");
                        return false;
                    } else {
                        dataE = dataE + "EXDATE:" + exclusao + "\n";
                        exdate = true;
                    }

    
                }

                break;
            }
  
            break;           
  
        }

        return true;

    }

    public String getUid() {

        return this.uID;

    }

    public String toString() {

        String retorno = "BEGIN:VEVENT" + "\n" +
                         "SUMMARY:" + sumario + "\n" +
                         "DTSTAMP:" + dataCriacao + "\n" +
                         "DTSTART:" + dataI + "\n" +
                         "DTEND:" + dataF + "\n" +
                         "UID:" + uID + "\n";
                         //CRIAR UMA CLASSE PARA OS EVENTOS EXTRAS
        if (rrule == true) {
            retorno = retorno + "RRULE:FREQ=" + this.frequencia + ";INTERVAL=" + intervalo + ";UNTIL=" + this.dataR + ";BYDAY=" + diaSemana + "\n";
        }
        if (exdate == true) {
            retorno = retorno + dataE;
        }
        retorno = retorno + "LOCATION:" + local + "\n" +
        "END:VEVENT" + "\n";

        return retorno;
    }

}