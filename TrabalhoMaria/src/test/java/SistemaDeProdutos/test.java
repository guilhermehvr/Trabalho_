package SistemaDeProdutos;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class SistemaDeProdutosTest {

    private final InputStream originalSystemIn = System.in;
    private ByteArrayInputStream simulatedInput;

    @Before
    public void setUp() {
        simulatedInput = new ByteArrayInputStream("1\nTestProduct\nTestDescription\nTestCategory\n10.99\n50\n3\nTestProduct\n2\nTestProduct\n0\n".getBytes());
        System.setIn(simulatedInput);
    }

    @After
    public void tearDown() {
        System.setIn(originalSystemIn);
    }

    @Test
    public void testAdicionarConsultarExcluirProduto() {
        SistemaDeProdutos.main(new String[]{});

        String expectedOutput = "Produto adicionado com sucesso!\n" +
                "\n===== Consultar Produto =====\n" +
                "Digite o nome do produto: \n" +
                "Detalhes do Produto:\n" +
                "Nome: TestProduct\n" +
                "Descrição: TestDescription\n" +
                "Categoria: TestCategory\n" +
                "Preço: 10.99\n" +
                "Quantidade em Estoque: 50\n" +
                "\n===== Excluir Produto =====\n" +
                "Digite o nome do produto a ser excluído: \n" +
                "Produto removido com sucesso!\n";

        assertEquals(expectedOutput, getSystemOut());
    }

    @Test
    public void testEditarProduto() {
        SistemaDeProdutos.main(new String[]{});

        String expectedOutput = "Produto adicionado com sucesso!\n" +
                "\n===== Editar Produto =====\n" +
                "Digite o nome do produto a ser editado: \n" +
                "Detalhes do Produto:\n" +
                "Nome: TestProduct\n" +
                "Descrição: TestDescription\n" +
                "Categoria: TestCategory\n" +
                "Preço: 10.99\n" +
                "Quantidade em Estoque: 50\n" +
                "Novo Nome: \n" +
                "Nova Descrição: \n" +
                "Nova Categoria: \n" +
                "Novo Preço: \n" +
                "Nova Quantidade em Estoque: \n" +
                "Produto editado com sucesso!\n";

        assertEquals(expectedOutput, getSystemOut());
    }

    @Test
    public void testSairDoSistema() {
        SistemaDeProdutos.main(new String[]{});

        String expectedOutput = "Saindo do sistema. Até logo!\n";

        assertEquals(expectedOutput, getSystemOut());
    }

    private String getSystemOut() {
        System.out.flush();
        System.setOut(originalSystemIn);
        return simulatedInput.toString();
    }
}

//Estou tendo erros onde está escrito "SistemaDeProdutos", segundo o chat  provavelmente está relacionado
// à tentativa de chamar o método main diretamente na classe SistemaDeProdutos como resolver?