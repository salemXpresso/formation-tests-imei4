# language: en
Feature: IMC Calculator form

  @wip
  Scenario: In order to retrieve the user's IMC,
  I want to fill the form and get my IMC with its description
    Given A running platform

    When The user opens <https://www.calculersonimc.fr>
    Then The home page is displayed

    When The user clicks on "Calcul de l'IMC"
    Then The IMC form is displayed

    When The user selects <Homme> gender
    And The user fill the height box with <170>
    And The user fill the weight box with <65>
    And The user fill the age box with <20>
    And The user submits the form
    Then The IMC result box is displayed
    And The calculated IMC is <22.49>
    And The calculated IMC label is <Corpulence Normale>

    # Post requisites
    And The user closes his Web browser

  Scenario: In order to verify the robustness of the IMC form, I want to check that wrong values are taken into account
    Given A running platform

    When The user opens <https://www.calculersonimc.fr>
    Then The home page is displayed

    When The user clicks on "Calcul de l'IMC"
    Then The IMC form is displayed

    # Checks negative are not permitted by the form
    When The user selects <Homme> gender
    And The user fill the height box with <-170>
    And The user fill the weight box with <65>
    And The user fill the age box with <20>
    And The user submits the form
    Then The IMC result box is not displayed

    # Checks data inconsistency
    And The user fill the height box with <10>
    And The user submits the form
    Then The IMC result box is displayed
    And The result label says the data is inconsistent

    # Post requisites
    And The user closes his Web browser