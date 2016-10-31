package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ffaviviendahogares database table.
 * 
 */
@Entity
@Table(name="ffaviviendahogares")
@NamedQuery(name="FfaViviendaHogar.findAll", query="SELECT f FROM FfaViviendaHogar f")
public class FfaViviendaHogar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idviviendahogar;

	private String aguacloro;

	private String aguafiltran;

	private String aguahierven;

	private String agualluvia;

	private String aguaninguno;

	private String aguaotro;

	private String aguapileta;

	private String aguapozo;

	private String aguapublica;

	private String aguapurificada;

	private String aguario;

	private String aguatriciclo;

	private String aguatuberia;

	private String alumbradoempresa;

	private String alumbradootro;

	private String alumbradopanel;

	private String alumbradoplanta;

	private String alumbradovela;

	private String anticresis;

	private String arriendo;

	private String basuracalle;

	private String basuracontratan;

	private String basuraentierran;

	private String basuramunicipal;

	private String basuraotro;

	private String basuraqueman;

	private String basurareciclan;

	private String cedida;

	private String cocinaelectricidad;

	private String cocinagas;

	private String cocinalena;

	private String cocinano;

	private String cocinaotro;

	private String duchacompartido;

	private String duchahogar;

	private String duchaotro;

	private String estado;

	private String higienicodentro;

	private String higienicofuera;

	private String higienicootro;

	private Integer idcuarto;

	private Integer iddormitorio;

	private String propia;

	private String servicioalcantar;

	private String serviciociego;

	private String servicioletrina;

	private String serviciootro;

	private String serviciorio;

	private String servicios;

	private String servicioseptico;

	private String tuberiaafuera;

	private String tuberiadentro;

	private String tuberiaedificio;

	private String tuberiaotros;

	//bi-directional many-to-one association to FfaVivienda
	@ManyToOne
	@JoinColumn(name="idvivienda")
	private FfaVivienda ffavivienda;

	public FfaViviendaHogar() {
	}

	public Long getIdviviendahogar() {
		return this.idviviendahogar;
	}

	public void setIdviviendahogar(Long idviviendahogar) {
		this.idviviendahogar = idviviendahogar;
	}

	public String getAguacloro() {
		return this.aguacloro;
	}

	public void setAguacloro(String aguacloro) {
		this.aguacloro = aguacloro;
	}

	public String getAguafiltran() {
		return this.aguafiltran;
	}

	public void setAguafiltran(String aguafiltran) {
		this.aguafiltran = aguafiltran;
	}

	public String getAguahierven() {
		return this.aguahierven;
	}

	public void setAguahierven(String aguahierven) {
		this.aguahierven = aguahierven;
	}

	public String getAgualluvia() {
		return this.agualluvia;
	}

	public void setAgualluvia(String agualluvia) {
		this.agualluvia = agualluvia;
	}

	public String getAguaninguno() {
		return this.aguaninguno;
	}

	public void setAguaninguno(String aguaninguno) {
		this.aguaninguno = aguaninguno;
	}

	public String getAguaotro() {
		return this.aguaotro;
	}

	public void setAguaotro(String aguaotro) {
		this.aguaotro = aguaotro;
	}

	public String getAguapileta() {
		return this.aguapileta;
	}

	public void setAguapileta(String aguapileta) {
		this.aguapileta = aguapileta;
	}

	public String getAguapozo() {
		return this.aguapozo;
	}

	public void setAguapozo(String aguapozo) {
		this.aguapozo = aguapozo;
	}

	public String getAguapublica() {
		return this.aguapublica;
	}

	public void setAguapublica(String aguapublica) {
		this.aguapublica = aguapublica;
	}

	public String getAguapurificada() {
		return this.aguapurificada;
	}

	public void setAguapurificada(String aguapurificada) {
		this.aguapurificada = aguapurificada;
	}

	public String getAguario() {
		return this.aguario;
	}

	public void setAguario(String aguario) {
		this.aguario = aguario;
	}

	public String getAguatriciclo() {
		return this.aguatriciclo;
	}

	public void setAguatriciclo(String aguatriciclo) {
		this.aguatriciclo = aguatriciclo;
	}

	public String getAguatuberia() {
		return this.aguatuberia;
	}

	public void setAguatuberia(String aguatuberia) {
		this.aguatuberia = aguatuberia;
	}

	public String getAlumbradoempresa() {
		return this.alumbradoempresa;
	}

	public void setAlumbradoempresa(String alumbradoempresa) {
		this.alumbradoempresa = alumbradoempresa;
	}

	public String getAlumbradootro() {
		return this.alumbradootro;
	}

	public void setAlumbradootro(String alumbradootro) {
		this.alumbradootro = alumbradootro;
	}

	public String getAlumbradopanel() {
		return this.alumbradopanel;
	}

	public void setAlumbradopanel(String alumbradopanel) {
		this.alumbradopanel = alumbradopanel;
	}

	public String getAlumbradoplanta() {
		return this.alumbradoplanta;
	}

	public void setAlumbradoplanta(String alumbradoplanta) {
		this.alumbradoplanta = alumbradoplanta;
	}

	public String getAlumbradovela() {
		return this.alumbradovela;
	}

	public void setAlumbradovela(String alumbradovela) {
		this.alumbradovela = alumbradovela;
	}

	public String getAnticresis() {
		return this.anticresis;
	}

	public void setAnticresis(String anticresis) {
		this.anticresis = anticresis;
	}

	public String getArriendo() {
		return this.arriendo;
	}

	public void setArriendo(String arriendo) {
		this.arriendo = arriendo;
	}

	public String getBasuracalle() {
		return this.basuracalle;
	}

	public void setBasuracalle(String basuracalle) {
		this.basuracalle = basuracalle;
	}

	public String getBasuracontratan() {
		return this.basuracontratan;
	}

	public void setBasuracontratan(String basuracontratan) {
		this.basuracontratan = basuracontratan;
	}

	public String getBasuraentierran() {
		return this.basuraentierran;
	}

	public void setBasuraentierran(String basuraentierran) {
		this.basuraentierran = basuraentierran;
	}

	public String getBasuramunicipal() {
		return this.basuramunicipal;
	}

	public void setBasuramunicipal(String basuramunicipal) {
		this.basuramunicipal = basuramunicipal;
	}

	public String getBasuraotro() {
		return this.basuraotro;
	}

	public void setBasuraotro(String basuraotro) {
		this.basuraotro = basuraotro;
	}

	public String getBasuraqueman() {
		return this.basuraqueman;
	}

	public void setBasuraqueman(String basuraqueman) {
		this.basuraqueman = basuraqueman;
	}

	public String getBasurareciclan() {
		return this.basurareciclan;
	}

	public void setBasurareciclan(String basurareciclan) {
		this.basurareciclan = basurareciclan;
	}

	public String getCedida() {
		return this.cedida;
	}

	public void setCedida(String cedida) {
		this.cedida = cedida;
	}

	public String getCocinaelectricidad() {
		return this.cocinaelectricidad;
	}

	public void setCocinaelectricidad(String cocinaelectricidad) {
		this.cocinaelectricidad = cocinaelectricidad;
	}

	public String getCocinagas() {
		return this.cocinagas;
	}

	public void setCocinagas(String cocinagas) {
		this.cocinagas = cocinagas;
	}

	public String getCocinalena() {
		return this.cocinalena;
	}

	public void setCocinalena(String cocinalena) {
		this.cocinalena = cocinalena;
	}

	public String getCocinano() {
		return this.cocinano;
	}

	public void setCocinano(String cocinano) {
		this.cocinano = cocinano;
	}

	public String getCocinaotro() {
		return this.cocinaotro;
	}

	public void setCocinaotro(String cocinaotro) {
		this.cocinaotro = cocinaotro;
	}

	public String getDuchacompartido() {
		return this.duchacompartido;
	}

	public void setDuchacompartido(String duchacompartido) {
		this.duchacompartido = duchacompartido;
	}

	public String getDuchahogar() {
		return this.duchahogar;
	}

	public void setDuchahogar(String duchahogar) {
		this.duchahogar = duchahogar;
	}

	public String getDuchaotro() {
		return this.duchaotro;
	}

	public void setDuchaotro(String duchaotro) {
		this.duchaotro = duchaotro;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getHigienicodentro() {
		return this.higienicodentro;
	}

	public void setHigienicodentro(String higienicodentro) {
		this.higienicodentro = higienicodentro;
	}

	public String getHigienicofuera() {
		return this.higienicofuera;
	}

	public void setHigienicofuera(String higienicofuera) {
		this.higienicofuera = higienicofuera;
	}

	public String getHigienicootro() {
		return this.higienicootro;
	}

	public void setHigienicootro(String higienicootro) {
		this.higienicootro = higienicootro;
	}

	public Integer getIdcuarto() {
		return this.idcuarto;
	}

	public void setIdcuarto(Integer idcuarto) {
		this.idcuarto = idcuarto;
	}

	public Integer getIddormitorio() {
		return this.iddormitorio;
	}

	public void setIddormitorio(Integer iddormitorio) {
		this.iddormitorio = iddormitorio;
	}

	public String getPropia() {
		return this.propia;
	}

	public void setPropia(String propia) {
		this.propia = propia;
	}

	public String getServicioalcantar() {
		return this.servicioalcantar;
	}

	public void setServicioalcantar(String servicioalcantar) {
		this.servicioalcantar = servicioalcantar;
	}

	public String getServiciociego() {
		return this.serviciociego;
	}

	public void setServiciociego(String serviciociego) {
		this.serviciociego = serviciociego;
	}

	public String getServicioletrina() {
		return this.servicioletrina;
	}

	public void setServicioletrina(String servicioletrina) {
		this.servicioletrina = servicioletrina;
	}

	public String getServiciootro() {
		return this.serviciootro;
	}

	public void setServiciootro(String serviciootro) {
		this.serviciootro = serviciootro;
	}

	public String getServiciorio() {
		return this.serviciorio;
	}

	public void setServiciorio(String serviciorio) {
		this.serviciorio = serviciorio;
	}

	public String getServicios() {
		return this.servicios;
	}

	public void setServicios(String servicios) {
		this.servicios = servicios;
	}

	public String getServicioseptico() {
		return this.servicioseptico;
	}

	public void setServicioseptico(String servicioseptico) {
		this.servicioseptico = servicioseptico;
	}

	public String getTuberiaafuera() {
		return this.tuberiaafuera;
	}

	public void setTuberiaafuera(String tuberiaafuera) {
		this.tuberiaafuera = tuberiaafuera;
	}

	public String getTuberiadentro() {
		return this.tuberiadentro;
	}

	public void setTuberiadentro(String tuberiadentro) {
		this.tuberiadentro = tuberiadentro;
	}

	public String getTuberiaedificio() {
		return this.tuberiaedificio;
	}

	public void setTuberiaedificio(String tuberiaedificio) {
		this.tuberiaedificio = tuberiaedificio;
	}

	public String getTuberiaotros() {
		return this.tuberiaotros;
	}

	public void setTuberiaotros(String tuberiaotros) {
		this.tuberiaotros = tuberiaotros;
	}

	public FfaVivienda getFfavivienda() {
		return this.ffavivienda;
	}

	public void setFfavivienda(FfaVivienda ffavivienda) {
		this.ffavivienda = ffavivienda;
	}

}