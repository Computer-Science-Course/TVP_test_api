package uea.api_test.dto;

import java.util.Objects;

public class ResumoPessoaDto {

	private Long codigo;
	private String nome;
	private boolean ativo;
	private String endereco;

	public ResumoPessoaDto() {
	}

	public ResumoPessoaDto(Long codigo, String nome, Boolean ativo, String endereco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.ativo = ativo;
		this.endereco = endereco;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getString() {
		return endereco;
	}

	public void setString(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResumoPessoaDto other = (ResumoPessoaDto) obj;
		return Objects.equals(codigo, other.codigo);
	}

}