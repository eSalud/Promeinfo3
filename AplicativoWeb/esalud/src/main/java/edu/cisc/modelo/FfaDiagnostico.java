package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ffadiagnosticos database table.
 * 
 */
@Entity
@Table(name="ffadiagnosticos")
@NamedQuery(name="FfaDiagnostico.findAll", query="SELECT f FROM FfaDiagnostico f")
public class FfaDiagnostico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddiagnostico;

	private String descdiag;

	private String descseg;

	private String descsegm;

	private String descsegmt;

	private String diagas;

	private String diagpds;

	private String diagpec;

	private String diagpr;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechadiag;

	@Temporal(TemporalType.DATE)
	private Date fechaseg;

	@Temporal(TemporalType.DATE)
	private Date fechasegm;

	@Temporal(TemporalType.DATE)
	private Date fechasegmt;

	private String nombdiag;

	private String nombseg;

	private String nombsegm;

	private String nombsegmt;

	private String segas;

	private String segmas;

	private String segmpds;

	private String segmpec;

	private String segmpr;

	private String segmtas;

	private String segmtpds;

	private String segmtpec;

	private String segmtpr;

	private String segpds;

	private String segpec;

	private String segpr;

	//bi-directional many-to-one association to FfaPersonaFichaFamiliar
	@ManyToOne
	@JoinColumn(name="idpersona")
	private FfaPersonaFichaFamiliar ffapersonasfichafamiliar;

	public FfaDiagnostico() {
	}

	public Long getIddiagnostico() {
		return this.iddiagnostico;
	}

	public void setIddiagnostico(Long iddiagnostico) {
		this.iddiagnostico = iddiagnostico;
	}

	public String getDescdiag() {
		return this.descdiag;
	}

	public void setDescdiag(String descdiag) {
		this.descdiag = descdiag;
	}

	public String getDescseg() {
		return this.descseg;
	}

	public void setDescseg(String descseg) {
		this.descseg = descseg;
	}

	public String getDescsegm() {
		return this.descsegm;
	}

	public void setDescsegm(String descsegm) {
		this.descsegm = descsegm;
	}

	public String getDescsegmt() {
		return this.descsegmt;
	}

	public void setDescsegmt(String descsegmt) {
		this.descsegmt = descsegmt;
	}

	public String getDiagas() {
		return this.diagas;
	}

	public void setDiagas(String diagas) {
		this.diagas = diagas;
	}

	public String getDiagpds() {
		return this.diagpds;
	}

	public void setDiagpds(String diagpds) {
		this.diagpds = diagpds;
	}

	public String getDiagpec() {
		return this.diagpec;
	}

	public void setDiagpec(String diagpec) {
		this.diagpec = diagpec;
	}

	public String getDiagpr() {
		return this.diagpr;
	}

	public void setDiagpr(String diagpr) {
		this.diagpr = diagpr;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechadiag() {
		return this.fechadiag;
	}

	public void setFechadiag(Date fechadiag) {
		this.fechadiag = fechadiag;
	}

	public Date getFechaseg() {
		return this.fechaseg;
	}

	public void setFechaseg(Date fechaseg) {
		this.fechaseg = fechaseg;
	}

	public Date getFechasegm() {
		return this.fechasegm;
	}

	public void setFechasegm(Date fechasegm) {
		this.fechasegm = fechasegm;
	}

	public Date getFechasegmt() {
		return this.fechasegmt;
	}

	public void setFechasegmt(Date fechasegmt) {
		this.fechasegmt = fechasegmt;
	}

	public String getNombdiag() {
		return this.nombdiag;
	}

	public void setNombdiag(String nombdiag) {
		this.nombdiag = nombdiag;
	}

	public String getNombseg() {
		return this.nombseg;
	}

	public void setNombseg(String nombseg) {
		this.nombseg = nombseg;
	}

	public String getNombsegm() {
		return this.nombsegm;
	}

	public void setNombsegm(String nombsegm) {
		this.nombsegm = nombsegm;
	}

	public String getNombsegmt() {
		return this.nombsegmt;
	}

	public void setNombsegmt(String nombsegmt) {
		this.nombsegmt = nombsegmt;
	}

	public String getSegas() {
		return this.segas;
	}

	public void setSegas(String segas) {
		this.segas = segas;
	}

	public String getSegmas() {
		return this.segmas;
	}

	public void setSegmas(String segmas) {
		this.segmas = segmas;
	}

	public String getSegmpds() {
		return this.segmpds;
	}

	public void setSegmpds(String segmpds) {
		this.segmpds = segmpds;
	}

	public String getSegmpec() {
		return this.segmpec;
	}

	public void setSegmpec(String segmpec) {
		this.segmpec = segmpec;
	}

	public String getSegmpr() {
		return this.segmpr;
	}

	public void setSegmpr(String segmpr) {
		this.segmpr = segmpr;
	}

	public String getSegmtas() {
		return this.segmtas;
	}

	public void setSegmtas(String segmtas) {
		this.segmtas = segmtas;
	}

	public String getSegmtpds() {
		return this.segmtpds;
	}

	public void setSegmtpds(String segmtpds) {
		this.segmtpds = segmtpds;
	}

	public String getSegmtpec() {
		return this.segmtpec;
	}

	public void setSegmtpec(String segmtpec) {
		this.segmtpec = segmtpec;
	}

	public String getSegmtpr() {
		return this.segmtpr;
	}

	public void setSegmtpr(String segmtpr) {
		this.segmtpr = segmtpr;
	}

	public String getSegpds() {
		return this.segpds;
	}

	public void setSegpds(String segpds) {
		this.segpds = segpds;
	}

	public String getSegpec() {
		return this.segpec;
	}

	public void setSegpec(String segpec) {
		this.segpec = segpec;
	}

	public String getSegpr() {
		return this.segpr;
	}

	public void setSegpr(String segpr) {
		this.segpr = segpr;
	}

	public FfaPersonaFichaFamiliar getFfapersonasfichafamiliar() {
		return this.ffapersonasfichafamiliar;
	}

	public void setFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		this.ffapersonasfichafamiliar = ffapersonasfichafamiliar;
	}

}