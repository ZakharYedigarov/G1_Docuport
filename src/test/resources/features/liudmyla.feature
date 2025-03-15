@validateitems
Feature: validate left navigate items of docuport for 3 user






  Scenario Outline: user validates items
    Given User login as "<Login>"
    Then validate "<items>"
    Examples:
      | Login      | items                                                                                               |
      | Advisor    | Home,Received docs,My uploads,Clients,Invitations,Users,Leads,Bookkeeping,1099 Form,Reconciliations |
      | Supervisor | Home,Received docs,My uploads,Clients,Users,Leads,Bookkeeping,1099 Form,Reconciliations             |
      | Employee   | Home,Received docs,My uploads,Clients,Users,Bookkeeping,1099 Form,Reconciliations                   |
      | Client     | Home,Received docs,My uploads,Invitations                                                           |