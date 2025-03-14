Feature: Validate Left Navigation items for advisor user

  Background: this is for navigating Docuport login page
  @advisor
  Scenario: Validate Left nav
    Given user is on Docuport login page
    When user enters username and password for advisor
    When user click login button



