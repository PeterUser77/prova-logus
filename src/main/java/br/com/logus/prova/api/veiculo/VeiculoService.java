package br.com.logus.prova.api.veiculo;

import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public Veiculo buscarPorId(Integer id) {
        return this.repository.findById(id).orElseThrow(() -> new IllegalStateException("Veículo não encontrado."));
    }

    public Veiculo cadastrar(Veiculo veiculo){
        return this.repository.save(veiculo);
    }
}
