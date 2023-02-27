package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {
	
	private ArrayList <Conta> listaContas = new ArrayList<Conta>();
	int numero = 1;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null)
			conta.visualizar();
		else 
			System.out.println("\nA conta número: " + numero + " não foi encontrada!");
	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
			}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A conta foi criada!");
		
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("A conta número: " + conta.getNumero() + " foi atualizada com sucesso!");
		}else 
			System.out.println("A conta número: " + conta.getNumero() + " não foi encontrada!");
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			if(listaContas.remove(conta) == true)
				System.out.println("A conta número: " + numero + " foi excluída!");
		}else 
			System.out.println("A conta número: " + numero + " não foi encontrada!");
	}
		

	@Override
	public void sacar(int numero, float valor) {
		var buscaConta = buscarNaCollection(numero);
		
		if(buscaConta != null) {
			if (buscaConta.sacar(valor) == true)
				System.out.println("O saque foi efetuado com sucesso!");
		}else 
			System.out.println("A conta número " + numero + " não foi encontrada!");
		
	}

	@Override
	public void depositar(int numero, float valor) {
		var buscaConta = buscarNaCollection(numero);
		
		if(buscaConta != null) {
			buscaConta.depositar(valor);
				System.out.println("O depósito foi efetuado com sucesso!");
		}else 
			System.out.println("A conta número " + numero + " não foi encontrada!");
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numero);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if(contaOrigem != null && contaDestino != null) {
			if (contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println("A transferência foi efetuada com sucesso!");
			}	
		}else 
			System.out.println("A conta de origem e/ou destino número não foram encontradas!");
		
	}
	
	public int gerarNumero() {
		if (listaContas.size() == 0) {
			return numero;
		} else {
			numero ++;
			return numero;
		}
	}
	
	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}	
		}
		
		return null;
	}
	
	public int retornaTipo(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta.getTipo();
			}
		}
		
		return 0;
}
}
