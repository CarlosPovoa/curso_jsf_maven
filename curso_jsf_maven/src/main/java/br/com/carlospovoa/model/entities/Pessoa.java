package br.com.carlospovoa.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table (name = "pessoa")
public class Pessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id                                         //Id da tabela
    @GeneratedValue                             //Gerado pelo BD auto-incremento
    @Column (name = "id", nullable = false)
    private Integer id;
    @Column (name = "nome", nullable = false, length = 80)
    private String nome;
    @Column (name = "email", length = 80)
    private String email;
    @Column (name = "telefone", length = 20)    //(999)99999-9999
    private String telefone;
    @Column (name = "cpf", length = 14)         //999.999.999-99
    private String cpf;
    @Column (name = "datanascimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    @Column (name = "datacadastro", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
    
    //-------------------------------------------------------------------------------------//
    
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, targetEntity = Endereco.class)
    @ForeignKey(name = "endereco_pessoa")
    private List<Endereco> enderecos;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "pessoa_sexo")
    @JoinColumn(name = "idsexo", referencedColumnName = "id")
    private Sexo sexo;

    //-------------------------------------------------------------------------------------//
    
    public Pessoa() {
        this.sexo = new Sexo();
    }

    //-------------------------------------------------------------------------------------//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
    //-------------------------------------------------------------------------------------//

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Pessoa other = (Pessoa) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
    
    
}
