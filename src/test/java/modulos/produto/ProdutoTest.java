package modulos.produto;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import telas.LoginTela;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@DisplayName("Teste mobile do modulo de produto")
public class ProdutoTest {

    private WebDriver app;

    @BeforeEach

    public void beforeEach() throws MalformedURLException {
        // Abrir o App

        DesiredCapabilities capacidades = new DesiredCapabilities();
        capacidades.setCapability("deviceName", "Google Pixel");
        capacidades.setCapability("platform", "Android");
        capacidades.setCapability("udid", "192.168.168.105:5555");
        capacidades.setCapability("appPackage", "com.lojinha");
        capacidades.setCapability("appActivity", "com.lojinha.ui.MainActivity");
        capacidades.setCapability("app", "C:\\lojinha\\lojinha-nativa.apk");

        this.app = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidades);
        this.app.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @DisplayName("Validação do Valor do Produto não permitido")
    @Test

    public void testValidacaoDoValorDoProdutoNaoPermitido() {
        // Fazer Login
          String mensagemApresentada = new LoginTela(app)
                    .prencherUsuario("admin")
                    .preencherSenha("admin")
                    .submeterLogin()
                    .abrirTelaAdicaoProduto()
                    .preencherNomeProduto("Iphone")
                    .preencherValorProduto("700001")
                    .preencherCoresProduto("preto , branco")
                    .submissaoComEroo()
                    .obterMensagemErro();

        // Abrir formulario novo produto

        // Cadastrar um produtp com valor invalido

        // validar que a messagem de valor invalido foi apreentada

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

    }

    @AfterEach
    public void afterEach() {

        app.quit();


    }
}




