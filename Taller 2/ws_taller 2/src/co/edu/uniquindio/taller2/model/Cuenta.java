package co.edu.uniquindio.taller2.model;

public class Cuenta {
    protected float saldo = 0f;
    protected int numConsignaciones = 0;
    protected int numRetiros = 0;
    protected float tasaAnual = 0f;
    protected float comisionMensual = 0f;

    /**
     * Es el constructor de la cuenta
     *
     * @param saldo
     * @param tasaAnual
     */
    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    /**
     *
     * @param saldo
     * @return
     */
    public String consignarDinero(float saldo) {
        return "Se consign� " + saldo + ", ahora tienes: " + this.saldo;
    }

    /**
     *
     * @param saldo
     * @return
     */
    public String retirarDinero(float saldo) {
        return "Se consign� " + saldo + ", ahora tienes: " + this.saldo;
    }

    /**
     *
     * @return
     */
    public float calcularIntereses() {
        return 0f;
    }

    /**
     *
     */
    public void extractoMensual() {

    }

    /**
     *
     * @return
     */
    public String imprimir() {
        return toString();
    }

    @Override
    public String toString() {
        return "Cuenta [saldo=" + saldo + ", numConsignaciones=" + numConsignaciones + ", numRetiros=" + numRetiros
                + ", tasaAnual=" + tasaAnual + ", comisionMensual=" + comisionMensual + "]";
    }
}
