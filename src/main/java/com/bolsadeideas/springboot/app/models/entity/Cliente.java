package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import com.bolsadeideas.springboot.app.enums.EstadosSolicitud;
import org.jboss.jandex.Index;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String nombre;

	@NotEmpty
	private String apellido;

	@NotEmpty
	@Email
	private String email;

	private Integer plazoSolicitado;


	private Integer montoSolicitado;


	private String numeroCuenta;


	private String motivoRechazo;


	private String EstadosSolicitud;

	private String foto;


	@NotNull
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


	public Integer getPlazoSolicitado() {
		return plazoSolicitado;
	}

	public void setPlazoSolicitado(Integer plazoSolicitado) {
		this.plazoSolicitado = plazoSolicitado;
	}

	public Integer getMontoSolicitado() {
		return montoSolicitado;
	}

	public void setMontoSolicitado(Integer montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}


	public String getEstadosSolicitud() {
		return EstadosSolicitud;
	}

	public void setEstadosSolicitud(String EstadosSolicitud) {
		this.EstadosSolicitud = EstadosSolicitud;

	}

	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;


}