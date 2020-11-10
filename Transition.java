public class Transition
{

    private String val;
    private String init;
    private String fin;

    public Transition(String val, String init, String fin) {
        this.val = val;
        this.init = init;
        this.fin = fin;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getInit() {
        return init;
    }

    public void setInit(String init) {
        this.init = init;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }


    /**
     * Transitions ::= Transition{Transition}
     * Transition ::= <init> - <val> - <fin>
     */

    @Override
    public String toString() {
        return init + "-" + val + "-" + fin + "\n";
    }
}
