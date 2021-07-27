package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListagemDeProdutoTela extends BaseTela {

    public ListagemDeProdutoTela(WebDriver app) {
        super(app);

    }

    public FormularioAdicaoProdutoTela abrirTelaAdicaoProduto() {
        app.findElement(By.id("com.lojinha:id/floatingActionButton")).click();
        return new FormularioAdicaoProdutoTela(app);
    }


}
