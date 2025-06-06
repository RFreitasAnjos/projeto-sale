package br.ifpe.edu.renanfreitas.modelo.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    @Transactional
    public Cliente save(Cliente cliente){
        cliente.setHabilitado(Boolean.TRUE);
        return repository.save(cliente);
    }

    @Transactional
    public void update(Long id, Cliente clienteAlterado){
        Cliente cliente = repository.findById(id).get();
        cliente.setNome(clienteAlterado.getNome());
        cliente.setCpf(clienteAlterado.getCpf());
        cliente.setRg(clienteAlterado.getRg());
        cliente.setDataNascimento(clienteAlterado.getDataNascimento());
        cliente.setFoneCelular(clienteAlterado.getFoneCelular());

        repository.save(cliente);
    }

    @Transactional
    public void delete(Long id){
        Cliente cliente = repository.findById(id).get();
        cliente.setHabilitado(Boolean.FALSE);

        repository.save(cliente);
    }

    public List<Cliente> listarTodos(){ return repository.findAll(); }
    public Cliente obterPorId(Long id){ return repository.findById(id).get(); }
}
