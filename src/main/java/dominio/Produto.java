package dominio;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String codigo;
	private String descricao;
	private String um;
	private String grupo;
	private float preco;
	private Integer saldo;
	public Produto(String codigo, String descricao, String um, String grupo, float preco, Integer saldo,Integer id) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.um = um;
		this.grupo = grupo;
		this.preco = preco;
		this.saldo = saldo;
	}
	
	public Produto() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUm() {
		return um;
	}

	public void setUm(String um) {
		this.um = um;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
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
		Produto other = (Produto) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", um=" + um + ", grupo=" + grupo + ", preco="
				+ preco + ", saldo=" + saldo + "]";
	}
	
	

}
