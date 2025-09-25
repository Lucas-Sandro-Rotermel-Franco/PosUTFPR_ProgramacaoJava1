package br.edu.utfpr.sistemarquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.util.Scanner;

public enum Command {

    LIST() {
        @Override
        boolean accept(String command) {
            final var commands = command.split(" ");
            return commands.length > 0 && commands[0].startsWith("LIST") || commands[0].startsWith("list");
        }

        @Override
        Path execute(Path path) throws IOException {
            System.out.println("Conteudo do diretorio: " + path.toString());
            File file = new File(path.toString());

            for (String filePrint : file.list())
                System.out.println("     - " + filePrint);

            return path;
        }
    },
    SHOW() {
        private String[] parameters = new String[]{};

        @Override
        void setParameters(String[] parameters) {
            if (parameters.length < 2)
                throw new UnsupportedOperationException("Eh necessario informar no minimo um parametro com este comando");

            this.parameters = parameters;
        }

        @Override
        boolean accept(String command) {
            final var commands = command.split(" ");
            return commands.length > 0 && commands[0].startsWith("SHOW") || commands[0].startsWith("show");
        }

        @Override
        Path execute(Path path) {
            for (int idx = 1; idx < parameters.length; ++idx) {
                StringBuilder filePath = new StringBuilder(path.toString());
                filePath.append(File.separator).append(parameters[idx]);

                Path pathNew = Paths.get(filePath.toString());

                if (!Files.exists(pathNew))
                    throw new UnsupportedOperationException("Endereco nao existente!");

                FileReader fileReader = new FileReader();

                fileReader.read(pathNew);
            }

            return path;
        }
    },
    BACK() {
        @Override
        boolean accept(String command) {
            final var commands = command.split(" ");
            return commands.length > 0 && commands[0].startsWith("BACK") || commands[0].startsWith("back");
        }

        @Override
        Path execute(Path path) {
            path = path.getParent();

            if (path == null)
                throw new UnsupportedOperationException("Impossível ir além do diretório raíz!");

            return path;
        }
    },
    OPEN() {
        private String[] parameters = new String[]{};

        @Override
        void setParameters(String[] parameters) {
            if (parameters.length < 2)
                throw new UnsupportedOperationException("Eh necessario informar no minimo um parametro com este comando");

            this.parameters = parameters;
        }

        @Override
        boolean accept(String command) {
            final var commands = command.split(" ");
            return commands.length > 0 && commands[0].startsWith("OPEN") || commands[0].startsWith("open");
        }

        @Override
        Path execute(Path path) {
            StringBuilder strPathNew = new StringBuilder(path.toString());
            strPathNew.append(File.separator).append(parameters[1]);

            path = Paths.get(strPathNew.toString());

            if (!Files.exists(path))
                throw new UnsupportedOperationException("Endereco nao existente!");

            if (!path.toFile().isDirectory())
                throw new UnsupportedOperationException("Novo endereco nao eh um diretorio!");

            return path;
        }
    },
    DETAIL() {
        private String[] parameters = new String[]{};

        @Override
        void setParameters(String[] parameters) {
            if (parameters.length < 2)
                throw new UnsupportedOperationException("Eh necessario informar no minimo um parametro com este comando");

            this.parameters = parameters;
        }

        @Override
        boolean accept(String command) {
            final var commands = command.split(" ");
            return commands.length > 0 && commands[0].startsWith("DETAIL") || commands[0].startsWith("detail");
        }

        @Override
        Path execute(Path path) {
            for (int idx = 1; idx < parameters.length; ++idx) {
                StringBuilder filePath = new StringBuilder(path.toString());
                filePath.append(File.separator).append(parameters[idx]);

                Path pathNew = Paths.get(filePath.toString());

                if (!Files.exists(pathNew))
                    throw new UnsupportedOperationException("Endereco nao existente!");

                BasicFileAttributeView basicView = Files.getFileAttributeView(path, BasicFileAttributeView.class);

                try {
                    System.out.println("Eh diretorio: " + (basicView.readAttributes().isDirectory() ? "Sim" : "Não"));
                    System.out.println("Data de criacao: " + basicView.readAttributes().creationTime().toString());
                    System.out.println("Data da ultima vez acessado: " + basicView.readAttributes().lastAccessTime().toString());
                    System.out.println("Data da ultima alteracao: " + basicView.readAttributes().lastModifiedTime().toString());
                    System.out.println("Tamanho: " + basicView.readAttributes().size());
                } catch (IOException e) {
                    throw new UnsupportedOperationException("Um erro de leitura ocorreu durante o detalhamento do endereço");
                }
            }

            return path;
        }
    },
    EXIT() {
        @Override
        boolean accept(String command) {
            final var commands = command.split(" ");
            return commands.length > 0 && commands[0].startsWith("EXIT") || commands[0].startsWith("exit");
        }

        @Override
        Path execute(Path path) {
            System.out.print("Saindo...");
            return path;
        }

        @Override
        boolean shouldStop() {
            return true;
        }
    };

    abstract Path execute(Path path) throws IOException;

    abstract boolean accept(String command);

    void setParameters(String[] parameters) {
    }

    boolean shouldStop() {
        return false;
    }

    public static Command parseCommand(String commandToParse) {

        if (commandToParse.isBlank()) {
            throw new UnsupportedOperationException("Type something...");
        }

        final var possibleCommands = values();

        for (Command possibleCommand : possibleCommands) {
            if (possibleCommand.accept(commandToParse)) {
                possibleCommand.setParameters(commandToParse.split(" "));
                return possibleCommand;
            }
        }

        throw new UnsupportedOperationException("Can't parse command [%s]".formatted(commandToParse));
    }
}
