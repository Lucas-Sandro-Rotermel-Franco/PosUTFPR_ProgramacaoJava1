package br.edu.utfpr.sistemarquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

public class FileReader {

    public void read(Path path) {
        File file = new File(path.toString());

        if (file.isDirectory())
            throw new UnsupportedOperationException("Os parametros enviados resultaram em um diretório");

        if (!file.getName().toLowerCase().endsWith(".txt"))
            throw new UnsupportedOperationException("Arquivo nao eh um txt");

        System.out.println("Conteudo do arquivo: " + file.getName());

        file = obtainNormalizedNameFile(file);

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine())
                System.out.println(scanner.nextLine());

            scanner.close();
        } catch (FileNotFoundException e) {
            throw new UnsupportedOperationException("Arquivo nao encontrado!");
        }
    }

    private File obtainNormalizedNameFile(File file) {
        File parent = file.getParentFile();

        for (File fileReal : parent.listFiles()) {
            if (fileReal.toString().toLowerCase().equals(file.toString().toLowerCase()))
                return fileReal;
        }

        return file;
    }
}
