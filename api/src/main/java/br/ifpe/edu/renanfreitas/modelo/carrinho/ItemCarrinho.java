package br.ifpe.edu.renanfreitas.modelo.carrinho;

import br.ifpe.edu.renanfreitas.modelo.produto.Produto;
import br.ifpe.edu.renanfreitas.util.entity.EntidadeAuditavel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ItemCarrinho extends EntidadeAuditavel{

    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    private Carrinho carrinho;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private Integer quantidade;
}
