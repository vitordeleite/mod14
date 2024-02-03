package dao;

import java.util.Collection;

import cliente.Cliente;

public interface IClineteDAO {
 public Boolean cadastrar(Cliente cliente);
 public void excluir (Long cpf);
 public void alterar(Cliente cliente);
 public Cliente consutar (long cpf);
 public Collection<Cliente> buscarTodos();
}
