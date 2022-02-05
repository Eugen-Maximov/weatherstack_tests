Feature: Send GET request to weather from 1 cities

  Background:
    Given get API key for request

    # Example test
  @positive
  Scenario: Send request to current weather by 1 city
    Given request path is current
    * request city parameter is
      | Moscow |
    * request auth parameter ia added
    * send GET request
    When Current request get response body after sending GET request
    Then compare responses with expected result
    * responses bodies match

  @positive
  # The second example has three steps
  Scenario: Send request to current weather by 4 cities
    Given request path is current
    * request city parameter is
      | Moscow   |
      | New York |
      | Berlin   |
      | London   |
    * request auth parameter ia added
    * send GET requests
    When Current request get response body after sending GET request
    Then compare responses with expected result
    * responses bodies match