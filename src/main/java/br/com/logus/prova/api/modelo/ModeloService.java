package br.com.logus.prova.api.modelo;

import org.springframework.stereotype.Service;

@Service
public class ModeloService {

    private final ModeloRepository repository;

    public ModeloService(ModeloRepository repository) {
        this.repository = repository;
    }

    public Modelo buscarPorId(Integer id){
        return this.repository.findById(id).orElseThrow(() -> new IllegalStateException("Modelo não encontrado."));
    }
}
