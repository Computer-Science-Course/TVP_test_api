package uea.api_test.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;

	@NotBlank(message="Nome é obrigatório")
	@Size(min=3, max=20, message="Nome deve ter tamanho de 3 e 20.")
	private String nome;
	
	@NotNull(message="Nome é obrigatório")
	private Boolean ativo;
	
	@Valid
	@Embedded
	private Endereco endereco;

	public Pessoa() {
	}

	public Pessoa(Integer codigo, String nome, Boolean ativo, Endereco endereco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.ativo = ativo;
		this.endereco = endereco;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ativo, codigo, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(ativo, other.ativo) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(nome, other.nome);
	}

}