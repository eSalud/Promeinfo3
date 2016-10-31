package edu.cisc.dto;

public class AdmMenuDTO {

	private Integer idmenu;
	private String nombre;
	private Integer nivel;
	private String urldestino;
	private String icono;
	private Integer idmenupadre;
	
	public AdmMenuDTO () {
		super();
	}
	
	public AdmMenuDTO (Integer idmenu, String nombre, Integer nivel, String urldestino, String icono, Integer idmenupadre) {
		super();
		this.idmenu = idmenu;
		this.nombre = nombre;
		this.nivel = nivel;
		this.urldestino = urldestino;
		this.icono = icono;
		this.idmenupadre = idmenupadre;
	}

	public Integer getIdmenu() {
		return idmenu;
	}

	public void setIdmenu(Integer idmenu) {
		this.idmenu = idmenu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public String getUrldestino() {
		return urldestino;
	}

	public void setUrldestino(String urldestino) {
		this.urldestino = urldestino;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public Integer getIdmenupadre() {
		return idmenupadre;
	}

	public void setIdmenupadre(Integer idmenupadre) {
		this.idmenupadre = idmenupadre;
	}
	
}
