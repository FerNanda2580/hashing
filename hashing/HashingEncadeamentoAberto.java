package hashing;

public class HashingEncadeamentoAberto implements EstruturaDeDados{

    private static final int TAMANHO = 1011;
    private int[] dados;

    public HashingEncadeamentoAberto() {
        dados = new int[TAMANHO];
    }

    private int identidade(int chave) {
        return chave % TAMANHO;
    }

    @Override
    public void insert(int chave) {
        int pCha = identidade(chave);

        if (dados[pCha] == 0) {
            dados[pCha] = chave;
        } else {
            for (int i = pCha; i < TAMANHO; i++) {
                if (dados[i] == 0) {
                    dados[i] = chave;
                    return;
                }
            }
        }
    }

    @Override
    public void delete(int chave) {
        int pCha = identidade(chave);

        for (int i = pCha; i < TAMANHO; i++) {
            if (dados[i] == chave) {
                dados[i] = 0;
                return;
            }
        }
    }

    @Override
    public boolean search(int chave) {
        int pCha = identidade(chave);

        for (int i = pCha; i < TAMANHO; i++) {
            if (dados[i] == chave) {
                return true;
            }
        }

        return false;
    }
}