Feature: create to do list
 create to do list

   Scenario Outline: create to do list
    Given user launch application
    And user validate loaded page
    When user add <item>
    Then user verify <item>
    
    Examples: 
      | item | 
      | good |
      | happy|
     
 