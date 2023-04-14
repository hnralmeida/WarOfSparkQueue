package cdp.birthplace;

/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
/**
 *
 * @author almei
 */
public class KaladeshType implements BithplaceSchema {

    /**
     *
     * @author almei
     * @param param is an weight
     * @return 
     */
    @Override
    public int caculateEnergy(int param) {
        double hp = 75 + Math.floor(param / 10);
        return (int) hp;
    }

}
