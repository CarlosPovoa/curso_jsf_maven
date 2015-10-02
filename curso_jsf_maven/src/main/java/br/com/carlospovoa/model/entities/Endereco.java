package br.com.carlospovoa.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table (name = "endereco")
public class Endereco implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id                                         //Id da tabela
    @GeneratedValue                             //Gerado pelo BD auto-incremento
    @Column (name = "IdEndereco", nullable = false)
    private Integer idEndereco;
    @Column (name = "Bairro", nullable = false, length = 60)
    private String bairro;
    @Column (name = "Cep", nullable = false, length = 9)
    private String cep;
    @Column (name = "Complemento", length = 20)
    private String complemento;
    @Column (name = "NomeLogradouro", nullable = false, length = 90)
    private String nomeLogradouro;
    @Column (name = "Numero", nullable = false, length = 6)
    private String numero;
    
    @ManyToOne(optional = false)
    @ForeignKey(name = "EnderecoCidade")
    private Cidade cidade;

    @ManyToOne(optional = false)
    @ForeignKey(name = "EnderecoEstado")
    private Estado estado;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.idEndereco != null ? this.idEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        if (this.idEndereco != other.idEndereco && (this.idEndereco == null || !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        return true;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    @ManyToOne(optional = false)
    @ForeignKey(name = "EnderecoPessoa")
    private Pessoa pessoa;

    @ManyToOne(optional = false)
    @ForeignKey(name = "EnderecoTipoEndereco")
    private TipoEndereco tipoEndereco;

    @ManyToOne(optional = false)
    @ForeignKey(name = "EnderecoTipoLogradouro")
    private TipoLogradouro tipoLogradouro;
  
    
    public Endereco() {
    }

    
    
}
