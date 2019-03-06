
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManipuladorArquivo {
	
	//Baseado no exemplo consultado em
	//https://www.lncc.br/~rogerio/poo/08-Arquivos-Java/Escrever%20e%20Ler%20arquivos%20com%20Java.pdf
	
	// OBS: O DIRETÓRIO C:\TESTE DEVE SER CRIADO PREVIAMENTE
	
	// Indicar o local do arquivo
	File arquivo = new File("c:/teste/teste.txt");

	public void escreveArquivo(String registro) {

		try {
			if (!arquivo.exists()) {
				// Se o arquivo não existir cria um arquivo (vazio)
				arquivo.createNewFile();
			}

			// escreve no arquivo. o booleano permite nova inserção sem apagar a anterior
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(registro);
			bw.newLine();
			bw.close();
			fw.close();
		
		// Caso não encontre o caminho (diretório não foi criado)
		} catch (IOException e) {
			System.out.println("O sistema não pode encontrar o caminho especificado");
		}
	}

	public void leArquivo() {
		try {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			// enquanto houver mais linhas
			while (br.ready()) {
				// lê a proxima linha
				String linha = br.readLine();
				// faz algo com a linha
				System.out.println(linha);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("Erro da leiturado do arquivo" + e);
		}
	}
}