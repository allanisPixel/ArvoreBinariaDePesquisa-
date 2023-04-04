package ArvBinPack;

public class ArvBinClass {
	public No raiz;
	
	void ArvBinPack(){
		this.raiz = null;
	}
	
	public void insertNo(No no, No referencia ){
		//No inicio no referencia precisa ser raiz
		
		if(referencia == null){ 
			// Se raiz nulo isso vai ser raiz
			referencia = no;
		}
		else if(no.varNo < referencia.varNo){ // Se menor vá pra esquerda
			referencia = referencia.filhoEsc;
			insertNo(no, referencia);
		}
		else if(no.varNo > referencia.varNo){
			referencia = referencia.filhoDir;
			insertNo(no, referencia);
		}
	}
	public No popNo(No no){
		/* Casos de remoção
		 * Nó folha: remove as referencias e cabou
		 * Nó tem 2 filhos: 1 pra direita e depois desce até o final pra esqueda e substitui
		 * no tem 1 filho: o 1 filho subistitui o pai
		*/
		No achado = findNo(no, this.raiz);
		// Corte as relações
		if(achado.filhoDir == null && achado.filhoEsc == null){
			// Nó é folha
			// É maior ou menor que pai? Se menor Esq se maior Dir
			if(achado == achado.noPai.filhoEsc){
				achado.noPai.filhoEsc = null;
			}
			else if(achado == achado.noPai.filhoDir){
				achado.noPai.filhoDir = null;
			}
			achado.noPai = null;
		}
		// Tem um unico filho (é esquerdo ou direito? o nó a ser removido é um filho esq ou dir?)
		else if(achado.filhoDir == null && achado.filhoEsc != null || achado.filhoDir != null && achado.filhoEsc == null){
			if(achado == achado.noPai.filhoEsc){
				//Achado É filho Esq 
				if(){}

			}
			else if(achado == achado.noPai.filhoDir){
				//Achado É Filho Dir
			}
			achado.noPai = null;
		}
		





		// Tem 2 filhos
		if(achado.filhoDir != null && achado.filhoEsc != null){
			

		}







		
		return achado;
	}
	
	public No findNo(No no, No referencia){ 
		//No referencia começa como raiz
		if(referencia == null){ 
			System.out.println("Arvore vazia ou referecia não existe");
		}
		else if(no.varNo < referencia.varNo){ // Se menor vá pra esquerda
			referencia = referencia.filhoEsc;
			findNo(no, referencia);
		}
		else if(no.varNo > referencia.varNo){
			referencia = referencia.filhoDir;
			findNo(no, referencia);

		}else if(no == referencia){
			System.out.println("No: " + referencia.varNo);
			System.out.println("Pai: "+ referencia.noPai.varNo);
			System.out.println("Filho Esq: " + referencia.filhoEsc.varNo);
			System.out.println("Filho Dir: " + referencia.filhoDir.varNo);
		}
		return referencia;
	}
	
	
	
	
}
