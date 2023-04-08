package co.edu.uniquindio.taller2.model;

import co.edu.uniquindio.taller2.exceptions.CuentaException;

public class CuentaAhorros extends Cuenta {

	/**
	 * Es el constructor de la cuenta de ahorros
	 *
	 * @param codigo
	 * @param saldo
	 * @param tasaAnual
	 */
	public CuentaAhorros(String codigo, float saldo, float tasaAnual) {
		super(codigo, saldo, tasaAnual);
	}

	/**
	 * Determina si la cuenta de ahorros est� activa o no
	 *
	 * @return true si el saldo es mayor o igual a 10000
	 */
	public boolean estaActiva() {
		return getSaldo() >= 10000f;
	}

	@Override
	public void consignarDinero(float saldo) throws CuentaException {
		throwIfNotActive("No se pudo consignar el dinero (cuenta no activa)");
		super.consignarDinero(saldo);
	}

	/**
	 * Muestra un error en caso de que no est� activa la cuenta
	 *
	 * @param msg es el mensaje de error
	 * @throws CuentaException si no esta activa
	 */
	public void throwIfNotActive(String msg) throws CuentaException {
		if (!estaActiva())
			throw new CuentaException(msg);
	}

	@Override
	public void retirarDinero(float saldo) throws CuentaException {
		throwIfNotActive("No se pudo retirar el dinero (cuenta no activa)");
		super.retirarDinero(saldo);
	}

	@Override
	public void extractoMensual() throws CuentaException {
		if (getNumRetiros() > 4)
			setComisionMensual(getComisionMensual() + (getNumRetiros() - 4) * 1000f);
		super.extractoMensual();
	}

	@Override
	public String imprimir() {
		return String.format("CuentaAhorros [saldo=%s, comisionMensual=%s, numTransacciones=%s]",
				Util.darFormatoDinero(getSaldo()), getComisionMensual(), getNumTransacciones());
	}

	@Override
	public String toString() {
		return String.format(
				"CuentaAhorros [codigo=%s, saldo=%s, numConsignaciones=%s, numRetiros=%s, tasaAnual=%s, comisionMensual=%s, estaActiva=%s]",
				codigo, saldo, numConsignaciones, numRetiros, tasaAnual, comisionMensual, estaActiva());
	}

}