# JewellersInvoice
An android app that helps jewelers make invoices based on the current price of jewelry using an API to get the current price.

## Jewellery Invoices
Our app is designed to have six fragments. 
1. My Invoices
   * Shows a list of previously generated Invoices which are stored and queried from a Room Database.
   * Home page of the app
   * Can edit User's company information
   * Can start new Invoices
2. New Invoices
   * Has EditTexts to get User input about the User's customer
   * Can go to Invoice Items
3. Invoice Items
   * Has EditTexts to get User input about the customer's purchase items and pricing.
   * Can go to Applicable Tax
4. Applicable Tax
   * Has and EditText for Tax input
   * Can go to Invoice Visualizer
5. Invoice Visualizer
   * This is where a pdf would show the results the User entered.

6. Edit User Company
   * User can enter and edit details about their company as a Jewellery Store/Seller
