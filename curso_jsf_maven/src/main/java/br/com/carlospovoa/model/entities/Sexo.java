package br.com.carlospovoa.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table (name = "sexo")
public class Sexo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column (name = "id", nullable = false)
    private Integer id;
    @Column (name = "descricao", unique = true, nullable = false, length = 10)
    private String descricao;
    
    //-------------------------------------------------------------------------------------//
    
    @OneToMany(mappedBy = "sexo", fetch = FetchType.LAZY, targetEntity = Pessoa.class)
    @ForeignKey(name = "pessoa_sexo") //usado para definir a foreignkey qdo exibi o erro, senao exibe numero aleatorios
    private List<Pessoa> pessoas;

    //-------------------------------------------------------------------------------------//
    
    public Sexo() {
    }
    
    //-------------------------------------------------------------------------------------//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    //-------------------------------------------------------------------------------------//

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Sexo other = (Sexo) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
