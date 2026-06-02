package Prog3-2026.TP6;

public class ObjetoMochila {

    private String nombreObjeto;
    private double pesoKG;
    private double valor;

    public ObjetoMochila(String nombreObjeto, double pesoKG, double valor){
        this.nombreObjeto = nombreObjeto;
        if(valor<0 || pesoKG<0){
            throw new IllegalArgumentException("Peso o valor negativo.");
        }
        this.pesoKG = pesoKG;
        this.valor = valor;
    }
    public String getNombreObjeto() {
        return nombreObjeto;
    }
    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }
    public double getPesoKG() {
        return pesoKG;
    }
    public void setPesoKG(double pesoKG) {
        this.pesoKG = pesoKG;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
}