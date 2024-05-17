package Projeto06;
import Projeto06.Cliente.Cliente;
import Projeto06.ClienteDAO.ClienteDAO;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();

        while (true){
            System.out.println("1- Criar cliente");
            System.out.println("2- Ler cliente");
            System.out.println("3- Atualizar Cliente");
            System.out.println("4- Deletar cliente");
            System.out.println("5- listar Todos os cliente");
            System.out.println("0- Sair");
            int op = in.nextInt();
            in.nextLine();

            switch (op){
                case 1:
                    System.out.println("Digite o nome do cliente: ");
                    String nome = in.nextLine();
                    System.out.println("Digite o email do cliente: ");
                    String email = in.nextLine();
                    Cliente novoCliente = new Cliente(0,nome,email);
                    clienteDAO.create(novoCliente);
                    break;
                case 2:
                    System.out.println("Digite o ID do cliente: ");
                    int id = in.nextInt();
                    Cliente cliente = clienteDAO.read(id);

                        if (cliente != null){
                            System.out.println("ID: "+cliente.getId());
                            System.out.println("Nome: "+cliente.getNome());
                            System.out.println("Email: "+ cliente.getEmail());

                        }else {
                            System.out.println("Cliente náo incontraado");
                                 }
                        break;
                case 3:
                    System.out.println("Digite o ID do cliente a ser atualizado: ");
                    int idAtualizar = in.nextInt();
                    in.nextLine();
                    System.out.println("Digite o novo do cliente: ");
                    String novoNome = in.nextLine();
                    System.out.println("Digite o novo email: ");
                    String novoEmail = in.nextLine();
                    Cliente clienteAtualizado = new Cliente(idAtualizar,novoNome,novoEmail);
                    clienteDAO.update(clienteAtualizado);
                    break;
                case 4:
                    System.out.println("Digite o ID do cliente a ser Delete: ");
                    int idDeletar = in.nextInt();
                    clienteDAO.delete(idDeletar);
                    break;
                case 5:
                    List<Cliente> clientes = clienteDAO.readAll();
                        for(Cliente c: clientes){
                            System.out.println("ID: "+ c.getId());
                            System.out.println("Nome: "+ c.getNome());
                            System.out.println("Email: "+ c.getEmail());
                            System.out.println("----------------------------------------------------");
                        }
                    break;
                case 0: in.close();
                System.exit(0);
                default:
                    System.out.println("Essa opção não é válida, tente novamente!!");
            }
        }
    }
}