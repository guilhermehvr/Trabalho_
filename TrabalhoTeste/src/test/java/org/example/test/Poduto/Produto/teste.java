package org.example.test.Poduto.Produto;
import org.example.Produto;
import org.example.SistemaProdutos;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class teste {




    public static class SistemaProdutosTest<Produto> {
        private SistemaProdutos sistemaProdutos;

        @Before
        public void setUp() {
            sistemaProdutos = new SistemaProdutos();
        }

        @After
        public void tearDown() {
            sistemaProdutos = null;
        }

        @Test
        public void testCriarProduto() {
            sistemaProdutos.criarProduto("ProdutoTeste", "Descrição Teste", "Categoria Teste", 10.0, 20);
            Assert.assertEquals(1, sistemaProdutos.getProdutos().size());
        }

        @Test
        public void testExcluirProduto() {
            sistemaProdutos.criarProduto("ProdutoTeste", "Descrição Teste", "Categoria Teste", 10.0, 20);
            sistemaProdutos.excluirProduto();
            Assert.assertEquals(0, sistemaProdutos.getProdutos().size());
        }

        @Test
        public void testConsultarProduto() {
            sistemaProdutos.criarProduto("ProdutoTeste", "Descrição Teste", "Categoria Teste", 10.0, 20);
            Produto produto = null;
            SistemaProdutos.consultarProduto("ProdutoTeste");
            Assert.assertNotNull(produto);
        }

        @Test
        public void testEditarProduto() {
            sistemaProdutos.criarProduto("ProdutoTeste", "Descrição Teste", "Categoria Teste", 10.0, 20);
            sistemaProdutos.editarProduto("ProdutoTeste", "NovoNome", "Nova Descrição", "Nova Categoria", 15.0, 25);
            Produto produto = null;
            SistemaProdutos.consultarProduto("NovoNome");
            Assert.assertNotNull(produto);
            Assert.assertEquals("Nova Descrição", produto.getClass());
            Assert.assertEquals("Nova Categoria", produto.getClass());
            Assert.assertEquals(String.valueOf(15.0), new Class[]{produto.getClass()}, 0.001);
            Assert.assertEquals(25, produto.getClass());
        }

        @Test
        public void testEditarProdutoInexistente() {
            sistemaProdutos.criarProduto("ProdutoTeste", "Descrição Teste", "Categoria Teste", 10.0, 20);
            sistemaProdutos.editarProduto("ProdutoInexistente", "NovoNome", "Nova Descrição", "Nova Categoria", 15.0, 25);
            Produto produto = null;
            SistemaProdutos.consultarProduto("NovoNome");
            Assert.assertNull(produto);
        }
    }



}
