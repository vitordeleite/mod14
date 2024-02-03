package cliente;

import dao.ClienteMapDAO;
import dao.IClineteDAO;
import javax.swing.*;
public class App {
	private static IClineteDAO iClineteDAO;
 public static void main(String[] args) {
	 iClineteDAO = new ClienteMapDAO();
	 String opcao = JOptionPane.showInputDialog(null, "digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alterar ou 5 para sair.","Menu principal",JOptionPane.INFORMATION_MESSAGE);
	if ("".equals(opcao)) {
		sair();
	}
	 while(!isOpcaoValida(opcao)) {
		 opcao=JOptionPane.showInputDialog(null, " opcção invalida digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alterar ou 5 para sair.","Cadastro",JOptionPane.INFORMATION_MESSAGE);
		 if ("".equals(opcao)) {
				sair();
			}
		 }
	 while(isOpcaoValida(opcao)) {
		 
		 if (isOpccaoSair(opcao)) {
			 sair();
		 }else if (isCadastro(opcao)) {
			 String dados =JOptionPane.showInputDialog(null, "digite usando virgula os seus dados, EX.: Nome,CPf,Telefone,Edenreço,Número,Cidade,Estado","Cadastro",JOptionPane.INFORMATION_MESSAGE);
		 cadastrar(dados);
		 	}else if (isConsuta(opcao)) {
		 		 String dados =JOptionPane.showInputDialog(null, "digite o cpf","consultar",JOptionPane.INFORMATION_MESSAGE);
		 		 consultar(dados);
		 	} else if (isExclusao(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente",
                        "Consulta cliente", JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            }else if (isatualizar(opcao)) {
            	String dados = JOptionPane.showInputDialog(null,"digite usando virgula os seus dados, EX.: Nome,CPf,Telefone,Edenreço,Número,Cidade,Estado","Atualização", JOptionPane.INFORMATION_MESSAGE);
                atualizar(dados);
            }
		    opcao = JOptionPane.showInputDialog(null, "digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alterar ou 5 para sair.","Menu principal",JOptionPane.INFORMATION_MESSAGE);
			if ("".equals(opcao)) {
				sair();}
		 
	 	}
}
 

private static void atualizar(String dados) {
	 String[] dadoSeparados = dados.split(",");
	 String nome = dadoSeparados[0];
     Long cpf = Long.valueOf(dadoSeparados[1].trim());
     Long tel = Long.valueOf(dadoSeparados[2].trim());
     String end = dadoSeparados[3];
     Integer numero = Integer.valueOf(dadoSeparados[4].trim());
     String cidade = dadoSeparados[5];
     String estado = dadoSeparados[6];

     Cliente cliente = new Cliente(nome, cpf, tel, end, numero, cidade, estado);
     iClineteDAO.alterar(cliente);
} 
   
	


private static void consultar( String dados) {
Cliente cliente = iClineteDAO.consutar(Long.parseLong(dados));
if(cliente!=null) {
 JOptionPane.showMessageDialog(null, "pessoa encontrada: " + cliente.toString(), "consultar", JOptionPane.INFORMATION_MESSAGE);
 }else { JOptionPane.showMessageDialog(null, "Cadastrado não existente", "consulta", JOptionPane.INFORMATION_MESSAGE);}
}

private static void cadastrar(String dados) {
	    String[] dadoSeparados = dados.split(",");

	    if (dadoSeparados.length == 7) {
	        String nome = dadoSeparados[0];
	        Long cpf = Long.valueOf(dadoSeparados[1].trim());
	        Long tel = Long.valueOf(dadoSeparados[2].trim());
	        String end = dadoSeparados[3];
	        Integer numero = Integer.valueOf(dadoSeparados[4].trim());
	        String cidade = dadoSeparados[5];
	        String estado = dadoSeparados[6];

	        Cliente cliente = new Cliente(nome, cpf, tel, end, numero, cidade, estado);
	        Boolean iscadastrado = iClineteDAO.cadastrar(cliente);
	        if(iscadastrado) {
	        	JOptionPane.showMessageDialog(null, " Cadastrado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
	        }else {
	        JOptionPane.showMessageDialog(null, "Cadastrado já existente", "Cadastro", JOptionPane.INFORMATION_MESSAGE);}
	    }
	    }

	

	private static void excluir(String dados) {
		  iClineteDAO.excluir(Long.parseLong(dados));
	      JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso: ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
	
}

	private static boolean isCadastro(String opcao) {
 		if("1".equals(opcao)) {
			return true;
} return false;
}
	 private static boolean isConsuta(String opcao) {
			
		 if("2".equals(opcao)) {
				return true;
	} return false;
	}
	   private static boolean isExclusao(String opcao) {
	        if ("3".equals(opcao)) {
	            return true;
	        }
	        return false;
	    }
	   private static boolean isatualizar(String opcao) {
			if("4".equals(opcao)) {
				return true;
		} return false;
		}


	private static boolean isOpccaoSair(String opcao) {
 		if("5".equals(opcao)) {
			return true;
} return false;
 	}
 	
	private static void sair() {
 		JOptionPane.showMessageDialog(null,"volte sempre", "sair",JOptionPane.INFORMATION_MESSAGE);
 		System.exit(0);
	
}
	private static boolean isOpcaoValida(String opcao) {
 		if("1".equals(opcao) ||"2".equals(opcao)||"3".equals(opcao)||"4".equals(opcao)||"5".equals(opcao)) {
 			return true;
 		}
 	return false;
}	
}
