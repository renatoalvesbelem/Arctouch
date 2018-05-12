Feature: Formulário de Registro

  Scenario Outline: Cadastrar usuário com sucesso
    Given que o usuário acesse a "<pagina>"
    And informe o primeiro nome "<firstName>"
    And informe o último nome "<lastName>"
    And selecione o seu estado civíl "<maritalStatus>"
    And selecione o seu Hobby "<hobby>"
    And selecione sua Nacionalidade "<country>"
    And selecione a data de nascimento "<dateOfBirth>"
    And informe o número de telefone <phoneNumber>
    And informe o nome do seu usuário "<userName>"
    And informe seu email "<email>"
    And selecione sua foto do perfil "<yourProfilePicture>"
    And informe dados pessoais "<aboutYourself>"
    And informe a senha do seu usuário "<password>"
    And informe novamente a senha do seu usuário "<confirmPassword>"

    When o usuário acionar Submit

    Then a mensagem "<mensagem>" é exibida na tela

    Examples:

      | pagina                          | firstName | lastName | maritalStatus | hobby         | country | dateOfBirth | phoneNumber | userName | email             | yourProfilePicture | aboutYourself        | password      | confirmPassword | mensagem                        |
      | http://demoqa.com/registration/ | Renato    | Alves    | Single        | Dance/Reading | Brazil  | 2/3/1988    | 1234567890  | renato2  | renato2@gmail.com | foto/foto.jpg      | Texto a ser inserido | Xa-4814362624 | Xa-4814362624   | Thank you for your registration |

  Scenario Outline: Mensagem de erro ao informar usuário já cadatrado
    Given que o usuário acesse a "<pagina>"
    And informe o primeiro nome "<firstName>"
    And informe o último nome "<lastName>"
    And selecione o seu estado civíl "<maritalStatus>"
    And selecione o seu Hobby "<hobby>"
    And selecione sua Nacionalidade "<country>"
    And selecione a data de nascimento "<dateOfBirth>"
    And informe o número de telefone <phoneNumber>
    And informe o nome do seu usuário "<userName>"
    And informe seu email "<email>"
    And selecione sua foto do perfil "<yourProfilePicture>"
    And informe dados pessoais "<aboutYourself>"
    And informe a senha do seu usuário "<password>"
    And informe novamente a senha do seu usuário "<confirmPassword>"

    When o usuário acionar Submit

    Then a mensagem "<mensagem>" é exibida na tela

    Examples:

      | pagina                          | firstName | lastName | maritalStatus | hobby         | country | dateOfBirth | phoneNumber | userName | email             | yourProfilePicture | aboutYourself        | password      | confirmPassword | mensagem                       |
      | http://demoqa.com/registration/ | Renato    | Alves    | Single        | Dance/Reading | Brazil  | 2/3/1988    | 1234567890  | renato2  | renato2@gmail.com | foto/foto.jpg      | Texto a ser inserido | Xa-4814362624 | Xa-4814362624   | Error: Username already exists |