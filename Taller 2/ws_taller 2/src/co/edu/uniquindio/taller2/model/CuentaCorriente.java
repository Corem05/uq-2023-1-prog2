package co.edu.uniquindio.taller2.model;

public class CuentaCorriente extends Cuenta {

	protected float sobregiro = 0f;

	/**
	 * Es el constructor de la cuenta corriente
	 *
	 * @param saldo
	 * @param tasaAnual
	 */
	public CuentaCorriente(float saldo, float tasaAnual) {
		super(saldo, tasaAnual);
	}

	@Override
	public String consignarDinero(float saldo) {
		return super.consignarDinero(saldo);
	}

	@Override
	public String imprimir() {
		return super.imprimir();
	}

	@Override
	public String retirarDinero(float saldo) {
		return super.retirarDinero(saldo);
	}

	public boolean haySobregiro() {
		return sobregiro > 0;
	}

}
