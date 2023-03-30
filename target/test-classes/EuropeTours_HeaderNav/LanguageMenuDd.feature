Feature: Language Menu dropdown

  @et_header_nav_language
  Scenario: Verify Language Menu dropdown options
    Given User checks that Language Menu btn is displayed
    And Default 'EN' language label is on the header
    When 'EN' language is displayed as selected in dropdown
    Then User open Language Menu dropdown
    And Default Language options are displayed in dropdown