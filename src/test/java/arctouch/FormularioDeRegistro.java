package arctouch;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page.FormularioDeRegistroPage;
import util.WebDriverArctouch;

import static util.FormularioRegistroInterface.*;
import static util.FormularioRegistroInterface.TEMP_USUARIO;

public class FormularioDeRegistro {
    private WebDriver webDriver;
    private FormularioDeRegistroPage formularioDeRegistroPage;

    public FormularioDeRegistro() {
        webDriver = new WebDriverArctouch().firefox();

    }

    @Given("^que o usuário acesse a \"([^\"]*)\"$")
    public void acessarUrl(String url) {
        webDriver.get(url);
        formularioDeRegistroPage = PageFactory.initElements(webDriver, FormularioDeRegistroPage.class);
    }

    @And("^informe o primeiro nome \"([^\"]*)\"$")
    public void informarPrimeiroNome(String firtName) {
        formularioDeRegistroPage.informarFirstName(firtName);
    }

    @And("^informe o último nome \"([^\"]*)\"$")
    public void informarUltimoNome(String lastName) {
        formularioDeRegistroPage.informarLastName(lastName);
    }

    @And("^selecione o seu estado civíl \"([^\"]*)\"$")
    public void informarEstadoCivil(String maritalStatus) {
        formularioDeRegistroPage.selecionarMaritalStatus(maritalStatus);
    }

    @And("^selecione o seu Hobby \"([^\"]*)\"$")
    public void selecionarHobby(String hobby) {
        formularioDeRegistroPage.selecionarHobby(hobby);
    }

    @And("^selecione sua Nacionalidade \"([^\"]*)\"$")
    public void selecionarNacionalidade(String country) {
        formularioDeRegistroPage.selecionarCountry(country);
    }

    @And("^selecione a data de nascimento \"([^\"]*)\"$")
    public void selecionarDataNascimento(String dateOfBirth) {
        formularioDeRegistroPage.selecionarDateOfBirth(dateOfBirth);
    }

    @And("^informe o número de telefone (\\d+)$")
    public void informarNumeroTelefone(int phoneNumber) {
        formularioDeRegistroPage.informarPhoneNumber(phoneNumber);
    }

    @And("^informe o nome do seu usuário \"([^\"]*)\"$")
    public void informarNomeUsuario(String userName) {
        formularioDeRegistroPage.informarUserName(TEMP_USUARIO + userName);
    }

    @And("^informe seu email \"([^\"]*)\"$")
    public void informarEmail(String email) {
        formularioDeRegistroPage.informarEmail(TEMP_USUARIO + email);
    }

    @And("^selecione sua foto do perfil \"([^\"]*)\"$")
    public void selecionarFotoPerfil(String yourProfilePicture) {
        formularioDeRegistroPage.selecionarYourProfilePicture(yourProfilePicture);
    }

    @And("^informe dados pessoais \"([^\"]*)\"$")
    public void informarDadosPessoais(String aboutYourself) {
        formularioDeRegistroPage.informarAboutYourself(aboutYourself);
    }

    @And("^informe a senha do seu usuário \"([^\"]*)\"$")
    public void informarSenhaUsuario(String password) {
        formularioDeRegistroPage.informarPassword(password);
    }

    @And("^informe novamente a senha do seu usuário \"([^\"]*)\"$")
    public void informarConfirmarSenha(String confirmPassword) {
        formularioDeRegistroPage.informarConfirmPassword(confirmPassword);
    }

    @When("^o usuário acionar Submit$")
    public void acionarSubmit() {
        formularioDeRegistroPage.acionarSubmit();
    }

    @Then("^a mensagem \"([^\"]*)\" é exibida na tela$")
    public void validarMensagemTela(String mensagem) {
        Assert.assertEquals(mensagem, formularioDeRegistroPage.mensagemTela());
        webDriver.close();
    }
}