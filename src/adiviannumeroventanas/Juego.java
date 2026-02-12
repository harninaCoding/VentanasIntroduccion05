package adiviannumeroventanas;

import java.util.Random;

public class Juego {
	private int numeroSecreto;
	private int min=1, max=101;
	
	public Juego() {
		super();
		generarNumero();
		System.out.println(numeroSecreto);
	}
	
	public void generarNumero() {
		this.numeroSecreto=new Random().nextInt(min, max);
	}
	
	public int getNumeroSecreto() {
		return numeroSecreto;
	}

	public void setNumeroSecreto(int numeroSecreto) {
		this.numeroSecreto = numeroSecreto;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int checkTry(int number) {
		if(number>max-1||number<min) throw new IllegalArgumentException("numero no valido");
		return this.numeroSecreto-number;
	}
	
}
