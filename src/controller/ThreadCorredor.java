package controller;

import java.util.concurrent.Semaphore;

public class ThreadCorredor extends Thread{
	
	private Semaphore semaforo;
	private int distanciat = 200;
	
	public ThreadCorredor(Semaphore semaforo){
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		Corre();
		try {
			semaforo.acquire();
			Porta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			semaforo.release();
		}
	}
	
	private void Corre(){
		int distanciap = 0;
		int velocidade = (int)(Math.random() * 3 + 4);
		while(distanciat > distanciap){
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			distanciap += velocidade;
			System.out.println("A pessoa "+getId()+" percorreu "+distanciap+"m");
		}
	}
	
	private void Porta(){
		int tempo = (int)(Math.random() * 1001 + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("A pessoa "+getId()+" saiu do corredor");
	}
}
