package hashing;

public class HashingComPorao implements EstruturaDeDados{

    private final int TAMANHO = 1011;
    private final int PORAO = 100;

    private int[] dados;
    private int[] porao;
    private int pInd;

    public HashingComPorao() {
        dados = new int[TAMANHO];
        porao = new int[PORAO];
        pInd = 0;
    }

    private int identidade(int chave) {
        return chave % TAMANHO;
    }

    @Override
    public void insert(int chave) {
        int pos = identidade(chave);

        if (dados[pos] == 0) {
            dados[pos] = chave;
        } else if (pInd < PORAO) {
            porao[pInd++] = chave;
        } else {
            for (int i = pos; i < TAMANHO; i++) {
                if (dados[i] == 0) {
                    dados[i] = chave;
                    return;
                }
            }
        }
    }

    @Override
    public void delete(int chave) {
        int pos = identidade(chave);

        if (dados[pos] == chave) {
            dados[pos] = 0;
        } else {
            for (int i = 0; i < pInd; i++) {
                if (porao[i] == chave) {
                    System.arraycopy(porao, i + 1, porao, i, pInd - i - 1);
                    pInd--;
                    return;
                }
            }

            if (pInd >= PORAO) {
                for (int i = pos; i < TAMANHO; i++) {
                    if (dados[i] == chave) {
                        dados[i] = 0;
                        return;
                    }
                }
            }
        }
    }

    @Override
    public boolean search(int chave) {
        int pos = identidade(chave);

        if (dados[pos] == chave) {
            return true;
        }

        for (int i = 0; i < pInd; i++) {
            if (porao[i] == chave) {
                return true;
            }
        }

        if (pInd >= PORAO) {
            for (int i = pos; i < TAMANHO; i++) {
                if (dados[i] == chave) {
                    return true;
                }
            }
        }

        return false;
    }
}
