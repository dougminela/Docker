import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CadastroClientes cadastroClientes = new CadastroClientes();
        String resposta = "0";
        Scanner ler = new Scanner(System.in);

        // Criar um arquivo vazio para os clientes (se não existir ainda)
        criarArquivoClientes();

        while (!resposta.equals("4")) {

            System.out.println("Selecione uma opção: " +
                    "\n 1 - Adicionar novo cliente" +
                    "\n 2 - Visualizar clientes" +
                    "\n 3 - Atualizar informações de clientes" +
                    "\n 4 - Sair");

            System.out.print(" > ");
            resposta = ler.next();
            System.out.println("\n");

            switch (resposta) {
                case "1":

                    System.out.print("Digite o nome do cliente:" +
                            "\n > ");
                    String nome = ler.next();

                    System.out.print("Digite o email do cliente:" +
                            "\n > ");
                    String email = ler.next();

                    System.out.print("Digite o telefone do cliente:" +
                            "\n > ");
                    String telefone = ler.next();

                    cadastroClientes.setLista(nome, email, telefone);
                    break;

                case "2":
                    System.out.println("Exibindo os clientes: ");
                    cadastroClientes.getLista();
                    System.out.println("\n");
                    break;

                case "3":
                    System.out.println("Digite o nome do cliente para atualizar: ");
                    String nomeAtualizar = ler.next();

                    System.out.println("Digite o novo nome do cliente: ");
                    String novoNome = ler.next();

                    System.out.println("Digite o novo email do cliente: ");
                    String novoEmail = ler.next();

                    System.out.println("Digite o novo telefone do cliente: ");
                    String novoTelefone = ler.next();

                    if (cadastroClientes.atualizarCliente(nomeAtualizar, novoNome, novoEmail, novoTelefone)) {
                        System.out.println("Cliente atualizado com sucesso.");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case "4":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Número inválido");

            }

        }

    }

    // Método estático para criar o arquivo de clientes se ele não existir
    private static void criarArquivoClientes() {
        String nomeArquivo = "C:/Temp/arquivoCliente.txt";
        try {
            FileWriter arquivo = new FileWriter(nomeArquivo, true); // true para não sobrescrever o arquivo existente
            arquivo.close();
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo: " + e.getMessage());
        }
    }
}
