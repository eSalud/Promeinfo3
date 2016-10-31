package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the admaplicaciones database table.
 * 
 */
@Entity
@Table(name="admaplicaciones")
@NamedQuery(name="AdmAplicacion.findAll", query="SELECT a FROM AdmAplicacion a")
public class AdmAplicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idaplicacion;

	private String direccionurl;

	private String estado;

	private Timestamp fechacreacion;

	private String nombrecorto;

	private String nombrelargo;

	//bi-directional many-to-one association to AdmModulo
	@OneToMany(mappedBy="admaplicacione")
	private List<AdmModulo> admmodulos;

	public AdmAplicacion() {
	}

	public Long getIdaplicacion() {
		return this.idaplicacion;
	}

	public void setIdaplicacion(Long idaplicacion) {
		this.idaplicacion = idaplicacion;
	}

	public String getDireccionurl() {
		return this.direccionurl;
	}

	public void setDireccionurl(String direccionurl) {
		this.direccionurl = direccionurl;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Timestamp getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Timestamp fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getNombrecorto() {
		return this.nombrecorto;
	}

	public void setNombrecorto(String nombrecorto) {
		this.nombrecorto = nombrecorto;
	}

	public String getNombrelargo() {
		return this.nombrelargo;
	}

	public void setNombrelargo(String nombrelargo) {
		this.nombrelargo = nombrelargo;
	}

	public List<AdmModulo> getAdmmodulos() {
		return this.admmodulos;
	}

	public void setAdmmodulos(List<AdmModulo> admmodulos) {
		this.admmodulos = admmodulos;
	}

	public AdmModulo addAdmmodulo(AdmModulo admmodulo) {
		getAdmmodulos().add(admmodulo);
		admmodulo.setAdmaplicacione(this);

		return admmodulo;
	}

	public AdmModulo removeAdmmodulo(AdmModulo admmodulo) {
		getAdmmodulos().remove(admmodulo);
		admmodulo.setAdmaplicacione(null);

		return admmodulo;
	}

}