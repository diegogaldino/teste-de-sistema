package br.com.galdino.teste;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LanceSystemTest {
	private FirefoxDriver driver;
	private LeiloesPage leiloes;

	@Before
	public void inicializa() {
		this.driver = new FirefoxDriver();

		// driver.get("http://localhost:8080/apenas-teste/limpa");

		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");
		usuarios.visita();
		usuarios.novo().cadastra("Jos� Alberto", "jose@alberto.com");

		leiloes = new LeiloesPage(driver);
		leiloes.visita();
		leiloes.novo().preenche("Geladeira", 100, "Paulo Henrique", false);
		leiloes.visita();
	}

	@Test
	public void deveFazerUmLance() {

		DetalhesDoLeilaoPage lances = leiloes.detalhes(1);

		lances.lance("Jos� Alberto", 150);

		assertTrue(lances.existeLance("Jos� Alberto", 150));
	}
}
