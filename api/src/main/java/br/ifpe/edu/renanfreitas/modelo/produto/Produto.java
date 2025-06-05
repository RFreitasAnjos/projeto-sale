package br.ifpe.edu.renanfreitas.modelo.produto;
import org.hibernate.annotations.SQLRestriction;

import br.ifpe.edu.renanfreitas.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Produto")
@SQLRestriction("habilitado = true")
public class Produto extends EntidadeAuditavel{
    
    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Double preco;
}
