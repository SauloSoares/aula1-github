package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import utilitario.Funcionarios;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Funcionarios> funcionario = new ArrayList<>();
		
		System.out.println("digite o número de funcionarios ");
		int num = sc.nextInt();		
		
		for(int i=1; i<=num; i++) {
			sc.nextLine();
			System.out.println("Digite o id: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Digite o nome: ");
			String nome = sc.nextLine();
			System.out.println("Digite o salario ");
			double salario = sc.nextDouble();
			
			funcionario.add(new Funcionarios(id, nome, salario));
			
		}
		
		for(Funcionarios func : funcionario) {
			System.out.println(func);
		}
		
		System.out.println("Qual id para reajuste salarial? ");
		int idAjuste = sc.nextInt();
		sc.nextLine();
		Funcionarios func = funcionario.stream().filter(x -> x.getId() == idAjuste).findFirst().orElse(null);
		if(func == null) {
			System.out.println("Id não existe!");
		}
		else {
			System.out.println("Digite a porcentagem ");
			int porcentagem = sc.nextInt();
			sc.nextLine();
			func.alteraSalario(porcentagem);
		}
		
		for(Funcionarios x : funcionario) {
			System.out.println(x);
		}


		sc.close();

	}

}
