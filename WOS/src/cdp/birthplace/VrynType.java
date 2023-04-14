package cdp.birthplace;

/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
/**
 *
 * @author almei
 */
public class VrynType implements BithplaceSchema {

    /**
     *
     * @author almei
     * @param param is an age
     * @return 
     */
    @Override
    public int caculateEnergy(int param) {
        double hp = 100 + Math.floor(param / 10);
        return (int) hp;
    }

}
