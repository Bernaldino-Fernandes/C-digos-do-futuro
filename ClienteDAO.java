package Projeto06.ClienteDAO;
import Projeto06.Cliente.Cliente;
import Projeto06.DatabaseConnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

        //Classe de Cliente DAO
public class ClienteDAO {

        // Metodo para criar cliente
        public void create(Cliente cliente) {
            String sql = " INSERT INTO clientes (nome, email) VALUES(?,?)";
            try (
                    Connection connection = DatabaseConnection.getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setString(1, cliente.getNome());
                    stmt.setString(2, cliente.getEmail());
                    stmt.executeUpdate();
            } catch (SQLException e) {
                    e.printStackTrace();
            }
        }

        // Metodo para Ler o dado de um Cliente especifico
        public Cliente read (int id ){

                    String sql = "SELECT * FROM clientes WHERE id = ?";
                    Cliente cliente = null;

                try (Connection connection = DatabaseConnection.getConnection();
                     PreparedStatement stmt = connection.prepareStatement(sql)) {

                    stmt.setInt(1, id);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        cliente = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("email"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return cliente;
            }

        // metodo para ler dado de todos os clientes existentes no banco de dados
        public List<Cliente> readAll(){
                        String sql = "SELECT * FROM clientes";
                        List<Cliente> clientes = new ArrayList<>();

                try(Connection connection = DatabaseConnection.getConnection()){
                        PreparedStatement stmt = connection.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                    while (rs.next()){
                       Cliente cliente = new Cliente(rs.getInt("id"),rs.getString("nome"),rs.getString("email"));
                       clientes.add(cliente);
                    }
                } catch (SQLException e){
                       e.printStackTrace();
                    }
                return clientes;
        }

        //Metodo para Atualizar um dado no banco de dados
        public void update(Cliente cliente){
            String sql = "UPDATE clientes SET nome = ?, email = ? WHERE id = ?";

            try(Connection connection =  DatabaseConnection.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)){

                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getEmail());
                stmt.setInt(3,cliente.getId());
                stmt.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        //Metodo para deletar
        public void delete(int id){
            String sql =  "DELETE FROM clientes WHERE id = ?";

            try(Connection connection = DatabaseConnection.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setInt(1,id);
                stmt.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();

            }
        }
 }
