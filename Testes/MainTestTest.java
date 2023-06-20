package Testes;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class MainTestTest {

    @Test
    public void testListaDePessoasDoSexoFeminino() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Maria", "Feminino"));
        pessoas.add(new Pessoa("João", "Masculino"));
        pessoas.add(new Pessoa("Ana", "Feminino"));
        pessoas.add(new Pessoa("Carlos", "Masculino"));
        pessoas.add(new Pessoa("Patricia", "Feminino"));

        List<Pessoa> feminino = new ArrayList<>();
        pessoas.stream()
                .filter(p -> p.getSexo().equals("Feminino"))
                .forEach(feminino::add);

        // Verificar se apenas os nomes de mulheres estão presentes na lista 'feminino'
        for (Pessoa p : feminino) {
            Assert.assertEquals("Feminino", p.getSexo());
        }

        // Verificar se apenas os nomes de mulheres estão sendo exibidos
        String expectedOutput = "Nome: Maria, Sexo: Feminino\n"
                + "Nome: Ana, Sexo: Feminino\n"
                + "Nome: Patricia, Sexo: Feminino\n";
        StringBuilder actualOutput = new StringBuilder();
        for (Pessoa p : feminino) {
            actualOutput.append("Nome: ").append(p.getNome()).append(", Sexo: ").append(p.getSexo()).append("\n");
        }
        Assert.assertEquals(expectedOutput, actualOutput.toString());
    }

}