import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CadastroClientes {
    private List<Cliente> listaClientes;

    public CadastroClientes() {
        this.listaClientes = new ArrayList<>();
    }

    public void setLista(String nome, String email, String telefone) {
        Cliente cliente = new Cliente(nome, email, telefone);
        listaClientes.add(cliente);
        adicionarClienteAoArquivo(cliente); // adiciona o cliente ao arquivo
    }

    public void getLista() {
        if (listaClientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
        } else {
            System.out.println("Lista de Clientes:");
            for (Cliente cliente : listaClientes) {
                System.out.println(clienteFormatado(cliente));
            }
        }
    }

    public boolean atualizarCliente(String nomeAtual, String novoNome, String novoEmail, String novoTelefone) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNome().equals(nomeAtual)) {
                cliente.setNome(novoNome);
                cliente.setEmail(novoEmail);
                cliente.setTelefone(novoTelefone);
                atualizarArquivoClientes(); // atualiza o arquivo com os novos dados
                return true;
            }
        }
        return false;
    }

    // metodo para adicionar um cliente ao arquivo
    private void adicionarClienteAoArquivo(Cliente cliente) {
        String nomeArquivo = "C:/Temp/arquivoCliente.txt";
        try {
            FileWriter arquivoEscrita = new FileWriter(nomeArquivo, true); // true para adicionar ao final do arquivo
            PrintWriter gravador = new PrintWriter(arquivoEscrita);
            gravador.println(cliente.getNome() + ";" + cliente.getEmail() + ";" + cliente.getTelefone());
            gravador.close();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    // metodo para formatar um cliente
    private String clienteFormatado(Cliente cliente) {
        return String.format("Nome: %s, Email: %s, Telefone: %s", cliente.getNome(), cliente.getEmail(),
                cliente.getTelefone());
    }

    // metodo para atualizar o arquivo com os novos dados
    private void atualizarArquivoClientes() {
        String nomeArquivo = "C:/Temp/arquivoCliente.txt";
        try {
            FileWriter arquivoEscrita = new FileWriter(nomeArquivo);
            PrintWriter gravador = new PrintWriter(arquivoEscrita);
            for (Cliente cliente : listaClientes) {
                gravador.println(cliente.getNome() + ";" + cliente.getEmail() + ";" + cliente.getTelefone());
            }
            gravador.close();
        } catch (IOException e) {
            System.out.println("Erro ao atualizar o arquivo: " + e.getMessage());
        }
    }
}
