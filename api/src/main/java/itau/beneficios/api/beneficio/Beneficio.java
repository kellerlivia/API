package itau.beneficios.api.beneficio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "beneficios")
@Entity(name = "Beneficio")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Beneficio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Conta conta;

    public Beneficio(DadosCadastroBeneficio dados) {
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.conta = dados.conta();
    }

    public void atualizarInformacoes(DadosAtualizarBeneficio dados) {
        if(dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if(dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if(dados.conta() != null) {
            this.conta = dados.conta();
        }
    }
}
