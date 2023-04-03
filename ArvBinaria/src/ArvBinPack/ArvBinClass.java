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
		No achado = findNo(no, this.raiz);
		//Corte as relações
		if(achado.noPai.filhoEsc.varNo == achado.varNo){
			// é filho esquerdo
			achado.noPai.filhoEsc = null;
			achado.noPai = null;

		} else if(achado.noPai.filhoDir.varNo == achado.varNo){
			// é filho direito
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
