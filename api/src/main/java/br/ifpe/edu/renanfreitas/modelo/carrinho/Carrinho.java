package br.ifpe.edu.renanfreitas.modelo.carrinho;
import java.util.ArrayList;
import java.util.List;

import br.ifpe.edu.renanfreitas.modelo.cliente.Cliente;
import br.ifpe.edu.renanfreitas.util.entity.EntidadeAuditavel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Carrinho")
public class Carrinho extends EntidadeAuditavel{

    @OneToOne
    @Column(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCarrinho> itens = new ArrayList<>();
}
