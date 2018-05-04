package br.com.galdino.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuariosSystemTest {
	
	private FirefoxDriver driver;
    private UsuariosPage usuarios;

    @Before
    public void inicializa() {
    	//driver.get("http://localhost:8080/apenas-teste/limpa");
        this.driver = new FirefoxDriver();
        this.usuarios = new UsuariosPage(driver);
    }

    @Test
    public void deveAdicionarUmUsuario() {
        usuarios.visita();
        usuarios.novo().cadastra("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br");

        usuarios.visita();
        assertTrue(usuarios.existeNaListagem("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));
    }

    @After
    public void encerra() {
        driver.close();
    }
}
