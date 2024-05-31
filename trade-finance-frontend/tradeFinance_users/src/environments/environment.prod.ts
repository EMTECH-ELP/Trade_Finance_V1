export const environment = {
  production: true,

  // Client's test servers

  //Emtech test server

  // Maker Authentication endpoints
  authUrl: "http://192.168.90.59:8082",
  resetUrl: "http://192.168.90.59:8082",
  OTPUrl: "http://192.168.90.59:8082",

  baseUrlAdmin: '...', 
  baseUrlHR: "http://52.15.152.26:6300",
  baseUrlProcurement: "http://52.15.152.26:9090",
  baseUrlBudget: "http://52.15.152.26:9090",
  baseUrlSupplierManagement: "http://52.15.152.26:9099",
  baseUrlFixedAssets: "http://52.15.152.26:9090",
  baseUrlPrepayments: "http://52.15.152.26:8099",
  baseUrlFinance: "http://52.15.152.26:8199",

  clientUrlHR: "http://52.15.152.26:6301/administration",
  selfServiceUrlHR: "http://52.15.152.26:6301/portal",



  // invoice discounting
 invUrl: 'http://192.168.90.44:9000' ,     //post invoice discounting forms. Createform url
 saveUrl: 'http://192.168.91.141:9000',     // save repayment details form
 getUrl: 'http://192.168.91.96:9000',              // Fetch forms

  //Localhost
};
