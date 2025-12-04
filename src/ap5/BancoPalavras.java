package ap5;

import java.util.Random;

public class BancoPalavras {
    
    String[] vetorPalavras;

    BancoPalavras(){
        this.vetorPalavras = new String[]{
            "casa", "bola", "carro", "moto", "sapato", "camisa"
        } ;
    }

    String sortear(){
    
        int index;
        
        Random random = new Random();
        index = random.nextInt(vetorPalavras.length);

        return this.vetorPalavras[index];
    }
}
