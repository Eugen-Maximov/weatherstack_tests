Feature: Negative Tests

  Background:
    Given get API key for request

  #Missing query - 601 error
  @negative
  Scenario: Get 601 error
    Given request path is current
    * request auth parameter ia added
    * send GET request
    When Error request get response body after sending GET request
    Then create expected model by
      | code_601 |
    * responses bodies match

  #No auth token - 101 error
  @negative
  Scenario: Get 101 error
    Given request path is current
    * request city parameter is
      | Moscow |
    * send GET request
    When Error request get response body after sending GET request
    Then create expected model by
      | code_101 |
    * responses bodies match

  #Invalide path - 103 error
  @negative
  Scenario: Get 103 error
    Given request path is qwerty
    * request city parameter is
      | Moscow |
    * request auth parameter ia added
    * send GET request
    When Error request get response body after sending GET request
    Then create expected model by
      | code_103 |
    * responses bodies match


  #Requet failed - 615 error
  @negative
  Scenario: Get 615 error
    Given request path is current
    * request city parameter is
      | qwerty |
    * request auth parameter ia added
    * send GET request
    When Error request get response body after sending GET request
    Then create expected model by
      | code_615   |
    * responses bodies match