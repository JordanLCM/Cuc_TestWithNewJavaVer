Feature: Testing for site WL19
Description: Purpose of this feature is to test if user can access to the site

  @OpenSite
  Scenario: Open URL to site
    Given user opens "https://bo.the777888.com/"
    And user checks that site opened is "https://bo.the777888.com/"
    
  @BOLogin
  Scenario: Login to back office https://bo.the777888.com/
    When user opens site "https://bo.the777888.com/"
    Given user inputs username1 "jordan"
    And user inputs password1 "test123"
    And user inputs QR code "123456"
    Then user clicks on login button