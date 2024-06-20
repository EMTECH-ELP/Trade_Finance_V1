export interface InvoiceDiscounting {
    accountNumber: number
    cifId: string
    nationalId: number
    accountName: string
    currency: string
    email: string
    phoneNumber: number
    address: string
    city: string
    postalCode: number
    countryCode: number
    country: string
    // invoice details

    invoiceDate: Date
    invoiceNumber: string
    invoiceAmount: number
    applicantBusinessName: string
    applicantBusinessAddress: string
    dueDate: Date
    // invoices: number    //file upload
    // applicationForm: number       //file upload
    buyerName: string
    buyerBusinessName: string
    buyerCity: string
    buyerCountry: string
    countryName: string
    buyerAddress: string
    buyerEmailAddress: string
  
}
