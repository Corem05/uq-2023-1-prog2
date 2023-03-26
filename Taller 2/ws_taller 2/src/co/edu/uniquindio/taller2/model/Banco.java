package co.edu.uniquindio.taller2.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	protected String nombre;
	protected String direccion;
	protected String codigo;
	protected List<Cuenta> listaCuentas = new ArrayList<Cuenta>();

	public Banco(String nombre, String direccion, String codigo) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.codigo = codigo;
	}

	public Banco() {
	}

	public Cuenta buscarCuenta(String codigo) {
		return getListaCuentas().stream().filter(cadaCuenta -> cadaCuenta.getCodigo().equals(codigo)).findFirst()
				.orElse(null);
	}

	private Cuenta buscarCuentaOError(String codigo) throws CuentaException {
		Cuenta cuentaEncontrada = buscarCuenta(codigo);
		if (cuentaEncontrada == null) {
			throw new CuentaException("La cuenta no existe (" + codigo + ")");
		}
		return cuentaEncontrada;
	}

	public void agregarCuentaAhorros(String codigo, float saldo, float tasaAnual) throws CuentaException {
		if (validarCuenta(codigo)) {
			throw new CuentaException("La cuenta ya existe (" + codigo + ")");
		}
		getListaCuentas().add(new CuentaAhorros(codigo, saldo, tasaAnual));
	}

	public void agregarCuentaCorriente(String codigo, float saldo, float tasaAnual) throws CuentaException {
		if (validarCuenta(codigo)) {
			throw new CuentaException("La cuenta ya existe (" + codigo + ")");
		}
		getListaCuentas().add(new CuentaCorriente(codigo, saldo, tasaAnual));
	}

	public void eliminarCuenta(String codigo) throws CuentaException {
		if (!validarCuenta(codigo)) {
			throw new CuentaException("La cuenta no existe (" + codigo + ")");
		}
	}

	private void actualizarCuenta(Cuenta cuenta) {
		Cuenta cuentaEncontrada = buscarCuenta(cuenta.getCodigo());

		int index = listaCuentas.indexOf(cuentaEncontrada);
		listaCuentas.set(index, cuenta);
	}

	public void consignarDineroCuenta(String codigo, float dinero) throws CuentaException {
		Cuenta cuentaEncontrada = buscarCuentaOError(codigo);
		cuentaEncontrada.consignarDinero(dinero);
		actualizarCuenta(cuentaEncontrada);
	}

	public void retirarDineroCuenta(String codigo, float dinero) throws CuentaException {
		Cuenta cuentaEncontrada = buscarCuentaOError(codigo);
		cuentaEncontrada.retirarDinero(dinero);
		actualizarCuenta(cuentaEncontrada);
	}

	public void calcularInteresesCuenta(String codigo) throws CuentaException {
		Cuenta cuentaEncontrada = buscarCuentaOError(codigo);
		cuentaEncontrada.calcularIntereses();
		actualizarCuenta(cuentaEncontrada);
	}

	public void extraerMensualCuenta(String codigo) throws CuentaException {
		Cuenta cuentaEncontrada = buscarCuentaOError(codigo);
		cuentaEncontrada.extractoMensual();
		actualizarCuenta(cuentaEncontrada);
	}

	public void imprimirCuenta(String codigo) throws CuentaException {
		Cuenta cuentaEncontrada = buscarCuentaOError(codigo);
		cuentaEncontrada.imprimir();
		actualizarCuenta(cuentaEncontrada);
	}

	public boolean estaActivaCuenta(String codigo) throws CuentaException {
		Cuenta cuentaEncontrada = buscarCuentaOError(codigo);
		if (!cuentaEncontrada.getClass().equals(CuentaAhorros.class)) {
			throw new CuentaException("La cuenta tiene que ser de ahorros");
		}
		CuentaAhorros cuentaEncontradaAhorros = (CuentaAhorros) cuentaEncontrada;
		return cuentaEncontradaAhorros.estaActiva();
	}

	public float obtenerSobregiroCuenta(String codigo) throws CuentaException {
		Cuenta cuentaEncontrada = buscarCuentaOError(codigo);
		if (!cuentaEncontrada.getClass().equals(CuentaCorriente.class)) {
			throw new CuentaException("La cuenta tiene que ser corriente");
		}
		CuentaCorriente cuentaEncontradaAhorros = (CuentaCorriente) cuentaEncontrada;
		return cuentaEncontradaAhorros.getSobregiro();
	}

	public List<Cuenta> getListaCuentas() {
		return listaCuentas;
	}

	public boolean validarCuenta(String codigo) {
		return buscarCuenta(codigo) != null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banco other = (Banco) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Banco [nombre=%s, direccion=%s, codigo=%s, listaCuentas=%s]", nombre, direccion, codigo,
				listaCuentas);
	}

}