Feature: Person testing feature

    ## Scenario to Initialize a list of persons
    Scenario: Initializing a given list of persons
        Given Static method to Initialize a list of persons
        When I connect, I can see the size of the Initialized persons
        Then the list size is equal to 5

    ## Create a new person with random entries
    Scenario: Create a new person
        Given the list of persons contains 5 persons already stored
        When I create a new person with random entry
        Then I get the ID of the new person and the list contains more than 5 persons

    ## Person Bulk creation
    Scenario Outline: Person Bulk creation
        Given the list of persons contains 5 persons already stored
        When I create a new person with <FirstName>, <LastName>, and <Age>
        Then I get the ID of the new person and the list contains more than 5 persons

        Examples:
            | FirstName | LastName | Age |
            | Seif      | Tlijani  | 21  |
            | john      | Doe      | 30  |
            | mark      | Depon    | 40  |
            | Amina     | Slim     | 22  |
            | Mohamed   | Belhadj  | 21  |

    ## Updating an existing person
    Scenario Outline: Update a person by ID
        When The List of persons contains 5 persons already stored
        When I Update a person data with <ID>, <FirstName>, <LastName>, and <Age>
        Then I get the person updated

        Examples:
            | ID | FirstName | LastName  | Age |
            | 1  | Seif      | Tlijani1 | 22  |
            | 2  | john      | Doe1     | 23  |
            | 3  | mark      | Depon1   | 30  |
            | 4  | Amina     | Slim1    | 35  |
            | 5  | Mohamed   | Belhadj1 | 37  |

    ## Delete an existing person
    Scenario: Delete a given person
        Given a list of persons with predefined IDs and data
        When I delete a person with Id "1"
        Then the given person is deleted, and the list size is equal to "4"
