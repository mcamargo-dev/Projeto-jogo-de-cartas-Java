package Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static boolean arquivoExiste(String path) {
        if (path == null) {
            return false;
        }
        File arquivo = new File(path);
        return arquivo.exists() && arquivo.isFile();
    }

    public static void escreverArquivo(String path, List<String> linhas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            for (String linha : linhas) {
                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo " + path + ": " + e.getMessage());
        }
    }

    public static List<String> lerArquivo(String path) {
        List<String> linhas = new ArrayList<>();
        File arquivo = new File(path);

        if (!arquivo.exists()) {
            return linhas;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    linhas.add(linha);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + path + ": " + e.getMessage());
        }

        return linhas;
    }
}