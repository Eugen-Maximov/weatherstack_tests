Feature: Check 4 errors

  @negative
  Scenario: Get 601 error
    Given request path is current
    * get API key for request
    * request city parameter is
      |  |
    * request auth parameter ia added
    * send GET request
    When Error request get response body after sending GET request
    Then create expected model by
      | code_601 |
    * responses bodies match

  @negative
  Scenario: Send request to current weather by 4 cities
    Given request path is current
    * request city parameter is
      |        |
      | qwerty |
      | Berlin |
      | London |
    * request auth parameter ia added
    * send GET requests
    When Current request get response body after sending GET request
    Then create expected models by
      | code_101 |
      | code_601 |
      | code_103 |
      | code_615 |
    * responses bodies match