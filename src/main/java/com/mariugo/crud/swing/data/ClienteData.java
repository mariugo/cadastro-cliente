package com.mariugo.crud.swing.data;

import com.mariugo.crud.swing.model.Cliente;
import com.mariugo.crud.swing.util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteData extends Conexao {

    public ClienteData() throws Exception {
    }

    public boolean incluir(Cliente cliente) throws Exception {
        String sql = "INSERT INTO CLIENTE (nome,sobrenome,"
                + "email,telefone,cpf) VALUES (?,?,?,?,?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getSobrenome());
        ps.setString(3, cliente.getEmail());
        ps.setString(4, cliente.getTelefone());
        ps.setString(5, cliente.getCpf());

        return ps.executeUpdate() > 0;
    }

    public boolean excluir(int id) throws Exception {
        String sql = "DELETE FROM CLIENTE WHERE ID=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, id);

        return ps.executeUpdate() > 0;
    }

    public boolean editar(Cliente cliente) throws Exception {
        String sql = "UPDATE CLIENTE SET nome=?, "
                + "sobrenome=?, email=?, telefone=?, cpf=? WHERE id=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getSobrenome());
        ps.setString(3, cliente.getEmail());
        ps.setString(4, cliente.getTelefone());
        ps.setString(5, cliente.getCpf());
        ps.setInt(6, cliente.getId());

        return ps.executeUpdate() > 0;
    }

//    public Vector pesquisar(String pesq) throws Exception{
//        Vector dados = new Vector();
//        String sql = "SELECT * FROM PRODUTO WHERE nomeproduto ILIKE '"+pesq+"%'";
//        PreparedStatement ps = getConexao().prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            Vector linha = new Vector();
//            linha.add(rs.getInt("id"));
//            linha.add(rs.getString("nome"));
//            linha.add(rs.getString("sobrenome"));
//            linha.add(rs.getString("email"));
//            linha.add(rs.getString("telefone"));
//            linha.add(rs.getString("cpf"));
//            dados.add(linha);
//        }
//        return dados;
    public ArrayList<Cliente> pesquisar(String pesq) throws Exception {
        String sql = "SELECT * FROM CLIENTE WHERE NOME ILIKE '" + pesq + "%'";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Cliente> clientes = new ArrayList<>();
        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setSobrenome(rs.getString("sobrenome"));
            cliente.setEmail(rs.getString("email"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setCpf(rs.getString("cpf"));
            clientes.add(cliente);

        }
        return clientes;
    }
}
