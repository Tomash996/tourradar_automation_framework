Feature: SortAndFilter functionality

  @et_sortAndFilter
  Scenario: Verify sorting categories and results

    Given User opens Sorting Menu List
    And  Default sorting parameters are listed in Sorting Menu
    When User selects 'PRIVATE_TOUR_AVAILABLE' filter option
    Then User checks after applied 'TOTAL_PRICE_L' sorting option results are displayed correctly