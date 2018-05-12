package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class FormularioDeRegistroPage {

    @FindBy(id = "name_3_firstname")
    private WebElement firstName;

    @FindBy(id = "name_3_lastname")
    private WebElement lastName;

    @FindBy(name = "radio_4[]")
    private List<WebElement> maritalStatus;

    @FindBy(name = "checkbox_5[]")
    private List<WebElement> hobby;

    @FindBy(id = "dropdown_7")
    private WebElement country;

    @FindBy(id = "mm_date_8")
    private WebElement month;

    @FindBy(id = "dd_date_8")
    private WebElement day;

    @FindBy(id = "yy_date_8")
    private WebElement year;

    @FindBy(id = "phone_9")
    private WebElement phoneNumber;

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "email_1")
    private WebElement email;

    @FindBy(id = "profile_pic_10")
    private WebElement yourProfilePicture;

    @FindBy(id = "description")
    private WebElement aboutYourself;

    @FindBy(id = "password_2")
    private WebElement password;

    @FindBy(id = "confirm_password_password_2")
    private WebElement confirmPassword;

    @FindBy(name = "pie_submit")
    private WebElement submit;

    @FindBy(xpath = "//div[@class = 'entry-content']/p[@class='piereg_message' or @class='piereg_login_error']")
    private WebElement message;

    public void informarFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void informarLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void selecionarMaritalStatus(String maritalStatus) {
        for (WebElement webElement : this.maritalStatus) {
            if (webElement.getAttribute("value").equalsIgnoreCase(maritalStatus))
                webElement.click();
        }
    }

    public void selecionarHobby(String hobby) {
        String[] hobbyArray = hobby.split("/");
        HOBBY:
        for (String hobbies : hobbyArray) {
            for (WebElement webElement : this.hobby) {
                if (webElement.getAttribute("value").equalsIgnoreCase(hobbies)) {
                    webElement.click();
                    continue HOBBY;
                }
            }
        }
    }

    public void selecionarCountry(String country) {
        new Select(this.country).selectByValue(country);
    }

    public void selecionartMonth(Integer month) {
        new Select(this.month).selectByValue(month.toString());
    }

    public void selecionarDay(Integer day) {
        new Select(this.day).selectByValue(day.toString());
    }

    public void selecionarYear(Integer year) {
        new Select(this.year).selectByValue(year.toString());
    }

    public void informarPhoneNumber(Integer phoneNumber) {
        this.phoneNumber.sendKeys(phoneNumber.toString());
    }

    public void informarUserName(String userName) {
        this.userName.sendKeys(userName);
    }

    public void informarEmail(String email) {
        this.email.sendKeys(email);
    }

    public void selecionarYourProfilePicture(String yourProfilePicture) {
        this.yourProfilePicture.sendKeys(new File(yourProfilePicture).getAbsolutePath());
    }

    public void informarAboutYourself(String aboutYourself) {
        this.aboutYourself.sendKeys(aboutYourself);
    }

    public void informarPassword(String password) {
        this.password.sendKeys(password);
    }

    public void informarConfirmPassword(String confirmPassword) {
        this.confirmPassword.sendKeys(confirmPassword);
    }

    public void acionarSubmit() {
        this.submit.click();
    }

    public void selecionarDateOfBirth(String dateOfBirth) {
        String[] dateArray = dateOfBirth.split("/");
        selecionartMonth(Integer.valueOf(dateArray[1]));
        selecionarDay(Integer.valueOf(dateArray[0]));
        selecionarYear(Integer.valueOf(dateArray[2]));
    }

    public String mensagemTela() {
        return this.message.getText();
    }
}
