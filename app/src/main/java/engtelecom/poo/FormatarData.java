package engtelecom.poo;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatarData {

    public FormatarData() {
        
    }

    public String definirDataEvento(int hora, int minuto, int segundo, int dia, int mes, int ano) {

        String dataFormatada = "";

        try {
            LocalDateTime localDateTime = LocalDateTime.of(ano, mes, dia, hora, minuto, segundo);
            dataFormatada = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss"));
            
        } catch (DateTimeException e) {
            System.out.println("A data informada não é válida.");
            dataFormatada = "";
        }

        return dataFormatada;

    }

    public String definirDataAtual() {

        LocalDateTime agora = LocalDateTime.now();
        String dataFormatada = agora.format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss"));

        return dataFormatada;

    }
}
