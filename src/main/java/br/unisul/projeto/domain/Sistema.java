package br.unisul.projeto.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.primefaces.model.UploadedFile;

@SuppressWarnings("serial")
@Entity
public class Sistema implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sis_id;
	
	@Column(length = 255)
	private String sis_arquivo;
	
	@Transient
	private String pathTemp;
	
	@Transient
	private UploadedFile file;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pathTemp == null) ? 0 : pathTemp.hashCode());
		result = prime * result + ((sis_arquivo == null) ? 0 : sis_arquivo.hashCode());
		result = prime * result + ((sis_id == null) ? 0 : sis_id.hashCode());
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
		Sistema other = (Sistema) obj;
		if (pathTemp == null) {
			if (other.pathTemp != null)
				return false;
		} else if (!pathTemp.equals(other.pathTemp))
			return false;
		if (sis_arquivo == null) {
			if (other.sis_arquivo != null)
				return false;
		} else if (!sis_arquivo.equals(other.sis_arquivo))
			return false;
		if (sis_id == null) {
			if (other.sis_id != null)
				return false;
		} else if (!sis_id.equals(other.sis_id))
			return false;
		return true;
	}

	public Long getSis_id() {
		return sis_id;
	}

	public void setSis_id(Long sis_id) {
		this.sis_id = sis_id;
	}

	public String getSis_arquivo() {
		return sis_arquivo;
	}

	public void setSis_arquivo(String sis_arquivo) {
		this.sis_arquivo = sis_arquivo;
	}

	public String getPathTemp() {
		return pathTemp;
	}

	public void setPathTemp(String pathTemp) {
		this.pathTemp = pathTemp;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
	
	

}
