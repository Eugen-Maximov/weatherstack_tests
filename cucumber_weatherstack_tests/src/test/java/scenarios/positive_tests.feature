Feature: Positive Tests

  Background:
    Given get API key for request

  #Example positive test
  @positive
  Scenario: Send request to current weather by 1 city
    Given request path is current
    * request city parameter is
      | Moscow |
    * request auth parameter ia added
    * send GET request
    When Current request get response body after sending GET request
    Then create expected model
    * responses bodies match

  #Get current weather by 4 cities
  @positive
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
    Then create expected models
    * responses bodies match