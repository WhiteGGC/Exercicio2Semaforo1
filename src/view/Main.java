package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCorredor;

public class Main {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		
		for(int i=0;i<4;i++){
			Thread tCorredor = new ThreadCorredor(semaforo);
			tCorredor.start();
		}

	}

}
