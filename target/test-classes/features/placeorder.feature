Feature: Placeorder

Scenario Outline: Placing the order successfully 
Given the user is on login page
When the user enter username as "<Username>" and password as "<Password>" and click login button
And the user selelcts product
And the user click add to cart button
And the user click cart icon
And the user click add to checkout button
And the user customer information anf click continue button
And the user verifies the product and click finish button
And the user click logout button

Examples:
|Username|Password|
|standard_user|secret_sauce|