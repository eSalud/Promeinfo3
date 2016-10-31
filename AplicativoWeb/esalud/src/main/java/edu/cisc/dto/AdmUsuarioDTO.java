package edu.cisc.dto;

public class AdmUsuarioDTO {
	
	private Integer idUsuario;
	private String userName;
	private String estado;
	private Integer idPersona;
	private String identificacion;
	private String nombre;
	private String apellido;
	private String email;
	private String rol;
	
	public AdmUsuarioDTO () {
		super();
	}
	
	public AdmUsuarioDTO (Integer idUsuario, String userName, String estado, Integer idPersona, String identificacion, String nombre, String apellido, String email, String rol) {
		super();
		this.idUsuario = idUsuario;
		this.userName = userName;
		this.estado = estado;
		this.idPersona = idPersona;
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.rol = rol;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
