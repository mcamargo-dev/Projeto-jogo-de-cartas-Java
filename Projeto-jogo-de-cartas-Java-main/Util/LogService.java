package Util;

import java.util.ArrayList;
import java.util.List;

public class LogService {

    private static final String ARQUIVO_LOG = "sistema_log.txt";

    public static void info(String msg) {
        String mensagemFormatada = "[INFO] " + msg;
        System.out.println(mensagemFormatada);
        gravarLog(mensagemFormatada);
    }

    public static void erro(String msg) {
        String mensagemFormatada = "[ERRO] " + msg;
        System.err.println(mensagemFormatada);
        gravarLog(mensagemFormatada);
    }

    public static void gravarLog(String msg) {
        try {
            List<String> linha = new ArrayList<>();
            linha.add(msg);
            FileUtil.escreverArquivo(ARQUIVO_LOG, linha);
        } catch (Exception e) {
            System.err.println("Falha ao gravar log: " + e.getMessage());
        }
    }
}