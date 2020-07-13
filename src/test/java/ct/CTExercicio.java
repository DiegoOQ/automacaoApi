package ct;

import org.junit.Test;

import api.ChamadaApi;

public class CTExercicio {

//	public static void main(String[] args) {
@Test
	public void executarScrip() {
		ChamadaApi api = new ChamadaApi();

		System.out.println("Executar Exercio API");
		System.out.println("Crie os usuarios Ana Maia, Rodrigo Mendes, Tatiana Vasconcelos");
		api.apiCadastroUser();

		System.out.println("Crie os pets Snoopy (dog), Bichento (cat) e Perry (platypus)");
		api.apiCadastroPets("dog","Snoopy");
		api.apiCadastroPets("cat","Bichento");
		api.apiCadastroPets("platypus","Perry");

		System.out.println(
				"Faça a venda do Perry para a Ana Maia, do Snoopy para o Rodrigo Mendes e do Bichento para a Tatiana Vanconcelos");
		api.apiCompraPet("dog");
		api.apiCompraPet("cat");
		api.apiCompraPet("platypus");
		
		System.out.println(
				"Mude o status da ordem de venda do Perry e do Snoopy para \"approved\" e do Bichento para \"delivered\"");
		api.apiAtualizarStatus("dog");
		api.apiAtualizarStatus("cat");
		api.apiAtualizarStatus("platypus");
		
		System.out.println("Consulte as 3 ordens geradas");
		api.apiBuscaPet("dog");
		api.apiBuscaPet("cat");
		api.apiBuscaPet("platypus");
	}

}
