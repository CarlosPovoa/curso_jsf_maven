package br.com.carlospovoa.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table (name = "endereco")
public class Endereco implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id                                         //Id da tabela
    @GeneratedValue                             //Gerado pelo BD auto-incremento
    @Column (name = "id", nullable = false)
    private Integer id;
    @Column (name = "bairro", nullable = false, length = 60)
    private String bairro;
    @Column (name = "cep", nullable = false, length = 9)
    private String cep;
    @Column (name = "complemento", length = 20)
    private String complemento;
    @Column (name = "nomelogradouro", nullable = false, length = 90)
    private String nomeLogradouro;
    @Column (name = "numero", nullable = false, length = 6)
    private String numero;
    
    //-------------------------------------------------------------------------------------//

    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "endereco_pessoa")
    @JoinColumn(name = "idpessoa", referencedColumnName = "id")
    private Pessoa pessoa;
   
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "endereco_tipoendereco")
    @JoinColumn(name = "idtipoendereco", referencedColumnName = "id")
    private TipoEndereco tipoEndereco;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "endereco_tipologradouro")
    @JoinColumn(name = "idtipologradouro", referencedColumnName = "id")
    private TipoLogradouro tipoLogradouro;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "endereco_cidade")
    @JoinColumn(name = "idcidade", referencedColumnName = "id")
    private Cidade cidade;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "endereco_estado")
    @JoinColumn(name = "idestado", referencedColumnName = "id")
    private Estado estado;

    //-------------------------------------------------------------------------------------//
    
    public Endereco() {
        this.pessoa = new Pessoa();
        this.tipoEndereco = new TipoEndereco();
        this.tipoLogradouro = new TipoLogradouro();
        this.cidade = new Cidade();
        this.estado = new Estado();
    }

    //-------------------------------------------------------------------------------------//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    
    //-------------------------------------------------------------------------------------//

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }


    
}
