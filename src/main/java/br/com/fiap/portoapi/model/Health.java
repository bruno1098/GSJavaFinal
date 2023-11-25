package br.com.fiap.portoapi.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.validation.constraints.NotNull;

public class Health {

	
	private Long id;

	@NotNull (message = "N pode ficar em branco")
	private String nmPaciente;
	
	@NotNull (message = "N pode ficar em branco")
	private LocalDate dataNascimentoPaciente;
	
	@NotNull (message = "N pode ficar em branco")
	private Long cpfPaciente;
	
	@NotNull (message = "N pode ficar em branco")
	private Long rgPaciente;
	
	@NotNull (message = "N pode ficar em branco")
	private String enderecoPaciente;
	
	@NotNull (message = "N pode ficar em branco")
	private Long cepPaciente;
	
	@NotNull (message = "N pode ficar em branco")
	private String emailPaciente;
	
	@NotNull (message = "N pode ficar em branco")
	private Long senhaPaciente;

	@NotNull (message = "N pode ficar em branco")
	private Float alturaPaciente;
	
	@NotNull (message = "N pode ficar em branco")
	private Float pesoPaciente;
	
	public Health() {
		super();
	}

	public Health(Long id, 
			@NotNull(message = "N pode ficar em branco") String nmPaciente,
			@NotNull(message = "N pode ficar em branco") LocalDate dataNascimentoPaciente,
			@NotNull(message = "N pode ficar em branco") Long cpfPaciente,
			@NotNull(message = "N pode ficar em branco") Long rgPaciente,
			@NotNull(message = "N pode ficar em branco") String enderecoPaciente,
			@NotNull(message = "N pode ficar em branco") Long cepPaciente,
			@NotNull(message = "N pode ficar em branco") String emailPaciente,
			@NotNull(message = "N pode ficar em branco") Long senhaPaciente,
			@NotNull(message = "N pode ficar em branco") Float alturaPaciente,
			@NotNull(message = "N pode ficar em branco") Float pesoPaciente){
		super();
		this.id = id;
		this.nmPaciente = nmPaciente;
		this.dataNascimentoPaciente = dataNascimentoPaciente;
		this.cpfPaciente = cpfPaciente;
		this.rgPaciente = rgPaciente;
		this.enderecoPaciente = enderecoPaciente;
		this.cepPaciente = cepPaciente;
		this.emailPaciente = emailPaciente;
		this.senhaPaciente = senhaPaciente;
		this.alturaPaciente = alturaPaciente;
		this.pesoPaciente = pesoPaciente;
	}


	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNmPaciente() {
		return nmPaciente;
	}

	public void setNmPaciente(String nmPaciente) {
		this.nmPaciente = nmPaciente;
	}

	public LocalDate getDataNascimentoPaciente() {
		return dataNascimentoPaciente;
	}

	public void setDataNascimentoPaciente(LocalDate dataNascimentoPaciente) {
		this.dataNascimentoPaciente = dataNascimentoPaciente;
	}

	public Long getCpfPaciente() {
		return cpfPaciente;
	}

	public void setCpfPaciente(Long cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}

	public Long getRgPaciente() {
		return rgPaciente;
	}

	public void setRgPaciente(Long rgPaciente) {
		this.rgPaciente = rgPaciente;
	}

	public String getEnderecoPaciente() {
		return enderecoPaciente;
	}

	public void setEnderecoPaciente(String enderecoPaciente) {
		this.enderecoPaciente = enderecoPaciente;
	}

	public Long getCepPaciente() {
		return cepPaciente;
	}

	public void setCepPaciente(Long cepPaciente) {
		this.cepPaciente = cepPaciente;
	}

	public String getEmailPaciente() {
		return emailPaciente;
	}

	public void setEmailPaciente(String emailPaciente) {
		this.emailPaciente = emailPaciente;
	}

	public Long getSenhaPaciente() {
		return senhaPaciente;
	}

	public void setSenhaPaciente(Long senhaPaciente) {
		this.senhaPaciente = senhaPaciente;
	}

	public Float getAlturaPaciente() {
		return alturaPaciente;
	}

	public void setAlturaPaciente(Float alturaPaciente) {
		this.alturaPaciente = alturaPaciente;
	}

	public Float getPesoPaciente() {
		return pesoPaciente;
	}

	public void setPesoPaciente(Float pesoPaciente) {
		this.pesoPaciente = pesoPaciente;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(nmPaciente, dataNascimentoPaciente, cpfPaciente, rgPaciente, enderecoPaciente, cepPaciente, emailPaciente, senhaPaciente, alturaPaciente, pesoPaciente, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Health other = (Health) obj;
		return Objects.equals(nmPaciente, other.nmPaciente) && Objects.equals(dataNascimentoPaciente, other.dataNascimentoPaciente)
				&& Objects.equals(cpfPaciente, other.cpfPaciente) && Objects.equals(rgPaciente, other.rgPaciente)
				&& Objects.equals(enderecoPaciente, other.enderecoPaciente) && Objects.equals(cepPaciente, other.cepPaciente)
				&& Objects.equals(emailPaciente, other.emailPaciente) && Objects.equals(senhaPaciente, other.senhaPaciente)
				&& Objects.equals(alturaPaciente, other.alturaPaciente) && Objects.equals(pesoPaciente, other.pesoPaciente)
				&& Objects.equals(id, other.id);
		
	}
	
	
	
	}

