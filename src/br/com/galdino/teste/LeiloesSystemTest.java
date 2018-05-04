package br.com.galdino.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LeiloesSystemTest {
	private FirefoxDriver driver;
    private LeiloesPage leiloes;

    @Before
    public void inicializa() {
    	//driver.get("http://localhost:8080/apenas-teste/limpa");
        this.driver = new FirefoxDriver();
        leiloes = new LeiloesPage(driver);

        UsuariosPage usuarios = new UsuariosPage(driver);
        usuarios.visita();
        usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");
    }
    @Test
    public void deveCadastrarUmLeilao() {

        leiloes.visita();
        NovoLeilaoPage novoLeilao = leiloes.novo();
        novoLeilao.preenche("Geladeira", 123, "Paulo Henrique", true);

        leiloes.visita();
        assertTrue(leiloes.existe("Geladeira", 123, "Paulo Henrique", true));

    }
    @After
    public void encerra() {
        driver.close();
    }

}
