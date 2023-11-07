@web
Feature: ClaroSteps

  @ClaroUS
  Scenario Outline: From Claro US go to MPLS page
    Given I go to page: "https://www.usclaro.com/" using <browser> browser
    When I click on Accept All Cookies
    And I hover the Solutions Header Section
    And I click on MPLS button
    Then I validate title of the page is "MPLS"
    Examples:
      | browser   |
      | "chrome"  |
      | "firefox" |
      | "edge"    |

  @ClaroUS
  Scenario Outline: Filling form contact us in Claro US
    Given I go to page: "https://www.usclaro.com/" using <browser> browser
    When I click on Accept All Cookies
    And I scroll to Contact US section
    When I load the user information:
      | firstName | lastName  | companyName                        | email                       | phoneNumber    | interestedIn |
      | "Mariana" | "Vasquez" | "CLARO ENTERPRISE SOLUTIONS, LLC." | "mariana.vasquez@claro.com" | "+52156411584" | "MPLS"       |
    And I check the By submitting my info checkbox
    Examples:
      | browser   |
      | "chrome"  |
      | "firefox" |
      | "edge"    |