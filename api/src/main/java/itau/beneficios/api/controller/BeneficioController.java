package itau.beneficios.api.controller;

import itau.beneficios.api.beneficio.Beneficio;
import itau.beneficios.api.beneficio.BeneficioRepository;
import itau.beneficios.api.beneficio.DadosAtualizarBeneficio;
import itau.beneficios.api.beneficio.DadosCadastroBeneficio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("beneficios")
public class BeneficioController {

    @Autowired
    private BeneficioRepository repository;

    @Transactional
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroBeneficio dados){
        repository.save(new Beneficio(dados));
    }

    @GetMapping
    public List<Beneficio> Listar(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Beneficio> ListarById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PutMapping
    @Transactional
    public void Atualizar(@RequestBody DadosAtualizarBeneficio dados){
        var beneficio = repository.getReferenceById(dados.id());
        beneficio.atualizarInformacoes(dados);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void Deletar(@PathVariable Long id){
        repository.deleteById(id);
    }
}
