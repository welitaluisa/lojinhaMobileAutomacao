package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class  LoginTela extends BaseTela {

    public LoginTela(WebDriver app) {
        super(app);

}


    public LoginTela prencherUsuario(String usuario) {

        app.findElement(By.id("com.lojinha:id/user")).click();
        app.findElement(By.id("com.lojinha:id/user")).findElement(By.id("com.lojinha:id/editText")).sendKeys(usuario);
        return this;

    }

    public LoginTela preencherSenha (String password){

        app.findElement(By.id("com.lojinha:id/password")).click();
        app.findElement(By.id("com.lojinha:id/password")).findElement(By.id("com.lojinha:id/editText")).sendKeys(password);
        return this;

    }

    public ListagemDeProdutoTela submeterLogin(){

        app.findElement(By.id("com.lojinha:id/loginButton")).click();

        return new ListagemDeProdutoTela(app);

    }



}
